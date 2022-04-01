package schmille.cabinetofmadness.items;

import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class ItemHourglass extends Item {

    public ItemHourglass() {
        super(getProperties());
        this.setRegistryName("interdimensional_hourglass");
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        var player = context.getPlayer();
        var level = context.getLevel();

        if(level.isClientSide())
            return InteractionResult.PASS;

        ResourceKey<Level> key = level.dimension() == Level.NETHER ? Level.OVERWORLD : Level.NETHER;
        ServerLevel targetDimension = level.getServer().getLevel(key);

        if (level.getServer().isNetherEnabled() && !player.isPassenger()) {
            level.getProfiler().push("portal");
            player.setPortalCooldown();
            player.changeDimension(targetDimension);
            level.getProfiler().pop();
        }

        return InteractionResult.CONSUME;
    }

    protected static Properties getProperties() {
        var props = new Properties();
        props.stacksTo(64);
        props.setNoRepair();
        props.tab(ModItems.CREATIVE_MODE_TAB);
        return props;
    }
}
