package com.jeusgame.game;

import com.jeusgame.entity.Player;
import com.jeusgame.input.KeyInput;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

    public static final int WIDTH = 270;
    public static final int HEIGHT = WIDTH/14*10;
    public static final int SCALE = 4;

    private Thread thread;
    private boolean running = false;

    public static Handler handler;

    public Game(){
        Dimension size = new Dimension(WIDTH*SCALE, HEIGHT*SCALE);
        setPreferredSize(size);
        setMaximumSize(size);
        setMaximumSize(size);
    }

    private void init(){
        handler = new Handler();
        handler.addEntity(new Player(200,200,64,64,true,Id.PLAYER, handler));
        addKeyListener(new KeyInput());

    }


    public synchronized void start(){
        if(running) {return;}

        running = true;
        thread = new Thread(this,"Start thread");
        thread.start();


    }

    private synchronized void stop() throws InterruptedException {
        if(!running) {return;}
        running = false;
        try{
            thread.join();}
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        init();
        requestFocus();
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        double delta = 0.0;
        int frames = 0;
        double ns = 1000000000.0/60.0;
        int ticks = 0;

        while (running){
            long now = System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime = now;

            while (delta>= 1){
                tick();
                ticks++;
                delta--;
            }

            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer+=1000;
                System.out.println(frames + " Frames per second " + ticks + " updates per second");
                frames = 0;
                ticks = 0;
            }
        }


        try {
            stop();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void render(){
        //buffer stratefy
        BufferStrategy bs = getBufferStrategy();

        if(bs == null){
            createBufferStrategy(3);
            return;
        }

        //create graphics
        Graphics g = bs.getDrawGraphics();

        g.setColor(new Color(124,28,97));
        g.fillRect(0,0,getWidth(),getHeight());
        handler.render(g);
        g.dispose();
        bs.show();

    }

    public void tick(){
        handler.tick();

    }




}
