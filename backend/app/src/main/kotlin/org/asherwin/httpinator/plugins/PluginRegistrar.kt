package org.asherwin.httpinator.plugins

import org.asherwin.httpinator.plugin.IPlugin
import org.asherwin.httpinator.plugin.http.IPluginHttpEndpoint
import org.asherwin.httpinator.plugin.http.response.IPluginHttpResponse
import org.asherwin.httpinator.plugin.http.response.ViewPluginHttpResponse
import org.asherwin.httpinator.plugin.registrars.IPluginRegistrar
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.mvc.method.RequestMappingInfo
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
import org.springframework.web.util.pattern.PathPatternParser
import kotlin.reflect.jvm.javaMethod

@Service
class PluginRegistrar : IPluginRegistrar {

  @Autowired
  lateinit var requestMappingHandlerMapping: RequestMappingHandlerMapping

  val plugins: MutableList<IPlugin> = mutableListOf()

  fun register(plugin: IPlugin) {
    synchronized(plugins) { plugins.add(plugin) }
  }

  fun start() {
    plugins.forEach { plugin ->
      plugin.registerHttpEndpoints(this)
    }
  }

  override fun registerEndpoint(endpoint: IPluginHttpEndpoint) {

    val options = RequestMappingInfo.BuilderConfiguration()
    options.patternParser = PathPatternParser()

    val methods = endpoint.methods.map { RequestMethod.resolve(it.name) }.toTypedArray()

    val proxy = RequestProxy(endpoint)

    requestMappingHandlerMapping.registerMapping(
      RequestMappingInfo
        .paths(*endpoint.paths)
        .methods(*methods)
        .options(options)
        .build(),
      proxy,
      RequestProxy::execute.javaMethod!!,
    )

  }


  class RequestProxy(
    val endpoint: IPluginHttpEndpoint,
  ) {

    fun execute(): Any? {

      val originalResult = endpoint.handlerMethod.invoke(endpoint.handler)

      if (originalResult is IPluginHttpResponse) {
        return convertToSpringResponseType(originalResult)
      }

      return originalResult
    }

    fun convertToSpringResponseType(original: IPluginHttpResponse): Any {

      if (original is ViewPluginHttpResponse) {
        return ModelAndView(original.viewName, original.data)
      }

      throw RuntimeException("Unsupported IPluginHttpResponse implementation of type ${original.javaClass.name}")
    }

  }


}