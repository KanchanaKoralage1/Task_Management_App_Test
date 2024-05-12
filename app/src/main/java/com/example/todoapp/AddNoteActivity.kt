package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todoapp.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {

    private  lateinit var binding:ActivityAddNoteBinding
    private lateinit var db:NoteDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddNoteBinding.inflate(layoutInflater)

        setContentView(binding.root)

        db= NoteDatabaseHelper(this)

        binding.saveButton.setOnClickListener{

            val title=binding.title.text.toString()
            val content=binding.description.text.toString()
            val note=Note(0,title, content)

            db.insertNote(note)
            finish()

            Toast.makeText(this,"note saved",Toast.LENGTH_SHORT).show()
        }
    }
}