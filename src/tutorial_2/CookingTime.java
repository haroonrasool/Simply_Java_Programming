package tutorial_2;

// Tutorial 18: CookingTime.java
// Represents time data and contains get and set methods.

public class CookingTime {
    // integers for storing minutes and seconds
    private int minute;
    private int second;

    // CookingTime constructor, minute and second supplied
    public CookingTime(int minuteValue, int secondValue) {
        setMinute(minuteValue);
        setSecond(secondValue);
    } // end constructor

    // return minute value
    public int getMinute() {
        return minute;
    } // end method getMinute

    // set minute value
    public void setMinute(int value) {
        if (value >= 0 && value < 60) {
            minute = value; // minute is valid
        } else {
            minute = 0; // set invalid input to 0
        }
    } // end method setMinute

    // return second value
    public int getSecond() {
        return second;
    } // end method getSecond

    // set second value
    public void setSecond(int value) {
        if (value >= 0 && value < 60) {
            second = value; // second is valid
        } else {
            second = 0; // set invalid input to 0
        }
    } // end method setSecond

    // return whether or not the time has reached zero
    public boolean isDone() {
        return (minute == 0 && second == 0);
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
            setSecond(59); // set seconds to 59
        }
    } // end method tick

} // end class CookingTime
