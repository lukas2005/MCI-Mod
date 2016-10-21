package lukas2005.MCIMod;

import java.nio.file.Path;
import java.nio.file.Paths;

import lukas2005.MCIMod.Items.MCIItem;
import lukas2005.loadclassapi.loadClassUtil;
import net.minecraft.item.Item;

public class util {

	public static void setMCICat(Item item, MCIItemType type) {
		
		
		
	}
	
	public static void loadItem(String directory, String name, Object[] args) {
		Class<?> loadedClass = loadClassUtil.loadClassWhitoutInstantiation(directory, name);
		if (loadedClass != null) {
			if (loadedClass.getSuperclass().getName() == MCIItem.class.getName()) { 
			
				Object item = null;
				try {
					item = (Object) loadedClass.getConstructors()[0].newInstance(args);
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
				System.out.println(item.getClass().getName());
				
			}
		}
		
	}
	
	public static String getMCPath() {
		
		Path currentRelativePath = Paths.get("");
		return currentRelativePath.toAbsolutePath().toString();
		
	}
	
	
	
}
	

