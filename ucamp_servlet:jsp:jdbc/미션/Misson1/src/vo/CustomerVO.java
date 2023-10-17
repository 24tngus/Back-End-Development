package vo;

public class CustomerVO {
	private int id;
	private String name;
	private String email;
	private int age;
	private String entryDate;
	
	public CustomerVO() { // 기본 생성자
		
	}

	public CustomerVO(int id, String name, String email, int age, String entryDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.entryDate = entryDate;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	public String getEntryDate() {
		return entryDate;
	}

	@Override
	public String toString() {
		return "CustomerVO [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", entryDate=" + entryDate
				+ "]";
	}
}
