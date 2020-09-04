package `in`.nitin.supersub.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

private val pattern = "(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*"
fun String.toVideoId(): String {
    val compiledPattern: Pattern = Pattern.compile(pattern)
    val matcher: Matcher = compiledPattern.matcher(this)

    if (matcher.find()) {
        return matcher.group()
    }
    return "gusv3BsHd3g"
}