package com.upv.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;



/**
 * Hello world!
 *
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage = FXMLLoader.load(getClass().getResource("/V_LogIn.fxml"));
        stage.setTitle("Sistema de Recursos Academicos");
        stage.show();
    }

    public static void main( String[] args )
    {
        launch(args);
    }
}
