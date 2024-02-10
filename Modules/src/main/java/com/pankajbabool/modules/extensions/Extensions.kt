package com.pankajbabool.modules.extensions

inline fun<reified T> Any.extIsTypeOf(): T? = if (this is T) this else null