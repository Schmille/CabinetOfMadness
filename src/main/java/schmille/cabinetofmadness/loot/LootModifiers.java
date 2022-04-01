package schmille.cabinetofmadness.loot;

import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import schmille.cabinetofmadness.CabinetOfMadness;

@Mod.EventBusSubscriber(modid = CabinetOfMadness.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public abstract class LootModifiers {

    public static final GlobalLootModifierSerializer<SpiceLootModifier> SPICE_MODIFIER_SERIALIZER = new SpiceLootSerializer();

    @SubscribeEvent
    public static void registerSerializers(RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().register(SPICE_MODIFIER_SERIALIZER);
    }
}
