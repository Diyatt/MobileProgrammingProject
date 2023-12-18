package com.example.catchok_apps.repository.gpt

import androidx.lifecycle.LiveData
import com.example.catchok_apps.repository.gpt.model.ChatResponse
import com.example.catchok_apps.repository.gpt.model.Choice
import com.example.catchok_apps.repository.gpt.model.RequestBody

interface GptRepository {

    suspend fun getPrompt(question:String):ChatResponse?

    val choiceLiveData: LiveData<Choice>?
}