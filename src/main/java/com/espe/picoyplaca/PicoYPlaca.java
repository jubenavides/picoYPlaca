/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espe.picoyplaca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jubenavides
 */
public class PicoYPlaca {

    public Boolean verifyPicoYplaca(String plateNumber, String date, String time) {
        Integer lastDigit = getLastDigit(plateNumber);
        Integer dayOfWeek = getDayOfWeek(date);
        LocalTime localTime = getTime(time);
        if (lastDigit != null && dayOfWeek != null && localTime != null) {
            return canRoad(lastDigit, dayOfWeek, localTime);
        } else {
            return false;
        }
    }

    private Integer getLastDigit(String plateNumber) {
        if (plateNumber != null) {
            if (!plateNumber.isEmpty() && plateNumber.length() == 8) {
                return Integer.valueOf(plateNumber.substring(plateNumber.length() - 1));
            } else {
                System.out.println("Error, check the plate format (ABC-1234)");
                return null;
            }
        } else {
            System.out.println("Error, the plate can't be null");
            return null;
        }
    }

    private Integer getDayOfWeek(String dateString) {
        Integer dayOfWeek = null;
        if (dateString != null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                sdf.setLenient(false);
                Date date = sdf.parse(dateString);
                GregorianCalendar calendar = new GregorianCalendar();
                calendar.setTime(date);
                dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            } catch (ParseException ex) {
                System.out.println("Error converting date, check the date or remember the correct format year/month/day (yyyy/MM/dd)");
            }
        } else {
            System.out.println("Error date can't be null");
        }
        return dayOfWeek;
    }

    private LocalTime getTime(String timeString) {
        LocalTime time = null;
        if (timeString != null) {
            try {
                time = LocalTime.parse(timeString);
            } catch (DateTimeParseException ex) {
                System.out.println("Error converting time, check the correct format");
            }
        } else {
            System.out.println("Error time can't be null");
        }
        return time;
    }

    private Boolean canRoad(Integer lastDigit, Integer dayOfWeek, LocalTime time) {
        if (checkDay(lastDigit, dayOfWeek)) {
            if (checkHour(time)) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    private Boolean checkDay(Integer lastDigit, Integer dayOfWeek) {
        Map<Integer, List<Integer>> restrictions = getRestrictions();
        for (Map.Entry<Integer, List<Integer>> entry : restrictions.entrySet()) {
            if (entry.getKey() == dayOfWeek) {
                if (entry.getValue().stream().anyMatch((digit) -> (digit == lastDigit))) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean checkHour(LocalTime time) {
        try {
            LocalTime morningBeginTime = LocalTime.parse("07:00:00");
            LocalTime morningEndTime = LocalTime.parse("09:30:00");
            LocalTime afternoonBeginTime = LocalTime.parse("16:00:00");
            LocalTime afternoonEndTime = LocalTime.parse("19:30:00");
            if (time.compareTo(morningBeginTime) >= 0 && time.compareTo(morningEndTime) <= 0) {
                return true;
            } else if (time.compareTo(afternoonBeginTime) >= 0 && time.compareTo(afternoonEndTime) <= 0) {
                return true;
            } else {
                return false;
            }
        } catch (DateTimeParseException ex) {
            System.out.println("Error converting hours for Pico Y Placa interval");
            return null;
        }
    }

    private Map<Integer, List<Integer>> getRestrictions() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(2, Arrays.asList(1, 2));
        map.put(3, Arrays.asList(3, 4));
        map.put(4, Arrays.asList(5, 6));
        map.put(5, Arrays.asList(7, 8));
        map.put(6, Arrays.asList(9, 0));
        return map;
    }
}
