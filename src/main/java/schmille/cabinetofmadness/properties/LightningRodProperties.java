package schmille.cabinetofmadness.properties;

import net.minecraftforge.common.ForgeConfigSpec;

public class LightningRodProperties {

    private final ForgeConfigSpec.ConfigValue<Double> raytraceDistance;
    private final ForgeConfigSpec.IntValue cooldownValue;
    private final ForgeConfigSpec.IntValue weatherChangeDuration;
    private final ForgeConfigSpec.BooleanValue changeWeather;

    LightningRodProperties(ForgeConfigSpec.Builder builder) {
        builder.push("Lightning Rod");
        raytraceDistance = builder.define("lightning_rod_raytrace_distance", 100.0D);
        cooldownValue = builder.comment("value in seconds")
                .defineInRange("lightning_rod_cooldown_value", 1, 0, 24 * 60 * 60);
        changeWeather = builder.comment("if true, the weather will change to thunder if used")
                        .define("lightning_rod_weather_change", true);
        weatherChangeDuration = builder.comment("value in seconds")
                .defineInRange("lightning_rod_weather_change_time", 20, 1, 24 * 60 * 60);
        builder.pop();
    }

    public int cooldown() {
        return this.cooldownValue.get() * 20;
    }

    public double raytraceDistance() {
        return this.raytraceDistance.get();
    }

    public boolean changeWeather() {
        return this.changeWeather.get();
    }

    public int weatherChangeDuration() {
        return this.weatherChangeDuration.get() * 20;
    }
}
