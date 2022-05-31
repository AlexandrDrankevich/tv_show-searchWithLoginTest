package com.tvmaze.ui.utils;

import java.time.Month;

public class DateConverter {
    public static int monthToInt(String month){
          return Month.valueOf(month.toUpperCase()).getValue();
    }
}
