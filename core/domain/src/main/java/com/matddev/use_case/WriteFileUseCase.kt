package com.matddev.use_case

import com.matddev.repository.FileRepository

class WriteFileUseCase(
    private val repository: FileRepository,
    private val lines: List<String>
) {
    operator fun invoke(lines: List<String>) = repository.write(lines)
}