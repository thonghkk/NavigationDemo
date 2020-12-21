package com.example.navigation2.NoteVoca

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation2.R
import java.util.ArrayList

class CustomAdapter(mCxt: Context, private val model: ArrayList<ModelVoca>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    val mCxt = mCxt


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_voca,parent,false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val customer : ModelVoca = model[position]
        holder.txtInput.text = customer.input
        holder.txtOutput.text = customer.output

        //custom event delete
        holder.btnDelete.setOnClickListener {
            val customName : String = customer.output
            var alertDialog: AlertDialog = AlertDialog.Builder(mCxt)
                .setTitle("Warning")
                .setMessage("Are you sure to delete: $customName ?")
                .setPositiveButton("yes", DialogInterface.OnClickListener { dialog, which ->
                    if (MainNote.dbHandler.deleteVocabulary(customer.output)) {
                        model.removeAt(position)
                        notifyItemRemoved(position)
                        notifyItemRangeChanged(position, model.size)
                        Toast.makeText(mCxt, "Customer $customName Deleted", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(mCxt, "Error Deleting", Toast.LENGTH_SHORT).show()
                    }

                })
                .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->  })
                .setIcon(R.drawable.ic_warning)
                .show()
        }

        //custom event update

        holder.btnEdit.setOnClickListener {
            val inflate: LayoutInflater = LayoutInflater.from(mCxt)
            val view : View = inflate.inflate(R.layout.update_voca,null)

            val txtCustomInput: TextView = view.findViewById(R.id.updateInput)
            val txtCustomOutput: TextView = view.findViewById(R.id.updateOutput)

            txtCustomInput.text = customer.input
            txtCustomOutput.text = customer.output

            val builder : AlertDialog.Builder = AlertDialog.Builder(mCxt)
                .setTitle("Update Vocabulary info")
                .setView(view)
                .setPositiveButton("Update", DialogInterface.OnClickListener { dialog, which ->
                    val isUpdate:Boolean = MainNote.dbHandler.updateVocabulary(
                        customer.output,
                        txtCustomInput.text.toString(),
                        txtCustomOutput.text.toString())
                    if(isUpdate==true){
                        model[position].input = txtCustomInput.text.toString()
                        model[position].output = txtCustomOutput.text.toString()
                        notifyDataSetChanged()
                        Toast.makeText(mCxt,"Update Successfull", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(mCxt,"Error Updating", Toast.LENGTH_SHORT).show()
                    }
                }).setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->  })
            val alert: AlertDialog = builder.create()
            alert.show()
        }
    }

    override fun getItemCount() = model.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {

        val txtInput = itemView.findViewById<TextView>(R.id.txtInput)
        val txtOutput = itemView.findViewById<TextView>(R.id.txtOutput)
        val btnEdit = itemView.findViewById<ImageButton>(R.id.btn_edit)
        val btnDelete = itemView.findViewById<ImageButton>(R.id.btn_delete)

    }

}