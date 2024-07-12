package me.dotcode.core.domain.run

import me.dotcode.core.domain.util.DataError
import me.dotcode.core.domain.util.EmptyResult
import me.dotcode.core.domain.util.Result

interface RemoteRunDataSource {
    suspend fun getRuns(): Result<List<Run>, DataError.Network>
    suspend fun postRun(run: Run, mapPicture: ByteArray): Result<Run, DataError.Network>
    suspend fun deleteRun(id: String): EmptyResult<DataError.Network>
}