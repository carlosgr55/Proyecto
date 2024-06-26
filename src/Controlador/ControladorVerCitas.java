package Controlador;

import Modelo.Componentes.CitasTableModel;
import Modelo.DAO.daoCitas;
import Modelo.DAO.daoVeterinarios;
import Modelo.VO.Cita;
import Modelo.VO.Cliente;
import Modelo.VO.Veterinario;
import Vista.VistaTablaCitasClientes;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ControladorVerCitas {

    private static VistaTablaCitasClientes vistaCitas;
    private static daoCitas dao = ControladorDetalleCita.getDaocitas();

    public static void mostrarVentana(boolean mostrar) {
        vistaCitas = new VistaTablaCitasClientes(); //Es necesario crear el objeto cuando se muestra la ventana para poder crear el filtro
        vistaCitas.setVisible(mostrar);

    }
    
    public static void cerrarVentana(){
        vistaCitas.setVisible(false);
        vistaCitas.dispose();
    }

    public static Cita getCitaTabla(int fila, JTable tabla) {
        Cita cita = null;
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila");
        } else {
            String id = tabla.getValueAt(fila, 0).toString();
            cita = dao.getCita(id);
        }
        return cita;
    }

    public static void eliminar(int index) {
        if (index == 1) {
            JOptionPane.showMessageDialog(null, "Selecciona una cita");
        } else {
            Cita cita = getCitaTabla(index, vistaCitas.getTabla_citas());
            habilitarVet(cita);
            dao.getLista().remove(cita);
            ControladorDetalleCita.getDaocitas().setLista(dao.getLista());  
            vistaCitas.setVisible(false);
            vistaCitas.dispose();
            mostrarVentana(true);
        }

    }
    
    public static void habilitarVet(Cita cita){
        daoVeterinarios daoVet = ControladorAgendarCita.getDaoVet();
        LocalDateTime fecha = cita.getFecha();
        Veterinario vet = cita.getVet();
        int index = daoVet.getListaVet().indexOf(vet);
        daoVet.getListaVet().get(index).addHora(fecha);
        ControladorAgendarCita.setDaoVet(daoVet);
    }

    public static void regresar() {
        vistaCitas.setVisible(false);
        ControladorMenuInicio.mostraVentana();
        vistaCitas.dispose();
    }

    public static void filtrarTabla(Cliente cliente, TableRowSorter<TableModel> sorter) {
        String filtro = cliente.getNombre();
        sorter.setRowFilter(RowFilter.regexFilter(filtro, 1));
    }

    public static JTable getTabla() {
        return vistaCitas.getTabla_citas();
    }

    public static void setTabla(JTable tabla) {
        vistaCitas.setTabla_citas(tabla);
    }

}
