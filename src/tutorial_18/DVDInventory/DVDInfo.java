package tutorial_18.DVDInventory;

// Exercise 18.17: DVDInfo.java
// Represents a DVD object and contains get and set methods.

public class DVDInfo {
    // String for storing movie title
    private String movieTitle = "";

    // integer for storing movie length
    private int movieLength;

    // BonusInfo reference for storing bonus materials
    private BonusInfo[] bonusMaterial;

    // constructor, movie name, bonus material,
    // and movie length supplied
    public DVDInfo(String nameValue, BonusInfo[] bonusValue,
                   int movieLengthValue) {
        setMovieTitle(nameValue);
        setBonusMaterial(bonusValue);
        setMovieLength(movieLengthValue);
    } // end constructor

    // return bonusMaterials value
    public String getBonusMaterial() {
        StringBuilder bonusMaterials = new StringBuilder();

        for (BonusInfo bonusInfo : bonusMaterial) {
            bonusMaterials.append(bonusInfo.getName()).append(": ").append(bonusInfo.getItemLength()).append(" minute(s)\n");
        }

        return bonusMaterials.toString();

    } // end method getBonusMaterial

    // set bonusMaterials
    public void setBonusMaterial(BonusInfo[] bonusValue) {
        bonusMaterial = bonusValue;

    } // end method setBonusMaterial

    // return movieTitle value
    public String getMovieTitle() {
        return movieTitle;
    } // end method getMovieTitle

    // set movieTitle value
    public void setMovieTitle(String value) {
        // cut off String input after 20 characters
        if (value.length() > 20) {
            movieTitle = value.substring(0, 20);
        } else {
            movieTitle = value;
        }
    } // end method setMovieTitle

    // return movieLength value
    public int getMovieLength() {
        return movieLength;
    } // end method getMovieLength

    // set movieLength value
    public void setMovieLength(int value) {
        // set invalid input to 0
        movieLength = Math.max(value, 0);
    } // end method setMovieLength

} // end class DVDInfo
