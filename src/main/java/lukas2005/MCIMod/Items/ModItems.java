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
					
				util.loadItem(Reference.MCI_DIR + "\\classes.jar", "lukas2005.MCIMod.externalClasses." + MySqlConnector.itemsQuery.getString("name").replaceAll(" ", ""), new Object[]{MySqlConnector.itemsQuery.getString("Author"), MySqlConnector.itemsQuery.getString("name"), MySqlConnector.itemsQuery.getString("lore"), util.getItemTypeFromString(MySqlConnector.itemsQuery.getString("type"))});
				//new MCIItem(MySqlConnector.itemsQuery.getString("author"), MySqlConnector.itemsQuery.getString("name"), MySqlConnector.itemsQuery.getString("lore"), null);
				//MCIItem item = (MCIItem)new ResourcesTestItem("", "Res Test", "", null);
				
			}
		} catch (Exception e) {
			
			Logger.error(e.getMessage(), e);
			
		}
		registerItems();
	}
	
	private static void registerItems() {
		for (MCIItem item : ITEMS.values()) {
		
			Logger.info("Registering item: " + item.getUnlocalizedName());
			GameRegistry.register(item);
			
		}
	}
	
	public static void registerRenders() {
		for (MCIItem item : ITEMS.values()) {
			
			Logger.info("Registering render for item: " + item.getUnlocalizedName());
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
			
		}
	}
	
}
