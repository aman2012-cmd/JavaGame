package com.brainmentors.gaming.sprites;

import javax.swing.ImageIcon;

public class Enemy extends sprite {
    public Enemy(int x, int speed) {
        y = 30;
        this.x = x;
        this.speed = speed;
        w = 200;
        h = 200;
        image = new ImageIcon(Enemy.class.getResource("spider-enemy.gif"));
    }

    public void move() {
        if (y > 900) {
            y = 0;
        }
        y = y + speed;
    }
}

