package game.obj;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Bullet {

    private double x;
    private double y;
    private Shape shape;
    private final Color color = new Color(255, 0, 0);
    private final float angle;
    private double size;
    private float speed = 0.8f;
    Image image;
public int id;
    public Bullet(double x, double y, float angle, double size, float speed,int id) {
        x += Player.PLAYER_SIZE / 2 - (size / 2);
        y += Player.PLAYER_SIZE / 2 - (size / 2);
        this.id=id;
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.size = size;
        this.speed = speed;
        int[] xPoints = {10, 20, 30, 25, 15};
        int[] yPoints = {20, 10, 20, 30, 30};
        int nPoints = 5;
        if(id==1) {
            shape = new Ellipse2D.Double(0, 0, size, size);
        }
        else if(id==2) {
            shape = new Polygon(xPoints,yPoints,nPoints);

        }
    }

    public void update() {
        x += Math.cos(Math.toRadians(angle)) * speed;
        y += Math.sin(Math.toRadians(angle)) * speed;
    }

    public boolean check(int width, int height) {
        if (x <= -size || y < -size || x > width || y > height) {
            return false;
        } else {
            return true;
        }
    }

    public void draw(Graphics2D g2) {
        AffineTransform oldTransform = g2.getTransform();
        g2.setColor(color);
        g2.translate(x, y);
        if(id==2)
        {
            System.out.println("id =2");
        this.image = new ImageIcon(getClass().getResource("/game/image/missile.png")).getImage();
      //  g2.drawImage(image,0,0,null);
            AffineTransform transform = new AffineTransform();
            transform.rotate(Math.toRadians(angle), image.getWidth(null) / 2, image.getHeight(null) / 2);
            g2.drawImage(image, transform, null);
        }
        g2.fill(shape);

        g2.setTransform(oldTransform);
    }

    public Shape getShape() {
        return new Area(new Ellipse2D.Double(x, y, size, size));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSize() {
        return size;
    }

    public double getCenterX() {
        return x + size / 2;
    }

    public double getCenterY() {
        return y + size / 2;
    }

}
