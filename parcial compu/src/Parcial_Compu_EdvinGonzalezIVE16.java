
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author agonz
 */
public class Parcial_Compu_EdvinGonzalezIVE16 extends javax.swing.JFrame {
     // Variables globales
    private String AlinDer(String formato, double valor) {
    java.text.DecimalFormat df = new java.text.DecimalFormat(formato);
    String textoFormateado = df.format(valor);
    // Agrega espacios al inicio para simular alineación a la derecha
    return String.format("%15s", textoFormateado);
}
    private double credito;
    private int periodoMax, periodoMin;
    private double interesMin, interesMax;
    private double incremento;
    private double pagoMensual;
    private boolean tablaPagos;

    // Declaración de las tablas
    private javax.swing.JTable jtablaPrestamo;
    private javax.swing.JTable jtablaCabsFilas;

    /** private String AlinDer(String formato, double valor) {
    java.text.DecimalFormat df = new java.text.DecimalFormat(formato);
    String textoFormateado = df.format(valor);
    // Agrega espacios al inicio para simular alineación a la derecha
    return String.format("%15s", textoFormateado);
}
     * Creates new form Parcial_Compu_EdvinGonzalezIVE16
     */
    public Parcial_Compu_EdvinGonzalezIVE16() {
        initComponents();
        this.setTitle("Prestamo bancario");
        this.setSize(750, 500);
        setLocationRelativeTo(null); // centrar la ventana

        int tiposIntrs = 18; // número de filas no fijas
        int añosMeses = 4;   // número de columnas no fijas

        // Datos iniciales
        jtfCredito.setText("6000");
        jtfPeriodoMax.setText("1");
        jtfPeriodoMin.setText("1");
        jtfInteresMax.setText("10.00");
        jtfInteresMin.setText("0.00");
        jcbIncremento.setSelectedIndex(2); // incremento

        // Inicializar las tablas
        initTable(tiposIntrs, añosMeses + 1);
    }

