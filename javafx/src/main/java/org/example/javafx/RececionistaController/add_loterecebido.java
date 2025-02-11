package org.example.javafx.RececionistaController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import projeto2java.basedados.bll.Funcionariobll;
import projeto2java.basedados.bll.encomendabll;
import projeto2java.basedados.bll.loterecebidobll;
import projeto2java.basedados.entity.EncomendaEntity;
import projeto2java.basedados.entity.FuncionarioEntity;
import projeto2java.basedados.entity.LoterecebidoEntity;

import java.util.List;
import java.util.Optional;

public class add_loterecebido {

    public ComboBox<String> combobox_fun;
    public ComboBox<String> combobox_enc;
    public TextField quantidade;

    public Label info;


    LoterecebidoEntity lote_e = new LoterecebidoEntity();
    loterecebidobll lote_b = new loterecebidobll();

    @FXML
    protected void initialize(){
        inicializarcomboboxfuncionario();
        inicializarcomboboxencomenda();
    }

    private void inicializarcomboboxfuncionario(){

        List<FuncionarioEntity> funcionarios = Funcionariobll.listarfun();

        for(FuncionarioEntity funcionario : funcionarios){
            if(funcionario.getIdTipofuncionario() == 1){
                combobox_fun.getItems().add(String.valueOf(funcionario.getIdFuncionario()));
            }
        }
    }

    private void inicializarcomboboxencomenda(){

        List<EncomendaEntity> encomendas = encomendabll.listarencomenda();

        for(EncomendaEntity encomenda : encomendas){
            if(encomenda.getIdEstadoencomenda() == 4){
                combobox_enc.getItems().add(String.valueOf(encomenda.getIdEncomenda()));
            }
        }



    }



    public void regist_lote(ActionEvent event){

        if(combobox_fun.getItems().isEmpty() || combobox_enc.getItems().isEmpty() ){

            info.setText("Preencher os campos");
        }else{

            // Criação do Alert de confirmação
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Confirmar Adição");
            confirmationAlert.setHeaderText(null);
            confirmationAlert.setContentText("Tem certeza que deseja registar lote encomenda?");


            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {

                lote_e.setIdFuncionario(Integer.parseInt(combobox_fun.getValue()));
                lote_e.setIdEncomenda(Integer.parseInt(combobox_enc.getValue()));
                lote_e.setQtdrecebida(Integer.parseInt(quantidade.getText()));


                lote_b.criarloterecebi(lote_e);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();


            }else {


            }




        }
    }






    public void voltar(ActionEvent event){

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}
