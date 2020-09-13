package com.example.myapplication

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.DB.UserDataBase
import com.example.myapplication.Repository.UserRepositoryImpl
import com.example.myapplication.UseCase.UserUseCaseImpl
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Component(modules = [LoginModule::class])
interface LoginComponent {
    fun inject(Activity : MainActivity)
}

@Module
class LoginModule(val context: Context){
    @Provides
    fun provideDB() : UserDataBase{
        return Room.databaseBuilder(context, UserDataBase::class.java, "user.db").build()
    }

    @Provides
    fun provideUserRepository(userDataBase: UserDataBase) : UserRepository{
        return UserRepositoryImpl(userDataBase)
    }

    @Provides
    fun provideUserUseCase(userRepository: UserRepository) : UserUseCase{
        return UserUseCaseImpl(userRepository)
    }

    @Provides
    fun provideUserViewModel(userUseCase: UserUseCase) : MainViewModel{
        return MainViewModel(userUseCase)

    }
}