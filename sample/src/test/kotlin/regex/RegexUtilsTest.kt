package com.phenix.regex

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import regex.RegexUtils

class RegexUtilsTest{
    @Test
    fun testEmail() {
        assertTrue(RegexUtils.checkEmailIsValid("iplanetcn@gmail.com"))
        assertFalse(RegexUtils.checkEmailIsValid("13123213"))
    }
    
    @Test
    fun testIntRange() {
        val test = IntRange(0, 5).map { "Hello$it"  }
        println(test)

    }
       
}