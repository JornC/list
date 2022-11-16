package nl.yogh.wui.application.ui.landing;

import com.axellience.vuegwt.core.annotations.component.Component;
import com.axellience.vuegwt.core.annotations.component.Prop;
import com.axellience.vuegwt.core.client.component.IsVueComponent;
import com.google.web.bindery.event.shared.EventBus;

@Component
public class LandingView implements IsVueComponent {
  @Prop EventBus eventBus;
}
