package com.gshoaib998.objectboxapp;

import java.util.List;

import io.objectbox.Box;

public class NoteRepository {
    private final Box<Note> noteBox;
    public NoteRepository(){
        noteBox=ObjectBox.get().boxFor(Note.class);
    }
    public List<Note> getAllNotes(){
        return noteBox.getAll();
    }
    public void addNote(Note note){
        noteBox.put(note);
    }
    public void deleteNote(Note note){
        noteBox.remove(note);
    }


}
