package de.dj2bee.minecraft.spigot.multimode.commands;

import de.dj2bee.minecraft.spigot.multimode.data.Datastore;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class ToggleMode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.getGameMode().equals(GameMode.CREATIVE)) {
                //Switch from Creative to Survival
                ItemStack[] inventory = player.getInventory().getStorageContents();
                UUID playerId = player.getUniqueId();
                Datastore.setInventoryCreative(playerId, inventory);

                player.getInventory().clear();
                player.setGameMode(GameMode.SURVIVAL);

                inventory = Datastore.getInventorySurvival(playerId);
                player.getInventory().setStorageContents(inventory);

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