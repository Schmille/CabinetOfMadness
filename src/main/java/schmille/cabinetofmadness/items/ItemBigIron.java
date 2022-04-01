package schmille.cabinetofmadness.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class ItemBigIron extends Item {

    public ItemBigIron() {
        super(getProperties());
        this.setRegistryName("big_iron");
    }

    protected static Properties getProperties() {
        var props = new Properties();
        props.stacksTo(64);
        props.setNoRepair();
        props.tab(CreativeModeTab.TAB_MATERIALS);
        return props;
    }
}
