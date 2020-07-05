package com.upv.app;

import javafx.beans.property.SimpleStringProperty;


public class TAula_Equipos {

    public SimpleStringProperty Aula_ID,id_equipo, cantidad;


    public TAula_Equipos(){
        this.Aula_ID= new SimpleStringProperty();
        this.id_equipo= new SimpleStringProperty();
        this.cantidad= new SimpleStringProperty();
    }
    public TAula_Equipos(int id_equipo, int cantidad, String aula_ID) {
        this.id_equipo = new SimpleStringProperty(String.valueOf(id_equipo));
        this.cantidad =  new SimpleStringProperty(String.valueOf(cantidad));
        Aula_ID = new SimpleStringProperty(aula_ID);
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

    public String getId_equipo() {
        return id_equipo.get();
    }

    public SimpleStringProperty id_equipoProperty() {
        return id_equipo;
    }

    public void setId_equipo(String id_equipo) {
        this.id_equipo.set(id_equipo);
    }

    public String getCantidad() {
        return cantidad.get();
    }

    public SimpleStringProperty cantidadProperty() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad.set(cantidad);
    }
}

