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
		Logger.setLogger(e.getModLog());
		Logger.info("Pre Init!");
		
		if (!Reference.MCI_DIR.exists()) Reference.MCI_DIR.mkdirs();
		
		MySqlConnector.main();
		
		ModItems.main();
		proxy.preInit(e);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent e) {
		Logger.info("Init!");
		proxy.init(e);
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent e) {
		Logger.info("Post Init!");
		
		proxy.postInit(e);
	}
	
}
