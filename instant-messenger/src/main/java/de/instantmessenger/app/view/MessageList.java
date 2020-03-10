package de.instantmessenger.app.view;

import java.awt.Component;

import com.vaadin.flow.component.html.Div;

public class MessageList extends Div{
	
	public MessageList() {
		addClassName("message-list");
	}
	
	
	
	@Override
	public void add(com.vaadin.flow.component.Component... components) {
		super.add(components);
		
		components[components.length-1]
				.getElement()
				.callJsFunction("scrollIntoView");
	}

	
	

}
