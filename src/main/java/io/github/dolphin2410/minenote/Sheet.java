package io.github.dolphin2410.minenote;

import java.util.ArrayList;

public class Sheet {
    private final ArrayList<NoteWrapper> notes = new ArrayList<>();

    public ArrayList<NoteWrapper> getNotes() {
        return notes;
    }
}
