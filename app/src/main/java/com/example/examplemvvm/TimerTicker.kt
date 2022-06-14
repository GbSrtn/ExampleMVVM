package com.example.examplemvvm

import java.util.*

class TimerTicker: TimeTicker {
    private var callBack: TimeTicker.CallBack? = null
    private var timer: Timer? = null
    private val timerTask
        get() = object : TimerTask() {
            override fun run() {
                callBack?.tick()
            }
        }

    override fun start(callBack: TimeTicker.CallBack, period: Long) {
        this.callBack = callBack
        timer = Timer()
        timer?.scheduleAtFixedRate(timerTask, 0, period)
    }

    override fun stop() {
        callBack = null
        timer?.cancel()
        timer = null
    }
}