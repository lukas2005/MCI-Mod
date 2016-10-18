package lukas2005.MCIMod.Items;

import java.util.ArrayList;

import lukas2005.MCIMod.MCIItemType;
import lukas2005.MCIMod.MySqlConnector;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
public class ModItems {
	
	public static MCIItem Test;
	public static ArrayList<MCIItem> itemList = new ArrayList<MCIItem>();
	
	public static void main() {
		Test = (MCIItem) new MCIItem("Example Dude", "Base Item Test", MCIItemType.MISC);
		try {
			while (MySqlConnector.itemsQuery.next()) {
					
					System.out.println("Registering item: " + MySqlConnector.itemsQuery.getString("name"));
					
					itemList.add(new MCIItem(MySqlConnector.itemsQuery.getString("author"), MySqlConnector.itemsQuery.getString("name"), null));
					
			}
		} catch (Exception e) {
		
			System.err.println("ERROR: " + e.getMessage());
		
		}
	}
	
	public static void registerRenders() {
		
		for (MCIItem item : itemList) {
			System.out.println("Register Render For: " + item.getRegistryName());
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
			
		}
		
	}
	
}
