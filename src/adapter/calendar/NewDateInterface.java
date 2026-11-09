package adapter.calendar;

// Target interface: defines the methods the client will use.
public interface NewDateInterface {

    // Set the day of the month
    void setDay(int day);

    // Set the month (1 = January, 12 = December)
    void setMonth(int month);

    // Set the year
    void setYear(int year);

    // Get the current day
    int getDay();

    // Get the current month
    int getMonth();

    // Get the current year
    int getYear();

    // Move the date forward by a given number of days
    void advanceDays(int days);
}
