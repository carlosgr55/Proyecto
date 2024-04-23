package Modelo.Componentes;

import Controlador.ControladorDetalleCita;
import Modelo.DAO.daoCitas;
import Modelo.DAO.daoDiagnosticos;
import Modelo.VO.Cita;
import Modelo.VO.Cliente;
import Modelo.VO.Diagnostico;
import Modelo.VO.Veterinario;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class HistorialTableModel extends AbstractTableModel {

    private String[] titulos = {"ID", "CLIENTE", "MASCOTA", "VETERINARIO", "FECHA", "DIAGNOSTICO"};
    private daoCitas citasDao = ControladorDetalleCita.getDaocitas();
    private ArrayList<Cita> listaCitas;
    private daoDiagnosticos daoDiagnosticos = new daoDiagnosticos();
    private ArrayList<Diagnostico> listaDiagnosticos;

    public HistorialTableModel() {
        listaCitas = citasDao.getLista();
        listaDiagnosticos = daoDiagnosticos.getLista();
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
        Diagnostico diagnostico = listaDiagnosticos.get(rowIndex);
        Cita cita = diagnostico.getCita();
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
                return diagnostico.getDiagnostico();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return titulos[column];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Diagnostico diagnostico = listaDiagnosticos.get(rowIndex);
        Cita cita = diagnostico.getCita();
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
                diagnostico.setDiagnostico((String) aValue);
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

}
