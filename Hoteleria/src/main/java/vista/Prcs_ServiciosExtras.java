/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import datos.GuardarBitacora;
import datos.ReservacionDAO;
import datos.ServicioDAO;
import datos.ServiciosExtrasDAO;
import dominio.ProcesosRepetidos;
import dominio.Reservacion;
import dominio.Servicio;
import dominio.ServiciosExtras;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import seguridad.vista.GenerarPermisos;
import seguridad.vista.Login_LD;

/**
 *
 * @author leone
 */
public class Prcs_ServiciosExtras extends javax.swing.JInternalFrame {

    ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
    ServiciosExtras sExtras = new ServiciosExtras();

    GuardarBitacora bitacora = new GuardarBitacora();

    void habilitarAcciones() {

        var codigoAplicacion = 2205;
        var usuario = Login_LD.usuario;

        Btn_guardar.setVisible(false);
        Btn_eliminar.setVisible(false);
        Btn_buscar.setVisible(false);

        GenerarPermisos permisos = new GenerarPermisos();

        String[] permisosApp = new String[5];

        for (int i = 0; i < 5; i++) {
            permisosApp[i] = permisos.getAccionesAplicacion(codigoAplicacion, usuario)[i];
        }

        if (permisosApp[0].equals("1")) {
            Btn_guardar.setVisible(true);
        }
        if (permisosApp[1].equals("1")) {
            Btn_buscar.setVisible(true);
        }
        if (permisosApp[3].equals("1")) {
            Btn_eliminar.setVisible(true);
        }
    }

    /**
     * Creates new form Prcs_ServiciosExtras
     */
    public Prcs_ServiciosExtras() {
        initComponents();
        habilitarAcciones();
        diseño();
        tablaServicios("");
    }

    public void diseño() {
        this.setTitle("Proceso asignación de servicios extras");
        Txt_codigo.setBorder(null);
        prcs_repetidos.Cursor(Btn_ayuda, Btn_cancelar, Btn_eliminar, Btn_guardar, Btn_reporte, Btn_buscar, Tbl_Servicios, Tbl_Asignaciones);
    }

    public void tablaServicios(String codigo) {
        ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
        ServicioDAO.codigoAuxiliar = codigo;
        ServicioDAO.nombreAuxiliar = codigo;
        String columnas[] = {"ID", "NOMBRE", "PRECIO"};
        int cantidadcolumnas = columnas.length;
        prcs_repetidos.llenarColumnas(columnas, cantidadcolumnas, Tbl_Servicios);
        String datos[] = new String[cantidadcolumnas];
        int tamaño[] = {50, 250, 250};
        ServicioDAO serviciosdao = new ServicioDAO();
        List<Servicio> servicio = serviciosdao.select();
        for (Servicio listaServicio : servicio) {
            if (listaServicio.getTipo().equals("2")) {
                if (listaServicio.getEstado().equals("1")) {
                    datos[0] = listaServicio.getId();
                    datos[1] = listaServicio.getNombre();
                    datos[2] = listaServicio.getPrecio();
                    prcs_repetidos.llenarFilas(datos, tamaño, Tbl_Servicios);
                }
            }
        }
    }

    public void tablaAsignaciones() {
        ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
        String columnas[] = {"CORRELATIVO", "ID RESERVACIÓN", "ID SERVICIO"};
        int cantidadcolumnas = columnas.length;
        prcs_repetidos.llenarColumnas(columnas, cantidadcolumnas, Tbl_Asignaciones);
        String datos[] = new String[cantidadcolumnas];
        int tamaño[] = {50, 250, 250};
        ServiciosExtrasDAO sExtrasDAO = new ServiciosExtrasDAO();
        List<ServiciosExtras> sExtras = sExtrasDAO.select();
        for (ServiciosExtras listaAsignación : sExtras) {
            if (listaAsignación.getReservación().equals(Txt_codigo.getText())) {
                datos[0] = listaAsignación.getCorrelativo();
                datos[1] = listaAsignación.getReservación();
                datos[2] = listaAsignación.getServicio();
            }
            prcs_repetidos.llenarFilas(datos, tamaño, Tbl_Asignaciones);
        }
    }

