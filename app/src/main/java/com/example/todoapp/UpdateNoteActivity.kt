package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.example.todoapp.databinding.ActivityUpdateNoteBinding

class UpdateNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateNoteBinding
    private lateinit var db:NoteDatabaseHelper
    private var noteId: Int=-1


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db=NoteDatabaseHelper(this)

        noteId=intent.getIntExtra("note_id",-1)
        if(noteId==-1){

            finish()
            return
        }

        val note=db.getNoteById(noteId)
        binding.updatetitle.setText(note.title)
        binding.updatedescription.setText(note.content)


        binding.updateButton.setOnClickListener{

            val newTitle=binding.updatetitle.text.toString()
            val newContent=binding.updatedescription.text.toString()
            val updateNote=Note(noteId,newTitle,newContent)

            db.updateNote(updateNote)

            finish()
            Toast.makeText(this, "changes saved", Toast.LENGTH_SHORT).show()
        }

    }
}