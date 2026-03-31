package com.example.bookinf.SDUI

import android.app.Application
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookinf.data.Room
import com.example.bookinf.data.rememberRooms
import com.example.bookinf.ui.AppButton
import com.example.bookinf.ui.Banner
import com.example.bookinf.ui.FilterBar
import com.example.bookinf.ui.Header
import com.example.bookinf.ui.MessageBlock
import com.example.bookinf.ui.PropertiesCountRow
import com.example.bookinf.ui.QualityRatingBlock
import com.example.bookinf.ui.RoomCard
import com.example.bookinf.ui.SearchBar
import com.example.bookinf.ui.theme.size.CardSizes
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.core.content.edit

class VMod(application: Application): AndroidViewModel(application) {
    private val PREFS_NAME = "BookingRoomsPrefs"
    private val KEYDATA = "data"
    private val InitialJsonNAME = "Initialjson1.json"
    private val sharedPreferences =
        application.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    private var defaultJson:String
    var data by mutableStateOf<List<UiItemDto>>(emptyList())
        private set
    init {
        defaultJson = loadJsonFromAssets(
            context = application,
            fileName = InitialJsonNAME
        )
        LoadDataAsync()
    }
    fun LoadDataAsync() {
        viewModelScope.launch(Dispatchers.IO) {
            val jsonString = sharedPreferences.getString(KEYDATA, null)
            val finalJson = jsonString ?: try {
                loadJsonFromAssets(getApplication(), InitialJsonNAME)
            } catch (e: Exception) {
                "[]"
            }

            val loadedList = try {
                Parser.deserialize(finalJson)
            } catch (e: Exception) {
                emptyList()
            }

            withContext(Dispatchers.Main) {
                data = loadedList
            }
        }
    }
    fun loadJsonFromAssets(context: Context, fileName: String): String {
        return context.assets.open(fileName)
            .bufferedReader()
            .use { it.readText() }
    }
    fun SaveDataAsync() {
        viewModelScope.launch(Dispatchers.IO) {
            val jsonString = Parser.serialize(data)
            sharedPreferences.edit(commit = true) {
                putString(KEYDATA, jsonString)
            }
        }
    }
}
/*(UiItemDto.kt)
создаю класс, который будет содержать:
тип + контент
*/

/*
Функция, которая будет отрисовывать компоненты. Принимает список UiItemDto
и вызывает их контент.
*/

@Composable
fun DrawComposableScreen(uiData: List<UiItemDto>) {
    val rooms = rememberRooms()
    
    uiData.forEach { item ->
        when (item.type.uppercase()) {
            "MESSAGE_BLOCK" -> {
                MessageBlock(
                    text = item.data?.getValue("text")?.toString() ?: ""
                )
            }
            "PROPERTIES_COUNT" -> {
                val countValue = item.data?.getValue("count")
                val count = when (countValue) {
                    is Number -> countValue.toInt()
                    is String -> countValue.toDoubleOrNull()?.toInt() ?: 0
                    else -> 0
                }
                PropertiesCountRow(count = count)
            }
            "QUALITY_RATING" -> {
                QualityRatingBlock()
            }
            "ROOM_CARDS" -> {
                rooms.forEach { room -> RoomCard(room, sizes = CardSizes) }
            }
            "ROOM_CARD" -> {
                SDUIRoomCard(item, rooms)
            }
            "BANNER" -> {
                Banner(text = item.data?.getValue("text")?.toString() ?: "")
            }
            "HEADER" -> {
                Header(text = item.data?.getValue("text")?.toString() ?: "")
            }
            "BUTTON" -> {
                AppButton(text = item.data?.getValue("text")?.toString() ?: "")
            }
            "SEARCH_BAR" -> {
                SearchBar(text = item.data?.getValue("text")?.toString() ?: "")
            }
            "FILTER_BAR" -> {
                FilterBar(text = item.data?.getValue("text")?.toString() ?: "")
            }
            else -> {}
        }
    }
}

@Composable
private fun SDUIRoomCard(
    item: UiItemDto,
    rooms: List<Room>
) {

    val roomIdValue = item.data?.getValue("ID")
    val roomId = when (roomIdValue) {
        is Number -> roomIdValue.toInt().toString()
        else -> roomIdValue?.toString()
    }
    val room = rooms.find { it.id.toString() == roomId }
    if (room == null) {
        MessageBlock(text = "Room not found")
    } else {
        RoomCard(
            room,
            sizes = CardSizes,//TODO(перенести в тему.)
        )
    }
}

object Parser {
    private val gson = Gson()
    fun serialize(source: List<UiItemDto>): String = gson.toJson(source)

    fun deserialize(json: String): List<UiItemDto> {
        val type = object : TypeToken<List<UiItemDto>>() {}.type
        return gson.fromJson(json, type)
    }
}
