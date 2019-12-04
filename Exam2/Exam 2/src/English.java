
public class English extends Subject {
	public English (String name,String subjecttype,String description,int credits,int averagetime )
	{
		super( name, subjecttype, description, credits, averagetime );
	}
	public String study()
	{
		return name+"-"+description+"-"+averagetime ;
	}
}
