package schmille.cabinetofmadness.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class SpiceItem extends Item {

    public SpiceItem() {
        super(getProperties());
        this.setRegistryName("spice");
    }

    private static Properties getProperties() {
        var props = new Properties();

        props = props.stacksTo(16);
        props = props.setNoRepair();
        props = props.tab(CreativeModeTab.TAB_FOOD);
        props = props.food(createFoodProperties());

        return props;
    }

    protected static FoodProperties createFoodProperties() {
        var builder = new FoodProperties.Builder()
                .fast()
                .nutrition(2)
                .saturationMod(1.0F)
                .effect(SpiceItem::createEffectInstance, 1.0F);
        return builder.build();
    }

    private static MobEffectInstance createEffectInstance() {
        // Duration, Strength, Ambient, Visible, Icon
        return new MobEffectInstance(MobEffects.REGENERATION, 250, 0, false,false, true);
    }
}
