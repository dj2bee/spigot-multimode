package de.dj2bee.minecraft.spigot.multimode.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Kit implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            ItemStack ironPickaxe = new ItemStack(Material.IRON_PICKAXE, 1);
            ItemStack food = new ItemStack(Material.BREAD, 3);
            ItemStack seeds = new ItemStack(Material.SEEDS, 10);
            ItemStack light = new ItemStack(Material.TORCH, 5);
            ItemStack saplings = new ItemStack(Material.SAPLING, 10);

            player.getInventory().addItem(ironPickaxe, light, saplings, food, seeds);
        }

        return true;
    }
}