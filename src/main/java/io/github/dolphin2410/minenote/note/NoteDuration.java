package io.github.dolphin2410.minenote.note;

import java.util.Objects;

public class NoteDuration {
    public static NoteDuration TICK_1 = new NoteDuration(1);
    public static NoteDuration TICK_2 = new NoteDuration(2);
    public static NoteDuration TICK_4 = new NoteDuration(4);

    public static NoteDuration of(int duration) {
        return new NoteDuration(duration);
    }

    private int ticks;

    public NoteDuration(int ticks) {
        this.ticks = ticks;
    }

    public int getTicks() {
        return ticks;
    }

    public void setTicks(int ticks) {
        this.ticks = ticks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteDuration that = (NoteDuration) o;
        return ticks == that.ticks;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticks);
    }
}
