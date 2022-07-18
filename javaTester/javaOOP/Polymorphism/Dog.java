package javaOOP.Polymorphism;

public class Dog extends Animal {
	public void eat() {
		System.out.println("Dog eating...");
	}

	public void showDog() {
		System.out.println("Show dog: -----------");
		eat();
		System.out.println("eye number: " + eyeNumber);
		System.out.println("-----------");
	}

}
