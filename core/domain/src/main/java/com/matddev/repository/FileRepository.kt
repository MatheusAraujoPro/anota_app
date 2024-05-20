package com.matddev.repository


interface FileRepository {
    fun write(lines: List<String>)
    fun load(path:String, fileName: String): List<String>
}