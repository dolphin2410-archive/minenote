package io.github.dolphin2410.minenote;

import java.util.Arrays;
import java.util.Optional;

public enum NoteType {
    F_SHARP(0),
    G(1),
    G_SHARP(2),
    A(3),
    A_SHARP(4),
    B(5),
    C(6),
    C_SHARP(7),
    D(8),
    D_SHARP(9),
    E(10),
    F(11);
    private final int code;

    NoteType(int code) {
        this.code = code;
    }

    public static NoteType ofCode(int code) {
        Optional<NoteType> optional =  Arrays.stream(NoteType.values())
                .filter(x -> x.code == code)
                .findFirst();

        if (optional.isEmpty())
            throw new RuntimeException("Invalid NoteType code");

        return optional.get();
    }

    public int getCode() {
        return code;
    }
}
