package org.example.javafx.ProducaoController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import projeto2java.basedados.bll.Funcionariobll;
import projeto2java.basedados.bll.faseproducaobll;
import projeto2java.basedados.bll.producaobll;
import projeto2java.basedados.entity.FaseproducaoEntity;
import projeto2java.basedados.entity.FuncionarioEntity;
import projeto2java.basedados.entity.ProducaoEntity;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class iniciar_producao {

    public ComboBox<String> comboboxfunc;
    public ComboBox<String> comboboxfase;

    public DatePicker dtini;
    public DatePicker dtfim;
    public TextField qtdprima;
    public TextField qtdproducao;

    public Label errogeral;
    public Label errodata;

    ProducaoEntity prod_e = new ProducaoEntity();
    producaobll prod_b = new producaobll();


    @FXML
    protected void initialize() {
        inicializarcomboboxfunc();
        inicializarcomboboxfase();

    }

    private void inicializarcomboboxfunc(){

        List<FuncionarioEntity> funcionarios = Funcionariobll.listarfun();

        for(FuncionarioEntity funcionario : funcionarios){
            if(funcionario.getIdTipofuncionario() == 3){
                comboboxfunc.getItems().add(String.valueOf(funcionario.getIdFuncionario()));
            }
        }
    }

    private void inicializarcomboboxfase(){

        List<FaseproducaoEntity> fases = faseproducaobll.listarfase();

        for(FaseproducaoEntity fase : fases){
            if(fase.getIdFase() == 1){
                comboboxfase.getItems().add(String.valueOf(fase.getIdFase()));
            }
        }
    }


    public void iniciar_prod (ActionEvent event){

        if(comboboxfunc.getItems().isEmpty() || comboboxfase.getItems().isEmpty() ||
                 dtini.getValue() == null || dtfim.getValue() == null || qtdprima.getText().isEmpty() || qtdproducao.getText().isEmpty() ){

            errogeral.setText("Preencher os campos");
        }else{
            if (comboboxfunc.getItems().isEmpty() || comboboxfase.getItems().isEmpty() ||
                     dtini.getValue() == null || dtfim.getValue() == null || dtini.getValue().isAfter(dtfim.getValue()) || qtdprima.getText().isEmpty() || qtdproducao.getText().isEmpty()) {
                errodata.setText("A data de início deve ser anterior à data de chegada.");
            } else {

                // Criação do Alert de confirmação
                Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
                confirmationAlert.setTitle("Confirmar Adição");
                confirmationAlert.setHeaderText(null);
                confirmationAlert.setContentText("Tem certeza que deseja iniciar Produção?");


                Optional<ButtonType> result = confirmationAlert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {

                    prod_e.setIdFuncionario(Integer.parseInt(comboboxfunc.getValue()));
                    prod_e.setIdFase(Integer.parseInt(comboboxfase.getValue()));
                    prod_e.setDatainicio(Date.valueOf(dtini.getValue()));
                    prod_e.setDatafim(Date.valueOf(dtfim.getValue()));
                    prod_e.setQtdmateriaprima(Integer.parseInt(qtdprima.getText()));
                    prod_e.setQtdproducao(Integer.parseInt(qtdproducao.getText()));

                    prod_b.criarproducao(prod_e);

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.close();

                }else {

                }

            }
        }
    }


    public void back(ActionEvent event){

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }



}
