package ml.volder.unikapi.logger;

import org.apache.logging.log4j.LogManager;

public class Laby3Logger_v1_8_9 implements Logger{

    private org.apache.logging.log4j.Logger logger;
    public Laby3Logger_v1_8_9(String name) {
        this.logger = LogManager.getLogger(name);
    }
  
    @Override
    public void finest(String s) {
        logger.debug(s);
    }
  
    @Override
    public void finer(String s) {
      logger.debug(s);
    }
  
    @Override
    public void fine(String s) {
      logger.debug(s);
    }
  
    @Override
    public void info(String s) {
      logger.info(s);
    }
  
    @Override
    public void warning(String s) {
      logger.warn(s);
    }
  
    @Override
    public void severe(String s) {
      logger.error(s);
    }
  }
