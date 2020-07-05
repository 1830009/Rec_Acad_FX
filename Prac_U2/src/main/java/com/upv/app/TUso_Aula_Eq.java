package com.upv.app;

import javafx.beans.property.SimpleStringProperty;

public class TUso_Aula_Eq {

    public SimpleStringProperty dia, esp_tiempo,Aula_ID, Grupo_ID, Materia_ID;

    public TUso_Aula_Eq() {
        this.dia = new SimpleStringProperty();
        this.esp_tiempo = new SimpleStringProperty();
        this.Aula_ID = new SimpleStringProperty();
        this.Grupo_ID = new SimpleStringProperty();
        this.Materia_ID =new SimpleStringProperty();
    }

    public TUso_Aula_Eq(int dia, int esp_tiempo, String aula_ID, String grupo_ID, String materia_ID) {
        this.dia = new SimpleStringProperty(String.valueOf(dia));
        this.esp_tiempo = new SimpleStringProperty(String.valueOf( esp_tiempo));
        Aula_ID = new SimpleStringProperty(aula_ID);
        Grupo_ID = new SimpleStringProperty( grupo_ID);
        Materia_ID =new SimpleStringProperty( materia_ID);
    }

    public String getDia() {
        return dia.get();
    }

    public SimpleStringProperty diaProperty() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia.set(dia);
    }

    public String getEsp_tiempo() {
        return esp_tiempo.get();
    }

    public SimpleStringProperty esp_tiempoProperty() {
        return esp_tiempo;
    }

    public void setEsp_tiempo(String esp_tiempo) {
        this.esp_tiempo.set(esp_tiempo);
    }

    public String getAula_ID() {
        return Aula_ID.get();
    }

    public SimpleStringProperty aula_IDProperty() {
        return Aula_ID;
    }

    public void setAula_ID(String aula_ID) {
        this.Aula_ID.set(aula_ID);
    }

    public String getGrupo_ID() {
        return Grupo_ID.get();
    }

    public SimpleStringProperty grupo_IDProperty() {
        return Grupo_ID;
    }

    public void setGrupo_ID(String grupo_ID) {
        this.Grupo_ID.set(grupo_ID);
    }

    public String getMateria_ID() {
        return Materia_ID.get();
    }

    public SimpleStringProperty materia_IDProperty() {
        return Materia_ID;
    }

    public void setMateria_ID(String materia_ID) {
        this.Materia_ID.set(materia_ID);
    }
}
