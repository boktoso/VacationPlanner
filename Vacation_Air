/*
Extends the Vacation class to add variables on if they are travelling by plane.
*/
public class Vacation_Air extends Vacation{
   
   private double costPlane;
   
   Vacation_Air(){
      super("", "", "", null, null);
      this.costPlane = 0;
   }
   
   Vacation_Air(String name, String phone, String vacation, String[] activity, double[]activityCost, double cost){
      super(name, phone, vacation, activity, activityCost);
      this.costPlane = cost;
   }
   
   public double getCostPlane(){ return this.costPlane; }
   
   public boolean setCostPlane(double cost){
      if(cost > 78 && cost < 420){
         this.costPlane = cost;
         return true;
      }
      return false;
   }
   
   public double calculateCost(){
      double totalCost = 0;
      totalCost += costPlane * 13;
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
      output += "Cost per Plane Ticket: " + String.format("$%.2f", this.costPlane) + "\n";
      output += "Total Cost: " + String.format("$%.2f", calculateCost()) + "\n\n";
      return output;
   }
}
