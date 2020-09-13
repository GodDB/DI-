package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.myapplication.UseCase.UserUseCaseImpl
import com.example.myapplication.databinding.ActivityMainBinding
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var vm : MainViewModel

    lateinit var dataBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val component = DaggerLoginComponent.builder()
            .loginModule(LoginModule(this))
            .build()
        component.inject(this)

        dataBinding.vm = vm
        dataBinding.lifecycleOwner = this
    }
}