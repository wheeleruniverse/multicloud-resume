package com.wheeler.core.utility.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RandomStringOptions {

    private int maxLength;
    private int minLength;
    private boolean withLetters;
    private boolean withNumbers;
    private boolean withSpecial;

    /**
     *
     * @return a new RandomStringOptions instance with default values
     */
    public static RandomStringOptions withDefaults(){
        return RandomStringOptions.builder()
                .maxLength(6)
                .minLength(6)
                .withLetters(true)
                .withNumbers(true)
                .withSpecial(false)
                .build();
    }
}
