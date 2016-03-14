package de.dj2bee.minecraft.spigot.multimode.commands;

import de.dj2bee.minecraft.spigot.multimode.data.Datastore;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ToggleMode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.getGameMode().equals(GameMode.CREATIVE)) {
                //Switch from Creative to Survival
                Datastore.setInventoryCreative(player.getUniqueId(), player.getInventory().getStorageContents());
                player.getInventory().clear();
                player.setGameMode(GameMode.SURVIVAL);
                player.getInventory().setStorageContents(Datastore.getInventorySurvival(player.getUniqueId()));
                player.sendMessage(ChatColor.DARK_PURPLE + "Gamemode: Survival");
            } else {
                //Switch from Survival to Creative
                Datastore.setInventorySurvival(player.getUniqueId(), player.getInventory().getStorageContents());
                player.getInventory().clear();
                player.setGameMode(GameMode.CREATIVE);
                player.getInventory().setStorageContents(Datastore.getInventoryCreative(player.getUniqueId()));
                player.sendMessage(ChatColor.DARK_PURPLE + "Gamemode: Creative");
            }
        }

        return true;
    }
}