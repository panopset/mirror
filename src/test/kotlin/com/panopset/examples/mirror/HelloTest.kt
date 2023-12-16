package com.panopset.examples.mirror

import org.junit.Test
import kotlin.test.assertEquals

class HelloTest {

    @Test
    fun test() {
        assertEquals("Hello world!", Driver().doSayHello())
    }
}
