package com.example.examplemvvm

interface TimeTicker {
    fun start(callBack: CallBack, period: Long = 1000)

    fun stop()

    interface CallBack {
        fun tick()
    }
}