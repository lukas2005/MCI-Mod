package lukas2005.MCIMod.Items;

import java.util.HashMap;

import lukas2005.MCIMod.MCIItemType;
import lukas2005.MCIMod.MySqlConnector;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
public class ModItems {
	
	public static HashMap<String,MCIItem> ITEMS = new HashMap<String,MCIItem>();
	
	public static void main() {
		new MCIItem("Example Dude", "Base Item Test", "This is a test item", MCIItemType.MISC);
		
		try {
			while (MySqlConnector.itemsQuery.next()) {
					
					System.out.println("Registering item: " + MySqlConnector.itemsQuery.getString("name"));
					
					new MCIItem(MySqlConnector.itemsQuery.getString("author"), MySqlConnector.itemsQuery.getString("name"), MySqlConnector.itemsQuery.getString("lore"), null);
					
			}
		} catch (Exception e) {
		
			System.err.println("ERROR: " + e.getMessage());
		
		}
	}
	
	public static void registerRenders() {
		
		for (MCIItem item : ITEMS.values()) {
			System.out.println("Register Render For: " + item.getRegistryName());
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
			
		}
		
	}
	
}
