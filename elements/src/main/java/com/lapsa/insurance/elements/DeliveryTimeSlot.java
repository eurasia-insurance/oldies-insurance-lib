package com.lapsa.insurance.elements;

import com.lapsa.insurance.LocalizedElement;

public enum DeliveryTimeSlot implements LocalizedElement {
    DURING_THE_DAY, // в течении дня
    BEFORE_LUNCH, // в первой половине дня (с 9:00 до 13:00)
    AFTER_LUNCH, // во второй половине дня (с 13:00 до 18:00)
    EVENING, // вечером (с 18:00 до 21:00)
    //
    ;
}
