package schmille.cabinetofmadness;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import schmille.cabinetofmadness.properties.Config;
import schmille.cabinetofmadness.util.MobEffectHelper;

import static schmille.cabinetofmadness.CabinetOfMadness.MOD_ID;

@Mod(MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CabinetOfMadness {

    public static final String MOD_ID = "cabinetofmadness";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public CabinetOfMadness() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent evt) {
        MobEffectHelper.initialize();
    }
}