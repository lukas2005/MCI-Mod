package lukas2005.MCIMod;

import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;

import net.minecraft.item.Item;

public class util {

	public static void setMCICat(Item item, MCIItemType type) {
		
		
		
	}
	
	public static Object loadClass(String directory,String name) {
		try {
			URLClassLoader c = URLClassLoader.newInstance(new URL[]{new URL(directory)});
			return c.loadClass(name).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String getMCPath() {
		
		Path currentRelativePath = Paths.get("");
		return currentRelativePath.toAbsolutePath().toString();
		
	}
		
}
	

