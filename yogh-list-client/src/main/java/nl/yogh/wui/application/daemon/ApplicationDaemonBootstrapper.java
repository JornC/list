package nl.yogh.wui.application.daemon;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

import nl.aerius.wui.event.BasicEventComponent;
import nl.aerius.wui.event.HasEventBus;
import nl.yogh.wui.application.dev.ApplicationDevelopmentObserver;

public class ApplicationDaemonBootstrapper extends BasicEventComponent implements DaemonBootstrapper {
  @Inject private ApplicationDevelopmentObserver developmentObserver;
  @Inject private ExceptionDaemon exceptionDaemon;

  @Inject private ListDaemon listDaemon;

  @Override
  public void setEventBus(final EventBus eventBus) {
    setEventBus(eventBus, developmentObserver, exceptionDaemon, listDaemon);
  }

  @Override
  public void setEventBus(final EventBus eventBus, final HasEventBus... children) {
    super.setEventBus(eventBus, children);
    for (final HasEventBus bus : children) {
      if (bus instanceof Daemon) {
        ((Daemon) bus).init();
      }
    }
  }
}
