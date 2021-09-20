public class Driver {

    public String license;
    public String name;
    public String street;
    public String city;
    public String province;
    
   public Driver(String license, String nam, String stre, String cit, String prov){
        this.license=license;
        this.name=nam;
        this.street=stre;
        this.city=cit;
        this.province=prov;
    }

    public Driver(){
        this(" ", " ", " ", " ", " ");
      }


    public String toString(){

        return "#"+ this.license + " " + this.name + " living at " + this.street + ", " + this.city + ", " + this.province;
    }
    

    
}
