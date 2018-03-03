package com.hao.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * com.hao.util
 *
 * @author Hao
 * @version v1.0
 * @since 2018/2/10 18:06
 */
public class CustomDateSerializer extends JsonSerializer {

    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws
            IOException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String formattedDate = formatter.format(o);
        jsonGenerator.writeString(formattedDate);
    }
}
