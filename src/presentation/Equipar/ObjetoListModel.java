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
        String colorDeLinea = "";
        char signoDelValor;
        
        for(Atributo atr : objeto.getAtributos()) {
            
            if (atr.getValor() > 0) {
                signoDelValor = '+';
                colorDeLinea = "green";
            } else{                
                signoDelValor = '-';
                colorDeLinea = "red";
            }
            
            atributosModificados += String.format("<br><span style=\"color: %s\">&emsp;%c %d %s</span>", colorDeLinea, signoDelValor, Math.abs(atr.getValor()), atr.getNombre());
        }
        
        String encantamientosModificados = "";
        
        for(Encantamiento enc : objeto.getEncantamientos()) {
            
            if (enc.getValor() > 0) {
                signoDelValor = '+';
                colorDeLinea = "green";
            } else{                
                signoDelValor = '-';
                colorDeLinea = "red";
            }
            
            encantamientosModificados += String.format("<br><span style=\"color: %s\">&emsp;%c %d %s</span>", colorDeLinea, signoDelValor, Math.abs(enc.getValor()), enc.getNombre());
        }

        String descripcion = String.format("<html>%s%s%s</html>", objeto.getObjeto().getNombre(), atributosModificados, encantamientosModificados);

        return descripcion;
    }

    public ContendedorDeObjeto getObjeto(int index) {
        return objetos.get(index);
    }
}
