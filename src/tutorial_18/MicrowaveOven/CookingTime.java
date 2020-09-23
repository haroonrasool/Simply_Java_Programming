package tutorial_18.MicrowaveOven;

// Exercise 18.12: CookingTime.java
// Represents time data and contains get and set methods.

public class CookingTime {
    // integers for storing hours, minutes and seconds
    private int hour;
    private int minute;
    private int second;

    // CookingTime constructor, hour, minute and second supplied
    public CookingTime(int hourValue, int minuteValue,
                       int secondValue) {
        setHour(hourValue);
        setMinute(minuteValue);
        setSecond(secondValue);
    } // end constructor

    // return hour value
    public int getHour() {
        return hour;
    } // end method getHour

    // set hour value
    public void setHour(int value) {
        if (value >= 0 && value < 10) {
            hour = value;
        } else // set invalid input to 0
        {
            hour = 0;
        }
    } // end method setHour

    // return minute value
    public int getMinute() {
        return minute;
    } // end method getMinute

    // set minute value
    public void setMinute(int value) {
        if (value >= 0 && value < 60) {
            minute = value;
        } else // set invalid input to 0
        {
            minute = 0;
        }
    } // end method setMinute

    // return second value
    public int getSecond() {
        return second;
    } // end method getSecond

    // set second value
    public void setSecond(int value) {
        if (value >= 0 && value < 60) {
            second = value;
        } else // set invalid input to 0
        {
            second = 0;
        }
    } // end method setSecond

    // return whether or not the time has reached zero
    public boolean isDone() {
        return (minute == 0 && second == 0 && hour == 0);
    } // end method isDone

    // decrement the time by one second
    public void tick() {
        // handle case when seconds need to be decremented
        if (getSecond() > 0) {
            setSecond(getSecond() - 1); // subtract one second
        }
        // handle case when minutes must be decremented
        else if (getMinute() > 0) {
            setMinute(getMinute() - 1); // subtract one minute
            setSecond(59);              // reset seconds to new minute
        }
        // handle case when hours must be decremented
        else if (getHour() > 0) {
            setHour(getHour() - 1); // subtract one hour
            setMinute(59);          // reset minutes to new hour
            setSecond(59);          // reset seconds to new minute
        }
    } // end method tick

} // end class CookingTime
