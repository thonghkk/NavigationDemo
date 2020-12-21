package com.example.navigation2.NoteVoca

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import com.example.navigation2.NoteVoca.Contract.VocaTable.Companion.COLUMS_INPUT
import com.example.navigation2.NoteVoca.Contract.VocaTable.Companion.COLUMS_OUTPUT
import com.example.navigation2.NoteVoca.Contract.VocaTable.Companion.TABLE_NAME2
import java.lang.Exception

class DatabaseHelperVoca(private val context: Context) : SQLiteOpenHelper(context,
    DATABASE_NAME,null,DATABASE_VER) {

    companion object{

        //create sql
        val SQL_CREATE_NOTE :String = ("CREATE TABLE $TABLE_NAME2 ( $COLUMS_INPUT TEXT ," +
                " $COLUMS_OUTPUT TEXT)")
        val DROP_TABLE : String = ("DROP TABLE IF EXISTS $TABLE_NAME2")

        const val DATABASE_VER = 1;
        const val DATABASE_NAME = "vocabulary.db"

    }

    private var db : SQLiteDatabase? = null

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(SQL_CREATE_NOTE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL(DROP_TABLE)
        onCreate(db)
    }

    fun addNote2(input:String ,output:String){

        db = this.writableDatabase
        val cv = ContentValues().apply {
            put(COLUMS_INPUT,input)
            put(COLUMS_OUTPUT,output)
        }
        val n = db!!.insert(TABLE_NAME2,null,cv)
        if(n.toInt() == -1 ){
            Toast.makeText(context,"False", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context,"Vocabulary Added", Toast.LENGTH_SHORT).show()
        }

    }


    fun readAllData(context: Context) : ArrayList<ModelVoca>{
        val query = "SELECT * FROM $TABLE_NAME2"
        db = this.readableDatabase
        val models = ArrayList<ModelVoca>()
        //thuc hien lenh truy van voi cau lelnh select
        var cursor : Cursor? = db!!.rawQuery(query,null)
        if(cursor!!.count == 0){
            Toast.makeText(context,"No Vocabulary", Toast.LENGTH_SHORT).show()
            cursor.moveToFirst()
        } else {
            //cursor.isAfterLast()trả về truekhi con trỏ ở vị trí hàng cuối cùng.
            // Thêm !(not) có nghĩa là thực hiện cho đến khi nó không ở cuối con trỏ.
            while (!cursor.isAfterLast &&  cursor.moveToNext()){
                val model = ModelVoca()
                model.input = cursor.getString(cursor.getColumnIndex(COLUMS_INPUT))
                model.output = cursor.getString(cursor.getColumnIndex(COLUMS_OUTPUT))
                models.add(model)

            }
            Toast.makeText(context,"${cursor.count.toString()} Vocabulary", Toast.LENGTH_SHORT).show()
        }
        cursor.close()
        db!!.close()
        return models
    }

    fun deleteVocabulary(output: String):Boolean{
        val qry = "DELETE FROM $TABLE_NAME2 WHERE $COLUMS_OUTPUT = $output"
        val db: SQLiteDatabase = this.writableDatabase
        var result = false
        try {
            // val cursor:Unit = db.execSQL(qry)
            val cursor = db.delete(TABLE_NAME2,"$COLUMS_OUTPUT = ?", arrayOf(output))
            result = true
        }catch (e: Exception){
            Log.e(ContentValues.TAG,"Error Deleting")
        }
        db.close()
        return result

    }

    fun updateVocabulary(input: String, output: String, toString: String):Boolean{
        val db: SQLiteDatabase = this.writableDatabase
        val contentValue = ContentValues()
        var result : Boolean = false
        contentValue.apply {
            put(COLUMS_INPUT,input)
            put(COLUMS_OUTPUT,output)
        }
        try {
            db.update(TABLE_NAME2,contentValue,"$COLUMS_OUTPUT = ?", arrayOf(input))
            result = true
        } catch (e: Exception){
            Log.e(ContentValues.TAG,"Error Updating")
            result = false
        }
        return result
    }

}