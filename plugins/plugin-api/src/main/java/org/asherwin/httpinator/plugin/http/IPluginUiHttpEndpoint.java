package org.asherwin.httpinator.plugin.http;

import java.lang.reflect.Method;
import java.util.List;

/**
 * The contract to provide a method which handles an HTTP endpoint
 */
public interface IPluginUiHttpEndpoint {

  List<Methods> getMethods();

  /**
   * This will be prefixed with "/plugins/${PLUGIN_NAME}"
   * <p>
   * Each path must start with "/"
   */
  List<String> getPaths();

  /**
   * The function which processes the web request
   *
   * @return
   */
  Method getHandler();


  enum Methods {
    GET, POST, PUT, DELETE
  }

}
