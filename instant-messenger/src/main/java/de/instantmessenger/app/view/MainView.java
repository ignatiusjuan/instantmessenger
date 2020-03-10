package de.instantmessenger.app.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import ch.qos.logback.core.Layout;
import de.instantmessenger.app.ChatMessage;
import de.instantmessenger.app.service.classes.GreetServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.UnicastProcessor;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Main-view class.
 * 
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 * 
 * 
 * 
 * @author engin
 * 
 */
@Route
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = true)
@StyleSheet("frontend://sytles//styles.css")

@Push //<---- using WebSockets
//@CssImport("./styles/shared-styles.css")
//@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {


	private String username;
	private final UnicastProcessor<ChatMessage> publisher;
	private final Flux<ChatMessage> messages;
	
	
    public MainView(UnicastProcessor<ChatMessage> publisher, Flux<ChatMessage> messages) {
    	this.messages = messages;
    	this.publisher = publisher;
    	addClassName("main-view");
    	setSizeFull();
    	setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    	
    	H1 header = new H1("Instant-Messanger");
    	header.getElement().getThemeList().add("dark");
    	
    	
    	add(header);
    	
    	askUsername();
    }

    
    	private void askUsername() {
    		HorizontalLayout layout = new HorizontalLayout();
    		TextField usernameField = new TextField();
    		Button startButton = new Button("Start Chatting");
    		
    		layout.add(usernameField, startButton);
    		
    		startButton.addClickListener(click -> {
    			username = usernameField.getValue();
    			remove(layout);
    			showChat();
    		});
    		
    		add(layout);
    	}
    	
    
    	
    	private void showChat() {
    		
    		setDefaultHorizontalComponentAlignment(Alignment.BASELINE);
    		MessageList messageList = new MessageList();
    		
    		add(messageList, createInputLayout());
    		expand(messageList);
    		
    		messages.subscribe(message -> {
    			getUI().ifPresent(ui -> 
    				ui.access(() -> 
    				messageList.add(
        					new Paragraph(message.getFrom()+ ": " +
        					message.getMessage()))
    				));
    			});
    			
    	}
    	
    	
    	private Component createInputLayout() {
    		HorizontalLayout layout = new HorizontalLayout();
    		layout.setWidth("100%");
    		TextField messageField = new TextField();    		
    		Button sendButton = new Button("Send");
    		sendButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    		
    		
    		layout.add(messageField, sendButton);
    		layout.expand(messageField);
    		
    		sendButton.addClickListener(click -> {
    			publisher.onNext(new ChatMessage(username, messageField.getValue()));
    			messageField.clear();
    			messageField.focus();
    		});
    		messageField.focus();
    		return layout;
    	}
    
    	
 }


