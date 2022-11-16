package nl.yogh.wui.application.ui;

import nl.yogh.wui.application.place.ListPlaces.LandingPlace;
import nl.yogh.wui.application.ui.landing.LandingActivity;

public interface MainActivityFactory {
  LandingActivity createLandingPresenter(MainView view, LandingPlace place);
}
