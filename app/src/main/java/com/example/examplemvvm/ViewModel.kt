package com.example.examplemvvm

import android.util.Log
import java.util.*

class ViewModel(private val model: Model) {

    private var textObservable: TextObservable? = null

    private val textCallBack = object : TextCallBack {
        override fun updateText(str: String) {
            textObservable?.postValue(str)
        }
    }

    fun init(textObservable: TextObservable) {
        this.textObservable = textObservable
        model.start(textCallBack)
    }

    fun clear() {
        textObservable = null
    }

    fun resumeCounting() {
        model.start(textCallBack)
    }

    fun pauseCounting() {
        model.stop()    }
}

class TextObservable {

    private lateinit var callBack: TextCallBack

    fun observe(callBack: TextCallBack) {
        this.callBack = callBack
    }

    fun postValue(text: String) {
        callBack.updateText(text)
    }
}

interface TextCallBack {
    fun updateText(str: String)
}

class Model(
    private val dataSource: DataSource,
    private val timeTicker: TimeTicker
    ) {
    private val tickerCallBack
        get() = object : TimeTicker.CallBack {
            override fun tick() {
                count++
                callback?.updateText(count.toString())
            }
        }

    private var callback: TextCallBack? = null
    private var count = -1

    fun start(textCallBack: TextCallBack) {
        callback = textCallBack
        if (count < 0)
            count = dataSource.getInt(COUNTER_KEY)
        timeTicker.start(tickerCallBack)
    }

    fun stop() {
        dataSource.saveInt(COUNTER_KEY,count)
        timeTicker.stop()
    }

    companion object{
        private const val COUNTER_KEY = "counting"
    }
}