package com.wheeler.core.utility;

import com.google.gson.Gson;
import com.wheeler.core.dto.model.helper.Argument;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonUtil {

    private static final Gson GSON = new Gson();

    public static <T> T toObject(final String json, final Class<T> type){
        ValidationUtil.arguments(
            new Argument<>("json", json),
            new Argument<>("type", type)
        );
        return GSON.fromJson(json, type);
    }

    public static String toString(final Object obj){
        return obj != null ? GSON.toJson(obj) : "null";
    }
}
