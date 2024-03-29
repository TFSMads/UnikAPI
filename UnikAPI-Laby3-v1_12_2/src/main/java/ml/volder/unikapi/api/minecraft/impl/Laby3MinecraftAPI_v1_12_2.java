package ml.volder.unikapi.api.minecraft.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.api.minecraft.MinecraftAPI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.resources.I18n;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.util.ChatAllowedCharacters;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.12.*")
public class Laby3MinecraftAPI_v1_12_2 implements MinecraftAPI {


    private static Laby3MinecraftAPI_v1_12_2 instance;

    @Override
    public boolean isInGame() {
        return Minecraft.getMinecraft().player != null && Minecraft.getMinecraft().world != null;
    }

    @Override
    public boolean isSingleplayer() {
        return Minecraft.getMinecraft().isSingleplayer();
    }

    @Override
    public boolean isF3MenuOpen() {
        return Minecraft.getMinecraft().gameSettings.showDebugInfo;
    }

    @Override
    public String filterAllowedCharacters(String inputString) {
        return ChatAllowedCharacters.filterAllowedCharacters(inputString);
    }

    @Override
    public boolean isAllowedCharacter(char character)
    {
        return character != 167 && character >= 32 && character != 127;
    }

    @Override
    public SocketAddress getSocketAddress() {
        if(Minecraft.getMinecraft() == null || Minecraft.getMinecraft().getConnection() == null || Minecraft.getMinecraft().getConnection().getNetworkManager() == null)
            return null;
        return Minecraft.getMinecraft().getConnection().getNetworkManager().getRemoteAddress();
    }

    @Override
    public String translateLanguageKey(String translateKey) {
        return I18n.format(translateKey, new Object[0]);
    }

    @Override
    public void openMainMenu() {
        Minecraft.getMinecraft().displayGuiScreen(new GuiMainMenu());
    }

    @Override
    public boolean isLegacy() {
        return true;
    }

    @Override
    public Map<String, Integer> getScoreBoardLines() {
        Map<String, Integer> scoreBoardLines = new HashMap<>();
        if(Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().world.getScoreboard() == null ||  Minecraft.getMinecraft().world.getScoreboard().getObjectiveInDisplaySlot(1) == null)
            return scoreBoardLines;
        ScoreObjective objective = Minecraft.getMinecraft().world.getScoreboard().getObjectiveInDisplaySlot(1);
        Collection<Score> scores = Minecraft.getMinecraft().world.getScoreboard().getScores();
        for (Score score : scores) {
            if(score.getObjective() != objective)
                continue;
            scoreBoardLines.put(score.getPlayerName(), score.getScorePoints());
        }
        return scoreBoardLines;
    }

    @Override
    public String getScoreBoardTitle() {
        if(Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().world.getScoreboard() == null || Minecraft.getMinecraft().world.getScoreboard().getObjectiveInDisplaySlot(1) == null)
            return "";
        return Minecraft.getMinecraft().world.getScoreboard().getObjectiveInDisplaySlot(1).getDisplayName();
    }

    public static Laby3MinecraftAPI_v1_12_2 getAPI() {
        if(instance == null)
            instance = new Laby3MinecraftAPI_v1_12_2();
        return instance;
    }
}
