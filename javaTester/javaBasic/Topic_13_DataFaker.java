package javaBasic;

import com.github.javafaker.Faker;

public class Topic_13_DataFaker {
	public static void main(String[] args) {
		Faker faker = new Faker();
		System.out.println(faker.business().creditCardNumber());
		System.out.println(faker.address().city());
		System.out.println(faker.name().firstName());
		System.out.println(faker.name().fullName());
		System.out.println(faker.phoneNumber().phoneNumber());
	}
}
