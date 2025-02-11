package org.example.javafx;

import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.javafx.ProducaoController.producao_dashboard;
import org.example.javafx.RececionistaController.rececionista_dashboard;
import org.example.javafx.EncomendasController.encomendas_dashboard;
import projeto2java.basedados.bll.Funcionariobll;
import projeto2java.basedados.entity.FuncionarioEntity;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    @FXML

    private Label usernameErro;

    @FXML
    private Label passwordErro;



    @FXML
    protected void login (ActionEvent event) throws IOException{
        Funcionariobll fun = new Funcionariobll();

        if(username.getText().isEmpty() || password.getText().isEmpty()){
            passwordErro.setText("Campos Vazios!");
            return;
        }

        FuncionarioEntity f = fun.getbyusername(username.getText());

        if(f != null && !(password.getText().equals(f.getPassword())) ){
            passwordErro.setText("Password Errada!");
        }else{

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso no Login");
            alert.setHeaderText(null);
            alert.setContentText("Login efetuado com sucesso!");
            alert.showAndWait();


            FXMLLoader rececionistaLoader = new FXMLLoader(getClass().getResource("/org/example/javafx/Rececionista/rececionista_dashboard.fxml"));
            Parent rececionistaRoot = rececionistaLoader.load();
            rececionista_dashboard rec_dash = rececionistaLoader.getController();



            FXMLLoader encomendasLoader = new FXMLLoader(getClass().getResource("/org/example/javafx/Encomendas/encomendas_dashboard.fxml"));
            Parent encomendasRoot = encomendasLoader.load();
            encomendas_dashboard enc_dash = encomendasLoader.getController();

            FXMLLoader producaoLoader = new FXMLLoader(getClass().getResource("/org/example/javafx/Producao/producao_dashboard.fxml"));
            Parent producaoRoot = producaoLoader.load();
            producao_dashboard prod_dash = producaoLoader.getController();


            Stage stage = new Stage();
            String titulo;


            switch(f.getIdTipofuncionario()){

                case 1:
                    titulo = "Rececionista -> DashBoard";
                    Scene rececionistaScene = new Scene (rececionistaRoot);
                    stage.setScene(rececionistaScene);
                    break;

                case 2:
                    titulo = "GestorEncomendas -> DashBoard";
                    Scene encomendasScene = new Scene (encomendasRoot);
                    stage.setScene(encomendasScene);
                    break;

                case 3:
                    titulo = "Produção -> Dashboard";
                    Scene producaoScene = new Scene(producaoRoot);
                    stage.setScene(producaoScene);
                    break;


                default:
                    passwordErro.setText("ERRO no login");
                    return;

            }
            stage.setTitle(titulo);
            stage.show();
            Node source = (Node) event.getSource();
            Stage stageAtual  = (Stage) source.getScene().getWindow();
            stageAtual.close();

        }
    }

}