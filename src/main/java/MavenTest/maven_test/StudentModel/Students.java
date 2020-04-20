package MavenTest.maven_test.StudentModel;

public class Students {
	
	private int studentId;
	private String studentName;
	private String studentEmail;
	private String studentAddress;
	private int studentFirstExam;
	private int studentSecondExam;
	private int studentThirdExam;
	
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public int getStudentFirstExam() {
		return studentFirstExam;
	}
	public void setStudentFirstExam(int studentFirstExam) {
		this.studentFirstExam = studentFirstExam;
	}
	public int getStudentSecondExam() {
		return studentSecondExam;
	}
	public void setStudentSecondExam(int studentSecondExam) {
		this.studentSecondExam = studentSecondExam;
	}
	public int getStudentThirdExam() {
		return studentThirdExam;
	}
	public void setStudentThirdExam(int studentThirdExam) {
		this.studentThirdExam = studentThirdExam;
	}
	@Override
	public String toString() {
		return "Students [studentId=" + studentId + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ ", studentAddress=" + studentAddress + ", studentFirstExam=" + studentFirstExam
				+ ", studentSecondExam=" + studentSecondExam + ", studentThirdExam=" + studentThirdExam + "]";
	}
	
	
}
