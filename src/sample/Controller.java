package sample;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelTitle;

    @FXML
    private Button buttonStart;

    @FXML
    private Canvas canvas;

    GraphicsContext gc;

    @FXML
    void startProgram(ActionEvent event)
    {
        double size = 1; //Размер точек

        gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());


        // Создание машины
        Car car = new Car();


        gc.setFill(Color.rgb(194,63,12));
        gc.fillRoundRect(car.getCarX(),car.getCarY(),size,size,size,size);
        System.out.println("X =" + car.getCarX() + "  Y = " + car.getCarY());



        // Создание финиша

        EndPoint endPoint = new EndPoint();
        endPoint.randomizeEndPointCoordinates();
        gc.setFill(Color.rgb(12,33,195));

        while ((endPoint.getEndX() == car.getCarX()) && (endPoint.getEndY() == car.getCarY()))
        {
          endPoint.randomizeEndPointCoordinates();
        }
        gc.fillRoundRect(endPoint.getEndX(),endPoint.getEndY(),size,size,size,size);

        // Создание препятствий

        Wall[] walls = new Wall[2000];
        ArrayList<WallContainer> wallContainerList = new ArrayList<WallContainer>();


        gc.setFill(Color.rgb(0,0,0));
        for (int i = 0; i < 2000; i++)
        {
            walls[i] = new Wall();
            walls[i].randomizeWallCoordinates();


            while (walls[i].getWallY() == car.getCarY() && walls[i].getWallX() == car.getCarX()
                    && (walls[i].getWallY() == endPoint.getEndY()) && (walls[i].getWallX() == endPoint.getEndX()))
            {
                walls[i].randomizeWallCoordinates();
            }

            wallContainerList.add(new WallContainer(walls[i].getWallX(),walls[i].getWallY()));

            gc.fillRoundRect(walls[i].getWallX(),walls[i].getWallY(),size,size,size,size);


        }

        //Запоминаем изначальные координаты автомобиля для дальнейшей перерисовки
        Car carStartCoordinates = new Car();
        carStartCoordinates.setCarX(car.getCarX());
        carStartCoordinates.setCarY(car.getCarY());

        // Создание маршрута до точек
        gc.setFill(Color.rgb(12,194,26));



        while ((car.getCarX() != endPoint.getEndX()) || (car.getCarY() != endPoint.getEndY()))
        {

                if (car.getCarY() < endPoint.getEndY() )
                {
                    if (!wallContainerList.contains(new WallContainer(car.getCarX(),car.getCarY()+1)))
                    {
                        car.moveDown();
                        gc.fillRoundRect(car.getCarX(), car.getCarY(), size, size, size, size);
                    }


                }

                if (car.getCarY() > endPoint.getEndY())
                {
                    if (!wallContainerList.contains(new WallContainer(car.getCarX(),car.getCarY() - 1)))
                    {
                        car.moveUp();
                        gc.fillRoundRect(car.getCarX(), car.getCarY(), size, size, size, size);
                    }
                }

                if (car.getCarX() < endPoint.getEndX())
                {
                    if (!wallContainerList.contains(new WallContainer(car.getCarX() + 1,car.getCarY())))
                    {
                        car.moveRight();
                        gc.fillRoundRect(car.getCarX(), car.getCarY(), size, size, size, size);
                    }
                }

                if (car.getCarX() > endPoint.getEndX())
                {
                    if (!wallContainerList.contains(new WallContainer(car.getCarX() - 1, car.getCarY())))
                    {
                        car.moveLeft();
                        gc.fillRoundRect(car.getCarX(), car.getCarY(), size, size, size, size);
                    }

                }
        }
        // Перерисовка конечных точек

        gc.setFill(Color.rgb(194,63,12));
        gc.fillRoundRect(carStartCoordinates.getCarX(),carStartCoordinates.getCarY(),size,size,size,size);
        gc.setFill(Color.rgb(12,33,195));
        gc.fillRoundRect(endPoint.getEndX(),endPoint.getEndY(),size,size,size,size);


        for (int i = 0; i < wallContainerList.size(); i++)
        {
            System.out.println("Wall Container:::X = " + wallContainerList.get(i).x + " Y = " + wallContainerList.get(i).y);
        }

    }

    @FXML
    void initialize()
    {
        gc = canvas.getGraphicsContext2D();

    }


}
