import java.io.File;
import java.io.FileNotFoundException;
//import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;
public class Driver2 {
	private static ArrayList<Person> People = new ArrayList<Person>() ;

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		readfile();
		System.out.println("List of People befor SelectionSort : ");
		printpeoplelist();
		SelectionSort();
		System.out.println("List of People after SelectionSort : ");
		printpeoplelist();
	}

	private static void SelectionSort() {
		int min;
		Person temp;
		for (int index=0;index < People.size();index++)
		{
			min = index;
			for (int scan=index +1;scan< People.size();scan++)
			{
				if (People.get(scan).compareTo(People.get(min) )<0)
					min=scan;
			}
			temp=People.get(min);
			People.set(min,People.get(index) );
			People.set(index,temp );
		}
		
		
		
	}

	private static void printpeoplelist() {
		for (int i=0;i<People.size();i++)
		{
			System.out.println( (i+1) + " - "+ People.get(i).toString());
		}
		
	}

	private static void readfile() throws FileNotFoundException, ParseException {
		File myFile = new File("./src/people.txt");
		Scanner myScan = new Scanner(myFile);
		myScan.nextLine();
		while (myScan.hasNextLine()) {//String FirstName; String LastName; DateSignedup;
			String line = myScan.nextLine();
			String[] lineSplit = line.split(",");
			String FirstName =  lineSplit[0];
			String LastName =  lineSplit[1];
			String DateSignedup =  lineSplit[2];
			Person myPerson=new Person(FirstName,LastName,DateSignedup);
			People.add(myPerson);
		}
		
	}
}







