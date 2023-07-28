package ml.volder.unikapi.api.minecraft.impl;

import ml.volder.unikapi.SupportedClient;
import ml.volder.unikapi.api.minecraft.MinecraftAPI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.util.SharedConstants;

import java.net.SocketAddress;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SupportedClient(clientBrand = "labymod3", minecraftVersion = "1.16.*")
public class Laby3MinecraftAPI_v1_16_5 implements MinecraftAPI {


    private static Laby3MinecraftAPI_v1_16_5 instance;

    @Override
    public boolean isInGame() {
        return Minecraft.getInstance().player != null && Minecraft.getInstance().world != null;
    }

    @Override
    public boolean isSingleplayer() {
        return Minecraft.getInstance().isSingleplayer();
    }

    @Override
    public boolean isF3MenuOpen() {
        return Minecraft.getInstance().gameSettings.showDebugInfo;
    }

    @Override
    public String filterAllowedCharacters(String inputString) {
        return SharedConstants.filterAllowedCharacters(inputString);
    }

    @Override
    public boolean isAllowedCharacter(char character)
    {
        return character != 167 && character >= 32 && character != 127;
    }

    @Override
    public SocketAddress getSocketAddress() {
        if(Minecraft.getInstance() == null || Minecraft.getInstance().getConnection() == null || Minecraft.getInstance().getConnection().getNetworkManager() == null)
            return null;
        return Minecraft.getInstance().getConnection().getNetworkManager().getRemoteAddress();
    }

    @Override
    public String translateLanguageKey(String translateKey) {
        return I18n.format(translateKey, new Object[0]);
    }

    @Override
    public void openMainMenu() {
        Minecraft.getInstance().displayGuiScreen(new MainMenuScreen());
    }

    @Override
    public boolean isLegacy() {
        return false;
    }

    @Override
    public Map<String, Integer> getScoreBoardLines() {
        Map<String, Integer> scoreBoardLines = new HashMap<>();
        if(Minecraft.getInstance().world == null || Minecraft.getInstance().world.getScoreboard() == null ||  Minecraft.getInstance().world.getScoreboard().getObjectiveInDisplaySlot(1) == null)
            return scoreBoardLines;
        ScoreObjective objective = Minecraft.getInstance().world.getScoreboard().getObjectiveInDisplaySlot(1);
        Collection<Score> scores = Minecraft.getInstance().world.getScoreboard().getSortedScores(objective);
        for (Score score : scores) {
            scoreBoardLines.put(score.getPlayerName(), score.getScorePoints());
        }
        return scoreBoardLines;
    }

    @Override
    public String getScoreBoardTitle() {
        if(Minecraft.getInstance().world == null || Minecraft.getInstance().world.getScoreboard() == null || Minecraft.getInstance().world.getScoreboard().getObjectiveInDisplaySlot(1) == null)
            return "";
        return Minecraft.getInstance().world.getScoreboard().getObjectiveInDisplaySlot(1).getDisplayName().getString();
    }

    public static Laby3MinecraftAPI_v1_16_5 getAPI() {
        if(instance == null)
            instance = new Laby3MinecraftAPI_v1_16_5();
        return instance;
    }
}
