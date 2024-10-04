// package Assignment6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Person{
    private String name;
    private int age;
    private int salary;
    public Person(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
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
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", salary=" + salary + "]";
    }
}

public class Problem3 {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        list.add(new Person("Ram", 24, 2000));
        list.add(new Person("Shyam", 14, 2000));
        list.add(new Person("rakesh", 34, 2000));
        list.add(new Person("Raju", 44, 2000));
        list.add(new Person("kalu", 99, 2000));
        list.add(new Person("Kamal", 67, 2000));

        list.sort(Comparator.comparingInt(person -> person.getAge()));

        list.forEach(System.out::println);
    }
}
