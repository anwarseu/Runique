package me.dotcode.run.presentation.run_overview.mapper

import me.dotcode.core.domain.run.Run
import me.dotcode.core.presentation.ui.formatted
import me.dotcode.core.presentation.ui.toFormattedHeartRate
import me.dotcode.core.presentation.ui.toFormattedKm
import me.dotcode.core.presentation.ui.toFormattedKmh
import me.dotcode.core.presentation.ui.toFormattedMeters
import me.dotcode.core.presentation.ui.toFormattedPace
import me.dotcode.run.presentation.run_overview.model.RunUi
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun Run.toRunUi(): RunUi {
    val dateTimeInLocalTime = dateTimeUtc
        .withZoneSameInstant(ZoneId.systemDefault())
    val formattedDateTime = DateTimeFormatter
        .ofPattern("MMM dd, yyyy - hh:mma")
        .format(dateTimeInLocalTime)

    val distanceKm = distanceMeters / 1000.0

    return RunUi(
        id = id!!,
        duration = duration.formatted(),
        dateTime = formattedDateTime,
        distance = distanceKm.toFormattedKm(),
        avgSpeed = avgSpeedKmh.toFormattedKmh(),
        maxSpeed = maxSpeedKmh.toFormattedKmh(),
        pace = duration.toFormattedPace(distanceKm),
        totalElevation = totalElevationMeters.toFormattedMeters(),
        mapPictureUrl = mapPictureUrl,
        avgHeartRate = avgHeartRate.toFormattedHeartRate(),
        maxHeartRate = maxHeartRate.toFormattedHeartRate()
    )
}