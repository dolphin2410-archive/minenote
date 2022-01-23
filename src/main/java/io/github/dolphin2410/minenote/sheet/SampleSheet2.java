package io.github.dolphin2410.minenote.sheet;

import io.github.dolphin2410.minenote.note.NoteBreak;
import io.github.dolphin2410.minenote.note.NoteDuration;
import io.github.dolphin2410.minenote.note.NoteMusic;
import io.github.dolphin2410.minenote.note.NoteType;

public class SampleSheet2 {
    public static Sheet create() {
        Sheet sheet = new Sheet();

        sheet.addNote(new NoteMusic(1, NoteType.C, NoteDuration.TICK_4));
        sheet.addNote(new NoteBreak(NoteDuration.TICK_4));
        sheet.addNote(new NoteMusic(1, NoteType.A_SHARP, NoteDuration.TICK_4));
        sheet.addNote(new NoteBreak(NoteDuration.TICK_4));

        sheet.addNote(new NoteMusic(1, NoteType.A, NoteDuration.TICK_2));
        sheet.addNote(new NoteMusic(1, NoteType.C, NoteDuration.TICK_2));
        sheet.addNote(new NoteMusic(1, NoteType.A, NoteDuration.TICK_2));
        sheet.addNote(new NoteMusic(1, NoteType.G_SHARP, NoteDuration.TICK_4));
        sheet.addNote(new NoteMusic(1, NoteType.G, NoteDuration.TICK_2));
        sheet.addNote(new NoteMusic(0, NoteType.F, NoteDuration.TICK_4));

        return sheet;
    }
}
