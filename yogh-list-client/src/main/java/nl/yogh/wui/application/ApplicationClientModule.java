package nl.yogh.wui.application;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.assistedinject.GinFactoryModuleBuilder;
import com.google.gwt.place.shared.PlaceHistoryHandler.Historian;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.web.bindery.event.shared.EventBus;

import nl.aerius.wui.activity.ActivityManager;
import nl.aerius.wui.activity.ActivityMapper;
import nl.aerius.wui.dev.DevelopmentObserver;
import nl.aerius.wui.event.CommandEventBus;
import nl.aerius.wui.history.HTML5Historian;
import nl.aerius.wui.history.PlaceHistoryMapper;
import nl.aerius.wui.place.ApplicationPlace;
import nl.aerius.wui.place.DefaultPlace;
import nl.aerius.wui.vue.AcceptsOneComponent;
import nl.aerius.wui.vue.activity.VueActivityManager;
import nl.yogh.wui.application.daemon.ApplicationDaemonBootstrapper;
import nl.yogh.wui.application.daemon.DaemonBootstrapper;
import nl.yogh.wui.application.dev.ApplicationDevelopmentObserver;
import nl.yogh.wui.application.factory.ApplicationActivityFactory;
import nl.yogh.wui.application.mapper.ApplicationActivityMapper;
import nl.yogh.wui.application.mapper.ApplicationPlaceHistoryMapper;
import nl.yogh.wui.application.place.ListPlaces.LandingPlace;
import nl.yogh.wui.application.ui.MainActivityFactory;

public class ApplicationClientModule extends AbstractGinModule {
  @Override
  protected void configure() {
    bind(EventBus.class).to(CommandEventBus.class).in(Singleton.class);

    bind(ApplicationPlace.class).annotatedWith(DefaultPlace.class).to(LandingPlace.class);
    bind(Historian.class).to(HTML5Historian.class);

    bind(new TypeLiteral<ActivityMapper<AcceptsOneComponent>>() {}).to(ApplicationActivityMapper.class);
    bind(new TypeLiteral<ActivityManager<AcceptsOneComponent>>() {}).to(VueActivityManager.class);
    bind(PlaceHistoryMapper.class).to(ApplicationPlaceHistoryMapper.class);
    bind(DaemonBootstrapper.class).to(ApplicationDaemonBootstrapper.class);
    bind(DevelopmentObserver.class).to(ApplicationDevelopmentObserver.class);

    install(new GinFactoryModuleBuilder().build(ApplicationActivityFactory.class));
    install(new GinFactoryModuleBuilder().build(MainActivityFactory.class));
  }
}
