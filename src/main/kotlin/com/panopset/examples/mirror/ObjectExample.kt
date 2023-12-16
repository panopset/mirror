package com.panopset.examples.mirror

/**
 * This is the Object that you wish to call, when you only know
 * that you want to call it at runtime, using reflection.
 */
object ObjectExample {
    fun sayHello(userName: String): String {
        return sayHey(userName)
    }
}
