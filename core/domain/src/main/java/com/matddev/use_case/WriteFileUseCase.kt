package com.matddev.use_case

import android.content.Context
import com.matddev.repository.FileRepository

class WriteFileUseCase(
    private val repository: FileRepository,
    private val lines: List<String>,
    private val context: Context
) {
    operator fun invoke() = repository.write(lines = lines, context = context)
}