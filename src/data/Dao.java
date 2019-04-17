/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logic.Jugador;
import wow.Application;

/*
 * @author alefa
 */
public class Dao {

    private RelDatabase db;

    public Dao() {
        db = new RelDatabase();
    }

    public void agregarJugador(Jugador j) throws Exception {
        String sql = "insert into Jugador (nombre, genero, color_de_piel, nivel, raza, clase, faccion, ubicacion)"
                + "values ('%s', '%s', '%s', %d, %d, %d, %d, %d)";
        sql = String.format(sql, j.getNombre(), j.getGenero(), j.getColor(), j.getNivel(), j.getRaza().getId(), j.getClase().getId(), j.getFaccion().getId(), 1);

        if (db.executeUpdate(sql) == 0) {
            throw new Exception("Jugador ya existe");
        }
    }

    public ArrayList<Jugador> listaJugadores() throws Exception {
        String sql = "select * from Jugador";
        ResultSet rs = db.executeQuery(sql);
        ArrayList<Jugador> jugadores = new ArrayList<>();

        while (rs.next()) {
            jugadores.add(new Jugador(rs.getString("nombre"), rs.getString("genero"), rs.getString("color_de_piel"), rs.getInt("nivel"), ));
        }

        return jugadores;
    }

}
