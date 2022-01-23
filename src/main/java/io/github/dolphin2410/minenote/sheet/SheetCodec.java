package io.github.dolphin2410.minenote.sheet;

import io.github.dolphin2410.minenote.note.InvalidNoteType;
import io.github.dolphin2410.minenote.note.NoteDuration;
import io.github.dolphin2410.minenote.note.NoteElement;
import io.github.dolphin2410.minenote.note.NoteElements;

import java.io.*;

public class SheetCodec {
    public static void serialize(OutputStream dest, Sheet sheet) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(dest);

        for (NoteElement note : sheet.getNotes()) {
            dataOutputStream.writeByte(note.getCode());
            dataOutputStream.writeByte(note.getDuration().getTicks());
        }

        dataOutputStream.flush();
    }

    public static ByteArrayOutputStream serialize(Sheet sheet) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        serialize(outputStream, sheet);
        return outputStream;
    }

    public static Sheet deserialize(InputStream stream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(stream);
        Sheet sheet = new Sheet();

        int code;
        int duration;
        while ((code = dataInputStream.readByte()) != 0 && (duration = dataInputStream.readByte()) != 0) {
            try {
                sheet.addNote(NoteElements.ofCode(code, NoteDuration.of(duration)));
            } catch (InvalidNoteType e) {
                System.out.println("Skipping note: Invalid code");
                e.printStackTrace();
            }
        }

        return sheet;
    }
}
