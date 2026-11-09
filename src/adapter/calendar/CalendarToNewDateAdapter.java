
package adapter.calendar;

import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDateInterface {

    // Adaptee: Java's existing Calendar class
    private final Calendar calendar;

    // Constructor: create a Calendar object
    public CalendarToNewDateAdapter() {
        calendar = Calendar.getInstance();
        calendar.setLenient(false);
    }

    // Set the day
    @Override
    public void setDay(int day) {
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    // Set the month
    @Override
    public void setMonth(int month) {
        // Calendar months start from 0
        calendar.set(Calendar.MONTH, month - 1);
    }

    // Set the year
    @Override
    public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
    }

    // Get the day
    @Override
    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    // Get the month
    @Override
    public int getMonth() {
        // Convert 0-based month to 1-based month
        return calendar.get(Calendar.MONTH) + 1;
    }

    // Get the year
    @Override
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    // Advance the date by the specified number of days
    @Override
    public void advanceDays(int days) {
        calendar.add(Calendar.DAY_OF_MONTH, days);
    }
}
