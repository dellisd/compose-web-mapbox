@file:Suppress("NOTHING_TO_INLINE")
package ca.derekellis.mapbox.style

value class Expression(val parts: Array<out Any>)

inline fun expression(vararg parts: Any): Expression = Expression(parts)

inline fun at(index: Int, array: dynamic): Expression = expression("at", index, array)

inline fun get(prop: String): Expression = expression("get", prop)

inline fun get(prop: String, obj: dynamic): Expression = expression("get", prop, obj)

inline fun has(prop: String): Expression = expression("has", prop)

inline fun has(prop: String, obj: dynamic): Expression = expression("has", prop, obj)

inline fun `in`(keyword: dynamic, input: dynamic): Expression = expression("in", keyword, input)

inline fun not(value: dynamic): Expression = expression("!", value)

inline fun neq(a: dynamic, b: dynamic): Expression = expression("!=", a, b)

inline fun neq(a: dynamic, b: dynamic, collator: dynamic): Expression = expression("!=", a, b, collator)

inline fun lt(a: dynamic, b: dynamic): Expression = expression("<", a, b)

inline fun lt(a: dynamic, b: dynamic, collator: dynamic): Expression = expression("<", a, b, collator)

inline fun lte(a: dynamic, b: dynamic): Expression = expression("<=", a, b)

inline fun lte(a: dynamic, b: dynamic, collator: dynamic): Expression = expression("<=", a, b, collator)

inline fun eq(a: dynamic, b: dynamic): Expression = expression("==", a, b)

inline fun eq(a: dynamic, b: dynamic, collator: dynamic): Expression = expression("==", a, b, collator)

inline fun gt(a: dynamic, b: dynamic): Expression = expression(">", a, b)

inline fun gt(a: dynamic, b: dynamic, collator: dynamic): Expression = expression(">", a, b, collator)

inline fun gte(a: dynamic, b: dynamic): Expression = expression(">=", a, b)

inline fun gte(a: dynamic, b: dynamic, collator: dynamic): Expression = expression(">=", a, b, collator)

inline fun all(a: dynamic, b: dynamic): Expression = expression("all", a, b)

inline fun all(a: dynamic, b: dynamic, vararg rest: dynamic): Expression = expression("all", a, b, *rest)

inline fun any(a: dynamic, b: dynamic): Expression = expression("any", a, b)

inline fun any(a: dynamic, b: dynamic, vararg rest: dynamic): Expression = expression("any", a, b, *rest)

inline fun interpolate(type: Expression, input: Expression, vararg stops: Pair<Number, dynamic>): Expression =
  expression("interpolate", type, input, *stops.flatMap { (input, output) -> listOf(input, output) }.toTypedArray())
