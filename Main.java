package Lab2;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        task1_2_Class(scanner);
        System.out.println();
        task1_3_Class(scanner);
        System.out.println();
        task2_4_Class(scanner);
        System.out.println();
        task3_4_Class(scanner);
        System.out.println();
        task4_5_Class(scanner);
        System.out.println();
        task5_1_Class(scanner);

        scanner.close();
    }

    // Задание 1.2
    public static void task1_2_Class(Scanner scanner) {
        System.out.println("ЗАДАНИЕ 1.2");

        int number = getPositiveInt(scanner, "Введите количество человек: ");

        for (int i = 0; i < number; i++) {
            System.out.println("\nЧеловек " + (i + 1));
            String name = getNonEmptyInput(scanner, "Введите имя: ");
            int height = getPositiveInt(scanner, "Введите рост (см): ");
            Task1_2 person = new Task1_2(name, height);
            System.out.println(person);
        }
    }

    // Задание 1.3
    public static void task1_3_Class(Scanner scanner) {
        System.out.println("ЗАДАНИЕ 1.3");

        int totalCount = getPositiveInt(scanner, "Введите количество имен для создания: ");

        for (int i = 0; i < totalCount; i++) {
            System.out.println("\nИмя " + (i + 1));
            String lastName = getLettersInput(scanner, "Введите фамилию (или Enter чтобы пропустить): ", false);
            String firstName = getLettersInput(scanner, "Введите имя: ", true);
            String middleName = getLettersInput(scanner, "Введите отчество (или Enter чтобы пропустить): ", false);

            Task1_3 name = new Task1_3(lastName, firstName, middleName);
            System.out.println(name);
        }
    }

    // Задание 2.4
    public static void task2_4_Class(Scanner scanner) {
        System.out.println("ЗАДАНИЕ 2.4");

        System.out.print("Введите название отдела: ");
        String deptName = scanner.nextLine();
        Department department = new Department(deptName);

        int count = getPositiveInt(scanner, "Введите количество сотрудников в отделе: ");

        Task2_4[] employees = new Task2_4[count];
        for (int i = 0; i < count; i++) {
            String name = getLettersInput(scanner, "Фамилия сотрудника " + (i + 1) + ": ", true);
            employees[i] = new Task2_4(name, department);
        }

        Task2_4 head = null;
        while (head == null) {
            String nameHead = getLettersInput(scanner, "Введите фамилию начальника отдела: ", true);
            for (Task2_4 emp : employees) {
                if (emp.getName().equals(nameHead)) {
                    head = emp;
                    break;
                }
            }
            if (head == null) {
                System.out.println("Сотрудник с фамилией '" + nameHead + "' не найден! Попробуйте снова.");
            }
        }
        department.setHead(head);

        for (Task2_4 emp : employees) {
            System.out.println(emp);
        }
    }

    // Задание 3.4
    public static void task3_4_Class(Scanner scanner) {
        System.out.println("ЗАДАНИЕ 3.4");

        System.out.print("Введите название отдела: ");
        Department3_4 department = new Department3_4(scanner.nextLine());

        int count = getPositiveInt(scanner, "Введите количество сотрудников в отделе: ");

        Task3_4[] employees = new Task3_4[count];

        for (int i = 0; i < count; i++) {
            String name = getLettersInput(scanner, "Фамилия сотрудника " + (i + 1) + ": ", true);
            employees[i] = new Task3_4(name, department);
        }

        Task3_4 head = null;
        while (head == null) {
            String nameHead = getLettersInput(scanner, "Введите фамилию начальника: ", true);

            for (Task3_4 emp : employees) {
                if (emp.getName().equals(nameHead)) {
                    head = emp;
                    break;
                }
            }

            if (head == null) {
                System.out.println("Сотрудник с фамилией '" + nameHead + "' не найден! Попробуйте снова.");
            }
        }

        department.setHead(head);

        for (Task3_4 emp : employees) {
            System.out.println(emp);
        }

        if (employees.length > 0) {
            Task3_4 sampleEmployee = employees[0];
            List<Task3_4> departmentEmployees = sampleEmployee.getDepartmentEmployees();

            System.out.println("Все сотрудники отдела " + department.getName() + ":");
            for (Task3_4 emp : departmentEmployees) {
                String headMark = emp.isHeadOfDepartment() ? " (начальник)" : "";
                System.out.println("- " + emp.getName() + headMark);
            }
            System.out.println("Всего сотрудников в отделе: " + department.getEmployeeCount());
        }
    }

    // Задание 4.5
    public static void task4_5_Class(Scanner scanner) {
        System.out.println("ЗАДАНИЕ 4.5");

        int totalCount = getPositiveInt(scanner, "Введите количество имен для создания: ");

        for (int i = 0; i < totalCount; i++) {
            System.out.println("\nИмя " + (i + 1));
            String lastName = getLettersInput(scanner, "Введите фамилию (или Enter чтобы пропустить): ", false);
            String firstName = getLettersInput(scanner, "Введите имя: ", true);
            String middleName = getLettersInput(scanner, "Введите отчество (или Enter чтобы пропустить): ", false);

            Task4_5 name;
            if (!lastName.isEmpty() && !middleName.isEmpty()) {
                name = new Task4_5(firstName, lastName, middleName);
            } else if (!lastName.isEmpty()) {
                name = new Task4_5(firstName, lastName);
            } else {
                name = new Task4_5(firstName);
            }
            System.out.println(name);
        }
    }

    // Задание 5.1
    public static void task5_1_Class(Scanner scanner) {
        System.out.println("ЗАДАНИЕ 5.1");

        int bulletCount = getPositiveInt(scanner, "Введите количество патронов (0 для пистолета по умолчанию): ");

        Task5_1 interactiveGun;
        if (bulletCount == 0) {
            interactiveGun = new Task5_1();
            System.out.println("Создан пистолет по умолчанию: " + interactiveGun.toString());
        } else {
            interactiveGun = new Task5_1(bulletCount);
            System.out.println("Создан пистолет: " + interactiveGun.toString());
        }

        int shootCount = getPositiveInt(scanner, "Введите количество выстрелов: ");
        System.out.println("Стреляем " + shootCount + " раз:");
        for (int i = 1; i <= shootCount; i++) {
            System.out.print("Выстрел " + i + ": ");
            interactiveGun.shoot();
        }
        System.out.println("Финальное состояние: " + interactiveGun.toString());
    }

    private static int getPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int number = Integer.parseInt(scanner.nextLine().trim());
                if (number >= 0) return number;
                System.out.println("Число не может быть отрицательным!");
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число!");
            }
        }
    }

    private static String getLettersInput(Scanner scanner, String prompt, boolean required) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!required && input.isEmpty()) return input;
            if (input.isEmpty()) {
                System.out.println("Поле не может быть пустым!");
                continue;
            }
            if (input.matches("[a-zA-Zа-яА-ЯёЁ\\s-]+")) return input;
            System.out.println("Поле должно содержать только буквы, пробелы и дефисы!");
        }
    }

    private static String getNonEmptyInput(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Поле не может быть пустым!");
            }
        } while (input.isEmpty());
        return input;
    }
}