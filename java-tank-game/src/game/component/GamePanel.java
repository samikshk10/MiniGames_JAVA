package game.component;


import game.obj.Bullet;
import game.obj.Player;
import game.obj.Etank;
import game.obj.sound.Sound;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

public class GamePanel extends JComponent {

    private Graphics2D g2;
    private BufferedImage image;
    private int width;
    private int height;
    private Thread thread;
    private boolean start = true;
    private Key key;
    private int shotTime;
    File scoreFile;
    public int highscore=0;

    FileWriter fileWriter;

    //  Game FPS
    private final int FPS = 60;
    private final int TARGET_TIME = 1000000000 / FPS;
    //  Game Object
    private Sound sound;
    private Player player;
    private List<Bullet> bullets;
    private List<Etank> tankss;

    private int score = 0;
    private int rocketlauncher= 10;


    public void start() {
        try {
            highscore= getHighScore();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        width = getWidth();
        height = getHeight();
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (start) {
                    long startTime = System.nanoTime();
                    drawBackground();
                    try {
                        drawGame();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    render();
                    long time = System.nanoTime() - startTime;
                    if (time < TARGET_TIME) {
                        long sleep = (TARGET_TIME - time) / 1000000;
                        sleep(sleep);
                    }
                }
            }
        });
        initObjectGame();
        initKeyboard();
        initBullets();
        thread.start();
    }

    private void addtank() {
        Random ran = new Random();
        int locationY = ran.nextInt(height - 50) + 25;
        Etank tank = new Etank();
//        BossTank btanks = new BossTank();
        tank.changeLocation(0, locationY);
//        btanks.changeLocation(0,locationY);
        tank.changeAngle(0);
        tankss.add(tank);
       // btank.add(btanks);
        if(score==2){
            Etank tank1 = new Etank();
            tank1.changeSpeed(30f);
        }

        int locationY2 = ran.nextInt(height - 50) + 25;
        Etank tank2 = new Etank();
        tank2.changeLocation(width, locationY2);
        tank2.changeAngle(180);
        tankss.add(tank2);
    }

    private void initObjectGame() {
        sound = new Sound();
        player = new Player();
        player.changeLocation(150, 150);
        tankss = new ArrayList<>();
    //    btank = new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (start) {
                    addtank();
                    sleep(3000);
                }
            }
        }).start();
    }

    private void resetGame() throws IOException {
        score = 0;
        rocketlauncher=5;
        tankss.clear();
         highscore= getHighScore();
        //btank.clear();
        bullets.clear();
        player.changeLocation(150, 150);
        player.reset();
    }

    private void initKeyboard() {
        key = new Key();
        requestFocus();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    key.setKey_left(true);
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    key.setKey_right(true);
                } else if (e.getKeyCode() == KeyEvent.VK_W) {
                    key.setKey_w(true);
                }
                else if (e.getKeyCode() == KeyEvent.VK_S) {
                    key.setKey_s(true);
                } else if (e.getKeyCode() == KeyEvent.VK_O) {
                    key.setKey_o(true);
                } else if (e.getKeyCode() == KeyEvent.VK_P) {
                    key.setKey_p(true);
                } else if (e.getKeyCode() == KeyEvent.VK_R) {
                    key.setKey_r(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    key.setKey_left(false);
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    key.setKey_right(false);
                } else if (e.getKeyCode() == KeyEvent.VK_W) {
                    key.setKey_w(false);
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    key.setKey_s(false);
                } else if (e.getKeyCode() == KeyEvent.VK_O) {
                    key.setKey_o(false);
                } else if (e.getKeyCode() == KeyEvent.VK_P) {
                    key.setKey_p(false);
                } else if (e.getKeyCode() == KeyEvent.VK_R) {
                    key.setKey_r(false);
                }
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                float s = 0.5f;
                while (start) {
                    if (player.isAlive()) {
                        float angle = player.getAngle();
                        if (key.isKey_left()) {
                            angle -= s;
                        }
                        if (key.isKey_right()) {
                            angle += s;
                        }
                        if (key.isKey_o() || (key.isKey_p() && rocketlauncher>0)) {
                            if (shotTime == 0) {
                                if (key.isKey_o()) {
                                    bullets.add(0, new Bullet(player.getX(), player.getY(), player.getAngle(), 5, 3f,1));
                                } else {
                                    rocketlauncher--;
                                    bullets.add(0, new Bullet(player.getX(), player.getY(), player.getAngle(), 20, 3f,2));
                                }
                                sound.soundShoot();
                            }
                            shotTime++;
                            if (shotTime == 15) {
                                shotTime = 0;
                            }
                        } else {
                            shotTime = 0;
                        }
                        if (key.isKey_w()) {
                            player.speedUp();
                        } else {
                            player.speedDown();
                        }

                        if (key.isKey_s()) {
                            player.speedDecrease();
                        } else {
                            player.speedDown();
                        }
                        player.update();
                        player.changeAngle(angle);
                    } else {
                        if (key.isKey_r()) {
                            try {
                                resetGame();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    for (int i = 0; i < tankss.size(); i++) {
                        Etank tank = tankss.get(i);
                        if (tank != null) {
                            tank.update();
                            if (!tank.check(width, height)) {
                                tankss.remove(tank);
                            } else {
                                if (player.isAlive()) {
                                    checkPlayer(tank);

                                }
                            }
                        }
                    }
                    //for boss tank
//                    for (int i = 0; i < btank.size(); i++) {
//                        BossTank tank = btank.get(i);
//                        if (tank != null) {
//                            tank.update();
//                            if (!tank.check(width, height)) {
//                                btank.remove(tank);
//                                } else {
//                                    if (player.isAlive()) {
//                                       checkPlayer1(tank);
//
//                                }
//                            }
//                        }
//                    }
                    sleep(5);
                }
            }
        }).start();
    }

    private void initBullets() {
        bullets = new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (start) {
                    for (int i = 0; i < bullets.size(); i++) {
                        Bullet bullet = bullets.get(i);
                        if (bullet != null) {
                            bullet.update();
                            collisionbullets(bullet);
                            if (!bullet.check(width, height)) {
                                bullets.remove(bullet);
                            }
                        } else {
                            bullets.remove(bullet);
                        }
                    }

                    sleep(1);
                }
            }
        }).start();
    }

    private void collisionbullets(Bullet bullet) {
        for (int i = 0; i < tankss.size(); i++) {
            Etank tank = tankss.get(i);
            if (tank != null) {
                Area area = new Area(bullet.getShape());
                area.intersect(tank.getShape());
                if (!area.isEmpty()) {
                    if (!tank.updateHP(bullet.getSize())) {

                        score++;
                        tankss.remove(tank);
                        sound.soundDestroy();
                        double x = tank.getX() + Etank.etanksize / 2;
                        double y = tank.getY() + Etank.etanksize / 2;
                    } else {
                        sound.soundHit();
                    }
                    bullets.remove(bullet);
                }
            }
        }
    }

    private void checkPlayer(Etank tank) {
        if (tank != null) {
            Area area = new Area(player.getShape());
            area.intersect(tank.getShape());
            if (!area.isEmpty()) {
                double tankHp = tank.getHP();
                if (!tank.updateHP(player.getHP())) {
                    tankss.remove(tank);
                    sound.soundDestroy();
                    double x = tank.getX() + Etank.etanksize / 2;
                    double y = tank.getY() + Etank.etanksize / 2;

                }
                if (!player.updateHP(tankHp)) {
                    player.setAlive(false);
                    sound.soundDestroy();
                    double x = player.getX() + Player.PLAYER_SIZE / 2;
                    double y = player.getY() + Player.PLAYER_SIZE / 2;

                }

            }
        }

    }
