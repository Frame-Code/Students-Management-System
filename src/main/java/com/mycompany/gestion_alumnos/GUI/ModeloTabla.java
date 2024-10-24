package com.mycompany.gestion_alumnos.GUI;

import com.mycompany.gestion_alumnos.DAO.ControlDAO;
import com.mycompany.gestion_alumnos.LOGICA.Aula;
import com.mycompany.gestion_alumnos.LOGICA.Curso;
import com.mycompany.gestion_alumnos.LOGICA.Estudiante;
import com.mycompany.gestion_alumnos.LOGICA.Materia;
import com.mycompany.gestion_alumnos.LOGICA.PagoColegiatura;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *  This interface is used to get a different type of defaultTableModel when is necessary used at the difference JFrame and JPanel
 * @author Frame-Code
 */
public interface ModeloTabla {

    public ControlDAO controladora = new ControlDAO();
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

            @Override
            public Class<?> getColumnClass(int column) {
                // La primera columna tendrá CheckBoxes, por lo tanto tipo Boolean
                if (column == 0) {
                    return Boolean.class;
                }
                return super.getColumnClass(column);
            }
        };
    }
    
    //Method to delete all rows of a JTable
    default DefaultTableModel borrarFilas(TableModel modeloTabla, int rowCount) {
        DefaultTableModel modelo = (DefaultTableModel) modeloTabla;
        modelo.setRowCount(0);
        return modelo;
    }
    
    //Method to get a defaultTableModel basic within rows, just te title
    default DefaultTableModel obtenerModeloTablaBasico(String titulos[]) {
        DefaultTableModel modeloTabla = modeloTablaBasico();
        modeloTabla.setColumnIdentifiers(titulos);
        return modeloTabla;
    }
    
    //Method to get a defaultTableModel where his rows are a list of subjects
    //And his rows can be selected
    default DefaultTableModel obtenerModeloTablaMateriasSeleccion(String titulos[], List<Materia> listMaterias) {
        DefaultTableModel modeloTabla = modeloTablaSeleccion();
        modeloTabla.setColumnIdentifiers(titulos);
        for (Materia materia : listMaterias) {
            Object object[] = {false, materia.getId(), materia.getNombre()};
            modeloTabla.addRow(object);
        }
        return modeloTabla;
    }
    
    //Method to get a defaultTableModel where his rows are a list of subjects
    default DefaultTableModel obtenerModeloTablaMaterias(String titulos[], List<Materia> listMaterias) {
        DefaultTableModel modeloTabla = modeloTablaBasico();
        modeloTabla.setColumnIdentifiers(titulos);
        for (Materia materia : listMaterias) {
            Object object[] = {materia.getId(), materia.getNombre()};
            modeloTabla.addRow(object);
        }
        return modeloTabla;
    }

    //Method to get a defaultTableModel where the rows are a list of subjects to aren't part of a Course
    //And the rows can be selected
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
    
    //Method to get a defaultTableModel where his rows are a list of Classrooms
    //And the rows can be selected
    default DefaultTableModel obtenerModeloTablaAulasSeleccion(String titulos[], List<Aula> listAulas) {
        DefaultTableModel modeloTabla = modeloTablaSeleccion();
        modeloTabla.setColumnIdentifiers(titulos);
        for (Aula aula : listAulas) {
            Object object[] = {false, aula.getId(), aula.getNombre(), aula.getNumeroAsientosTotales(), aula.getNumeroAsientosDisponibles()};
            modeloTabla.addRow(object);
        }
        return modeloTabla;
    }
    
    //Method to get a defaultTableModel where his rows are a list of Classrooms
    default DefaultTableModel obtenerModeloTablaAulas(String titulos[], List<Aula> listAulas) {
        DefaultTableModel modeloTabla = modeloTablaBasico();
        modeloTabla.setColumnIdentifiers(titulos);
        for (Aula aula : listAulas) {
            Object object[] = {aula.getId(), aula.getNombre(), aula.getNumeroAsientosTotales(), aula.getNumeroAsientosDisponibles()};
            modeloTabla.addRow(object);
        }
        return modeloTabla;
    }
    
    //Method to get a defaultTableModel where his rows are a list of Classroom with a column to show
    //The total of students registered in that clasroomn
    default DefaultTableModel obtenerModeloTablaAulasConEstudiante(String titulos[], List<Aula> listAulas) {
        DefaultTableModel modeloTabla = modeloTablaBasico();
        modeloTabla.setColumnIdentifiers(titulos);
        for (Aula aula : listAulas) {
            Object object[] = {aula.getId(), aula.getNombre(), aula.getListEstudiantes().size(), aula.getNumeroAsientosDisponibles()};
            modeloTabla.addRow(object);
        }
        return modeloTabla;
    }
    
    //Method to get a defaultTableModel where his rows are a list of Courses
    default DefaultTableModel obtenerModeloTablaCursos(String titulos[], List<Curso> listCursos) {
        DefaultTableModel modeloTabla = modeloTablaBasico();
        modeloTabla.setColumnIdentifiers(titulos);
        for (Curso curso : listCursos) {
            Object object[] = {curso.getId(), curso.getNombre()};
            modeloTabla.addRow(object);
        }
        return modeloTabla;
    }
    
    //Method to get a defaultTableModel where his rows are a list of Courses more detailed 
    default DefaultTableModel obtenerModeloTablaCursosDetallado(String titulos[], List<Curso> listCursos) {
        DefaultTableModel modeloTabla = modeloTablaBasico();
        modeloTabla.setColumnIdentifiers(titulos);
        for (Curso curso : listCursos) {
            Object object[] = {curso.getId(), curso.getNombre(),  curso.getListMaterias().size(), curso.getListAulas().size()};
            modeloTabla.addRow(object);
        }
        return modeloTabla;
    }

    
    //Method to get a defaultTableModel where his rows are a list of students
    default DefaultTableModel obtenerModeloTablaEstudiantes(String titulos[], List<Estudiante> listEstudiantes) {
        DefaultTableModel modeloTabla = modeloTablaBasico();
        modeloTabla.setColumnIdentifiers(titulos);
        for (Estudiante estudiante : listEstudiantes) {
            Object object[] = {0 + estudiante.getId(), estudiante.getNombre(), estudiante.getEdad(), estudiante.getMatricula().getEstado()};
            modeloTabla.addRow(object);
        }
        return modeloTabla;
    }

    
    //Method to get a defaultTableModel where his rows are a list of students with details of he
    default DefaultTableModel obtenerModeloTablaEstudiantesDetallado(String titulos[], List<Estudiante> listEstudiantes) {
        DefaultTableModel modeloTabla = modeloTablaBasico();
        modeloTabla.setColumnIdentifiers(titulos);
        String mensaje = "";
            for (Estudiante estudiante : listEstudiantes) {
                if (controladora.getEstudianteI().leerEntidad(estudiante.getId()).getListPago_colegiaturas().isEmpty()) {
                    mensaje = "(Sin pagos)";
                } else {
                    mensaje = "(Con pagos)";
                }
                Object object[] = {0 + estudiante.getId(), estudiante.getNombre(), estudiante.getEdad(), estudiante.getMatricula().getEstado() + mensaje};
                modeloTabla.addRow(object);
            }
        return modeloTabla;
    }
    
    //Method to get a defaultTableModel where his rows are a list of payments
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
