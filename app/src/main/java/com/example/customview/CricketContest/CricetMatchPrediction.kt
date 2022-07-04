package com.example.customview.CricketContest

import com.example.customview.CricketContest.data.ChallengeType

const val TAG = "CricketPrediction"

fun main() {
    inputChallengeTypeFromUser()
}

private fun inputChallengeTypeFromUser() {
    getChallengeType()?.let {
        try {
            val challengeType = it.toInt()
            handleChallengeType(challengeType)
        } catch (e: Exception) {
            println("Invalid Data Type")
            inputChallengeTypeFromUser()
        }
    }
}

private fun handleChallengeType(challengeType: Int) {
    when (challengeType) {
        ChallengeType.PREDICT_OUTCOME.value -> PredictScoreFlow().startPredictOutcomeFlow()
        ChallengeType.COMMENTARY.value -> CommentaryFlow().startCommentaryFlow()
        ChallengeType.SUPER_OVER.value -> SuperOverFlow().startSuperOverFlow()
        else -> {
            println("Not existing challenge Type")
            inputChallengeTypeFromUser()
        }
    }
}

private fun getChallengeType(): String? {
    println("Please Enter ChallengeType \n 1.Predict Outcome \n 2.Commentary \n 3.Super Over")
    return readLine()
}