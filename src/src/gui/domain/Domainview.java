package src.gui.domain;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Domainview extends JPanel {
    ZoomController zoomController =  new ZoomController();

	Background background = new Background();
	MoveableGlass glassbehind = new MoveableGlass();
	MoveableGlass glassinfront = new MoveableGlass(){
	{
		setLocation(100, 100);
		System.out.println("vindu " + Domainview.this.getWidth());
	}	
};
	OpticalZoom opticalZoom = new OpticalZoom( background);

	public Domainview() {
		setLayout(null);
        add(opticalZoom);
        add(glassinfront);
		add(background);
        add(glassbehind);
        zoomController.addObserver(opticalZoom);


    }

	public void selectGlassColor() {
		glassinfront.selectGlassColor();
	}

	public void selectShape() {
		glassinfront.selectShape();
	}

	public Dimension getTheSize() {
		return background.getSize();
	}
	

}
