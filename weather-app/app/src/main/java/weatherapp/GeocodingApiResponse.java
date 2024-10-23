package weatherapp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GeocodingApiResponse {
    
    @JsonProperty("results")
    private List<City> cities; // is results because the API's object is name this way, both name have to match so ObjectMapper can help me with the parsing
    // if i want or need o change the attribute name but for some reason i cant have the same matching name, use the annotation 

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString(){

        StringBuilder answer = new StringBuilder();
        for (City city : cities){
            answer.append(city+"\n");
        }
        return String.valueOf(answer);
    }
    
}
