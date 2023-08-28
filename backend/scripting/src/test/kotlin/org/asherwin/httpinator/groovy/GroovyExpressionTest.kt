package org.asherwin.httpinator.groovy

import groovy.lang.Binding
import groovy.lang.GroovyShell
import org.codehaus.groovy.control.CompilerConfiguration
import org.junit.jupiter.api.Test

class GroovyExpressionTest {

  @Test
  fun test() {

//    val compilerConfig = CompilerConfiguration()
    val compilerConfig = CompilerConfiguration.DEFAULT

    val sharedData = Binding()
    sharedData.setVariable("str1", "abc")
    sharedData.setVariable("int1", 1)
    sharedData.setVariable("long1", 2L)
    sharedData.setVariable("boolt", true)
    sharedData.setVariable("boolT", java.lang.Boolean.TRUE)
    sharedData.setVariable("helper", Helper())
    sharedData.setVariable("fn", Helper()::ok)

    val shell = GroovyShell(sharedData, compilerConfig)

//    val result = shell.evaluate("\"z\${str1}\"")
//    val result = shell.evaluate("helper.ok()")
    val result = shell.evaluate("fn()")
    println("result: " + result);

    val r1 = shell.parse("\"z\${str1}\"")



    println()
  }

  class Helper {
    fun ok(): String {
      println("ok!")
      return "okay"
    }
  }
}