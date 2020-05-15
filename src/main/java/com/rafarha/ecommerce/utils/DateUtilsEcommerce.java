package com.rafarha.ecommerce.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateUtilsEcommerce {

    /**
     * Receive a local date time and convert to UTC zone
     *
     * @param pDate
     * @return
     */
    public static Timestamp dateUTCConverter(LocalDateTime pDate) {
	return Timestamp.valueOf(pDate.from(ZoneOffset.UTC));
    }

}
