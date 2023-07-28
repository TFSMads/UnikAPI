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

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.8.*")
public class Laby3MinecraftAPI_v1_8_9 implements MinecraftAPI {


    private static Laby3MinecraftAPI_v1_8_9 instance;

    @Override
    public boolean isInGame() {
        return Minecraft.getMinecraft().thePlayer != null && Minecraft.getMinecraft().theWorld != null;
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
        if(Minecraft.getMinecraft() == null || Minecraft.getMinecraft().getNetHandler() == null || Minecraft.getMinecraft().getNetHandler().getNetworkManager() == null)
            return null;
        return Minecraft.getMinecraft().getNetHandler().getNetworkManager().getRemoteAddress();
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
        if(Minecraft.getMinecraft().theWorld == null || Minecraft.getMinecraft().theWorld.getScoreboard() == null ||  Minecraft.getMinecraft().theWorld.getScoreboard().getObjectiveInDisplaySlot(1) == null)
            return scoreBoardLines;
        ScoreObjective objective = Minecraft.getMinecraft().theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
        Collection<Score> scores = Minecraft.getMinecraft().theWorld.getScoreboard().getScores();
        for (Score score : scores) {
            if(score.getObjective() != objective)
                continue;
            scoreBoardLines.put(score.getPlayerName(), score.getScorePoints());
        }
        return scoreBoardLines;
    }

    @Override
    public String getScoreBoardTitle() {
        if(Minecraft.getMinecraft().theWorld == null || Minecraft.getMinecraft().theWorld.getScoreboard() == null || Minecraft.getMinecraft().theWorld.getScoreboard().getObjectiveInDisplaySlot(1) == null)
            return "";
        return Minecraft.getMinecraft().theWorld.getScoreboard().getObjectiveInDisplaySlot(1).getDisplayName();
    }

    public static Laby3MinecraftAPI_v1_8_9 getAPI() {
        if(instance == null)
            instance = new Laby3MinecraftAPI_v1_8_9();
        return instance;
    }
}
