package io.github.dolphin2410.minenote;

import java.io.*;

public class NoteCodec {
    public static void serialize(OutputStream dest, Sheet sheet) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(dest);

        for (NoteWrapper note : sheet.getNotes()) {
            dataOutputStream.writeByte(note.getCode());
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
        while ((code = dataInputStream.readByte()) != 0) {
            sheet.getNotes().add(NoteWrapper.ofCode(code));
        }

        return sheet;
    }
}
