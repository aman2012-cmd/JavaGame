// === File: Board.java ===
package com.brainmentors.gaming;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.brainmentors.gaming.sprites.Enemy;
import com.brainmentors.gaming.sprites.Player;

public class Board extends JPanel {
    Timer timer;
    BufferedImage backgroundImage;
    Player player;
    Enemy enemies[] = new Enemy[3];
    private GameState state = GameState.START;

    public Board() {
        setSize(1500, 950);
        loadBackgroundImage();
        player = new Player();
        loadEnemies();
        gameLoop();
        bindEvents();
        setFocusable(true);
    }

    private void loadBackgroundImage() {
        try {
            backgroundImage = ImageIO.read(Board.class.getResource("game-ab.jpeg"));
        } catch (IOException e) {
            System.out.println("Background Image Not Found....");
            System.exit(1);
            e.printStackTrace();
        }
    }

    private void loadEnemies() {
        int x = 400;
        int gap = 450;
        int speed = 7;
        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new Enemy(x, speed);
            x = x + gap;
            speed = speed + 5;
        }
    }

    private void bindEvents() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if (state == GameState.PLAYING) {
                    player.speed = 0;
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (state == GameState.START && e.getKeyCode() == KeyEvent.VK_ENTER) {
                    state = GameState.PLAYING;
                    timer.start();
                } else if ((state == GameState.GAME_OVER || state == GameState.GAME_WIN) && e.getKeyCode() == KeyEvent.VK_R) {
                    resetGame();
                    state = GameState.PLAYING;
                    timer.start();
                } else if (state == GameState.PLAYING) {
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        player.speed = 10;
                    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        player.speed = -5;
                    }
                }
            }
        });
    }

    private void resetGame() {
        player = new Player();
        loadEnemies();
    }

    private void gameLoop() {
        timer = new Timer(50, (e) -> repaint());
    }

    private boolean isCollide(Enemy enemy) {
        int xDistance = Math.abs(player.x - enemy.x);
        int yDistance = Math.abs(player.y - enemy.y);
        int maxH = Math.max(player.h, enemy.h);
        int maxW = Math.max(player.w, enemy.w);
        return xDistance <= maxW - 80 && yDistance <= maxH - 80;
    }

    private void checkGameOver(Graphics pen) {
        if (player.outOfScreen()) {
            state = GameState.GAME_WIN;
            timer.stop();
            repaint(); // Force immediate repaint to show win message
            return;
        }
        for (Enemy enemy : enemies) {
            if (isCollide(enemy)) {
                state = GameState.GAME_OVER;
                timer.stop();
                repaint(); // Force immediate repaint to show game over message
                return;
            }
        }
    }


    private void printEnemies(Graphics pen) {
        for (Enemy enemy : enemies) {
            enemy.draw(pen);
            enemy.move();
        }
    }

    private void drawStartScreen(Graphics pen) {
        pen.setFont(new Font("Arial", Font.BOLD, 70));
        pen.setColor(Color.WHITE);
        pen.drawString("Press ENTER to Start", 350, 400);
    }

    private void drawGameOverScreen(Graphics pen) {
        pen.setFont(new Font("Arial", Font.BOLD, 70));
        pen.setColor(Color.RED);
        pen.drawString("GAME OVER!", 500, 400);
        pen.setFont(new Font("Arial", Font.PLAIN, 40));
        pen.setColor(Color.WHITE);
        pen.drawString("Press R to Restart", 550, 500);
    }

    private void drawWinScreen(Graphics pen) {
        pen.setFont(new Font("Arial", Font.BOLD, 70));
        pen.setColor(Color.GREEN);
        pen.drawString("CONGRATULATIONS! YOU WON!", 200, 400);
        pen.setFont(new Font("Arial", Font.PLAIN, 40));
        pen.setColor(Color.WHITE);
        pen.drawString("Press R to Play Again", 500, 500);
    }

    @Override
    public void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        pen.drawImage(backgroundImage, 0, 0, 1500, 950, null);

        switch (state) {
            case START:
                drawStartScreen(pen);
                break;
            case PLAYING:
                player.draw(pen);
                player.move();
                printEnemies(pen);
                checkGameOver(pen);
                break;
            case GAME_OVER:
                drawGameOverScreen(pen);
                break;
            case GAME_WIN:
                drawWinScreen(pen);
                break;
        }
    }
}