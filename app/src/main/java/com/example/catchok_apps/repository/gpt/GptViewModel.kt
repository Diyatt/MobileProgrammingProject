package com.example.catchok_apps.repository.gpt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.catchok_apps.base.BaseViewModel
import com.example.catchok_apps.repository.gpt.model.ChatResponse
import com.example.catchok_apps.repository.gpt.model.RequestBody
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class GptViewModel @Inject constructor(
    private val repository: GptRepositoryImpl
):BaseViewModel(){
    private var _chatResponseLiveData = MutableLiveData<ChatResponse?>()
    var chatResponseLiveData:LiveData<ChatResponse?> = _chatResponseLiveData
    fun getPrompt(question: String){
        launch(
            request = {
                repository.getPrompt(question)
            },
            onSuccess = {
                _chatResponseLiveData.postValue(it)
            }
        )
    }
}



