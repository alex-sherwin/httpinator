package org.asherwin.httpinator.plugins

import org.asherwin.httpinator.plugin.http.IPluginHttpEndpoint
import org.asherwin.httpinator.plugin.http.response.IPluginHttpResponse
import org.asherwin.httpinator.plugin.http.response.ViewPluginHttpResponse
import org.springframework.web.servlet.ModelAndView

/**
 * Handles all HTTP requests for plugins
 *
 * Responsible for converting [IPluginHttpResponse] objects returned from plugins into a Spring MVC compatible type
 * in [convertToSpringResponseType]
 */
class PluginRequestProxy(
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