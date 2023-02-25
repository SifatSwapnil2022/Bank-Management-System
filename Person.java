public class Person {

	private String firstName;
	private String lastName;
	private String idCard;
	private String phoneNumber;
	private String address;
	private String email;
	private String gender;

	public Person() {

	}

	public void setAccount(String firstName, String lastName, String idCard, String gender, String phoneNumber,
			String email, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idCard = idCard;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getAccountPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAccountAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccountEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountFirstName() {
		return firstName;
	}

	public String getAccountLastName() {
		return lastName;
	}

	public String getAccountIdCard() {
		return idCard;
	}

	public String getAccountGender() {
		return gender;
	}
}
