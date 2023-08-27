package org.asherwin.httpinator.treemodel

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Test

class TreeNodeTest {


  @Test
  fun parse() {

    Thread.currentThread().contextClassLoader
      .getResourceAsStream("examples/plugin.HttpRequest_01.json")
      ?.use {
        it.readAllBytes()?.decodeToString()?.let { json ->

          val om = ObjectMapper()
          om.registerModules(KotlinModule.Builder().build())

          val value = om.readValue<TreeNode>(json)

          println(value)

        }
      }

  }
}