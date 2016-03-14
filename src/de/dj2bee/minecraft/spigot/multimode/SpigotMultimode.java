package de.dj2bee.minecraft.spigot.multimode;

import de.dj2bee.minecraft.spigot.multimode.commands.Kit;
import de.dj2bee.minecraft.spigot.multimode.commands.ToggleMode;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotMultimode extends JavaPlugin {

    @Override
    public void onEnable() {
        // Commands
        this.getCommand("kit").setExecutor(new Kit());
        this.getCommand("toggle").setExecutor(new ToggleMode());

        // Listener
//        getServer().getPluginManager().registerEvents(new ListenerJoin(), this);
    }

    @Override
    public void onDisable(){

    }
}