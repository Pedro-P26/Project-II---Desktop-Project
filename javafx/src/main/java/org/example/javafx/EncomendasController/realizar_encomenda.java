package org.example.javafx.EncomendasController;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import projeto2java.basedados.bll.Funcionariobll;
import projeto2java.basedados.bll.encomendabll;
import projeto2java.basedados.bll.estadoencomendabll;
import projeto2java.basedados.bll.fornecedorbll;
import projeto2java.basedados.entity.EncomendaEntity;
import projeto2java.basedados.entity.EstadoencomendaEntity;
import projeto2java.basedados.entity.FornecedorEntity;
import projeto2java.basedados.entity.FuncionarioEntity;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class realizar_encomenda {

    public ComboBox<String> combobox_forn;
    public ComboBox<String> combobox_estad;
    public ComboBox<String> combobox_fun;
    public TextField n_enc;

    public DatePicker data_ini;
    public DatePicker data_chega;
    public Label dados;
    public Label dataerro;



   EncomendaEntity enc_e = new EncomendaEntity();
    encomendabll enc_b = new encomendabll();


    @FXML
    protected void initialize() {
        inicializarComboBoxFornecedores();
        inicializarcomboboxestados();
        inicializarcomboboxfuncionario();
    }

    private void inicializarComboBoxFornecedores() {
        List<FornecedorEntity> fornecedores = fornecedorbll.listarforn();

        for (FornecedorEntity fornecedor : fornecedores) {
            combobox_forn.getItems().add(String.valueOf(fornecedor.getIdFornecedor()));
        }

    }

    private void inicializarcomboboxestados(){

        List<EstadoencomendaEntity> estados = estadoencomendabll.listarestados();

        for (EstadoencomendaEntity estado : estados){
            if(estado.getIdEstadoencomenda() == 1){
                combobox_estad.getItems().add(String.valueOf(estado.getIdEstadoencomenda()));
            }
        }

    }

    private void inicializarcomboboxfuncionario(){

        List<FuncionarioEntity> funcionarios = Funcionariobll.listarfun();

        for(FuncionarioEntity funcionario : funcionarios){
            if(funcionario.getIdTipofuncionario() == 2){
                combobox_fun.getItems().add(String.valueOf(funcionario.getIdFuncionario()));
            }
        }
    }



    public void realizar_enc (ActionEvent event){

        if(combobox_forn.getItems().isEmpty() || combobox_estad.getItems().isEmpty() ||
                combobox_fun.getItems().isEmpty() || n_enc.getText().isEmpty() || data_ini.getValue() == null || data_chega.getValue() == null ){

            dados.setText("Preencher os campos");
        }else{
            if (combobox_forn.getItems().isEmpty() || combobox_estad.getItems().isEmpty() ||
                    combobox_fun.getItems().isEmpty() || n_enc.getText().isEmpty() || data_ini.getValue() == null || data_chega.getValue() == null || data_ini.getValue().isAfter(data_chega.getValue())) {
                dataerro.setText("A data de início deve ser anterior à data de chegada.");
            } else {

                // Criação do Alert de confirmação
                Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
                confirmationAlert.setTitle("Confirmar Adição");
                confirmationAlert.setHeaderText(null);
                confirmationAlert.setContentText("Tem certeza que deseja adicionar este fornecedor?");


                Optional<ButtonType> result = confirmationAlert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {

                    enc_e.setIdFornecedor(Integer.parseInt(combobox_forn.getValue()));
                    enc_e.setIdEstadoencomenda(Integer.parseInt(combobox_estad.getValue()));
                    enc_e.setIdFuncionario(Integer.parseInt(combobox_fun.getValue()));
                    enc_e.setnEnvio(Integer.parseInt(n_enc.getText()));
                    enc_e.setDataemissao(Date.valueOf(data_ini.getValue()));
                    enc_e.setDatachegada(Date.valueOf(data_chega.getValue()));

                    enc_b.criarencomenda(enc_e);

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.close();

                }else {

                }

            }
        }
    }















    public void voltar_dash(ActionEvent event){

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}
