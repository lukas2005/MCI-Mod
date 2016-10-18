package lukas2005.MCIMod;

import lukas2005.MCIMod.Items.ModItems;
import lukas2005.MCIMod.proxy.IProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, version = Reference.VERSION, name = Reference.NAME, acceptedMinecraftVersions = Reference.MCVERSION, dependencies = Reference.DEPENDENCIES)
public class MCIMod {

	@SidedProxy(modId = Reference.MODID, serverSide = Reference.SERVER_PROXY, clientSide = Reference.CLIENT_PROXY)
	public static IProxy proxy;
	
	@Instance(value = Reference.MODID)
	public static MCIMod INSTANCE;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent e) {
		System.out.println("Pre Init!");
		
		MySqlConnector.main();
		
		ModItems.main();
		proxy.main();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent e) {
		System.out.println("Init!");
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent e) {
		System.out.println("Post Init!");
		
		
	}
	
}
