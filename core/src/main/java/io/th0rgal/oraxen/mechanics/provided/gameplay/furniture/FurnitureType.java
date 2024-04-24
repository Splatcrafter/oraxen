package io.th0rgal.oraxen.mechanics.provided.gameplay.furniture;

import io.th0rgal.oraxen.OraxenPlugin;
import io.th0rgal.oraxen.utils.logs.Logs;
import org.bukkit.entity.*;

import java.util.ArrayList;
import java.util.List;

public enum FurnitureType {
    ITEM_FRAME, GLOW_ITEM_FRAME, DISPLAY_ENTITY;//, ARMOR_STAND;

    public static List<Class<? extends Entity>> furnitureEntityClasses() {
        List<Class<? extends Entity>> list = new ArrayList<>(List.of(ItemFrame.class, GlowItemFrame.class, ArmorStand.class));
        if (OraxenPlugin.supportsDisplayEntities) list.add(ItemDisplay.class);
        return list;
    }

    public static FurnitureType getType(String type) {
        try {
            return FurnitureType.valueOf(type);
        } catch (IllegalArgumentException e) {
            Logs.logError("Invalid furniture type: " + type + ", set in mechanics.yml.");
            Logs.logWarning("Using default " + (OraxenPlugin.supportsDisplayEntities ? "DISPLAY_ENTITY" : "ITEM_FRAME"), true);
            return OraxenPlugin.supportsDisplayEntities ? DISPLAY_ENTITY : ITEM_FRAME;
        }
    }
}