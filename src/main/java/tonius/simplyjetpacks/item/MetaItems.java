package tonius.simplyjetpacks.item;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import tonius.simplyjetpacks.setup.ModItems;

import javax.annotation.Nonnull;
import java.util.EnumSet;

public enum MetaItems {

    PARTICLE_DEFAULT("particle_default", "particle_customizers", EnumRarity.COMMON),
    PARTICLE_NONE("particle_none", "particle_customizers", EnumRarity.COMMON),
    PARTICLE_SMOKE("particle_smoke", "particle_customizers", EnumRarity.COMMON),
    PARTICLE_RAINBOW("particle_rainbow", "particle_customizers", EnumRarity.COMMON),

    LEATHER_STRAP("leather_strap", null, EnumRarity.COMMON),
    PILOT_GOGGLES("pilot_goggles", null, EnumRarity.COMMON);

    private final String name;
    private final String keyTooltip;
    private final EnumRarity rarity;

    public static final EnumSet<MetaItems> PARTICLE_CUSTOMIZERS = EnumSet.range(PARTICLE_DEFAULT, PARTICLE_RAINBOW);

    MetaItems(String name, String keyTooltip, EnumRarity rarity) {
        this.name = name;
        this.keyTooltip = keyTooltip;
        this.rarity = rarity;
    }

    public static MetaItems getFromName(String s) {
        for (MetaItems meta : values()) {
            if (meta.name.toLowerCase().equals(s.toLowerCase())) {
                return meta;
            }
        }
        return null;
    }

    @Nonnull
    public static MetaItems getTypeFromMeta(int meta) {
        return values()[meta >= 0 && meta < values().length ? meta : 0];
    }

    @Nonnull
    public ItemStack getStackMetaItem() {
        return getStackMetaItem(1);
    }

    @Nonnull
    public ItemStack getStackMetaItem(int size) {
        return new ItemStack(ModItems.metaItem, size, ordinal());
    }

    public String getName() {
        return name;
    }

    public String getKeyTooltip() {
        return keyTooltip;
    }

    public EnumRarity getRarity() {
        return rarity;
    }
}
