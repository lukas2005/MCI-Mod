package lukas2005.MCIMod.proxy;


import java.util.List;

import lukas2005.MCIMod.Items.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResourcePack;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy implements IProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
        // DefaultResourcePacks because of the private, reflection is necessary.
        List<IResourcePack> DefaultResourcePacks = ObfuscationReflectionHelper.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), "defaultResourcePacks" , "Field_110449_ao" );
        DefaultResourcePacks.add(new MCIResourceLoader( ));
		ModItems.registerRenders();
		
	}

	@Override
	public void init(FMLInitializationEvent e) {
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		
	}
	
}
