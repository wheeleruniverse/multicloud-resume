package com.wheeler.core.utility;

import com.wheeler.core.utility.model.RandomStringOptions;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@UtilityClass
public class RandomUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(RandomUtil.class);
    private static final SecureRandom RANDOM = new SecureRandom();

    // getString constants
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789012345678901234567890123456789012345678901";
    private static final String SPECIAL = "`~!@#$%^&*()-_=+[{]}\\|:;'\",<.>/?`~!@#$%^&*()-_=+[{";


    public static <T extends Enum<?>> T getEnum(Class<T> clazz){
        final T[] constants = clazz.getEnumConstants();
        final int randomIdx = RANDOM.nextInt(constants.length);
        return constants[randomIdx];
    }

    public static int getInt(){
        return RANDOM.nextInt();
    }

    public static int getInt(final int bound){
        return RANDOM.nextInt(bound);
    }

    public static String getString(){
        return getString(RandomStringOptions.withDefaults());
    }

    public static String getString(final RandomStringOptions options){
        LOGGER.debug("using options: {}", options);

        // find length
        int length;
        if (options.getMaxLength() < options.getMinLength()){
            throw new IllegalArgumentException("maxLength must be larger than minLength");
        }
        else if (options.getMinLength() == options.getMaxLength()){
            length = options.getMinLength();
        }
        else {
            final List<Integer> range = IntStream
                    .rangeClosed(options.getMinLength(), options.getMaxLength())
                    .boxed()
                    .collect(Collectors.toList());

            length = range.get(RANDOM.nextInt(range.size()));
        }

        // find characters
        final StringBuilder allCharactersBuilder = new StringBuilder();
        if (options.isWithLetters()){
            allCharactersBuilder.append(LETTERS);
        }
        if (options.isWithNumbers()){
            allCharactersBuilder.append(NUMBERS);
        }
        if (options.isWithSpecial()){
            allCharactersBuilder.append(SPECIAL);
        }
        final String allCharacters = allCharactersBuilder.toString();
        if (allCharacters.isEmpty()){
            throw new IllegalArgumentException("withLetters, withNumbers, or withSpecial must be true");
        }


        // build string
        final StringBuilder value = new StringBuilder();
        for(int i = 0; i < length; i++){
            value.append(allCharacters.charAt(RANDOM.nextInt(allCharacters.length())));
        }
        return value.toString();
    }
}
