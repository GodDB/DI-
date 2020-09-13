package com.example.myapplication.Repository

import com.example.myapplication.DB.UserDataBase
import com.example.myapplication.DB.UserEntity
import com.example.myapplication.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(var db : UserDataBase): UserRepository {


    override suspend fun getUserToken() {

    }

    override suspend fun setUserInfo(id : String, pw : String) {
        db.userDao().setUser(UserEntity(id, pw))
    }

    override suspend fun checkUserInfo() {
    }
}