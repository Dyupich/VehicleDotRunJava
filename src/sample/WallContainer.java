package sample;

import java.util.Objects;

public class WallContainer
{
    public int x;
    public int y;

    public WallContainer(int x, int y)
    {
        this.x = x;
        this.y = y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WallContainer that = (WallContainer) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
