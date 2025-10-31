package Lab2;

public class Task5_1 {
    private int bulletCount;

    public Task5_1(int initialBullets) {
        this.bulletCount = initialBullets;
    }

    public Task5_1() {
        this.bulletCount = 5;
    }

    public int getBulletCount() {
        return bulletCount;
    }

    public void shoot() {
        if (bulletCount > 0) {
            System.out.println("Бах!");
            bulletCount--;
        } else {
            System.out.println("Клац!");
        }
    }

    public boolean isLoaded() {
        return bulletCount > 0;
    }

    @Override
    public String toString() {
        return "Пистолет {" +
                "патронов=" + bulletCount +
                ", состояние=" + (isLoaded() ? "заряжен" : "разряжен") +
                '}';
    }
}