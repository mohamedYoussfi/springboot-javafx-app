package org.sid.demospringjavafx;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.sid.demospringjavafx.entities.Product;
import org.sid.demospringjavafx.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StageInitializer implements ApplicationListener<JavaFXApp.StageReadyEvent> {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void onApplicationEvent(JavaFXApp.StageReadyEvent event) {
        productRepository.save(new Product(null,"Computer",6500));
        productRepository.save(new Product(null,"Printer",6500));
        productRepository.save(new Product(null,"Smart Phone",1200));
        Stage stage=event.getStage();
        stage.setTitle("Application FX Spring Boot");
        BorderPane borderPane=new BorderPane();
        Scene scene=new Scene(borderPane);
        ObservableList<String> model = FXCollections.observableArrayList();
        ListView<String> listView=new ListView<>(model);
        Button button=new Button("Show Products");
        borderPane.setCenter(listView);
        HBox hBox=new HBox();
        hBox.getChildren().addAll(button);
        borderPane.setTop(hBox);
        stage.setScene(scene);
        stage.show();
        button.setOnAction((evt)->{
            List<Product> products=productRepository.findAll();
            products.forEach(p->{
                model.add(p.getName());
            });
        });
    }
}
