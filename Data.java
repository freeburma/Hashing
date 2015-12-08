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
 	This Data.class will create an object to given input 
 	Key and Value int values. 
 */
public class Data 
{
	 public int key = 0 ;	// Key  
	 public int value = 0;	// V value
	 

     /*
       Initialization the object
      */
     public Data()
     {
    	 key = -1; 
    	 value = -1; 
    	 
     }

     /*
     	Assigning the object
    */
     public Data(int key, int value) 
     {
           this.key = key;
           this.value = value;
     }     

     // Set method
     public void setKey(int key) 
     {

         this.key = key;

     }
     
     // Get method
     public int getKey() 
     {
           return key;
     }

     // Set method
     public void setValue(int value) 
     {
         this.value = value;
     }
     
     // Get method
     public int getValue() 
     {
           return value;
     }
     
    
     /*
      	To dipslay the hash table
      * (non-Javadoc)
      * @see java.lang.Object#toString()
      */
     public String toString() 
     {
         return  key + ", \t  " + value + "\n";
     }
	
	 
}
