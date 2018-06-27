package com.gdlactivity.gdggithub.util

import android.content.Context
import android.content.Intent


inline fun <reified T> Context.launchActivity(block: Intent.() -> Unit) {
    val intent = Intent(this, T::class.java)
    intent.block()
    startActivity(intent)
}
