package javaOOP.Polymorphism;

public class Testing {

	public static void main(String[] args) {
		Animal ani = new Animal();
		ani.eat();

		Dog husky = new Dog();
		husky.eat();
		husky.showDog();
		husky.eyeNumber = 2;
		husky.showDog();

		Cat cat = new Cat();
		cat.eat();

		// Upcasting
		ani = new Dog();
		ani.eat();

	}
}
