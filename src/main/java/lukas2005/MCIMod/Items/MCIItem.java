package lukas2005.MCIMod.Items;

import java.util.List;

import lukas2005.MCIMod.Logger;
import lukas2005.MCIMod.Reference;
import lukas2005.MCIMod.util;
import lukas2005.MCIMod.Enum.MCIItemType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class MCIItem extends Item {
	
	private String Author;
	private String Lore;
	private MCIItemType type;
	
	public MCIItem(String Author, String Name, String lore, MCIItemType type) {
		if (Name != null) {
			setUnlocalizedName(Name);
			setRegistryName(Reference.MODID, Name.toLowerCase().replace(" ", "_"));
			this.Author = Author;
			this.Lore = lore;
			Logger.info("Loaded succesfully: " + this.getRegistryName());
			util.setMCICat(this, type);
			this.type = type;
			ModItems.ITEMS.put(Name.toLowerCase().replace(" ", "_"), this);
		}
	}
	
	@Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
		if (!stack.hasTagCompound()) {
			stack.getItem().onCreated(stack, playerIn.getEntityWorld(), playerIn);
		}
		NBTTagCompound nbt = stack.getTagCompound();
		
		String[] lore = nbt.getString("lore").split("\\|", -1);
		
		for (String s : lore) {
			
			tooltip.add(s);
			
		}
		
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
		nbt.setString("lore", Lore);
		nbt.setString("type", type.toString());
		
		stack.setTagCompound(nbt);	
	}
	
}
