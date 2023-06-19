package ml.volder.unikapi.api.draw.impl;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import ml.volder.unikapi.NotSupportedException;
import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.api.draw.DrawAPI;
import ml.volder.unikapi.api.minecraft.MinecraftAPI;
import ml.volder.unikapi.types.Material;
import ml.volder.unikapi.types.ResourceLocation;
import net.labymod.core.LabyModCore;
import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.registry.Registry;
import org.lwjgl.opengl.GL11;

import java.awt.*;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.16.*")
public class Laby3DrawAPI_v1_16_5 implements DrawAPI {

    private static Laby3DrawAPI_v1_16_5 instance;

    public static Laby3DrawAPI_v1_16_5 getAPI() {
        if(instance == null)
            instance = new Laby3DrawAPI_v1_16_5();
        return instance;
    }

    private static MatrixStack savedRenderStack;
    public static void updateRenderStack(MatrixStack stack) {
        savedRenderStack = CURRENT_RENDERSTACK;
        CURRENT_RENDERSTACK = stack;
    }

    public static void restoreRenderStack() {
        CURRENT_RENDERSTACK = savedRenderStack;
        savedRenderStack = null;
    }

    public static MatrixStack CURRENT_RENDERSTACK;
    public static MatrixStack getRenderStack() {
        return CURRENT_RENDERSTACK;
    }

    //region Other stuff
    @Override
    public int getScaledWidth() {
        return LabyMod.getInstance().getDrawUtils().getScaledResolution().getScaledWidth();
    }

    @Override
    public int getScaledHeight() {
        return LabyMod.getInstance().getDrawUtils().getScaledResolution().getScaledHeight();
    }

    @Override
    public int getTextureWidth() {
        return GL11.glGetTexLevelParameteri(GL11.GL_TEXTURE_2D,0, GL11.GL_TEXTURE_WIDTH);
    }

    @Override
    public int getTextureHeight() {
        return GL11.glGetTexLevelParameteri(GL11.GL_TEXTURE_2D,0, GL11.GL_TEXTURE_HEIGHT);
    }
    //endregion

    //region Texture related

    @Override
    public void drawTexturedModalRect(double x, double y, double textureX, double textureY, double width, double height) {
        LabyMod.getInstance().getDrawUtils().drawTexturedModalRect(getRenderStack(), x, y, textureX, textureY, width, height);
    }

    @Override
    public void drawTexturedModalRect(double left, double top, double right, double bottom) {
        drawTexturedModalRect(left, top, 0, 0, right - left, bottom - top);
    }

    @Override
    public void drawTexture(double x, double y, double texturePosX, double texturePosY, double imageWidth, double imageHeight, double maxWidth, double maxHeight, float alpha) {
        LabyMod.getInstance().getDrawUtils().drawTexture(getRenderStack(), x, y, texturePosX, texturePosY, imageWidth, imageHeight, maxWidth, maxHeight, alpha);
    }

    @Override
    public void drawTexture(double x, double y, double texturePosX, double texturePosY, double imageWidth, double imageHeight, double maxWidth, double maxHeight) {
        drawTexture(x, y, texturePosX, texturePosY, imageWidth, imageHeight, maxWidth, maxHeight, 1F);
    }

    @Override
    public void drawTexture(double x, double y, double imageWidth, double imageHeight, double maxWidth, double maxHeight, float alpha) {
        drawTexture(x, y, 0, 0, imageWidth, imageHeight, maxWidth, maxHeight, alpha);
    }

    @Override
    public void drawTexture(double x, double y, double imageWidth, double imageHeight, double maxWidth, double maxHeight) {
        drawTexture(x, y, imageWidth, imageHeight, maxWidth, maxHeight, 1F);
    }

    @Override
    public void bindTexture(ResourceLocation resourceLocation) {
        //TODO change to unikapi namespace
        Minecraft.getInstance().getTextureManager().bindTexture(new net.minecraft.util.ResourceLocation(/*resourceLocation.getResourceDomain()*/ "minecraft", resourceLocation.getResourcePath()));
    }

    //endregion

    //region String related
    @Override
    public String trimStringToWidth(String text, int width) {
        return trimStringToWidth(text, width, false);
    }

