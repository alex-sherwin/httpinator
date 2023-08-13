package org.asherwin.httpinator.web.ui

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/ui")
class UiStaticish {

  @GetMapping(path = ["", "/", "/index.html"])
  fun index(): String = "ui/index"

}