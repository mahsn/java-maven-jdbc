package MavenTest.maven_test.StudentModel;

public class BeanUserPhone {

	private String studentName;
	private String phoneNumber;
	private String studentEmail;
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	@Override
	public String toString() {
		return "studentName=" + studentName + ", phoneNumber=" + phoneNumber + ", studentEmail="
				+ "studentEmail";
	}
	
	
}
