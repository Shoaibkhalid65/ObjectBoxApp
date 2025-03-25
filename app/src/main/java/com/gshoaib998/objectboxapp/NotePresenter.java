package com.gshoaib998.objectboxapp;

import java.util.List;

public class NotePresenter implements NoteContract.Presenter {
    NoteContract.View view;
    NoteRepository noteRepository;
    public NotePresenter(NoteContract.View view){
        this.view=view;
        noteRepository=new NoteRepository();
    }

    @Override
    public void loadNotes() {
        List<Note> notes=noteRepository.getAllNotes();
        view.showNotes(notes);
    }

    @Override
    public void addNote(Note note) {
        if(note.getText().isEmpty()){
            view.showMessage("Text should not be empty");
        }else {
            noteRepository.addNote(note);
            view.showMessage("Note added successfully");
            loadNotes();
        }
    }

    @Override
    public void deleteNote(Note note) {
       noteRepository.deleteNote(note);
       view.showMessage("Note deleted!");
       loadNotes();
    }


}
