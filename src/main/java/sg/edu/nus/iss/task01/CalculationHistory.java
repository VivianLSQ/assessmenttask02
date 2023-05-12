package sg.edu.nus.iss.task01;
import java.util.ArrayList;
import java.util.Scanner;

public class CalculationHistory{
   private double answer = 0.0;
   double $last = answer; 
   double num3 = 0.0; 
   double num4 = 0.0; 
   double answer2 = 0.0; 

   public final static CalculationHistory Instance = new CalculationHistory();
   public final ArrayList<Calculator> History = new ArrayList<Calculator>(); 
   Calculator latestCalculation = new Calculator(); 

   ArrayList<Integer> lastAns = new ArrayList<Integer> (1); {
    for (int i =0; i <=1 ; i++){
        System.out.println("Last calculated value =" + $last);
    }
   }
   
   //Use Scanner object to receive user input
   Scanner scanNum2 = new Scanner(System.in);

  

//Close scanner at the end 
scanNum2.close(); 

}
    
