package org.sid.demospringjavafx;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringJavafxApplication {

    public static void main(String[] args) {
        //SpringApplication.run(DemoSpringJavafxApplication.class, args);
        Application.launch(JavaFXApp.class,args);
    }

}
