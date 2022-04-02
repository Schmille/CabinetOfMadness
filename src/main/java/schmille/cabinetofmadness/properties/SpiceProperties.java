package schmille.cabinetofmadness.properties;

import net.minecraftforge.common.ForgeConfigSpec;

public class SpiceProperties {

    private final ForgeConfigSpec.IntValue time;
    private final ForgeConfigSpec.IntValue nutrition;
    private final ForgeConfigSpec.IntValue effectLevel;
    private final ForgeConfigSpec.ConfigValue<Double> saturation;
    private final ForgeConfigSpec.ConfigValue<Double> probability;

    SpiceProperties(ForgeConfigSpec.Builder builder) {
        builder.push("Spice");
        time = builder
                .comment("time in seconds")
                .defineInRange("spice_effect_time", 25,1, 24 * 60 * 60);
        nutrition = builder.defineInRange("spice_nutrition", 2, 1, 16);
        saturation = builder.define("spice_saturation", 1.0D);
        probability = builder.define("spice_effect_probability", 1.0D);
        effectLevel = builder
                .comment("effect level starting at 1")
                .defineInRange("spice_effect_level",1, 1, 4);
        builder.pop();
    }

    public int time() {
        return time.get() * 20;
    }

    public int nutrition() {
        return nutrition.get();
    }

    public float saturation() {
        return saturation.get().floatValue();
    }

    public float probability() {
        return probability.get().floatValue();
    }

    public int level() {
        return effectLevel.get() - 1;
    }
}
