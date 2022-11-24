package nl.yogh.wui.application.component.list;

import com.axellience.vuegwt.core.annotations.component.Component;
import com.axellience.vuegwt.core.annotations.component.Prop;
import com.axellience.vuegwt.core.client.component.IsVueComponent;

import nl.yogh.wui.application.domain.ListItem;

@Component
public class ListItemComponent implements IsVueComponent {
  @Prop ListItem item;
}
