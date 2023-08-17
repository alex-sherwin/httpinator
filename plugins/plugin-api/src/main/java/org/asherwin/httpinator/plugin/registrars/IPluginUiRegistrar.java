package org.asherwin.httpinator.plugin.registrars;

import org.asherwin.httpinator.plugin.http.IPluginHttpEndpoint;

import java.lang.reflect.Method;

public interface IPluginUiRegistrar {

  void registerEndpoint(IPluginHttpEndpoint endpoint);

  default void registerEndpoint(IPluginHttpEndpoint.Methods method, String path, Object handler, Method handlerMethod) {
    registerEndpoint(new IPluginHttpEndpoint.Methods[]{method}, new String[]{path}, handler, handlerMethod);
  }

  default void registerEndpoint(IPluginHttpEndpoint.Methods[] methods, String[] paths, Object handler, Method handlerMethod) {
    registerEndpoint(new IPluginHttpEndpoint() {
      @Override
      public Methods[] getMethods() {
        return methods;
      }

      @Override
      public String[] getPaths() {
        return paths;
      }

      @Override
      public Object getHandler() {
        return handler;
      }

      @Override
      public Method getHandlerMethod() {
        return handlerMethod;
      }
    });
  }

}
