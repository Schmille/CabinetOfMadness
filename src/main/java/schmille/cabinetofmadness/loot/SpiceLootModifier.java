package schmille.cabinetofmadness.loot;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;
import schmille.cabinetofmadness.items.Items;

import java.util.List;

public class SpiceLootModifier extends LootModifier {

    private final double drawChance;

    public SpiceLootModifier(LootItemCondition[] conditionsIn, double drawChance) {
        super(conditionsIn);
        this.drawChance = drawChance;
    }

    @NotNull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        double chance = this.drawChance * 100;
        int draw = context.getRandom().nextInt(1,100);

        if(draw <= chance) {
            generatedLoot.clear();
            generatedLoot.add(new ItemStack(Items.SPICE_ITEM, 1));
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
