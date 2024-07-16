package me.dotcode.core.connectivity.data

import me.dotcode.core.connectivity.data.messaging.WearMessagingClient
import me.dotcode.core.connectivity.domain.NodeDiscovery
import me.dotcode.core.connectivity.domain.messaging.MessagingClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreConnectivityDataModule = module {
    singleOf(::WearMessagingClient).bind<MessagingClient>()
    singleOf(::WearNodeDiscovery).bind<NodeDiscovery>()
}