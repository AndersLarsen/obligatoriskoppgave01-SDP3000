package src.gui.domain;


import java.awt.*;

import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;


public class OpticalZoom extends MoveableComponent implements Observer {


    private	Image imageFromBackground;
    private static final int WIDTH = 200;
    private static final int HEIGHT = 200;
    private int backgroundImgStartX, backgroundImgStartY, backgroundImgEndX, backgroundImgEndY,value;
    private double halfWidth,halfHeight,centerX,centerY,zoom = 0;

    public OpticalZoom(Background background)
    {
        setSize(WIDTH, HEIGHT);
        imageFromBackground = background.getImage();
        setVisible(true);
    }

    private void zoomCalculator() {

        backgroundImgStartX = (int)Math.round(centerX-halfWidth);
        backgroundImgStartY = (int)Math.round(centerY-halfHeight);
        backgroundImgEndX = (int)Math.round(centerX+halfWidth);
        backgroundImgEndY = (int)Math.round(centerY+halfHeight);

    }

    public void paint(Graphics g){

        zoomCalculator();
        g.drawImage(imageFromBackground,
                0,
                0,
                WIDTH,
                HEIGHT,
                backgroundImgStartX,
                backgroundImgStartY,
                backgroundImgEndX,
                backgroundImgEndY,
                null);
    }

       public void mouseDragged(MouseEvent source) {
        super.mouseDragged(source);
        centerX = getX()+ WIDTH /2;
        centerY = getY()+ HEIGHT /2;
    }

    @Override
    public void update(Observable o, Object v) {

        value = (Integer)v;
        centerX = getX()+ WIDTH /2;
        centerY = getY()+ HEIGHT /2;
        zoom = 1+((double)value/100);
        halfWidth = (WIDTH *zoom/2);
        halfHeight = (HEIGHT *zoom/2);
        repaint();

    }


}
