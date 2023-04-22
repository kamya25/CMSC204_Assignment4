import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{

	int GetHash(CourseDBElement element) {
		return (""+ element.getCRN()).hashCode() % getTableSize();
	}
	
	int GetHash(int crn) {
		return (""+ crn).hashCode() % getTableSize();
	}
	
	
	public static int fourKPlus3(int n, double loadfactor) {
		boolean fkp3 = false;
		boolean aPrime = false;
		int prime, highDivisor, d;
		prime = (int)(n/loadfactor);
		if(prime % 2 == 0)
			prime = prime+1;
		while(fkp3==false) {
			while(aPrime == false)
			{
				highDivisor = (int)(Math.sqrt(prime)+0.5);
				 for(d = highDivisor; d>1; d--) {
					 if(prime % d == 0)
						 break;
				 }
				 if(d!=1)
					 prime +=2;
				 else
					 aPrime = true;
			}
			if((prime-3)%4==0)
				fkp3= true;
			else {
				prime+=2;
				aPrime = false;
			}
		}
		return prime;
		
	}
	
	private LinkedList <CourseDBElement>[] array;
	
	
	public CourseDBStructure(int n){
		array= new LinkedList[fourKPlus3(n, 1.5)];
	}

	public CourseDBStructure(String string, int i) {
		array= new LinkedList[fourKPlus3(i, 1.5)];
	}
	
	

	@Override
	public void add(CourseDBElement element) {
		try {
			get(element.getCRN());
			return;
		}catch(IOException e) {
			
		}
		LinkedList<CourseDBElement> list = array[GetHash(element)];
		if(list==null)
		{
			list = new LinkedList<>();
			array[GetHash(element)]=list;
		}
		list.add(element);
		list.sort(null);
	}

	
	@Override
	public CourseDBElement get(int crn) throws IOException {
		LinkedList<CourseDBElement> list=  array[GetHash(crn)];
		if(list==null)throw new IOException();
		for(CourseDBElement e: list) {
			if(e.getCRN()== crn)return e;
		}
		throw new IOException();
	}

	//Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 //Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200

	
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> lines = new ArrayList<>();
		for(int i = 0; i < array.length; i++) {
		 LinkedList<CourseDBElement> list=  array[i];
		 if(list!=null) {
			 for(CourseDBElement e: list) {
				 lines.add(e.toString());
				}
		 }
		}
		return lines ;
	}

	@Override
	public int getTableSize() {
		return array.length;
	}
}
