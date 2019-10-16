package com.tooflexdev.dokomaps.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tooflexdev.dokomaps.model.*
import com.tooflexdev.dokomaps.model.Properties
import java.util.*
import java.util.Collections.emptyList
import kotlin.collections.ArrayList


class Converters {
    @TypeConverter
    fun fromString(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromStringToArrayList(value: String): ArrayList<String> {
        val listType = object : TypeToken<ArrayList<String>>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromList(list: List<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

  /*  // Places related

    @TypeConverter
    fun storedStringToMyPlaces(data: String?): List<Place> {
        val gson = Gson()
        if (data == null) {
            return emptyList()
        }
        val listType = object : TypeToken<List<Place>>() {

        }.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun myPlacesToStoredString(myObjects: List<Place>): String {
        val gson = Gson()
        return gson.toJson(myObjects)
    }

    // End place related

    // Country Geo Json related

    @TypeConverter
    fun storedStringToMyCountryGeojson(data: String?): CountryGeojson {
        val gson = Gson()

        val type = object : TypeToken<CountryGeojson>() {

        }.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    fun myCountryGeojsonToStoredString(myObject: CountryGeojson): String {
        val gson = Gson()
        return gson.toJson(myObject)
    }

    // End Geo Json related

    // Geometry related

    @TypeConverter
    fun storedStringToMyGeometry(data: String?): Geometry {
        val gson = Gson()

        val type = object : TypeToken<Geometry>() {

        }.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    fun myGeometryToStoredString(myObject: Geometry): String {
        val gson = Gson()
        return gson.toJson(myObject)
    }

    // End Geometry related

    // Properties related

    @TypeConverter
    fun storedStringToMyProperties(data: String?): Properties {
        val gson = Gson()

        val type = object : TypeToken<Properties>() {

        }.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    fun myPropertiesToStoredString(myObject: Properties): String {
        val gson = Gson()
        return gson.toJson(myObject)
    }

    // End Properties related

    // Category related

    @TypeConverter
    fun storedStringToMyCategory(data: String?): List<Category> {
        val gson = Gson()
        if (data == null) {
            return emptyList()
        }
        val listType = object : TypeToken<List<Category>>() {

        }.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun myCategoryToStoredString(myObjects: List<Category>): String {
        val gson = Gson()
        return gson.toJson(myObjects)
    }

    // End Category related

    // Owner related

    @TypeConverter
    fun storedStringToMyOwner(data: String?): Owner {
        val gson = Gson()

        val type = object : TypeToken<Owner>() {

        }.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    fun myOwnerToStoredString(myObject: Owner): String {
        val gson = Gson()
        return gson.toJson(myObject)
    }

    // End Owner related*/

}