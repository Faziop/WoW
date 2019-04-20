/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

public class Encantamiento {
    int identificador;
    String nombre;
    int valor;

    public Encantamiento() {
    }

    public Encantamiento(int identificador, String nombre, int valor) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.valor = valor;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    

}
