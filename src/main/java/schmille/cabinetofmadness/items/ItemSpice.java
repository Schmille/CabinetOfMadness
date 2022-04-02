package schmille.cabinetofmadness.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import schmille.cabinetofmadness.properties.Config;
import schmille.cabinetofmadness.util.MobEffectHelper;

import java.util.Random;

public class ItemSpice extends Item {

    private static final Random RANDOM = new Random();

    public ItemSpice() {
        super(getProperties());
        this.setRegistryName("spice");
    }

    private static Properties getProperties() {
        var props = new Properties();

        props = props.stacksTo(16);
        props = props.setNoRepair();
        props = props.tab(ModItems.CREATIVE_MODE_TAB);
        props = props.food(createFoodProperties());

        return props;
    }

    protected static FoodProperties createFoodProperties() {
        var builder = new FoodProperties.Builder()
                .fast()
                .nutrition(Config.SPICE.nutrition())
                .saturationMod(Config.SPICE.saturation())
                .effect(ItemSpice::createEffectInstance, Config.SPICE.probability());
        return builder.build();
    }

    private static MobEffectInstance createEffectInstance() {
        var effect = MobEffectHelper.getRandom(RANDOM);
        // Duration, Strength, Ambient, Visible, Icon
        return new MobEffectInstance(effect, Config.SPICE.time(), Config.SPICE.level(), false,false, true);
    }
}
