package Lab2;

public class Task2_4 {
    private String name;
    private Department department;

    public Task2_4(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public boolean isHeadOfDepartment() {
        return this.department.getHead() == this;
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

class Department {
    private String name;
    private Task2_4 head;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Task2_4 getHead() {
        return head;
    }

    public void setHead(Task2_4 head) {
        this.head = head;
    }
}