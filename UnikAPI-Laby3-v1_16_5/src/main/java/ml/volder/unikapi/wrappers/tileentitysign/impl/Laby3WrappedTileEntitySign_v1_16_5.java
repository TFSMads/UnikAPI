package ml.volder.unikapi.wrappers.tileentitysign.impl;

import ml.volder.unikapi.wrappers.tileentitysign.WrappedTileEntitySign;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.network.play.client.CUpdateSignPacket;
import net.minecraft.tileentity.SignTileEntity;

public class Laby3WrappedTileEntitySign_v1_16_5 extends WrappedTileEntitySign {

    private String[] signLines = new String[4];

    private SignTileEntity tileEntitySign;

    public Laby3WrappedTileEntitySign_v1_16_5(SignTileEntity tileEntitySign) {
        this.tileEntitySign = tileEntitySign;
    }

    @Override
    public void setEditable(boolean isEditable) {
        tileEntitySign.setEditable(isEditable);
    }

    @Override
    public void sendUpdatePacket() {
        ClientPlayNetHandler lvt_1_1_ = Minecraft.getInstance().getConnection();
        if (lvt_1_1_ != null) {
            lvt_1_1_.sendPacket(new CUpdateSignPacket(this.tileEntitySign.getPos(), signLines[0], signLines[1], signLines[2], signLines[3]));
        }
    }

    @Override
    public void markDirty() {
        tileEntitySign.markDirty();
    }

    @Override
    public String getLine(int selected) {
        return signLines.length >= selected + 1 ? signLines[selected] : null;
    }

    @Override
    public void setLine(int selected, String value) {
        if(signLines.length < selected + 1)
            return;
        signLines[selected] = value;
    }
}
