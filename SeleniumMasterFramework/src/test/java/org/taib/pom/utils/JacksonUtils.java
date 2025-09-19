package org.taib.pom.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.taib.pom.objects.BillingAddress;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {

    public static BillingAddress deserializeBillingAddress(InputStream filePath, BillingAddress billingAddress) throws IOException {
        ObjectMapper obj = new ObjectMapper();
        return obj.readValue(filePath, billingAddress.getClass());
    }


    // we have to make the above method generic so that it can be used for any object not just BillingAddress

    public static <T> T deserialize(String fileName, Class<T> T) throws IOException {
        InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(fileName);
        ObjectMapper obj = new ObjectMapper();
        return obj.readValue(is, T);
    }
}
