package myspring.customer.vo;

public class CustomerVO {
	
	private Long id;
	private String name;
	private String email;
	private int age;
	private String entryDate;

	// 기본생성자 
	public CustomerVO() {}
	
	public CustomerVO(String name, String email, int age, String entryDate) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.entryDate = entryDate;
	}
	public CustomerVO(Long id, String name, String email, int age, String entryDate) {
		this(name, email, age, entryDate);
		this.id = id;
	}

	// getter와 setter 생성
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	// toString 생성
	@Override
	public String toString() {
		return "CustomerVO [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", entryDate="
				+ entryDate + "]";
	}
}
