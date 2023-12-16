package com.panopset.examples.mirror

class Driver {
    val arguments = arrayOfNulls<Any>(0)

    fun doSayHello(): String {
        val clazzj = Class.forName("com.panopset.examples.mirror.Passenger")
        val clazzk = clazzj.kotlin
        val instx = clazzk.objectInstance
        val resz = clazzk.members.firstOrNull { it.name == "sayHello" }?.call(instx)
        println(resz)
        return resz.toString()
    }
}
