package ml.volder.unikapi.api.minecraft;

import ml.volder.unikapi.api.ApiManager;

import java.net.SocketAddress;

public interface MinecraftAPI {
    boolean isInGame();
    boolean isSingleplayer();
    String filterAllowedCharacters(String inputString);
    boolean isAllowedCharacter(char character);
    SocketAddress getSocketAddress();
    String translateLanguageKey(String translateKey);

    /**
     * @return Returns true if minecraft version is prior to version 1.13
     */
    boolean isLegacy();

    static MinecraftAPI getAPI() {
        return ApiManager.getAPI("MinecraftAPI", "ml.volder.unikapi.api.minecraft.impl", MinecraftAPI.class);
    }
}
