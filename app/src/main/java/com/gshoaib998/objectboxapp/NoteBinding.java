package com.gshoaib998.objectboxapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gshoaib998.objectboxapp.databinding.ItemNoteViewBinding;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;

import java.util.List;

public class NoteBinding extends AbstractBindingItem<ItemNoteViewBinding> {
    private Note note;
    public NoteBinding(Note note ){
        this.note=note;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    @NonNull
    @Override
    public ItemNoteViewBinding createBinding(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        return ItemNoteViewBinding.inflate(layoutInflater,viewGroup,false);
    }

    @Override
    public int getType() {
        return R.id.main_layout;
    }

    @Override
    public void bindView(@NonNull ItemNoteViewBinding binding, @NonNull List<?> payloads) {
        super.bindView(binding, payloads);
        binding.setNote(note);

    }

    @Override
    public void unbindView(@NonNull ItemNoteViewBinding binding) {
        super.unbindView(binding);
        binding.setNote(null);
    }
}
