package org.asherwin.httpinator.web.ui

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/ui")
class UiTemplatesController {

  @GetMapping(path = ["", "/", "/index.html"])
  fun index(): String = "ui/index"

  @GetMapping(path = ["/{*template}"])
  fun monaco(@PathVariable("template") template: String): String = "ui/${template}"

}