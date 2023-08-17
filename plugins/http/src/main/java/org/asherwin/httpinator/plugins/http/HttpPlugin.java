package org.asherwin.httpinator.plugins.http;

import org.asherwin.httpinator.plugin.IPlugin;
import org.asherwin.httpinator.plugin.http.IPluginHttpEndpoint;
import org.asherwin.httpinator.plugin.http.response.IPluginHttpResponse;
import org.asherwin.httpinator.plugin.http.response.ViewPluginHttpResponse;
import org.asherwin.httpinator.plugin.registrars.IPluginUiRegistrar;

import java.util.HashMap;

public class HttpPlugin implements IPlugin {

  @Override
  public void registerUiEndpoints(IPluginUiRegistrar registrar) {

//    HttpPlugin.class.getMethod("httpConfig");

    registrar.registerEndpoint(IPluginHttpEndpoint.Methods.GET, "/plugins/http/config", this, safeMethod("httpConfig"));

  }

  public IPluginHttpResponse httpConfig() {
    final HashMap<String, Object> data = new HashMap<>();
    data.put("a", "hello world");
    return new ViewPluginHttpResponse("plugins/http/config", data);
  }

}
