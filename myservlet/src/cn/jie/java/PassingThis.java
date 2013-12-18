package cn.jie.java;

public class PassingThis {
		  public static void main(String[] args) {
			  
			Apple apple = new Apple();
			Person person = new Person();
		    person.eat(apple);
		  }
}
class Person {
	  public void eat(Apple apple) {
		System.out.println(apple);
	    Apple peeled = apple.getPeeled();
	    System.out.println("Yummy");
	  }
	}
	class Peeler {
	  static Apple peel(Apple apple) {
		  System.out.println("Ï÷Æ¤");
	    // ... remove peel
	    return apple; // Peeled
	  }
	}
	class Apple {
	  Apple getPeeled() {
		System.out.println(this);
		return Peeler.peel(this); 
		  }
	}