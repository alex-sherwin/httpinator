package org.asherwin.httpinator.web.ui

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/ui")
class UiStaticish {

  @GetMapping(path = ["", "/", "/index.html"])
  fun index(): String = "ui/index"

  @GetMapping(path = ["/monaco"])
  fun monaco(): String = "ui/monaco"

  @GetMapping(path = ["/htmx"])
  fun htmx(): String = "ui/htmx"

  @GetMapping(path = ["/hyperscript"])
  fun hyperscript(): String = "ui/hyperscript"

  @GetMapping(path = ["/tailwind"])
  fun tailwind(): String = "ui/tailwind"

  @GetMapping(path = ["/kitchensink"])
  fun kitchensink(): String = "ui/kitchensink"

}