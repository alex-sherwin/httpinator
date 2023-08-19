package org.asherwin.httpinator.spring

import jakarta.annotation.PostConstruct
import org.asherwin.httpinator.plugin.IPlugin
import org.asherwin.httpinator.plugins.PluginRegistrar
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import java.util.*


@Configuration
class PluginSpringConfiguration {

  @Autowired
  private lateinit var pluginRegistrar: PluginRegistrar

  @PostConstruct
  fun init() {
    val plugins = ServiceLoader.load(IPlugin::class.java)
    plugins.forEach(pluginRegistrar::register)
    pluginRegistrar.start()
  }

}