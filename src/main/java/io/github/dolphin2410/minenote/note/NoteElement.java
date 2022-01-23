package io.github.dolphin2410.minenote.note;

/**
 * NoteElement Interface
 *
 * @author dolphin2410
 */
public interface NoteElement {
    int getCode();
    boolean isKey();
    NoteDuration getDuration();
}
