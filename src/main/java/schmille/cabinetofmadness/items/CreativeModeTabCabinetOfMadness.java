package schmille.cabinetofmadness.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import schmille.cabinetofmadness.CabinetOfMadness;

public class CreativeModeTabCabinetOfMadness extends CreativeModeTab {
    public CreativeModeTabCabinetOfMadness() {
        super(CabinetOfMadness.MOD_ID);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModItems.SPICE, 1);
    }
}
