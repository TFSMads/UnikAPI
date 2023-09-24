package ml.volder.unikapi.api.draw.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.api.draw.DrawAPI;
import ml.volder.unikapi.api.minecraft.MinecraftAPI;
import ml.volder.unikapi.types.Material;
import ml.volder.unikapi.types.ResourceLocation;
import net.labymod.core.LabyModCore;
import net.labymod.core.WorldRendererAdapter;
import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import java.awt.*;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.8.*")
public class Laby3DrawAPI_v1_8_9 implements DrawAPI {

    private static Laby3DrawAPI_v1_8_9 instance;

    public static Laby3DrawAPI_v1_8_9 getAPI() {
        if(instance == null)
            instance = new Laby3DrawAPI_v1_8_9();
        return instance;
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
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRendererAdapter worldrenderer = LabyModCore.getWorldRenderer();
        GlStateManager.color(1F, 1F, 1F);
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos((double)(x + 0), (double)(y + height), 0).tex((double)((float)(textureX + 0) * f), (double)((float)(textureY + height) * f1)).endVertex();
        worldrenderer.pos((double)(x + width), (double)(y + height), 0).tex((double)((float)(textureX + width) * f), (double)((float)(textureY + height) * f1)).endVertex();
        worldrenderer.pos((double)(x + width), (double)(y + 0), 0).tex((double)((float)(textureX + width) * f), (double)((float)(textureY + 0) * f1)).endVertex();
        worldrenderer.pos((double)(x + 0), (double)(y + 0), 0).tex((double)((float)(textureX + 0) * f), (double)((float)(textureY + 0) * f1)).endVertex();
        tessellator.draw();
    }

    @Override
    public void drawTexturedModalRect(double left, double top, double right, double bottom) {
        drawTexturedModalRect(left, top, 0, 0, right - left, bottom - top);
    }

    @Override
    public void drawTexture(double x, double y, double texturePosX, double texturePosY, double imageWidth, double imageHeight, double maxWidth, double maxHeight, float alpha) {
        GL11.glPushMatrix();
        double sizeWidth = maxWidth / imageWidth;
        double sizeHeight = maxHeight / imageHeight;
        GL11.glScaled(sizeWidth, sizeHeight, 0.0D);
        if (alpha <= 1.0F) {
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.color(1.0F, 1.0F, 1.0F, alpha);
        }

        this.drawUVTexture(x / sizeWidth, y / sizeHeight, texturePosX, texturePosY, x / sizeWidth + imageWidth - x / sizeWidth, y / sizeHeight + imageHeight - y / sizeHeight);
        if (alpha <= 1.0F) {
            GlStateManager.disableAlpha();
            GlStateManager.disableBlend();
        }

        GL11.glPopMatrix();
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
        Minecraft.getMinecraft().getTextureManager().bindTexture(new net.minecraft.util.ResourceLocation(/*resourceLocation.getResourceDomain()*/ "minecraft", resourceLocation.getResourcePath()));
    }

    private void drawUVTexture(double x, double y, double textureX, double textureY, double width, double height) {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRendererAdapter worldrenderer = LabyModCore.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos(x + 0.0D, y + height, 0).tex((double)((float)(textureX + 0.0D) * f), (double)((float)(textureY + height) * f1)).endVertex();
        worldrenderer.pos(x + width, y + height, 0).tex((double)((float)(textureX + width) * f), (double)((float)(textureY + height) * f1)).endVertex();
        worldrenderer.pos(x + width, y + 0.0D, 0).tex((double)((float)(textureX + width) * f), (double)((float)(textureY + 0.0D) * f1)).endVertex();
        worldrenderer.pos(x + 0.0D, y + 0.0D, 0).tex((double)((float)(textureX + 0.0D) * f), (double)((float)(textureY + 0.0D) * f1)).endVertex();
        tessellator.draw();
    }
    //endregion

    //region String related
    @Override
    public String trimStringToWidth(String text, int width) {
        return trimStringToWidth(text, width, false);
    }

    @Override
    public String trimStringToWidth(String text, int width, boolean reverse) {
        return getFontRenderer().trimStringToWidth(text, width, reverse);
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
        getFontRenderer().drawString(text, (x - (centered ? getStringWidth(text)*scale / 2 : 0)) / scale, y / scale, color, shadow);
        GL11.glPopMatrix();
    }

    private FontRenderer getFontRenderer() {
        return LabyModCore.getMinecraft().getFontRenderer();
    }
    //endregion