    @Override
    public String trimStringToWidth(String text, int width, boolean reverse) {
        StringBuilder builder = new StringBuilder();
        float fullWidth = 0.0F;
        int position = reverse ? text.length() - 1 : 0;
        int delta = reverse ? -1 : 1;
        boolean currentParagraph = false;
        boolean currentBold = false;

        for(int i = position; i >= 0 && i < text.length() && fullWidth < width; i += delta) {
            char c = text.charAt(i);
            float charWidth = this.getStringWidth(String.valueOf(c));
            if (currentParagraph) {
                currentParagraph = false;
                if (c != 'l' && c != 'L') {
                    if (c == 'r' || c == 'R') {
                        currentBold = false;
                    }
                } else {
                    currentBold = true;
                }
            } else if (charWidth < 0.0F) {
                currentParagraph = true;
            } else {
                fullWidth += charWidth;
                if (currentBold || false) {
                    ++fullWidth;
                }
            }

            if (fullWidth > width) {
                break;
            }

            if (reverse) {
                builder.insert(0, c);
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    @Override
    public int getFontHeight() {
        return getFontRenderer().FONT_HEIGHT;
    }

    @Override
    public int getStringWidth(String text) {
        return getFontRenderer().getStringWidth(text);
    }

    @Override
    public void renderString(String text, float x, float y, boolean shadow, boolean centered, float scale, int color) {
        GL11.glPushMatrix();
        GL11.glScaled(scale, scale, 1F);
        if(shadow)
            getFontRenderer().drawStringWithShadow(getRenderStack(), text, (x - (centered ? getStringWidth(text)*scale / 2 : 0)) / scale, y / scale, color);
        else
            getFontRenderer().drawString(getRenderStack(), text, (x - (centered ? getStringWidth(text)*scale / 2 : 0)) / scale, y / scale, color);
        GL11.glPopMatrix();
    }

    private FontRenderer getFontRenderer() {
        return LabyModCore.getMinecraft().getFontRenderer();
    }

    //endregion

    //region Rectangle related
    @Override
    public void drawRect(double left, double top, double right, double bottom, int color) {
        LabyMod.getInstance().getDrawUtils().drawRect(getRenderStack(), left, top, right, bottom, color);
    }

    @Override
    public void drawGradientRect(int left, int top, int right, int bottom, Color startColor, Color endColor) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();
        int i1 = 4;
        Matrix4f matrix = getRenderStack().getLast().getMatrix();
        RenderSystem.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFuncSeparate(770, 771, 0, 1);
        GlStateManager.disableAlphaTest();
        GlStateManager.shadeModel(7425);
        GlStateManager.disableTexture();
        buffer.begin(7, DefaultVertexFormats.POSITION_COLOR);
        buffer.pos(matrix, right, top, 0.0F).color(startColor.getRed(), startColor.getGreen(), startColor.getBlue(), startColor.getAlpha()).endVertex();
        buffer.pos(matrix, left, top, 0.0F).color(startColor.getRed(), startColor.getGreen(), startColor.getBlue(), startColor.getAlpha()).endVertex();
        buffer.pos(matrix, left, bottom, 0.0F).color(endColor.getRed(), endColor.getGreen(), endColor.getBlue(), endColor.getAlpha()).endVertex();
        buffer.pos(matrix, right, bottom, 0.0F).color(endColor.getRed(), endColor.getGreen(), endColor.getBlue(), endColor.getAlpha()).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel(7424);
        GlStateManager.enableAlphaTest();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture();
        RenderSystem.popMatrix();

    }
    //endregion

    //region Background related
    @Override
    public void drawBackground(int tint, double scrolling, int brightness) {
        LabyMod.getInstance().getDrawUtils().drawBackground(getRenderStack(), tint, scrolling, brightness);
    }

    @Override
    public void drawDimmedOverlayBackground(int left, int top, int right, int bottom) {
        LabyMod.getInstance().getDrawUtils().drawDimmedOverlayBackground(left, top, right, bottom);
    }

    @Override
    public void drawOverlayBackground(int startY, int endY) {
        LabyMod.getInstance().getDrawUtils().drawOverlayBackground(getRenderStack(), startY, endY);
    }
    //endregion

    //region Item related
    @Override
    public void renderItemIntoGUI(Material material, int itemDamage, double x, double y, double scale) {
        Item item = Registry.ITEM.getOptional(new net.minecraft.util.ResourceLocation(material.getNamespace(), material.getPath(MinecraftAPI.getAPI().isLegacy()))).orElse(Items.BARRIER);
        ItemStack itemStack = new ItemStack(item);
        itemStack.setDamage(itemDamage);
        RenderSystem.pushMatrix();
        RenderSystem.scaled(scale, scale, 1F);
        LabyMod.getInstance().getDrawUtils().drawItem(itemStack, x / scale, y / scale, "");
        RenderSystem.popMatrix();
    }
    //endregion
}
