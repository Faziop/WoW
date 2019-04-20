package wow;

import data.RelDatabase;
import presentation.Agregar.ControllerAgregar;
import presentation.Agregar.ModelAgregar;
import presentation.Agregar.ViewAgregar;
import presentation.Borrar.ControllerBorrar;
import presentation.Borrar.ModelBorrar;
import presentation.Borrar.ViewBorrar;
import presentation.Listar.ControllerListar;
import presentation.Listar.ModelListar;
import presentation.Equipar.ControllerEquipar;
import presentation.Equipar.ModelEquipar;
import presentation.Equipar.ViewEquipar;
import presentation.Localizar.ControllerLocalizar;
import presentation.Localizar.ModelLocalizar;
import presentation.Localizar.ViewJugadores;
import presentation.Teletransportar.ControllerTeletransportar;
import presentation.Teletransportar.ModelTeletransportar;
import presentation.Teletransportar.ViewTeletransportar;
import presentation.menu.ControllerMenu;
import presentation.menu.ModelMenu;
import presentation.menu.ViewMenu;

/*
 * @author alefa
 */
public class Application {
    public static RelDatabase DB;
    public static ControllerMenu CONTROLLER_MENU;
    public static ControllerAgregar CONTROLLER_AGREGAR;
    public static ControllerBorrar CONTROLLER_BORRAR;
    public static ControllerEquipar CONTROLLER_EQUIPAR;
    public static ControllerTeletransportar CONTROLLER_TELETRANSPORTAR;
    public static ControllerLocalizar CONTROLLER_LOCALIZAR;
    public static ControllerListar CONTROLLER_LISTAR;

    
    public static void main(String[] args) {
        RelDatabase rdb = new RelDatabase();
        DB = rdb;
        
        ModelMenu mm = new ModelMenu();
        ViewMenu vm = new ViewMenu();
        ControllerMenu cm = new ControllerMenu(mm, vm);
        CONTROLLER_MENU = cm;
        
        ModelAgregar ma = new ModelAgregar();
        ViewAgregar va = new ViewAgregar();
        ControllerAgregar ca = new ControllerAgregar(ma, va);
        CONTROLLER_AGREGAR = ca;
        
        ModelBorrar mb = new ModelBorrar();
        ViewBorrar vb = new ViewBorrar();
        ControllerBorrar cb = new ControllerBorrar(mb, vb);        
        CONTROLLER_BORRAR = cb;
        
        
        ModelEquipar me = new ModelEquipar();
        ViewEquipar ve = new ViewEquipar();
        ControllerEquipar ce = new ControllerEquipar(me, ve);        
        CONTROLLER_EQUIPAR = ce;
        
        ModelTeletransportar mt = new ModelTeletransportar();
        ViewTeletransportar vt = new ViewTeletransportar();
        ControllerTeletransportar ct = new ControllerTeletransportar(mt, vt);        
        CONTROLLER_TELETRANSPORTAR = ct;
        
        ModelLocalizar ml = new ModelLocalizar();
        presentation.Localizar.ViewJugadores vl = new presentation.Localizar.ViewJugadores();
        ControllerLocalizar cl = new ControllerLocalizar(ml, vl);        
        CONTROLLER_LOCALIZAR = cl;
        
        ModelListar mlis = new ModelListar();
        presentation.Listar.ViewJugadores vlis = new presentation.Listar.ViewJugadores();
        ControllerListar clis = new ControllerListar(mlis, vlis);        
        CONTROLLER_LISTAR = clis;
        
        vm.setVisible(true);
    }
    
}
