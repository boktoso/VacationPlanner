/*
Data Definition Class.
*/
public class Vacation{
   
   private String memName;
   private String phoneNo;
   private String vacationName;
   private String[] activity = new String[5];
   private double[] activityCost = new double[5];
   
   Vacation(){
      this.memName = "";
      this.phoneNo = "";
      this.vacationName = "";
      this.activity = null;
      this.activityCost = null;
   }
   
   Vacation(String name, String phone, String vacation, String[] activity, double[]activityCost){
      this.memName = name;
      this.phoneNo = phone;
      this.vacationName = vacation;
      this.activity = activity;
      this.activityCost = activityCost;
   }
   
   public String getMemName(){ return this.memName; }
   public String getPhoneNo(){ return this.phoneNo; }
   public String getVacationName(){ return this.vacationName; }
   public String getActivity(int x){ return this.activity[x]; }
   public String[] getActivity(){ return this.activity;}
   public double getActivityCost(int x){ return this.activityCost[x]; }
   
   public boolean setMemName(String name){
      if(name != null){
         this.memName = name;
         return true;
      }
      return false;
   }
   
   public void setPhoneNo(String phone){
           this.phoneNo = phone;
   }
   public boolean setVacationName(String vacation){
      if(vacation != null){
         this.vacationName = vacation;
         return true;
      }
      return false;
   }
   public boolean setActivity(String[] activity){
      if(activity != null){
         this.activity = activity;
         return true;
      }
      return false;
   }
   
   public void setActivityCost(double[]cost){
      this.activityCost = cost;
   }
   
   
   public String toString(){
      String output = "";
      output += "Vacation: " + this.vacationName + "\n";
      output += "Family Member Suggested: " + this.memName + "\n";
      output += "Phone Number: " + this.phoneNo + "\n";
      output += "Activites:\n";
      for(int x=0; x < this.activity.length; x++){
         if(this.activity[x] != null){
            output += "   " + this.activity[x] + " Cost Per Person: " + this.activityCost[x] + "\n";
         }      
      }
      output += "\n\n";
      return output;
   }
   
   public double calculateCost(){ return 0;}
   
   public static boolean validatePhoneNo(String phone){
     if(phone.length() == 10){
      for(int x=0; x < 10; x++){
         if(!Character.isDigit(phone.charAt(x))){
			   return false;
         }
      }
      return true;
     }
     return false;
   }
   
   public static boolean validateMemName(String name){
      if(name != null){
         return true;
      }
      return false;
   }
   public static boolean validateVacationName(String vacation){
      if(vacation != null){
         return true;
      }
      return false;
   }
}
