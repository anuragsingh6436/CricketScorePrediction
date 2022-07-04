package com.example.customview.CricketContest

import com.example.customview.CricketContest.data.*

class SuperOverFlow : CricketScoreBaseClass(), Commentary, PredictScore {

    private var indiaSuperOverScore: Int = 0
    private var totalAvailableWickets = 2
    private var australianTeamScore = 0
    private var randomBowlingType = arrayListOf<BowlingType>()
    private val shotTypeList = arrayListOf<BattingShotsType>()
    private val shotTimingList = arrayListOf<ShotTimingsType>()
    private val outcomeList = arrayListOf<Int>()
    private val bowlerName = IndianTeam.values().random()
    private val batsmanList = AustralianTeam.values()

    fun startSuperOverFlow() {
        inputSuperOverConstraints()
    }

    private fun inputSuperOverConstraints() {
        println("Enter First Innings Constraints")
        generateRandomBowlingType()
        inputTeam1Score()
        inputTeam2Data()
        predictBallByBallOutcome()
    }

    private fun generateRandomBowlingType() {
        BowlingType.values().shuffle()
        for (data in BowlingType.values()) {
            randomBowlingType.add(data)
        }
    }

    private fun predictBallByBallOutcome() {
        for (i in 0 until 6) {
            println("$bowlerName bowled ${randomBowlingType[i]} ball")
        }
        var strikeBatsman = batsmanList[0]
        var nonStrikeBatsman = batsmanList[1]

        for (i in 0 until 6) {
            println("$strikeBatsman played ${shotTimingList[i]} ${shotTypeList[i]} shot")

            if (outcomeList[i] == 0) {
                totalAvailableWickets--
                strikeBatsman = batsmanList[2]
            } else if (outcomeList[i] == 1) {
                val currentBatsman = strikeBatsman
                strikeBatsman = nonStrikeBatsman
                nonStrikeBatsman = currentBatsman
                australianTeamScore += outcomeList[i]
            } else {
                australianTeamScore += outcomeList[i]
            }
            if (totalAvailableWickets <= 0 || australianTeamScore > indiaSuperOverScore) {
                break
            }
            println("${handleCommentaryOutput(outcomeList[i])}")
        }
        outputSuperOverOutcome()
    }

    private fun outputSuperOverOutcome() {
        println("AUSTRALIA scored: $australianTeamScore")
        if (australianTeamScore + 1 >= indiaSuperOverScore) {
            println("AUSTRALIA won by $totalAvailableWickets wicket")
        } else {
            println("AUSTRALIA lost by ${indiaSuperOverScore - australianTeamScore}")
        }
    }

    private fun inputTeam2Data() {
        for (i in 0 until 6) {
            shotTypeList.add(inputShotType()!!)
            val shotTimingsType = inputShotTiming()
            shotTimingsType?.let {
                shotTimingList.add(it)
                outcomeList.add(predictOutcome(it))
            }
        }
    }

    private fun inputTeam1Score() {
        println("Enter team India first inning target score")
        try {
            indiaSuperOverScore = readLine()?.toInt() ?: 0
        } catch (e: Exception) {
            println("Not a valid input.Please enter again")
            inputTeam1Score()
        }
    }

}