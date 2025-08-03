package com.example.dailyquizetest.presentation.common

enum class Difficulties(val level: String, amountOfQuestions: Int) {
    EASY("easy", 5),
    MEDIUM("medium", 10),
    HARD("hard", 15)
}