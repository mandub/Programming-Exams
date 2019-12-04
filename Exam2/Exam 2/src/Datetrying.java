import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Datetrying {

	public static void main(String[] args) throws ParseException {
		System.out.println("Hi");
		
		
		/*DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
		try {
			Date date = formatter.parse(test);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//System.out.println(dateFormat.format(dateFormat.parse("31/05/2011")));
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
		String test = "31-12-1969 23:00:00.000";
		Date date = dateFormat.parse(test);
		System.out.println(dateFormat.format(date));
	}

}








