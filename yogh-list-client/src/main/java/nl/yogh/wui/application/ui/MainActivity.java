package nl.yogh.wui.application.ui;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.ResettableEventBus;

import nl.aerius.wui.activity.DelegableActivity;
import nl.aerius.wui.command.PlaceChangeCommand;
import nl.aerius.wui.place.Place;
import nl.aerius.wui.vue.activity.AbstractVueActivity;
import nl.yogh.wui.application.place.ListPlaces.MainPlace;

public class MainActivity extends AbstractVueActivity<MainPresenter, MainView, MainViewFactory> implements MainPresenter, DelegableActivity {
  private final MainActivityManager delegator;

  @Inject
  public MainActivity(final MainActivityManager delegator) {
    super(MainViewFactory.get());
    this.delegator = delegator;
  }

  @Override
  public MainActivity getPresenter() {
    return this;
  }

  @Override
  public boolean delegate(final ResettableEventBus eventBus, final PlaceChangeCommand c) {
    final boolean delegated = delegator.delegate(eventBus, c.getValue(), c::setRedirect);

    return delegated;
  }

  @Override
  public void setView(final MainView view) {
    delegator.setView(view);
  }

  @Override
  public boolean isDelegable(final Place place) {
    return place instanceof MainPlace;
  }
}
