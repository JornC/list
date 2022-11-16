package nl.yogh.wui.application.command;

import nl.aerius.wui.command.SimpleCommand;
import nl.yogh.wui.application.event.ToggleNotificationDisplayEvent;
import nl.yogh.wui.component.notification.NotificationToggleInfo;

public class ToggleNotificationDisplayCommand extends SimpleCommand<ToggleNotificationDisplayEvent> {
  private NotificationToggleInfo toggleInfo;

  @Override
  protected ToggleNotificationDisplayEvent createEvent() {
    return new ToggleNotificationDisplayEvent(toggleInfo);
  }

  public void setToggleInfo(final NotificationToggleInfo toggleInfo) {
    this.toggleInfo = toggleInfo;
  }
}

