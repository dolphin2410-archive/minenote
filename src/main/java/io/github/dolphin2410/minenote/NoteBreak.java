package io.github.dolphin2410.minenote;

public class NoteBreak implements NoteElement {
    @Override
    public boolean isKey() {
        return false;
    }

    @Override
    public int getCode() {
        return 0;
    }
}
