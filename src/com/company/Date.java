package com.company;

public class Date {
    int day;
    int month;
    int year;

    Date(int d, int m, int y) {
        assert m >= 1 && m <= 12;
        assert d >= 1 && d <= 31;
        day = d;
        month = m;
        year = y;
    }

    int dayOfWeek() {
        System.out.println(year);
        if (month < 3) year = year - 1;
        int weekDay = (int) ((day + Math.floor(2.6 * ((month + 9) % 12 + 1) - 0.2) + year % 100 + Math.floor(year % 100 / 4.0)
                + Math.floor(year / 400.0) - 2 * Math.floor(year / 100.0) - 1) % 7 + 7) % 7 + 1;
        if (weekDay == 7) weekDay = 0;
        return weekDay;
    }

    boolean isLeapYear() {
        return (this.year % 400 == 0) || ((this.year % 4 == 0)
                && (this.year % 100 != 0));
    }


    Date easter() {
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int n = (h + l - 7 * m + 114) / 31;
        int p = (h + l - 7 * m + 114) % 31;
        return new Date(p + 1, n, year);
    }

    Date ascensionDay(){
        Date ascension = easter();
        for(int i = 0; i < 39; i++) {
            ascension = ascension.nextDay();
        }
        return ascension;
    }

    static int howOftenTenthOfMay(int startYear, int endYear){
        int tenthOfMayCounter = 0;
        for(int i = startYear; i <= endYear; i++) {
            Date ascension = new Date(1,1, i).ascensionDay();
            System.out.println(ascension);
            if (ascension.day == 10) {
                tenthOfMayCounter = tenthOfMayCounter +1;
            }
        }

        return tenthOfMayCounter;
    }

    Date nextDay() {
        int newDay = day + 1;
        int newMonth = month;
        int newYear = year;
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (newDay > 30) {
                newDay = 1;
                newMonth = month + 1;
                if (newMonth > 12) {
                    newMonth = 1;
                    newYear = year + 1;
                }
            }
        } else if (month == 2) {
            if (isLeapYear() && newDay > 29) {
                newDay = 1;
                newMonth = month + 1;
                if (newMonth > 12) {
                    newMonth = 1;
                    newYear = year + 1;
                }
            }
            if (!isLeapYear() && newDay > 28) {
                newDay = 1;
                newMonth = month + 1;
                if (newMonth > 12) {
                    newMonth = 1;
                    newYear = year + 1;
                }
            }
        } else {
            if (newDay > 31) {
                newDay = 1;
                newMonth = month + 1;
                if (newMonth > 12) {
                    newMonth = 1;
                    newYear = year + 1;
                }
            }
        }
        return new Date(newDay, newMonth, newYear);
    }

    String monthAsHTML() {
        String table = "<table><tr><th>Mo</th><th>Di</th><th>Mi</th>" +
                "<th>Do</th><th>Fr</th><th>Sb</th><th>So</th></tr>";
        int firstWeekday = new Date(1, month, year).dayOfWeek();
        int amountOfDays;
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            amountOfDays = 30;
        } else if (month == 2) {
            if (isLeapYear()) {
                amountOfDays = 29;
            } else {
                amountOfDays = 28;
            }
        } else {
            amountOfDays = 31;
        }
        int dayCount = 0;
        for(int i = 0; i < 6; i++) {
            if(dayCount == amountOfDays) {
                continue;
            }
            table = table + "<tr>";
            for(int j = 1; j < 8; j++) {
                if(i == 0) {
                    if(j >= firstWeekday && firstWeekday != 0) {
                        if(dayCount < amountOfDays) {
                            table = table + "<td>" + (dayCount+1) + "</td>";
                            dayCount++;
                        }
                    } else if (firstWeekday == 0 && j ==7) {
                        table = table + "<td>" + (dayCount+1) + "</td>";
                        dayCount++;
                    } else {
                        table = table + "<td></td>";
                    }
                } else if (i < 4) {
                    if(dayCount < amountOfDays) {
                        table = table + "<td>" + (dayCount+1) + "</td>";
                        dayCount++;
                    }
                } else {
                    if(dayCount < amountOfDays) {
                        table = table + "<td>" + (dayCount+1) + "</td>";
                        dayCount++;
                    } else {
                        continue;
                    }
                }
            }
            table = table + "</tr>";
        }
        return table + "</table>";
    }

    Date mothersDay() {
        Date mayFirst = new Date(1, 5, year); // reference date to determine the second sunday in may
        int dayOfWeek = mayFirst.dayOfWeek();
        System.out.println(dayOfWeek);
        Date firstSunday; // initialize the first sunday
        if (dayOfWeek == 0) {
            firstSunday = mayFirst; // first sunday is also the first of may
        } else {
            firstSunday = new Date(1 + (7 - dayOfWeek), 5, year); // calculate the first saturday of may
            System.out.println(firstSunday);
        }
        return new Date(firstSunday.day + 7, 5, year);
    }

    public String toString() {
        return day + "." + month + "." + year;
    }

    public static void main(String[] args) {
        Date date = new Date(31,12,2016);
        System.out.println(howOftenTenthOfMay(0, 2018));
    }
}
