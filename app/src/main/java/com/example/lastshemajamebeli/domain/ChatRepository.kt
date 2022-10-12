package com.example.lastshemajamebeli.domain

import com.example.lastshemajamebeli.data.models.ChatModelDto
import retrofit2.Response

interface ChatRepository {

    suspend fun getUsers(): Response<List<ChatModelDto.ChatModelDtoItem>>

}