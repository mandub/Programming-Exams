import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Driver {
	private static ArrayList<Subject> MyArray = new ArrayList<Subject>() ;
	//private static int [][] t
	public static void main(String[] args) throws FileNotFoundException {
		readAfile();
		printMyArray();
		printrandomlypicksandtotal();
		
		
		

	}
	private static void printrandomlypicksandtotal() {
		// creating 2D array where first row calculates times appear and second row calculates how many minutes of studying
		int [][] Total=new int [MyArray.size()][2];
		for (int j=0;j < Total.length;j++)
		{
			Total[j][0]=0;
			Total[j][1]=0;
		}
		Random randomGenerator = new Random();
		for (int i=0 ;i<200;i++)
		{
		int randomInt = randomGenerator.nextInt(8);
		String [] mystring=MyArray.get(randomInt).study().split("-");
		int studyTime= Integer.parseInt(mystring[2]);
		Total[randomInt][0]=Total[randomInt][0] +1;
		Total[randomInt][1]=Total[randomInt][1] + studyTime ;
		System.out.println((i+1)+ " - this is "+Total[randomInt][0]+"  times for with "+Total[randomInt][1]+" minutes studied for "+MyArray.get(randomInt).toString());
		}
		System.out.println(" - - - - - - - - - - - - - - - - - - -Total - - - - - - - - - - - - - - - - - - - -  - - -");
		for (int x=0;x<MyArray.size();x++)
		{
			System.out.println(" Total Times for Study is : " +Total[x][0]+ " and Total minutes are : "+Total[x][1] + " For course " +MyArray.get(x).getname());
		}
		
	}
	private static void printMyArray() {
		System.out.println(MyArray.size()+" records has been read from the file .");
		for (int i=0;i<MyArray.size();i++){
			System.out.println((i+1)+" - "+MyArray.get(i).toString());
		}
		System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - -");
		
	}
	private static void readAfile() throws FileNotFoundException {
		File myFile = new File("./src/Courses.txt");
		Scanner myScan = new Scanner(myFile);
		myScan.nextLine();
		while (myScan.hasNextLine()) {//
			String line = myScan.nextLine();
			String[] lineSplit = line.split(",");
			String subjecttype =  lineSplit[0];
			String name =  lineSplit[1];
			String description =  lineSplit[2];
			int credits =  Integer.parseInt(lineSplit[3]);
			int averagetime =  Integer.parseInt(lineSplit[4]);
			
			if (subjecttype.equals("ComputerScience"))
			{
				
				ComputerScience mycourse=new ComputerScience( name, subjecttype, description, credits, averagetime );
				MyArray.add(mycourse);
			}
			if (subjecttype.equals("Chemistry"))
			{
				Chemistry mycourse=new Chemistry( name, subjecttype, description, credits, averagetime );
				MyArray.add(mycourse);
			}
			if (subjecttype.equals("Math"))
			{
				Math mycourse=new Math( name, subjecttype, description, credits, averagetime );
				MyArray.add(mycourse);
			}
			if (subjecttype.equals("English"))
			{
				English mycourse=new English( name, subjecttype, description, credits, averagetime );
				MyArray.add(mycourse);
			}
		}
		
	}

}
