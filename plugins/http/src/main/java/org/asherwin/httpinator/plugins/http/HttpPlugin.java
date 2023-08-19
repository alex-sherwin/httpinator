package org.asherwin.httpinator.plugins.http;

import org.asherwin.httpinator.plugin.IPlugin;
import org.asherwin.httpinator.plugin.http.IPluginHttpEndpoint;
import org.asherwin.httpinator.plugin.http.response.IPluginHttpResponse;
import org.asherwin.httpinator.plugin.http.response.ViewPluginHttpResponse;
import org.asherwin.httpinator.plugin.registrars.IPluginUiRegistrar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class HttpPlugin implements IPlugin {

  @Override
  public void registerUiEndpoints(IPluginUiRegistrar registrar) {

//    HttpPlugin.class.getMethod("httpConfig");

    registrar.registerEndpoint(IPluginHttpEndpoint.Methods.GET, "/plugins/http/config", this, safeMethod("httpConfig"));
    registrar.registerEndpoint(IPluginHttpEndpoint.Methods.GET, "/plugins/http/streaming", this, safeMethod("streaming"));

  }

  public IPluginHttpResponse httpConfig() {
    final HashMap<String, Object> data = new HashMap<>();
    data.put("a", "hello world");
    return new ViewPluginHttpResponse("plugins/http/config", data);
  }

  public IPluginHttpResponse streaming() {

    final ArrayList<CustomData> list = new ArrayList<>();
    for (int i = 0; i < 2000; i++) {
      list.add(new CustomData(i));
    }

    final Stream<CustomData> stream = list.stream();

    final HashMap<String, Object> data = new HashMap<>();
    data.put("a", "hello world");
    data.put("list", list);
    data.put("stream", stream);

    return new ViewPluginHttpResponse("plugins/http/streaming", data);
  }

}
