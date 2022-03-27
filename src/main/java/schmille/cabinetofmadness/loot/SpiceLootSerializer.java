package schmille.cabinetofmadness.loot;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;

public class SpiceLootSerializer extends GlobalLootModifierSerializer<SpiceLootModifier> {

    public SpiceLootSerializer() {
        super();
        this.setRegistryName("loot_spice");
    }

    @Override
    public SpiceLootModifier read(ResourceLocation location, JsonObject object, LootItemCondition[] ailootcondition) {
        double chance = GsonHelper.getAsDouble(object, "drawChance");
        return new SpiceLootModifier(ailootcondition, chance);
    }

    @Override
    public JsonObject write(SpiceLootModifier instance) {
        JsonObject obj = this.makeConditions(instance.getConditions());
        obj.addProperty("drawChance", instance.getDrawChance());
        return obj;
    }
}
