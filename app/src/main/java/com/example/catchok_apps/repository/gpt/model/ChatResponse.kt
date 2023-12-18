package com.example.catchok_apps.repository.gpt.model

import com.google.gson.annotations.SerializedName

data class ChatResponse(
    @SerializedName("created")
    val created: Long,
    @SerializedName("choices")
    val choices: List<Choice>,
)
