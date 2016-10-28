package lukas2005.MCIMod.Items;

import java.util.HashMap;

import lukas2005.MCIMod.Logger;
import lukas2005.MCIMod.MySqlConnector;
import lukas2005.MCIMod.Reference;
import lukas2005.MCIMod.util;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
public class ModItems {
	
	public static HashMap<String,MCIItem> ITEMS = new HashMap<String,MCIItem>();
	
	public static void main() {
		try {
			while (MySqlConnector.itemsQuery.next()) {
				if ((boolean) util.searchItems("loadExtClass")) {
					
					//util.loadItem(Reference.MCI_DIR + "\\classes.jar", "lukas2005.MCIMod.externalClasses." + MySqlConnector.itemsQuery.getString("name").replaceAll(" ", ""), "Example Dude", "Resources Test Item", "test item", MCIItemType.MISC);
					util.loadItem(Reference.MCI_DIR + "\\classes.jar", "lukas2005.MCIMod.externalClasses." + MySqlConnector.itemsQuery.getString("name").replaceAll(" ", ""), (String) util.searchItems("author"), (String) util.searchItems("name"), (String) util.searchItems("lore"), util.getItemTypeFromString((String) util.searchItems("type")));

				} else {
					
					new MCIItem((String) util.searchItems("author"), (String) util.searchItems("name"), (String) util.searchItems("lore"), util.getItemTypeFromString((String) util.searchItems("type")));
					
				}
			}
		} catch (Exception e) {
			
			Logger.printStackTrace(e);
			
		}
		registerItems();
	}
	
	private static void registerItems() {
		for (MCIItem item : ITEMS.values()) {
		
			Logger.info("Registering item: " + item.getRegistryName());
			GameRegistry.register(item);
			
		}
	}
	
	public static void registerRenders() {
		for (MCIItem item : ITEMS.values()) {
			
			Logger.info("Registering render for item: " + item.getRegistryName());
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
			
		}
	}
	
}
