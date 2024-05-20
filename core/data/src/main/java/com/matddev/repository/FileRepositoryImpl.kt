package com.matddev.repository

import android.content.Context
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class FileRepositoryImpl : FileRepository {
    override fun write(lines: List<String>, context: Context) {
        val fileDir = context.filesDir
        val file = File(fileDir.path)
        val fileWriter = FileWriter(file)
        val bufferedWriter = BufferedWriter(fileWriter)

        lines.forEachIndexed { index, line ->
            bufferedWriter.write(line)
            if (index != lines.lastIndex)
                bufferedWriter.newLine()
        }
        bufferedWriter.close()
    }

    override fun load(path: String, fileName: String): List<String> {
        val file = File(path, fileName)
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

    override fun loadAllFileNames(context: Context): Array<String> {
        return context.fileList()
    }
}