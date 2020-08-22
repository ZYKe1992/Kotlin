package com.example.lesson.entity

data class Lesson(
        val date: String?,
        val content: String?,
        val state: State
) {
    enum class State(val stateName: String) {
        PLAYBACK ("有回放"),
        LIVE ("正在直播"),
        WAIT ("等待中")
    }
}