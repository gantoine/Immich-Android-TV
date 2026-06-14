package nl.giejay.android.tv.immich.weather

import com.google.gson.annotations.SerializedName

/** Open-Meteo geocoding response (city name -> coordinates). */
data class GeocodingResponse(val results: List<GeoResult>?)

data class GeoResult(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val country: String?,
    val admin1: String?
)

/** Open-Meteo forecast response. */
data class ForecastResponse(val current: CurrentWeather?, val daily: DailyWeather?)

data class CurrentWeather(
    @SerializedName("temperature_2m") val temperature: Double,
    @SerializedName("weather_code") val weatherCode: Int
)

data class DailyWeather(
    val time: List<String>,
    @SerializedName("weather_code") val weatherCode: List<Int>,
    @SerializedName("temperature_2m_max") val tempMax: List<Double>,
    @SerializedName("temperature_2m_min") val tempMin: List<Double>
)

/** Domain model handed to the UI. */
data class Weather(
    val locationName: String,
    val currentTemp: Int,
    val currentCode: Int,
    val unitSymbol: String,
    val days: List<DailyForecast>
)

data class DailyForecast(
    val date: String, // ISO yyyy-MM-dd
    val code: Int,
    val high: Int,
    val low: Int
)
