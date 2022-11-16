package nl.yogh.wui.application.component.application;

import javax.inject.Inject;

import com.axellience.vuegwt.core.annotations.component.Component;
import com.axellience.vuegwt.core.annotations.component.Data;
import com.axellience.vuegwt.core.annotations.component.Prop;
import com.axellience.vuegwt.core.client.component.IsVueComponent;
import com.google.web.bindery.event.shared.EventBus;

import jsinterop.annotations.JsMethod;

import nl.aerius.wui.place.PlaceController;
import nl.yogh.wui.application.context.ConfigurationContext;
import nl.yogh.wui.application.place.ListPlaces.LandingPlace;

@Component
public class ApplicationHeader implements IsVueComponent {
  @Prop EventBus eventBus;

  @Data @Inject ConfigurationContext context;

  @Inject PlaceController placeController;

  @JsMethod
  public void goHome() {
    placeController.goTo(new LandingPlace());
  }
}
