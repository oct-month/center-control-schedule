package cn.ablocker.ccs.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import cn.ablocker.ccs.model.ResourceTagRelate;

public class ResourceTagSerializer extends JsonSerializer<ResourceTagRelate> {	
	@Override
	public void serialize(ResourceTagRelate value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(value.getTag());
	}
}
