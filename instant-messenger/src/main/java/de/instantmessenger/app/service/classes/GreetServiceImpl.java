package de.instantmessenger.app.service.classes;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class GreetServiceImpl implements Serializable {

    public String greet(String name) {
        if (name == null || name.isEmpty()) {
            return "Hallo anonymous user";
        } else {
            return "Guten Tag ! " + name;
        }
    }

}
