package Lab2;

public class Task1_3 {
    private String lastName;
    private String firstName;
    private String middleName;

    public Task1_3(String lastName, String firstName, String middleName) {
        this.lastName = lastName != null ? lastName : "";
        this.firstName = firstName != null ? firstName : "";
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

    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
}