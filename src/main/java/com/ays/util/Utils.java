package com.ays.util;

import java.util.Objects;

/**
 * @author ayush agrahari created on 10/02/2021
 */
public final class Utils {

    public static <T> T requireNonEmpty(T obj, String errMsg) {
        Objects.requireNonNull(obj, errMsg);
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.isEmpty()) {
                throw new RuntimeException(errMsg);
            }
        }
        return obj;
    }

    public static <T> T requireNonNull(T obj, String errMsg) {
        return Objects.requireNonNull(obj, errMsg);
    }

}
