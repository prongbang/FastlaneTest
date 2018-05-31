package com.touchtechnologies.fastlanetest

import com.touchtechnologies.fastlanetest.utils.StringUtil
import junit.framework.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by mdev on 1/9/2018 AD.
 */
@RunWith(JUnit4::class)
class StringUtilTest {

    @Test
    @Throws(Exception::class)
    fun revertHelloIsNotNullTest() {

        val output = StringUtil.revert("Hello")

        Assert.assertNotNull(output)
        Assert.assertEquals("olleH", output)
    }

    @Test
    @Throws(Exception::class)
    fun revertHelloIsNullTest() {
        val output = StringUtil.revert(null)
        Assert.assertNull(output)
    }

}