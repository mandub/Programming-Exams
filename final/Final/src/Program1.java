import java.io.File;
import java.util.Scanner;
import java.util.Stack;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Program1  {
	static Stack<Character> myStack = new Stack<Character>();
	static File myFile = new File("./src/test.html");
	static Scanner myScan ;
	public static void main(String[] args) throws IOException {
		myScan = new Scanner(myFile);
		if (readrecursively()){
			if (myStack.isEmpty())
				System.out.println("The file "+myFile.toString()+ " is a correct syntax of < and /> " );
			else 
				System.out.println("The file "+myFile.toString()+ "  is not viled  syntax of < and /> " );
			}
		else {
			System.out.println("The file "+myFile.toString()+ "  is not viled  syntax of < then /> " );
		}
		

	}
	
	private static boolean readrecursively() {
		if (!myScan.hasNextLine())
		return true;
		else {
			boolean found=false;
			int index = 0;
			String line = myScan.nextLine();
			String []linearray=line.split(" ");
			if (! inlinereadrecursively(line))
			return false;
			return readrecursively();
		}
	}

	private static boolean inlinereadrecursively(String restline) {
		if (restline.length() == 0)
			return true;
		
		char s = restline.charAt(0);
		restline=restline.replaceFirst(Character.toString(s), "");
		if (s=='<')
			myStack.push(s);
		else if (s=='/')
		{
			char s2 = restline.charAt(0);
			restline=restline.replaceFirst(Character.toString(s), "");
			if (s2=='>')
			{
				{
				try {
					myStack.pop();
					
			
				} catch (java.util.EmptyStackException e) {
				    System.out.println("Caught java.util.EmptyStackException: " + e.getMessage());
				    return false;
				} 
				}
				
				
			}
	

		}
		return inlinereadrecursively( restline);
		
	}

}
