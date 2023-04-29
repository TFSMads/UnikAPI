package ml.volder.unikapi.logger;

import net.labymod.api.Laby;
import net.labymod.api.util.logging.Logging;

public class Laby4Logger implements Logger{

  private Logging logger;
  public Laby4Logger(String name) {
    this.logger = Laby.references().loggingFactory().create(name);
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
