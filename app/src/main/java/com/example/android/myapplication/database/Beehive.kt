package com.example.android.myapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "beehive_table")
data class Beehive(
    @PrimaryKey(autoGenerate = true)
    var beehiveId: Long = 0L,

    @ColumnInfo(name = "beehive_name")
    var beehiveName: String = "-",

    @ColumnInfo(name = "queen_bee_age")
    var queenBeeAge: Int = 0,

    @ColumnInfo(name = "queen_bee_state")
    var queenBeeState: Int = 0,

    @ColumnInfo(name = "beehive_population")
    var BeehivePopulation: Int = 0,

    @ColumnInfo(name = "last_management")
    var lastManagement: String = "-",

    @ColumnInfo(name = "fias_frame_number")
    var fiasFrameNumber: Int = 0,

    @ColumnInfo(name = "fias_frame")
    var fiasFrame: Int = 0,

    @ColumnInfo(name = "mezes_frame_number")
    var mezesFrameNumber: Int = 0,

    @ColumnInfo(name = "mezes_frame")
    var mezesFrame: Int = 0,

    @ColumnInfo(name = "noszema")
    var noszema: Int = 0,

    @ColumnInfo(name = "meszesedes")
    var meszesedes: Int = 0,

    @ColumnInfo(name = "group_id")
    var groupId: Long = 0L
)
