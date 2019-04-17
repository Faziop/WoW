/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logic.Clase;
import logic.Faccion;
import logic.Jugador;
import logic.Raza;
import logic.Region;
import logic.Sitio;
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
        String sql = "insert into Jugador (nombre, genero, color_de_piel, nivel, raza, clase, faccion, ubicacion) "
                + "values ('%s', '%s', '%s', %d, %d, %d, %d, %d)";
        sql = String.format(sql, j.getNombre(), j.getGenero(), j.getColor(), j.getNivel(), j.getRaza().getId(), j.getClase().getId(), j.getFaccion().getId(), 1);
        try {
            db.connect();
            if (db.executeUpdate(sql) == 0) {
                throw new Exception("Jugador ya existe");
            }

        } finally {
            db.disconnect();
        }
    }

    public ArrayList<Jugador> listaJugadores() throws Exception {
        String sql = "select jugador.nombre, jugador.genero, jugador.color_de_piel, jugador.nivel, jugador.raza, jugador.clase, jugador.faccion, jugador.ubicacion, clase.id, clase.nombre, raza.nombre, faccion.nombre, sitio.nombre from Jugador, Clase, Raza, Faccion, Sitio where Jugador.raza = Raza.id and Jugador.clase = Clase.id and Jugador.faccion = Faccion.id";
        ArrayList<Jugador> jugadores = new ArrayList<>();

        try {
            db.connect();
            ResultSet rs = db.executeQuery(sql);

            while (rs.next()) {
                jugadores.add(new Jugador(rs.getString("nombre"), rs.getString("genero"), rs.getString("color_de_piel"), rs.getInt("nivel"),
                        new Clase(-1, rs.getString(9)),
                        new Raza(-1, rs.getString(10)),
                        new Faccion(-1, rs.getString(11)),
                        new Sitio(-1, rs.getString(12), null, null), true));
            }
        } finally {
            db.disconnect();
        }

        return jugadores;
    }
}
