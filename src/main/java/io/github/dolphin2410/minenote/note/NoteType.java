package io.github.dolphin2410.minenote.note;

import org.bukkit.Note;

import java.util.Arrays;
import java.util.Optional;

/**
 * Type of musical notes
 *
 * @author dolphin2410
 */
public enum NoteType {
    F_SHARP(0, true, Note.Tone.F),
    G(1, false, Note.Tone.G),
    G_SHARP(2, true, Note.Tone.G),
    A(3, false, Note.Tone.A),
    A_SHARP(4, true, Note.Tone.A),
    B(5, false, Note.Tone.B),
    C(6, false, Note.Tone.C),
    C_SHARP(7, true, Note.Tone.C),
    D(8, false, Note.Tone.D),
    D_SHARP(9, true, Note.Tone.D),
    E(10, false, Note.Tone.E),
    F(11, false, Note.Tone.F);

    private final int code;
    private final boolean isSharp;
    private final Note.Tone tone;

    NoteType(int code, boolean isSharp, Note.Tone tone) {
        this.code = code;
        this.isSharp = isSharp;
        this.tone = tone;
    }

    public static NoteType ofCode(int code) throws InvalidNoteType {
        Optional<NoteType> optional =  Arrays.stream(NoteType.values())
                .filter(x -> x.code == code)
                .findFirst();

        if (optional.isEmpty())
            throw new InvalidNoteType("Invalid NoteType code");

        return optional.get();
    }

    public int getCode() {
        return code;
    }

    public boolean isSharp() {
        return isSharp;
    }

    public Note.Tone unwrap() {
        return tone;
    }
}
