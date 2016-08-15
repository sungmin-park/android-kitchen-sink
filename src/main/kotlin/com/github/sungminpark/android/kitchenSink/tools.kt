package com.github.sungminpark.android.kitchenSink

import android.content.Context
import android.util.TypedValue

fun Context.attribute(value: Int): TypedValue {
    val ret = TypedValue()
    theme.resolveAttribute(value, ret, true)
    return ret
}

fun Context.attrAsDimen(value: Int): Int {
    return TypedValue.complexToDimensionPixelSize(attribute(value).data, resources.displayMetrics)
}