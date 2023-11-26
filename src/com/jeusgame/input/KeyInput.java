package com.jeusgame.input;

import com.jeusgame.entity.Entity;
import com.jeusgame.game.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();

        for(Entity entity : Game.handler.entities){

            switch (key) {
                case KeyEvent.VK_W:
                   entity.setVelY(-5);
                    break;
                case KeyEvent.VK_S:
                    entity.setVelY(5);
                    break;
                case KeyEvent.VK_A:
                    entity.setVelX(-5);
                    break;
                case KeyEvent.VK_D:
                    entity.setVelX(5);
                    break;

            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for(Entity entity : Game.handler.entities){

            switch (key) {
                case KeyEvent.VK_W:
                    entity.setVelY(0);
                    break;
                case KeyEvent.VK_S:
                    entity.setVelY(0);
                    break;
                case KeyEvent.VK_A:
                    entity.setVelX(0);
                    break;
                case KeyEvent.VK_D:
                    entity.setVelX(0);
                    break;

            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
//not using
    }
}
