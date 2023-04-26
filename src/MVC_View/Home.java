package MVC_View;

import Class.Background_image;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Home extends javax.swing.JFrame
{
    public Home()
    {
        try
        { UIManager.setLookAndFeel( new MintLookAndFeel()); }
        catch( Exception ex )
         { JOptionPane.showMessageDialog(null,"Não foi possível inicializar a Interface Gráfica Tattoo" ); }
        initComponents();
        Background_image fundo = new Background_image
        ( new ImageIcon("src/Imagens/fundo.png").getImage() );
        this.getContentPane().add(fundo);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        icon_turmas = new javax.swing.JButton();
        icon_professor = new javax.swing.JButton();
        bt_matricula = new javax.swing.JButton();
        bt_matricular = new javax.swing.JLabel();
        btn_turmas = new javax.swing.JLabel();
        btn_professores = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        icon_turmas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pngegg 512.png"))); // NOI18N
        icon_turmas.setBorderPainted(false);
        icon_turmas.setContentAreaFilled(false);
        icon_turmas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icon_turmas.setFocusPainted(false);
        icon_turmas.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                icon_turmasActionPerformed(evt);
            }
        });

        icon_professor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/professor.png"))); // NOI18N
        icon_professor.setBorderPainted(false);
        icon_professor.setContentAreaFilled(false);
        icon_professor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icon_professor.setFocusPainted(false);
        icon_professor.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                icon_professorActionPerformed(evt);
            }
        });

        bt_matricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/matricula_aluno_novo.png"))); // NOI18N
        bt_matricula.setBorderPainted(false);
        bt_matricula.setContentAreaFilled(false);
        bt_matricula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_matricula.setFocusPainted(false);
        bt_matricula.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                bt_matriculaActionPerformed(evt);
            }
        });

        bt_matricular.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_matricular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/button_AZUL.png"))); // NOI18N
        bt_matricular.setText("Matrícular Aluno");
        bt_matricular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_matricular.setFont(new java.awt.Font("Estrangelo Edessa", 0, 18)); // NOI18N
        bt_matricular.setForeground(new java.awt.Color(255, 255, 255));
        bt_matricular.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btn_turmas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_turmas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/button_AZUL.png"))); // NOI18N
        btn_turmas.setText("Turmas e Alunos");
        btn_turmas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_turmas.setFont(new java.awt.Font("Estrangelo Edessa", 0, 18)); // NOI18N
        btn_turmas.setForeground(new java.awt.Color(255, 255, 255));
        btn_turmas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_turmas.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                btn_turmasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                btn_turmasMousePressed(evt);
            }
        });

        btn_professores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_professores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/button_AZUL.png"))); // NOI18N
        btn_professores.setText("Professores");
        btn_professores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_professores.setFont(new java.awt.Font("Estrangelo Edessa", 0, 18)); // NOI18N
        btn_professores.setForeground(new java.awt.Color(255, 255, 255));
        btn_professores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_professores.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                btn_professoresMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                btn_professoresMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(icon_turmas)
                .addGap(135, 135, 135)
                .addComponent(icon_professor)
                .addGap(120, 120, 120)
                .addComponent(bt_matricula))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btn_turmas)
                .addGap(167, 167, 167)
                .addComponent(btn_professores)
                .addGap(143, 143, 143)
                .addComponent(bt_matricular))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon_turmas)
                    .addComponent(icon_professor)
                    .addComponent(bt_matricula))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_turmas)
                    .addComponent(btn_professores)
                    .addComponent(bt_matricular))
                .addGap(156, 156, 156))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void icon_turmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icon_turmasActionPerformed
        this.dispose();
        new Turmas().setVisible(true);
    }//GEN-LAST:event_icon_turmasActionPerformed

    private void icon_professorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icon_professorActionPerformed
        this.dispose();
        new Professores().setVisible(true);
        //new Turmas().setVisible(true);
    }//GEN-LAST:event_icon_professorActionPerformed

    private void btn_turmasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_turmasMouseClicked

    }//GEN-LAST:event_btn_turmasMouseClicked

    private void btn_turmasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_turmasMousePressed
        this.dispose();
        new Turmas().setVisible(true);
    }//GEN-LAST:event_btn_turmasMousePressed

    private void btn_professoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_professoresMouseEntered

    }//GEN-LAST:event_btn_professoresMouseEntered

    private void btn_professoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_professoresMousePressed
        this.dispose();
        new Professores().setVisible(true);
    }//GEN-LAST:event_btn_professoresMousePressed

    private void bt_matriculaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bt_matriculaActionPerformed
    {//GEN-HEADEREND:event_bt_matriculaActionPerformed
        this.dispose();
        new Matricula_Aluno(null).setVisible(true);               // TODO add your handling code here:
    }//GEN-LAST:event_bt_matriculaActionPerformed

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_matricula;
    private javax.swing.JLabel bt_matricular;
    private javax.swing.JLabel btn_professores;
    private javax.swing.JLabel btn_turmas;
    private javax.swing.JButton icon_professor;
    private javax.swing.JButton icon_turmas;
    // End of variables declaration//GEN-END:variables
}
