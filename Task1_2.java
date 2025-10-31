package Lab2;

public class Task1_2 {
    private String name;
    private int height;

    public Task1_2(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return name + ", рост: " + height;
    }
}