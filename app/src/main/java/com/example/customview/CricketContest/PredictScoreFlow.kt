package com.example.customview.CricketContest

class PredictScoreFlow : CricketScoreBaseClass(),PredictScore {

    private var output: String? = null

    fun startPredictOutcomeFlow() {
        val bowlingType = inputBowlerCardName()
        val shotsType = inputShotType()
        val shotTimingsType = inputShotTiming()
        shotTimingsType?.let {
            val outcome = predictOutcome(it)
            output = handlePredictScoreFlow(outcome)
        }
        println(output)
    }
}

interface PredictScore {
    fun handlePredictScoreFlow(num: Int): String {
        return if (num == 0) {
            ("1 wicket")
        } else {
            "$num runs"
        }
    }
}
