package schmille.cabinetofmadness.items;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class ItemLightningRod extends Item {

    public ItemLightningRod() {
        super(getProperties());
        this.setRegistryName("lightning_rod");
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = hand == InteractionHand.MAIN_HAND ? player.getMainHandItem() : player.getOffhandItem();
        if(level.isClientSide())
            return InteractionResultHolder.pass(stack);

        HitResult result = player.pick(20.0D, 0.0F, true);

        BlockPos pos = switch(result.getType()) {
            case BLOCK, ENTITY -> new BlockPos(result.getLocation());
            default -> null;
        };
        if(pos == null)
            return InteractionResultHolder.pass(stack);

        Entity lightningEntity = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
        lightningEntity.setPos(pos.getX(), pos.getY(), pos.getZ());
        level.addFreshEntity(lightningEntity);

        ServerLevel serverLevel = level.getServer().getLevel(level.dimension());
        // ClearTime, Rain/Thunder time, Raining, Thundering
        serverLevel.setWeatherParameters(0, 1, true, true);
        player.getCooldowns().addCooldown(this, 20);

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
