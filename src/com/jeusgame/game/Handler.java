package com.jeusgame.game;

import com.jeusgame.entity.Entity;
import com.jeusgame.tile.Tile;

import java.awt.*;
import java.util.LinkedList;
import java.util.Objects;

public class Handler {

    public LinkedList<Entity> entities = new LinkedList<>();
    public LinkedList<Tile> tiles = new LinkedList<>();

    public void render(Graphics g){
        for(Entity en : entities){
            en.render(g);
        }
        for(Tile t : tiles){
            t.render(g);
        }
    }

    public void tick(){
        for(Entity en : entities){
            en.tick();
        }
        for(Tile t : tiles){
            t.tick();
        }
    }

    public void addEntity(Entity entity){
        entities.add(entity);
    }

    public void removeEntity(Entity entity){
        entities.remove(entity);
    }


    public void addTile(Tile tile){
        tiles.add(tile);
    }

    public void removeTile(Tile tile){
        tiles.remove(tile);
    }

}
