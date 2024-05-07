package com.matddev.utils

import com.matddev.RepoConstants

fun decideImageTec(language: String): String {
    return when (language) {
        "TypeScript" -> RepoConstants.TYPESCPRIPT
        "JavaScript" -> RepoConstants.JAVASCRIPT
        "Java" -> RepoConstants.JAVA
        "Kotlin" -> RepoConstants.KOTLIN
        "HTML" -> RepoConstants.HTML
        else -> RepoConstants.DEFAULT
    }
}
