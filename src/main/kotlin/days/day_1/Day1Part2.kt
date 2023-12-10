package days.day_1

import utils.Utils

class Day1Part2 {
    fun main(args: Array<String>) {
        val utils = Utils()
        val getContent = utils.readInputFile("day_1/input_day_1.txt")
        //val getContent = utils.readInputFile("day_1/input_trial_day_1_part_2.txt")
        val contentArray = getContent.split("\n")
        var result = 0
        contentArray.forEach {
            result += getFirstAndLastNumberOnlyInString(it).toInt()
        }
        println(result)
    }

    private fun getFirstAndLastNumberOnlyInString(content: String): String {
        var frontStackContent = ""
        var backStackedContent = ""
        var firstDigit = ""
        var lastDigit = ""

        //For first digit
        content.forEach {
            frontStackContent+=it
            if(firstDigit.isEmpty())
                firstDigit = findDigit(frontStackContent, it.toString())
        }

        //For last digit
        for (i in content.length - 1 downTo 0) {
            backStackedContent = content[i] + backStackedContent
            if (lastDigit.isEmpty())
                lastDigit = findDigit(backStackedContent, content[i].toString())
        }

        if (firstDigit.isNotEmpty() && lastDigit.isNotEmpty())
            return "$firstDigit$lastDigit"

        return "0"
    }

    private fun findDigit(currentContent: String, currentCharacter: String): String {
        val isDigit = currentCharacter.filter { it.isDigit() }

        //Is Number
        if (isDigit.isNotEmpty())
            return currentCharacter

        //Is String
        return when {
            currentContent.contains("one") -> "1"
            currentContent.contains("two") -> "2"
            currentContent.contains("three") -> "3"
            currentContent.contains("four") -> "4"
            currentContent.contains("five") -> "5"
            currentContent.contains("six") -> "6"
            currentContent.contains("seven") -> "7"
            currentContent.contains("eight") -> "8"
            currentContent.contains("nine") -> "9"
            else -> ""
        }
    }
}