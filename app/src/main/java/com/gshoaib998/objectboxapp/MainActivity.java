package com.gshoaib998.objectboxapp;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.gshoaib998.objectboxapp.databinding.ActivityMainBinding;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

public class MainActivity extends AppCompatActivity implements NoteContract.View {
    ActivityMainBinding binding;
    FastAdapter<NoteBinding> fastAdapter;
    ItemAdapter<NoteBinding> itemAdapter;
    NotePresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        presenter=new NotePresenter(this);
        itemAdapter=new ItemAdapter<>();
        fastAdapter=FastAdapter.with(itemAdapter);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerview.setAdapter(fastAdapter);
        presenter.loadNotes();

        binding.edText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_DONE||event != null && event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER){
                    String text= Objects.requireNonNull(binding.edText.getText()).toString().trim();
                    if(!text.isEmpty()) {
                        presenter.addNote(new Note(text));
                        binding.edText.setText("");
                    }
                    return true;
                }
                return false;
            }
        });
        fastAdapter.setOnClickListener(new Function4<View, IAdapter<NoteBinding>, NoteBinding, Integer, Boolean>() {
            @Override
            public Boolean invoke(View view, IAdapter<NoteBinding> noteBindingIAdapter, NoteBinding noteBinding, Integer integer) {
                presenter.deleteNote(noteBinding.getNote());
                return true;
            }
        });



    }

    @Override
    public void showNotes(List<Note> notes) {
        List <NoteBinding> noteBindings=getNoteBindings(notes);
        itemAdapter.set(noteBindings);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    private List<NoteBinding> getNoteBindings (List<Note> notes){
        List<NoteBinding> noteBindings=new ArrayList<>();
        for(Note note:notes){
            noteBindings.add(new NoteBinding(note));
        }
        return noteBindings;
    }
}