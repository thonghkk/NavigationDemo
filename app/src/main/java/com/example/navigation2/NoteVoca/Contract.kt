package com.example.navigation2.NoteVoca

import android.provider.BaseColumns

object Contract {
    class VocaTable: BaseColumns {
        companion object{
            val TABLE_NAME2 ="my_note"
            val COLUMS_INPUT = "_text_input"
            val COLUMS_OUTPUT = "_text_output"

        }
    }

}