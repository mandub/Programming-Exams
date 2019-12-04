
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Person {
	private String FirstName;
	private String LastName;
	private Date DateSignedup;
	public Person (String FirstName,String LastName,String newdate) throws ParseException
	{
		this.FirstName=FirstName;
		this.LastName=LastName;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
		Date DateSignedup = dateFormat.parse(newdate);
		this.DateSignedup=DateSignedup;
		
	}
	/*Return Value
0 if the argument Date is equal to this Date; a value less than 0 
if this Date is before the Date argument; and a value greater than
 0 if this Date is after the Date argument.*/
	
	public int compareTo(Person other) {
	    return this.DateSignedup.compareTo(other.DateSignedup) ;
		
	}
	public String toString()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
		
		return "FirstName : "+FirstName+ "\t , LastName : " +LastName + "\t , Date Signed up : "+dateFormat.format(DateSignedup) ;//+ DateSignedup.toString();//
	}

}
