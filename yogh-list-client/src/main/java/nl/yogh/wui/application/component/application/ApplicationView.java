package nl.yogh.wui.application.component.application;

import javax.inject.Inject;

import com.axellience.vuegwt.core.annotations.component.Component;
import com.axellience.vuegwt.core.annotations.component.Computed;
import com.axellience.vuegwt.core.annotations.component.Data;
import com.axellience.vuegwt.core.annotations.component.Prop;
import com.axellience.vuegwt.core.client.component.IsVueComponent;
import com.google.web.bindery.event.shared.EventBus;

import nl.yogh.wui.application.config.EnvironmentConfiguration;
import nl.yogh.wui.component.notification.NotificationComponent;

@Component(components = {
    ApplicationHeader.class,
    NotificationComponent.class
})
public class ApplicationView implements IsVueComponent {
  @Prop EventBus eventBus;

  @Data @Inject EnvironmentConfiguration cfg;

  @Computed
  public String getApplicationBuild() {
    return "https://github.com/JornC/list/commit/" + cfg.getBuildNumber();
  }
}
