package ca.derekellis.mapbox

internal inline fun <T> jsObject(block: T.() -> Unit): T = js("{}").unsafeCast<T>().apply(block)
