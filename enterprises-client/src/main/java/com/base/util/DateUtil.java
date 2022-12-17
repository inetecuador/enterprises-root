package com.base.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * DateUtil.
 *
 * @author vsangucho on 2022/12/15
 * @version 1.0
 * @since 1.0.0
 */
public final class DateUtil {

    /**
     * Constructor.
     */
    private DateUtil() {
    }

    /**
     * Obtiene la fecha actual LocalDateTime.
     *
     * @author vsangucho on 2022/12/15
     * @return Date
     */
    public static Date currentDate() {
        return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());


    }
}
