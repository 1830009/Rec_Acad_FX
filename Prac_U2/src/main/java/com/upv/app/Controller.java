package com.upv.app;

import com.mycompany.app.Configuracion;
import com.mycompany.app.LogIn;
import com.mycompany.app.SQL;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    static SQL A = new SQL();
    static Casteo Cast= new Casteo();
    static ObservableList<TAula_Equipos> Li_Aula_Equipo;
    static ObservableList<TUso_Aula_Eq> Li_UAula_Equipo;
    static List<LogIn> L_LogIn= new ArrayList<>();
    public TextField T_Usuario;
    public Button B_logIn;
    public PasswordField T_Pass;
    //AulaEquipos
    public TableView<TAula_Equipos> Tbl_Aula_Equipos = new TableView<>();
    public TableColumn<TAula_Equipos,String> C_ID_Equipo = new TableColumn<>();
    public TableColumn<TAula_Equipos,String> C_Aula_ID= new TableColumn<>();
    public TableColumn<TAula_Equipos,String> C_Cantidad= new TableColumn<>();
    public TextField T_ID_Equipo;
    public TextField T_ID_Materia;
    public TextField T_Cantidad;
    public Button B_Regresa;
    public int posicion=0,ix=0;


    @FXML public void initialize (){
            Configuracion.CargarConfiguracion();
            Li_Aula_Equipo = Cast.CastAula_Eq(A.Consultar("AULA_EQUIPOS"));
            Li_UAula_Equipo = Cast.CastUso_Aula_Eq(A.Consultar("USO_AULA_EQUIPOS"));
            final ObservableList<TAula_Equipos> tablaPersonaSel = Tbl_Aula_Equipos.getSelectionModel().getSelectedItems();
            tablaPersonaSel.addListener(selecTblAula_Eq);
            ini_TblAulaEq();

            final ObservableList<TUso_Aula_Eq> tblUAula_Eq = Tbl_uso_Aula_Eq.getSelectionModel().getSelectedItems();
            tblUAula_Eq.addListener(selecTblUso_Aula_Eq);
            ini_TblU_AulaEq();

    }

    private final ListChangeListener<TAula_Equipos> selecTblAula_Eq = new ListChangeListener<TAula_Equipos>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends TAula_Equipos> c) { ponerUsuarioSelec(); }  };

    //2. Extraer los datos de la fila en la Tabla
    public TAula_Equipos getTablaUsuarioSeleccionada() {
        if (Tbl_Aula_Equipos != null) {
            List<TAula_Equipos> tabla = Tbl_Aula_Equipos.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final TAula_Equipos competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }
    //3. Poner los datos en las columnas
    private void ponerUsuarioSelec() {
        final TAula_Equipos user = getTablaUsuarioSeleccionada();
        posicion = Li_Aula_Equipo.indexOf(user);

        if (user != null) {
            T_ID_Equipo.setText(String.valueOf(user.getId_equipo()));
            T_ID_Materia.setText(user.getAula_ID());
            T_Cantidad.setText(String.valueOf(user.getCantidad()));
        }
    }
    void limpiarTXAula_eq(){
        T_ID_Materia.setText("");
        T_Cantidad.setText("");
        T_ID_Equipo.setText("");
    }

    //4. Mostrar los datos en los textbox
    public TAula_Equipos getsTextUser(){
        TAula_Equipos rev = new TAula_Equipos();
        rev.Aula_ID.set(T_ID_Materia.getText());
        rev.cantidad.set(T_Cantidad.getText());
        rev.id_equipo.set(T_ID_Equipo.getText());
        return rev;
    }
    //5. Inicializar la tabla, sus columnas, usuario es la tabla, y entre parentesis son sus atributos
    public void ini_TblAulaEq(){
        C_ID_Equipo.setCellValueFactory(new PropertyValueFactory<TAula_Equipos, String>("id_equipo"));
        C_Aula_ID.setCellValueFactory(new PropertyValueFactory<TAula_Equipos, String>("Aula_ID"));
        C_Cantidad.setCellValueFactory(new PropertyValueFactory<TAula_Equipos, String>("cantidad"));
       //L_Aula_Equipo.add(new Aula_Equipos(1,1,"1"));

        Tbl_Aula_Equipos.setItems(Li_Aula_Equipo);
    }
    //6. Declaramos la Lista
    //ObservableList<Aula_Equipos> L_Aula_Equipo= FXCollections.observableArrayList();


    //UsoAulaEquipos
    public TableView<TUso_Aula_Eq> Tbl_uso_Aula_Eq = new TableView<>();
    public TableColumn<TUso_Aula_Eq,String> C_Dia= new TableColumn<>();
    public TableColumn<TUso_Aula_Eq,String> C_Esp_tiempo= new TableColumn<>();
    public TableColumn<TUso_Aula_Eq,String> C_Grupo_ID= new TableColumn<>();
    public TableColumn<TUso_Aula_Eq,String> C_Materia_ID= new TableColumn<>();
    public TableColumn<TUso_Aula_Eq,String> C_UAula_ID= new TableColumn<>();
    public TextField T_UDia;
    public TextField T_UEsp_Tiempo;
    public TextField T_UGrupo_ID;
    public TextField T_UMateria_ID;
    public TextField T_UAula_ID;

    private final ListChangeListener<TUso_Aula_Eq> selecTblUso_Aula_Eq = new ListChangeListener<TUso_Aula_Eq>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends TUso_Aula_Eq> c) { ponerU_Aula_EqSelec(); }  };

    //2. Extraer los datos de la fila en la Tabla
    public TUso_Aula_Eq getTblU_Aula_Eq_Selec() {
        if (Tbl_Aula_Equipos != null) {
            List<TUso_Aula_Eq> tabla = Tbl_uso_Aula_Eq.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final TUso_Aula_Eq competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }
    //3. Poner los datos en las columnas
    private void ponerU_Aula_EqSelec() {
        final TUso_Aula_Eq user = getTblU_Aula_Eq_Selec();
        posicion = Li_UAula_Equipo.indexOf(user);

        if (user != null) {
            T_UGrupo_ID.setText(String.valueOf(user.getGrupo_ID()));
            T_UMateria_ID.setText(user.getMateria_ID());
            T_UEsp_Tiempo.setText(String.valueOf(user.getEsp_tiempo()));
            T_UDia.setText(String.valueOf(user.getDia()));
            T_UAula_ID.setText(String.valueOf(user.getAula_ID()));
        }
    }
    void limpiarTXU_Aula_eq(){
        T_UGrupo_ID.setText("");
        T_UMateria_ID.setText("");
        T_UEsp_Tiempo.setText("");
        T_UDia.setText("");
        T_UAula_ID.setText("");
    }

    //4. Mostrar los datos en los textbox
    public TUso_Aula_Eq getsTextU_Aula_Eq(){
        TUso_Aula_Eq rev = new TUso_Aula_Eq();
        rev.Aula_ID.set(T_UAula_ID.getText());
        rev.dia.set(T_UDia.getText());
        rev.esp_tiempo.set(T_UEsp_Tiempo.getText());
        rev.Grupo_ID.set(T_UGrupo_ID.getText());
        rev.Aula_ID.set(T_UAula_ID.getText());
        return rev;
    }
    //5. Inicializar la tabla, sus columnas, usuario es la tabla, y entre parentesis son sus atributos
    //public SimpleStringProperty dia, esp_tiempo,Aula_ID, Grupo_ID, Materia_ID;
    public void ini_TblU_AulaEq(){
        C_Materia_ID.setCellValueFactory(new PropertyValueFactory<TUso_Aula_Eq, String>("Materia_ID"));
        C_Dia.setCellValueFactory(new PropertyValueFactory<TUso_Aula_Eq, String>("dia"));
        C_Esp_tiempo.setCellValueFactory(new PropertyValueFactory<TUso_Aula_Eq, String>("esp_tiempo"));
        C_Grupo_ID.setCellValueFactory(new PropertyValueFactory<TUso_Aula_Eq, String>("Grupo_ID"));
        C_UAula_ID.setCellValueFactory(new PropertyValueFactory<TUso_Aula_Eq, String>("Aula_ID"));
        //L_UAula_Equipo.add(new Uso_Aula_Eq(1,1,"1","1","1"));

        Tbl_uso_Aula_Eq.setItems(Li_UAula_Equipo);
    }
    //6. Declaramos la Lista
    //ObservableList<Uso_Aula_Eq> L_UAula_Equipo= FXCollections.observableArrayList();


    public void B_LogIn(ActionEvent actionEvent) {
        L_LogIn= A.Consultar("LOGIN");
        String user=T_Usuario.getText(), pass= T_Pass.getText();
        for(int i=0; i<L_LogIn.size();i++){
            if(user.equals(L_LogIn.get(i).getProfesor_ID()) && pass.equals(L_LogIn.get(i).getPassword())){
                Stage stage = (Stage) B_logIn.getScene().getWindow();
                stage.close();
                try {
                    stage = FXMLLoader.load(getClass().getResource("/V_Aula_Equipos.fxml"));
                    stage.show();
                }catch(IOException e){
                    System.out.println("Error al abrir");
                }
            }
        }
    }

    public void BAula_Eq_Agregar(ActionEvent actionEvent) {
    }

    public void BAula_Eq__Eliminar(ActionEvent actionEvent) {
    }

    public void BAula_Eq__Modificar(ActionEvent actionEvent) {
    }

    public void B_Back(ActionEvent actionEvent) {

        try {
            Stage op = FXMLLoader.load(getClass().getResource("/V_Uso_Aula_Equipos.fxml"));

            op.setTitle("Servicios");
            op.show();
            Stage stage = (Stage) B_Regresa.getScene().getWindow();
            stage.close();
        }catch(IOException e){

            }
    }

    public void BUAula_Eq_Agregar(ActionEvent actionEvent) {
    }

    public void BUAula_Eq__Eliminar(ActionEvent actionEvent) {
    }

    public void BUAula_Eq__Modificar(ActionEvent actionEvent) {
    }
}
