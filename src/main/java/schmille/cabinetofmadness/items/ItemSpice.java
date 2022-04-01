package schmille.cabinetofmadness.items;

import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import schmille.cabinetofmadness.properties.Config;
import schmille.cabinetofmadness.util.MobEffectHelper;

public class ItemSpice extends Item {

    public ItemSpice() {
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
                .nutrition(Config.SPICE.nutrition())
                .saturationMod(Config.SPICE.saturation())
                .effect(ItemSpice::createEffectInstance, Config.SPICE.probability());
        return builder.build();
    }

    private static MobEffectInstance createEffectInstance() {
        var effect = MobEffects.REGENERATION;
        if(Minecraft.getInstance().player != null)
            effect = MobEffectHelper.getRandom(Minecraft.getInstance().player.getRandom());

        // Duration, Strength, Ambient, Visible, Icon
        return new MobEffectInstance(effect, Config.SPICE.time(), Config.SPICE.level(), false,false, true);
    }
}
