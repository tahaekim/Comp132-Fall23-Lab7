package course;

public class Course {
	private String Code;
	private String Title;
	private int Capacity;
	private boolean isOffered;
	
	public Course(String code, String title, int capacity, boolean isOffered) {
		this.Code = code;
		this.Title = title;
		this.Capacity = capacity;
		this.isOffered = isOffered;
	}

	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int capacity) {
		this.Capacity = capacity;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public boolean isOffered() {
		return isOffered;
	}

	public void setOffered(boolean isOffered) {
		this.isOffered = isOffered;
	}
	
}
