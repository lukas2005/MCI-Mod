package lukas2005.MCIMod.Items;

import java.util.List;

import lukas2005.MCIMod.MCIItemType;
import lukas2005.MCIMod.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MCIItem extends Item {
	
	private String Author;
	
	public MCIItem(String Author, String Name, MCIItemType type) {
		setUnlocalizedName(Name);
		setRegistryName(Reference.MODID, Name.toLowerCase().replace(" ", "_"));
		this.Author = Author;
		GameRegistry.register(this);
	}
	
	@Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
		if (!stack.hasTagCompound()) {
			stack.getItem().onCreated(stack, playerIn.getEntityWorld(), playerIn);
		}
		NBTTagCompound nbt = stack.getTagCompound();
		
		tooltip.add("by: " + nbt.getString("author"));
		
    }
	
	@Override
	public void onCreated(ItemStack stack, World worldObj, EntityPlayer playerIn) {
		NBTTagCompound nbt;
		if (!stack.hasTagCompound()) {
			nbt = new NBTTagCompound();
		} else {
			nbt = stack.getTagCompound();
		}

		nbt.setString("author", Author);
		
		stack.setTagCompound(nbt);	
	}
	
}
