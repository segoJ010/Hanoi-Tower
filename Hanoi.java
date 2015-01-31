/*
   Name: Juan Segoviano
   Date:02/10/14
   Class: ITCS 2215-002 (W-F 9:30-10:45 am)
   Program: Tower of Hanoi
   Purpose: The purpose of this program is to re-create the popular game
            with the use of recursion.

*/

import java.util.*; 
public class Hanoi 
{
   static ArrayList<Stack<Integer>> towerPegs = new ArrayList<Stack<Integer>>();   //creates an ArrayList to hold the pegs and disks
   static int n = 0; //"n" is for disks; the user will be able to input the # of disks soon*
 
 
   public static void main(String[] args)
   {
       towerPegs.add(new Stack<Integer>());  //-------]
       towerPegs.add(new Stack<Integer>());  //-------] The three pegs used for the game
       towerPegs.add(new Stack<Integer>());  //-------]
    
      Scanner keyboard = new Scanner(System.in);   //*the user will be able to input how many disks he/she wants to use
      System.out.println("How many disks would you like to use? 1-7: ");  
      n = keyboard.nextInt(); 
    
      while(n <= 0 || n >= 8) //the input size must be no less than 1 AND no greater than 7
      {
         System.out.println("The number must be within 1-7. Try again: ");  //the user will have to input a number again
         n = keyboard.nextInt(); 
      } 
    
      makingTheMoves();  //this method is to represent the making of the towers
    
      findTheAnswer(n, 0, 1, 2);   // used to find the solution
    }
 
 
    public static void makingTheMoves()
    {
      Stack<Integer> towersOfHanoi = towerPegs.get(0);
      for(int c = n; c > 0; c--)
      {
         towersOfHanoi.push(c);
      }
      
      findTheAnswer();
     }
       
     public static void findTheAnswer(int n, int first, int auxillary, int last) //The user's input # of disks; the names of the three pegs from left to right
     {
         if(n > 7)
         {
         
            System.out.println("Error; the input is not within the 1-7 range.");
            
         }
         else
         {
            if(n <= 0) 
            {
               return;
            }
          
             findTheAnswer(n-1, first, last, auxillary);
             towerPegs.get(last).push(towerPegs.get(first).pop());
             findTheAnswer();
             findTheAnswer(n-1, auxillary, first, last);
          }
       }
       
       public static void findTheAnswer()
       {
          System.out.println("____________________________________________________");
          System.out.println("F| " + towerPegs.get(0)); //"F" for the first tower peg
          System.out.println("A| " + towerPegs.get(1)); //"A" for the auxillary peg
          System.out.println("L| " + towerPegs.get(2)); //"L" for the last peg
       }
 }

