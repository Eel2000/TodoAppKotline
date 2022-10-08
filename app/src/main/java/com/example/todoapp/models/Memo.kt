package com.example.todoapp.models

import java.util.Date
import java.util.UUID

data class Memo(
    var id: UUID,
    var title: String,
    var content: String,
    var date: Date
)
