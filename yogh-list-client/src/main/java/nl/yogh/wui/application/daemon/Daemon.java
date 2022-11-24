package nl.yogh.wui.application.daemon;

import nl.aerius.wui.event.HasEventBus;

public interface Daemon extends HasEventBus {
  default void init() {}
}
