package com.example.lastshemajamebeli.data.models


import com.google.gson.annotations.SerializedName

data class ChatModelDto(
    val chatModelDtoItem: ChatModelDtoItem
){
    data class ChatModelDtoItem(
        @SerializedName("avatar")
        val avatar: String = "",
        @SerializedName("email")
        val email: String = "",
        @SerializedName("first_name")
        val firstName: String = "",
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("is_typing")
        val isTyping: Boolean = false,
        @SerializedName("last_message")
        val lastMessage: String? = "",
        @SerializedName("last_name")
        val lastName: String = "",
        @SerializedName("message_type")
        val messageType: String = "",
        @SerializedName("unrea_message")
        val unreaMessage: Int = 0,
        @SerializedName("updated_date")
        val updatedDate: Long? = 0
    )
}