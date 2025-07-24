package com.brainmentors.gaming.sprites;

import javax.swing.ImageIcon;

public class Player extends sprite {
    public Player() {
        w = 200;
        h = 200;
        x = 50;
        y = 550;
        image = new ImageIcon(Player.class.getResource("player.gif"));
    }

    public void move() {
        x = x + speed;
    }

    public boolean outOfScreen() {
        return x > 1500;
    }
}
