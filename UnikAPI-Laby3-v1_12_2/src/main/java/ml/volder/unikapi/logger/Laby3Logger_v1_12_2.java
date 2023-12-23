package ml.volder.unikapi.logger;

import org.apache.logging.log4j.LogManager;

public class Laby3Logger_v1_12_2 implements Logger{

    private org.apache.logging.log4j.Logger logger;
    public Laby3Logger_v1_12_2(String name) {
        this.logger = LogManager.getLogger(name);
    }

    @Override
    public void log(LOG_LEVEL logLevel, String string) {
        if(!isEnabled(logLevel))
            return;
        switch (logLevel) {
            case FINEST:
            case FINE:
            case FINER:
            case INFO:
                logger.info(string);
                break;
            case WARNING:
                logger.warn(string);
                break;
            case SEVERE:
                logger.error(string);
                break;
        }
    }
  }
