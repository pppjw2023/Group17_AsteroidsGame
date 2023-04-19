package com.asteroids.gameObjects;

import com.asteroids.gameController.AsteroidApplication;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Bullet extends GameObject{

    private int ttl = 130;
    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isNew = true;

    public Bullet(double x, double y){
        super(new Polygon(2, -2, 2, 2, -2, 2, -2, -2), x, y);
        this.getGamePolygon().setFill(Color.WHITE);
    }



    public void returnToBarell(Point2D gunPoint){
        this.getGamePolygon().setVisible(false);
        this.setNew(false);
        this.getGamePolygon().setTranslateX(gunPoint.getX());
        this.getGamePolygon().setTranslateX(gunPoint.getY());

    }

    public boolean move(){
        this.getGamePolygon().setTranslateX(this.getGamePolygon().getTranslateX() + this.getMovement().getX());
        this.getGamePolygon().setTranslateY(this.getGamePolygon().getTranslateY() + this.getMovement().getY());

        if (this.getGamePolygon().getTranslateX() < 0) {
            return true;
        }

        if (this.getGamePolygon().getTranslateX() > AsteroidApplication.WIDTH) {
            this.getGamePolygon().setTranslateX(this.getGamePolygon().getTranslateX() % AsteroidApplication.WIDTH);
        }

        if (this.getGamePolygon().getTranslateY() < 0) {
            return true;
        }

        if (this.getGamePolygon().getTranslateY() > AsteroidApplication.HEIGHT) {
            this.getGamePolygon().setTranslateX(this.getGamePolygon().getTranslateX() % AsteroidApplication.HEIGHT);
        }
        ttl --;
        if(ttl <= 0){
            return true;
        }
        return false;
    }


    public boolean hasCollide(LargeAsteroid largeAsteroid) {
        Shape collisionArea = Shape.intersect(this.getGamePolygon, largeAsteroid.getGamePolygon());
        return collisionArea.getBoundsInLocal().getWidth() != -1;
    }

}
