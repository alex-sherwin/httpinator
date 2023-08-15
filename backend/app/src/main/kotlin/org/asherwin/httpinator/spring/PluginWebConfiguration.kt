package org.asherwin.httpinator.spring

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.View
import org.springframework.web.servlet.mvc.method.RequestMappingInfo
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
import org.springframework.web.util.pattern.PathPatternParser
import org.thymeleaf.spring6.view.ThymeleafView
import kotlin.reflect.jvm.javaMethod

@Configuration
class PluginWebConfiguration {

  @Autowired
  private lateinit var requestMappingHandlerMapping: RequestMappingHandlerMapping

  @PostConstruct
  fun init() {
    println("Here")

    val bean = MyBean()

    val options = RequestMappingInfo.BuilderConfiguration()
    options.patternParser = PathPatternParser()

    requestMappingHandlerMapping.registerMapping(
      RequestMappingInfo
        .paths("/plugins/http")
        .methods(RequestMethod.GET)
        .options(options)
        .build(),
      bean,
      bean::api.javaMethod!!
    )

    requestMappingHandlerMapping.registerMapping(
      RequestMappingInfo
        .paths("/plugins/template")
        .methods(RequestMethod.GET)
        .options(options)
        .build(),
      bean,
      bean::template.javaMethod!!
    )

    requestMappingHandlerMapping.registerMapping(
      RequestMappingInfo
        .paths("/plugins/view")
        .methods(RequestMethod.GET)
        .options(options)
        .build(),
      bean,
      bean::view.javaMethod!!
    )

    println("here")
  }

  class MyBean {
    //    @GetMapping("/plugins/http")

    fun api(): ResponseEntity<String> {

      val entity = ResponseEntity.ok()
        .header("x-custom", "hello")
        .body("body data")

      return entity
    }

    fun template(): String {

      return "ui/htmx"
    }

    fun view(): ModelAndView {
      val map = mutableMapOf("a" to "b", "b" to "c")
      val view = ModelAndView("ui/model", map)
      return view
    }
  }


}