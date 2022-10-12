package com.example.lastshemajamebeli.network

import com.example.lastshemajamebeli.data.models.ChatModelDto
import retrofit2.Response
import retrofit2.http.GET

// using
interface ChatApi {
    @GET("80d25aee-d9a6-4e9c-b1d1-80d2a7c979bf")
    suspend fun getChat(
    ): Response<List<ChatModelDto.ChatModelDtoItem>>

}