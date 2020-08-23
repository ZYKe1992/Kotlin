package com.example.lesson.entity

data class Lesson(
        var date: String?,
        var content: String?,
        var state: State
) {
    enum class State(val stateName: String) {
        PLAYBACK ("有回放"),
        LIVE ("正在直播"),
        WAIT ("等待中")
    }
}