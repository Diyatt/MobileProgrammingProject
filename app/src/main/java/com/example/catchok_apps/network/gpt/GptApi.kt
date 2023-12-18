package com.example.catchok_apps.network.gpt

import com.example.catchok_apps.repository.gpt.model.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST



interface GptApi {
    @POST("chat/completions")
    suspend fun getPrompt(
        @Body requestBody: RequestBody,
        ): Response<ChatResponse>
}
