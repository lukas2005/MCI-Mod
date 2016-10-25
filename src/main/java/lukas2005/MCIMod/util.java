package lukas2005.MCIMod;

import java.nio.file.Path;
import java.nio.file.Paths;

import lukas2005.MCIMod.Enum.MCIBlockType;
import lukas2005.MCIMod.Enum.MCIItemType;
import lukas2005.MCIMod.Items.MCIItem;
import lukas2005.loadclassapi.loadClassUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class util {

	public static void setMCICat(Item item, MCIItemType type) {
		Logger.info("MCICat reg for item : " + item.getRegistryName());
		switch(type){
		
		case MISC:
			item.setCreativeTab(MCIMod.MISC_TAB);
			
		default:
			Logger.warn("WARNING: Unknown MCI Item Type");
			
		}
		
	}
	
	public static void setMCICat(Block block, MCIBlockType type) {
		switch(type){
		
		case MISC:
			block.setCreativeTab(MCIMod.MISC_TAB);
			
		default:
			Logger.warn("WARNING: Unknown MCI Block Type");
		
		}
		
	}
	
	public static void loadItem(String directory, String name, Object[] args) {
		Class<?> loadedClass = loadClassUtil.loadClassWhitoutInstantiation(directory, name);
		MCIItem item = null;
		if (loadedClass != null) {
			if (loadedClass.getSuperclass().getName() == MCIItem.class.getName()) { 
			
				try {
					item = (MCIItem) loadedClass.getConstructors()[0].newInstance(args); //Why this throws ClassCastException
					//item = (MCIItem) ResourcesTestItem.class.getConstructors()[0].newInstance(args); //While this not??
				} catch (Exception e) {
					Logger.error(e.getMessage());
				} finally {
					
					if (item != null) {
						
						Logger.info("Loaded succesfully: " + item.getRegistryName());
						
					}					
				}
				
			}
		}
		
	}
	
	public static String getMCPath() {
		
		Path currentRelativePath = Paths.get("");
		return currentRelativePath.toAbsolutePath().toString();
		
	}

	public static MCIItemType getItemTypeFromString(String string) {
		switch(string) {
		
		case("MISC"):
			return MCIItemType.MISC;
			
		default:
			return null;
			
		}
	}
	
	
	
}
	

