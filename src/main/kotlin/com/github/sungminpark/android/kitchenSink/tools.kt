package com.github.sungminpark.android.kitchenSink

import android.content.Context
import android.support.v4.view.ViewCompat
import android.util.TypedValue
import android.view.View

fun Context.attribute(value: Int): TypedValue {
    val ret = TypedValue()
    theme.resolveAttribute(value, ret, true)
    return ret
}

fun Context.attrAsDimen(value: Int): Int {
    return TypedValue.complexToDimensionPixelSize(attribute(value).data, resources.displayMetrics)
}

fun View.setElevation(elevation: Int) {
    ViewCompat.setElevation(this, elevation.toFloat())
}