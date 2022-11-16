package nl.yogh.wui.application.ui.landing;

import java.util.List;

import javax.inject.Inject;

import com.axellience.vuegwt.core.annotations.component.Component;
import com.axellience.vuegwt.core.annotations.component.Computed;
import com.axellience.vuegwt.core.annotations.component.Data;
import com.axellience.vuegwt.core.annotations.component.Prop;
import com.axellience.vuegwt.core.client.component.IsVueComponent;
import com.google.web.bindery.event.shared.EventBus;

import nl.yogh.wui.application.context.ListContext;
import nl.yogh.wui.application.context.ListItem;

@Component
public class LandingView implements IsVueComponent {
  @Prop EventBus eventBus;

  @Inject @Data ListContext listContext;

  @Computed
  public List<ListItem> getActiveList() {
    return listContext.getActiveList();
  }
}
