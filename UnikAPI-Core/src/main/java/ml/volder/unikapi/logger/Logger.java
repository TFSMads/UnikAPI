package ml.volder.unikapi.logger;

public interface Logger {

    void finest(String string);
    void finer(String string);
    void fine(String string);
    void info(String string);
    void warning(String string);
    void severe(String string);

    default void debug(String string) {
        //TODO if debug is enabled!
        info(string);
    }


}
