package de.ellpeck.actuallyadditions.api.recipe;

import de.ellpeck.actuallyadditions.api.internal.IAtomicReconstructor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

/**
 * Changes an item's color by changing its metadata.
 * Much like dye and wool, 0 is white and 15 is black and it will cycle around.
 */
public class ColorLensChangerByDyeMeta implements IColorLensChanger{

    @Override
    public ItemStack modifyItem(ItemStack stack, IBlockState hitBlockState, BlockPos hitBlock, IAtomicReconstructor tile){
        ItemStack newStack = stack.copy();
        int meta = newStack.getItemDamage();
        if(meta >= 15){
            newStack.setItemDamage(0);
        }
        else{
            newStack.setItemDamage(meta+1);
        }
        return newStack;
    }
}
