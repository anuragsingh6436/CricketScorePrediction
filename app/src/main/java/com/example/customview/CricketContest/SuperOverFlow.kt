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
    var strikeBatsman: AustralianTeam? = null
    var nonStrikeBatsman: AustralianTeam? = null
    var superOverEnded = false

    fun startSuperOverFlow() {
        inputSuperOverConstraints()
    }

    private fun inputSuperOverConstraints() {
        println("Enter First Innings Constraints")
        generateRandomBowlingType()
        inputTeam1Score()
        inputTeam2Data()
        outputSuperOverOutcome()
    }

    private fun generateRandomBowlingType() {
        BowlingType.values().shuffle()
        for (data in BowlingType.values()) {
            randomBowlingType.add(data)
        }
    }

    private fun predictBallByBallOutcome(ball:Int):Boolean {
        println("$bowlerName bowled ${randomBowlingType[ball]} ball")
        strikeBatsman = batsmanList[0]
        nonStrikeBatsman = batsmanList[1]
            println("$strikeBatsman played ${shotTimingList[ball]} ${shotTypeList[ball]} shot")

            if (outcomeList[ball] == 0) {
                totalAvailableWickets--
                strikeBatsman = batsmanList[2]
            } else if (outcomeList[ball] == 1) {
                val currentBatsman = strikeBatsman
                strikeBatsman = nonStrikeBatsman
                nonStrikeBatsman = currentBatsman
                australianTeamScore += outcomeList[ball]
            } else {
                australianTeamScore += outcomeList[ball]
            }
            if (totalAvailableWickets <= 0 || australianTeamScore > indiaSuperOverScore) {
                return true
            }
            println("${handleCommentaryOutput(outcomeList[ball])}")
        return false
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
                superOverEnded = predictBallByBallOutcome(i)
            }
            if(superOverEnded) {
                break
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