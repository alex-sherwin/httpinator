package org.asherwin.httpinator.web

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/test")
class TestController {

  @GetMapping("/ping")
  fun ping(): ResponseEntity<String> {
    return ResponseEntity.ok("pong")
  }

  @GetMapping("/data")
  fun data(): ResponseEntity<String> {
    return ResponseEntity.ok("pong")
  }



}