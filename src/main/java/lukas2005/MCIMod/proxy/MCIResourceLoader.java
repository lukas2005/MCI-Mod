package lukas2005.MCIMod.proxy;

import java.io.File;
import java.io.IOException;

import lukas2005.MCIMod.Reference;
import net.minecraft.client.resources.FileResourcePack;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.MetadataSerializer;

public class MCIResourceLoader extends FileResourcePack {

	public MCIResourceLoader() {
		super(new File(Reference.MCI_DIR + "\\assets.zip"));
	}

	@Override
	public <T extends IMetadataSection> T getPackMetadata(MetadataSerializer metadataSerializer,
			String metadataSectionName) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPackName() {
		// TODO Auto-generated method stub
		return "MCIModResourceLoader";
	}



}
