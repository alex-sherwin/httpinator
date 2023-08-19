package org.asherwin.httpinator.spring

import jakarta.annotation.PostConstruct
import org.asherwin.httpinator.plugin.registrars.IPluginUiRegistrar
import org.asherwin.httpinator.plugins.http.HttpPlugin
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping


@Configuration
class PluginWebConfiguration {

  @Autowired
  private lateinit var requestMappingHandlerMapping: RequestMappingHandlerMapping

  @Autowired
  private lateinit var pluginRegistrar: IPluginUiRegistrar

  @PostConstruct
  fun init() {

    val httpPlugin = HttpPlugin()

    httpPlugin.registerUiEndpoints(pluginRegistrar)


  }

}