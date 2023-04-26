package MVC_View;

import Class.Background_image;
import MVC_Controller.Controller_Turma;
import MVC_Controller.Controller_Aluno;
import MVC_Model.Aluno;
import MVC_Model.Turma;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import java.awt.Color;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class Turmas extends javax.swing.JFrame
{
    Controller_Turma controller_turmas = new Controller_Turma();
    List<Turma> turmas=controller_turmas.carrega_turmas();
    
    public Turmas()
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
    
    public void seleciona_aluno(java.awt.event.MouseEvent evt)
    {
        JTable source = (JTable) evt.getSource();
        int linha = source.rowAtPoint(evt.getPoint());
        if (evt.getClickCount() == 1)
        {
            int matricula = (int) tabela_alunos.getValueAt(linha, 0);
            String nome = (String) tabela_alunos.getValueAt(linha, 1);
            Date nascimento = new Date((Long) tabela_alunos.getValueAt(linha, 2));
            String mae_nome = (String) tabela_alunos.getValueAt(linha, 3);
            String pai_nome = (String) tabela_alunos.getValueAt(linha, 4);
            String cpf_mae = (String) tabela_alunos.getValueAt(linha, 5);
            String rg_mae = (String) tabela_alunos.getValueAt(linha, 6);
            String cpf_pai = (String) tabela_alunos.getValueAt(linha, 7);
            String rg_pai = (String) tabela_alunos.getValueAt(linha, 8);
            String cep = (String) tabela_alunos.getValueAt(linha, 9);
            String rua = (String) tabela_alunos.getValueAt(linha, 10);
            String bairro = (String) tabela_alunos.getValueAt(linha, 11);
            String cidade = (String) tabela_alunos.getValueAt(linha, 12);
            String telefone1 = (String) tabela_alunos.getValueAt(linha, 13);
            String telefone2 = (String) tabela_alunos.getValueAt(linha, 14);
            String tel1_pai = (String) tabela_alunos.getValueAt(linha, 15);
            String tel2_pai = (String) tabela_alunos.getValueAt(linha, 16);
            String tel1_mae = (String) tabela_alunos.getValueAt(linha, 17);
            String tel2_mae = (String) tabela_alunos.getValueAt(linha, 18);
            String tel_emergencia = (String) tabela_alunos.getValueAt(linha, 19);
            int id_turma = (int) tabela_alunos.getValueAt(linha, 20);

            Aluno aluno = new Controller_Aluno().recupera_aluno(matricula, id_turma, nome, nascimento, telefone1, telefone2, tel_emergencia, cep, rua, bairro, cidade, mae_nome, tel1_mae, tel2_mae, cpf_mae, rg_mae, pai_nome, tel1_pai, tel2_pai, cpf_pai, rg_pai);
            new Matricula_Aluno(aluno).setVisible(true);
            this.dispose();
        }
    }
    
    public void busca_aluno()
    {
        int id_turma = turmas.get(lista_turmas.getSelectedIndex()).getId_turma();
        ResultSet busca = controller_turmas.busca_aluno(id_turma, txt_buscar.getText() + "%");
        settabela(busca);
    }
    
    public void settabela(ResultSet tabela)
    {
        int i;

        if(tabela==null)
        {
            int id_turma = turmas.get(lista_turmas.getSelectedIndex()).getId_turma();
            tabela=controller_turmas.carrega_alunos(id_turma);
        }

        tabela_alunos.setModel(DbUtils.resultSetToTableModel(tabela));
        
        tabela_alunos.getColumnModel().getColumn(0).setHeaderValue("Matrícula");
        tabela_alunos.getColumnModel().getColumn(1).setHeaderValue("Aluno");
        
        for(i=2;i<tabela_alunos.getColumnCount();i++)
        {
            tabela_alunos.getColumnModel().getColumn(i).setMinWidth(0);
            tabela_alunos.getColumnModel().getColumn(i).setMaxWidth(0);
        }
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        topo_turmas = new javax.swing.JLabel();
        lbl_divisoria = new javax.swing.JLabel();
        lbl_turma = new javax.swing.JLabel();
        lista_turmas = new javax.swing.JComboBox();
        bt_novaturma = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_alunos = new javax.swing.JTable();
        lbl_buscar = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        bt_novaturma1 = new javax.swing.JButton();
        btn_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(146, 225, 244));

        topo_turmas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topo_turmas.setText("TURMAS");
        topo_turmas.setFont(new java.awt.Font("Estrangelo Edessa", 0, 36)); // NOI18N
        topo_turmas.setForeground(new java.awt.Color(228, 0, 121));

        lbl_divisoria.setBackground(new java.awt.Color(0, 0, 0));
        lbl_divisoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));

        lbl_turma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_turma.setText("Turma:");
        lbl_turma.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl_turma.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_turma.setForeground(new java.awt.Color(228, 0, 121));

        lista_turmas.setModel(new DefaultComboBoxModel<Turma>(turmas.toArray(new Turma[0])));
        lista_turmas.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                lista_turmasItemStateChanged(evt);
            }
        });

        bt_novaturma.setBackground(new java.awt.Color(255, 255, 255));
        bt_novaturma.setFont(new java.awt.Font("Estrangelo Edessa", 0, 17)); // NOI18N
        bt_novaturma.setForeground(new java.awt.Color(228, 0, 121));
        bt_novaturma.setText("Nova Turma");
        bt_novaturma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));
        bt_novaturma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_novaturma.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                bt_novaturmaActionPerformed(evt);
            }
        });

        tabela_alunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        tabela_alunos.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                tabela_alunosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_alunos);

        lbl_buscar.setText("Buscar aluno:");
        lbl_buscar.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_buscar.setForeground(new java.awt.Color(228, 0, 121));

        txt_buscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));
        txt_buscar.setPreferredSize(new java.awt.Dimension(126, 27));
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txt_buscarKeyReleased(evt);
            }
        });

        bt_novaturma1.setBackground(new java.awt.Color(255, 255, 255));
        bt_novaturma1.setFont(new java.awt.Font("Estrangelo Edessa", 0, 17)); // NOI18N
        bt_novaturma1.setForeground(new java.awt.Color(228, 0, 121));
        bt_novaturma1.setText("Exibir/Detalhar informações da Turma");
        bt_novaturma1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));
        bt_novaturma1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_novaturma1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                bt_novaturma1ActionPerformed(evt);
            }
        });

        btn_voltar.setBackground(new java.awt.Color(255, 255, 255));
        btn_voltar.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        btn_voltar.setForeground(new java.awt.Color(228, 0, 121));
        btn_voltar.setText("Voltar");
        btn_voltar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));
        btn_voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_voltar.setFocusPainted(false);
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
                        .addComponent(lbl_turma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lista_turmas, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_novaturma, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(bt_novaturma1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_buscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addComponent(topo_turmas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_divisoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btn_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(topo_turmas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_divisoria)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lista_turmas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_turma)))
                    .addComponent(bt_novaturma, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_buscar))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_novaturma1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_novaturmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novaturmaActionPerformed
        this.dispose();
        new Cadastro_Turma(null).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_bt_novaturmaActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        this.dispose();
        new Home().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void lista_turmasItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_lista_turmasItemStateChanged
    {//GEN-HEADEREND:event_lista_turmasItemStateChanged
       settabela(null);
    }//GEN-LAST:event_lista_turmasItemStateChanged

    private void tabela_alunosMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_tabela_alunosMouseClicked
    {//GEN-HEADEREND:event_tabela_alunosMouseClicked
         seleciona_aluno(evt);
    }//GEN-LAST:event_tabela_alunosMouseClicked

    private void bt_novaturma1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_novaturma1ActionPerformed
    {//GEN-HEADEREND:event_bt_novaturma1ActionPerformed
        Turma turma=(Turma) lista_turmas.getSelectedItem();
        this.dispose();
        new Cadastro_Turma(turma).setVisible(true);
    }//GEN-LAST:event_bt_novaturma1ActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txt_buscarKeyReleased
    {//GEN-HEADEREND:event_txt_buscarKeyReleased
       busca_aluno();
    }//GEN-LAST:event_txt_buscarKeyReleased

    public void backgroundcolor()
    {   this.getContentPane().setBackground(Color.decode("#d4eeff"));   }
    
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {   new Turmas().setVisible(true);  }
        }
                                       );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_novaturma;
    private javax.swing.JButton bt_novaturma1;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_buscar;
    private javax.swing.JLabel lbl_divisoria;
    private javax.swing.JLabel lbl_turma;
    private javax.swing.JComboBox lista_turmas;
    private javax.swing.JTable tabela_alunos;
    private javax.swing.JLabel topo_turmas;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
