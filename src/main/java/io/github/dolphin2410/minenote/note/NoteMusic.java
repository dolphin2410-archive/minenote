package io.github.dolphin2410.minenote.note;

import org.bukkit.Note;

public class NoteMusic implements NoteElement {
    private final int octave;
    private final NoteType type;
    private final NoteDuration duration;

    public NoteMusic(int octave, NoteType type, NoteDuration duration) {
        this.octave = octave;
        this.type = type;
        this.duration = duration;
    }

    public static NoteMusic ofCode(int code, NoteDuration duration) throws InvalidNoteType {
        return new NoteMusic(code / 12, NoteType.ofCode(code % 12), duration);
    }

    @Override
    public int getCode() {
        return this.octave * 12 + this.type.getCode();
    }

    @Override
    public boolean isKey() {
        return true;
    }

    @Override
    public NoteDuration getDuration() {
        return duration;
    }

    public Note unwrap() {
        if (type.isSharp()) {
            return Note.sharp(octave, type.unwrap());
        } else {
            return Note.natural(octave, type.unwrap());
        }
    }
}