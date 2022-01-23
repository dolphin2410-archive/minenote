package io.github.dolphin2410.minenote;

import io.github.dolphin2410.minenote.minecraft.CommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class MineNotePlugin extends JavaPlugin {

    public static MineNotePlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        CommandHandler.register();

        getLogger().log(Level.INFO, "Plugin Started Successfully");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
