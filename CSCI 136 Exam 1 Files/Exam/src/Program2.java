import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program2 {
	

	public static void main(String[] args) throws FileNotFoundException {
		//Initialize the array size to 5 Student objects.
		Student [] myArrayList=new Student[5];

		//Read in the student file and create Student objects
		myArrayList=readfile(myArrayList);
	
		printmyArrayList(myArrayList);
		//System.out.println(size(myArrayList));

	}
	public static Student get(Student [] myArrayList , int index)
	{
		//Create a get method to get items out of the ArrayList
		Student myStudent=null;
		for (int i=0 ; i < myArrayList.length;i++)
		{
			if (myArrayList[i] != null)
				if (i == index)
					myStudent=myArrayList[i];
			
		}
		
		return myStudent;
	}
	public static void printmyArrayList(Student [] myArrayList)
	{
		for (int i=0 ; i < myArrayList.length;i++)
		{
			if (myArrayList[i] != null)
				//print out each of the objects by using a get method
				System.out.println(get(myArrayList,i).tostring());
		}
		
	}
	
	public static Student [] expand(Student [] myArrayList)
	{
		//expand the array (double its size) and copy all the previous items into the new array
		//System.out.println(myArrayList.length);
		Student[] tmp = new Student[2*myArrayList.length];
		    System.arraycopy(myArrayList,0,tmp,0,myArrayList.length); 
		    myArrayList = tmp;
		    return myArrayList;
	}
	public static void add(Student [] myArrayList, Student newStudent)
	{
		int newindex=0;
		boolean myboolean= true;
		for (int i =0 ; i < myArrayList.length;i++)
		{
			if (myArrayList[i] != null)
			{
				++newindex;
				
			}
			else if (myboolean)
			{
				myArrayList[newindex]= newStudent;
				myboolean=false;
			}
				
		}
	}
	public static int size(Student [] myArrayList)
	{
		//Create a size method to keep track of how large the ArrayList
		int size=0;
		for (int i =0 ; i < myArrayList.length;i++)
		{
			if (myArrayList[i] != null)
			{
				++size;
			}
				
		}
		
		return size;
	}

	public static Student [] readfile(Student [] myArrayList) throws FileNotFoundException
	{

		// read from file students.dat students names, IDs and Total Points Earned
		File myFile = new File("./src/students.dat");
		Scanner myScan = new Scanner(myFile);
		int counter=0;
		while (myScan.hasNextLine()) {
			String line = myScan.nextLine();
			String[] lineSplit = line.split("\t");
			if (lineSplit[0]!="")
			{
				String name = lineSplit[0];// + " "+ lineSplit[2];
				int ID =  Integer.parseInt(lineSplit[1]);
				double TotalPointsEarned= Double.parseDouble(lineSplit[2]);
				//Read in the student file and create Student objects
				Student mystudent= new Student (ID, name, TotalPointsEarned);
				
				if (counter < myArrayList.length)
				{
					//Store each object into the array you created
					//Create an add method to add items to the ArrayList
					add(myArrayList,mystudent);
					//System.out.println(myArrayList[counter].tostring()+">>>>>>>>>>>>>"+counter);

				}	
				else
				{
					//expand method when the number of items read in exceeds the size of the array
					Student []temp=expand(myArrayList);
					myArrayList= temp;
					//Store each object into the array you created
					//Create an add method to add items to the ArrayList
					add(myArrayList,mystudent);
					//System.out.println(myArrayList[counter].tostring() +">>>>>>>>>>>>>"+counter);
					

				}
			}
			counter++;
		}
		//System.out.println(counter);
		return myArrayList;	
	}

}
