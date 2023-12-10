package utils

class Utils {
    fun readInputFile(fileName: String): String {
        return this::class.java.classLoader.getResource(fileName)?.readText() ?: ""
    }


}