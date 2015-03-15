package src.gui.domain;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.Controller;

import java.util.Hashtable;
import java.util.Observer;

public class ZoomController extends JFrame implements ChangeListener{

    public static final int BREDDE =700;
    public static final int HOYDE = 140;
    public static final int INGENSKALERING = 0;
    public static final int MINIMUMSKALERING = -99;
    public static final int MAXIMUMSKALERING = 100;
    public static final int MELLOMROM = 10;

    private PanelObservavble panelObservavble = new PanelObservavble();
    private JSlider js = new JSlider(JSlider.HORIZONTAL,MINIMUMSKALERING, MAXIMUMSKALERING,INGENSKALERING);


    public ZoomController() {
		
		zoomingslider();
		
		setTitle(" ZoomController 1.0");
		setLocation(400,4);
		setSize(BREDDE,HOYDE);
		setVisible(true);
	}


	private void zoomingslider() {

        //Create the label table
        Hashtable labelTable = new Hashtable();
        labelTable.put( new Integer( INGENSKALERING ), new JLabel("Ingen zoom") );
        labelTable.put( new Integer( MINIMUMSKALERING ), new JLabel("Zoom inn") );
        labelTable.put( new Integer( MAXIMUMSKALERING ), new JLabel("Zoom ut") );
        js.setLabelTable( labelTable );

        js.setPaintLabels(true);


        js.getLabelTable();
        js.setMajorTickSpacing(MELLOMROM);
		js.setPaintLabels(true);
		js.setMinimum(MINIMUMSKALERING);
		js.setValue(INGENSKALERING);
        js.setPaintTicks(false);
        js.setPaintLabels(true);
        js.setMaximum(MAXIMUMSKALERING);
		js.addChangeListener(this);
        add(js);

    }

	@Override
	public void stateChanged(ChangeEvent e) {
        panelObservavble.setValue(js.getValue());
	}

    public void addObserver(Observer o){
        panelObservavble.addObserver(o);
    }

}
