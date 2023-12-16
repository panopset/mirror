package com.panopset.examples.mirror

import kotlin.reflect.KCallable
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

/**
 * This is the class that calls ObjectExample.sayHello(args) using reflection.
 */
class Driver {

    /**
     * See https://stackoverflow.com/questions/45210567/, for why we need to go to the Java class, to get the package.
     */
    private val pkg: Package = this::class.java.`package`
    private val pkgThisWouldAlsoWork = "com.panopset.examples.mirror"

    private val methodName = "sayHello"

    fun doSayHelloToAnObject(args: Array<String>): String {
        val clazzKotlin = getClassKotlin("ObjectExample")
        val singleton = clazzKotlin.objectInstance
        val mbr = getMethod(clazzKotlin, methodName)
        val response = mbr?.call(singleton, *args)
        return response.toString()
    }

    fun doSayHelloToAClass(args: Array<String>): String {
        val clazzKotlin = getClassKotlin("ClassExample")
        val singleton = clazzKotlin.createInstance()
        val mbr = getMethod(clazzKotlin, methodName)
        val response = mbr?.call(singleton, *args)
        return response.toString()
    }

    private fun getMethod(clazzKotlin: KClass<out Any>, methodName: String): KCallable<*>? {
        return clazzKotlin.members.firstOrNull() {it.name == methodName}
    }

    private fun getClassKotlin(name: String): KClass<out Any> {
        return getClass("${pkg.name}.$name").kotlin
    }

    private fun getClass(name: String): Class<*> {
        return Class.forName(name)
    }
}
