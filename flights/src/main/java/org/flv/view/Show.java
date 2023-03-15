package org.flv.view;

public class Show {
    public void showTimeFromMinutes(String message, long allMinutesTime) {
        int days = (int) allMinutesTime / 1440;
        allMinutesTime %= 1440;
        int hours = (int) allMinutesTime / 60;
        allMinutesTime %= 60;
        int minutes = (int) allMinutesTime;
        System.out.println(message);
        System.out.println("Days:" + days + " " + "Hours:" + hours + " " + "Minutes:" + minutes);
    }
}
