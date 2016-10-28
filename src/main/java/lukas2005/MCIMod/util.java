package lukas2005.MCIMod;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;

import lukas2005.MCIMod.Enum.MCIBlockType;
import lukas2005.MCIMod.Enum.MCIItemType;
import lukas2005.MCIMod.Items.MCIItem;
import lukas2005.loadclassapi.loadClassUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class util {

	public static void setMCICat(Item item, MCIItemType type) {
		Logger.info("Assocated MCI category: " + type.toString() + " to item: " + item.getRegistryName());
		switch(type){
		
		case MISC:
			item.setCreativeTab(MCIMod.MISC_TAB);
			break;
			
		default:
			Logger.warn("WARNING: Unknown MCI Item Type: " + type.toString());
			break;
			
		}
		
	}
	
	public static void setMCICat(Block block, MCIBlockType type) {
		Logger.info("Assocated MCI category to block: " + block.getRegistryName());
		switch(type){
		
		case MISC:
			block.setCreativeTab(MCIMod.MISC_TAB);
			break;
			
		default:
			Logger.warn("WARNING: Unknown MCI Block Type: " + type.toString());
			break;
			
		}
		
	}
	
	public static void loadItem(String directory, String name, Object... args) {
		Class<?> loadedClass = loadClassUtil.loadClassWhitoutInstantiation(directory, name);
		MCIItem item = null;
		if (loadedClass != null) {
			if (loadedClass.getSuperclass().getName() == MCIItem.class.getName()) { 
				try {
					//item = (MCIItem) loadedClass.getConstructor(String.class, String.class, String.class, MCIItemType.class).newInstance(args);
					item = (MCIItem) loadedClass.getConstructors()[0].newInstance(args);
					//item = (MCIItem) loadedClass.getConstructors()[0].newInstance("Example Dude", "Resources Test Item", "This is a test item|this appears on second line|This item is used to test|resources system", MCIItemType.MISC);
				} catch (Exception e) {
					Logger.printStackTrace(e);;
				} finally {
					
					if (item == null) {
						
						Logger.info("Loaded unsuccesfully: " + loadedClass.getName());
						
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
	
	public static Object searchResultSet(String key, ResultSet set) {
		try {
			return set.getObject(key);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object searchItems(String key) {
		
		return searchResultSet(key, MySqlConnector.itemsQuery);
		
	}
	
	
}
	

