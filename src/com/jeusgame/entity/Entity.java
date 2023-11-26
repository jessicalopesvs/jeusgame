package com.jeusgame.entity;

import com.jeusgame.game.Handler;
import com.jeusgame.game.Id;

import java.awt.*;

public abstract class Entity {

    public int x,y;
    public int width, height;

    public boolean solid;

    public int velX, velY;

    public Id id;

    public Handler handler;

    //constructor
    public Entity(int x, int y,int width,int height,  boolean solid, Id id, Handler handler){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.solid = solid;
        this.id = id;
        this.handler = handler;
    }



    public abstract void render(Graphics g);
    public abstract void tick();

    public void die(){
        handler.removeEntity(this);

    }


    //Getters and setters

    public Id getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isSolid() {
        return solid;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
}
