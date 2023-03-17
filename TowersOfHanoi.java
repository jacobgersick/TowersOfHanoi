/* 

//Programmer: Jacob Gersick
//Date: 2/23/2023
//Assignment: Lab 5 Towers of Hanoi
//Class: CIS145 w/Jeremiah Ramsey

This program solves the Towers of Hanoi problem for a tower of four disks. 

For extra credit I learned about the Deque interface and ArrayDeque class.
I used three ArrayDeques to represent the three pegs in the problem
and various methods to move discs and report movements.

*/
import java.util.*;

public class TowersOfHanoi{

   public static void main(String[] args) {
   
   //initialize empty towers
      Deque<String> towerA = new ArrayDeque<>();
      Deque<String> towerB = new ArrayDeque<>();
      Deque<String> towerC = new ArrayDeque<>();
   
   //adding 'labels' to the front of the deques
      towerA.addLast("A");
      towerB.addLast("B");
      towerC.addLast("C");
   
   //add initial 'discs' to towerA
      towerA.addLast("####");
      towerA.addLast("###");
      towerA.addLast("##");
      towerA.addLast("#");
   
   //print original state
      System.out.println("Initial State: ");
      System.out.println(towerA);
      System.out.println(towerB);
      System.out.println(towerC);
      System.out.println("------------------------");
   
   //solve tower problem
      move(4,towerA,towerC,towerB);
   
   //print ending state
      System.out.println("Finished State: ");
      System.out.println(towerA);
      System.out.println(towerB);
      System.out.println(towerC);
      System.out.println("------------------------");
   
       
   }//end main


/*
   -- Moves a maximum of one disc to an open or appropriate (larger disc underneath) peg.
   *  discAmount is the amount of discs to be moved
   *  source represents the leftmost peg, which starts with all discs on it
   *  target represents the rightmost peg, which starts empty
   *  spare represents the middle peg, which starts empty
   */
   public static void move(int discAmount, Deque<String> source,
   Deque<String> target, Deque<String> spare) {
   
   //base case of 1 disc to move: prints out and makes the move from source to target
      if (discAmount == 1) {
      
         System.out.println("Moving: " + source.peekLast() + 
         " from " + source.peekFirst() + 
         " to " + target.peekFirst());
         target.addLast(source.removeLast());
         System.out.println("------------------------");
         
      } else { 
      
      //makes the 'spare' peg of current call the new target
      //this which makes way for the disc beneath it 
         move(discAmount-1, source, spare, target);
      
      //prints out and makes the move from (current) source and target
         System.out.println("Moving: " + source.peekLast() +
          " from " + source.peekFirst() +
          " to " + target.peekFirst());
         target.addLast(source.removeLast());
         System.out.println("------------------------");
         
      // makes the 'spare' peg the source for the next call
         move(discAmount-1, spare, target, source);
         
      }//end if
   
   }//end move

}//end class