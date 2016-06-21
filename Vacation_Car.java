/*
Extends the Vacation class to add variables on if they are travelling by car.
*/
public class Vacation_Car extends Vacation{

   private int numOfCars = 4; //HARD SET AS ESTIMATION OF HOW MANY VEHICLES THEY ARE TAKING
   private int numOfMiles;
   private String[] carMakes = new String[numOfCars];
   private double COST_PER_MILE = 0.575;
   
   Vacation_Car(){
      super("", "", "", null, null);
      this.numOfMiles = 0;
      this.carMakes = null;
   }
   
   Vacation_Car(String name, String phone, String vacation, String[] activity, double[]activityCost, int miles, String[] makes){
      super(name, phone, vacation, activity, activityCost);
      this.numOfMiles = miles;
      this.carMakes = makes;
   }
   
   public boolean setNumOfMiles(int miles){
      if((miles <= 426 && miles > 0)){
         this.numOfMiles = miles;
         return true;
      }
      return false;
   }
   
   public boolean setCarMakes(String[] makes){
      if(makes != null){
         this.carMakes = makes;
         return true;
      }
      return false;
   }
   
   public int getNumOfMiles(){ return numOfMiles; }
   public String getCarMakes(int x){ return carMakes[x]; }
   
   public double calculateCost(){
      double totalCost = 0;
      totalCost += this.numOfCars * this.numOfMiles * this.COST_PER_MILE;
      for(int x=0; x < getActivity().length; x++){
         if(getActivity(x) != null){
            totalCost += getActivityCost(x) * 13;
         } 
      }
      return totalCost;
   }
   
   public String toString(){
      String output = "";
      output += "Vacation: " + getVacationName() + "\n";
      output += "Family Member Suggested: " + getMemName() + "\n";
      output += "Phone Number: " + getPhoneNo() + "\n";
      output += "Activites:\n";
      for(int x=0; x < getActivity().length; x++){
         if(getActivity(x) != null){
            output += "   " + getActivity(x) + " Cost Per Person: " + String.format("$%.2f", getActivityCost(x)) + "\n";
         }      
      }
      output += "Number of Cars: " + this.numOfCars + "\n";
      output += "Miles to Drive: " + this.numOfMiles + "\n";
      output += "Car Makes:\n";
      for(int y=0; y < this.carMakes.length; y++){
         output += "   " + this.carMakes[y] + "\n";  
      }
      output += "Total Cost: " + String.format("$%.2f", calculateCost()) + "\n\n";
      return output;
   }
}
