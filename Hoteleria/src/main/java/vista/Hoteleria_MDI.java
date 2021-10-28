/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.formdev.flatlaf.FlatLightLaf;
import dominio.ProcesosRepetidos;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;
import seguridad.vista.GenerarPermisos;
import seguridad.vista.Login_LD;

/**
 *
 * @author Herbert Leonel Dominguez Chavez
 */
public class Hoteleria_MDI extends javax.swing.JFrame {

    private Mnt_Servicios form_Mant_Servicios;
    private Mnt_MetodoDePago form_Mnt_MetodoDePago;
    private Mnt_Pisos form_Mant_Pisos;
    private Mnt_Horarios form_Mant_Horarios;
    private Mnt_Habitaciones form_Mant_Habitaciones;
    private Mnt_Huespedes form_Mant_Huespedes;
    private Mnt_Menu form_Mant_Menu;
    private Mnt_Tarifas form_Mant_Tarifas;
    private Prcs_AsignacionServicios form_Prcs_AsignacionServicios;
    private Prcs_Reservacion form_Prcs_Reservacion;
    private Prcs_AsignacionGobernanta form_Prcs_AsignacionGobernanta;
    private Prcs_AsignacionLimpieza form_Prcs_AsignacionLimpieza;
    private Prcs_ObjetoPerdido form_Objeto_perdido;
    private Prcs_ConsultaLimpieza form_ConsultaLimpieza;
    private Prcs_SupervisionLimpieza form_SupervisionLimpieza;

    ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
    public static JLabel Jl_logo = new JLabel();

    /**
     * Creates new form Hoteleria_MDI
     */
    public Hoteleria_MDI() {
        initComponents();

        this.setTitle("Usuario: " + "[" + Login_LD.usuario + "]" + " \t" + "FECHA: [" + prcs_repetidos.getFecha() + "]");
        GenerarPermisos generarPermisos = new GenerarPermisos();
        var usuario = Login_LD.usuario;
        var modulo = "Hotelero";
        generarPermisos.getPermisos(modulo, usuario);

        Diseño();
    }

    public void Diseño() {
        Jdp_contenedor.setBackground(new Color(228, 68, 68));
        prcs_repetidos.Cursor(Mnb_menu);
        ImageIcon icono = new ImageIcon("src/main/java/assets/hotel.png");
        this.setIconImage(icono.getImage());
        logo();
        Jdp_contenedor.add(Jl_logo);
    }

    public void logo() {
        ImageIcon icon = new ImageIcon("src/main/java/assets/logo_hotel.png");
        Jl_logo.setSize(300, 300);
        if (icon != null) {
            Jl_logo.setIcon(icon);
        } else {
            //No existe imagen.
        }
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = Jl_logo.getSize();
        Jl_logo.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jdp_contenedor = new javax.swing.JDesktopPane();
        Mnb_menu = new javax.swing.JMenuBar();
        Sbm_archivos = new javax.swing.JMenu();
        Sbm_catalogo = new javax.swing.JMenu();
        Mnu_mantenimientos = new javax.swing.JMenu();
        MnI_servicios = new javax.swing.JMenuItem();
        MnI_metodoDePago = new javax.swing.JMenuItem();
        MnI_piso = new javax.swing.JMenuItem();
        MnI_horario = new javax.swing.JMenuItem();
        MnI_huespedes = new javax.swing.JMenuItem();
        MnI_habitaciones = new javax.swing.JMenuItem();
        MnI_menu = new javax.swing.JMenuItem();
        MnI_tarifas = new javax.swing.JMenuItem();
        Sbm_procesos = new javax.swing.JMenu();
        MnI_reservacion = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        Sbm_herramientas = new javax.swing.JMenu();
        Sbm_ayuda = new javax.swing.JMenu();
        Btn_cerrarSesion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        javax.swing.GroupLayout Jdp_contenedorLayout = new javax.swing.GroupLayout(Jdp_contenedor);
        Jdp_contenedor.setLayout(Jdp_contenedorLayout);
        Jdp_contenedorLayout.setHorizontalGroup(
            Jdp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        Jdp_contenedorLayout.setVerticalGroup(
            Jdp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 727, Short.MAX_VALUE)
        );

        Sbm_archivos.setText("Archivos");
        Sbm_archivos.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Sbm_archivos);

