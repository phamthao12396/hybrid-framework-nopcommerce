package utilities;

import com.github.javafaker.Faker;

public class DataFaker {
	// private Locale local = new Locale("vi");
	private Faker faker = new Faker();

	public static DataFaker getData() {
		return new DataFaker();
	}

	public String getFirstName() {
		return faker.name().firstName();
	}

	public String getLastName() {
		return faker.name().lastName();
	}

	public String getEmail() {
		return faker.internet().emailAddress();
	}

	public String getPassword() {
		return faker.internet().password();
	}

	public String getCity() {
		return faker.address().cityName();
	}

	public String getPhoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}

	public String getAddress() {
		return faker.address().streetAddress();
	}

}
