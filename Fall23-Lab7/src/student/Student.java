package student;

public class Student {
	private String ID;
	private String Name;
	private int Age;
	
	public Student(String ID, String name, int age) {
		this.Age = age;
		this.ID = ID;
		this.Name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}
	
}
