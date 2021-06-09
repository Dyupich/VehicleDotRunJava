package sample;

import java.util.Random;

public class Car
{
    private int carX;
    private int carY;


    ////////////////////////////////////////////////////////////////////////
    // Конструктор
    ////////////////////////////////////////////////////////////////////////

    public Car()
    {
        Random random = new Random();
        // range in [a;b] = a + random.nextInt(b - a + 1);
        this.carY = 80 + random.nextInt(600 - 80 + 1); // random in range y = [80;600]
        this.carX = 0 + random.nextInt(700 - 0 + 1); // random in range x = [0;700]
    }



    ////////////////////////////////////////////////////////////////////////
    // Методы изменяющие передвижение машины
    ////////////////////////////////////////////////////////////////////////

    public void moveLeft()
    {
        this.carX = carX - 1;
    }

    public void moveRight()
    {
        this.carX = carX + 1;
    }

    public void moveUp()
    {
        this.carY = carY - 1;
    }

    public void moveDown()
    {
        this.carY = carY + 1;
    }
    ////////////////////////////////////////////////////////////////////////
    // Геттеры и сеттеры
    ////////////////////////////////////////////////////////////////////////

    public int getCarX() {
        return carX;
    }

    public void setCarX(int carX) {
        this.carX = carX;
    }

    public int getCarY() {
        return carY;
    }

    public void setCarY(int carY) {
        this.carY = carY;
    }
}
