package org.example.javafx.ProducaoController;

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
import projeto2java.basedados.bll.faseproducaobll;
import projeto2java.basedados.bll.producaobll;
import projeto2java.basedados.entity.FaseproducaoEntity;
import projeto2java.basedados.entity.ProducaoEntity;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class producao_dashboard {

    //ProduçãoGeral

    @FXML
    protected TableView<ProducaoEntity> list_prod;
    @FXML
    protected TableColumn<ProducaoEntity,String> idprod;
    @FXML
    protected TableColumn<ProducaoEntity,String> idfun;
    @FXML
    protected TableColumn<ProducaoEntity,String> idfase;
    @FXML
    protected TableColumn<ProducaoEntity, LocalDate> dtaini;
    @FXML
    protected TableColumn<ProducaoEntity,LocalDate> dtafim;
    @FXML
    protected TableColumn<ProducaoEntity,Integer> qtdmateria;
    @FXML
    protected TableColumn<ProducaoEntity,Integer> qtdprod;

    //ProduçãoEngarrafamento

    @FXML
    protected TableView<ProducaoEntity> list_engarrafado;
    @FXML
    protected TableColumn<ProducaoEntity,String> nprod;
    @FXML
    protected TableColumn<ProducaoEntity,String > nfun;
    @FXML
    protected TableColumn<ProducaoEntity,String> nfas;
    @FXML
    protected TableColumn<ProducaoEntity, LocalDate> inicial;
    @FXML
    protected TableColumn<ProducaoEntity,LocalDate> fim;
    @FXML
    protected TableColumn<ProducaoEntity,Integer> qdmat;
    @FXML
    protected TableColumn<ProducaoEntity,Integer> qtprod;









    //Fases Produção


    @FXML
    protected TableView<FaseproducaoEntity> list_fases;
    @FXML
    protected TableColumn<FaseproducaoEntity,String> nfase;
    @FXML
    protected TableColumn<FaseproducaoEntity,String> descricao;


    @FXML
    protected void initialize(){
        loadfasespord();
        loadproducao();
        loadengarrafado();

    }

    protected void loadproducao(){

        List<ProducaoEntity> producao = producaobll.listarproducao();

        idprod.setCellValueFactory(cellData -> {
            String idAsString = String.valueOf(cellData.getValue().getIdProducao());
            return new SimpleStringProperty(idAsString);
        });

        idfun.setCellValueFactory(cellData -> {
            String idAsString = String.valueOf(cellData.getValue().getIdFuncionario());
            return new SimpleStringProperty(idAsString);
        });

        idfase.setCellValueFactory(cellData -> {
            String idAsString = String.valueOf(cellData.getValue().getIdFase());
            return new SimpleStringProperty(idAsString);
        });

        dtaini.setCellValueFactory(new PropertyValueFactory<>("datainicio"));
        dtafim.setCellValueFactory(new PropertyValueFactory<>("datafim"));

        qtdmateria.setCellValueFactory(new PropertyValueFactory<>("qtdproducao"));
        qtdprod.setCellValueFactory(new PropertyValueFactory<>("qtdmateriaprima"));

        list_prod.getItems().clear();
        list_prod.getItems().addAll(producao);

    }

    protected void loadengarrafado(){

        List<ProducaoEntity> prod_fim = producaobll.listarproducao();

        nprod.setCellValueFactory(cellData -> {
            String idAsString = String.valueOf(cellData.getValue().getIdProducao());
            return new SimpleStringProperty(idAsString);
        });

        nfun.setCellValueFactory(cellData -> {
            String idAsString = String.valueOf(cellData.getValue().getIdFuncionario());
            return new SimpleStringProperty(idAsString);
        });

        nfas.setCellValueFactory(cellData -> {
            String idAsString = String.valueOf(cellData.getValue().getIdFase());
            return new SimpleStringProperty(idAsString);
        });

        inicial.setCellValueFactory(new PropertyValueFactory<>("datainicio"));
        fim.setCellValueFactory(new PropertyValueFactory<>("datafim"));

        qdmat.setCellValueFactory(new PropertyValueFactory<>("qtdproducao"));
        qtprod.setCellValueFactory(new PropertyValueFactory<>("qtdmateriaprima"));

        list_engarrafado.getItems().clear();

        list_engarrafado.getItems().addAll(prod_fim.stream().filter(p -> p.getIdFase() == 7).collect(Collectors.toList()));

    }





    protected void loadfasespord(){

        List<FaseproducaoEntity> fases = faseproducaobll.listarfase();

        nfase.setCellValueFactory(cellData -> {
            String idAsString = String.valueOf(cellData.getValue().getIdFase());
            return new SimpleStringProperty(idAsString);
        });

        descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));

        list_fases.getItems().clear();
        list_fases.getItems().addAll(fases);


    }


    public void atualizarproducao(){
        loadproducao();
    }

    public void atualizarlotefim(){
        loadengarrafado();
    }

    @FXML
    protected void ini_producao() throws IOException{

        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/org/example/javafx/Producao/iniciar_producao.fxml"));
        Parent root = Loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }



    @FXML
    protected void exit(ActionEvent event) throws IOException {
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
