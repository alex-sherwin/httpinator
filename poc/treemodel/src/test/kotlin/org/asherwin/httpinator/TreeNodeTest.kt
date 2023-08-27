package org.asherwin.httpinator

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.junit.jupiter.api.Test

class TreeNodeTest {

  @Test
  fun test() {

    val om = ObjectMapper()
    om.registerModules(KotlinModule.Builder().build())

    val root = TreeNode("abc")

    val json = om.writeValueAsString(root)

    println("json:\n" + json)
  }
}