package src.gui.domain;

import java.awt.Rectangle;
import java.util.Observable;

public class PanelObservavble extends Observable {




    public void setValue(int i){
		setChanged();
		notifyObservers(i);
		clearChanged();
	}

}

