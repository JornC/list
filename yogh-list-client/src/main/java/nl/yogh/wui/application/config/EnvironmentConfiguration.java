package nl.yogh.wui.application.config;

import com.google.inject.ImplementedBy;

@ImplementedBy(EnvironmentConfigurationImpl.class)
public interface EnvironmentConfiguration {
  String getBuildNumber();
}
