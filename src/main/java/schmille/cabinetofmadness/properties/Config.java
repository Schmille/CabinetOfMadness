package schmille.cabinetofmadness.properties;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final SpiceProperties SPICE = new SpiceProperties(BUILDER);
    public static final ForgeConfigSpec SPEC = BUILDER.build();
}
