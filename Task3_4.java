package Lab2;

import java.util.ArrayList;
import java.util.List;

public class Task3_4 {
    private String name;
    private Department3_4 department;

    public Task3_4(String name, Department3_4 department) {
        this.name = name;
        this.department = department;
        this.department.addEmployee(this);
    }

    public String getName() {
        return name;
    }

    public Department3_4 getDepartment() {
        return department;
    }

    public boolean isHeadOfDepartment() {
        return this.department.getHead() == this;
    }

    public List<Task3_4> getDepartmentEmployees() {
        return this.department.getEmployees();
    }

    @Override
    public String toString() {
        if (isHeadOfDepartment()) {
            return name + " начальник отдела " + department.getName();
        } else {
            return name + " работает в отделе " + department.getName() +
                    ", начальник которого " + department.getHead().getName();
        }
    }
}

class Department3_4 {
    private String name;
    private Task3_4 head;
    private List<Task3_4> employees;

    public Department3_4(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Task3_4 getHead() {
        return head;
    }

    public void setHead(Task3_4 head) {
        this.head = head;
    }

    public void addEmployee(Task3_4 employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
    }

    public List<Task3_4> getEmployees() {
        return new ArrayList<>(employees);
    }

    public int getEmployeeCount() {
        return employees.size();
    }
}