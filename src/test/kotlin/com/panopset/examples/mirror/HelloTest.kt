package com.panopset.examples.mirror

import org.junit.Test
import kotlin.test.assertEquals

class HelloTest {
    val userName = System.getProperty("user.name")

    @Test
    fun testObject() {
        assertEquals("Hello $userName!", Driver().doSayHelloToAnObject(
            arrayOf(userName)
        ))
    }

    @Test
    fun testClass() {
        assertEquals("Hello $userName!", Driver().doSayHelloToAClass(
            arrayOf(userName)
        ))
    }
}
