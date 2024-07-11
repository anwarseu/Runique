package me.dotcode.auth.domain

import me.dotcode.core.domain.util.DataError
import me.dotcode.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}