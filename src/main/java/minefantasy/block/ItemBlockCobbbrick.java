package minefantasy.block;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

/**
 *
 * @author Anonymous Productions
 * 
 * Sources are provided for educational reasons.
 * though small bits of code, or methods can be used in your own creations.
 */
public class ItemBlockCobbbrick extends ItemBlock{

    public ItemBlockCobbbrick(int id)
    {
        super(id);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    @Override
    public void getSubItems(int id, CreativeTabs tabs, List list)
    {
        for (int n = 0; n < 6; ++n)
        {
            list.add(new ItemStack(id, 1, n));
        }
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }

    @Override
    public String getItemDisplayName(ItemStack itemstack)
    {
        int i = itemstack.getItemDamage();
        switch(i)
        {
            case 1:
                return StatCollector.translateToLocal("tile.cobbBrick.mossy");
            case 2:
                return StatCollector.translateToLocal("tile.cobbBrick.cracked");
                
            case 3:
                return StatCollector.translateToLocal("tile.cobbBrick.rough");
            case 4:
            	return StatCollector.translateToLocal("tile.cobbBrick.rough.mossy");
            case 5:
               	return StatCollector.translateToLocal("tile.cobbBrick.rough.cracked");
                
        }
        return StatCollector.translateToLocal("tile.cobbBrick");
    }
}
