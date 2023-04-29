package ml.volder.unikapi;

import ml.volder.unikapi.logger.DefaultLogger;
import ml.volder.unikapi.logger.Logger;

public class UnikAPI {

    public static Logger LOGGER = new DefaultLogger("UnikAPI");

    // Client brand - Examples:
    // - labymod
    // - forge
    // - fabric
    // - etc
    private static String clientBrand;
    // If the current client has versions with major differences this may be required. Set this to null if
    // there isn't any version with major differences.
    // For example this could differentiate labymod-3 from labymod-4
    private static String otherVersion;
    //Minecraft version - Examples:
    // - 1.8.8
    // - 1.12.2
    // - etc
    private static String minecraftVersion;

    //Minecraft- and other version can contain a * if all numbers is allowed. NOTE: this only works if the version is sepperated with dots. Here is an example:
    //
    // if the minecraft version is set to 1.8.*, all the following versions would be matched.
    // - 1.8
    // - 1.8.1
    // - 1.8.2
    // - 1.8.3
    // - 1.8.4
    // - 1.8.5
    // - 1.8.6
    // - 1.8.7
    // - 1.8.8
    // - 1.8.9

    public static void initAPI(String clientBrand, String otherVersion, String minecraftVersion) {
        UnikAPI.clientBrand = clientBrand;
        UnikAPI.otherVersion = otherVersion;
        UnikAPI.minecraftVersion = minecraftVersion;
    }

    public static boolean matchBrand(String clientBrand) {
        return UnikAPI.clientBrand.equals(clientBrand);
    }

    private static boolean matchDotSepperatedVersion(String matchVersion, String versionToCheck) {
        String[] subVersionsMatch = matchVersion.split(".");
        String[] subVersionsCheck = versionToCheck.split(".");
        int index = -1;
        for (String subVersion : subVersionsMatch) {
            index++;
            if(subVersion.equals("*")){
                if(subVersionsMatch.length - 1 >= index + 1)
                    continue;
                return true;
            }
            if(subVersionsCheck.length - 1 >= index && subVersionsCheck[index].equals(subVersion))
                continue;
            return false;
        }
        return true;
    }

    public static boolean matchOtherVersion(String otherVersion) {
        if(UnikAPI.otherVersion == null || otherVersion.equals("*"))
            return true;
        return matchDotSepperatedVersion(UnikAPI.otherVersion, otherVersion);
    }

    public static boolean matchMinecraftVersion(String[] minecraftVersion) {
        for(String version : minecraftVersion) {
            if(matchDotSepperatedVersion(UnikAPI.minecraftVersion, version))
                return true;
        }
        return false;
    }

    public static boolean isSupported(SupportedClient annotation) {
        return matchBrand(annotation.clientBrand()) && matchOtherVersion(annotation.otherVersion()) && matchMinecraftVersion(annotation.minecraftVersion());
    }

    public static String getClientBrand() {
        return clientBrand;
    }

    public static String getOtherVersion() {
        return otherVersion;
    }

    public static String getMinecraftVersion() {
        return minecraftVersion;
    }
}