    public void Limpiar() {
        DefaultTableModel DT_tablaNueva;
        DT_tablaNueva = new DefaultTableModel();
        DT_tablaNueva.addColumn("CORRELATIVO");      //LE AÑADIMOS COLUMNAS AL OBJETO MODELO
        DT_tablaNueva.addColumn("ID RESERVACIÓN");
        DT_tablaNueva.addColumn("ID SERVICIO");
        Tbl_Asignaciones.setModel(DT_tablaNueva);
        prcs_repetidos.Limpiar(Txt_codigo, Txt_nombreCliente);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_ingresoDatos = new javax.swing.JPanel();
        Lbl_id = new javax.swing.JLabel();
        Txt_codigo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        Btn_fondoGuardar = new javax.swing.JPanel();
        Btn_guardar = new javax.swing.JLabel();
        Btn_fondo_eliminar = new javax.swing.JPanel();
        Btn_eliminar = new javax.swing.JLabel();
        Btn_fondo_reporte = new javax.swing.JPanel();
        Btn_reporte = new javax.swing.JLabel();
        Btn_fondo_ayuda = new javax.swing.JPanel();
        Btn_ayuda = new javax.swing.JLabel();
        Btn_fondo_cancelar = new javax.swing.JPanel();
        Btn_cancelar = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tbl_Asignaciones = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tbl_Servicios = new javax.swing.JTable();
        Btn_fondoBuscar = new javax.swing.JPanel();
        Btn_buscar = new javax.swing.JLabel();
        Txt_nombreCliente = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        Pnl_ingresoDatos.setBackground(new java.awt.Color(36, 47, 65));
        Pnl_ingresoDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INGRESO DE DATOS:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        Lbl_id.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_id.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_id.setText("ID Reservación:");

        Txt_codigo.setBackground(new java.awt.Color(36, 47, 65));
        Txt_codigo.setForeground(new java.awt.Color(255, 255, 255));
        Txt_codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Btn_fondoGuardar.setBackground(new java.awt.Color(97, 212, 195));

        Btn_guardar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_guardar.setText("Insertar");
        Btn_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_guardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_guardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_guardarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoGuardarLayout = new javax.swing.GroupLayout(Btn_fondoGuardar);
        Btn_fondoGuardar.setLayout(Btn_fondoGuardarLayout);
        Btn_fondoGuardarLayout.setHorizontalGroup(
            Btn_fondoGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
            .addGroup(Btn_fondoGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
        );
        Btn_fondoGuardarLayout.setVerticalGroup(
            Btn_fondoGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(Btn_fondoGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        Btn_fondo_eliminar.setBackground(new java.awt.Color(97, 212, 195));

        Btn_eliminar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_eliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_eliminar.setText("Eliminar");
        Btn_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_eliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_eliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_eliminarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_eliminarLayout = new javax.swing.GroupLayout(Btn_fondo_eliminar);
        Btn_fondo_eliminar.setLayout(Btn_fondo_eliminarLayout);
        Btn_fondo_eliminarLayout.setHorizontalGroup(
            Btn_fondo_eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );
        Btn_fondo_eliminarLayout.setVerticalGroup(
            Btn_fondo_eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Btn_fondo_reporte.setBackground(new java.awt.Color(97, 212, 195));

        Btn_reporte.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_reporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_reporte.setText("Reporte");
        Btn_reporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_reporteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_reporteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_reporteMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_reporteLayout = new javax.swing.GroupLayout(Btn_fondo_reporte);
        Btn_fondo_reporte.setLayout(Btn_fondo_reporteLayout);
        Btn_fondo_reporteLayout.setHorizontalGroup(
            Btn_fondo_reporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );
        Btn_fondo_reporteLayout.setVerticalGroup(
            Btn_fondo_reporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Btn_fondo_ayuda.setBackground(new java.awt.Color(253, 255, 182));

        Btn_ayuda.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_ayuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_ayuda.setText("Ayuda");
        Btn_ayuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_ayudaLayout = new javax.swing.GroupLayout(Btn_fondo_ayuda);
        Btn_fondo_ayuda.setLayout(Btn_fondo_ayudaLayout);
        Btn_fondo_ayudaLayout.setHorizontalGroup(
            Btn_fondo_ayudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );
        Btn_fondo_ayudaLayout.setVerticalGroup(
            Btn_fondo_ayudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Btn_fondo_cancelar.setBackground(new java.awt.Color(255, 128, 115));

        Btn_cancelar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_cancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_cancelar.setText("Cancelar");
        Btn_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_cancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_cancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_cancelarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_cancelarLayout = new javax.swing.GroupLayout(Btn_fondo_cancelar);
        Btn_fondo_cancelar.setLayout(Btn_fondo_cancelarLayout);
        Btn_fondo_cancelarLayout.setHorizontalGroup(
            Btn_fondo_cancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );
        Btn_fondo_cancelarLayout.setVerticalGroup(
            Btn_fondo_cancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Tbl_Asignaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CORRELATIVO", "ID TARIFA", "ID SERVICIO"
            }
        ));
        jScrollPane3.setViewportView(Tbl_Asignaciones);

        Tbl_Servicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "SERVICIO", "PRECIO"
            }
        ));
        jScrollPane4.setViewportView(Tbl_Servicios);

        Btn_fondoBuscar.setBackground(new java.awt.Color(97, 212, 195));

        Btn_buscar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_buscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_buscar.setText("Buscar");
        Btn_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_buscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_buscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_buscarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoBuscarLayout = new javax.swing.GroupLayout(Btn_fondoBuscar);
        Btn_fondoBuscar.setLayout(Btn_fondoBuscarLayout);
        Btn_fondoBuscarLayout.setHorizontalGroup(
            Btn_fondoBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
            .addGroup(Btn_fondoBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
        );
        Btn_fondoBuscarLayout.setVerticalGroup(
            Btn_fondoBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(Btn_fondoBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_buscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        Txt_nombreCliente.setBackground(new java.awt.Color(36, 47, 65));
        Txt_nombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        Txt_nombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout Pnl_ingresoDatosLayout = new javax.swing.GroupLayout(Pnl_ingresoDatos);
        Pnl_ingresoDatos.setLayout(Pnl_ingresoDatosLayout);
        Pnl_ingresoDatosLayout.setHorizontalGroup(
            Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addComponent(Lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(Txt_codigo))))
                .addGap(18, 18, 18)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btn_fondoGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_fondo_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_fondo_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_fondo_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_fondo_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addComponent(Btn_fondoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Txt_nombreCliente)))
                .addContainerGap())
        );
        Pnl_ingresoDatosLayout.setVerticalGroup(
            Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lbl_id))
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Pnl_ingresoDatosLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(Txt_nombreCliente))
                        .addComponent(Btn_fondoBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addContainerGap())
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(Btn_fondoGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_fondo_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_fondo_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_fondo_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_fondo_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_ingresoDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_ingresoDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseClicked
        int filaSeleccionada = Tbl_Servicios.getSelectedRow();
        if (filaSeleccionada >= 0) {
            if (prcs_repetidos.isNoneEmpty(Txt_codigo)) {
                if (prcs_repetidos.isNumeric(Txt_codigo.getText())) {
                    ServiciosExtrasDAO sExtrasDAO = new ServiciosExtrasDAO();
                    sExtras.setCorrelativo("0");
                    sExtras.setReservación(Txt_codigo.getText());
                    sExtras.setServicio(Tbl_Servicios.getValueAt(filaSeleccionada, 0).toString());
                    bitacora.GuardarEnBitacora("insertar", "2205");
                    sExtrasDAO.insert(sExtras);
                    tablaAsignaciones();
                }
            }
        }
    }//GEN-LAST:event_Btn_guardarMouseClicked

    private void Btn_guardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseEntered
        Btn_fondoGuardar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_guardarMouseEntered

    private void Btn_guardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseExited
        Btn_fondoGuardar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_guardarMouseExited

    private void Btn_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseClicked
        int filaSeleccionada = Tbl_Asignaciones.getSelectedRow();
        if (filaSeleccionada >= 0) {   //SI EXISTE UNA FILA SELECCIONADA REALIZARA LA ELIMINACIÓN
            if (prcs_repetidos.isNoneEmpty(Txt_codigo)) {
                if (prcs_repetidos.isNumeric(Txt_codigo.getText())) {
                    if (prcs_repetidos.ConfirmarEliminacion("eliminar", "asignación", this)) {
                        ServiciosExtrasDAO sExtrasDAO = new ServiciosExtrasDAO();
                        sExtras.setCorrelativo(Tbl_Asignaciones.getValueAt(filaSeleccionada, 0).toString());
                        sExtrasDAO.delete(sExtras);
                        tablaAsignaciones();
                        bitacora.GuardarEnBitacora("eliminar", "2205");
                        prcs_repetidos.AlertaMensaje("eliminada", "Asignación", "exitosamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar la asignación");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe de seleccionar una fila de la tabla de asignaciones (LADO DERECHO)");
        }
    }//GEN-LAST:event_Btn_eliminarMouseClicked

    private void Btn_eliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseEntered
        Btn_fondo_eliminar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_eliminarMouseEntered

    private void Btn_eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseExited
        Btn_fondo_eliminar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_eliminarMouseExited

    private void Btn_reporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseClicked
        prcs_repetidos.imprimirReporte("Rpt_PrcsServiciosExtras.jrxml", "Reporte de servicios extras");
        bitacora.GuardarEnBitacora("reporte", "2205");
    }//GEN-LAST:event_Btn_reporteMouseClicked

    private void Btn_reporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseEntered
        Btn_fondo_reporte.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_reporteMouseEntered

    private void Btn_reporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseExited
        Btn_fondo_reporte.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_reporteMouseExited

    private void Btn_ayudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseClicked
        prcs_repetidos.imprimirAyuda("AyudaMantenimientoServicios.chm");
        bitacora.GuardarEnBitacora("ayuda", "2205");
    }//GEN-LAST:event_Btn_ayudaMouseClicked

    private void Btn_ayudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseEntered
        Btn_fondo_ayuda.setBackground(new Color(255, 255, 63));
    }//GEN-LAST:event_Btn_ayudaMouseEntered

    private void Btn_ayudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseExited
        Btn_fondo_ayuda.setBackground(new Color(253, 255, 182));
    }//GEN-LAST:event_Btn_ayudaMouseExited

    private void Btn_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseClicked
        Limpiar();
    }//GEN-LAST:event_Btn_cancelarMouseClicked

    private void Btn_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseEntered
        Btn_fondo_cancelar.setBackground(new Color(255, 52, 31));
    }//GEN-LAST:event_Btn_cancelarMouseEntered

    private void Btn_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseExited
        Btn_fondo_cancelar.setBackground(new Color(255, 128, 115));
    }//GEN-LAST:event_Btn_cancelarMouseExited

    private void Btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseClicked
        if (prcs_repetidos.isNoneEmpty(Txt_codigo)) {
            if (prcs_repetidos.isNumeric(Txt_codigo.getText())) {
                ReservacionDAO reservacionDAO = new ReservacionDAO();
                Reservacion reservacion = new Reservacion();
                reservacion.setIdReservacion(Txt_codigo.getText());
                reservacion = reservacionDAO.query(reservacion);

                if (reservacion.getEstadoReservacion() != null) {
                    if (reservacion.getEstadoReservacion().equals("1")) {
                        Txt_nombreCliente.setText(reservacion.getIdCliente());
                        tablaAsignaciones();
                        bitacora.GuardarEnBitacora("buscar", "2205");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Reservación no encontrada o ya culmino su estadia");
                }
            }
        }
    }//GEN-LAST:event_Btn_buscarMouseClicked

    private void Btn_buscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseEntered
        Btn_fondoBuscar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_buscarMouseEntered

    private void Btn_buscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseExited
        Btn_fondoBuscar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_buscarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Btn_ayuda;
    private javax.swing.JLabel Btn_buscar;
    private javax.swing.JLabel Btn_cancelar;
    private javax.swing.JLabel Btn_eliminar;
    private javax.swing.JPanel Btn_fondoBuscar;
    private javax.swing.JPanel Btn_fondoGuardar;
    private javax.swing.JPanel Btn_fondo_ayuda;
    private javax.swing.JPanel Btn_fondo_cancelar;
    private javax.swing.JPanel Btn_fondo_eliminar;
    private javax.swing.JPanel Btn_fondo_reporte;
    private javax.swing.JLabel Btn_guardar;
    private javax.swing.JLabel Btn_reporte;
    private javax.swing.JLabel Lbl_id;
    private javax.swing.JPanel Pnl_ingresoDatos;
    private javax.swing.JTable Tbl_Asignaciones;
    private javax.swing.JTable Tbl_Servicios;
    private javax.swing.JTextField Txt_codigo;
    private javax.swing.JTextField Txt_nombreCliente;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
