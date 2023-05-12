package sg.edu.nus.iss.task01;
import java.util.Scanner;
//import java.util.Arrays; 

public class Calculator {
    public static void main(String[] args) throws Exception {
    
    System.out.println("Welcome!");
    //Instantiate variables
    double num1= 0.0;
    double num2= 0.0;
    char operator = '+';
    double answer =0.0; 

    //Embed everything in a do-while loop? 

    //Use Scanner object to receive user input
    Scanner scanNum = new Scanner(System.in);

    System.out.println("Please enter first number: "); 
    num1 = scanNum.nextDouble(); 
    System.out.println("Please enter second number: "); 
    num2 = scanNum.nextDouble(); 
    System.out.println("Choose operator (+,-,* or /)");
    operator = scanNum.next().charAt(0); 

    //Use switch statements to calculate
    switch(operator){
        case '+': answer = num1 + num2;
        break; 
        case '-': answer = num1 - num2;
        break; 
        case '/': answer = num1 / num2;
        break; 
        case '*': answer = num1 * num2;
        break; 
        default: 
        System.out.println("Invalid operator used!");
        break; 
    }

    //Show answer
    System.out.println(num1 + " " + operator + " " + num2 + " = " + answer );
    

    //Create $last variable to store last calculated answer
    //New calculations will ovewrrite that

    double $last = answer; 
    double num3 = 0.0; 
    double num4 = 0.0; 
    double answer2 = 0.0; 
   
    double[] Array; 
    Array = new double[1];
    for (int i =0; i <Array.length; i++){
        System.out.println("Last calculated value =" + $last);
    }
    
    //Use Scanner object to receive user input
    Scanner scanNum2 = new Scanner(System.in);

    System.out.println(">>>Please enter first number: "); 
    num3 = scanNum2.nextDouble(); 
    System.out.println(">>>Please enter second number: "); 
    num4 = scanNum2.nextDouble(); 
    System.out.println(">>>Choose operator (+,-,* or /)");
    operator = scanNum2.next().charAt(0); 

    //Use switch statements to calculate
    switch(operator){
        case '+': answer2 = num3 + $last;
        break; 
        case '-': answer2 = num4 - $last;
        break; 
        case '/': answer2 = num3 / $last;
        break; 
        case '*': answer2 = num4 * $last;
        break; 
        default: 
        System.out.println("Invalid operator used! Try again using +, -, * or /");
        break; 
    }

    //Display answer with new $last variable 
    System.out.println((num3) + " " + operator + " " + ($last) + " = " + answer2);
    System.out.println($last + " " + operator + " " + num4 + " = " + answer2);

    System.out.println("Bye bye!"); 

    //Close scanner at the end 
    scanNum.close(); 
    scanNum2.close(); 
    }
}
