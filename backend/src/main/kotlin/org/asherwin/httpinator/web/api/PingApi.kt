package org.asherwin.httpinator.web.api

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api")
class PingApi {

  @GetMapping("/ping")
  fun ping(): ResponseEntity<String> {
    val entity = ResponseEntity.ok("some data")
    return entity
  }

  @GetMapping("/test1")
  fun test1(): String {
    return "tests/test1"
  }
}