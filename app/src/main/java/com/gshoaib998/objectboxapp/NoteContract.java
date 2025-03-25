package com.gshoaib998.objectboxapp;

import java.util.List;

public interface NoteContract {
     interface View{
        void showNotes(List<Note> notes);
        void showMessage(String message);
    }
    interface Presenter{
         void loadNotes();
         void addNote(Note note);
         void deleteNote(Note note);
    }

}
