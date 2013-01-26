package com.som.blog.util;

/**
 * @author zhelezoglo
 */
// TODO: replace with Spring Utils
public final class CheckNotNull {
    private CheckNotNull() {

    }

    static public void throwIllegalArgument(String name, Object arg) {
        if (arg == null) throw new IllegalArgumentException(name + " cannot be null");
    }

}
