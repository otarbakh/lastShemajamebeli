package com.example.lastshemajamebeli.data

import com.example.lastshemajamebeli.data.models.ChatModelDto
import com.example.lastshemajamebeli.domain.ChatRepository
import com.example.lastshemajamebeli.network.ChatApi
import retrofit2.Response
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val api: ChatApi
) : ChatRepository {
    override suspend fun getUsers(): Response<List<ChatModelDto.ChatModelDtoItem>> {
        return api.getChat()
    }


}