package com.example.lastshemajamebeli.domain.use_case

import com.example.lastshemajamebeli.data.models.ChatModelDto
import com.example.lastshemajamebeli.domain.ChatRepository
import retrofit2.Response
import javax.inject.Inject



class GetChatUseCase @Inject constructor(
    private val repository: ChatRepository
) {
    suspend fun getTeams(): Response<List<ChatModelDto.ChatModelDtoItem>>{
        return repository.getUsers()
    }
}