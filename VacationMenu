/*
This is Assigment 8 for IT 206.
We are keeping track of at the most 13 vacation recommendations.
Each family member enters a phone number to register the vacation.
Each phone number must be unique.
Each vacation must have 1-5 activities that are less than $25 per person
Each vacation is either travel by Car or Plane
Prices must be valid per type.
*/
import javax.swing.JOptionPane;
public class VacationMenu{
   
   public static final int MAX_RECOMMENDATION = 13;
   public static void main(String[] args){
      Vacation[] vacation = new Vacation[MAX_RECOMMENDATION];
      printMenu(vacation);
   }
   
   public static void printMenu(Vacation[] vacation){
      
      int index = 0;
      String[] exPhoneNo = new String[13];
      int num_OF_NUMS = 0;
      Object[] options = {"Add Vacation", "Print Full List", "Print Lowest Cost", "Print Highest Cost", "Exit"};
      boolean quit = false;
      do{
      
    	  	int option = JOptionPane.showOptionDialog(null,
    	  		"What would you like to do?","Vacation Menu", 
    	  		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
    	  		null,options,options[0]);
    	  	
    	  	switch(option){
    	  	case 0: vacation[index] = addVacation(exPhoneNo, num_OF_NUMS);
               index++;
               JOptionPane.showMessageDialog(null, "Vacation Added.");
    	  			break;
    	  	case 1: printList(vacation);
    	  			break;
    	  	case 2: printCheap(vacation);
    	  			break;
         case 3: printExpensive(vacation);
               break;      
    	  	case 4: quit=true;
    	  			break;
  			default: //should never hit this point, but just in case, some code is available
  				throw new RuntimeException("Unexpected Error!");
    	  	}
      } while (!quit);
   }
   
   public static Vacation addVacation(String[] exPhoneNo, int num_OF_NUMS){
      int numOfActivities;
      int vacationType;
      boolean set = false;
      
      String phoneNo = "";
      do{
         phoneNo = JOptionPane.showInputDialog(null, "Enter the phone number to provide (only one entry is allowed per number):");
         for(int x = 0; x < exPhoneNo.length; x++){
            if(exPhoneNo[x] != ""){
               if(phoneNo == exPhoneNo[x]){
                  JOptionPane.showMessageDialog(null, "That phone number already exists.");
                  phoneNo = "";
               }
            }
         }
         if(Vacation.validatePhoneNo(phoneNo)){
            JOptionPane.showMessageDialog(null, "Number successfully entered.");
            exPhoneNo[num_OF_NUMS] = phoneNo;
            num_OF_NUMS++;
         }
         else{ JOptionPane.showMessageDialog(null, "Number Invalid."); phoneNo = ""; }
      }while(phoneNo == "");
      
      String name;
      do{
         name = JOptionPane.showInputDialog(null, "Enter your name:");
         if(!Vacation.validateMemName(name)){
            JOptionPane.showMessageDialog(null, "Name invalid.");
         }
      }while(!Vacation.validateMemName(name));
      
      String vacation;
            do{
         vacation = JOptionPane.showInputDialog(null, "Enter The Vacation Name:");
         if(!Vacation.validateVacationName(vacation)){
            JOptionPane.showMessageDialog(null, "Vacation Name invalid.");
         }
      }while(!Vacation.validateVacationName(vacation));
      
      String[] activities = new String[5];
      double[] activityCost = new double[5];
      int count = 0;
      boolean cont = true;
      do{
         String activityTest = JOptionPane.showInputDialog(null, "Enter the name of the activity:");
         while(activityTest == null){
            activityTest = JOptionPane.showInputDialog(null, "Error, invalid entry.\nEnter the name of the activity:");
         }
         activities[count] = activityTest;
         
         activityCost[count] = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the cost of the activity (between 0.01 and 24.99):"));
         while((activityCost[count] <= 0) || (activityCost[count] >= 25)){
            activityCost[count] = Double.parseDouble(JOptionPane.showInputDialog(null, "Error, invalid entry.\nEnter the cost of the activity (between 0.01 and 24.99):"));
         }
         count++;
         if(count < 5){
            int choice;
            choice = JOptionPane.showConfirmDialog(null, "Do you have another activity (maximum 5)?", null, JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION){
               cont = true;
            }
            else{ cont = false; break;}
         }
      }while((count < 5) &&(cont = true));
      
      
      Object[] options = {"Travel By Car", "Travel By Plane"};
      int option = JOptionPane.showOptionDialog(null,
    	  		"How will you be travelling?","Travel Menu", 
    	  		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
    	  		null,options,options[0]);
    	  	
    	  	switch(option){
    	  	case 0: vacationType = 1; //Travel by Car
    	  			break;
    	  	case 1:vacationType = 2; //Travel by Plane
    	  			break;
         default: //should never hit this point, but just in case, some code is available
  				throw new RuntimeException("Unexpected Error!");
         }
      if(vacationType == 1){
         int miles = 0;
         String[] makes = new String[4];
         miles = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the amount of miles to drive:"));
         while(miles <= 0){
            miles = Integer.parseInt(JOptionPane.showInputDialog(null, "Invalid Amount of Miles.\nEnter the amount of miles to drive:"));
         }
         for(int i=0; i < 4; i++){
            String test;
            test = JOptionPane.showInputDialog(null, "Enter the Make for Car #" + (i+1));
            if(test == null){
               JOptionPane.showMessageDialog(null, "Error Invalid Entry.");
            }
            else{ makes[i] = test; }
         }
         
         Vacation newVacation = new Vacation_Car(name, phoneNo, vacation, activities, activityCost, miles, makes);
         return newVacation;
      }
      else{
         double planeCost = 0;
         planeCost = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the price of each plane ticket (must be between $79 and $419):"));
         while(planeCost < 79 || planeCost > 419){
            planeCost = Double.parseDouble(JOptionPane.showInputDialog(null, "Invalid Amount.\nEnter the price of each plane ticket (must be between $79 and $419):"));
         }
         Vacation newVacation = new Vacation_Air(name, phoneNo, vacation, activities, activityCost, planeCost);
         return newVacation;
      }
   }
   
   public static void printList(Vacation[] vacation){
      String vacations = "Vacation Recommendations: \n";
      for(int x=0; x < vacation.length; x++){
         if(vacation[x] != null){
            vacations += vacation[x].toString();
         }
      }
      JOptionPane.showMessageDialog(null, vacations);
   }
   
   public static void printCheap(Vacation[] vacation){
      double cheapest = 999999;  //default to allow the lowest cost to override.
      int index = 0;
      for(int x=0; x < vacation.length; x++){
         if(vacation[x] != null){
            if(vacation[x].calculateCost() < cheapest){
               cheapest = vacation[x].calculateCost();
               index = x;
            }
         }
      }
      
      String output = "Lowest Costing Vacation:\n";
      output += vacation[index].toString();
      JOptionPane.showMessageDialog(null, output);
   }
   
   public static void printExpensive(Vacation[] vacation){
      double expensive = 0; //default to allow more expensive to override
      int index = 0;
      for(int x=0; x < vacation.length; x++){
         if(vacation[x] != null){
            if(vacation[x].calculateCost() > expensive){
               expensive = vacation[x].calculateCost();
               index = x;
            }
         }
      }
      
      String output = "Highest Costing Vacation:\n";
      output += vacation[index].toString();
      JOptionPane.showMessageDialog(null, output);
   }
   
}
