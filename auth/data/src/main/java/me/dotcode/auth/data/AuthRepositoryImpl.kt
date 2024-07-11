package me.dotcode.auth.data

import io.ktor.client.HttpClient
import me.dotcode.auth.domain.AuthRepository
import me.dotcode.core.data.post
import me.dotcode.core.domain.util.DataError
import me.dotcode.core.domain.util.EmptyResult

class AuthRepositoryImpl(
    private val httpClient: HttpClient
): AuthRepository {
    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}