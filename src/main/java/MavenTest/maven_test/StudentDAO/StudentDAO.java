package MavenTest.maven_test.StudentDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.ls.LSInput;

import com.mysql.cj.xdevapi.PreparableStatement;

import MavenTest.maven_test.DatabaseConnection;
import MavenTest.maven_test.StudentModel.BeanUserPhone;
import MavenTest.maven_test.StudentModel.Students;
import MavenTest.maven_test.StudentModel.Telephone;

public class StudentDAO {
	
	private Connection connection;
	
	public StudentDAO() {
		this.connection = DatabaseConnection.getDatabaseConnection();
	}
	
	public void saveStudent(Students students) {
		
		try {
			
			String sql = "INSERT INTO studentsdatabase.students "
					+ "(studentName,studentEmail, studentAddress, studentFirstExam, studentSecondExam, studentThirdExam) "
					+ "values (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, students.getStudentName());
			preparedStatement.setString(2, students.getStudentEmail());
			preparedStatement.setString(3, students.getStudentAddress());
			preparedStatement.setInt(4, students.getStudentFirstExam());
			preparedStatement.setInt(5, students.getStudentSecondExam());
			preparedStatement.setInt(6, students.getStudentThirdExam());
			preparedStatement.execute();
			connection.commit(); // save in database
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public void saveTelephone(Telephone telephone) {
		try {
			
			String sqlTelephone = "INSERT INTO studentsdatabase.telephoneuser "
					+ "(telephoneNumber,telephoneType, userStudent) "
					+ "values (?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sqlTelephone);
			preparedStatement.setString(1, telephone.getTelephoneNumber());
			preparedStatement.setString(2, telephone.getTelephoneType());
			preparedStatement.setLong(3, telephone.getUserStudent());
			preparedStatement.execute();
			connection.commit(); // save in database
			
		} catch (Exception e) {
			
			try {
				connection.rollback();
			} catch ( SQLException e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public List<BeanUserPhone> studentPhoneList(int studentId) {
		List<BeanUserPhone> sBeanUserPhones = new ArrayList<BeanUserPhone>();
		
		String sql = "select telephoneNumber, studentName, studentEmail ";
			sql	  += " from telephoneuser  as TL  inner join students as SD ";
			sql	  += " on SD.studentId = TL.userStudent ";
			sql	  += " where SD.studentId = " + studentId;
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BeanUserPhone beanUserPhone = new BeanUserPhone();
				beanUserPhone.setStudentName(resultSet.getString("studentName"));
				beanUserPhone.setPhoneNumber(resultSet.getString("telephoneNumber"));
				beanUserPhone.setStudentEmail(resultSet.getString("studentEmail"));
				sBeanUserPhones.add(beanUserPhone);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sBeanUserPhones;
	}
	
	
	public List<Students> getAllStudents() {
		
		List<Students> listStudents = new ArrayList<Students>();
		
		try {
			
			String sql = "select * from studentsdatabase.students";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Students students = new Students();
				students.setStudentId(resultSet.getInt("studentId"));
				students.setStudentName(resultSet.getString("studentName"));
				students.setStudentEmail(resultSet.getString("studentEmail"));
				students.setStudentAddress(resultSet.getString("studentAddress"));
				students.setStudentFirstExam(resultSet.getInt("studentFirstExam"));
				students.setStudentSecondExam(resultSet.getInt("studentSecondExam"));
				students.setStudentThirdExam(resultSet.getInt("studentThirdExam"));
				listStudents.add(students);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listStudents;
	}
	
	public Students searchStudents(int studentId) {
		Students studentFound = new Students();
		try {
			
			String sql = "select * from studentsdatabase.students where studentId=" + studentId;
			PreparedStatement preparedStatement  = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
		
			if (resultSet.next()) {
				studentFound.setStudentId(resultSet.getInt("studentId"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return studentFound;
	}
	
	public Students removeStudent(int studentId) {
		Students student = this.searchStudents(studentId);
		
		try {
			
			String sql = "delete from studentsdatabase.students where studentId=" + student.getStudentId();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.commit(); // save in database
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
	
	public void updateStudentData(Students students) {
		
		try {
			
			String sql = "update studentsdatabase.students set studentName = ? where studentId = " + students.getStudentId();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, students.getStudentName());
			preparedStatement.execute();
			connection.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
