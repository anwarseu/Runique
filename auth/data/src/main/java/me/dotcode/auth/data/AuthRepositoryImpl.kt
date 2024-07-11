package me.dotcode.auth.data

import io.ktor.client.HttpClient
import me.dotcode.auth.domain.AuthRepository
import me.dotcode.core.data.networking.post
import me.dotcode.core.domain.AuthInfo
import me.dotcode.core.domain.SessionStorage
import me.dotcode.core.domain.util.DataError
import me.dotcode.core.domain.util.EmptyResult
import me.dotcode.core.domain.util.Result
import me.dotcode.core.domain.util.asEmptyDataResult

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
): AuthRepository {

    override suspend fun login(email: String, password: String): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/login",
            body = LoginRequest(
                email = email,
                password = password
            )
        )
        if(result is Result.Success) {
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }
        return result.asEmptyDataResult()
    }

    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}