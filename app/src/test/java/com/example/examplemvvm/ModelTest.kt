package com.example.examplemvvm

import android.provider.ContactsContract
import org.junit.Assert.*

import org.junit.Test
import java.util.*

private class TestCallBack : TextCallBack {
    var text = ""
    override fun updateText(str: String) {
        text = str
    }
}

private class TestDataSourse : DataSource {
    private var int: Int = Int.MIN_VALUE
    override fun saveInt(key: String, value: Int) {
        int = value    }

    override fun getInt(key: String) = int
}

class ModelTest {

//    @Test
//    fun test_start_with_saved_value() {
//        val testDataSource = TestDataSourse()
//        val model = Model(testDataSource)
//        val callBack = TestCallBack()
//        testDataSource.saveInt("",5)
//        model.start(callBack)
//        Thread.sleep(20)
//        val actual = callBack.text
//        val expected = "5"
//        assertEquals(expected,actual)
//    }

    @Test
    fun stop() {
    }
}