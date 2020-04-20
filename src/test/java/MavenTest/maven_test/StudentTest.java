package MavenTest.maven_test;

import java.util.List;

import org.junit.Test;
import org.w3c.dom.ls.LSInput;

import MavenTest.maven_test.StudentDAO.StudentDAO;
import MavenTest.maven_test.StudentModel.BeanUserPhone;
import MavenTest.maven_test.StudentModel.Students;
import MavenTest.maven_test.StudentModel.Telephone;
import junit.framework.TestCase;

public class StudentTest {
	
	 @Test
	public void shouldSaveStudents() {
		StudentDAO studentDAO = new StudentDAO();
		Students students = new Students();
		students.setStudentName("Tomas");
		students.setStudentEmail("tomas@tomas.com");
		students.setStudentAddress("Rua Tom vista 869");
		students.setStudentFirstExam(90);
		students.setStudentSecondExam(100);
		students.setStudentThirdExam(90);
		studentDAO.saveStudent(students);
	}
	 
	 @Test 
	 public void shouldSaveTelephone() {
		 StudentDAO studentDAO = new StudentDAO();
		 Telephone telephone = new Telephone();
		 telephone.setTelephoneNumber("+551100000000");
		 telephone.setTelephoneType("Cell Phone");
		 telephone.setUserStudent(7);
		 studentDAO.saveTelephone(telephone);
	 }
	 
	 @Test 
	 public void shouldReturnPhoneUsers() {
		 StudentDAO studentDAO  = new StudentDAO();
		 List<BeanUserPhone> listBeanUserPhones  = studentDAO.studentPhoneList(7);
		 for (BeanUserPhone beanUserPhone : listBeanUserPhones) {
			System.out.println(beanUserPhone.toString());
			System.out.println("---------------");
		}
	 }
	 
	 @Test
	 public void shouldReturnAllStudents() {
		 StudentDAO studentDAO = new StudentDAO();
		
		 try {
			
			 List<Students> listStudents = studentDAO.getAllStudents();
			for (Students students : listStudents) {
				System.out.println(students);
				System.out.println("-----------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 
	 @Test
	 public void searchStudents() {
		 StudentDAO studentDAO = new StudentDAO();
		 Students students = studentDAO.searchStudents(1);
		 System.out.println("===>" + students);
		 
	 }
	 
	 @Test
	 public void removeStudent() {
		 StudentDAO studentDAO = new StudentDAO();
		 Students studentRemoved = studentDAO.removeStudent(6);
		 System.out.println(" Student removed " + studentRemoved);
	 }
	 
	 @Test
	 public void updateStudent() {
		 try {
			 StudentDAO studentDAO = new StudentDAO();
			 Students studentUpdate = studentDAO.searchStudents(1);
			 studentUpdate.setStudentName("new name");
			 studentDAO.updateStudentData(studentUpdate);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	 }
}
