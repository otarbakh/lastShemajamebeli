package com.example.lastshemajamebeli.di

import com.example.lastshemajamebeli.data.ChatRepositoryImpl
import com.example.lastshemajamebeli.domain.ChatRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    @Singleton
    abstract fun provideChatRepo(repoImpl: ChatRepositoryImpl): ChatRepository

}