    // Método initTable
    private void initTable(final int filasTabla, final int colsTabla) {
        class CModeloTablaPrestamo extends javax.swing.table.AbstractTableModel {
            Object dato[][] = new Object[filasTabla][colsTabla];
            String cabecera[] = new String[colsTabla];
            boolean editColum[] = new boolean[colsTabla];

            CModeloTablaPrestamo() {
                for (int c = 0; c < colsTabla; ++c) {
                    // Texto inicial de las cabeceras de las columnas.
                    cabecera[c] = "Columna " + c;
                    // Hacer editables las columnas 1 a colsTabla-1
                    if (c != 0) editColum[c] = true;
                }
            }

            public int getColumnCount() { return cabecera.length; }
            public int getRowCount() { return dato.length; }
            public String getColumnName(int col) { return cabecera[col]; }

            public Object getValueAt(int fila, int col) {
                return dato[fila][col];
            }

            public void setValueAt(Object obj, int fila, int col) {
                dato[fila][col] = obj;
            }

            public boolean isCellEditable(int indFila, int indColum) {
                return editColum[indColum];
            }
        };

        // Crear un modelo de columnas para la tabla préstamo que ignore la primera columna.
        javax.swing.table.TableColumnModel modeloColums = 
            new javax.swing.table.DefaultTableColumnModel() {
            boolean primeraCol = true;

            public void addColumn(javax.swing.table.TableColumn col) {
                // Ignorar la primera columna.
                if (primeraCol) { primeraCol = false; return; }
                col.setMinWidth(200);
                super.addColumn(col);
            }
        };

        // Crear un modelo de columnas para la tabla que hará de cabecera de las filas
        javax.swing.table.TableColumnModel modeloCabsFilas = 
            new javax.swing.table.DefaultTableColumnModel() {
            boolean primeraCol = true;

            public void addColumn(javax.swing.table.TableColumn col) {
                if (primeraCol) {
                    col.setMaxWidth(92);
                    super.addColumn(col);
                    primeraCol = false;
                }
                // Ignorar el resto de las columnas
            }
        };

        // Crear el modelo de la tabla préstamo
        javax.swing.table.TableModel modeloTabla = new CModeloTablaPrestamo();

        // Crear la tabla préstamo con los modelos pasados como argumentos.
        jtablaPrestamo = new javax.swing.JTable(modeloTabla, modeloColums);

        // Crear la tabla cabecera de las filas.
        jtablaCabsFilas = new javax.swing.JTable(modeloTabla, modeloCabsFilas);

        // Crear las columnas
        jtablaPrestamo.createDefaultColumnsFromModel();
        jtablaCabsFilas.createDefaultColumnsFromModel();

        // Asegurar el sincronismo entre las dos tablas cuando se realicen selecciones
        jtablaPrestamo.setSelectionModel(jtablaCabsFilas.getSelectionModel());

        // Color gris para la cabecera de las filas
        jtablaCabsFilas.setBackground(java.awt.Color.lightGray);
        jtablaCabsFilas.setSelectionBackground(java.awt.Color.lightGray);

        // Permitir barras de desplazamiento para ambas tablas
        jtablaPrestamo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtablaCabsFilas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        // Establecer la fuente Courier New
        jtablaPrestamo.setFont(new java.awt.Font("Courier New", 0, 12));
        jtablaCabsFilas.setFont(new java.awt.Font("Courier New", 0, 12));
        
        jScrollPane2.setViewportView(jtablaPrestamo);

// Crear una vista que será utilizada para colocar la tabla
// cabecera de las filas en el mismo panel de desplazamiento
// que la tabla préstamo.
javax.swing.JViewport jv = new javax.swing.JViewport();
jv.setView(jtablaCabsFilas);
jv.setPreferredSize(jtablaCabsFilas.getMaximumSize());
jScrollPane2.setRowHeader(jv);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jtfCredito = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jtfPeriodoMax = new javax.swing.JTextField();
        jtfPeriodoMin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jtfInteresMax = new javax.swing.JTextField();
        jtfInteresMin = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jcbIncremento = new javax.swing.JComboBox<>();
        jbtCalculoPagos = new javax.swing.JButton();
        jbtCalculoAmort = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jmbarBarraDeMenus = new javax.swing.JMenuBar();
        jmnuOpciones = new javax.swing.JMenu();
        jmItemInstruc = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmItemSalir = new javax.swing.JMenuItem();
        jmnuPrestamoEn = new javax.swing.JMenu();
        jmItemAños = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmItemMeses = new javax.swing.JMenuItem();
        jmnuAyuda = new javax.swing.JMenu();
        jmItemAyuda = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Crédito:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Años del préstamo"));

        jLabel4.setText("Mínimo:");

        jLabel3.setText("Máximo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfPeriodoMax, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPeriodoMin, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPeriodoMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfPeriodoMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Años del préstamo"));

        jLabel9.setText("%mínimo:");

        jLabel10.setText("%máximo:");

        jLabel11.setText("Incremento:");

