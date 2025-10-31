package Lab2;

public class Task4_5 {
    private String firstName;
    private String lastName;
    private String middleName;

    public Task4_5(String firstName) {
        this(firstName, "", "");
    }

    public Task4_5(String firstName, String lastName) {
        this(firstName, lastName, "");
    }

    public Task4_5(String firstName, String lastName, String middleName) {
        this.firstName = firstName != null ? firstName : "";
        this.lastName = lastName != null ? lastName : "";
        this.middleName = middleName != null ? middleName : "";
    }

    private boolean isNotEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (isNotEmpty(lastName)) {
            result.append(lastName);
        }

        if (isNotEmpty(firstName)) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(firstName);
        }

        if (isNotEmpty(middleName)) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(middleName);
        }

        return result.toString();
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getMiddleName() { return middleName; }
}