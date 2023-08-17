package org.asherwin.httpinator.plugin.http;

import java.lang.reflect.Method;
import java.util.List;

/**
 * The contract to provide a method which handles an HTTP endpoint
 */
public interface IPluginHttpEndpoint {

  Methods[] getMethods();

  /**
   * This will be prefixed with "/plugins/${PLUGIN_NAME}"
   * <p>
   * Each path must start with "/"
   */
  String[] getPaths();

  Object getHandler();

  /**
   * The function which processes the web request
   *
   * @return
   */
  Method getHandlerMethod();


  enum Methods {
    GET, POST, PUT, DELETE
  }

}
