package org.asherwin.httpinator.plugin;

import org.asherwin.httpinator.plugin.registrars.IPluginUiRegistrar;

public interface IPlugin {

  void registerUiEndpoints(IPluginUiRegistrar registrar);

}
