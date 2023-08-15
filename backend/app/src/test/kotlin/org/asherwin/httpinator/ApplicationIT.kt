package org.asherwin.httpinator

import org.springframework.boot.runApplication
import org.springframework.core.env.AbstractEnvironment

fun main(args: Array<String>) {
  System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "test")
  runApplication<Application>(*args)
}