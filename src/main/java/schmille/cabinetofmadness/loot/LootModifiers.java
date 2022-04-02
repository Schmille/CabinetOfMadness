package schmille.cabinetofmadness.loot;

import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import schmille.cabinetofmadness.CabinetOfMadness;
import schmille.cabinetofmadness.util.Pair;

@Mod.EventBusSubscriber(modid = CabinetOfMadness.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public abstract class LootModifiers {

    public static final GlobalLootModifierSerializer<SpiceLootModifier> SPICE_MODIFIER_SERIALIZER = new SpiceLootSerializer();

    @SubscribeEvent
    public static void registerSerializers(RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().register(SPICE_MODIFIER_SERIALIZER);
    }

    public static Pair<Integer, Integer> findPercentile(double chance) {
        double currentChance = chance * 10;
        int exponent = 1;

        while(currentChance < 1 || !isWhole(currentChance)) {
            currentChance *= 10;
            exponent++;
        }

        int draw = (int) currentChance;
        int pool = (int) Math.pow(10D, exponent);

        return new Pair<>(draw, pool);
    }

    private static boolean isWhole(double number) {
        return number % 1 == 0;
    }
}
