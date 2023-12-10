package days.day_2

import utils.Utils

class Day2Part1 {
    private val fixedRedCubes = 12
    private val fixedGreenCubes = 13
    private val fixedBlueCubes = 14
    private var sumOfGameIds = 0

    fun main(args: Array<String>) {
        val utils = Utils()
        val getContent = utils.readInputFile("day_2/input_day_2.txt")
        //val getContent = utils.readInputFile("day_2/input_trial_day_2.txt")
        val contentArray = getContent.split("\n")

        contentArray.forEach {
            var model = ElfGameModel()
            model = getGameId(it)
            model = gameSplitter(model)
            if(model.isInRange)
                sumOfGameIds += model.gameId
        }


        println("Sum of game ids that is within the possibilities: $sumOfGameIds")
    }

    fun getGameId(content: String): ElfGameModel {
        val contentSplit = content.split(": ")
        val model = ElfGameModel()
        model.gameId = contentSplit[0].replace("Game ", "").toInt()
        model.gameContent = contentSplit[1]
        return model
    }

    private fun gameSplitter(model: ElfGameModel): ElfGameModel {
        val timesPicked = model.gameContent.split("; ")
        timesPicked.forEach {
            val cubes = it.split(", ")
            if(model.isInRange)
                model.isInRange = determineCubeWithinRange(cubes)
        }

        return model
    }

    private fun determineCubeWithinRange(cubes: List<String>): Boolean {
        var isInRange = true
        cubes.forEach {
            val numberOfCubes = it.split(" ")[0].toInt()
            with(it) {
                when {
                    contains("red") -> {
                        if(numberOfCubes > fixedRedCubes)
                            isInRange = false
                    }
                    contains("green") -> {
                        if(numberOfCubes > fixedGreenCubes)
                            isInRange = false
                    }
                    contains("blue") -> {
                        if(numberOfCubes > fixedBlueCubes)
                            isInRange = false
                    }
                }
            }
        }
        return isInRange
    }
}

class ElfGameModel {
    var gameId = 0
    var gameContent = ""
    var isInRange = true

    //Use for part 2
    var maxRedCubes = 0
    var maxGreenCubes = 0
    var maxBlueCubes = 0
}