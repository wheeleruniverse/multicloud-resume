package com.wheeler.core.utility;

import com.wheeler.core.dto.model.helper.Argument;
import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class ValidationUtil {

    public static void arguments(Argument<?>... args){
        if (args == null){
            arguments(new Argument<>("'args'", null));
            return;
        }
        Arrays.stream(args).forEach(arg -> {
            if(arg.getValue() == null){
                throw new IllegalArgumentException(String.format("'%s' is invalid", arg.getName()));
            }
        });
    }
}
