package nl.yogh.wui.application.daemon;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import nl.aerius.wui.event.BasicEventComponent;
import nl.yogh.wui.application.dev.ApplicationDevelopmentObserver;

public class ApplicationDaemonBootstrapper extends BasicEventComponent implements DaemonBootstrapper {
  @Inject ApplicationDevelopmentObserver developmentObserver;
  @Inject ExceptionDaemon exceptionDaemon;

  @Override
  public void setEventBus(final EventBus eventBus) {
    super.setEventBus(eventBus, developmentObserver, exceptionDaemon);
  }
}
