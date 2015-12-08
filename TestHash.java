/*
 	Project 			: Assignment 4 (Hashing)

 	Date 				: 11 June 2015
 	Project Description : This project will add the 3 different input
 	 					  and detect collision. If collision found, it 
 	 					  it will call resolve method and solve it.
 	 					  I solved with openAddressing, Linear probing and
 	 					  quantatic probing.  
 */

/*
  This TestHash.class will input the data and display the all 
  information of the hash table. 
  This will display the whole hash table, collision value, number of 
  slots used. 
  
  Finally, it will display the "progrma finished" for debugging purpose.
 */

public class TestHash 
{
	public static void main(String args [])
	{
		
		 System.out.println("Output the entire list :"); 
		 System.out.println("\n\nIndex " + "\t " + " Key");
		 
		 // Creating an object which pass the size of the array
		 MyHashtable  test2 = new MyHashtable (1001);
		 
		 // Adding data to the hash table by student key
		 for (int i = 1201100; i <= 1201400; i++)
		 {
			 test2.put(i, i);
		 }
		 
		 for (int i = 1302250; i <= 1302550; i++)
		 {
			 test2.put(i, i);
		 }
		 
		 for (int i = 1403400; i <= 1403700; i++)			
		 {
			 test2.put(i, i);
		 }
		 
		 
		 //test2.displayKey();
		 // Displaying the all the index 
		 System.out.println(test2);
		
		 // Looking searching for the key - Checking big O(1)
		 //System.out.println("Is 1403700 in the array : " + test2.find(1302549));
		 //System.out.println("Comparison " + test2.comparison());
		 
		 // Reseting the comparison for next search
		 test2.restComparison();
		 
		 // Printing the Collision and Count 
		 System.out.println("\nCollison Occurs : " + test2.collison());
		 System.out.println("\n\nUsed Slot : " + test2.count());
		 
		
		 
		System.out.println("\n\nProgram finished"); 
	}// End main

}
