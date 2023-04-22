
public class CourseDBElement implements Comparable<CourseDBElement> {

	private String courseID;
	private int crn;
	private int numberOfCredits;
	private String roomNumber;
	private String instructorName;


	public CourseDBElement(String courseID, int crn, int numberOfCredits, String roomNumber, String instructorName) {
		this.courseID= courseID;
		this.crn= crn;
		this.numberOfCredits= numberOfCredits;
		this.roomNumber= roomNumber;
		this.instructorName= instructorName;
	}
	
	
	@Override
	public int compareTo(CourseDBElement o) {
		return Integer.compare(crn, o.crn);
	}


	public String getID() {
		return courseID;
	}


	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}


	public int getCRN() {
		return crn;
	}


	public void setCrn(int crn) {
		this.crn = crn;
	}


	public int getNumberOfCredits() {
		return numberOfCredits;
	}


	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}


	public String getRoomNum() {
		return roomNumber;
	}



	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}



	public String getInstructorName() {
		return instructorName;
	}


	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	
	//Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 //Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	@Override
	public String toString() {
		return String.format("Course:%s CRN:%d Credits:%d Instructor:%s Room:%s",
				courseID, crn, numberOfCredits,instructorName,roomNumber );
	}

}
