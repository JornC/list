package nl.yogh.wui.application.factory;

import nl.yogh.wui.application.place.ListPlaces.MainPlace;
import nl.yogh.wui.application.ui.MainActivity;

public interface ApplicationActivityFactory {
  MainActivity createMainPresenter(MainPlace place);
}
