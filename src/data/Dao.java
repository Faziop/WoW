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
import logic.Continente;
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
        String sql = "insert into Jugador (nombre, genero, color_de_piel, nivel, raza, clase, faccion, ubicacion)"
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
    
    private Sitio getObjetoSitio(ResultSet rs) throws Exception {
        try {
            Sitio sitio = new Sitio();
            sitio.setId(rs.getInt("identificador"));
            sitio.setNombre(rs.getString("nombre"));
            return sitio;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Sitio getSitio(int numero) throws Exception {
        String sql = String.format("select sitio.identificador, sitio.nombre from Sitio where identificador = %d", numero);

        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return getObjetoSitio(rs);
        } else {
            throw new Exception();
        }
    }
    
    private Continente getObjetoContinente(ResultSet rs) throws Exception {
        try {
            Continente continente = new Continente();
            continente.setId(rs.getInt("identificador"));
            continente.setNombre(rs.getString("nombre"));
            return continente;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Continente getContinente(int numero) throws Exception {
        String sql = String.format("select continente.identificador, continente.nombre from Continente where identificador = %d", numero);

        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return getObjetoContinente(rs);
        } else {
            throw new Exception();
        }
    }
    
    private Region getObjetoRegion(ResultSet rs) throws Exception {
        try {
            Region region = new Region();
            region.setId(rs.getInt("identificador"));
            region.setNombre(rs.getString("nombre"));
            region.setContinente(getContinente(rs.getInt("continente")));
            return region;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Region getRegion(int numero) throws Exception {
        String sql = String.format("select region.identificador, region.nombre, region.continente from Region where identificador = %d", numero);

        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return getObjetoRegion(rs);
        } else {
            throw new Exception();
        }
    }
    
    private Raza getObjetoRaza(ResultSet rs) throws Exception {
        try {
            Raza raza = new Raza();
            raza.setId(rs.getInt("identificador"));
            raza.setNombre(rs.getString("nombre"));
            raza.setRegion(getRegion(rs.getInt("region")));
            return raza;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Raza getRaza(int numero) throws Exception {
        String sql = String.format("select raza.identificador, raza.nombre, raza.region from Raza where identificador = %d", numero);

        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return getObjetoRaza(rs);
        } else {
            throw new Exception();
        }
    }

    private Clase getObjetoClase(ResultSet rs) throws Exception {
        try {
            Clase clase = new Clase();
            clase.setId(rs.getInt("identificador"));
            clase.setNombre(rs.getString("nombre"));
            return clase;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Clase getClase(int numero) throws Exception {
        String sql = String.format("select clase.identificador, clase.nombre from Clase where identificador = %d", numero);

        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return getObjetoClase(rs);
        } else {
            throw new Exception();
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
    
    public ArrayList<Jugador> listaJugadoresTele() throws Exception {
        String sql = "select jugador.nombre, jugador.raza, jugador.clase, jugador.ubicacion, jugador.conectado from Jugador where jugador.conectado = true";
        ArrayList<Jugador> jugadores = new ArrayList<>();

        try {
            db.connect();
            ResultSet rs = db.executeQuery(sql);

            while (rs.next()) {
                Jugador jugador = new Jugador();
                jugador.setNombre(rs.getString("nombre"));
                jugador.setRaza(getRaza(rs.getInt("raza")));
                jugador.setClase(getClase(rs.getInt("clase")));
                jugador.setUbicacion(getSitio(rs.getInt("ubicacion")));
                jugador.setConectado((rs.getInt("conectado") == 1));
                jugadores.add(jugador);
            }
        } finally {
            db.disconnect();
        }

        return jugadores;
    }

    public void updateUbicacion(String nombre, Integer ubicacion) throws SQLException, Exception {
        String sql = String.format("update Jugador set ubicacion = %d where nombre = '%s' and conectado = true", ubicacion, nombre);

        try {
            db.connect();
            if (db.executeUpdate(sql) != -1) {
                throw new Exception();
            }
        } finally {
            db.disconnect();
        }
    }

    public Jugador getJugador(String nombre) throws SQLException, Exception {
        String sql = String.format("select jugador.ubicacion, jugador.raza from Jugador where nombre = '%s'", nombre);
        Jugador jugador = new Jugador();

        try {
            db.connect();
            ResultSet rs = db.executeQuery(sql);
            jugador.setUbicacion(getSitio(rs.getInt("ubicacion")));
            jugador.setRaza(getRaza(rs.getInt("raza")));
        } finally {
            db.disconnect();
        }

        return jugador;
    }

    public ArrayList<Jugador> listaJugadoresFiltro(String nombre) throws SQLException, Exception {
        String sql;
        
        if(nombre.equals(""))
            sql = String.format("select jugador.nombre, jugador.raza, jugador.clase, jugador.ubicacion, jugador.conectado, jugador.nivel from Jugador where jugador.conectado = true");
        else
            sql = String.format("select jugador.nombre, jugador.raza, jugador.clase, jugador.ubicacion, jugador.conectado, jugador.nivel from Jugador where jugador.conectado = true and nombre like '%%%s%%'", nombre);
        ArrayList<Jugador> jugadores = new ArrayList<>();

        try {
            db.connect();
            ResultSet rs = db.executeQuery(sql);

            while (rs.next()) {
                Jugador jugador = new Jugador();
                jugador.setNombre(rs.getString("nombre"));
                jugador.setRaza(getRaza(rs.getInt("raza")));
                jugador.setClase(getClase(rs.getInt("clase")));
                jugador.setUbicacion(getSitio(rs.getInt("ubicacion")));
                jugador.setConectado((rs.getInt("conectado") == 1));
                jugador.setNivel(rs.getInt("nivel"));
                jugadores.add(jugador);
            }
        } finally {
            db.disconnect();
        }

        return jugadores;
        
    }
}
