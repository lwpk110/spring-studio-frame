package cn.spring.studio.util;

import java.util.UUID;

/**
 * Created by minjay on 2017/4/17.
 */
public abstract class LocalStorageKeyUtil {

    private static final String LOCAL_STORAGE_KEY_PREFIX = "TDLS";

    public static String create() {
        return new StringBuilder().append(LOCAL_STORAGE_KEY_PREFIX)
                .append(UUID.randomUUID().toString())
                .toString();
    }
}
