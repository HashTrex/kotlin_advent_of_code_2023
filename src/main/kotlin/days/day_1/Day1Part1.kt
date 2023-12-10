package days.day_1

import utils.Utils

class Day1Part1 {
    fun main(args: Array<String>) {
        val utils = Utils()
        val getContent = utils.readInputFile("day_1/input_day_1.txt")
        //val getContent = utils.readInputFile("day_1/input_trial_day_1_part_1.txt")
        val contentArray = getContent.split("\n")
        var result = 0
        contentArray.forEach {
            result += getFirstAndLastNumberOnlyInString(it).toInt()
        }
        println(result)
    }

    private fun getFirstAndLastNumberOnlyInString(content: String): String {
        val result = content.filter { it.isDigit() }
        val resultFirst = result.first()
        val resultLast = result.last()
        return "$resultFirst$resultLast"
    }
}