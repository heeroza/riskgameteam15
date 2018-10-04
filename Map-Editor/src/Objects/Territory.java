package Objects;

public class Territory {

    private String country;
    private String name;

    public Territory(String Name,String Country){
        this.name =Name;
        this.country = Country;
    }

    public String getName(){
      return  this.name;
    }
    public String getCountry(){
        return  this.country;
    }

}
