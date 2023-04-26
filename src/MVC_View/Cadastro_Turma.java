package MVC_View;

import Class.Background_image;
import MVC_Controller.Controller_Professor;
import MVC_Controller.Controller_Turma;
import MVC_Model.Professor;
import MVC_Model.Turma;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Cadastro_Turma extends javax.swing.JFrame
{
    Controller_Professor controller = new Controller_Professor();
    List<Professor> professores = controller.carrega_professores();
    Controller_Turma turma_controller = new Controller_Turma();
    Turma turma;
    Professor professor;
    List <String> id_professores_materias;
    
    public Cadastro_Turma(Turma turma)
    {
        try
        { UIManager.setLookAndFeel( new MintLookAndFeel()); }
        catch( Exception ex )
        { JOptionPane.showMessageDialog(null,"Não foi possível inicializar a Interface Gráfica Tatto" ); }
        
        initComponents();
        this.turma=turma;
        preenche_materias_professor();
        
        if(turma!=null)
        visualiza_turma();
        else
        {
            bt_alterar.setVisible(false);
            bt_excluir.setVisible(false);
            lista_professores_materias.setVisible(false);
        }
        
        Background_image fundo = new Background_image
        ( new ImageIcon("src/Imagens/background_matricula.jpg").getImage() );
        this.getContentPane().add(fundo);
        backgroundcolor();
    }

    private Cadastro_Turma()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void deletar()
    {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir essa turma da base de dados?", "EXCLUSÃO DE TURMA", 2);
        
        if(resposta==0)
        {
            if(turma_controller.deletar_turma(turma.getId_turma()))
            {
                JOptionPane.showMessageDialog(null, "Turma excluída com sucesso");
                this.dispose();
                new Turmas().setVisible(true);
            }
            else
            JOptionPane.showMessageDialog(null, "Houve uma falha ao excluir essa Turma");
        }
    }
    
    private void visualiza_turma()
    {
        bt_cadastraTurma.setVisible(false);
        
        id_professores_materias = id_professores_materias = turma_controller.Professores_titulares(turma.getId_turma());
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(id_professores_materias.toArray());
        lista_professores_materias.setModel(defaultComboBox);
        
        txt_nome.setText(turma.getNome_turma());
        
        if(turma.getSerie_turma().equals("1° Ano Fundamental"))
        list_escolaridade.setSelectedIndex(0);
        else if(turma.getSerie_turma().equals("2° Ano Fundamental"))
        list_escolaridade.setSelectedIndex(1);
        else if(turma.getSerie_turma().equals("3° Ano Fundamental"))
        list_escolaridade.setSelectedIndex(2);
        else if(turma.getSerie_turma().equals("4° Ano Fundamental"))
        list_escolaridade.setSelectedIndex(3);
        else
        list_escolaridade.setSelectedIndex(4);   
        
        if(turma.getTurno_turna().equals("Matutino"))
        list_turno.setSelectedIndex(0);
        else
        list_turno.setSelectedIndex(1);    
        
        txt_anoletivo.setText(String.valueOf(turma.getAno_turma()));
    }
    
    private void preenche_materias_professor()
    {
        int i,j;
        
        list_prof_portugues.removeAllItems();
        list_prof_matematica.removeAllItems();
        list_prof_artes.removeAllItems();
        list_prof_educFisica.removeAllItems();
        list_prof_religiao.removeAllItems();
        list_prof_ingles.removeAllItems();
        list_prof_geografia.removeAllItems();
        list_prof_historia.removeAllItems();
        list_prof_ciencia.removeAllItems();
        
        list_prof_portugues.addItem(null);
        list_prof_artes.addItem(null);
        list_prof_educFisica.addItem(null);
        list_prof_religiao.addItem(null);
        list_prof_ingles.addItem(null);   
        list_prof_matematica.addItem(null);
        list_prof_ciencia.addItem(null);
        list_prof_geografia.addItem(null);
        list_prof_historia.addItem(null);
        
        for(i=0;i<professores.size();i++)
        {
            for(j=0;j<professores.get(i).getMaterias().size();j++)
            {
                if(professores.get(i).getMaterias().get(j).equals("Português"))
                list_prof_portugues.addItem(professores.get(i));
                else if(professores.get(i).getMaterias().get(j).equals("Artes"))
                list_prof_artes.addItem(professores.get(i));
                else if(professores.get(i).getMaterias().get(j).equals("Educação Física"))
                list_prof_educFisica.addItem(professores.get(i));
                else if(professores.get(i).getMaterias().get(j).equals("Religião"))
                list_prof_religiao.addItem(professores.get(i));
                else if(professores.get(i).getMaterias().get(j).equals("Inglês"))
                list_prof_ingles.addItem(professores.get(i));
                else if(professores.get(i).getMaterias().get(j).equals("Matemática"))
                list_prof_matematica.addItem(professores.get(i));
                else if(professores.get(i).getMaterias().get(j).equals("Ciência"))
                list_prof_ciencia.addItem(professores.get(i));
                else if(professores.get(i).getMaterias().get(j).equals("Geografia"))
                list_prof_geografia.addItem(professores.get(i));
                else if(professores.get(i).getMaterias().get(j).equals("História"))
                list_prof_historia.addItem(professores.get(i));
            }
        }
        professores.clear();
    }
    
    private void update()
    {
        boolean alterou_disciplina=false;
        
        if(!txt_nome.getText().equals(turma.getNome_turma()))
        {
            if(turma_controller.update_nome(turma, txt_nome.getText()))
            JOptionPane.showMessageDialog(null, "Nome da Turma atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o nome da Turma");
        }
        
        String escolaridade = list_escolaridade.getSelectedItem().toString();
        if(!escolaridade.equals(turma.getSerie_turma()))
        {
            if(turma_controller.update_escolaridade(turma, escolaridade))
            JOptionPane.showMessageDialog(null, "Escolaridade/Série da Turma atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar a Escolaridade/Série da Turma");
        }
        
        String turno = list_turno.getSelectedItem().toString();
        if(!turno.equals(turma.getTurno_turna()))
        {
            if(turma_controller.update_turno(turma, turno))
            JOptionPane.showMessageDialog(null, "Turno da Turma atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o Turno da Turma");
        }
        
        int ano_letivo = Integer.parseInt(txt_anoletivo.getText());
        if(ano_letivo!=turma.getAno_turma())
        {
            if(turma_controller.update_ano_letivo(turma, ano_letivo))
            JOptionPane.showMessageDialog(null, "Ano Letivo da Turma atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o Ano Letivo da Turma");
        }
        
        if(list_prof_portugues.getSelectedIndex()!=0)
        alterou_disciplina=true;
        if(list_prof_educFisica.getSelectedIndex()!=0)
        alterou_disciplina=true;
        if(list_prof_matematica.getSelectedIndex()!=0)
        alterou_disciplina=true;
        if(list_prof_religiao.getSelectedIndex()!=0)
        alterou_disciplina=true;
        if(list_prof_ciencia.getSelectedIndex()!=0)
        alterou_disciplina=true;
        if(list_prof_ingles.getSelectedIndex()!=0)
        alterou_disciplina=true;
        if(list_prof_geografia.getSelectedIndex()!=0)
        alterou_disciplina=true;
        if(list_prof_artes.getSelectedIndex()!=0)
        alterou_disciplina=true;
        if(list_prof_historia.getSelectedIndex()!=0)
        alterou_disciplina=true;
            
        if(alterou_disciplina)
        {
            List<String> materias = new ArrayList<>();
            List<Integer> id_professores = new ArrayList<>();
            
            if(list_prof_portugues.getSelectedItem()!=null)
            {
                 professor=(Professor) list_prof_portugues.getSelectedItem();
                 materias.add("Português");
                 id_professores.add(professor.getId_professor());
            }
            if(list_prof_artes.getSelectedItem() != null)
            {
                professor = (Professor) list_prof_artes.getSelectedItem();
                materias.add("Artes");
                id_professores.add(professor.getId_professor());
            }
            if(list_prof_educFisica.getSelectedItem() != null)
            {
                professor = (Professor) list_prof_educFisica.getSelectedItem();
                materias.add("Educação Física");
                id_professores.add(professor.getId_professor());
            }
            if(list_prof_religiao.getSelectedItem() != null)
            {
                professor = (Professor) list_prof_religiao.getSelectedItem();
                materias.add("Religião");
                id_professores.add(professor.getId_professor());
            }
            if(list_prof_ingles.getSelectedItem() != null)
            {
                professor = (Professor) list_prof_ingles.getSelectedItem();
                materias.add("Inglês");
                id_professores.add(professor.getId_professor());
            }
            if(list_prof_matematica.getSelectedItem() != null)
            {
                professor = (Professor) list_prof_matematica.getSelectedItem();
                materias.add("Matemática");
                id_professores.add(professor.getId_professor());
            }
            if(list_prof_ciencia.getSelectedItem() != null)
            {
                professor = (Professor) list_prof_ciencia.getSelectedItem();
                materias.add("Ciência");
                id_professores.add(professor.getId_professor());
            }
            if(list_prof_geografia.getSelectedItem() != null)
            {
                professor = (Professor) list_prof_geografia.getSelectedItem();
                materias.add("Geografia");
                id_professores.add(professor.getId_professor());
            }
            if(list_prof_historia.getSelectedItem() != null)
            {
                professor = (Professor) list_prof_historia.getSelectedItem();
                materias.add("História");
                id_professores.add(professor.getId_professor());
            }
            
            if(turma_controller.atualiza_disciplinas(turma.getId_turma(), materias, id_professores))
            {
                JOptionPane.showMessageDialog(null, "Professores das Disciplinas selecionadas alteradas com sucesso.");
                this.dispose();
                new Cadastro_Turma(turma).setVisible(true);
            }
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar as disciplinas");
        }
    }
    
    private void cadastra_turma()
    {
        List<String> materias = new ArrayList<>();
        List<Integer> id_professores = new ArrayList<>();
       
        if(list_prof_portugues.getSelectedItem()!=null)
        {
             professor=(Professor) list_prof_portugues.getSelectedItem();
             materias.add("Português");
             id_professores.add(professor.getId_professor());
        }
        if(list_prof_artes.getSelectedItem() != null)
        {
            professor = (Professor) list_prof_artes.getSelectedItem();
            materias.add("Artes");
            id_professores.add(professor.getId_professor());
        }
        if(list_prof_educFisica.getSelectedItem() != null)
        {
            professor = (Professor) list_prof_educFisica.getSelectedItem();
            materias.add("Educação Física");
            id_professores.add(professor.getId_professor());
        }
        if(list_prof_religiao.getSelectedItem() != null)
        {
            professor = (Professor) list_prof_religiao.getSelectedItem();
            materias.add("Religião");
            id_professores.add(professor.getId_professor());
        }
        if(list_prof_ingles.getSelectedItem() != null)
        {
            professor = (Professor) list_prof_ingles.getSelectedItem();
            materias.add("Inglês");
            id_professores.add(professor.getId_professor());
        }
        if(list_prof_matematica.getSelectedItem() != null)
        {
            professor = (Professor) list_prof_matematica.getSelectedItem();
            materias.add("Matemática");
            id_professores.add(professor.getId_professor());
        }
        if(list_prof_ciencia.getSelectedItem() != null)
        {
            professor = (Professor) list_prof_ciencia.getSelectedItem();
            materias.add("Ciência");
            id_professores.add(professor.getId_professor());
        }
        if(list_prof_geografia.getSelectedItem() != null)
        {
            professor = (Professor) list_prof_geografia.getSelectedItem();
            materias.add("Geografia");
            id_professores.add(professor.getId_professor());
        }
        if(list_prof_historia.getSelectedItem() != null)
        {
            professor = (Professor) list_prof_historia.getSelectedItem();
            materias.add("História");
            id_professores.add(professor.getId_professor());
        }
        
        Controller_Turma nova_turma = new Controller_Turma();
        
        boolean Cadastro_turma = nova_turma.Cadastrar_turma(txt_nome.getText(), list_escolaridade.getSelectedItem().toString(), Integer.parseInt(txt_anoletivo.getText()), list_turno.getSelectedItem().toString(), materias, id_professores);
        
        if(Cadastro_turma)
        {
            JOptionPane.showMessageDialog(null, "Cadastro de Turma realizado com sucesso!");
            this.dispose();
            new Cadastro_Turma(null).setVisible(true);
        }
        else
        JOptionPane.showMessageDialog(null, "Houve um erro ao realizar o cadastro");
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        divisor_topo_turmas = new javax.swing.JLabel();
        lbl_divisoria = new javax.swing.JLabel();
        lbl_nome = new javax.swing.JLabel();
        bt_novaturma1 = new javax.swing.JButton();
        bt_cadastraTurma = new javax.swing.JButton();
        lbl_cep = new javax.swing.JLabel();
        txt_anoletivo = new javax.swing.JTextField();
        lbl_cidade = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        lbl_tel1aluno = new javax.swing.JLabel();
        divisor_documentacao = new javax.swing.JLabel();
        lbl_divisoria2 = new javax.swing.JLabel();
        list_escolaridade = new javax.swing.JComboBox();
        list_turno = new javax.swing.JComboBox();
        lbl_tel1aluno1 = new javax.swing.JLabel();
        list_prof_portugues = new javax.swing.JComboBox();
        lbl_tel1aluno2 = new javax.swing.JLabel();
        list_prof_educFisica = new javax.swing.JComboBox();
        lbl_tel1aluno3 = new javax.swing.JLabel();
        list_prof_matematica = new javax.swing.JComboBox();
        lbl_tel1aluno4 = new javax.swing.JLabel();
        list_prof_religiao = new javax.swing.JComboBox();
        lbl_tel1aluno5 = new javax.swing.JLabel();
        list_prof_ciencia = new javax.swing.JComboBox();
        lbl_tel1aluno6 = new javax.swing.JLabel();
        lbl_tel1aluno7 = new javax.swing.JLabel();
        list_prof_geografia = new javax.swing.JComboBox();
        list_prof_artes = new javax.swing.JComboBox();
        lbl_tel1aluno8 = new javax.swing.JLabel();
        list_prof_ingles = new javax.swing.JComboBox();
        lbl_tel1aluno9 = new javax.swing.JLabel();
        list_prof_historia = new javax.swing.JComboBox();
        bt_alterar = new javax.swing.JLabel();
        bt_excluir = new javax.swing.JLabel();
        lista_professores_materias = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(146, 225, 244));

        divisor_topo_turmas.setFont(new java.awt.Font("Estrangelo Edessa", 0, 33)); // NOI18N
        divisor_topo_turmas.setForeground(new java.awt.Color(228, 0, 121));
        divisor_topo_turmas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        divisor_topo_turmas.setText("CADASTRO DE TURMA");

        lbl_divisoria.setBackground(new java.awt.Color(0, 0, 0));
        lbl_divisoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));

        lbl_nome.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_nome.setForeground(new java.awt.Color(228, 0, 121));
        lbl_nome.setText("Nome:");

        bt_novaturma1.setBackground(new java.awt.Color(255, 255, 255));
        bt_novaturma1.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        bt_novaturma1.setForeground(new java.awt.Color(228, 0, 121));
        bt_novaturma1.setText("Voltar");
        bt_novaturma1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));
        bt_novaturma1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_novaturma1.setFocusPainted(false);
        bt_novaturma1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                bt_novaturma1ActionPerformed(evt);
            }
        });

        bt_cadastraTurma.setBackground(new java.awt.Color(255, 255, 255));
        bt_cadastraTurma.setFont(new java.awt.Font("Estrangelo Edessa", 0, 28)); // NOI18N
        bt_cadastraTurma.setForeground(new java.awt.Color(228, 0, 121));
        bt_cadastraTurma.setText("Cadastrar Turma");
        bt_cadastraTurma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));
        bt_cadastraTurma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_cadastraTurma.setFocusPainted(false);
        bt_cadastraTurma.setOpaque(false);
        bt_cadastraTurma.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                bt_cadastraTurmaActionPerformed(evt);
            }
        });

        lbl_cep.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_cep.setForeground(new java.awt.Color(228, 0, 121));
        lbl_cep.setText("Ano Letivo:");

        txt_anoletivo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_anoletivo.setPreferredSize(new java.awt.Dimension(54, 20));

        lbl_cidade.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_cidade.setForeground(new java.awt.Color(228, 0, 121));
        lbl_cidade.setText("Escolaridade:");

        txt_nome.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_nomeActionPerformed(evt);
            }
        });

        lbl_tel1aluno.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_tel1aluno.setForeground(new java.awt.Color(228, 0, 121));
        lbl_tel1aluno.setText("Turno:");

        divisor_documentacao.setFont(new java.awt.Font("Estrangelo Edessa", 0, 33)); // NOI18N
        divisor_documentacao.setForeground(new java.awt.Color(228, 0, 121));
        divisor_documentacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        divisor_documentacao.setText("DISCIPLINAS E PROFESSORES");

        lbl_divisoria2.setBackground(new java.awt.Color(0, 0, 0));
        lbl_divisoria2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));

        list_escolaridade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1° Ano Fundamental", "2° Ano Fundamental", "3° Ano Fundamental", "4° Ano Fundamental", "5° Ano Fundamental" }));
        list_escolaridade.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                list_escolaridadeActionPerformed(evt);
            }
        });

        list_turno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Matutino", "Vespertino" }));
        list_turno.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                list_turnoActionPerformed(evt);
            }
        });

        lbl_tel1aluno1.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_tel1aluno1.setForeground(new java.awt.Color(228, 0, 121));
        lbl_tel1aluno1.setText(" Português:");

        list_prof_portugues.setModel(new DefaultComboBoxModel<Professor>(professores.toArray(new Professor[0])));
        list_prof_portugues.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                list_prof_portuguesActionPerformed(evt);
            }
        });

        lbl_tel1aluno2.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_tel1aluno2.setForeground(new java.awt.Color(228, 0, 121));
        lbl_tel1aluno2.setText("Educação Física:");

        list_prof_educFisica.setModel(new DefaultComboBoxModel<Professor>(professores.toArray(new Professor[0])));
        list_prof_educFisica.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                list_prof_educFisicaActionPerformed(evt);
            }
        });

        lbl_tel1aluno3.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_tel1aluno3.setForeground(new java.awt.Color(228, 0, 121));
        lbl_tel1aluno3.setText(" Matemática:");

        list_prof_matematica.setModel(new DefaultComboBoxModel<Professor>(professores.toArray(new Professor[0])));
        list_prof_matematica.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                list_prof_matematicaActionPerformed(evt);
            }
        });

        lbl_tel1aluno4.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_tel1aluno4.setForeground(new java.awt.Color(228, 0, 121));
        lbl_tel1aluno4.setText("Religião:");

        list_prof_religiao.setModel(new DefaultComboBoxModel<Professor>(professores.toArray(new Professor[0])));
        list_prof_religiao.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                list_prof_religiaoActionPerformed(evt);
            }
        });

        lbl_tel1aluno5.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_tel1aluno5.setForeground(new java.awt.Color(228, 0, 121));
        lbl_tel1aluno5.setText(" Ciência:");

        list_prof_ciencia.setModel(new DefaultComboBoxModel<Professor>(professores.toArray(new Professor[0])));
        list_prof_ciencia.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                list_prof_cienciaActionPerformed(evt);
            }
        });

        lbl_tel1aluno6.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_tel1aluno6.setForeground(new java.awt.Color(228, 0, 121));
        lbl_tel1aluno6.setText("Inglês:");

        lbl_tel1aluno7.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_tel1aluno7.setForeground(new java.awt.Color(228, 0, 121));
        lbl_tel1aluno7.setText("Artes:");

        list_prof_geografia.setModel(new DefaultComboBoxModel<Professor>(professores.toArray(new Professor[0])));
        list_prof_geografia.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                list_prof_geografiaActionPerformed(evt);
            }
        });

        list_prof_artes.setModel(new DefaultComboBoxModel<Professor>(professores.toArray(new Professor[0])));
        list_prof_artes.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                list_prof_artesActionPerformed(evt);
            }
        });

        lbl_tel1aluno8.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_tel1aluno8.setForeground(new java.awt.Color(228, 0, 121));
        lbl_tel1aluno8.setText(" Geografia:");

        list_prof_ingles.setModel(new DefaultComboBoxModel<Professor>(professores.toArray(new Professor[0])));
        list_prof_ingles.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                list_prof_inglesActionPerformed(evt);
            }
        });

        lbl_tel1aluno9.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_tel1aluno9.setForeground(new java.awt.Color(228, 0, 121));
        lbl_tel1aluno9.setText(" História:");

        list_prof_historia.setModel(new DefaultComboBoxModel<Professor>(professores.toArray(new Professor[0])));
        list_prof_historia.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                list_prof_historiaActionPerformed(evt);
            }
        });

        bt_alterar.setFont(new java.awt.Font("Estrangelo Edessa", 0, 23)); // NOI18N
        bt_alterar.setForeground(new java.awt.Color(255, 255, 255));
        bt_alterar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/button_ROXO.png"))); // NOI18N
        bt_alterar.setText("Alterar");
        bt_alterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_alterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_alterar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                bt_alterarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                bt_alterarMousePressed(evt);
            }
        });

        bt_excluir.setFont(new java.awt.Font("Estrangelo Edessa", 0, 23)); // NOI18N
        bt_excluir.setForeground(new java.awt.Color(255, 255, 255));
        bt_excluir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/button_ROXO.png"))); // NOI18N
        bt_excluir.setText("Excluir");
        bt_excluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_excluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_excluir.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                bt_excluirMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                bt_excluirMousePressed(evt);
            }
        });

        lista_professores_materias.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(divisor_topo_turmas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_divisoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(divisor_documentacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_divisoria2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_tel1aluno3)
                                            .addComponent(lbl_tel1aluno5)
                                            .addComponent(lbl_tel1aluno8)
                                            .addComponent(lbl_tel1aluno9)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lbl_tel1aluno1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(list_prof_portugues, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)
                                        .addComponent(lbl_tel1aluno2)
                                        .addGap(10, 10, 10)
                                        .addComponent(list_prof_educFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(list_prof_matematica, 0, 284, Short.MAX_VALUE)
                                            .addComponent(list_prof_ciencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_tel1aluno6)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbl_tel1aluno4)
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(list_prof_ingles, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(list_prof_religiao, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(list_prof_artes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(list_prof_geografia, 0, 284, Short.MAX_VALUE)
                                            .addComponent(list_prof_historia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(10, 10, 10)
                                        .addComponent(lbl_tel1aluno7))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bt_novaturma1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_nome)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_cidade)
                                            .addComponent(lbl_tel1aluno)
                                            .addComponent(lbl_cep))
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(list_turno, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(list_escolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_anoletivo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bt_alterar)
                                        .addGap(18, 18, 18)
                                        .addComponent(bt_excluir)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bt_cadastraTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lista_professores_materias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(bt_novaturma1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(divisor_topo_turmas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_divisoria)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nome)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_cidade)
                    .addComponent(list_escolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_tel1aluno)
                    .addComponent(list_turno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_cep)
                    .addComponent(txt_anoletivo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(divisor_documentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lbl_divisoria2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lista_professores_materias, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_tel1aluno1)
                            .addComponent(list_prof_portugues, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(list_prof_educFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(list_prof_religiao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(list_prof_matematica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_tel1aluno3)
                                .addComponent(lbl_tel1aluno4)))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(list_prof_ingles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(list_prof_ciencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_tel1aluno5)
                                .addComponent(lbl_tel1aluno6)))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(list_prof_artes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(list_prof_geografia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_tel1aluno8)
                                .addComponent(lbl_tel1aluno7)))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(list_prof_historia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))
                            .addComponent(lbl_tel1aluno9)))
                    .addComponent(lbl_tel1aluno2))
                .addGap(9, 9, 9)
                .addComponent(bt_cadastraTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_excluir)
                    .addComponent(bt_alterar))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeActionPerformed

    private void bt_novaturma1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novaturma1ActionPerformed
        this.dispose();
        new Turmas().setVisible(true);
    }//GEN-LAST:event_bt_novaturma1ActionPerformed

    private void list_escolaridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_escolaridadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list_escolaridadeActionPerformed

    private void list_turnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_turnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list_turnoActionPerformed

    private void list_prof_portuguesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_prof_portuguesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list_prof_portuguesActionPerformed

    private void list_prof_educFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_prof_educFisicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list_prof_educFisicaActionPerformed

    private void list_prof_matematicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_prof_matematicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list_prof_matematicaActionPerformed

    private void list_prof_religiaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_prof_religiaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list_prof_religiaoActionPerformed

    private void list_prof_cienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_prof_cienciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list_prof_cienciaActionPerformed

    private void list_prof_geografiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_prof_geografiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list_prof_geografiaActionPerformed

    private void list_prof_artesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_prof_artesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list_prof_artesActionPerformed

    private void list_prof_inglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_prof_inglesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list_prof_inglesActionPerformed

    private void list_prof_historiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_prof_historiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list_prof_historiaActionPerformed

    private void bt_cadastraTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastraTurmaActionPerformed
        cadastra_turma();
    }//GEN-LAST:event_bt_cadastraTurmaActionPerformed

    private void bt_alterarMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_bt_alterarMouseClicked
    {//GEN-HEADEREND:event_bt_alterarMouseClicked
        update();
    }//GEN-LAST:event_bt_alterarMouseClicked

    private void bt_alterarMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_bt_alterarMousePressed
    {//GEN-HEADEREND:event_bt_alterarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_alterarMousePressed

    private void bt_excluirMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_bt_excluirMouseClicked
    {//GEN-HEADEREND:event_bt_excluirMouseClicked
        deletar();
    }//GEN-LAST:event_bt_excluirMouseClicked

    private void bt_excluirMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_bt_excluirMousePressed
    {//GEN-HEADEREND:event_bt_excluirMousePressed

    }//GEN-LAST:event_bt_excluirMousePressed

    public void backgroundcolor()
    {   this.getContentPane().setBackground(Color.decode("#d4eeff"));   }
    
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {   new Cadastro_Turma().setVisible(true);  }
        }
                                       );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bt_alterar;
    private javax.swing.JButton bt_cadastraTurma;
    private javax.swing.JLabel bt_excluir;
    private javax.swing.JButton bt_novaturma1;
    private javax.swing.JLabel divisor_documentacao;
    private javax.swing.JLabel divisor_topo_turmas;
    private javax.swing.JLabel lbl_cep;
    private javax.swing.JLabel lbl_cidade;
    private javax.swing.JLabel lbl_divisoria;
    private javax.swing.JLabel lbl_divisoria2;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_tel1aluno;
    private javax.swing.JLabel lbl_tel1aluno1;
    private javax.swing.JLabel lbl_tel1aluno2;
    private javax.swing.JLabel lbl_tel1aluno3;
    private javax.swing.JLabel lbl_tel1aluno4;
    private javax.swing.JLabel lbl_tel1aluno5;
    private javax.swing.JLabel lbl_tel1aluno6;
    private javax.swing.JLabel lbl_tel1aluno7;
    private javax.swing.JLabel lbl_tel1aluno8;
    private javax.swing.JLabel lbl_tel1aluno9;
    private javax.swing.JComboBox list_escolaridade;
    private javax.swing.JComboBox list_prof_artes;
    private javax.swing.JComboBox list_prof_ciencia;
    private javax.swing.JComboBox list_prof_educFisica;
    private javax.swing.JComboBox list_prof_geografia;
    private javax.swing.JComboBox list_prof_historia;
    private javax.swing.JComboBox list_prof_ingles;
    private javax.swing.JComboBox list_prof_matematica;
    private javax.swing.JComboBox list_prof_portugues;
    private javax.swing.JComboBox list_prof_religiao;
    private javax.swing.JComboBox list_turno;
    private javax.swing.JComboBox<String> lista_professores_materias;
    private javax.swing.JTextField txt_anoletivo;
    private javax.swing.JTextField txt_nome;
    // End of variables declaration//GEN-END:variables

}
