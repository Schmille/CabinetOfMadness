package schmille.cabinetofmadness;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static schmille.cabinetofmadness.CabinetOfMadness.MOD_ID;

@Mod(MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CabinetOfMadness {

    public static final String MOD_ID = "cabinetofmadness";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public CabinetOfMadness() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent evt) {
        LOGGER.info("Hello from CommonSetup");
    }
}