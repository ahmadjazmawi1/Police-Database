
import java.util.Date;

public class PoliceDatabase {
    /*
    vehicles - an array storing all vehicles in the database
    numVehicles - an int that keeps track of how many vehicles there are in the database
    drivers - an array storing all drivers (i.e., people who drive vehicles) in the database
    numDrivers - an int that keeps track of how many drivers there are in the database
    infractions - an array storing all infractions that have ever been given to drivers
    numInfractions - an int that keeps track of how many infractions there are in the database

    */
    
    public Vehicle vehicles[];
    public int numVehicles=0;//this is 0 as it needs to be incremented
    public Driver drivers[];
    public int numDrivers=0;//this is 0 because it needs to be incremented
    public Infraction infractions[];
    public int numInfractions=0;
    public String n;
    //public Vehicle newV[];
    

    public int maxDrivers=2000;
    public int maxVehicles=1000;
    public int maxInfrac=800;
    
    public PoliceDatabase(){
        this.drivers=new Driver[2000];
        this.vehicles=new Vehicle[1000];
        this.infractions=new Infraction[800];
    }
    public void registerDriver(Driver aDriver){
        if(this.numDrivers<maxDrivers){ //Makes sure the database is not full
            this.drivers[numDrivers]=aDriver; 
            numDrivers+=1;
        }
    }
    
    public void registerVehicle(Vehicle aVehicle, String license){
        if(this.numVehicles<this.maxVehicles){ //Makes sure the vehicle database is not full
            for (int i=0;i<numDrivers;i++){
                /*to make sure that the current driver has the license id 
                given, we must check if the driver.toString contains the given license.
                */
                if (drivers[i].toString().contains(license)){
                    aVehicle.d=drivers[i].name;
                    aVehicle.owner = drivers[i];
                }
            }
            this.vehicles[numVehicles]=aVehicle;
            numVehicles+=1;
        }
    }

    public void unregisterVehicle(String plate){
        int idx=0;
        boolean found=false;
        int i;
        for (i=0;i<numVehicles;i++){
            if(vehicles[i]==null){
                continue;
            }
            if (vehicles[i].toString().contains(plate)){
                found=true;
                idx=i;
                break;
            }    
        }
        if(found==true){
            i=idx;
            while(i<numVehicles-1){
                vehicles[i]=vehicles[i+1];
                i++;
            }

            vehicles[numVehicles]=null;
            numVehicles--;
        }
    }

    public void reportStolen(String plate){
        for (int i=0;i<numVehicles;i++){
            if (vehicles[i].toString().contains(plate)){
                vehicles[i].reportedStolen=true;
            }
        }
    }
    public void changeOwner(String plate, String license){
        for (int i=0;i<numVehicles;i++){
            if (vehicles[i].toString().contains(plate)){
                for (int j=0;j<numDrivers;j++){
                    if (drivers[j].toString().contains(license)){
                        System.out.println(license);
                        vehicles[i].owner=drivers[j];
                        return;
                    }
                }
            }
        }
    }
    public Infraction issueInfraction(String license, float amount, String description, Date date){
        String n="";
        Infraction inf = new Infraction(amount, description, date);
        if (numInfractions<maxInfrac){
            for (int i=0;i<numDrivers;i++){
                if (this.drivers[i].toString().contains(license)){
                    n=this.drivers[i].name;
                    inf.driver=this.drivers[i];
                    break;
                }
            }
        }
        inf.d=n;
        infractions[numInfractions]=inf;
        numInfractions+=1;
        return inf;
    }

    public boolean hasOutstandingInfractions(Driver d){
        for (int i=0;i<numInfractions;i++){
            if (infractions[i].driver.license==d.license){ //Checks if the current infraction object's license is the same as the license 
                //of the given driver
                if (infractions[i].outstanding==true){ //Checks if the current infraction object has an outstanding payment
                    return true;
                }
            }
        }
        return false;
    }

