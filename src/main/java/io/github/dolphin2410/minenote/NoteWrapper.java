package io.github.dolphin2410.minenote;

public class NoteWrapper implements NoteElement {
    private final int octave;
    private final NoteType type;

    public NoteWrapper(int octave, NoteType type) {
        this.octave = octave;
        this.type = type;
    }

    public static NoteWrapper ofCode(int code) {
        return new NoteWrapper(code / 12, NoteType.ofCode(code % 12));
    }

    @Override
    public int getCode() {
        return this.octave * 12 + this.type.getCode();
    }

    @Override
    public boolean isKey() {
        return true;
    }
}