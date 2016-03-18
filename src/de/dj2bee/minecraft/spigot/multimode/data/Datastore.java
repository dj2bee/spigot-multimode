package de.dj2bee.minecraft.spigot.multimode.data;

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class Datastore {
    private static HashMap<UUID, ItemStack[]> inventorySurvival = new HashMap<UUID, ItemStack[]>();
    private static HashMap<UUID, ItemStack[]> inventoryCreative = new HashMap<UUID, ItemStack[]>();

    public static void setInventorySurvival(UUID playerId, ItemStack[] inventory) {
        inventorySurvival.put(playerId, inventory);
    }

    public static ItemStack[] getInventorySurvival(UUID playerId) {
        return inventorySurvival.keySet().contains(playerId) ? inventorySurvival.get(playerId) : new ItemStack[0];
    }

    public static void setInventoryCreative(UUID playerId, ItemStack[] inventory) {
        inventoryCreative.put(playerId, inventory);
    }

    public static ItemStack[] getInventoryCreative(UUID playerId) {
        return inventoryCreative.keySet().contains(playerId) ? inventoryCreative.get(playerId) : new ItemStack[0];
    }
}