package de.dj2bee.minecraft.spigot.multimode.data;

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class Datastore {
    private static HashMap<UUID, ItemStack[]> inventorySurvival = new HashMap<>();
    private static HashMap<UUID, ItemStack[]> inventoryCreative = new HashMap<>();

    public static void setInventorySurvival(UUID playerId, ItemStack[] inventory) {
        inventorySurvival.put(playerId, inventory);
    }

    public static ItemStack[] getInventorySurvival(UUID playerId) {
        return inventorySurvival.get(playerId) == null ? new ItemStack[0] : inventorySurvival.get(playerId);
    }

    public static void setInventoryCreative(UUID playerId, ItemStack[] inventory) {
        inventoryCreative.put(playerId, inventory);
    }

    public static ItemStack[] getInventoryCreative(UUID playerId) {
        return inventoryCreative.get(playerId) == null ? new ItemStack[0] : inventoryCreative.get(playerId);
    }
}