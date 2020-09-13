package com.example.myapplication.UseCase

import com.example.myapplication.DB.UserEntity
import com.example.myapplication.UserRepository
import com.example.myapplication.UserUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserUseCaseImpl @Inject constructor(var userRepository : UserRepository) : UserUseCase{

    override fun login(userEntity: UserEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            userRepository.setUserInfo(userEntity.userId, userEntity.userPassword)
        }
    }

    override fun signUp() {

    }
}