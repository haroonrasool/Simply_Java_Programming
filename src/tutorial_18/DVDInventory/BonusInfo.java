package tutorial_18.DVDInventory;

// Exercise 18.17: BonusInfo.java
// Represents DVD bonus material.

public class BonusInfo {
    // String for storing name
    private String name = "";
    private int itemLength;

    // BonusInfo constructor, name and length supplied
    public BonusInfo(String nameValue, int lengthValue) {
        setName(nameValue);
        setItemLength(lengthValue);
    } // end constructor

    // return name value
    public String getName() {
        return name;
    } // end method getName

    // set name value
    public void setName(String value) {
        // cut off String input after 20 characters
        if (value.length() > 20) {
            name = value.substring(0, 20);
        } else {
            name = value;
        }
    } // end method setName

    // return itemLength value
    public int getItemLength() {
        return itemLength;
    } // end method getItemLength

    // set itemLength value
    public void setItemLength(int value) {
        // set invalid input to 0
        itemLength = Math.max(value, 0);
    } // end method setItemLength

} // end class BonusInfo
