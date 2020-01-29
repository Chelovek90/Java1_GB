package Lesson4;

public class Employee {
    private String name;
    private String position;
    private String phoneNumber;
    private int salary;
    private int age;
    // 2. Конструктор класса должен заполнять эти поля при создании объекта;
    Employee(String name, String position, String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }
    // 3. Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
    public String getName() {
        return this.name;
    }
    public String getPosition() {
        return this.position;
    }
    public String getPhoneNumbere() {
        return this.phoneNumber;
    }
    public int getSalary() {
        return this.salary;
    }
    public int getAge() {
        return this.age;
    }
    public String getEmployeeInfo() {
        return "Сотрудник: " + this.name + ". Должность: " + this.position + ". Телефон: " + this.phoneNumber + ". Зарплата: " + this.salary + ". Возраст: " + this.age;
    }
    //* 6. Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
    private void setSalary(int n) {
        this.salary += n;
    }

    public static void incSalary(Employee[] staff, int n) {
        for(int i = 0; i < staff.length; ++i) {
            if (staff[i].getAge() > 45) {
                staff[i].setSalary(n);
            }
        }
    }

    public static String arithmetic(Employee[] staff) {
        float sumAge = 0.0F;
        float sumSalary = 0.0F;

        for(int i = 0; i < staff.length; ++i) {
            sumAge += (float)staff[i].getAge();
            sumSalary += (float)staff[i].getSalary();
        }
        return "Средний возраст сотрудников = " + sumAge / (float)staff.length + ". \nСредняя зарплата сотрудников = " + sumSalary / (float)staff.length;
    }
}
