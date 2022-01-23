package io.github.dolphin2410.minenote.note;

/**
 * NoteElement Registry
 *
 * @author dolphin2410
 */
public class NoteElements {
    public static NoteElement ofCode(int code, NoteDuration duration) throws InvalidNoteType {
        NoteElement element;

        try {
            element = NoteMusic.ofCode(code, duration);
        } catch (InvalidNoteType e) {
            try {
                element = NoteBreak.ofCode(code, duration);
            } catch (InvalidNoteType ex) {
                throw new InvalidNoteType("Invalid NoteElement code: " + code);
            }
        }

        return element;
    }
}
