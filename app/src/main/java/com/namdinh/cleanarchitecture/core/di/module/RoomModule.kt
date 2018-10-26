package com.namdinh.cleanarchitecture.core.di.module

import android.app.Application
import androidx.room.Room
import com.namdinh.cleanarchitecture.core.di.scope.PerApplication
import com.namdinh.cleanarchitecture.data.local.room.GithubDb
import com.namdinh.cleanarchitecture.data.local.room.dao.RepoDao
import com.namdinh.cleanarchitecture.data.local.room.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RoomModule {
    @Provides
    @PerApplication
    @Named("room_name")
    internal fun provideRoomDbNameName(): String {
        return "clean_architecture_data.db"
    }

    @Provides
    @PerApplication
    fun provideDb(app: Application, @Named("room_name") roomName: String): GithubDb {
        return Room
                .databaseBuilder(app, GithubDb::class.java, roomName)
                .fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    @PerApplication
    fun provideUserDao(db: GithubDb): UserDao {
        return db.userDao()
    }

    @Provides
    @PerApplication
    fun provideRepoDao(db: GithubDb): RepoDao {
        return db.repoDao()
    }
}