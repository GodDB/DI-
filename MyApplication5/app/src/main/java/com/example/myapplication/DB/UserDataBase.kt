package com.example.myapplication.DB

import androidx.room.*


@Database(entities = [UserEntity::class], version = 1)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDao() : UserDao
}

@Dao
interface UserDao{
    @Query("select * from UserEntity")
    suspend fun getUserId() : UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setUser(userEntity: UserEntity)
}
@Entity
data class UserEntity(
    @PrimaryKey val userId : String,
    val userPassword : String
)