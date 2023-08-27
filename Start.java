import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;
public class Start {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management App");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Press 1 to ADD Student");
			System.out.println("Press 2 to Delete Student");
			System.out.println("Press 3 to Display Student");
			System.out.println("Press 4 to Update Student's Phone with name");
			System.out.println("Press 5 to Update Student's City with id");
			System.out.println("Press 6 to exit app");
			
			int c = Integer.parseInt(br.readLine());
			
			if(c == 1) {
				// add student
				System.out.println("Enter student name : ");
				String name = br.readLine();
				
				System.out.println("Enter student phone : ");
				String phone = br.readLine();
				
				System.out.println("Entere student city : ");
				String city = br.readLine();
				
				//create student object to store student
				Student st = new Student(name, phone, city);
				System.out.println(st);
				boolean answer = StudentDao.insertStudentToDao(st);
				
				if(answer) {
					System.out.println("student added successfully");
				}else {
					System.out.println("something went wrong, please try again...");
				}
				
				
			}else if(c == 2) {
				// delete student
				System.out.println("Enter student ID to be delete : ");
				int userId = Integer.parseInt(br.readLine());
				
				boolean answer = StudentDao.deleteStudentId(userId);
				
				if(answer) {
					System.out.println("Student deleted...");
				}else {
					System.out.println("Something wrong, please try again...");
				}
				
				
				
			}else if(c == 3) {
				//display student
				StudentDao.displayAll();
				
			}else if(c == 4) {
				//update student phone
				System.out.println("Enter student name to be updated : ");
				String name = br.readLine();
				
				System.out.println("Enter student phone : ");
				String phone = br.readLine();
				
				Student st = new Student(name, phone);
				boolean ans = StudentDao.updateStudentPhone(st);
				if(ans) {
					System.out.println("Student updated successfully");
				}else {
					System.out.println("Something wrong, please try again...");
				}
			}
			
			
			else if(c == 5) {
				//update student city
				System.out.println("Enter student's Id to update city : ");
				int userId = Integer.parseInt(br.readLine());
				
				System.out.println("Enter student's new city : ");
				String city = br.readLine();
				
				Student st = new Student();
				st.setStudentId(userId);
				st.setStudentCity(city);
				
				boolean ans = StudentDao.updateStudentCity(st);
				
				if(ans) {
					System.out.println("City updated successfully");
				}else {
					System.out.println("Something went wrong, please try again");
				}
				
				
			}else if(c == 6) {
				//exit
				break;
			}else {
				
			}
			
		}
		System.out.println("Thanks for using my application");
		System.out.println("See you soon...Bye Bye");
	}
	

}
























