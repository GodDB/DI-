package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.DB.UserEntity
import javax.inject.Inject


class MainViewModel@Inject constructor(var userUseCase: UserUseCase){


    val userId = MutableLiveData<String>()
    val userPw = MutableLiveData<String>()

    fun onClick(){
        userUseCase.login(UserEntity(userId.value!!, userPw.value!!))
    }
}