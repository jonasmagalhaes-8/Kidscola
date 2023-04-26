package MVC_View;

import Class.Background_image;
import MVC_Controller.Controller_Professor;
import MVC_Model.Professor;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import java.awt.Color;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class Professores extends javax.swing.JFrame
{
    List<String> materias_professor;
    
    public Professores()
    {
        try
        { UIManager.setLookAndFeel( new MintLookAndFeel()); }
        catch( Exception ex )
         { JOptionPane.showMessageDialog(null,"Não foi possível inicializar a Interface Gráfica Tatto" ); }
        
        initComponents();
        settabela(null);
        
        Background_image fundo = new Background_image
        ( new ImageIcon("src/Imagens/background_turmas.jpg").getImage() );
        this.getContentPane().add(fundo);
        backgroundcolor();
    }
    
    public void seleciona_professor(java.awt.event.MouseEvent evt)
    {
        JTable source = (JTable) evt.getSource();
        int linha = source.rowAtPoint(evt.getPoint());
        if (evt.getClickCount() == 1)
        {
            int matricula = (int) tabela_professores.getValueAt(linha, 0);
            String nome = (String) tabela_professores.getValueAt(linha, 1);
            Date nascimento = new Date((Long) tabela_professores.getValueAt(linha, 2));
            String telefone1 = (String) tabela_professores.getValueAt(linha, 3);
            String telefone2 = (String) tabela_professores.getValueAt(linha, 4);
            String email = (String) tabela_professores.getValueAt(linha, 5);
            String cpf = (String) tabela_professores.getValueAt(linha, 6);
            String rg = (String) tabela_professores.getValueAt(linha, 7);
            String cep = (String) tabela_professores.getValueAt(linha, 8);
            String rua = (String) tabela_professores.getValueAt(linha, 9);
            String bairro = (String) tabela_professores.getValueAt(linha, 10);
            String cidade = (String) tabela_professores.getValueAt(linha, 11);
            materias_professor=new Controller_Professor().carrega_materias_professor(matricula);
            
            Professor professor = new Controller_Professor().recupera_professor(matricula, nome, nascimento, telefone1, telefone2, email,cpf, rg, cep, rua,bairro,cidade,materias_professor);
            new Matricula_Professor(professor).setVisible(true);
            this.dispose();
        }
    }
    
    private void busca_professor()
    {
        ResultSet busca = new Controller_Professor().busca_professor(txt_buscar.getText() + "%");
        settabela(busca);
    }
    
    private void settabela(ResultSet tabela)
    {
        int i;
        
        if(tabela==null)
        tabela=new Controller_Professor().tabela_carrega_professores();
        
        tabela_professores.setModel(DbUtils.resultSetToTableModel(tabela));

        tabela_professores.getColumnModel().getColumn(0).setHeaderValue("Matrícula");
        tabela_professores.getColumnModel().getColumn(1).setHeaderValue("Professor");
        
        for(i=2;i<tabela_professores.getColumnCount();i++)
        {
            tabela_professores.getColumnModel().getColumn(i).setMinWidth(0);
            tabela_professores.getColumnModel().getColumn(i).setMaxWidth(0);
        }
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        topo_turmas = new javax.swing.JLabel();
        lbl_divisoria = new javax.swing.JLabel();
        bt_novaturma = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_professores = new javax.swing.JTable();
        lbl_buscar = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        btn_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(146, 225, 244));

        topo_turmas.setFont(new java.awt.Font("Estrangelo Edessa", 0, 36)); // NOI18N
        topo_turmas.setForeground(new java.awt.Color(228, 0, 121));
        topo_turmas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topo_turmas.setText("PROFESSORES");

        lbl_divisoria.setBackground(new java.awt.Color(0, 0, 0));
        lbl_divisoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));

        bt_novaturma.setText("Cadastrar Novo Professor");
        bt_novaturma.setBackground(new java.awt.Color(255, 255, 255));
        bt_novaturma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));
        bt_novaturma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_novaturma.setFont(new java.awt.Font("Estrangelo Edessa", 0, 17)); // NOI18N
        bt_novaturma.setForeground(new java.awt.Color(228, 0, 121));
        bt_novaturma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_novaturma.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                bt_novaturmaActionPerformed(evt);
            }
        });

        tabela_professores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        tabela_professores.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                tabela_professoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_professores);

        lbl_buscar.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_buscar.setForeground(new java.awt.Color(228, 0, 121));
        lbl_buscar.setText("Buscar Professor:");

        txt_buscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));
        txt_buscar.setPreferredSize(new java.awt.Dimension(126, 27));
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txt_buscarKeyReleased(evt);
            }
        });

        btn_voltar.setText("Voltar");
        btn_voltar.setBackground(new java.awt.Color(255, 255, 255));
        btn_voltar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));
        btn_voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_voltar.setFocusPainted(false);
        btn_voltar.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        btn_voltar.setForeground(new java.awt.Color(228, 0, 121));
        btn_voltar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btn_voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_buscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addComponent(topo_turmas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_divisoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_novaturma, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btn_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(topo_turmas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_divisoria)
                .addGap(14, 14, 14)
                .addComponent(bt_novaturma, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_novaturmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novaturmaActionPerformed
        this.dispose();
        new Matricula_Professor(null).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_bt_novaturmaActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        this.dispose();
        new Home().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void tabela_professoresMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_tabela_professoresMouseClicked
    {//GEN-HEADEREND:event_tabela_professoresMouseClicked
         seleciona_professor(evt);
    }//GEN-LAST:event_tabela_professoresMouseClicked

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txt_buscarKeyReleased
    {//GEN-HEADEREND:event_txt_buscarKeyReleased
        busca_professor();
    }//GEN-LAST:event_txt_buscarKeyReleased

    public void backgroundcolor()
    {   this.getContentPane().setBackground(Color.decode("#d4eeff"));   }
    
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {   new Professores().setVisible(true);  }
        }
                                       );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_novaturma;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_buscar;
    private javax.swing.JLabel lbl_divisoria;
    private javax.swing.JTable tabela_professores;
    private javax.swing.JLabel topo_turmas;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
