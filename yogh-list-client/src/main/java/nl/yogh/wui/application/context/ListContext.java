package nl.yogh.wui.application.context;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import jsinterop.annotations.JsProperty;

import nl.yogh.wui.application.domain.ListItem;

@Singleton
public class ListContext {
  private @JsProperty List<ListItem> activeList = new ArrayList<>();

  public List<ListItem> getActiveList() {
    return activeList;
  }

  public void setActiveList(final List<ListItem> list) {
    this.activeList = list;
  }

  public void addListItem(final ListItem item) {
    activeList.add(item);
  }
}
