package demo1;

public class Person {

	private String name;
	private int age;
	private String msg = "hello world";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Person(){}
	
	private Person(String name){
		this.name = name;
		System.out.println(name);
	}
	
	public void fun(){
		System.out.println("fun");
	}
	
	public void fun(String name , int age){
		System.out.println("�ҽ�"+name+"������"+age+"�ꡣ");
	}
}
