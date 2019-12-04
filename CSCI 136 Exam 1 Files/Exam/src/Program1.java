import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Scanner;

public class Program1 {
	static ArrayList<Person> people = new ArrayList<Person>() ;
	static ArrayList<String> Allpurchases = new ArrayList<String>() ;
	 ArrayList<Double> coffeepurchases = new ArrayList<Double>() ;

	public static void main(String[] args) throws FileNotFoundException {
		
		//
		readMoneySpentOnCoffee();
		readPeopleFile();
		System.out.println("-----------------------------------------");
		System.out.println("Sum of Coffee Purchases");
		System.out.println("Name"+"\t"+"Coffee Purchased");
		SumofCoffeePurchases();
		System.out.println("-----------------------------------------");
		int chose=0;
		System.out.println("If you want to print out all the individual purchases by a person ");
		System.out.println("Enter 1 : ");
		Scanner myS = new Scanner(System.in);
		chose = myS.nextInt();
		
		if (chose == 1){
			System.out.println("Coffee Purchases");
			System.out.println("Name"+"\t"+"Coffee Purchased");
			CoffeePurchases();
			System.out.println("-----------------------------------------");
		}
		
		

	}
	public static void CoffeePurchases(){

		for (int i = 0; i < people.size();i++)
		{
			String name= people.get(i).getname();
			//double total=people.get(i).sum();
			NumberFormat myForm1 = NumberFormat.getCurrencyInstance();
			//System.out.println(name +"\t"+myForm1.format(total));
			
			ArrayList L=people.get(i).getcoffeepurchases();
			for (int j=0; j < L.size();j++)
			{
				System.out.println(name +"\t"+myForm1.format(L.get(j)));
			}
			
			
			
			
		}
		
		
	}
	public static void SumofCoffeePurchases()
	{
		for (int i = 0; i < people.size();i++)
		{
			String name= people.get(i).getname();
			double total=people.get(i).sum();
			NumberFormat myForm1 = NumberFormat.getCurrencyInstance();
			System.out.println(name +"\t"+myForm1.format(total));
			
			//ArrayList L=people.get(i).getcoffeepurchases();
			/*for (int j=0; j < L.size();j++)
			{
				System.out.println(L.get(j));
				total=total+L.get(j);
			}*/
			
			
			
			
		}
	}
	public static void readMoneySpentOnCoffee() throws FileNotFoundException
	{
		// Add all lines from file MoneySpentOnCoffee.txt to String list
		File myFile = new File("./src/MoneySpentOnCoffee.txt");
		Scanner myScan = new Scanner(myFile);
		//String line = myScan.nextLine();
		while (myScan.hasNextLine()) {
			String line = myScan.nextLine();
			Allpurchases.add(line);
		}
		//System.out.println(Allpurchases.get(60)); for testing only
	}
	public static void readPeopleFile() throws FileNotFoundException
	{
		// read from file people.txt people names and IDs
		File myFile = new File("./src/People.txt");
		Scanner myScan = new Scanner(myFile);
		//String line = myScan.nextLine();
		while (myScan.hasNextLine()) {
			String line = myScan.nextLine();
			String[] lineSplit = line.split("\t");
			if (lineSplit[0]!="")
			{
				int ID =  Integer.parseInt(lineSplit[0]);
				String name = lineSplit[1] + " "+ lineSplit[2];
				//System.out.println(ID + ">>"+name);
				//creating an ArrayList for coffeepurchases to add it to aperson 
				ArrayList<Double> coffeepurchases = new ArrayList<Double>() ;
				double total=0;
				for (int i =0 ; i < Allpurchases.size();i++)
				{
					
					String line2= Allpurchases.get(i);
					String[] lineSplit2 = line2.split("\t");
					
					if (ID == Integer.parseInt(lineSplit2[0]) )
					{
						total=total+Double.parseDouble(lineSplit2[1]);
						//System.out.println(Double.parseDouble(lineSplit2[1]));
						//System.out.println(total);
						coffeepurchases.add(Double.parseDouble(lineSplit2[1]));
					}
					
				}
				//System.out.println(total+"<<<<<<<<<<<<<<<");
				// creating an objects from  Person class
				Person myperson = new Person ( ID , name, coffeepurchases) ;
				//adding person objects to people  Array List
				people.add(myperson);
				
			}
			
			
		
			
		}
	}

}

/*
Scanner myLineScanner = new Scanner(myScan.nextLine());
myLineScanner.useDelimiter("\t");
while(myLineScanner.hasNext())
{
	int ID =  Integer.parseInt(myLineScanner.next());
	String name =myLineScanner.next();
	name = name + " "+ myLineScanner.next();
	
}*/
