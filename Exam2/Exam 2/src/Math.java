
public class Math extends Subject {
	public Math (String name,String subjecttype,String description,int credits,int averagetime )
	{
		super( name, subjecttype, description, credits, averagetime );
	}
	public String study()
	{
		return name+"-"+description+"-"+averagetime ;
	}
}
