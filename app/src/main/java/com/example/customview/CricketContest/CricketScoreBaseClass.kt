package com.example.customview.CricketContest

import com.example.customview.CricketContest.data.BattingShotsType
import com.example.customview.CricketContest.data.BowlingType
import com.example.customview.CricketContest.data.ShotTimingsType
import java.lang.IllegalArgumentException

abstract class CricketScoreBaseClass {

    fun inputBowlerCardName(): BowlingType? {
        println("Enter Bowler Card Name")
        var bowlingType: BowlingType? = null
        val input = readLine()
        try {
            for (type in BowlingType.values()) {
                if (type.value.lowercase() == input?.lowercase()) {
                    bowlingType = type
                    return type
                }
            }
            if (bowlingType == null) {
                throw IllegalArgumentException()
            }
        } catch (e: Exception) {
            println("Not a existing bowler card type")
            return inputBowlerCardName()
        }
        return null
    }

    fun inputShotType(): BattingShotsType? {
        println("Enter Shot Type")
        var shotType: BattingShotsType? = null
        val input = readLine()
        try {
            for (type in BattingShotsType.values()) {
                if (type.value.lowercase() == input?.lowercase()) {
                    shotType = type
                    return shotType
                }
            }
            if (shotType == null) {
                throw IllegalArgumentException()
            }
        } catch (e: Exception) {
            println("Not a existing shot Type")
            return inputShotType()
        }
        return null
    }

    fun inputShotTiming(): ShotTimingsType? {
        println("Enter Shot Timing")
        var shotTimingsType: ShotTimingsType? = null

        val input = readLine()
        try {
            for (type in ShotTimingsType.values()) {
                if (type.name.lowercase() == input?.lowercase()) {
                    shotTimingsType = type
                    return shotTimingsType
                }
            }
            if (shotTimingsType == null) {
                throw IllegalArgumentException()
            }
        } catch (e: Exception) {
            println("Not a existing Shot Timing")
            return inputShotTiming()
        }
        return null
    }

    fun predictOutcome(shotTimingsType: ShotTimingsType):Int {
        when (shotTimingsType) {
            ShotTimingsType.Early -> {
                val randomNumberList = listOf(6, 4, 1, 1, 1, 2, 2, 2, 0, 0)
                return randomNumberList.random()
            }

            ShotTimingsType.Good -> {
                val randomNumberList = listOf(6, 6, 6, 4, 4, 4, 2, 2, 1, 0)
                return randomNumberList.random()
            }

            ShotTimingsType.Perfect -> {
                val randomNumberList = listOf(6, 6, 6, 6, 4, 4, 4, 2, 1, 0)
                return randomNumberList.random()
            }

            ShotTimingsType.Late -> {
                val randomNumberList = listOf(6, 4, 2, 2, 1, 1, 0, 0, 0, 0)
                return randomNumberList.random()
            }
        }
    }
}