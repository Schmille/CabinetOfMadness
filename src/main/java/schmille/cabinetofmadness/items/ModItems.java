package schmille.cabinetofmadness.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import schmille.cabinetofmadness.CabinetOfMadness;

@Mod.EventBusSubscriber(modid = CabinetOfMadness.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public abstract class ModItems {

    public static final CreativeModeTab CREATIVE_MODE_TAB = new CreativeModeTabCabinetOfMadness();

    public static final Item SPICE = new ItemSpice();
    public static final Item BIG_IRON = new ItemBigIron();
    public static final Item HOURGLASS = new ItemHourglass();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(SPICE);
        event.getRegistry().register(BIG_IRON);
        event.getRegistry().register(HOURGLASS);
    }
}