//    private void checkPlayer1(BossTank tank) {
//        if (tank != null) {
//            Area area = new Area(player.getShape());
//            area.intersect(tank.getShape());
//            if(tank.getX()>=width)
//            {
//                JOptionPane.showMessageDialog(this,"game over");
//            }
//
//            if (!area.isEmpty()) {
//                double tankHp = tank.getHP();
//                if (!tank.updateHP(player.getHP())) {
//                    btank.remove(tank);
//                    sound.soundDestroy();
//                    double x = tank.getX() + BossTank.etanksize / 2;
//                    double y = tank.getY() + BossTank.etanksize / 2;
//
//                }
//
//                if (!player.updateHP(tankHp)) {
//                    player.setAlive(false);
//                    sound.soundDestroy();
//                    double x = player.getX() + Player.PLAYER_SIZE / 2;
//                    double y = player.getY() + Player.PLAYER_SIZE / 2;
//
//                }
//
//            }
//        }
//
//    }


Image imagse;
    private void drawBackground() {
       g2.setColor(new Color(30, 30, 30));
       g2.fillRect(0, 0, width, height);
        // imagse = new ImageIcon("/game/image/background.jpeg").getImage();
     //   g2.drawImage(imagse,0,0,null);
        imagse = new ImageIcon(getClass().getResource("/game/image/background.jpeg")).getImage();
        g2.drawImage(imagse,0,0,null);

    }

    private void drawGame() throws IOException {
        if (player.isAlive()) {
            player.draw(g2);
        }
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            if (bullet != null) {
                bullet.draw(g2);
            }
        }
        for (int i = 0; i < tankss.size(); i++) {
            Etank tank = tankss.get(i);
            if (tank != null) {
                tank.draw(g2);
            }
        }

        g2.setColor(Color.WHITE);
        g2.setFont(getFont().deriveFont(Font.BOLD, 25f));
        g2.drawString("Score : " + score, width-150, 30);

        g2.drawString("High Score : " + highscore, width/2, 30);

        g2.drawString("Missile: "+ rocketlauncher, 100,30);

        if (!player.isAlive()) {
            String text = "GAME OVER!!!";
            String textKey = "Press R to Play Again ...";
            g2.setFont(getFont().deriveFont(Font.BOLD, 50f));
            FontMetrics fm = g2.getFontMetrics();
            Rectangle2D r2 = fm.getStringBounds(text, g2);
            double textWidth = r2.getWidth();
            double textHeight = r2.getHeight();
            double x = (width - textWidth) / 2;
            double y = (height - textHeight) / 2;
            g2.drawString(text, (int) x, (int) y + fm.getAscent());
            g2.setFont(getFont().deriveFont(Font.BOLD, 15f));
            fm = g2.getFontMetrics();
            r2 = fm.getStringBounds(textKey, g2);
            textWidth = r2.getWidth();
            textHeight = r2.getHeight();
            x = (width - textWidth) / 2;
            y = (height - textHeight) / 2;
            g2.drawString(textKey, (int) x, (int) y + fm.getAscent() + 50);
setHighscore();

        }
    }

    //get the high score
    public int getHighScore() throws IOException {
        scoreFile = new File("highscore.txt");
        BufferedReader reader =new BufferedReader(new FileReader(scoreFile));
        String Int_line;
        Int_line = reader.readLine();
        int value = Integer.parseInt(Int_line);
        highscore = value;
        System.out.println(highscore);
        return highscore;
    }
//set the high score
    public  void setHighscore() throws IOException {
int highscores=getHighScore();
        if(score > highscores)
        {
            try {
//                scoreFile.delete();
                //scoreFile.createNewFile();
                System.out.println("hgih scroe"+ highscores);
                System.out.println(score);
                fileWriter = new FileWriter(scoreFile);
                fileWriter.write(score + "");
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }



    private void render() {
        Graphics g = getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
    }

    private void sleep(long speed) {
        try {
            Thread.sleep(speed);
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
    }
}
