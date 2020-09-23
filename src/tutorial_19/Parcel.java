package tutorial_19;

// Tutorial 19: Parcel.java
// This class defines the Parcel object.

public class Parcel {
    // member data
    private String name;
    private String address;
    private String city;
    private String state;
    private int zip;
    private final int parcelID;
    private String arrivalTime;

    // constructor
    public Parcel(int number, String time) {
        setParcel();
        parcelID = number;
        arrivalTime = time;
    }

    // set the parcel properties
    private void setParcel() {
        name = "";
        address = "";
        city = "";
        state = "";
        zip = 99999;
        arrivalTime = "";
    }

    // get the name
    public String getName() {
        return name;
    }

    // set the name
    public void setName(String nameValue) {
        name = nameValue;
    }

    // get the address
    public String getAddress() {
        return address;
    }

    // set the address
    public void setAddress(String addressValue) {
        address = addressValue;
    }

    // get the city
    public String getCity() {
        return city;
    }

    // set the city
    public void setCity(String cityValue) {
        city = cityValue;
    }

    // get the state
    public String getState() {
        return state;
    }

    // set the state
    public void setState(String stateValue) {
        state = stateValue;
    }

    // get the zip code
    public int getZip() {
        return zip;
    }

    // set the zip code
    public void setZip(int zipValue) {
        zip = zipValue;
    }

    // get the parcel number
    public int getParcelID() {
        return parcelID;
    }

    // get the arrival time
    public String getArrivalTime() {
        return arrivalTime;
    }

} // end class Parcel
