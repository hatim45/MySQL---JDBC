package projects.exception;

@SuppressWarnings("serial")
public class DbException extends RuntimeException {

  /**
   * Creates an exception with a message.
   * 
   * @param message The message.
   */
  public DbException(String message) {
    super(message);
  }

  /**
   * Creates an exception with a cause.
   * 
   * @param cause The causal exception.
   */
  public DbException(Throwable cause) {
    super(cause);
  }

  /**
   * Create an exception with a message and a cause.
   * 
   * @param message The message.
   * @param cause The causal exception.
   */
  public DbException(String message, Throwable cause) {
    super(message, cause);
  }
}