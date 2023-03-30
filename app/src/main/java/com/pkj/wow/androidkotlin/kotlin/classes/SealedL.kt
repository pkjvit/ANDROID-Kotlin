package com.pkj.wow.androidkotlin.kotlin.classes

import java.io.File
import javax.sql.DataSource

sealed interface Error

sealed class IOError(): Error

class FileReadError(val file: File): IOError()
class DatabaseError(val source: DataSource): IOError()

object RuntimeError : Error