package com.portalj.ctrl;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Label;

public class IndexCtrl extends BaseCtrl{
	
	private Label juegoSaludo;
	
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		
		
		juegoSaludo.setValue("Hola desde indexCtrl");
	}
	
	private void onClickbtnsaludo (Event evt) {
		
		
	   juegoSaludo.setValue("Hiciste click en boton");
	   juegoSaludo.setStyle("color: blue");

	}
	
	

}
