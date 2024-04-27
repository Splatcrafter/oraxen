package io.th0rgal.oraxen.mechanics.provided.gameplay.efficiency;

import io.th0rgal.oraxen.mechanics.Mechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectTypeWrapper;

public class EfficiencyMechanic extends Mechanic {

    private final int amount;
    private final PotionEffectType type;

    public EfficiencyMechanic(final MechanicFactory mechanicFactory, final ConfigurationSection section) {
        super(mechanicFactory, section);
        final int tempAmount = section.getInt("amount", 1);
        if (tempAmount < 0) {
            type = PotionEffectTypeWrapper.SLOW_DIGGING;
            amount = -tempAmount;
        } else {
            type = PotionEffectTypeWrapper.FAST_DIGGING;
            amount = tempAmount;
        }
    }

    public int getAmount() {
        return amount;
    }

    public PotionEffectType getType() {
        return type;
    }
}
