

public class Vehicle{


    /*
    make - a string representing the company that made the vehicle (e.g., "Pontiac", "Honda", etc..)
    model - a string representing the model of the vehicle (e.g., "Grand Prix", "Civic", etc..)
    year - an int representing the year of the vehicle (e.g., 2004 etc..)
    color - a string representing the color of the vehicle (e.g., "red", "blue" etc..)
    plate - a string representing the license plate of the vehicle (e.g., "X5T6Y8", "2FAST", etc..)
    owner - a Driver object representing the owner of the vehicle (e.g., John Doe from part 1)
    reportedStolen - a boolean indicating whether or not the vehicle has been reported  as stolen
    */

    public String make;
    public String model;
    public int year;
    public String color;
    public String plate;

    Driver owner =new Driver();
    String d="";
    
    public boolean reportedStolen=false;
    public Vehicle(String make, String model, int year, String color, String plate){
        
        this.make=make;
        this.model=model;
        this.year=year;
        this.color=color;
        this.plate=plate;
        
    }
    public Vehicle(){
        this("", "", 0, "", "");
    }
    public String toString(){
        return "A " + this.color + " " + this.year + " " + this.make + " " + this.model + " with plate " + this.plate;
    }


}
