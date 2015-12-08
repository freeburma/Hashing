import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

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
 	This method will get Data.class java file and put the objects 
 	in the correct hash table. This will calculate the number of 
 	collision occurs, how many slots have been use and 
 	collision resolution. 
 	
 	 Aslo, this method will display the hash table. 
 */

public class MyHashtable 
{
	private int capacity = 0;	// The size of the hash table
	private int collision = 0; 	// Detaching the collision
	private int countSlot = 0;  // Counting the number of slot used	
	private int checkComparison = 0; // Comparison for big O(n)
	 
	// The object array of the Data class 
    LinkedList <Data> [] table;
    
    // Integer array 
    int [] keyArray; 
    
    /**
   		Constructor 
     * @param size - the size of array
     */
    public MyHashtable (int size) 
    {
    	// Assigning the capacity 
        this.capacity = size; 
    	
        // Initialization the int array
        keyArray = new int [capacity]; 
        
        // Fill the array with -1 for Collision 
        Arrays.fill(keyArray, -1); 
        
        // Initialization the Obj array
    	table = new LinkedList[capacity];
        
    	// Initialization the Obj array
        for (int i = 0; i < capacity; i++)
        {
                table[i] = new LinkedList ();
        }                                   

    }
    
    /*
 		This method will return the new Set for Data array.
     */
    private Set <Data> entrySet ()
    {
    	// Creating a new HashSet. 
    	Set <Data> set = new HashSet <Data> (); 
    	
    	// Looping through the whole list
    	for (int i = 0; i < capacity; i++)
    	{
    		if (table [i] != null)
    		{
    			LinkedList <Data> bucket = table [i]; 
    			
    			for (Data d : set)
    	    	{
    	    		set.add(d);  
    	    	}
    		}
    	}
    	
    	return set; 
    }
    
    /*
     	This method will increase the array size by double and then 
     	it it will create a new linked list and override the oldone.
     */
    private void rehash ()
    {
    	Set <Data> set = entrySet (); 
    	
    	capacity = capacity * capacity; 
    	
    	table = new LinkedList [capacity]; 
    	
    	countSlot = 0; 
    	
    	for (Data d : set)
    	{
    		// Store the new value in the table
    		put (d.getKey(), d.getValue()); 
    	}
    	
    }

    /**
     This method will find the in the array. 
     The searching time is O(1)
    * @param key 	- key to find
   
    */

	public int get(int key)
    {
		// Getting the hash index
        int hash = hashCode (key);

        // Checking the empty array
          if (table[hash] != null )
          {
            // Searching the index
          	LinkedList <Data> bucket = table [hash]; 
          	
            // Looking for key in the index
          	for (Data entry : bucket)
          	{
          		
          		if (entry.getKey() == (key))
          			return entry.getValue(); 
          	}

          }
          
          // Found the key
          return -1; 

    }
    
	

	// Return the collison value
	public int collison ()
	{
	 return collision; 
	}

	// Return the count value
	public int count ()
	{
	 return countSlot; 
	}
	
	// Return the int value for comparison
	 public int comparison ()
	 {
		 return checkComparison; 
	 }
	 
	 // Reseting the variable for next input
	 public void restComparison ()
	 {
		 checkComparison = 0; 
	 }
	 
	 /*
		This method will resolve with Opening addressing
	*/
	 private int hashCode (int key)
	 {
		 return (key % (capacity - 1)); 
	 }
	
	 /**
	  This method will find the in the array. 
	  The searching time is O(1)
	  * @param key 	- key to find
	  * @return		- found key or not
	  */
	  
	 public boolean find (int key)
	 {
		if (get (key) != -1)
			return true; 
		else 
			return false; 
	 }
	 
	 /**
	  This method will look for the collision key. 
	  * @param key		- the key
	  * @param value	- the value of the obj
	  * @param hash		- hash index in the array
	  * @return
	  */
	 
	 public boolean collisionDetection (int key, int value, int hash)
	 {
		// Checking the collision
		 if (keyArray [hash] != -1)
		 {
			// Collision found
	    	return true; 
		 }
		 else
		 {
			// Collision not found
			 keyArray [hash] = key; 
			 return false; 
		 }
	 }
	 
	 /*
	  	This method will resolve with linear probing
	  */
	 public int resolveLinear (int key)
	 {
		 int hash = (key  + 7) % (capacity - 1);  
		 
		 return hash; 
	 }
	 
	 /*
		This method will resolve with quart-antic probing
	*/
	public int resolveQuardantic (int key)
	{
		int hash = (key  + 7 ^ 2) % (capacity - 1);
		 
		 return hash; 
	}
 
 
  public void put(int key, int value) 
  { 
	  	// Calculating the hash index for open addressing. 
	 	int hash = hashCode (key);
	 	
	 	// Checking for the first item
	    if (table[hash] == null)
	    {	        
	    	++countSlot;
	      	table [hash]= new LinkedList <Data>(); 
	      	
	    }
  		
	    
         
	    ///*
	    // Checking the collison
        if (collisionDetection (key, value, hash))
        {
          ++countSlot;
          table [hash].add(new Data (hash, value));
           
          
        }
        else
        {
        	
        	//System.out.println("Collision Occur at Index : " + hash + " Key : " + key);
        	int hashLinear = resolveLinear (key); 
        	
        	// Checking the collison
        	if (collisionDetection (key, value, hashLinear))
            {
        	  ++countSlot;
              table [hash].add(new Data (hashLinear, value));
             
              
            }
        	else 
        	{
        		// Using the Quantatic Approach
        		int hashQuardantic = resolveQuardantic (key); 
        		
        		// Checking the hash index is less than the size of the array 
        		if (hashQuardantic < capacity)
        		{
        			// Checking the collison
	            	if (collisionDetection (key, value, hashQuardantic))
	                {
	                  table [hash].add(new Data (hashQuardantic, value));
	                  ++ countSlot; 
	                  
	                }
	            	else 
	            		collision ++;	// Counting for collision
        		}
        		else 
        		{
        			collision ++; // Counting for collision
        			System.out.println("The array hashIndex : " + hashQuardantic + " is bigger than array index ");
        			System.out.println("Insertion abort"); 
        			
        		}
        	}
        	
        }
        //*/
         
    }
	
  /*
   	This method will display a key for collision. 
   	This method is very handy for testing. 
   */
  public void displayKey ()
	{
		for (int i = 0; i < capacity; i++)
		{
			System.out.println(keyArray [i]); 
		}
			
	}
  
  /*
   This method will display the whole list of data and key. 
   This will be printing out key by key.  
   * (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  public String toString ()
  {
  	StringBuilder builder = new StringBuilder ();
  	String word = ""; 
  	for (int i = 0; i < table.length; i++)
  	{
  		if (table [i] != null && table [i].size() > 0)
	    		for (Data entry : table [i])
	    		{
	    			builder.append (entry); 
	    			
	    		}
  	}
  	//builder.append(); 
  	
  	return builder.toString();  
  }

	

}