    public boolean shouldStopVehicle(String plate){
        boolean c=true;
        for (int i=0;i<numVehicles;i++){
            if (this.vehicles[i].toString().contains(plate)){
                if (hasOutstandingInfractions(this.vehicles[i].owner)==true||this.vehicles[i].reportedStolen==true){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }
    public static  PoliceDatabase example() { // Register all drivers and their vehicles
    PoliceDatabase pdb = new PoliceDatabase();
        pdb.registerDriver(new Driver("L1567-34323-84980", "Matt Adore",
            "1323 Kenaston St.", "Gloucester", "ON"));
        pdb.registerDriver(new Driver("L0453-65433-87655", "Bob B. Pins",
            "32 Rideau Rd.", "Greely", "ON"));
        pdb.registerDriver(new Driver("L2333-45645-54354", "Stan Dupp",
            "1355 Louis Lane", "Gloucester", "ON"));
        pdb.registerDriver(new Driver("L1234-35489-99837", "Ben Dover",
            "2348 Walkley Rd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L8192-87498-27387", "Patty O'Lantern",
            "2338 Carling Ave.", "Nepean", "ON"));
        pdb.registerDriver(new Driver("L2325-45789-35647", "Ilene Dover",
            "287 Bank St.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1213-92475-03984", "Patty O'Furniture",
            "200 St. Laurant Blvd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1948-87265-34782", "Jen Tull",
            "1654 Stonehenge Cres.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L0678-67825-83940", "Jim Class",
            "98 Oak Blvd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L0122-43643-73286", "Mark Mywords",
            "3 Third St.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L6987-34532-43334", "Bob Upandown",
            "434 Gatineau Way", "Hull", "QC"));
        pdb.registerDriver(new Driver("L3345-32390-23789", "Carrie Meehome",
            "123 Thurston Drive", "Kanata", "ON"));
        pdb.registerDriver(new Driver("L3545-45396-88983", "Sam Pull",
            "22 Colonel By Drive", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1144-26783-58390", "Neil Down",
            "17 Murray St.", "Nepean", "ON"));
        pdb.registerDriver(new Driver("L5487-16576-38426", "Pete Reedish",
            "3445 Bronson Ave.", "Ottawa", "ON"));
        pdb.registerVehicle(new Vehicle("Honda", "Civic", 2015, "yellow", "W3EW4T"),
            "L0453-65433-87655");
        pdb.registerVehicle(new Vehicle("Pontiac","Grand Prix",2007,"dark green","GO SENS"),
            "L0453-65433-87655");
        pdb.registerVehicle(new Vehicle("Mazda", "RX-8", 2004, "white", "OH YEAH"),
            "L2333-45645-54354");
        pdb.registerVehicle(new Vehicle("Nissan","Altima",2017,"bergundy", "Y6P9O7"),
            "L1234-35489-99837");
        pdb.registerVehicle(new Vehicle("Saturn", "Vue", 2002, "white", "9R6P2P"),
            "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Honda", "Accord", 2018, "gray", "7U3H5E"),
            "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Chrysler", "PT-Cruiser", 2006, "gold", "OLDIE"),
            "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Nissan", "Cube", 2010, "white", "5Y6K8V"),
            "L1948-87265-34782");
        pdb.registerVehicle(new Vehicle("Porsche", "959", 1989, "silver", "CATCHME"),
            "L0678-67825-83940");
        pdb.registerVehicle(new Vehicle("Kia", "Soul", 2018, "red", "J8JG2Z"),
            "L0122-43643-73286");
        pdb.registerVehicle(new Vehicle("Porsche", "Cayenne", 2014, "black", "EXPNSV"),
            "L6987-34532-43334");
        pdb.registerVehicle(new Vehicle("Nissan", "Murano", 2010, "silver", "Q2WF6H"),
            "L3345-32390-23789");
        pdb.registerVehicle(new Vehicle("Honda", "Element", 2008, "black", "N7MB5C"),
            "L3545-45396-88983");
        pdb.registerVehicle(new Vehicle("Toyota", "RAV-4", 2010, "green", "R3W5Y7"),
            "L3545-45396-88983");
        pdb.registerVehicle(new Vehicle("Toyota", "Celica", 2006, "red", "FUNFUN"),
            "L5487-16576-38426");
        return pdb;
    }
    

    public void showInfractionsFor(String license){
        int countInf=0;
        for (int i=0;i<this.numDrivers;i++){
            if(this.drivers[i].toString().contains(license)){
                
                for(int j=0;j<this.numInfractions;j++){
                    if(this.infractions[j].d==this.drivers[i].name){
                        
                        System.out.println(this.infractions[j]);
                        countInf+=1;
                    }
                }
                System.out.println("Total outstanding infractions = " + countInf);
                return;
            }
        }
        
    }
    public Driver[] cleanDrivers(){
        int size=0; //determines the size of the clean array
        int cnt=0; //a counter to go through the clean array
        String infrac="";
        //converting the array of driver objects to a string:
        for(int i=0;i<this.numInfractions;i++){
            infrac+=this.infractions[i].driver.license+" ";
        }
        //determining the size of the clean array:
        for(int i=0;i<this.numDrivers;i++){
            if(!infrac.contains(this.drivers[i].license)){
                size+=1;
            }
        }

        Driver[] a= new Driver[size];
        //storing the clean drivers in the array:
        for(int i=0;i<this.numDrivers;i++){
            if(!infrac.contains(this.drivers[i].license)){
                a[cnt]=this.drivers[i];
                cnt+=1;
            }
            else{
                
            }
        }
        return a;
    }

    public void showInfractionReport(){
        int count=0;//counts the number of infractions the driver got
        int amount=0; //counts the $ amount that the driver payed in infractions

        for(int i=0;i<numDrivers;i++){
            for(int j=0;j<numInfractions;j++){
                if(drivers[i].license==infractions[j].driver.license){
                    count+=1;
                    if(infractions[j].outstanding!=true){
                        amount+=infractions[j].amount;
                    }
                }
            }
            if(count!=0){
                System.out.printf("%s: %d infractions, total payed = $ %d.00\n", drivers[i].name, count, amount);
            }
            else{
                
            }
            amount=0;
            count=0;
        }
    }
}
