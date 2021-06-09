package sample;

import java.util.Random;

public class Wall
{
    private int wallX;
    private int wallY;

    public void randomizeWallCoordinates()
    {
        Random random = new Random();
        this.wallY = 80 + random.nextInt(600 - 80 + 1);
        this.wallX = 0 + random.nextInt(700 - 0 + 1);
    }

    ////////////////////////////////////////////////////////////////////////
    // Геттеры и сеттеры
    ////////////////////////////////////////////////////////////////////////


    public int getWallX() {
        return wallX;
    }

    public void setWallX(int wallX) {
        this.wallX = wallX;
    }

    public int getWallY() {
        return wallY;
    }

    public void setWallY(int wallY) {
        this.wallY = wallY;
    }


}