        Sbm_catalogo.setText("Catalogo");
        Sbm_catalogo.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        Mnu_mantenimientos.setText("Mantenimientos");

        MnI_servicios.setText("Mant. Servicios");
        MnI_servicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_serviciosActionPerformed(evt);
            }
        });
        Mnu_mantenimientos.add(MnI_servicios);

        MnI_metodoDePago.setText("Mant. Metodos de Pago");
        MnI_metodoDePago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_metodoDePagoActionPerformed(evt);
            }
        });
        Mnu_mantenimientos.add(MnI_metodoDePago);

        MnI_piso.setText("Mant. Pisos");
        MnI_piso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_pisoActionPerformed(evt);
            }
        });
        Mnu_mantenimientos.add(MnI_piso);

        MnI_horario.setText("Mant. Horarios");
        MnI_horario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_horarioActionPerformed(evt);
            }
        });
        Mnu_mantenimientos.add(MnI_horario);

        MnI_huespedes.setText("Mant. Huespedes");
        MnI_huespedes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_huespedesActionPerformed(evt);
            }
        });
        Mnu_mantenimientos.add(MnI_huespedes);

        MnI_habitaciones.setText("Mant. Habitaciones");
        MnI_habitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_habitacionesActionPerformed(evt);
            }
        });
        Mnu_mantenimientos.add(MnI_habitaciones);

        MnI_menu.setText("Mant. Menu");
        MnI_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_menuActionPerformed(evt);
            }
        });
        Mnu_mantenimientos.add(MnI_menu);

        MnI_tarifas.setText("Mant. Tarifas");
        MnI_tarifas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_tarifasActionPerformed(evt);
            }
        });
        Mnu_mantenimientos.add(MnI_tarifas);

        Sbm_catalogo.add(Mnu_mantenimientos);

        Mnb_menu.add(Sbm_catalogo);

        Sbm_procesos.setText("Procesos");
        Sbm_procesos.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        Mnu_procesos.setText("Procesos");

        MnI_asingacionServiciosHabitacion.setText("Prcs. Asignación de Servicios a Habitacion");
        MnI_asingacionServiciosHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_asingacionServiciosHabitacionActionPerformed(evt);
            }
        });
        Mnu_procesos.add(MnI_asingacionServiciosHabitacion);

        MnI_reservacion.setText("Prcs. Reservación");
        MnI_reservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_reservacionActionPerformed(evt);
            }
        });
        Mnu_procesos.add(MnI_reservacion);

        jMenuItem1.setText("Prcs. Asignación Gobernanta");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Mnu_procesos.add(jMenuItem1);

        jMenuItem3.setText("Prcs. Asignación Limpieza");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        Mnu_procesos.add(jMenuItem3);

        jMenu1.setText("Consulta y Supervisión de Limpieza");

        jMenuItem4.setText("Prcs. Consulta Limpieza");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Prcs. Supervisión Limpieza");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        Mnu_procesos.add(jMenu1);

        jMenuItem2.setText("Prcs. Objetos Perdidos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Mnu_procesos.add(jMenuItem2);

        Sbm_procesos.add(Mnu_procesos);

        Mnb_menu.add(Sbm_procesos);

        Sbm_herramientas.setText("Herramientas");
        Sbm_herramientas.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Sbm_herramientas);

        Sbm_ayuda.setText("Ayuda");
        Sbm_ayuda.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Sbm_ayuda);

        Btn_cerrarSesion.setText("Cerrar Sesión");
        Btn_cerrarSesion.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Btn_cerrarSesion);

        setJMenuBar(Mnb_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jdp_contenedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jdp_contenedor)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        logo();
    }//GEN-LAST:event_formComponentResized

    private void MnI_serviciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_serviciosActionPerformed
        form_Mant_Servicios = new Mnt_Servicios();

        Jdp_contenedor.add(form_Mant_Servicios);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = form_Mant_Servicios.getSize();
        form_Mant_Servicios.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        form_Mant_Servicios.setVisible(true);
        form_Mant_Servicios.toFront();
    }//GEN-LAST:event_MnI_serviciosActionPerformed

    private void MnI_metodoDePagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_metodoDePagoActionPerformed
        form_Mnt_MetodoDePago = new Mnt_MetodoDePago();

        Jdp_contenedor.add(form_Mnt_MetodoDePago);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = form_Mnt_MetodoDePago.getSize();
        form_Mnt_MetodoDePago.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        form_Mnt_MetodoDePago.setVisible(true);
        form_Mnt_MetodoDePago.toFront();
    }//GEN-LAST:event_MnI_metodoDePagoActionPerformed

    private void MnI_pisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_pisoActionPerformed
        form_Mant_Pisos = new Mnt_Pisos();

        Jdp_contenedor.add(form_Mant_Pisos);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = form_Mant_Pisos.getSize();
        form_Mant_Pisos.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        form_Mant_Pisos.setVisible(true);
        form_Mant_Pisos.toFront();
    }//GEN-LAST:event_MnI_pisoActionPerformed

    private void MnI_horarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_horarioActionPerformed
        form_Mant_Horarios = new Mnt_Horarios();

        Jdp_contenedor.add(form_Mant_Horarios);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = form_Mant_Horarios.getSize();
        form_Mant_Horarios.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        form_Mant_Horarios.setVisible(true);
        form_Mant_Horarios.toFront();
    }//GEN-LAST:event_MnI_horarioActionPerformed

    private void MnI_huespedesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_huespedesActionPerformed
        // TODO add your handling code here:
        form_Mant_Huespedes = new Mnt_Huespedes();

        Jdp_contenedor.add(form_Mant_Huespedes);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = form_Mant_Huespedes.getSize();
        form_Mant_Huespedes.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        form_Mant_Huespedes.setVisible(true);
        form_Mant_Huespedes.toFront();
    }//GEN-LAST:event_MnI_huespedesActionPerformed

    private void MnI_habitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_habitacionesActionPerformed
        // TODO add your handling code here:
        form_Mant_Habitaciones = new Mnt_Habitaciones();

        Jdp_contenedor.add(form_Mant_Habitaciones);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = form_Mant_Habitaciones.getSize();
        form_Mant_Habitaciones.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        form_Mant_Habitaciones.setVisible(true);
        form_Mant_Habitaciones.toFront();
    }//GEN-LAST:event_MnI_habitacionesActionPerformed

    private void MnI_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_menuActionPerformed
        // TODO add your handling code here:
        form_Mant_Menu = new Mnt_Menu();

        Jdp_contenedor.add(form_Mant_Menu);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = form_Mant_Menu.getSize();
        form_Mant_Menu.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        form_Mant_Menu.setVisible(true);
        form_Mant_Menu.toFront();
    }//GEN-LAST:event_MnI_menuActionPerformed

    private void MnI_tarifasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_tarifasActionPerformed
        // TODO add your handling code here:
        form_Mant_Tarifas = new Mnt_Tarifas();

        Jdp_contenedor.add(form_Mant_Tarifas);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = form_Mant_Tarifas.getSize();
        form_Mant_Tarifas.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        form_Mant_Tarifas.setVisible(true);
        form_Mant_Tarifas.toFront();
    }//GEN-LAST:event_MnI_tarifasActionPerformed

    private void MnI_asingacionServiciosHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_asingacionServiciosHabitacionActionPerformed
        // TODO add your handling code here:
        form_Prcs_AsignacionServicios = new Prcs_AsignacionServicios();

        Jdp_contenedor.add(form_Prcs_AsignacionServicios);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = form_Prcs_AsignacionServicios.getSize();
        form_Prcs_AsignacionServicios.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        form_Prcs_AsignacionServicios.setVisible(true);
        form_Prcs_AsignacionServicios.toFront();
    }//GEN-LAST:event_MnI_asingacionServiciosHabitacionActionPerformed

    private void MnI_reservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_reservacionActionPerformed
        form_Prcs_Reservacion = new Prcs_Reservacion();

        Jdp_contenedor.add(form_Prcs_Reservacion);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = form_Prcs_Reservacion.getSize();
        form_Prcs_Reservacion.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        form_Prcs_Reservacion.setVisible(true);
        form_Prcs_Reservacion.toFront();
    }//GEN-LAST:event_MnI_reservacionActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        form_Prcs_AsignacionGobernanta = new Prcs_AsignacionGobernanta();

        Jdp_contenedor.add(form_Prcs_AsignacionGobernanta);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = form_Prcs_AsignacionGobernanta.getSize();
        form_Prcs_AsignacionGobernanta.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        form_Prcs_AsignacionGobernanta.setVisible(true);
        form_Prcs_AsignacionGobernanta.toFront();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        form_Objeto_perdido = new Prcs_ObjetoPerdido();

        Jdp_contenedor.add(form_Objeto_perdido);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = form_Objeto_perdido.getSize();
        form_Objeto_perdido.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        form_Objeto_perdido.setVisible(true);
        form_Objeto_perdido.toFront();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        form_Prcs_AsignacionLimpieza = new Prcs_AsignacionLimpieza();

        Jdp_contenedor.add(form_Prcs_AsignacionLimpieza);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = form_Prcs_AsignacionLimpieza.getSize();
        form_Prcs_AsignacionLimpieza.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        form_Prcs_AsignacionLimpieza.setVisible(true);
        form_Prcs_AsignacionLimpieza.toFront();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        form_ConsultaLimpieza = new Prcs_ConsultaLimpieza();

        Jdp_contenedor.add(form_ConsultaLimpieza);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = form_ConsultaLimpieza.getSize();
        form_ConsultaLimpieza.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        form_ConsultaLimpieza.setVisible(true);
        form_ConsultaLimpieza.toFront();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        form_SupervisionLimpieza = new Prcs_SupervisionLimpieza();

        Jdp_contenedor.add(form_SupervisionLimpieza);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = form_SupervisionLimpieza.getSize();
        form_SupervisionLimpieza.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        form_SupervisionLimpieza.setVisible(true);
        form_SupervisionLimpieza.toFront();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //FLATLAF
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hoteleria_MDI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu Btn_cerrarSesion;
    private javax.swing.JDesktopPane Jdp_contenedor;
    public static final javax.swing.JMenuItem MnI_asingacionServiciosHabitacion = new javax.swing.JMenuItem();
    public static javax.swing.JMenuItem MnI_habitaciones;
    public static javax.swing.JMenuItem MnI_horario;
    public static javax.swing.JMenuItem MnI_huespedes;
    public static javax.swing.JMenuItem MnI_menu;
    public static javax.swing.JMenuItem MnI_metodoDePago;
    public static javax.swing.JMenuItem MnI_piso;
    private javax.swing.JMenuItem MnI_reservacion;
    public static javax.swing.JMenuItem MnI_servicios;
    public static javax.swing.JMenuItem MnI_tarifas;
    public static javax.swing.JMenuBar Mnb_menu;
    public static javax.swing.JMenu Mnu_mantenimientos;
    public static final javax.swing.JMenu Mnu_procesos = new javax.swing.JMenu();
    public static javax.swing.JMenu Sbm_archivos;
    public static javax.swing.JMenu Sbm_ayuda;
    public static javax.swing.JMenu Sbm_catalogo;
    public static javax.swing.JMenu Sbm_herramientas;
    public static javax.swing.JMenu Sbm_procesos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    // End of variables declaration//GEN-END:variables
}
