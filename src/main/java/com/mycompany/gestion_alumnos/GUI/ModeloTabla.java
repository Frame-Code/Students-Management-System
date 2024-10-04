package com.mycompany.gestion_alumnos.GUI;

import com.mycompany.gestion_alumnos.LOGICA.Aula;
import com.mycompany.gestion_alumnos.LOGICA.Curso;
import com.mycompany.gestion_alumnos.LOGICA.Estudiante;
import com.mycompany.gestion_alumnos.LOGICA.Materia;
import com.mycompany.gestion_alumnos.LOGICA.PagoColegiatura;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author artist-code
 */
public interface ModeloTabla {
    public static final String TITULOS_PAGOS[] = {"ID", "MES", "MONTO"};
    
    default DefaultTableModel modeloTablaBasico() {
        return new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    default DefaultTableModel modeloTablaSeleccion() {
        return new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0;
            }

            public Class<?> getColumnClass(int column) {
                // La primera columna tendrá CheckBoxes, por lo tanto tipo Boolean
                if (column == 0) {
                    return Boolean.class;
                }
                return super.getColumnClass(column);
            }
        };
    }
    
    default DefaultTableModel borrarFilas(TableModel modeloTabla, int rowCount) {
        DefaultTableModel modelo = (DefaultTableModel) modeloTabla;
        modelo.setRowCount(0);
        return modelo;
    }

    default DefaultTableModel obtenerModeloTablaBasico(String titulos[]) {
        DefaultTableModel modeloTabla = modeloTablaBasico();
        modeloTabla.setColumnIdentifiers(titulos);
        return modeloTabla;
    }

    default DefaultTableModel obtenerModeloTablaMateriasSeleccion(String titulos[], List<Materia> listMaterias) {
        DefaultTableModel modeloTabla = modeloTablaSeleccion();
        modeloTabla.setColumnIdentifiers(titulos);
        for (Materia materia : listMaterias) {
            Object object[] = {false, materia.getId(), materia.getNombre()};
            modeloTabla.addRow(object);
        }
        return modeloTabla;
    }

    //Retorna un modelo de tabla donde las filas que se muestran son de las materias que no son parte del curso
    //Solo muestra las materias que no son parte del curso para poder seleccionarlas
    default DefaultTableModel obtenerModeloTablaMateriasSeleccion(String titulos[], List<Materia> listCompletaMaterias, List<Materia> listSeleccionadasMaterias) {
        DefaultTableModel modeloTabla = modeloTablaSeleccion();
        modeloTabla.setColumnIdentifiers(titulos);
        int contador = 0;
        for (Materia materia : listCompletaMaterias) {
            for (Materia materiaSeleccionada : listSeleccionadasMaterias) {
                if (!materia.getId().equals(materiaSeleccionada.getId())) {
                    contador++;
                }
            }
            if (contador == listSeleccionadasMaterias.size()) {
                Object object[] = {false, materia.getId(), materia.getNombre()};
                modeloTabla.addRow(object);
            }
            contador = 0;
        }
        return modeloTabla;
    }

    default DefaultTableModel obtenerModeloTablaAulasSeleccion(String titulos[], List<Aula> listAulas) {
        DefaultTableModel modeloTabla = modeloTablaSeleccion();
        modeloTabla.setColumnIdentifiers(titulos);
        for (Aula aula : listAulas) {
            Object object[] = {false, aula.getId(), aula.getNombre(), aula.getNumeroAsientosTotales(), aula.getNumeroAsientosDisponibles()};
            modeloTabla.addRow(object);
        }
        return modeloTabla;
    }

    default DefaultTableModel obtenerModeloTablaAulas(String titulos[], List<Aula> listAulas) {
        DefaultTableModel modeloTabla = modeloTablaBasico();
        modeloTabla.setColumnIdentifiers(titulos);
        for (Aula aula : listAulas) {
            Object object[] = {aula.getId(), aula.getNombre(), aula.getNumeroAsientosTotales(), aula.getNumeroAsientosDisponibles()};
            modeloTabla.addRow(object);
        }
        return modeloTabla;
    }
    default DefaultTableModel obtenerModeloTablaAulasConEstudiante(String titulos[], List<Aula> listAulas) {
        DefaultTableModel modeloTabla = modeloTablaBasico();
        modeloTabla.setColumnIdentifiers(titulos);
        for (Aula aula : listAulas) {
            Object object[] = {aula.getId(), aula.getNombre(), aula.getListEstudiantes().size(), aula.getNumeroAsientosDisponibles()};
            modeloTabla.addRow(object);
        }
        return modeloTabla;
    }

    default DefaultTableModel obtenerModeloTablaCursos(String titulos[], List<Curso> listCursos) {
        DefaultTableModel modeloTabla = modeloTablaBasico();
        modeloTabla.setColumnIdentifiers(titulos);
        for (Curso curso : listCursos) {
            Object object[] = {curso.getId(), curso.getNombre()};
            modeloTabla.addRow(object);
        }
        return modeloTabla;
    }
    
    default DefaultTableModel obtenerModeloTablaEstudiantes(String titulos[], List<Estudiante> listEstudiantes) {
        DefaultTableModel modeloTabla = modeloTablaBasico();
        modeloTabla.setColumnIdentifiers(titulos);
        for (Estudiante estudiante : listEstudiantes) {
            Object object[] = {0+estudiante.getId(), estudiante.getNombre(), estudiante.getEdad(), estudiante.getMatricula().getEstado()};
            modeloTabla.addRow(object);
        }
        return modeloTabla;
    }
    
    default DefaultTableModel obtenerModeloTablaPagos(String titulos[], List<PagoColegiatura> listPagos) {
        DefaultTableModel modeloTabla = modeloTablaBasico();
        modeloTabla.setColumnIdentifiers(titulos);
        for (PagoColegiatura pago : listPagos) {
            Object object[] = {pago.getId(), pago.getMes(), pago.getMonto()};
            modeloTabla.addRow(object);
        }
        return modeloTabla;
    }
    
}
