import java.util.ArrayList;

public class Person {
	private ArrayList<Double> coffeepurchases = new ArrayList<Double>() ;
	private String name;
	private int ID;
	public Person (int ID , String name,ArrayList coffeepurchases)
	{
		this.ID= ID;
		this.name = name;
		this.coffeepurchases = coffeepurchases;
	}
	public int getID()
	{
		return ID;
	}
	public String getname()
	{
		return name;
	}
	public ArrayList getcoffeepurchases()
	{
		return coffeepurchases;
	}
	public String toStringsum()
	{
		return (name + sum());
		
	}
	public double sum()
	{
		double total=0;
		for (int i=0; i< this.coffeepurchases.size();i++)
		{
			total = total + this.coffeepurchases.get(i);
		}
		return total;
	}


}
