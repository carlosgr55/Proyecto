package Modelo.Componentes;

import Controlador.ControladorDetalleCita;
import Modelo.DAO.daoCitas;
import Modelo.VO.Cita;
import Modelo.VO.Cliente;
import Modelo.VO.Veterinario;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class CitasTableModel extends AbstractTableModel {

    private String[] titulos = {"ID", "CLIENTE", "MASCOTA", "VETERINARIO", "FECHA", "HORA", "MOTIVO"};
    private daoCitas citasDao = ControladorDetalleCita.getDaocitas();
    private ArrayList<Cita> listaCitas;

    public CitasTableModel() {
        listaCitas = citasDao.getLista();
    }

    @Override
    public int getRowCount() {
        return citasDao.getLista().size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cita cita = citasDao.getLista().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cita.getId();
            case 1:
                return cita.getCliente().getNombre();
            case 2:
                return cita.getNomMascota();
            case 3:
                return cita.getVet().getNombre();
            case 4:
                return cita.getFecha().getDayOfMonth() + "-" + cita.getFecha().getMonthValue() + "-" + cita.getFecha().getYear();
            case 5:
                return cita.getFecha().getHour() + ":" + cita.getFecha().getMinute();
            case 6:
                return cita.getTipo();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return titulos[column];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Cita cita = citasDao.getLista().get(rowIndex);
        switch (columnIndex) {
            case 0:
                cita.setId((String) aValue);
            case 1:
                cita.setCliente((Cliente) aValue);
            case 2:
                cita.setNomMascota((String) aValue);
            case 3:
                cita.setVet((Veterinario) aValue);
            case 4:
                cita.setFecha((LocalDateTime) aValue);
            case 5:
                cita.setFecha((LocalDateTime) aValue);
            case 6:
                cita.setTipo((String) aValue);
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

}
