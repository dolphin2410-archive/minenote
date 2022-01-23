package io.github.dolphin2410.minenote.util;

import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

public enum Direction {
    NORTH,
    EAST,
    WEST,
    SOUTH;

    public static Direction getDirection(Player player) {
        float rotation = (player.getLocation().getYaw() - 90) % 360;

        if (rotation < 0.0D) {
            rotation += 360.0D;
        }
        if ((0.0D <= rotation) && (rotation < 45.0D))
            return Direction.WEST;
        if ((45.0D <= rotation) && (rotation < 135.0D))
            return Direction.NORTH;
        if ((135.0D <= rotation) && (rotation < 225.0D))
            return Direction.EAST;
        if ((225.0D <= rotation) && (rotation < 315.0D))
            return Direction.SOUTH;
        if ((315.0D <= rotation) && (rotation < 360.0D)) {
            return Direction.WEST;
        }

        throw new RuntimeException("Invalid Player Yaw");
    }

    public BlockFace asBlockFace() {
        return switch (this) {
            case NORTH -> BlockFace.SOUTH;
            case SOUTH -> BlockFace.NORTH;
            case EAST -> BlockFace.WEST;
            case WEST -> BlockFace.EAST;
        };
    }
}
