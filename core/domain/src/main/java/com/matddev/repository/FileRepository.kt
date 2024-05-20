package com.matddev.repository

import android.content.Context


interface FileRepository {
    fun write(lines: List<String>, context: Context)
    fun load(path:String, fileName: String): List<String>
    fun loadAllFileNames(context: Context): Array<String>
}