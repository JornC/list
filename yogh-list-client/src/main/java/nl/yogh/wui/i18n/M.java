package nl.yogh.wui.i18n;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;

import nl.aerius.wui.dev.GWTProd;

/**
 * Global class to messages interfaces.
 */
public final class M {
  private static void init() {
    DEFAULT_DATE_TIME_FORMATTER = DateTimeFormat.getFormat(M.messages().notificationDateTimeFormat());
  }

  private static DateTimeFormat DEFAULT_DATE_TIME_FORMATTER;

  private static final ApplicationMessages APPLICATION_MESSAGES = GWT.create(ApplicationMessages.class);
  static {
    init();
  }

  public static ApplicationMessages messages() {
    return APPLICATION_MESSAGES;
  }

  public static String formatDateTime(final Date dateTime) {
    return DEFAULT_DATE_TIME_FORMATTER.format(dateTime);
  }

  /**
   * Returns a user friendly readable message of the exception.
   *
   * @param e Exception to format
   * @return user friendly version of the message
   */
  public static String getErrorMessage(final Throwable e) {
    final Throwable cause = findCause(e);

    String message = "";
    if (e == null) {
      // do nothing, just return empty string.
    }

    if (GWTProd.isDev()) {
      message = cause.getMessage() + " (" + messages().errorInternalFatal() + ")";
    } else {
      message = messages().errorInternalFatal();
    }

    return message;
  }

  private static Throwable findCause(final Throwable e) {
    if (e.getCause() != null) {
      return findCause(e.getCause());
    } else {
      return e;
    }
  }
}
