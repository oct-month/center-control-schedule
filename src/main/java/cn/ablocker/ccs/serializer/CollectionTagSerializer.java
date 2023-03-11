package cn.ablocker.ccs.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import cn.ablocker.ccs.model.CollectionTagRelate;

public class CollectionTagSerializer extends JsonSerializer<CollectionTagRelate> {
	@Override
	public void serialize(CollectionTagRelate value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(value.getTag());
	}
}
