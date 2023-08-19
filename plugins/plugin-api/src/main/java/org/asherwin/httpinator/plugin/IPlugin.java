package org.asherwin.httpinator.plugin;

import org.asherwin.httpinator.plugin.registrars.IPluginHttpRegistrar;

import java.lang.reflect.Method;

public interface IPlugin {

  void registerHttpEndpoints(IPluginHttpRegistrar registrar);

  default Method safeMethod(String methodName) {
    return safeMethod(this, methodName);
  }

  default Method safeMethod(Object o, String methodName) {
    try {
      return o.getClass().getMethod(methodName);
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }

}
