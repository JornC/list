package nl.yogh.wui.application.mapper;

import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;

import nl.aerius.wui.activity.Activity;
import nl.aerius.wui.activity.ActivityMapper;
import nl.aerius.wui.place.ApplicationPlace;
import nl.aerius.wui.place.DefaultPlace;
import nl.aerius.wui.place.Place;
import nl.aerius.wui.vue.AcceptsOneComponent;
import nl.yogh.wui.application.factory.ApplicationActivityFactory;
import nl.yogh.wui.application.place.ListPlaces.MainPlace;

public class ApplicationActivityMapper implements ActivityMapper<AcceptsOneComponent> {
  private final ApplicationActivityFactory factory;

  @Inject
  public ApplicationActivityMapper(@DefaultPlace final ApplicationPlace place, final ApplicationActivityFactory factory) {
    this.factory = factory;
  }

  @Override
  public Activity<?, AcceptsOneComponent> getActivity(final Place place) {
    Activity<?, AcceptsOneComponent> presenter = null;

    presenter = tryGetActivity(place);

    if (presenter == null) {
      GWT.log("Presenter is null: Place ends up nowhere. " + place);
      throw new RuntimeException("No Presenter found for place " + place);
    }

    return presenter;
  }

  private Activity<?, AcceptsOneComponent> tryGetActivity(final Place place) {
    Activity<?, AcceptsOneComponent> presenter = null;

    if (place instanceof MainPlace) {
      presenter = factory.createMainPresenter((MainPlace) place);
    }
    return presenter;
  }
}
