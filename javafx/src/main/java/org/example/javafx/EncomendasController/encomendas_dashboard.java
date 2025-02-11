package org.example.javafx.EncomendasController;

import jakarta.persistence.Id;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import projeto2java.basedados.bll.encomendabll;
import projeto2java.basedados.bll.estadoencomendabll;
import projeto2java.basedados.bll.fornecedorbll;
import projeto2java.basedados.entity.EncomendaEntity;
import projeto2java.basedados.entity.EstadoencomendaEntity;
import projeto2java.basedados.entity.FornecedorEntity;

import java.io.IOException;
import java.io.Serial;
import java.time.LocalDate;
import java.util.List;

import static projeto2java.basedados.bll.encomendabll.updateprodencomend;

public class encomendas_dashboard {

    //Fornecedores

    @FXML
    protected TableView <FornecedorEntity> listfornecedor;

    @FXML
    protected TableColumn <FornecedorEntity, String > idfornecedor;

    @FXML
    protected TableColumn <FornecedorEntity,String> namelocal;

    @FXML
    protected TableColumn <FornecedorEntity,Integer> ntelefone;

    @FXML
    protected TableColumn <FornecedorEntity,String> foremail;

    @FXML
    protected TextField nforndel;


    @FXML
    protected void initialize(){
        loadfornecedores();
        loadencomendas();
        loadestadoenc();
    }


    //Encomendas

    @FXML
    protected TableView<EncomendaEntity> list_encomendas;

    @FXML
    protected TableColumn<EncomendaEntity,String> id_encomenda;
    @FXML
    protected TableColumn<EncomendaEntity,String> id_fornecedor;
    @FXML
    protected TableColumn<EncomendaEntity,String > id_estado;
    @FXML
    protected TableColumn<EncomendaEntity,String> id_funcionario;
    @FXML
    protected TableColumn<EncomendaEntity,String>encenvio;
    @FXML
    protected TableColumn<EncomendaEntity, LocalDate> dta_emissao;
    @FXML
    protected TableColumn<EncomendaEntity,LocalDate> dta_chegada;
    @FXML
    public TextField n_enc;
    @FXML
    public TextField n_estado;

    //Tabela estados encomenda

    @FXML
    protected TableView<EstadoencomendaEntity> list_estados;
    @FXML
    protected TableColumn<EstadoencomendaEntity,String> id_estadoenc;
    @FXML
    protected TableColumn<EstadoencomendaEntity,String> descricaoenc;


    public Label erroupdate;


    protected void loadestadoenc(){
        List<EstadoencomendaEntity> estados = estadoencomendabll.listarestados();

        id_estadoenc.setCellValueFactory(cellData -> {
            String idAsString = String.valueOf(cellData.getValue().getIdEstadoencomenda());
            return new SimpleStringProperty(idAsString);
        });

        descricaoenc.setCellValueFactory(new PropertyValueFactory<>("tipoestado"));

        list_estados.getItems().clear();
        list_estados.getItems().addAll(estados);
    }

    protected void loadencomendas(){

        List<EncomendaEntity> encomendas = encomendabll.listarencomenda();

        list_encomendas.getItems().clear();

        id_encomenda.setCellValueFactory(cellData -> {
            String idAsString = String.valueOf(cellData.getValue().getIdEncomenda());
            return new SimpleStringProperty(idAsString);
        });
        id_fornecedor.setCellValueFactory(cellData -> {
            String idAsString = String.valueOf(cellData.getValue().getIdFornecedor());
            return new SimpleStringProperty(idAsString);
        });
        id_estado.setCellValueFactory(cellData -> {
            String idAsString = String.valueOf(cellData.getValue().getIdEstadoencomenda());
            return new SimpleStringProperty(idAsString);
        });
        id_funcionario.setCellValueFactory(cellData -> {
            String idAsString = String.valueOf(cellData.getValue().getIdFuncionario());
            return new SimpleStringProperty(idAsString);
        });
        encenvio.setCellValueFactory(cellData -> {
            String idAsString = String.valueOf(cellData.getValue().getnEnvio());
            return new SimpleStringProperty(idAsString);
        });


        dta_emissao.setCellValueFactory(new PropertyValueFactory<>("dataemissao"));
        dta_chegada.setCellValueFactory(new PropertyValueFactory<>("datachegada"));

        list_encomendas.getItems().clear();
        list_encomendas.getItems().addAll(encomendas);
    }




    protected void loadfornecedores(){

        List<FornecedorEntity> fornecedores = fornecedorbll.listarforn();


        idfornecedor.setCellValueFactory(cellData -> {
            String idAsString = String.valueOf(cellData.getValue().getIdFornecedor());
            return new SimpleStringProperty(idAsString);
        });
        namelocal.setCellValueFactory(new PropertyValueFactory<>("Localidade"));
        ntelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
        foremail.setCellValueFactory(new PropertyValueFactory<>("Email"));


        listfornecedor.getItems().clear();

        listfornecedor.getItems().addAll(fornecedores);

    }

    @FXML
    protected void add_forn() throws IOException{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/javafx/Encomendas/add_fornecedor.fxml"));
        Parent root =fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void atualizarfornecedor(){
        loadfornecedores();

    }
    public void atualizarencomenda(){
        loadencomendas();
    }



    //ENCOMENDAS//

    @FXML
    protected void add_encomenda() throws IOException{

        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/org/example/javafx/Encomendas/realizar_encomenda.fxml"));
        Parent root = Loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    //Atualizar Estado Encmenda///




    @FXML
    protected void editarestado(){

        String orderId = n_enc.getText().trim();
        String newStatusId = n_estado.getText().trim();

        if (orderId.isEmpty() || newStatusId.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Dados vazios!!");
            return;
        }


        EncomendaEntity enc = encomendabll.getById(Integer.parseInt(orderId));

        if(enc == null){
            erroupdate.setText("");
            return;
        }

        if(newStatusId != null){
            enc.setIdEstadoencomenda(Integer.parseInt(newStatusId));
        }

        encomendabll.updateprodencomend(enc);
        loadencomendas();
        erroupdate.setText("");

        switch (newStatusId) {
            case "2":
                showAlert(Alert.AlertType.INFORMATION, "Status Update", "Encomenda foi paga.");
                break;
            case "3":
                showAlert(Alert.AlertType.INFORMATION, "Status Update", "Encomenda em processamento.");
                break;
            case "4":
                showAlert(Alert.AlertType.INFORMATION, "Status Update", "Encomenda será entregue em breve.");
                break;

        }



    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null); // No header
        alert.setContentText(message);
        alert.showAndWait();
    }

    //Logout//

    @FXML
    protected void onActionExit(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/javafx/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

        Node source = (Node) event.getSource();
        Stage stageAtual = (Stage) source.getScene().getWindow();
        stageAtual.close();
    }
}
