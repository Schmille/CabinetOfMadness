package schmille.cabinetofmadness.items;

import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import schmille.cabinetofmadness.util.NetherTeleporter;

public class ItemHourglass extends Item {

    public ItemHourglass() {
        super(getProperties());
        this.setRegistryName("interdimensional_hourglass");
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        ItemStack stack = hand == InteractionHand.MAIN_HAND ? player.getMainHandItem() : player.getOffhandItem();
        if(level.isClientSide())
            return InteractionResultHolder.pass(stack);


        ResourceKey<Level> key = level.dimension() == Level.NETHER ? Level.OVERWORLD : Level.NETHER;
        ServerLevel targetDimension = level.getServer().getLevel(key);

        if (level.getServer().isNetherEnabled() && !player.isPassenger()) {
            player.setPortalCooldown();
            player.changeDimension(targetDimension, new NetherTeleporter());
        }

        return InteractionResultHolder.consume(stack);
    }

    protected static Properties getProperties() {
        var props = new Properties();
        props.stacksTo(64);
        props.setNoRepair();
        props.tab(ModItems.CREATIVE_MODE_TAB);
        return props;
    }
}
