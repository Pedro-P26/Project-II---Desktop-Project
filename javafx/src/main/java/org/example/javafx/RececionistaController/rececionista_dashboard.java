package org.example.javafx.RececionistaController;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import projeto2java.basedados.bll.encomendabll;
import projeto2java.basedados.bll.fornecedorbll;
import projeto2java.basedados.bll.loterecebidobll;
import projeto2java.basedados.entity.EncomendaEntity;
import projeto2java.basedados.entity.FornecedorEntity;
import projeto2java.basedados.entity.LoterecebidoEntity;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static projeto2java.basedados.bll.fornecedorbll.*;

public class rececionista_dashboard {


    //Fornecedores

    @FXML
    protected TableView<FornecedorEntity> listfornecedor;

    @FXML
    protected TableColumn<FornecedorEntity, String > idfornecedor;

    @FXML
    protected TableColumn <FornecedorEntity,String> namelocal;

    @FXML
    protected TableColumn <FornecedorEntity,Integer> ntelefone;

    @FXML
    protected TableColumn <FornecedorEntity,String> foremail;

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
    protected TableColumn<EncomendaEntity,String>n_envio;
    @FXML
    protected TableColumn<EncomendaEntity, LocalDate> dta_emissao;
    @FXML
    protected TableColumn<EncomendaEntity,LocalDate> dta_chegada;


    //Lotes Recebidos

    @FXML
    protected TableView<LoterecebidoEntity> list_lotesrecebi;
    @FXML
    protected TableColumn<LoterecebidoEntity,String> id_lote;
    @FXML
    protected TableColumn<LoterecebidoEntity,String> id_fun;
    @FXML
    protected TableColumn<LoterecebidoEntity,String> id_enc;
    @FXML
    protected TableColumn<LoterecebidoEntity,Integer> quantidade;


    @FXML
    protected void initialize(){
        loadforn();
        load_encomendas();
        loadlotesrecebi();
    }

    protected void loadlotesrecebi(){

        List<LoterecebidoEntity> recebidos = loterecebidobll.listarloterecebido();


        id_lote.setCellValueFactory(cellData -> {
            String idAsString = String.valueOf(cellData.getValue().getIdLoterecebido());
            return new SimpleStringProperty(idAsString);
        });

        id_fun.setCellValueFactory(cellData -> {
            String idAsString = String.valueOf(cellData.getValue().getIdFuncionario());
            return new SimpleStringProperty(idAsString);
        });

        id_enc.setCellValueFactory(cellData -> {
            String idAsString = String.valueOf(cellData.getValue().getIdEncomenda());
            return new SimpleStringProperty(idAsString);
        });

        quantidade.setCellValueFactory(new PropertyValueFactory<>("qtdrecebida"));

        list_lotesrecebi.getItems().clear();
        list_lotesrecebi.getItems().addAll(recebidos);

    }

    public void atualizarloterecebi(){
        loadlotesrecebi();
    }

    protected void loadforn(){

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
    protected void addforn() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/javafx/Encomendas/add_fornecedor.fxml"));
        Parent root =fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    protected void addlote() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/javafx/Rececionista/add_loterecebido.fxml"));
        Parent root =fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void atualizarforn(){
        loadforn();
    }


    protected void load_encomendas(){

        List<EncomendaEntity> encomendas = encomendabll.listarencomenda();

        List<EncomendaEntity> encomendasFiltradas = encomendas.stream().filter(e -> e.getIdEstadoencomenda() == 4).collect(Collectors.toList());

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
        n_envio.setCellValueFactory(cellData -> {
            String idAsString = String.valueOf(cellData.getValue().getnEnvio());
            return new SimpleStringProperty(idAsString);
        });

        dta_emissao.setCellValueFactory(new PropertyValueFactory<>("dataemissao"));
        dta_chegada.setCellValueFactory(new PropertyValueFactory<>("datachegada"));

        list_encomendas.getItems().clear();
        list_encomendas.getItems().addAll(encomendasFiltradas);
    }

    public void atualizarenc(){
        load_encomendas();
    }





    //Logout//

    @FXML
    protected void logout (ActionEvent event) throws IOException {
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
