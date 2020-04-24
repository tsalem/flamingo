import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Student_ex {

    public static void main(String [] args) {
		
		// Create a student object
		Student student1 = new Student("William", "CS", 3.9);
		System.out.println( student1.toString() );
		
		Student student2 = new Student("Scott", "CS", 3.6);
		
		System.out.println( student2.toString());
		
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		studentList.add(student1);
		studentList.add(student2);
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object stream.bin"));
			
			oos.writeObject(studentList);
			oos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Students read from object stream:");
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object stream.bin"));
			
			ArrayList<Student> fileStudentList = (ArrayList<Student>) ois.readObject();
			
			for(Student student:fileStudentList)
				System.out.println(student);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
}

class Student implements Serializable {
	
	// Declare variables or properties
	String name, major;
	double cgpa;
	
	public Student(String name, String major, double cgpa) {
		this.name = name;
		this.major = major;
		this.cgpa = cgpa;
	}

	/**
	 * It returns a string with student information
	 * @return A String with student information
	 */
	public String toString() {
		return name + " " + major + " " + cgpa;
	}	
}




