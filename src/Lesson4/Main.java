package Lesson4;

public class Main {
    public static void main(String[] args) {
        //    4. Вывести при помощи методов из пункта 3 ФИО и должность.
        Employee e1 = new Employee("Ivanov Ivan Ivanovich", "Engineer", "+7(911)-356-00-00", 12000, 39);

        System.out.println("Сотрудник: " + e1.getName() + ". Должность: " + e1.getPosition() + ". Телефон: " + e1.getPhoneNumbere() + ". Зарплата: " + e1.getSalary() + ". Возраст: " + e1.getAge());
        System.out.print("---------------------------------------------------------------------------------------------- \n");
        //5. Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        Employee[] staff = new Employee[5];
        staff[0] = new Employee("Ivanov Ivan Ivanovich", "Engineer ", "+7(911)-356-00-00 ", 32000, 39);
        staff[1] = new Employee ("Petrov Petr Petrovich", "QA engineer ", "+7(911)-356-00-01 ", 42000, 24);
        staff[2] =new Employee("Semenov Semen Semenovich ", "Developer ", "+7(911)-356-00-02 ", 52000, 50);
        staff[3] =new Employee("Beluchi Monica Fedorovna", "Product manager ", "+7(911)-356-00-03 ", 62000, 33);
        staff[4] =new Employee("Shevrole Niva Petrovna ", "Director ", "+7(911)-356-00-04 ", 72000, 45);

        for(int i = 0; i < staff.length; ++i) {
            if (staff[i].getAge() > 40) {
                System.out.println(staff[i].getEmployeeInfo());
            }
        }
        System.out.print("---------------------------------------------------------------------------------------------- \n");
        //* 6. Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
        Employee.incSalary(staff, 5000);

        for(int i = 0; i < staff.length; ++i) {
            if (staff[i].getAge() > 45) {
                System.out.println(staff[i].getEmployeeInfo());
            }
        }
        // * 7. Средние арифметические возраста и зарплаты
        System.out.print("---------------------------------------------------------------------------------------------- \n");
        System.out.println(Employee.arithmetic(staff));
        System.out.print("---------------------------------------------------------------------------------------------- \n");
    }
}
