package io.github.dolphin2410.minenote.sheet;

import io.github.dolphin2410.minenote.note.NoteElement;

import java.util.ArrayList;

public class Sheet {
    private final ArrayList<NoteElement> notes = new ArrayList<>();

    public ArrayList<NoteElement> getNotes() {
        return notes;
    }

    public void addNote(NoteElement note) {
        this.notes.add(note);
    }
}