package presentation.Equipar;

import java.util.ArrayList;
import logic.Atributo;
import logic.Encantamiento;
import logic.Objeto;

public class ContendedorDeObjeto {
    Objeto objeto;
    ArrayList<Atributo> atributos;
    ArrayList<Encantamiento> encantamientos;

    public ContendedorDeObjeto(Objeto objeto, ArrayList<Atributo> atributos, ArrayList<Encantamiento> encantamientos) {
        this.objeto = objeto;
        this.atributos = atributos;
        this.encantamientos = encantamientos;
    }

    ContendedorDeObjeto() {
        
    }
    
    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public ArrayList<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(ArrayList<Atributo> atributos) {
        this.atributos = atributos;
    }

    public ArrayList<Encantamiento> getEncantamientos() {
        return encantamientos;
    }

    public void setEncantamientos(ArrayList<Encantamiento> encantamientos) {
        this.encantamientos = encantamientos;
    }
    
}
