package minefantasy.container;

import minefantasy.block.tileentity.TileEntityTripHammer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


/**
 *
 * @author Anonymous Productions
 * 
 * Sources are provided for educational reasons.
 * though small bits of code, or methods can be used in your own creations.
 */
public class ContainerHammer extends Container
{
    private TileEntityTripHammer hammer;

    public ContainerHammer(InventoryPlayer inventoryplayer, TileEntityTripHammer tile)
    {
        hammer = tile;
        addSlotToContainer(new Slot(tile, 0, 54, 35));
        addSlotToContainer(new Slot(tile, 1, 116, 35));
        for (int i = 0; i < 3; i++)
        {
            for (int k = 0; k < 9; k++)
            {
            	addSlotToContainer(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }
        }

        for (int j = 0; j < 9; j++)
        {
        	addSlotToContainer(new Slot(inventoryplayer, j, 8 + j * 18, 142));
        }
    }


    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return hammer.isUseableByPlayer(entityplayer);
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int num)
    {
    	int invSize = 2;
        ItemStack placedItem = null;
        Slot slot = (Slot)this.inventorySlots.get(num);

        
        
        
        if (slot != null && slot.getHasStack())
        {
            ItemStack itemSlot = slot.getStack();
            placedItem = itemSlot.copy();

            //Take
            if (num < invSize)
            {
            	//System.out.println("Take from Rack");
                if (!this.mergeItemStack(itemSlot, invSize, 36 + invSize, true))
                {
                    return null;
                }

                slot.onSlotChange(itemSlot, placedItem);
            }
            //Put
            else
            {
            	if (!this.mergeItemStack(itemSlot, 0, 1, false))
                {
                    return null;
                }

                slot.onSlotChange(itemSlot, placedItem);
            }

            if (itemSlot.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemSlot.stackSize == placedItem.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, itemSlot);
        }

        return placedItem;
    }
}
