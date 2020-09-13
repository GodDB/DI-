package com.example.myapplication

import com.example.myapplication.DB.UserEntity

interface UserRepository {
    suspend fun getUserToken()
    suspend fun setUserInfo(id : String, pw:String)
    suspend fun checkUserInfo()
}

interface UserUseCase{
    fun login(userEntity: UserEntity)
    fun signUp()
}