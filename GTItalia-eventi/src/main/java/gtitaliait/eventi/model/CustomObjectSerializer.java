package gtitaliait.eventi.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomObjectSerializer extends JsonSerializer<EventGenericAc> {

    @Override
    public void serialize(EventGenericAc value, JsonGenerator jgen,
        SerializerProvider provider) throws IOException,JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeNumberField("y", value.getId());
        jgen.writeEndObject();
    }

    @Override
    public Class<EventGenericAc> handledType() {
        return EventGenericAc.class;
    }
}