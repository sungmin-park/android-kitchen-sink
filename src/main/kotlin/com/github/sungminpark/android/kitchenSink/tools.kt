package com.github.sungminpark.android.kitchenSink

fun android.content.Context.attribute(value: Int): android.util.TypedValue {
    val ret = android.util.TypedValue()
    theme.resolveAttribute(value, ret, true)
    return ret
}

fun android.content.Context.attrAsDimen(value: Int): Int {
    return android.util.TypedValue.complexToDimensionPixelSize(attribute(value).data, resources.displayMetrics)
}