package io.github.dolphin2410.minenote.minecraft;

import io.github.dolphin2410.minenote.note.*;
import io.github.dolphin2410.minenote.sheet.Sheet;
import io.github.dolphin2410.minenote.util.Direction;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.type.NoteBlock;
import org.bukkit.block.data.type.Repeater;
import org.bukkit.entity.Player;

public class SheetConverter {
    private final Direction direction;
    private final Location location;
    private final Sheet sheet;
    private int counter = 0;    // Count how many blocks are currently placed

    public SheetConverter(Player player, Sheet sheet) {
        this.direction = Direction.getDirection(player);
        this.sheet = sheet;
        this.location = player.getLocation().clone();
    }


    public void convert() {
        for (NoteElement element : sheet.getNotes()) {
            if (element instanceof NoteMusic music) {
                placeNoteBlock(music);
            } else {
                placeBreak(element.getDuration().getTicks());
            }
        }
    }

    public void placeNoteBlock(NoteMusic music) {
        NoteBlock noteBlock = (NoteBlock) Material.NOTE_BLOCK.createBlockData();
        noteBlock.setNote(music.unwrap());
        location.getBlock().setBlockData(noteBlock);
        incrementDirection();
        placeRepeater(music.getDuration().getTicks());
        placeBreak(music.getDuration().getTicks());
        // TODO: Add instrument type
    }

    public void placeRepeater(int leftTick) {
        int maxTick = leftTick / 4;
        int tick;

        if (maxTick == 0) {
            tick = leftTick % 4;
        } else {
            tick = 4;
        }

        Repeater repeater = (Repeater) Material.REPEATER.createBlockData();
        repeater.setDelay(tick);
        repeater.setFacing(direction.asBlockFace());
        location.getBlock().setBlockData(repeater);

        incrementDirection();

        if (maxTick != 0 && leftTick > 4) {
            placeBreak(leftTick - 4);
        }
    }

    public void placeBreak(int leftTick) {
        location.getBlock().setBlockData(Material.STONE.createBlockData()); // TODO: Make this customizable
        incrementDirection();
        placeRepeater(leftTick);
    }

    public void incrementDirection() {
        switch (direction) {
            case NORTH -> location.add(0, 0, -1);
            case EAST -> location.add(1, 0, 0);
            case WEST -> location.add(-1, 0, 0);
            case SOUTH -> location.add(0, 0, 1);
        }
        counter++;
    }
}
