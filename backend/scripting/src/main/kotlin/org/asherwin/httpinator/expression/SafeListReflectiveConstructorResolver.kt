package org.asherwin.httpinator.expression

import org.springframework.core.convert.TypeDescriptor
import org.springframework.expression.AccessException
import org.springframework.expression.ConstructorExecutor
import org.springframework.expression.ConstructorResolver
import org.springframework.expression.EvaluationContext
import org.springframework.expression.spel.support.ReflectiveConstructorExecutor
import org.springframework.expression.spel.support.ReflectiveConstructorResolver


/**
 * Wraps a [ReflectiveConstructorResolver] and delegates [ReflectiveConstructorResolver.resolve] to it.
 *
 * If the delegate returns resolves a constructor then the configured safelist of classes is consulted,
 * if it's not safelisted then an [AccessException] is thrown
 */
class SafeListReflectiveConstructorResolver(
  private val delegate: ReflectiveConstructorResolver,
  safeList: Array<Class<*>>,
) : ConstructorResolver {

  private val typeNames = safeList.map { it.name }

  override fun resolve(
    context: EvaluationContext,
    typeName: String,
    argumentTypes: MutableList<TypeDescriptor>
  ): ConstructorExecutor? {

    val result = delegate.resolve(context, typeName, argumentTypes)

    return if (result is ReflectiveConstructorExecutor) {
      when {
        typeNames.contains(result.constructor.declaringClass.name) -> result
        else -> throw AccessException("Failed to resolve constructor for type '${result.constructor.declaringClass.name}', type not safe listed");
      }
    } else {
      null
    }
  }

}