package com.example.customview.CricketContest

open class CommentaryFlow : CricketScoreBaseClass(), Commentary {

    private var output: String? = null

    fun startCommentaryFlow() {
        val bowlingType = inputBowlerCardName()
        val shotsType = inputShotType()
        val shotTimingsType = inputShotTiming()

        shotTimingsType?.let {
            val outcome = predictOutcome(it)
            output = handleCommentaryOutput(outcome)
        }

        println(output)
    }

}

interface Commentary {

    fun handleCommentaryOutput(num: Int): String? {
        when (num) {
            0 -> {
                val randomCommentaryList = listOf("It’s a wicket.", "Edged and taken.")
                val random = randomCommentaryList.random()
                return "$random - $num Runs"
            }
            1 -> {
                val randomCommentaryList = listOf(
                    "Excellent running between the wickets.",
                    "Excellent effort on the boundary.",
                    "Excellent line and length."
                )
                val random = randomCommentaryList.random()
                return "$random - $num Runs"
            }
            2 -> {
                val randomCommentaryList = listOf(
                    "Excellent running between the wickets.",
                    "Excellent effort on the boundary.",
                    "Excellent line and length.",
                    "Convert ones into twos."
                )
                val random = randomCommentaryList.random()
                return "$random - $num Runs"
            }

            4 -> {
                val randomCommentaryList = listOf(
                    "It’s a huge hit.",
                    "Just over the fielder."
                )
                val random = randomCommentaryList.random()
                return "$random - $num Runs"
            }
            6 -> {
                val randomCommentaryList = listOf(
                    "It’s a huge hit.",
                    "Just over the fielder.",
                    "That’s massive and out of the ground."
                )
                val random = randomCommentaryList.random()
                return "$random - $num Runs"
            }
        }
        return null
    }

}