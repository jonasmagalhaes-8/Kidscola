package MVC_View;

import Class.Background_image;
import MVC_Controller.Controller_Aluno;
import MVC_Controller.Controller_Turma;
import MVC_Model.Aluno;
import javax.swing.DefaultComboBoxModel;
import MVC_Model.Turma;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import java.awt.Color;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Matricula_Aluno extends javax.swing.JFrame
{
    Controller_Aluno controller_aluno = new Controller_Aluno();
    List<Turma> turmas = new Controller_Turma().carrega_turmas();
    Aluno aluno;
    
    public Matricula_Aluno(Aluno aluno)
    {
        try
        { UIManager.setLookAndFeel( new MintLookAndFeel()); }
        catch( Exception ex )
        { JOptionPane.showMessageDialog(null,"Não foi possível inicializar a Interface Gráfica Tatto" ); }
        initComponents();
        
        this.aluno=aluno;
        if(aluno!=null)
        preenche_campos();
        else
        {
            bt_alterar.setVisible(false);
            bt_excluir.setVisible(false);
        }
        
        Background_image fundo = new Background_image
        ( new ImageIcon("src/Imagens/background_matricula.jpg").getImage() );
        this.getContentPane().add(fundo);
        backgroundcolor();
    }

    private void preenche_campos()
    {
        bt_matricula.setVisible(false);
        bt_alterar.setVisible(true);
        bt_excluir.setVisible(true);
        
        int i;
        for(i=0;i<turmas.size();i++)
        {
            if(turmas.get(i).getId_turma()==aluno.getId_turma())
            lista_turmas.setSelectedIndex(i);
        }
        txt_nome.setText(aluno.getNome());
        escolhe_data.setDate(aluno.getData_nascimento());
        txt_cep.setText(aluno.getCep());
        txt_cidade.setText(aluno.getCidade());
        txt_bairro.setText(aluno.getBairro());
        txt_endereco.setText(aluno.getRua());
        txt_tel1aluno.setText(aluno.getTelefone1());
        txt_tel2aluno.setText(aluno.getTelefone2());
        txt_telemergencia.setText(aluno.getTelefone_emergencial());
        txt_maenome.setText(aluno.getNome_mae());
        txt_maetelefone1.setText(aluno.getTelefone1_mae());
        txt_maetelefone2.setText(aluno.getTelefone2_mae());
        txt_cpfmae.setText(aluno.getCpf_mae());
        txt_rgmae.setText(aluno.getRg_mae());
        txt_painome.setText(aluno.getNome_pai());
        txt_paitelefone1.setText(aluno.getTelefone1_pai());
        txt_paitelefone2.setText(aluno.getTelefone2_pai());
        txt_cpfpai.setText(aluno.getCpf_pai());
        txt_rgpai.setText(aluno.getRg_pai());
    }
    
    private void update()
    {
        int id_turma = turmas.get(lista_turmas.getSelectedIndex()).getId_turma();
        
        if(id_turma!=aluno.getId_turma())
        {
            if(controller_aluno.update_aluno_turma(aluno.getId_aluno(), id_turma))
            JOptionPane.showMessageDialog(null, "Turma do aluno atualizado com sucesso!");
        }
        
        if(!txt_nome.getText().equals(aluno.getNome()))
        {
            if(controller_aluno.update_nome(aluno, txt_nome.getText()))
            JOptionPane.showMessageDialog(null, "Nome do aluno atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o nome do aluno!");
        }
        
        if(!txt_cep.getText().equals(aluno.getCep()))
        {
            if(controller_aluno.update_cep(aluno, txt_cep.getText()))
            JOptionPane.showMessageDialog(null, "CEP do Aluno atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o CEP do aluno!");
        }  
 
        if(!txt_bairro.getText().equals(aluno.getBairro()))
        {
            if(controller_aluno.update_bairro(aluno, txt_bairro.getText()))
            JOptionPane.showMessageDialog(null, "Bairro do Aluno atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o Bairro do aluno!");
        }
        
        if(!txt_cidade.getText().equals(aluno.getCidade()))
        {
            if(controller_aluno.update_cidade(aluno, txt_cidade.getText()))
            JOptionPane.showMessageDialog(null, "Cidade do Aluno atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar a Cidade do aluno!");
        }  
        
        if(!txt_endereco.getText().equals(aluno.getRua()))
        {
            if(controller_aluno.update_rua(aluno, txt_endereco.getText()))
            JOptionPane.showMessageDialog(null, "Rua do aluno atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar a Rua do aluno!");
        }
        
        if(!txt_tel1aluno.getText().equals(aluno.getTelefone1()))
        {
            if(controller_aluno.update_telefone1(aluno, txt_tel1aluno.getText()))
            JOptionPane.showMessageDialog(null, "Telefone 1 do Aluno atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o Telefone 1 do aluno!");
        }  
 
        if(!txt_tel2aluno.getText().equals(aluno.getTelefone2()))
        {
            if(controller_aluno.update_telefone2(aluno, txt_tel2aluno.getText()))
            JOptionPane.showMessageDialog(null, "Telefone 2 do Aluno atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o Telefone 2 do aluno!");
        }   
        
        if(!txt_telemergencia.getText().equals(aluno.getTelefone_emergencial()))
        {
            if(controller_aluno.update_telefone_emergencial(aluno, txt_telemergencia.getText()))
            JOptionPane.showMessageDialog(null, "Telefone Emergencial do Aluno atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o Telefone Emergencial do aluno!");
        } 

        if(!txt_maenome.getText().equals(aluno.getNome_mae()))
        {
            if(controller_aluno.update_mae_nome(aluno, txt_maenome.getText()))
            JOptionPane.showMessageDialog(null, "Nome da Mãe do aluno atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o nome da Mãe do aluno!");
        }
        
        if(!txt_cpfmae.getText().equals(aluno.getCpf_mae()))
        {
            if(controller_aluno.update_cpf_mae(aluno, txt_cpfmae.getText()))
            JOptionPane.showMessageDialog(null, "CPF da Mãe do Aluno atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o CPF da Mãe aluno!");
        }  
 
        if(!txt_rgmae.getText().equals(aluno.getRg_mae()))
        {
            if(controller_aluno.update_rg_mae(aluno, txt_rgmae.getText()))
            JOptionPane.showMessageDialog(null, "RG da Mãe do Aluno atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o RG da Mãe aluno!");
        }
        
        if(!txt_maetelefone1.getText().equals(aluno.getTelefone1_mae()))
        {
            if(controller_aluno.update_telefone1_mae(aluno, txt_maetelefone1.getText()))
            JOptionPane.showMessageDialog(null, "Telefone 1 da Mãe do Aluno atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o Telefone 1 da Mãe do aluno!");
        }  
 
        if(!txt_maetelefone2.getText().equals(aluno.getTelefone2_mae()))
        {
            if(controller_aluno.update_telefone2_mae(aluno, txt_maetelefone2.getText()))
            JOptionPane.showMessageDialog(null, "Telefone 2 da Mãe do Aluno atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o Telefone 2 da Mãe do aluno!");
        }  
        
        if(!txt_painome.getText().equals(aluno.getNome_pai()))
        {
            if(controller_aluno.update_pai_nome(aluno, txt_painome.getText()))
            JOptionPane.showMessageDialog(null, "Nome do Pai do aluno atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o nome do Pai do aluno!");
        }
        
        if(!txt_cpfpai.getText().equals(aluno.getCpf_pai()))
        {
            if(controller_aluno.update_cpf_pai(aluno, txt_cpfpai.getText()))
            JOptionPane.showMessageDialog(null, "CPF do Pai do Aluno atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o CPF do Pai aluno!");
        }  
 
        if(!txt_rgpai.getText().equals(aluno.getRg_pai()))
        {
            if(controller_aluno.update_rg_pai(aluno, txt_rgpai.getText()))
            JOptionPane.showMessageDialog(null, "RG do Pai do Aluno atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o RG do Pai aluno!");
        }
        
        if(!txt_paitelefone1.getText().equals(aluno.getTelefone1_pai()))
        {
            if(controller_aluno.update_telefone1_pai(aluno, txt_paitelefone1.getText()))
            JOptionPane.showMessageDialog(null, "Telefone 1 do Pai do Aluno atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o Telefone 1 do Pai do aluno!");
        }  
 
        if(!txt_paitelefone2.getText().equals(aluno.getTelefone2_pai()))
        {
            if(controller_aluno.update_telefone2_pai(aluno, txt_paitelefone2.getText()))
            JOptionPane.showMessageDialog(null, "Telefone 2 do Pai do Aluno atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o Telefone 2 do Pai do aluno!");
        }  
        
        if(!escolhe_data.getDate().equals(aluno.getData_nascimento()))
        {
            if(controller_aluno.update_nascimento(aluno, escolhe_data.getDate()))
            JOptionPane.showMessageDialog(null, "Data de Nascimento do Aluno atualizada com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar a Data de Nascimento do aluno!");
        }
    }
    
    public void delete_aluno()
    {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse aluno da base de dados?", "EXCLUSÃO DE ALUNO", 2);
        
        if(resposta==0)
        {
            if(controller_aluno.detele_aluno(aluno.getId_aluno()))
            {
                JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso");
                this.dispose();
                new Turmas().setVisible(true);
            }
            else
            JOptionPane.showMessageDialog(null, "Houve uma falha ao excluir a matrícula do Aluno");
        }
    }
    
    private Matricula_Aluno()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void preenche_cep()
    {
            new Thread(new Runnable()
            {
                public void run()
                {
                    br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteService service = new br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteService();
                    br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente port = service.getAtendeClientePort();
                    try
                    {
                        br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP consulta = port.consultaCEP(txt_cep.getText());

                        String endereco=consulta.getEnd();
                        txt_endereco.setText(endereco);
                        
                        if(txt_endereco.getText().length()>endereco.length())
                        {
                            txt_endereco.setText("");
                            txt_endereco.setText(endereco);
                        }
                        
                        txt_bairro.setText(consulta.getBairro());
                        txt_cidade.setText(consulta.getCidade());
                    }
                    catch(Exception e)
                    {   JOptionPane.showMessageDialog(null, "CEP informado inválido, ou falta de conexão com a internet");   }
                }
            }
                       ).start();
    }
    
    private void matricular_aluno()
    {
        int id_turma = turmas.get(lista_turmas.getSelectedIndex()).getId_turma();
        boolean matricula=new Controller_Aluno().Matricular_Aluno(id_turma,txt_nome.getText(), escolhe_data.getDate(), txt_tel1aluno.getText(), txt_tel2aluno.getText(), txt_telemergencia.getText(),txt_cep.getText(), txt_endereco.getText(), txt_bairro.getText(), txt_cidade.getText(), txt_maenome.getText(), txt_maetelefone1.getText(), txt_maetelefone2.getText(), txt_cpfmae.getText(), txt_rgmae.getText(), txt_painome.getText(), txt_paitelefone1.getText(), txt_paitelefone2.getText(), txt_cpfpai.getText(), txt_rgpai.getText());
        
        if(matricula)
        {
            JOptionPane.showMessageDialog(null, "Matrícula realizada com sucesso!");
            this.dispose();
            new Matricula_Aluno(null).setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Houve um erro ao realizar a matrícula!");
            this.show(true);
        }
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        divisor_topo_turmas = new javax.swing.JLabel();
        lbl_divisoria = new javax.swing.JLabel();
        lbl_turma = new javax.swing.JLabel();
        lista_turmas = new javax.swing.JComboBox();
        lbl_nome = new javax.swing.JLabel();
        bt_novaturma1 = new javax.swing.JButton();
        bt_matricula = new javax.swing.JButton();
        lbl_cep = new javax.swing.JLabel();
        txt_cep = new javax.swing.JTextField();
        lbl_endereco = new javax.swing.JLabel();
        txt_cidade = new javax.swing.JTextField();
        lbl_bairro = new javax.swing.JLabel();
        txt_endereco = new javax.swing.JTextField();
        lbl_cidade = new javax.swing.JLabel();
        txt_bairro = new javax.swing.JTextField();
        lbl_nascimento = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        lbl_tel1aluno = new javax.swing.JLabel();
        txt_tel1aluno = new javax.swing.JTextField();
        lbl_tel2aluno = new javax.swing.JLabel();
        txt_tel2aluno = new javax.swing.JTextField();
        divisor_filiacao = new javax.swing.JLabel();
        lbl_divisoria1 = new javax.swing.JLabel();
        lbl_maenome = new javax.swing.JLabel();
        txt_maenome = new javax.swing.JTextField();
        lbl_painome = new javax.swing.JLabel();
        txt_cpfmae = new javax.swing.JTextField();
        lbl_telMae1 = new javax.swing.JLabel();
        txt_maetelefone1 = new javax.swing.JTextField();
        lbl_telMae2 = new javax.swing.JLabel();
        txt_maetelefone2 = new javax.swing.JTextField();
        lbl_telPai1 = new javax.swing.JLabel();
        txt_rgmae = new javax.swing.JTextField();
        lbl_telemergencia = new javax.swing.JLabel();
        txt_telemergencia = new javax.swing.JTextField();
        escolhe_data = new com.github.lgooddatepicker.components.DatePicker();
        lbl_maenome1 = new javax.swing.JLabel();
        txt_painome = new javax.swing.JTextField();
        lbl_telMae3 = new javax.swing.JLabel();
        txt_paitelefone1 = new javax.swing.JTextField();
        lbl_telMae4 = new javax.swing.JLabel();
        txt_paitelefone2 = new javax.swing.JTextField();
        lbl_painome1 = new javax.swing.JLabel();
        txt_cpfpai = new javax.swing.JTextField();
        lbl_telPai3 = new javax.swing.JLabel();
        txt_rgpai = new javax.swing.JTextField();
        bt_excluir = new javax.swing.JLabel();
        bt_alterar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(146, 225, 244));

        divisor_topo_turmas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        divisor_topo_turmas.setText("MATRÍCULA");
        divisor_topo_turmas.setFont(new java.awt.Font("Estrangelo Edessa", 0, 33)); // NOI18N
        divisor_topo_turmas.setForeground(new java.awt.Color(228, 0, 121));

        lbl_divisoria.setBackground(new java.awt.Color(0, 0, 0));
        lbl_divisoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));

        lbl_turma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_turma.setText("Turma:");
        lbl_turma.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl_turma.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_turma.setForeground(new java.awt.Color(228, 0, 121));

        lista_turmas.setModel(new DefaultComboBoxModel<Turma>(turmas.toArray(new Turma[0])));

        lbl_nome.setText("Nome:");
        lbl_nome.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_nome.setForeground(new java.awt.Color(228, 0, 121));

        bt_novaturma1.setText("Voltar");
        bt_novaturma1.setBackground(new java.awt.Color(255, 255, 255));
        bt_novaturma1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));
        bt_novaturma1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_novaturma1.setFocusPainted(false);
        bt_novaturma1.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        bt_novaturma1.setForeground(new java.awt.Color(228, 0, 121));
        bt_novaturma1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                bt_novaturma1ActionPerformed(evt);
            }
        });

        bt_matricula.setText("Matrícular Aluno");
        bt_matricula.setBackground(new java.awt.Color(255, 255, 255));
        bt_matricula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));
        bt_matricula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_matricula.setFocusPainted(false);
        bt_matricula.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        bt_matricula.setForeground(new java.awt.Color(228, 0, 121));
        bt_matricula.setOpaque(false);
        bt_matricula.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                bt_matriculaActionPerformed(evt);
            }
        });

        lbl_cep.setText("CEP:");
        lbl_cep.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_cep.setForeground(new java.awt.Color(228, 0, 121));

        txt_cep.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cep.setPreferredSize(new java.awt.Dimension(54, 20));
        txt_cep.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txt_cepKeyReleased(evt);
            }
        });

        lbl_endereco.setText("Cidade:");
        lbl_endereco.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_endereco.setForeground(new java.awt.Color(228, 0, 121));

        txt_cidade.setPreferredSize(new java.awt.Dimension(138, 20));
        txt_cidade.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_cidadeActionPerformed(evt);
            }
        });

        lbl_bairro.setText("Bairro:");
        lbl_bairro.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_bairro.setForeground(new java.awt.Color(228, 0, 121));

        txt_endereco.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_enderecoActionPerformed(evt);
            }
        });

        lbl_cidade.setText("Rua/Nº:");
        lbl_cidade.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_cidade.setForeground(new java.awt.Color(228, 0, 121));

        txt_bairro.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_bairroActionPerformed(evt);
            }
        });

        lbl_nascimento.setText("Data de Nascimento:");
        lbl_nascimento.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_nascimento.setForeground(new java.awt.Color(228, 0, 121));

        txt_nome.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_nomeActionPerformed(evt);
            }
        });

        lbl_tel1aluno.setText("Telefone:");
        lbl_tel1aluno.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_tel1aluno.setForeground(new java.awt.Color(228, 0, 121));

        txt_tel1aluno.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_tel1alunoActionPerformed(evt);
            }
        });
        txt_tel1aluno.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txt_tel1alunoKeyReleased(evt);
            }
        });

        lbl_tel2aluno.setText("Telefone 2:");
        lbl_tel2aluno.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_tel2aluno.setForeground(new java.awt.Color(228, 0, 121));

        txt_tel2aluno.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_tel2alunoActionPerformed(evt);
            }
        });
        txt_tel2aluno.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txt_tel2alunoKeyReleased(evt);
            }
        });

        divisor_filiacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        divisor_filiacao.setText("FILIAÇÃO");
        divisor_filiacao.setFont(new java.awt.Font("Estrangelo Edessa", 0, 33)); // NOI18N
        divisor_filiacao.setForeground(new java.awt.Color(228, 0, 121));

        lbl_divisoria1.setBackground(new java.awt.Color(0, 0, 0));
        lbl_divisoria1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));

        lbl_maenome.setText("Nome da Mãe:");
        lbl_maenome.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_maenome.setForeground(new java.awt.Color(228, 0, 121));

        txt_maenome.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_maenomeActionPerformed(evt);
            }
        });

        lbl_painome.setText("CPF da Mãe:");
        lbl_painome.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_painome.setForeground(new java.awt.Color(228, 0, 121));

        txt_cpfmae.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_cpfmaeActionPerformed(evt);
            }
        });

        lbl_telMae1.setText("Telefone:");
        lbl_telMae1.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_telMae1.setForeground(new java.awt.Color(228, 0, 121));

        txt_maetelefone1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_maetelefone1ActionPerformed(evt);
            }
        });

        lbl_telMae2.setText("Telefone 2:");
        lbl_telMae2.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_telMae2.setForeground(new java.awt.Color(228, 0, 121));

        txt_maetelefone2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_maetelefone2ActionPerformed(evt);
            }
        });

        lbl_telPai1.setText("RG:");
        lbl_telPai1.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_telPai1.setForeground(new java.awt.Color(228, 0, 121));

        txt_rgmae.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_rgmaeActionPerformed(evt);
            }
        });

        lbl_telemergencia.setText("Contato de Emergência:");
        lbl_telemergencia.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_telemergencia.setForeground(new java.awt.Color(228, 0, 121));

        txt_telemergencia.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_telemergenciaActionPerformed(evt);
            }
        });
        txt_telemergencia.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txt_telemergenciaKeyReleased(evt);
            }
        });

        lbl_maenome1.setText("Nome do Pai:");
        lbl_maenome1.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_maenome1.setForeground(new java.awt.Color(228, 0, 121));

        txt_painome.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_painomeActionPerformed(evt);
            }
        });

        lbl_telMae3.setText("Telefone:");
        lbl_telMae3.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_telMae3.setForeground(new java.awt.Color(228, 0, 121));

        txt_paitelefone1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_paitelefone1ActionPerformed(evt);
            }
        });

        lbl_telMae4.setText("Telefone 2:");
        lbl_telMae4.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_telMae4.setForeground(new java.awt.Color(228, 0, 121));

        txt_paitelefone2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_paitelefone2ActionPerformed(evt);
            }
        });

        lbl_painome1.setText("CPF do Pai:");
        lbl_painome1.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_painome1.setForeground(new java.awt.Color(228, 0, 121));

        txt_cpfpai.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_cpfpaiActionPerformed(evt);
            }
        });

        lbl_telPai3.setText("RG:");
        lbl_telPai3.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_telPai3.setForeground(new java.awt.Color(228, 0, 121));

        txt_rgpai.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_rgpaiActionPerformed(evt);
            }
        });

        bt_excluir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/button_ROXO.png"))); // NOI18N
        bt_excluir.setText("Excluir");
        bt_excluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_excluir.setFont(new java.awt.Font("Estrangelo Edessa", 0, 23)); // NOI18N
        bt_excluir.setForeground(new java.awt.Color(255, 255, 255));
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

        bt_alterar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/button_ROXO.png"))); // NOI18N
        bt_alterar.setText("Alterar");
        bt_alterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_alterar.setFont(new java.awt.Font("Estrangelo Edessa", 0, 23)); // NOI18N
        bt_alterar.setForeground(new java.awt.Color(255, 255, 255));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(divisor_topo_turmas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_divisoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(divisor_filiacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_divisoria1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_matricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_cidade)
                                    .addComponent(lbl_tel1aluno))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_tel1aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbl_tel2aluno)
                                        .addGap(10, 10, 10)
                                        .addComponent(txt_tel2aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(72, 72, 72)
                                        .addComponent(lbl_telemergencia)
                                        .addGap(10, 10, 10)
                                        .addComponent(txt_telemergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(bt_novaturma1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_turma)
                                    .addComponent(lbl_cep)
                                    .addComponent(lbl_nome))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_nome)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lbl_endereco)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbl_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(13, 13, 13)
                                                .addComponent(txt_bairro))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbl_nascimento)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(escolhe_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(lista_turmas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_maenome)
                                    .addComponent(lbl_painome)
                                    .addComponent(lbl_maenome1)
                                    .addComponent(lbl_painome1))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_cpfpai, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_telPai3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_rgpai, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_maenome, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txt_cpfmae, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbl_telPai1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_rgmae, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(8, 8, 8)
                                        .addComponent(lbl_telMae1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_maetelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbl_telMae2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_maetelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_painome, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)
                                        .addComponent(lbl_telMae3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_paitelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbl_telMae4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_paitelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_alterar)
                                .addGap(18, 18, 18)
                                .addComponent(bt_excluir)))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bt_novaturma1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_rgmae, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(divisor_topo_turmas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_divisoria)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_turma)
                            .addComponent(lista_turmas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(escolhe_data, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_nome)
                                .addComponent(lbl_nascimento)
                                .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_cep)
                            .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_endereco)
                            .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_bairro)
                            .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_cidade)
                            .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_tel2aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_tel2aluno)
                                .addComponent(txt_telemergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_telemergencia))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_tel1aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_tel1aluno)))
                        .addGap(7, 7, 7)
                        .addComponent(divisor_filiacao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(lbl_divisoria1)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_maenome)
                                .addComponent(txt_maenome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbl_telMae1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_maetelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_telMae2)
                                    .addComponent(txt_maetelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_painome)
                                    .addComponent(txt_cpfmae, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lbl_telPai1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_maenome1)
                        .addComponent(txt_painome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbl_telMae3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_paitelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_telMae4)
                            .addComponent(txt_paitelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_painome1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_cpfpai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_rgpai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_telPai3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addComponent(bt_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_excluir)
                    .addComponent(bt_alterar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cidadeActionPerformed

    private void txt_enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_enderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_enderecoActionPerformed

    private void txt_bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bairroActionPerformed

    private void txt_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeActionPerformed

    private void txt_tel1alunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tel1alunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tel1alunoActionPerformed

    private void txt_maenomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maenomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maenomeActionPerformed

    private void txt_cpfmaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cpfmaeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpfmaeActionPerformed

    private void txt_maetelefone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maetelefone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maetelefone1ActionPerformed

    private void txt_maetelefone2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maetelefone2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maetelefone2ActionPerformed

    private void txt_rgmaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rgmaeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rgmaeActionPerformed

    private void txt_telemergenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telemergenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telemergenciaActionPerformed

    private void bt_novaturma1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novaturma1ActionPerformed
        this.dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_bt_novaturma1ActionPerformed

    private void bt_matriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_matriculaActionPerformed
        this.dispose();
        matricular_aluno();
    }//GEN-LAST:event_bt_matriculaActionPerformed

    private void txt_cepKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txt_cepKeyReleased
    {//GEN-HEADEREND:event_txt_cepKeyReleased
        if(txt_cep.getText().length()==8)
        preenche_cep();
        else if(txt_cep.getText().length()>8)
        JOptionPane.showMessageDialog(null, "CEP informado inválido! Favor informar corretamente os 8 digitos");
        if(txt_cep.getText().contains("-") || txt_cep.getText().contains("."))
        JOptionPane.showMessageDialog(null, "Favor não inserir caracteres especiais, apenas os NÚMEROS do CEP");
    }//GEN-LAST:event_txt_cepKeyReleased

    private void txt_painomeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_painomeActionPerformed
    {//GEN-HEADEREND:event_txt_painomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_painomeActionPerformed

    private void txt_paitelefone1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_paitelefone1ActionPerformed
    {//GEN-HEADEREND:event_txt_paitelefone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_paitelefone1ActionPerformed

    private void txt_paitelefone2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_paitelefone2ActionPerformed
    {//GEN-HEADEREND:event_txt_paitelefone2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_paitelefone2ActionPerformed

    private void txt_cpfpaiActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_cpfpaiActionPerformed
    {//GEN-HEADEREND:event_txt_cpfpaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpfpaiActionPerformed

    private void txt_rgpaiActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_rgpaiActionPerformed
    {//GEN-HEADEREND:event_txt_rgpaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rgpaiActionPerformed

    private void txt_tel2alunoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_tel2alunoActionPerformed
    {//GEN-HEADEREND:event_txt_tel2alunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tel2alunoActionPerformed

    private void bt_excluirMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_bt_excluirMouseClicked
    {//GEN-HEADEREND:event_bt_excluirMouseClicked
        delete_aluno();
    }//GEN-LAST:event_bt_excluirMouseClicked

    private void bt_excluirMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_bt_excluirMousePressed
    {//GEN-HEADEREND:event_bt_excluirMousePressed

    }//GEN-LAST:event_bt_excluirMousePressed

    private void bt_alterarMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_bt_alterarMouseClicked
    {//GEN-HEADEREND:event_bt_alterarMouseClicked
        update();
    }//GEN-LAST:event_bt_alterarMouseClicked

    private void bt_alterarMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_bt_alterarMousePressed
    {//GEN-HEADEREND:event_bt_alterarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_alterarMousePressed

    private void txt_tel1alunoKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txt_tel1alunoKeyReleased
    {//GEN-HEADEREND:event_txt_tel1alunoKeyReleased
        if(txt_tel1aluno.getText().length()>11)
        JOptionPane.showMessageDialog(null, "Telefone inválido! Favor informar corretamente os 11 Digitos\nDD9XXXXXXXX");
        if(txt_tel1aluno.getText().contains("(") || txt_tel1aluno.getText().contains(")") || txt_tel1aluno.getText().contains("-"))
        JOptionPane.showMessageDialog(null, "Favor remover os caracteres especiais, informe apenas os NÚMEROS do Telefone");
        
    }//GEN-LAST:event_txt_tel1alunoKeyReleased

    private void txt_tel2alunoKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txt_tel2alunoKeyReleased
    {//GEN-HEADEREND:event_txt_tel2alunoKeyReleased
        if(txt_tel2aluno.getText().length()>11)
        JOptionPane.showMessageDialog(null, "Telefone inválido! Favor informar corretamente os 11 Digitos\nDD9XXXXXXXX");
        if(txt_tel2aluno.getText().contains("(") || txt_tel2aluno.getText().contains(")") || txt_tel2aluno.getText().contains("-"))
        JOptionPane.showMessageDialog(null, "Favor remover os caracteres especiais, informe apenas os NÚMEROS do Telefone");
    }//GEN-LAST:event_txt_tel2alunoKeyReleased

    private void txt_telemergenciaKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txt_telemergenciaKeyReleased
    {//GEN-HEADEREND:event_txt_telemergenciaKeyReleased
        if(txt_telemergencia.getText().length()>11)
        JOptionPane.showMessageDialog(null, "Telefone inválido! Favor informar corretamente os 11 Digitos\nDD9XXXXXXXX");
        if(txt_telemergencia.getText().contains("(") || txt_telemergencia.getText().contains(")") || txt_telemergencia.getText().contains("-"))
        JOptionPane.showMessageDialog(null, "Favor remover os caracteres especiais, informe apenas os NÚMEROS do Telefone");
    }//GEN-LAST:event_txt_telemergenciaKeyReleased

    public void backgroundcolor()
    {   this.getContentPane().setBackground(Color.decode("#d4eeff"));   }
    
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {   new Matricula_Aluno().setVisible(true);  }
        }
                                       );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bt_alterar;
    private javax.swing.JLabel bt_excluir;
    private javax.swing.JButton bt_matricula;
    private javax.swing.JButton bt_novaturma1;
    private javax.swing.JLabel divisor_filiacao;
    private javax.swing.JLabel divisor_topo_turmas;
    private com.github.lgooddatepicker.components.DatePicker escolhe_data;
    private javax.swing.JLabel lbl_bairro;
    private javax.swing.JLabel lbl_cep;
    private javax.swing.JLabel lbl_cidade;
    private javax.swing.JLabel lbl_divisoria;
    private javax.swing.JLabel lbl_divisoria1;
    private javax.swing.JLabel lbl_endereco;
    private javax.swing.JLabel lbl_maenome;
    private javax.swing.JLabel lbl_maenome1;
    private javax.swing.JLabel lbl_nascimento;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_painome;
    private javax.swing.JLabel lbl_painome1;
    private javax.swing.JLabel lbl_tel1aluno;
    private javax.swing.JLabel lbl_tel2aluno;
    private javax.swing.JLabel lbl_telMae1;
    private javax.swing.JLabel lbl_telMae2;
    private javax.swing.JLabel lbl_telMae3;
    private javax.swing.JLabel lbl_telMae4;
    private javax.swing.JLabel lbl_telPai1;
    private javax.swing.JLabel lbl_telPai3;
    private javax.swing.JLabel lbl_telemergencia;
    private javax.swing.JLabel lbl_turma;
    private javax.swing.JComboBox lista_turmas;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JTextField txt_cep;
    private javax.swing.JTextField txt_cidade;
    private javax.swing.JTextField txt_cpfmae;
    private javax.swing.JTextField txt_cpfpai;
    private javax.swing.JTextField txt_endereco;
    private javax.swing.JTextField txt_maenome;
    private javax.swing.JTextField txt_maetelefone1;
    private javax.swing.JTextField txt_maetelefone2;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_painome;
    private javax.swing.JTextField txt_paitelefone1;
    private javax.swing.JTextField txt_paitelefone2;
    private javax.swing.JTextField txt_rgmae;
    private javax.swing.JTextField txt_rgpai;
    private javax.swing.JTextField txt_tel1aluno;
    private javax.swing.JTextField txt_tel2aluno;
    private javax.swing.JTextField txt_telemergencia;
    // End of variables declaration//GEN-END:variables

}
