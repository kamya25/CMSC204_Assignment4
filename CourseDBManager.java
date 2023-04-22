import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface{
	private CourseDBStructure table;
	
	public CourseDBManager(int n) {
		table = new CourseDBStructure(n);
	}

	
	public CourseDBManager() {
		table = new CourseDBStructure(10);
	}


	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		table.add (new CourseDBElement(id, crn, credits, roomNum, instructor));
		
	}

	
	@Override
	public void readFile(File input) throws FileNotFoundException {
		
	
		Scanner data = null;
		try 
		{
			data = new Scanner(input);
			while(data.hasNext())
			{
				add(data.next(), data.nextInt(), data.nextInt(), data.next(), data.next());
			}
		}
		
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found: "+ e.getMessage());
		}
		finally 
		{
			if(data!=null) {
				data.close();
			}
		}
	}
	
	

	@Override
	public ArrayList<String> showAll() {
		return table.showAll();
	}


	@Override
	public CourseDBElement get(int crn) {
		try {
			return table.get(crn);
		} catch (IOException e) {
		   System.out.println("No such element: "+ crn);
		}
		return null;
	}

}
