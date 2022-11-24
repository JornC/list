package nl.yogh.wui.application.component.list;

import java.util.List;

import com.axellience.vuegwt.core.annotations.component.Component;
import com.axellience.vuegwt.core.annotations.component.Prop;
import com.axellience.vuegwt.core.client.component.IsVueComponent;

import jsinterop.annotations.JsProperty;

import nl.yogh.wui.application.domain.ListItem;

@Component(components = {
    ListItemComponent.class,
})
public class ListViewComponent implements IsVueComponent {
  @Prop @JsProperty List<ListItem> list;
}
