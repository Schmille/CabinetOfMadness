package schmille.cabinetofmadness.util;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class MobEffectHelper {

    private static final List<MobEffect> EFFECTS = new ArrayList<>();

    public static void initialize() {
        for (MobEffect effect : ForgeRegistries.MOB_EFFECTS.getValues())
            EFFECTS.add(effect);
    }

    public static MobEffect getRandom(Random random) {
        return EFFECTS.get(random.nextInt(EFFECTS.size()));
    }
}
