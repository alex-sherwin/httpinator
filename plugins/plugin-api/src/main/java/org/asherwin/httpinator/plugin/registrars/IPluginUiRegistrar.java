package org.asherwin.httpinator.plugin.registrars;

import org.asherwin.httpinator.plugin.http.IPluginUiHttpEndpoint;

public interface IPluginUiRegistrar {

  void registerUiHttpEndpoint(IPluginUiHttpEndpoint endpoint);

}
