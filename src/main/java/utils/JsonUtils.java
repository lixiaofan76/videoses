package utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.qfedu.common.JsonResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class JsonUtils {

    public static void writeJsonInfo(int code, Object info, HttpServletResponse response){
        JsonResult r = new JsonResult(code, info);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        // null转为空字符串
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException,
                    JsonProcessingException {
                gen.writeString("");
            }
        });
        try {
            String jsonInfo = objectMapper.writeValueAsString(r);
            PrintWriter writer = response.getWriter();
            writer.write(jsonInfo);
            writer.flush(); // 刷新缓存
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