    //region Rectangle related
    @Override
    public void drawRect(double left, double top, double right, double bottom, int color) {
        double j;
        if (left < right) {
            j = left;
            left = right;
            right = j;
        }

        if (top < bottom) {
            j = top;
            top = bottom;
            bottom = j;
        }

        float f3 = (float)(color >> 24 & 255) / 255.0F;
        float f = (float)(color >> 16 & 255) / 255.0F;
        float f1 = (float)(color >> 8 & 255) / 255.0F;
        float f2 = (float)(color & 255) / 255.0F;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRendererAdapter worldrenderer = LabyModCore.getWorldRenderer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(f, f1, f2, f3);
        worldrenderer.begin(7, DefaultVertexFormats.POSITION);
        worldrenderer.pos(left, bottom, 0.0D).endVertex();
        worldrenderer.pos(right, bottom, 0.0D).endVertex();
        worldrenderer.pos(right, top, 0.0D).endVertex();
        worldrenderer.pos(left, top, 0.0D).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    @Override
    public void drawGradientRect(int left, int top, int right, int bottom, Color startColor, Color endColor) {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRendererAdapter worldrenderer = LabyModCore.getWorldRenderer();
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.shadeModel(7425);
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
        worldrenderer.pos(right, top, 0.0D).color(startColor.getRed(), startColor.getGreen(), startColor.getBlue(), startColor.getAlpha()).endVertex();
        worldrenderer.pos(left, top, 0.0D).color(startColor.getRed(), startColor.getGreen(), startColor.getBlue(), startColor.getAlpha()).endVertex();
        worldrenderer.pos(left, bottom, 0.0D).color(endColor.getRed(), endColor.getGreen(), endColor.getBlue(), endColor.getAlpha()).endVertex();
        worldrenderer.pos(right, bottom, 0.0D).color(endColor.getRed(), endColor.getGreen(), endColor.getBlue(), endColor.getAlpha()).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();

    }
    //endregion

    //region Background related
    @Override
    public void drawBackground(int tint, double scrolling, int brightness) {
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        Tessellator tessellator = Tessellator.getInstance();
        WorldRendererAdapter worldrenderer = LabyModCore.getWorldRenderer();
        Minecraft.getMinecraft().getTextureManager().bindTexture(LabyModCore.getRenderImplementation().getOptionsBackground());
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        worldrenderer.pos(0.0D, (double)this.getScaledHeight(), 0.0D).tex(0.0D, ((double)this.getScaledHeight() + scrolling) / 32.0D + (double)tint).color(brightness, brightness, brightness, 255).endVertex();
        worldrenderer.pos((double)this.getScaledWidth(), (double)this.getScaledHeight(), 0.0D).tex((double)((float)this.getScaledWidth() / 32.0F), ((double)this.getScaledHeight() + scrolling) / 32.0D + (double)tint).color(brightness, brightness, brightness, 255).endVertex();
        worldrenderer.pos((double)this.getScaledWidth(), 0.0D, 0.0D).tex((double)((float)this.getScaledWidth() / 32.0F), (double)tint + scrolling / 32.0D).color(brightness, brightness, brightness, 255).endVertex();
        worldrenderer.pos(0.0D, 0.0D, 0.0D).tex(0.0D, (double)tint + scrolling / 32.0D).color(brightness, brightness, brightness, 255).endVertex();
        tessellator.draw();
    }

    @Override
    public void drawDimmedOverlayBackground(int left, int top, int right, int bottom) {
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        Tessellator tessellator = Tessellator.getInstance();
        WorldRendererAdapter worldrenderer = LabyModCore.getWorldRenderer();
        Minecraft.getMinecraft().getTextureManager().bindTexture(LabyModCore.getRenderImplementation().getOptionsBackground());
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        float f = 32.0F;
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        worldrenderer.pos((double)left, (double)bottom, 0.0D).tex((double)((float)left / f), (double)((float)bottom / f)).color(32, 32, 32, 255).endVertex();
        worldrenderer.pos((double)right, (double)bottom, 0.0D).tex((double)((float)right / f), (double)((float)bottom / f)).color(32, 32, 32, 255).endVertex();
        worldrenderer.pos((double)right, (double)top, 0.0D).tex((double)((float)right / f), (double)((float)top / f)).color(32, 32, 32, 255).endVertex();
        worldrenderer.pos((double)left, (double)top, 0.0D).tex((double)((float)left / f), (double)((float)top / f)).color(32, 32, 32, 255).endVertex();
        tessellator.draw();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 0, 1);
        GlStateManager.disableAlpha();
        GlStateManager.shadeModel(7425);
        GlStateManager.disableDepth();
    }

    @Override
    public void drawOverlayBackground(int startY, int endY) {
        int endAlpha = 255;
        int startAlpha = 255;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRendererAdapter worldrenderer = LabyModCore.getWorldRenderer();
        Minecraft.getMinecraft().getTextureManager().bindTexture(LabyModCore.getRenderImplementation().getOptionsBackground());
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        worldrenderer.pos(0.0D, endY, 0.0D)
                .tex(0.0D, (float)endY / 32.0F)
                .color(64, 64, 64, endAlpha)
                .endVertex();
        worldrenderer.pos(this.getScaledWidth(), endY, 0.0D).tex((float)this.getScaledWidth() / 32.0F, (float)endY / 32.0F).color(64, 64, 64, endAlpha).endVertex();
        worldrenderer.pos(this.getScaledWidth(), startY, 0.0D).tex((float)this.getScaledWidth() / 32.0F, (float)startY / 32.0F).color(64, 64, 64, startAlpha).endVertex();
        worldrenderer.pos(0.0D, startY, 0.0D).tex(0.0D, (float)startY / 32.0F).color(64, 64, 64, startAlpha).endVertex();
        tessellator.draw();
    }
    //endregion

    //region Item related
    @Override
    public void renderItemIntoGUI(Material material, int itemDamage, double x, double y, double scale) {
        Item item = Item.itemRegistry.getObject(new net.minecraft.util.ResourceLocation(material.getNamespace(), material.getPath(MinecraftAPI.getAPI().isLegacy())));
        ItemStack itemStack = new ItemStack(item, 1, itemDamage);
        GL11.glPushMatrix();
        GlStateManager.scale(scale, scale, 1F);
        LabyMod.getInstance().getDrawUtils().drawItem(itemStack, x / scale, y / scale, "");
        GL11.glPopMatrix();
    }
    //endregion
}
