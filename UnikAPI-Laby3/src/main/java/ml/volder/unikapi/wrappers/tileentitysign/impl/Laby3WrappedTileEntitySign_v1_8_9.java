package ml.volder.unikapi.wrappers.tileentitysign.impl;

import ml.volder.unikapi.wrappers.tileentitysign.WrappedTileEntitySign;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.play.client.C12PacketUpdateSign;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.ChatComponentText;

public class Laby3WrappedTileEntitySign_v1_8_9 extends WrappedTileEntitySign {

    private TileEntitySign tileEntitySign;

    public Laby3WrappedTileEntitySign_v1_8_9(TileEntitySign tileEntitySign) {
        this.tileEntitySign = tileEntitySign;
    }

    @Override
    public void setEditable(boolean isEditable) {
        tileEntitySign.setEditable(isEditable);
    }

    @Override
    public void sendUpdatePacket() {
        NetHandlerPlayClient nethandlerplayclient = Minecraft.getMinecraft().getNetHandler();

        if (nethandlerplayclient != null) {
            nethandlerplayclient.addToSendQueue(new C12PacketUpdateSign(tileEntitySign.getPos(), tileEntitySign.signText));
        }
    }

    @Override
    public void markDirty() {
        tileEntitySign.markDirty();
    }

    @Override
    public String getLine(int selected) {
        return tileEntitySign.signText.length >= selected + 1 ? tileEntitySign.signText[selected].getUnformattedText() : null;
    }

    @Override
    public void setLine(int selected, String value) {
        if(tileEntitySign.signText.length < selected + 1)
            return;
        tileEntitySign.signText[selected] = new ChatComponentText(value);
    }
}
