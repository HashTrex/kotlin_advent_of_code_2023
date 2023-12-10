package days.day_2

import utils.Utils

class Day2Part2 {
    fun main(args: Array<String>) {
        val utils = Utils()
        val getContent = utils.readInputFile("day_2/input_day_2.txt")
        //val getContent = utils.readInputFile("day_2/input_trial_day_2.txt")
        val contentArray = getContent.split("\n")
        var total = 0
        contentArray.forEach {
            var model = ElfGameModel()
            model = Day2Part1().getGameId(it)
            model = gameSplitter(model)

            //Do multiplications
            val totalMultiplication = model.maxRedCubes * model.maxGreenCubes * model.maxBlueCubes
            total += totalMultiplication
        }

        println(total)
    }

    private fun gameSplitter(model: ElfGameModel): ElfGameModel {
        var updatedModel = model
        val timesPicked = model.gameContent.split("; ")
        timesPicked.forEach {
            val cubes = it.split(", ")
            //Determine max number of each type of cubes
            //println(cubes)
            updatedModel = determineMaxCube(cubes, model)
        }
        return updatedModel
    }

    private fun determineMaxCube(cubes: List<String>, model: ElfGameModel): ElfGameModel {
        cubes.forEach {
            val numberOfCubes = it.split(" ")[0].toInt()
            with(it) {
                when {
                    contains("red") -> {
                        if (numberOfCubes > model.maxRedCubes)
                            model.maxRedCubes = numberOfCubes
                    }

                    contains("green") -> {
                        if (numberOfCubes > model.maxGreenCubes)
                            model.maxGreenCubes = numberOfCubes
                    }

                    contains("blue") -> {
                        if (numberOfCubes > model.maxBlueCubes)
                            model.maxBlueCubes = numberOfCubes
                    }
                }
            }
        }
        return model
    }
}

