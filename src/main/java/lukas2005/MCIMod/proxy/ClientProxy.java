package lukas2005.MCIMod.proxy;

import lukas2005.MCIMod.Items.ModItems;

public class ClientProxy implements IProxy {

	@Override
	public void main() {
		
		ModItems.registerRenders();
		
	}

}
