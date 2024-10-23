package weatherapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class City {
    private String name;
    private int id;
    private double longitude;
    private double latitude;
    private String country;
    @JsonProperty("admin1")
    private String state;

    

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public double getLongitude() {
        return longitude;
    }



    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }



    public double getLatitude() {
        return latitude;
    }



    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }



    public String getCountry() {
        return country;
    }



    public void setCountry(String country) {
        this.country = country;
    }


    public String getState() {
        return state;
    }



    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString(){
        return String.format("%s, %s, %s", this.name,this.state, this.country);
    }
}
