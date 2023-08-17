package org.asherwin.httpinator.plugin.http.response;

import java.util.Collections;
import java.util.Map;

public class ViewPluginHttpResponse extends AbstractPluginHttpResponse {

  public final String viewName;
  public final Map<String, Object> data;

  public ViewPluginHttpResponse(String viewName) {
    this(viewName, Collections.emptyMap());
  }

  public ViewPluginHttpResponse(String viewName, Map<String, Object> data) {
    this.viewName = viewName;
    this.data = data;
  }

}
