package com.matddev.repository


interface FileRepository {
    fun write(lines: List<String>)
    fun read(): List<String>
}