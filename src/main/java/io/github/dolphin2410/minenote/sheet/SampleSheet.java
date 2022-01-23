package io.github.dolphin2410.minenote.sheet;

import io.github.dolphin2410.minenote.note.NoteDuration;
import io.github.dolphin2410.minenote.note.NoteMusic;
import io.github.dolphin2410.minenote.note.NoteType;

public class SampleSheet {
    public static Sheet create() {
        Sheet sheet = new Sheet();

        sheet.addNote(new NoteMusic(1, NoteType.E, NoteDuration.of(3)));
        sheet.addNote(new NoteMusic(1, NoteType.D, NoteDuration.of(1)));
        sheet.addNote(new NoteMusic(1, NoteType.C, NoteDuration.of(2)));
        sheet.addNote(new NoteMusic(1, NoteType.D, NoteDuration.of(2)));

        sheet.addNote(new NoteMusic(1, NoteType.E, NoteDuration.of(2)));
        sheet.addNote(new NoteMusic(1, NoteType.E, NoteDuration.of(2)));
        sheet.addNote(new NoteMusic(1, NoteType.E, NoteDuration.of(4)));

        sheet.addNote(new NoteMusic(1, NoteType.D, NoteDuration.of(2)));
        sheet.addNote(new NoteMusic(1, NoteType.D, NoteDuration.of(2)));
        sheet.addNote(new NoteMusic(1, NoteType.D, NoteDuration.of(4)));

        sheet.addNote(new NoteMusic(1, NoteType.E, NoteDuration.of(2)));
        sheet.addNote(new NoteMusic(1, NoteType.E, NoteDuration.of(2)));
        sheet.addNote(new NoteMusic(1, NoteType.E, NoteDuration.of(4)));

        return sheet;
    }
}
