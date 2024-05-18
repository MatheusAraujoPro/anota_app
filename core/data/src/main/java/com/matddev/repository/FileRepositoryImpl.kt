package com.matddev.repository

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class FileRepositoryImpl : FileRepository {
    override fun write(lines: List<String>) {
        val file = File("path do file")
        val fileWriter = FileWriter(file)
        val bufferedWriter = BufferedWriter(fileWriter)

        lines.forEachIndexed { index, line ->
            bufferedWriter.write(line)
            if (index != lines.lastIndex)
                bufferedWriter.newLine()
        }
        bufferedWriter.close()
    }

    override fun read(): List<String> {
        val file = File("path of file", "fileName")
        val fileReader = FileReader(file)
        val bufferReader = BufferedReader(fileReader)
        var line: String?
        val lines = mutableListOf("")

        while (bufferReader.readLine().also { line = it } != null) {
            lines.add(line.orEmpty())
        }
        bufferReader.close()
        return lines
    }
}