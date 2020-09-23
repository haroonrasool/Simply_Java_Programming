package tutorial_18.ViewName;

// Exercise 18.16: Name.java
// Represents name data and contains get and set methods.

public class Name {
    // Strings for storing first and last name
    private String first = "";
    private String last = "";

    // Name constructor, first and last supplied
    public Name(String firstValue, String lastValue) {
        setFirst(firstValue);
        setLast(lastValue);

    } // end constructor

    // return first value
    public String getFirst() {
        return first;
    } // end method getFirst

    // set first value
    public void setFirst(String value) {
        first = value;
    } // end method setFirst

    // return last value
    public String getLast() {
        return last;
    } // end method getLast

    // set last value
    public void setLast(String value) {
        last = value;
    } // end method setLast

} // end class Name
