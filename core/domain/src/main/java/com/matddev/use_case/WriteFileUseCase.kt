package com.matddev.use_case

import android.content.Context
import com.matddev.repository.FileRepository

class WriteFileUseCase(
    private val repository: FileRepository,
) {
    operator fun invoke(lines: List<String>, context: Context) =
        repository.write(lines = lines, context = context)
}