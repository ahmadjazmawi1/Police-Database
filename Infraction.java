import java.util.Date;



public class Infraction {
    /*
    amount - a float indicating how much the fine was for this infraction
    description - a String describing the infraction (e.g., "Not stopping for red light")
    dateIssued - a Date representing the date and time at which the infraction occurred.
    You must import java.util.Date in order for your code to compile.
    outstanding - a boolean indicating whether or not the infraction was paid yet
    driver - a Driver object representing the driver that received the infraction
    */

    private static final Date Date = null;
    public float amount;
    public String description;
    
    public boolean outstanding=true;
    public Date dateIssued;
    Driver driver=new Driver();
    String d=driver.name;
	
    public Infraction(){
	this(0, "", Date);
        
    }
    public Infraction(float amount, String description, Date dateIssued){
        this.amount=amount;
        this.description=description;
        this.dateIssued=dateIssued;

    }
    public String toString(){
        /*
            "$100.00 Infraction on Sun Jul 14 07:08:00 EDT 2002 [PAID IN FULL]"
        */
        if (this.outstanding==false){
            return "$" + this.amount + " Infraction on " + this.dateIssued +  " [PAID IN FULL] ";
        }
        else{
            return "$" + this.amount + " Infraction on " + this.dateIssued +  " [OUTSTANDING] ";
        }
        
    }

    public void pay(){
        
        
        this.outstanding=false;
        
    
    }


    

    





    public static void main(String[] args){
        String license="L420";
        String name="Ahmad";
        String street="Bayshore"; 
        String city="Ottawa"; 
        String province="Ontario";
        Driver br=new Driver(license, name, street, city, province);
        System.out.println(br);


        
        
        

        

            


        
       


        

    }
}
