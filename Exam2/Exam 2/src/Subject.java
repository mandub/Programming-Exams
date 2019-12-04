
public class Subject {
	protected String name;
	protected String subjecttype;
	protected String description;
	protected int credits;
	protected int averagetime;
	public Subject(String name,String subjecttype,String description,int credits,int averagetime )
	{
		this.name=name;
		this.subjecttype=subjecttype;
		this.description=description;
		this.credits=credits;
		this.averagetime=averagetime;

	}
	public String getname()
	{
		return name;
	}
	
	public String study()
	{
		return name+"-"+description+"-"+averagetime ;
	}
	
	public String toString()
	{
		return "Course name : "+name+" , Course type : " +subjecttype+" , description : "+description+" , credits : "+credits+" Hours , average time to Study : " +averagetime+" minutes";
	}

}
