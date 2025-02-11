package org.example.javafx.EncomendasController;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projeto2java.basedados.bll.fornecedorbll;
import projeto2java.basedados.entity.FornecedorEntity;

import java.io.IOException;
import java.util.Optional;

public class add_fornecedor {

    public TextField text_telefone;
    public TextField text_email;
    public TextField text_local;

    public Label info;

    FornecedorEntity for_e = new FornecedorEntity();
    fornecedorbll for_b = new fornecedorbll();

    public void adicionarfornecedor(ActionEvent event) {
        if (text_telefone.getText().isEmpty() || text_email.getText().isEmpty() || text_local.getText().isEmpty()) {
            info.setText("Existe campos vazios!");
        } else {
            // Criação do Alert de confirmação
            Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Confirmar Adição");
            confirmationAlert.setHeaderText(null);
            confirmationAlert.setContentText("Tem certeza que deseja adicionar este fornecedor?");

            // Mostrar o Alert e esperar pela resposta do usuário
            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Se o usuário confirmar, execute a adição do fornecedor
                for_e.setTelefone(Integer.parseInt(text_telefone.getText()));
                for_e.setEmail(text_email.getText());
                for_e.setLocalidade(text_local.getText());

                for_b.criarfornecedor(for_e);

                // Fechar a janela atual
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();
            } else {
                // Se o usuário não confirmar, apenas retorna sem fazer nada
                return;
            }
        }
    }



    public void voltar(ActionEvent event){

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }



}
