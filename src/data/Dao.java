/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
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
        
        ArrayList<Atributo> atributos = listaAtributosClase(j.getClase().getId()); 
        
        for (Atributo atributo : atributos){
            
            sql = "insert into AtributoJugador (valor, atributo, clase, jugador) values (%d, %d, %d, '%s')";
            sql = String.format(sql, atributo.getValor(), atributo.getIdentificador(), j.getClase(), j.getNombre());
            
            try {
                db.connect();
                if (db.executeUpdate(sql) == 0) {
                    throw new Exception("Atributo ya existe");
                }

            } finally {
                db.disconnect();
            }
        
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

    public Atributo getAtributo(int numero) throws Exception {
        String sql = String.format("select atributo.identificador, atributo.nombre, atributo.valor from Atributo where identificador = %d", numero);

        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return getObjetoAtributo(rs);
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
    
    public ArrayList<Atributo> listaAtributosClase(int numero) throws Exception {
        String sql = String.format("select ClaseAtributo.atributo, ClaseAtributo.valor_inicial from ClaseAtributo where clase = %d", numero);
        ArrayList<Atributo> atributos = new ArrayList<>();
        ArrayList<Integer> identificadorAtributos = new ArrayList<>();
        ArrayList<Integer> valoresAtributos = new ArrayList<>();
        try {
            db.connect();
            ResultSet rs = db.executeQuery(sql);

            while (rs.next()) {
                identificadorAtributos.add(rs.getInt("atributo"));
                valoresAtributos.add(rs.getInt("valor_inicial"));
            }
        } finally {
            db.disconnect();
        }

        try{
            
            for(int i = 0; i < identificadorAtributos.size(); i++){
                Atributo atributo = getAtributo(identificadorAtributos.get(i));
                atributo.setValor(valoresAtributos.get(i));
                atributos.add(atributo);   
            }
              
        } catch(Exception e){}
        
        
        return atributos;
    }

    public void updateUbicacion(String nombre, Integer ubicacion) throws SQLException, Exception {
        String sql = String.format("update Jugador set ubicacion = %d where nombre = '%s'", ubicacion, nombre);

        try {
            db.connect();
            if (db.executeUpdate(sql) == -1) {

            } else {
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

    public Jugador getJugador1(String nombre) throws SQLException, Exception {
        String sql = String.format("select * from Jugador where nombre = '%s'", nombre);
        Jugador jugador = new Jugador();

        try {
            db.connect();
            ResultSet rs = db.executeQuery(sql);

            jugador.setNombre(rs.getString("nombre"));
            jugador.setGenero(rs.getString("genero"));
            jugador.setColor(rs.getString("color_de_piel"));
            jugador.setNivel(rs.getInt("nivel"));
            jugador.setClase(this.getClase(rs.getInt("clase")));
            jugador.setRaza(this.getRaza(rs.getInt("raza")));
            jugador.setFaccion(this.getFaccion(rs.getInt("faccion")));
//            TODO
            jugador.setUbicacion(this.getSitio(rs.getInt("ubicacion")));
            jugador.setConectado(Boolean.valueOf(rs.getString("conectado")));
        } finally {
            db.disconnect();
        }

        return jugador;
    }

    private Faccion getObjetoFaccion(ResultSet rs) throws Exception {
        try {
            Faccion faccion = new Faccion();
            faccion.setId(rs.getInt("identificador"));
            faccion.setNombre(rs.getString("nombre"));
            return faccion;
        } catch (SQLException ex) {
            return null;
        }
    }

    public Faccion getFaccion(int numero) throws Exception {
        String sql = String.format("select * from Faccion where identificador = %d", numero);

        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return getObjetoFaccion(rs);
        } else {
            throw new Exception();
        }
    }

//    private Sitio getUbicacionDeJugador(int aInt) {
////        TODO
//    }
    private Atributo getObjetoAtributo(ResultSet rs) {
        try {
            Atributo atributo = new Atributo();
            atributo.setIdentificador(rs.getInt("identificacion"));
            atributo.setNombre(rs.getString("nombre"));            
            atributo.setValor(rs.getInt("valor"));
            return atributo;
        } catch (SQLException ex) {
            return null;
        }
    }

    public HashMap<String, Atributo> getAtributosDeJugador(String nombre) {
        String sql = String.format("SELECT Atributo.nombre, AtributoJugador.valor FROM AtributoJugador, ClaseAtributo, Atributo WHERE AtributoJugador.clase = ClaseAtributo.clase AND AtributoJugador.atributo = ClaseAtributo.atributo = Atributo.identificador AND AtributoJugador.jugador = '%s'", nombre);

        HashMap<String, Atributo> atributos = new HashMap<>();

        try {
            try {
                db.connect();
                ResultSet rs = db.executeQuery(sql);

                while (rs.next()) {
                    atributos.put(rs.getString("nombre"), this.getObjetoAtributo(rs));
                }
            } catch (SQLException ex) {
                ex.getMessage();
            } finally {
                db.disconnect();
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return atributos;
    }

    public HashMap<String, Encantamiento> getEncantamientosDeJugador(String nombre) {
        String sql = String.format("SELECT Encantamiento.nombre, EncantamientoJugador.valor FROM EncantamientoJugador, Encantamiento WHERE EncantamientoJugador.encantamiento = Encantamiento.identificador AND EncantamientoJugador.jugador = '%s';", nombre);

        HashMap<String, Encantamiento> encantamientos = new HashMap<>();

        try {
            try {
                db.connect();
                ResultSet rs = db.executeQuery(sql);

                while (rs.next()) {
                    encantamientos.put(rs.getString("nombre"), this.getObjetoEncantamiento(rs));
                }
            } catch (SQLException ex) {
                ex.getMessage();
            } finally {
                db.disconnect();
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return encantamientos;
    }

    private Objeto getObjetoObjeto(ResultSet rs) {
        try {
            Objeto objeto = new Objeto();
            objeto.setId(rs.getInt("identificador"));
            objeto.setNombre(rs.getString("nombre"));
            objeto.setTipo(rs.getString("tipo"));
            objeto.setNivel(rs.getInt("nivel_requerido"));
            objeto.setEquipado(rs.getBoolean("equipado"));
            objeto.setJugador(this.getJugador1(rs.getString("jugador")));
            return objeto;
        } catch (Exception ex) {
            return null;
        }
    }

    public ArrayList<Objeto> getObjetosDeJugador(String nombre, int equipado) {
        String sql = String.format("SELECT * FROM Objeto WHERE jugador = '%s' AND equipado = %d", nombre, equipado);

        ArrayList<Objeto> objetos = new ArrayList<>();

        try {
            try {
                db.connect();
                ResultSet rs = db.executeQuery(sql);

                while (rs.next()) {
                    objetos.add(this.getObjetoObjeto(rs));
                }
            } catch (SQLException ex) {
                ex.getMessage();
            } finally {
                db.disconnect();
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return objetos;
    }

    public ArrayList<Atributo> getAtributosDeJugadorModificadosPorObjeto(int identificador, String nombre) {
        String sql = String.format("SELECT Atributo.nombre, AtributoObjeto.valor_modificador as valor FROM AtributoObjeto, AtributoJugador, ClaseAtributo, Atributo WHERE AtributoObjeto.clase = AtributoJugador.clase = ClaseAtributo.clase AND AtributoObjeto.atributo = AtributoJugador.atributo = ClaseAtributo.atributo = Atributo.identificador AND AtributoObjeto.jugador = AtributoJugador.jugador AND AtributoJugador.jugador = '%s' AND AtributoObjeto.objeto = %d", nombre, identificador);

        ArrayList<Atributo> atributos = new ArrayList<>();

        try {
            try {
                db.connect();
                ResultSet rs = db.executeQuery(sql);

                while (rs.next()) {
                    atributos.add(this.getObjetoAtributo(rs));
                }
            } catch (SQLException ex) {
                ex.getMessage();
            } finally {
                db.disconnect();
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return atributos;
    }
    
    private Encantamiento getObjetoEncantamiento(ResultSet rs) {
        try {
            Encantamiento encantamiento = new Encantamiento();
            encantamiento.setIdentificador(rs.getInt("identificacion"));
            encantamiento.setNombre(rs.getString("nombre"));            
            encantamiento.setValor(rs.getInt("valor"));
            return encantamiento;
        } catch (SQLException ex) {
            return null;
        }
    }

    public ArrayList<Encantamiento> getEncantamientosDeJugadorModificadosPorObjeto(int identificador, String nombre) {
        String sql = String.format("SELECT Encantamiento.nombre, EncantamientoObjeto.valor_modificador as valor FROM EncantamientoObjeto, EncantamientoJugador, Encantamiento WHERE EncantamientoObjeto.encantamiento = EncantamientoJugador.encantamiento = Encantamiento.identificador AND EncantamientoObjeto.jugador = EncantamientoJugador.jugador AND EncantamientoJugador.jugador = '%s' AND EncantamientoObjeto.objeto = %d", nombre, identificador);

        ArrayList<Encantamiento> encantamientos = new ArrayList<>();

        try {
            try {
                db.connect();
                ResultSet rs = db.executeQuery(sql);

                while (rs.next()) {
                    encantamientos.add(this.getObjetoEncantamiento(rs));
                }
            } catch (SQLException ex) {
                ex.getMessage();
            } finally {
                db.disconnect();
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return encantamientos;
    }
    
//    private Jugador getObjetoJugador(ResultSet rs) {
//        try {
//            Jugador jugador = new Jugador();
//            jugador.setNombre(rs.getString("nombre"));
//            jugador.setGenero(rs.getString("genero"));
//            jugador.setColor(rs.getString("color_de_piel"));
//            jugador.setNivel(rs.getInt("nivel"));
//            jugador.setRaza(this.getObjetoRaza(rs));
//            jugador.setClase(this.getObjetoClase(rs));
//            jugador.setFaccion(this.getObjetoFaccion(rs));
//            return jugador;
//        } catch (Exception ex) {
//            return null;
//        }
//    }

    public Vector<String> getJugadoresAEquipar() {
        String sql = "SELECT Jugador.nombre FROM Jugador";

        Vector<String> jugadores = new Vector<>();

        try {
            try {
                db.connect();
                ResultSet rs = db.executeQuery(sql);

                while (rs.next()) {
                    jugadores.add(rs.getString("nombre"));
                }
            } catch (SQLException ex) {
                ex.getMessage();
            } finally {
                db.disconnect();
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return jugadores;
    }
}
