package com.example.catchok_apps.repository.gpt

import androidx.lifecycle.LiveData

interface GptRepository {

    suspend fun getPrompt(question:String):ChatResponse?

    val choiceLiveData: LiveData<Choice>?
}