        jcbIncremento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "0.10", "0.50", "Item 4" }));
        jcbIncremento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbIncrementoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10)
                        .addComponent(jLabel9))
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtfInteresMax, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addComponent(jtfInteresMin))
                    .addComponent(jcbIncremento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfInteresMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtfInteresMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jcbIncremento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jbtCalculoPagos.setText("Pagos");
        jbtCalculoPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCalculoPagosActionPerformed(evt);
            }
        });

        jbtCalculoAmort.setText("Amortización");
        jbtCalculoAmort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCalculoAmortActionPerformed(evt);
            }
        });

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jmnuOpciones.setText("Opciones");

        jmItemInstruc.setText("Instrucciones");
        jmItemInstruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmItemInstrucActionPerformed(evt);
            }
        });
        jmnuOpciones.add(jmItemInstruc);
        jmnuOpciones.add(jSeparator1);

        jmItemSalir.setText("Salir");
        jmnuOpciones.add(jmItemSalir);

        jmbarBarraDeMenus.add(jmnuOpciones);

        jmnuPrestamoEn.setText("Prestamo en...");

        jmItemAños.setText("Años");
        jmItemAños.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmItemMesesAñosActionPerformed(evt);
            }
        });
        jmnuPrestamoEn.add(jmItemAños);
        jmnuPrestamoEn.add(jSeparator2);

        jmItemMeses.setText("Meses");
        jmItemMeses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmItemMesesActionPerformed(evt);
                jmItemMesesAñosActionPerformed(evt);
            }
        });
        jmnuPrestamoEn.add(jmItemMeses);

        jmbarBarraDeMenus.add(jmnuPrestamoEn);

        jmnuAyuda.setText("Ayuda");

        jmItemAyuda.setText("Ayuda");
        jmItemAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmItemAyudaActionPerformed(evt);
            }
        });
        jmnuAyuda.add(jmItemAyuda);

        jmbarBarraDeMenus.add(jmnuAyuda);

        setJMenuBar(jmbarBarraDeMenus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtCalculoPagos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtCalculoAmort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtCalculoPagos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtCalculoAmort))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmItemMesesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItemMesesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmItemMesesActionPerformed

    private void jmItemMesesAñosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItemMesesAñosActionPerformed
        // TODO add your handling code here:
        Object item = evt.getSource();
    String tituloMarco = "";

    if (item == jmItemAños)
    {
        jmItemAños.setEnabled(false);
        jmItemMeses.setEnabled(true);
        tituloMarco = "Años del préstamo";
    }
    else if (item == jmItemMeses)
    {
        jmItemAños.setEnabled(true);
        jmItemMeses.setEnabled(false);
        tituloMarco = "Meses del préstamo";
    }

    jPanel1.setBorder(
        new javax.swing.border.TitledBorder(tituloMarco));
    }//GEN-LAST:event_jmItemMesesAñosActionPerformed

    private void jbtCalculoPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCalculoPagosActionPerformed
        // TODO add your handling code here:
         try
{
    credito = Double.parseDouble(jtfCredito.getText());
    periodoMin = Integer.parseInt(jtfPeriodoMin.getText());
    periodoMax = Integer.parseInt(jtfPeriodoMax.getText());
    interesMin = Double.parseDouble(jtfInteresMin.getText());
    interesMax = Double.parseDouble(jtfInteresMax.getText());
    incremento = Double.parseDouble((String)jcbIncremento.getSelectedItem());

    // Comprobar que los datos son válidos
    if (credito <= 0 || 
        periodoMin <= 0 || periodoMax <= 0 || periodoMax < periodoMin || 
        interesMin < 0 || interesMax < 0 || interesMax < interesMin)
        throw new NumberFormatException();
}
catch (NumberFormatException e)
{
    javax.swing.JOptionPane.showMessageDialog(
            null, "Datos no válidos",
            "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    return;
}

// Calcular el nº de tipos de interés y de períodos
 int tiposIntrs = (int) ((interesMax - interesMin) / incremento) + 1;
 int añosMeses = (periodoMax - periodoMin) + 1;

// Tamaño mínimo de la tabla: los valores iniciales
int filas = tiposIntrs, cols = añosMeses;
if (tiposIntrs < 18) filas = 18;
if (añosMeses < 4) cols = 4;

// Crear la tabla
initTable(filas, cols + 1);

// Almacenar en la columna 0 los tipos de interés
jtablaCabsFilas.setValueAt(AlinDer("##0.00", interesMin) + "%", 0, 0);
for (int fila = 1; fila < tiposIntrs; ++fila)
    jtablaCabsFilas.setValueAt(AlinDer("##0.00", 
            interesMin + incremento * fila) + "%", fila, 0);

// Almacenar en la fila 0 las distintas duraciones del préstamo
javax.swing.table.TableColumn colum = null;
String per = " años";
if (jmItemAños.isEnabled()) per = " meses";
for (int columna = 0; columna < añosMeses; ++columna)
{
    colum = jtablaPrestamo.getColumnModel().getColumn(columna);
    colum.setHeaderValue((periodoMin + columna) + per);
}

// Los períodos ¿en qué vienen dados? ¿En años o en meses?
int P = 0;
if (!jmItemAños.isEnabled())
    P = 12; // son años
else
    P = 1;  // son meses

// Calcular pagos
double interes = 0.0, pagoMensual = 0.0;
int meses;
for (int fila = 0; fila < tiposIntrs; ++fila)
{
    // Obtener el tipo de interés de la fila actual
    String sinteres = jtablaCabsFilas.getValueAt(fila, 0).toString();
    sinteres = sinteres.substring(0, sinteres.indexOf('%'));
    sinteres = sinteres.replace(',', '.');
    interes = Double.parseDouble(sinteres) / 100 / 12;

    // Calcular los pagos para este tipo de interés
    for (int columna = 0; columna < añosMeses; ++columna)
    {
        // Obtener la duración del préstamo
        colum = jtablaPrestamo.getColumnModel().getColumn(columna);
        String smeses = (String) colum.getHeaderValue();
        smeses = smeses.substring(0, smeses.indexOf(' '));
        meses = Integer.parseInt(smeses) * P;

        // Calcular la cantidad a pagar mensualmente
        if (interes == 0.0)
            pagoMensual = credito / meses;
        else
            pagoMensual = credito * (interes / (1 - (1 /
                    (Math.pow(1.0 + interes, (double)meses)))));

        // Ponerla en la tabla (se redondea a dos decimales)
        jtablaPrestamo.setValueAt(AlinDer("###,###,##0.00",
                pagoMensual), fila, columna);
    }
}

tablaPagos = true;
    }//GEN-LAST:event_jbtCalculoPagosActionPerformed

    private void jbtCalculoAmortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCalculoAmortActionPerformed
        // TODO add your handling code here:
          int fila = jtablaPrestamo.getSelectedRow();
    int columna = jtablaPrestamo.getSelectedColumn();

    // 1. Validar selección de celda
    if (fila == -1 || columna == -1) {
        javax.swing.JOptionPane.showMessageDialog(
            this, 
            "Por favor, selecciona una celda con un valor en la tabla antes de continuar.", 
            "Atención", 
            javax.swing.JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    try {
        // Obtener el porcentaje de interés
        Object valInteres = jtablaCabsFilas.getValueAt(fila, 0);
        if (valInteres == null) return;
        
        String sinteres = valInteres.toString();
        if (sinteres.contains("%")) {
            sinteres = sinteres.substring(0, sinteres.indexOf('%'));
        }
        sinteres = sinteres.replace(',', '.').trim();
        double interes = Double.parseDouble(sinteres) / 100 / 12;

        // Obtener el período correspondiente
        int P = (!jmItemAños.isEnabled()) ? 12 : 1;
        
        javax.swing.table.TableColumn colum = jtablaPrestamo.getColumnModel().getColumn(columna);
        String smeses = colum.getHeaderValue().toString();
        if (smeses.contains(" ")) {
            smeses = smeses.substring(0, smeses.indexOf(' '));
        }
        
        int meses = Integer.parseInt(smeses.trim()) * P;
        int filas = (meses < 18) ? 18 : meses;

        // Redimensionar tabla
        initTable(filas, 5);

        // Mostrar meses en la cabecera lateral
        for (int mes = 0; mes < meses; ++mes) {
            jtablaCabsFilas.setValueAt(AlinDer("#####", mes + 1), mes, 0);
        }

        // Establecer nombres de cabecera
        String cab[] = {"Capital", "Intereses", "Capital pendiente", "Total intereses"};
        for (int c = 0; c < 4; ++c) {
            colum = jtablaPrestamo.getColumnModel().getColumn(c);
            colum.setHeaderValue(cab[c]);
        }

        // Realizar los cálculos de amortización
        double interesesMensuales = 0, creditoPendiente = credito;
        double capitalMensualAmort = 0, totalIntereses = 0;
        String formato = "###,###,#0.00";

        for (int mes = 0; mes < meses; ++mes) {
            interesesMensuales = creditoPendiente * interes;
            capitalMensualAmort = pagoMensual - interesesMensuales;
            creditoPendiente -= capitalMensualAmort;
            totalIntereses += interesesMensuales;

            jtablaPrestamo.setValueAt(AlinDer(formato, capitalMensualAmort), mes, 0);
            jtablaPrestamo.setValueAt(AlinDer(formato, interesesMensuales), mes, 1);
            jtablaPrestamo.setValueAt(AlinDer(formato, creditoPendiente), mes, 2);
            jtablaPrestamo.setValueAt(AlinDer(formato, totalIntereses), mes, 3);
        }

        jbtCalculoAmort.setEnabled(false);
        tablaPagos = false;

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(
            this, 
            "Error al calcular la amortización: " + e.getMessage(), 
            "Error", 
            javax.swing.JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_jbtCalculoAmortActionPerformed

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
         Object datoCelda = jtablaPrestamo.getValueAt(
        jtablaPrestamo.getSelectedRow(),
        jtablaPrestamo.getSelectedColumn()
    );

    if (datoCelda != null && tablaPagos) {
        // Pasar el número a formato de US necesario para parseDouble
        StringBuffer s = new StringBuffer(datoCelda.toString());
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '.') s.delete(i, i + 1);
            if (s.charAt(i) == ',') s.setCharAt(i, '.');
        }

        // Convertir a double
        pagoMensual = Double.parseDouble(s.toString());
        jbtCalculoAmort.setEnabled(true);
    }
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void jmItemInstrucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItemInstrucActionPerformed
        // TODO add your handling code here:
        String mensaje;
    mensaje = "Introduzca el crédito, la duración del préstamo y el tipo\n";
    mensaje += "de interés. Pulse el botón [Pagos] para visualizar\n";
    mensaje += "los pagos mensuales en la rejilla.\n\n";
    mensaje += "Elija un pago mensual y pulse el botón [Amortización]\n";
    mensaje += "para visualizar el plan de amortización para el interés\n";
    mensaje += "y periodos correspondientes al pago elegido.\n\n";
    mensaje += "Para copiar datos en el portapapeles, seleccione las celdas\n";
    mensaje += "que desee y pulse las teclas Ctrl+c.\n";

    javax.swing.JOptionPane.showMessageDialog(
        null, mensaje, "Instrucciones",
        javax.swing.JOptionPane.INFORMATION_MESSAGE
    );
    }//GEN-LAST:event_jmItemInstrucActionPerformed

    private void jcbIncrementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbIncrementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbIncrementoActionPerformed

    private void jmItemAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItemAyudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmItemAyudaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Parcial_Compu_EdvinGonzalezIVE16.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Parcial_Compu_EdvinGonzalezIVE16.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Parcial_Compu_EdvinGonzalezIVE16.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Parcial_Compu_EdvinGonzalezIVE16.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Parcial_Compu_EdvinGonzalezIVE16().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jbtCalculoAmort;
    private javax.swing.JButton jbtCalculoPagos;
    private javax.swing.JComboBox<String> jcbIncremento;
    private javax.swing.JMenuItem jmItemAyuda;
    private javax.swing.JMenuItem jmItemAños;
    private javax.swing.JMenuItem jmItemInstruc;
    private javax.swing.JMenuItem jmItemMeses;
    private javax.swing.JMenuItem jmItemSalir;
    private javax.swing.JMenuBar jmbarBarraDeMenus;
    private javax.swing.JMenu jmnuAyuda;
    private javax.swing.JMenu jmnuOpciones;
    private javax.swing.JMenu jmnuPrestamoEn;
    private javax.swing.JTextField jtfCredito;
    private javax.swing.JTextField jtfInteresMax;
    private javax.swing.JTextField jtfInteresMin;
    private javax.swing.JTextField jtfPeriodoMax;
    private javax.swing.JTextField jtfPeriodoMin;
    // End of variables declaration//GEN-END:variables
}
