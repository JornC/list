/*
 * Copyright the State of the Netherlands
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 */
package nl.yogh.wui.application.ui;

import com.google.inject.Inject;

import nl.aerius.wui.dev.GWTProd;
import nl.aerius.wui.place.Place;
import nl.yogh.wui.application.place.ListPlaces.LandingPlace;

public class MainActivityManager extends AbstractSubActivityManager<MainView, MainSubPresenter> {
  private final MainActivityFactory activityFactory;

  @Inject
  public MainActivityManager(final MainActivityFactory activityFactory) {
    this.activityFactory = activityFactory;
  }

  @Override
  public MainSubPresenter getActivity(final Place place, final MainView view) {
    if (place instanceof LandingPlace) {
      return activityFactory.createLandingPresenter(view, (LandingPlace) place);
    } else {
      GWTProd.warn("MainActivityManager", "Could not create sub-activity inside MainActivityManager: no activity for " + place);
      //      return activityFactory.createEmptyActivity(view);
      return null;
    }
  }

  @Override
  protected Place getRedirect(final Place place) {
    final Place redirect = null;
    return redirect;
  }
}
