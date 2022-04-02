package schmille.cabinetofmadness.loot;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;
import schmille.cabinetofmadness.items.ModItems;

import java.util.List;

public class SpiceLootModifier extends LootModifier {

    private final double drawChance;

    private final int draw;
    private final int pool;

    public SpiceLootModifier(LootItemCondition[] conditionsIn, double drawChance) {
        super(conditionsIn);
        this.drawChance = drawChance;

        var pair = LootModifiers.findPercentile(this.drawChance);
        this.draw = pair.left();
        this.pool = pair.right();
    }

    @NotNull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        int drawn = context.getRandom().nextInt(1, this.pool);

        if(drawn <= this.draw) {
            generatedLoot.clear();
            generatedLoot.add(new ItemStack(ModItems.SPICE, 1));
        }

        return generatedLoot;
    }

    LootItemCondition[] getConditions() {
        return this.conditions;
    }

    double getDrawChance() {
        return drawChance;
    }
}
