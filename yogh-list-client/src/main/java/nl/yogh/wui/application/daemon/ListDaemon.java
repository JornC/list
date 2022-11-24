package nl.yogh.wui.application.daemon;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;

import nl.aerius.wui.event.BasicEventComponent;
import nl.yogh.wui.application.context.ListContext;
import nl.yogh.wui.application.domain.ListItem;

public class ListDaemon extends BasicEventComponent implements Daemon {
  @Inject private ListContext listContext;

  @Override
  public void init() {
    final ListItem item1 = new ListItem();
    item1.setText("Test 1");
    final ListItem item2 = new ListItem();
    item2.setText("Item 2");
    final ListItem item3 = new ListItem();
    item3.setText("Test 3");
    final ListItem item4 = new ListItem();
    item4.setText("Item 4");

    listContext.addListItem(item1);
    listContext.addListItem(item2);
    listContext.addListItem(item3);
    listContext.addListItem(item4);
  }

  @Override
  public void setEventBus(final EventBus eventBus) {
    super.setEventBus(eventBus);
  }
}
