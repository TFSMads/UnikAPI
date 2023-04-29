package ml.volder.unikapi.logger;

public class DefaultLogger implements Logger{

    private java.util.logging.Logger logger;
    public DefaultLogger(String name) {
        this.logger = java.util.logging.Logger.getLogger(name);
    }

    @Override
    public void finest(String string) {
        logger.finest(string);
    }

    @Override
    public void finer(String string) {
        logger.finer(string);
    }

    @Override
    public void fine(String string) {
        logger.fine(string);
    }

    @Override
    public void info(String string) {
        logger.info(string);
    }

    @Override
    public void warning(String string) {
        logger.warning(string);
    }

    @Override
    public void severe(String string) {
        logger.severe(string);
    }
}
