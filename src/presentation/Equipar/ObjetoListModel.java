package presentation.Equipar;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import logic.Atributo;
import logic.Encantamiento;

public class ObjetoListModel extends AbstractListModel {

    private ArrayList<ContendedorDeObjeto> objetos;

    public ObjetoListModel() {
        this.objetos = new ArrayList<>();
    }

    public void addObjeto(ContendedorDeObjeto objeto) {
        objetos.add(objeto);
        this.fireIntervalAdded(this, getSize(), getSize() + 1);
    }

    public void eliminarObjeto(int index) {
        objetos.remove(index);
        this.fireIntervalRemoved(index, getSize(), getSize() + 1);
    }

    @Override
    public int getSize() {
        return objetos.size();
    }
    
    @Override
    public String getElementAt(int index) {
        ContendedorDeObjeto objeto = objetos.get(index);
        
        String atributosModificados = "";
        String colorDeAtributo = "";
        
        for(Atributo atr : objeto.getAtributos()) {
            
            switch (atr.getNombre()) {
                case "Intelecto": colorDeAtributo = "#DAA520"; break;
                case "Estamina": colorDeAtributo = "green"; break;
                case "Mana": colorDeAtributo = "blue"; break;
                case "Agilidad": colorDeAtributo = "tomato"; break;
            }
            
            atributosModificados += String.format("<br><span style=\"color: %s\">&emsp;+%d %s</span>", colorDeAtributo, atr.getValor(), atr.getNombre());
        }
        
        String encantamientosModificados = "";
        String colorDeEncantamiento = "";
        
        for(Encantamiento enc : objeto.getEncantamientos()) {
            
            switch (enc.getNombre()) {
                case "Golpe critico": colorDeEncantamiento = "red"; break;
                case "Hipnosis": colorDeEncantamiento = "#DA70D6"; break;
                case "Suerte": colorDeEncantamiento = "#6A5ACD"; break;
                case "Veneno": colorDeEncantamiento = "#006400"; break;
            }
            
            encantamientosModificados += String.format("<br><span style=\"color: %s\">&emsp;+%d %s</span>", colorDeEncantamiento, enc.getValor(), enc.getNombre());
        }

        String descripcion = String.format("<html>%s%s%s</html>", objeto.getObjeto().getNombre(), atributosModificados, encantamientosModificados);

        return descripcion;
    }

    public ContendedorDeObjeto getObjeto(int index) {
        return objetos.get(index);
    }
}
