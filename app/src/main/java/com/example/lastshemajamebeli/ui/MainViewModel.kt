package com.example.lastshemajamebeli.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lastshemajamebeli.Resource
import com.example.lastshemajamebeli.domain.use_case.GetChatUseCase
import com.example.lastshemajamebeli.data.models.ChatModelDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUseCase: GetChatUseCase,
) : ViewModel() {


    private val _info =
        MutableStateFlow<Resource<List<ChatModelDto.ChatModelDtoItem>>>(Resource.Loading(true))
    val info = _info.asStateFlow()

    fun setData(){
        viewModelScope.launch {
            _info.value = Resource.Loading(true)
            val response = getUseCase.getTeams()
            response.body()?.let {
                try {
                    if(response.isSuccessful){
                        _info.value = Resource.Success(it)
                    }else{
                        _info.value = Resource.Error(response.errorBody().toString())
                    }
                }catch (e:Throwable){
                    _info.value = Resource.Error("some error blin")
                }
            }
        }
    }

}