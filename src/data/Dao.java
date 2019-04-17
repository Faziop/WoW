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

        if (db.executeUpdate(sql) == 0) {
            throw new Exception("Jugador ya existe");
        }
    }

    public ArrayList<Jugador> listaJugadores() throws Exception {
        String sql = "select jugador.nombre, jugador.genero, jugador.color_de_piel, jugador.nivel, jugador.raza, jugador.clase, jugador.faccion, jugador.ubicacion, "
                + "clase.id, clase.nombre, raza.id, raza.nombre, raza.region, faccion.id, faccion.nombre "
                + "from Jugador, Clase, Raza, Faccion "
                + "where Jugador.raza = Raza.id and Jugador.clase = Clase.id and Jugador.faccion = Faccion.id";
        ResultSet rs = db.executeQuery(sql);
        ArrayList<Jugador> jugadores = new ArrayList<>();

        while (rs.next()) {
            //Ocupo aiuda
//            jugadores.add(new Jugador(rs.getString("nombre"), rs.getString("genero"), rs.getString("color_de_piel"), rs.getInt("nivel"), 
//                    new Clase(rs.getInt("id"), rs.getString("nombre:1")),
//                    new Raza(rs.getInt("id:1"), rs.getString("nombre:2")), 
//                    new Faccion(rs.getInt("id:2"), rs.getString("nombre:3")), 
//                    new Sitio(rs.getInt("id:3"), rs.getString("nombre:4"), rs.getString("tipo"), 
//                            new Region(rs.getInt("region:1")))));
        }

        return jugadores;
    }
}
