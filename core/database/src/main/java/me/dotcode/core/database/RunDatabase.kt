package me.dotcode.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import me.dotcode.core.database.dao.AnalyticsDao
import me.dotcode.core.database.dao.RunDao
import me.dotcode.core.database.dao.RunPendingSyncDao
import me.dotcode.core.database.entity.DeletedRunSyncEntity
import me.dotcode.core.database.entity.RunEntity
import me.dotcode.core.database.entity.RunPendingSyncEntity

@Database(
    entities = [
        RunEntity::class,
        RunPendingSyncEntity::class,
        DeletedRunSyncEntity::class
    ],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {

    abstract val runDao: RunDao
    abstract val runPendingSyncDao: RunPendingSyncDao
    abstract val analyticsDao: AnalyticsDao
}