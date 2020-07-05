package com.upv.app;

import com.mycompany.app.Aula_Equipos;
import com.mycompany.app.Uso_Aula_Eq;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Casteo {

    public ObservableList<TAula_Equipos> CastAula_Eq(List<Aula_Equipos> A){
        ObservableList<TAula_Equipos> O = FXCollections.observableArrayList();
        for(int i=0;i<A.size();i++){
            O.add(new TAula_Equipos(A.get(i).getId_equipo(),A.get(i).getCantidad(),A.get(i).getAula_ID()));
        }
        return O;
    }

    public ObservableList<TUso_Aula_Eq> CastUso_Aula_Eq(List<Uso_Aula_Eq> A){
        ObservableList<TUso_Aula_Eq> O = FXCollections.observableArrayList();
        for(int i=0;i<A.size();i++){
            O.add(new TUso_Aula_Eq(A.get(i).getDia(),A.get(i).getEsp_tiempo(),A.get(i).getAula_ID(),
                    A.get(i).getGrupo_ID(),A.get(i).getMateria_ID()));
        }
        return O;
    }
}
