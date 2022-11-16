package nl.yogh.wui.application.context;

import java.util.List;

import javax.inject.Singleton;

import jsinterop.annotations.JsProperty;

@Singleton
public class ListContext {
  private @JsProperty List<ListItem> activeList;

  public List<ListItem> getActiveList() {
    return activeList;
  }
}
