package org.example.exception;

public class AdminException {
    //Ngày tháng
    public boolean isValiDate(int day, int month, int year) {
        if (year < 1990 || year > 2024) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        int daysInFebruary = isLeapYear(year) ? 29 : 28;
        int[] dayInMonth = {31, daysInFebruary , 31, 30, 31, 30, 31, 31, 30, 31,30, 31};
        return day > 0 && day <= dayInMonth[month - 1];
    }
    //Năm
    public boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
