package org.asherwin.httpinator.expression

import org.springframework.expression.AccessException
import org.springframework.expression.TypeLocator

class SafeListTypeLocator(
  private val delegate: TypeLocator,
  safeList: Array<Class<*>>,
) : TypeLocator {

  private val typeNames = safeList.map { it.name }

  override fun findType(typeName: String): Class<*> {
    val result = delegate.findType(typeName)

    return   when {
      typeNames.contains(result.name) -> result
      else -> throw AccessException("Failed to resolve type '${result.name}', type not safe listed");
    }
  }


}