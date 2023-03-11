package cn.ablocker.ccs.serializer;

import java.io.IOException;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import cn.ablocker.ccs.model.CollectionTagRelate;

public class CollectionTagDeserializer extends JsonDeserializer<CollectionTagRelate> {
	@Override
	public CollectionTagRelate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		String tag = p.getValueAsString();
		if (StringUtils.hasText(tag)) {
			CollectionTagRelate rtr = new CollectionTagRelate();
			rtr.setTag(tag);
			return rtr;
		}
		return null;
	}
}
