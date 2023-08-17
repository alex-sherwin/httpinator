package org.asherwin.httpinator.plugin.http.response;

import java.util.Map;

public abstract class AbstractPluginHttpResponse implements IPluginHttpResponse {

  public int statusCode = 200;
  public Map<String, Object> headers;

}
