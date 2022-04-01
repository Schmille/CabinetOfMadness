package schmille.cabinetofmadness.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import schmille.cabinetofmadness.CabinetOfMadness;

@Mod.EventBusSubscriber(modid = CabinetOfMadness.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public abstract class ModItems {

    public static final Item SPICE = new ItemSpice();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(SPICE);
    }
}
