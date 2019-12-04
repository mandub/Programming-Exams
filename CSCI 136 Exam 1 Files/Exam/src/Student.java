
public class Student {
	//Name, StudentID, and their TotalPointsEarned
	private int StudentID;
	private String name;
	private double TotalPointsEarned;
	public Student(int StudentID,String name,double TotalPointsEarned)
	{
		this.StudentID=StudentID;
		this.name=name;
		this.TotalPointsEarned=TotalPointsEarned;
		
	}
	
	public int getStudentID()
	{
		return StudentID;
	}
	public String getname()
	{
		return name;
	}
	public double getTotalPointsEarned()
	{
		return TotalPointsEarned;
	}
	public String tostring()
	{
		return "StudentID : "+StudentID+"\t Name : "+name+ "\tTotal Points Earned : "+TotalPointsEarned;
	}
	

}
