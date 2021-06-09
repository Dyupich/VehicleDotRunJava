    package sample;

    import java.util.Random;

    public class EndPoint
    {
        private int endX;
        private int endY;


        public void randomizeEndPointCoordinates()
        {
            Random random = new Random();

            this.endY = 80 + random.nextInt(600 - 80 + 1);
            this.endX = 0 + random.nextInt(700 - 0 + 1);
        }




        public int getEndX()
        {
            return endX;
        }

        public void setEndX(int endX) {
            this.endX = endX;
        }

        public int getEndY() {
            return endY;
        }

        public void setEndY(int endY) {
            this.endY = endY;
        }
    }
