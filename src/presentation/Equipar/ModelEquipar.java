package presentation.Equipar;

import java.util.ArrayList;
import java.util.HashMap;
import logic.Atributo;
import logic.Clase;
import logic.Continente;
import logic.Encantamiento;
import logic.Faccion;
import logic.Jugador;
import logic.Objeto;
import logic.Raza;
import logic.Region;
import logic.Sitio;

public class ModelEquipar {
    private Jugador jugador;
    private HashMap<String ,Atributo> atributos;
    private HashMap<String ,Encantamiento> encantamientos;
    private ObjetoListModel equipamiento;
    private ObjetoListModel inventario;

    public ModelEquipar() {
        Sitio sitio = new Sitio(1, "Vertormenta", "Villa", null);
        Region region = new Region(1, "Region Azerot 1", "Vertormenta", new Continente(1, "Azerot"));
        this.jugador = new Jugador("GonzaCRC", "Masculino", "Blanco", 12, new Clase(1, "Guerrero"), new Raza(1, "Humano"), new Faccion(1, "Alianza"), sitio, true);
        this.atributos = new HashMap();
        this.encantamientos = new HashMap();
        this.equipamiento = new ObjetoListModel();
        this.inventario = new ObjetoListModel();
        
        Objeto objeto1 = new Objeto(1, "Espada X", "Arma", 5, false, jugador);
        Objeto objeto2 = new Objeto(2, "Casco Z", "Pechera", 5, false, jugador);
        
        ArrayList<Atributo> atributosobjeto1 = new ArrayList<>();
        ArrayList<Atributo> atributosobjeto2 = new ArrayList<>();
        
        Atributo atributos1objeto1 = new Atributo("Intelecto", 4);
        Atributo atributos2objeto2 = new Atributo("Mana", 8);
        
        atributosobjeto1.add(atributos1objeto1);
        atributosobjeto2.add(atributos2objeto2);
        
        ArrayList<Encantamiento> encantamientosobjeto1 = new ArrayList<>();
        ArrayList<Encantamiento> encantamientosobjeto2 = new ArrayList<>();
        
        Encantamiento encantamiento1objeto1 = new Encantamiento("Golpe critico", 5);
        Encantamiento encantamiento2objeto2 = new Encantamiento("Veneno", 10);
        
        encantamientosobjeto1.add(encantamiento1objeto1);
        encantamientosobjeto2.add(encantamiento2objeto2);
        
        ContendedorDeObjeto contenedorObjeto1 = new ContendedorDeObjeto(objeto1, atributosobjeto1, encantamientosobjeto1);
        ContendedorDeObjeto contenedorObjeto2 = new ContendedorDeObjeto(objeto2, atributosobjeto2, encantamientosobjeto2);
        
        inventario.addObjeto(contenedorObjeto1);
        inventario.addObjeto(contenedorObjeto2);
        
        Atributo atributo1 = new Atributo("Intelecto", 1);
        Atributo atributo2 = new Atributo("Estamina", 2);
        Atributo atributo3 = new Atributo("Mana", 3);
        Atributo atributo4 = new Atributo("Agilidad", 4);
        
        atributos.put("Intelecto", atributo1);
        atributos.put("Estamina", atributo2);
        atributos.put("Mana", atributo3);
        atributos.put("Agilidad", atributo4);
        
        Encantamiento encantamiento1 = new Encantamiento("Golpe critico", 1);
        Encantamiento encantamiento2 = new Encantamiento("Hipnosis", 2);
        Encantamiento encantamiento3 = new Encantamiento("Suerte", 3);
        Encantamiento encantamiento4 = new Encantamiento("Veneno", 4);
        
        encantamientos.put("Golpe critico", encantamiento1);
        encantamientos.put("Hipnosis", encantamiento2);
        encantamientos.put("Suerte", encantamiento3);
        encantamientos.put("Veneno", encantamiento4);
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public HashMap<String, Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(HashMap<String, Atributo> atributos) {
        this.atributos = atributos;
    }

    public HashMap<String, Encantamiento> getEncantamientos() {
        return encantamientos;
    }

    public void setEncantamientos(HashMap<String, Encantamiento> encantamientos) {
        this.encantamientos = encantamientos;
    }    

    public ObjetoListModel getEquipamiento() {
        return equipamiento;
    }

    public void setEquipamiento(ObjetoListModel equipamiento) {
        this.equipamiento = equipamiento;
    }

    public ObjetoListModel getInventario() {
        return inventario;
    }

    public void setInventario(ObjetoListModel inventario) {
        this.inventario = inventario;
    }
}
