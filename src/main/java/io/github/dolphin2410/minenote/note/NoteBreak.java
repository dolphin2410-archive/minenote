package io.github.dolphin2410.minenote.note;

public class NoteBreak implements NoteElement {
    private final NoteDuration duration;
    public NoteBreak(NoteDuration duration) {
        this.duration = duration;
    }

    @Override
    public boolean isKey() {
        return false;
    }

    @Override
    public NoteDuration getDuration() {
        return duration;
    }

    @Override
    public int getCode() {
        return 0;
    }

    public static NoteBreak ofCode(int code, NoteDuration duration) throws InvalidNoteType {
        if (code == 25) {
            return new NoteBreak(duration);
        } else {
            throw new InvalidNoteType("Invalid NoteBreak code");
        }
    }
}
