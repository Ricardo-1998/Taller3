package com.example.monedas.data

import android.provider.BaseColumns

object DatabaseContract {
    object MonedaEntry : BaseColumns{
        const val TABLE_NAME = "moneda"

        const val COLUMN_NAME = "name"
        const val COLUMN_COUNTRY = "country"
        const val COLUMN_VALUE = "value"
        const val COLUMN_VALUE_US = "value_us"
        const val COLUMN_REVIEW = "review"
        const val COLUMN_AVAILABLE = "isAvailable"
        const val COLUMN_IMG = "img"
    }
}