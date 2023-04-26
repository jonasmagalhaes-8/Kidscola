package MVC_View;

import Class.Background_image;
import MVC_Controller.Controller_Professor;
import MVC_Model.Professor;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Matricula_Professor extends javax.swing.JFrame
{
    List<String> materias = new ArrayList<>();
    Controller_Professor controller_professor = new Controller_Professor();
    Professor professor;
    boolean portugues,educ_fisica,matematica,religiao,ciencia,ingles,geografia,artes,historia;
    
    public Matricula_Professor(Professor professor)
    {
        try
        { UIManager.setLookAndFeel( new MintLookAndFeel()); }
        catch( Exception ex )
         { JOptionPane.showMessageDialog(null,"Não foi possível inicializar a Interface Gráfica Tatto" ); }
        
        initComponents();
        this.professor=professor;
        
        if(professor!=null)
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
        bt_cadastrarProfessor.setVisible(false);
        bt_alterar.setVisible(true);
        bt_excluir.setVisible(true);
        
        txt_nome.setText(professor.getNome());
        escolhe_data.setDate(professor.getData_nascimento());
        txt_cep.setText(professor.getCep());
        txt_cidade.setText(professor.getCidade());
        txt_bairro.setText(professor.getBairro());
        txt_endereco.setText(professor.getRua());
        txt_tel1.setText(professor.getTelefone1());
        txt_tel2.setText(professor.getTelefone2());
        txt_cpf.setText(professor.getCpf());
        txt_rg.setText(professor.getRg());
        txt_email.setText(professor.getEmail());
        
        int i;
        for(i=0;i<professor.getMaterias().size();i++)
        {
            if(professor.getMaterias().get(i).equals("Português"))
            {
                disc_portugues.setSelected(true);
                portugues=true;
            }
            else if(professor.getMaterias().get(i).equals("Artes"))
            {
                disc_artes.setSelected(true);
                artes=true;
            }
            else if(professor.getMaterias().get(i).equals("Educação Física"))
            {
                educ_fisica=true;
                disc_educfisica.setSelected(true);
            }
            else if(professor.getMaterias().get(i).equals("Religião"))
            {
                disc_religiao.setSelected(true);
                religiao=true;
            }
            else if(professor.getMaterias().get(i).equals("Inglês"))
            {
                disc_ingles.setSelected(true);
                ingles=true;
            }
            else if(professor.getMaterias().get(i).equals("Matemática"))
            {
                matematica=true;
                disc_matematica.setSelected(true);
            }
            else if(professor.getMaterias().get(i).equals("Ciência"))
            {
                disc_ciencia.setSelected(true);
                ciencia=true;
            }
            else if(professor.getMaterias().get(i).equals("Geografia"))
            {
                geografia=true;
                disc_geografia.setSelected(true);
            }
            else if(professor.getMaterias().get(i).equals("História"))
            {
                disc_historia.setSelected(true);
                historia=true;
            }
        }
    }
    
    private void update_professor()
    {
        if(!txt_nome.getText().equals(professor.getNome()))
        {
            if(controller_professor.update_nome(professor, txt_nome.getText()))
            JOptionPane.showMessageDialog(null, "Nome do Professor atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o nome do Professor!");
        }
        
        if(!txt_cep.getText().equals(professor.getCep()))
        {
            if(controller_professor.update_cep(professor, txt_cep.getText()))
            JOptionPane.showMessageDialog(null, "CEP do Professor atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o CEP do Professor!");
        }  
 
        if(!txt_bairro.getText().equals(professor.getBairro()))
        {
            if(controller_professor.update_bairro(professor, txt_bairro.getText()))
            JOptionPane.showMessageDialog(null, "Bairro do Professor atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o Bairro do Professor!");
        }
        
        if(!txt_cidade.getText().equals(professor.getCidade()))
        {
            if(controller_professor.update_cidade(professor, txt_cidade.getText()))
            JOptionPane.showMessageDialog(null, "Cidade do Professor atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar a Cidade do Professor!");
        }  
        
        if(!txt_endereco.getText().equals(professor.getRua()))
        {
            if(controller_professor.update_rua(professor, txt_endereco.getText()))
            JOptionPane.showMessageDialog(null, "Rua do Professor atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar a Rua do Professor!");
        }
        
        if(!txt_tel1.getText().equals(professor.getTelefone1()))
        {
            if(controller_professor.update_telefone1(professor, txt_tel1.getText()))
            JOptionPane.showMessageDialog(null, "Telefone 1 do Professor atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o Telefone 1 do Professor!");
        }  
 
        if(!txt_tel2.getText().equals(professor.getTelefone2()))
        {
            if(controller_professor.update_telefone2(professor, txt_tel2.getText()))
            JOptionPane.showMessageDialog(null, "Telefone 2 do Professor atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o Telefone 2 do Professor!");
        }   
        
        if(!txt_cpf.getText().equals(professor.getCpf()))
        {
            if(controller_professor.update_cpf(professor, txt_cpf.getText()))
            JOptionPane.showMessageDialog(null, "CPF do Professor atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o CPF do Professor!");
        }  
 
        if(!txt_rg.getText().equals(professor.getRg()))
        {
            if(controller_professor.update_rg(professor, txt_rg.getText()))
            JOptionPane.showMessageDialog(null, "RG do Professor atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o RG do Professor!");
        }
        
        if(!txt_email.getText().equals(professor.getEmail()))
        {
            if(controller_professor.update_email(professor, txt_email.getText()))
            JOptionPane.showMessageDialog(null, "E-Mail do Professor atualizado com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar o E-Mail do Professor!");
        }
        
        boolean alterou_disciplina=false;
        
        if(artes!=disc_artes.isSelected())
        alterou_disciplina=true;
        
        if(ciencia!=disc_ciencia.isSelected())
        alterou_disciplina=true;
        
        if(educ_fisica!=disc_educfisica.isSelected())
        alterou_disciplina=true;
        
        if(geografia!=disc_geografia.isSelected())
        alterou_disciplina=true;
        
        if(historia!=disc_historia.isSelected())
        alterou_disciplina=true;
        
        if(ingles!=disc_ingles.isSelected())
        alterou_disciplina=true;
        
        if(matematica!=disc_matematica.isSelected())
        alterou_disciplina=true;
        
        if(portugues!=disc_portugues.isSelected())
        alterou_disciplina=true;
        
        if(religiao!=disc_religiao.isSelected())
        alterou_disciplina=true;
        
        if(alterou_disciplina)
        {
            materias.clear();
            
            if(disc_portugues.isSelected())
            materias.add(disc_portugues.getText());
            if(disc_artes.isSelected())
            materias.add(disc_artes.getText());
            if(disc_educfisica.isSelected())
            materias.add(disc_educfisica.getText());
            if(disc_religiao.isSelected())
            materias.add(disc_religiao.getText());
            if(disc_ingles.isSelected())
            materias.add(disc_ingles.getText());
            if(disc_matematica.isSelected())
            materias.add(disc_matematica.getText());
            if(disc_ciencia.isSelected())
            materias.add(disc_ciencia.getText());
            if(disc_geografia.isSelected())
            materias.add(disc_geografia.getText());
            if(disc_historia.isSelected())
            materias.add(disc_historia.getText());
            
            if(controller_professor.update_materias_professor(professor.getId_professor(),materias))
            JOptionPane.showMessageDialog(null, "Disciplinas que o Professor ministra atualizadas com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Houve um erro ao atualizar as disciplias que o Professor ministra.");
            
            materias.clear();
        }
    }
    
    private void delete_professor()
    {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse Professor da base de dados?", "EXCLUSÃO DE PROFESSOR", 2);
        
        if(resposta==0)
        {
            if(controller_professor.detele_professor(professor.getId_professor()))
            {
                JOptionPane.showMessageDialog(null, "Professor excluído com sucesso");
                this.dispose();
                new Turmas().setVisible(true);
            }
            else
            JOptionPane.showMessageDialog(null, "Houve uma falha ao excluir a matrícula do Professor");
        }
    }
    
    private void cadastrar_professor()
    {
        if(disc_portugues.isSelected())
        materias.add(disc_portugues.getText());
        if(disc_artes.isSelected())
        materias.add(disc_artes.getText());
        if(disc_educfisica.isSelected())
        materias.add(disc_educfisica.getText());
        if(disc_religiao.isSelected())
        materias.add(disc_religiao.getText());
        if(disc_ingles.isSelected())
        materias.add(disc_ingles.getText());
        if(disc_matematica.isSelected())
        materias.add(disc_matematica.getText());
        if(disc_ciencia.isSelected())
        materias.add(disc_ciencia.getText());
        if(disc_geografia.isSelected())
        materias.add(disc_geografia.getText());
        if(disc_historia.isSelected())
        materias.add(disc_historia.getText());
        
        Controller_Professor novo_professor = new Controller_Professor();
        boolean cadastro=novo_professor.Cadastrar_professor(txt_nome.getText(), escolhe_data.getDate(), txt_tel1.getText(), txt_tel2.getText(), txt_cep.getText(), txt_cidade.getText(), txt_bairro.getText(), txt_endereco.getText(), txt_email.getText(), txt_cpf.getText(), txt_rg.getText(), materias);
        materias.clear();
        
        if(cadastro)
        {
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
            this.dispose();
            new Matricula_Professor(null).setVisible(true);
        }
        else
        JOptionPane.showMessageDialog(null, "Houve um erro ao realizar o cadastro");
    }
    
    private Matricula_Professor()
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
                        txt_endereco.setText(consulta.getEnd());
                        
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
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        divisor_topo_cadastro_professor = new javax.swing.JLabel();
        lbl_divisoria = new javax.swing.JLabel();
        lbl_nome = new javax.swing.JLabel();
        bt_voltar = new javax.swing.JButton();
        bt_cadastrarProfessor = new javax.swing.JButton();
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
        lbl_tel1 = new javax.swing.JLabel();
        txt_tel1 = new javax.swing.JTextField();
        lbl_tel2 = new javax.swing.JLabel();
        txt_tel2 = new javax.swing.JTextField();
        lbl_email = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        divisor_disciplinasMinistradas = new javax.swing.JLabel();
        lbl_divisoria2 = new javax.swing.JLabel();
        disc_portugues = new javax.swing.JCheckBox();
        disc_artes = new javax.swing.JCheckBox();
        disc_religiao = new javax.swing.JCheckBox();
        disc_educfisica = new javax.swing.JCheckBox();
        txt_cpf = new javax.swing.JTextField();
        lbl_cpf = new javax.swing.JLabel();
        lbl_rg = new javax.swing.JLabel();
        txt_rg = new javax.swing.JTextField();
        disc_matematica = new javax.swing.JCheckBox();
        disc_ciencia = new javax.swing.JCheckBox();
        disc_geografia = new javax.swing.JCheckBox();
        disc_historia = new javax.swing.JCheckBox();
        disc_ingles = new javax.swing.JCheckBox();
        escolhe_data = new com.github.lgooddatepicker.components.DatePicker();
        bt_alterar = new javax.swing.JLabel();
        bt_excluir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(146, 225, 244));

        divisor_topo_cadastro_professor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        divisor_topo_cadastro_professor.setText("CADASTRO DE PROFESSOR");
        divisor_topo_cadastro_professor.setFont(new java.awt.Font("Estrangelo Edessa", 0, 33)); // NOI18N
        divisor_topo_cadastro_professor.setForeground(new java.awt.Color(228, 0, 121));

        lbl_divisoria.setBackground(new java.awt.Color(0, 0, 0));
        lbl_divisoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));

        lbl_nome.setText("Nome:");
        lbl_nome.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_nome.setForeground(new java.awt.Color(228, 0, 121));

        bt_voltar.setBackground(new java.awt.Color(255, 255, 255));
        bt_voltar.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        bt_voltar.setForeground(new java.awt.Color(228, 0, 121));
        bt_voltar.setText("Voltar");
        bt_voltar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));
        bt_voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_voltar.setFocusPainted(false);
        bt_voltar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                bt_voltarActionPerformed(evt);
            }
        });

        bt_cadastrarProfessor.setBackground(new java.awt.Color(255, 255, 255));
        bt_cadastrarProfessor.setFont(new java.awt.Font("Estrangelo Edessa", 0, 17)); // NOI18N
        bt_cadastrarProfessor.setForeground(new java.awt.Color(228, 0, 121));
        bt_cadastrarProfessor.setText("Cadastrar Professor");
        bt_cadastrarProfessor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));
        bt_cadastrarProfessor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_cadastrarProfessor.setFocusPainted(false);
        bt_cadastrarProfessor.setOpaque(false);
        bt_cadastrarProfessor.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                bt_cadastrarProfessorActionPerformed(evt);
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
        lbl_endereco.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
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

        txt_bairro.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                txt_bairroMouseClicked(evt);
            }
        });
        txt_bairro.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_bairroActionPerformed(evt);
            }
        });

        lbl_nascimento.setText("Nascimento:");
        lbl_nascimento.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_nascimento.setForeground(new java.awt.Color(228, 0, 121));

        txt_nome.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_nomeActionPerformed(evt);
            }
        });

        lbl_tel1.setText("Telefone:");
        lbl_tel1.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_tel1.setForeground(new java.awt.Color(228, 0, 121));

        txt_tel1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_tel1ActionPerformed(evt);
            }
        });

        lbl_tel2.setText("Telefone 2:");
        lbl_tel2.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_tel2.setForeground(new java.awt.Color(228, 0, 121));

        txt_tel2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_tel2ActionPerformed(evt);
            }
        });

        lbl_email.setText("E-Mail:");
        lbl_email.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(228, 0, 121));

        txt_email.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_emailActionPerformed(evt);
            }
        });

        divisor_disciplinasMinistradas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        divisor_disciplinasMinistradas.setText("DISCIPLINAS MINISTRADAS");
        divisor_disciplinasMinistradas.setFont(new java.awt.Font("Estrangelo Edessa", 0, 33)); // NOI18N
        divisor_disciplinasMinistradas.setForeground(new java.awt.Color(228, 0, 121));

        lbl_divisoria2.setBackground(new java.awt.Color(0, 0, 0));
        lbl_divisoria2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 0, 121)));

        disc_portugues.setText("Português");
        disc_portugues.setFocusPainted(false);
        disc_portugues.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        disc_portugues.setForeground(new java.awt.Color(228, 0, 121));
        disc_portugues.setOpaque(false);
        disc_portugues.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                disc_portuguesActionPerformed(evt);
            }
        });

        disc_artes.setText("Artes");
        disc_artes.setFocusPainted(false);
        disc_artes.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        disc_artes.setForeground(new java.awt.Color(228, 0, 121));
        disc_artes.setOpaque(false);

        disc_religiao.setText("Religião");
        disc_religiao.setFocusPainted(false);
        disc_religiao.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        disc_religiao.setForeground(new java.awt.Color(228, 0, 121));
        disc_religiao.setOpaque(false);

        disc_educfisica.setText("Educação Física");
        disc_educfisica.setFocusPainted(false);
        disc_educfisica.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        disc_educfisica.setForeground(new java.awt.Color(228, 0, 121));
        disc_educfisica.setOpaque(false);
        disc_educfisica.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                disc_educfisicaActionPerformed(evt);
            }
        });

        txt_cpf.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_cpfActionPerformed(evt);
            }
        });

        lbl_cpf.setText("CPF:");
        lbl_cpf.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_cpf.setForeground(new java.awt.Color(228, 0, 121));

        lbl_rg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_rg.setText("RG:");
        lbl_rg.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        lbl_rg.setForeground(new java.awt.Color(228, 0, 121));

        txt_rg.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txt_rgActionPerformed(evt);
            }
        });

        disc_matematica.setText("Matemática");
        disc_matematica.setFocusPainted(false);
        disc_matematica.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        disc_matematica.setForeground(new java.awt.Color(228, 0, 121));
        disc_matematica.setOpaque(false);
        disc_matematica.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                disc_matematicaActionPerformed(evt);
            }
        });

        disc_ciencia.setText("Ciência");
        disc_ciencia.setFocusPainted(false);
        disc_ciencia.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        disc_ciencia.setForeground(new java.awt.Color(228, 0, 121));
        disc_ciencia.setOpaque(false);

        disc_geografia.setText("Geografia");
        disc_geografia.setFocusPainted(false);
        disc_geografia.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        disc_geografia.setForeground(new java.awt.Color(228, 0, 121));
        disc_geografia.setOpaque(false);

        disc_historia.setText("História");
        disc_historia.setFocusPainted(false);
        disc_historia.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        disc_historia.setForeground(new java.awt.Color(228, 0, 121));
        disc_historia.setOpaque(false);
        disc_historia.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                disc_historiaActionPerformed(evt);
            }
        });

        disc_ingles.setText("Inglês");
        disc_ingles.setFocusPainted(false);
        disc_ingles.setFont(new java.awt.Font("Estrangelo Edessa", 0, 24)); // NOI18N
        disc_ingles.setForeground(new java.awt.Color(228, 0, 121));
        disc_ingles.setOpaque(false);

        escolhe_data.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                escolhe_dataFocusLost(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(divisor_topo_cadastro_professor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_divisoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(divisor_disciplinasMinistradas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_divisoria2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(disc_matematica)
                            .addComponent(disc_portugues))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(disc_ciencia)
                            .addComponent(disc_artes))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(disc_educfisica)
                            .addComponent(disc_geografia))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(disc_religiao)
                                .addGap(10, 10, 10)
                                .addComponent(disc_ingles))
                            .addComponent(disc_historia)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_cidade)
                                            .addComponent(lbl_tel1)
                                            .addComponent(lbl_cpf))
                                        .addGap(16, 16, 16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_endereco)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbl_rg)
                                                .addGap(88, 88, 88)
                                                .addComponent(txt_rg, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txt_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbl_tel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_tel2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lbl_email)
                                                .addGap(41, 41, 41)
                                                .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_nome)
                                            .addComponent(lbl_cep))
                                        .addGap(46, 46, 46)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbl_endereco)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_cidade, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                                            .addComponent(txt_nome))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_nascimento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(escolhe_data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_bairro)
                                        .addGap(10, 10, 10)
                                        .addComponent(txt_bairro)))))))
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_cadastrarProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_alterar)
                        .addGap(18, 18, 18)
                        .addComponent(bt_excluir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(divisor_topo_cadastro_professor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_divisoria)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nome)
                    .addComponent(lbl_nascimento)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(escolhe_data, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_bairro)
                        .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_endereco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_cidade)
                    .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_tel1)
                    .addComponent(txt_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_tel2)
                    .addComponent(txt_tel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_email))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_cpf)
                        .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_rg)
                        .addComponent(txt_rg, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(divisor_disciplinasMinistradas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lbl_divisoria2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(disc_portugues)
                            .addComponent(disc_artes)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(disc_educfisica)
                            .addComponent(disc_religiao)
                            .addComponent(disc_ingles))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(disc_matematica)
                            .addComponent(disc_ciencia)
                            .addComponent(disc_geografia)
                            .addComponent(disc_historia))))
                .addGap(18, 18, 18)
                .addComponent(bt_cadastrarProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txt_tel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tel1ActionPerformed

    private void txt_tel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tel2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tel2ActionPerformed

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltarActionPerformed
        this.dispose();
        new Professores().setVisible(true);
    }//GEN-LAST:event_bt_voltarActionPerformed

    private void txt_cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpfActionPerformed

    private void txt_rgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rgActionPerformed

    private void disc_portuguesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disc_portuguesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_disc_portuguesActionPerformed

    private void disc_matematicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disc_matematicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_disc_matematicaActionPerformed

    private void disc_historiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disc_historiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_disc_historiaActionPerformed

    private void bt_cadastrarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarProfessorActionPerformed
        
        cadastrar_professor();
        
    }//GEN-LAST:event_bt_cadastrarProfessorActionPerformed

    private void disc_educfisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disc_educfisicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_disc_educfisicaActionPerformed

    private void txt_cepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cepKeyReleased
        
        if(txt_cep.getText().length()==8)
        preenche_cep();
        
    }//GEN-LAST:event_txt_cepKeyReleased

    private void escolhe_dataFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_escolhe_dataFocusLost
    {//GEN-HEADEREND:event_escolhe_dataFocusLost
        
    }//GEN-LAST:event_escolhe_dataFocusLost

    private void txt_bairroMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_txt_bairroMouseClicked
    {//GEN-HEADEREND:event_txt_bairroMouseClicked
      
    }//GEN-LAST:event_txt_bairroMouseClicked

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txt_emailActionPerformed
    {//GEN-HEADEREND:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void bt_alterarMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_bt_alterarMouseClicked
    {//GEN-HEADEREND:event_bt_alterarMouseClicked
        update_professor();
    }//GEN-LAST:event_bt_alterarMouseClicked

    private void bt_alterarMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_bt_alterarMousePressed
    {//GEN-HEADEREND:event_bt_alterarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_alterarMousePressed

    private void bt_excluirMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_bt_excluirMouseClicked
    {//GEN-HEADEREND:event_bt_excluirMouseClicked
        delete_professor();
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
            {   new Matricula_Professor().setVisible(true);  }
        }
                                       );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bt_alterar;
    private javax.swing.JButton bt_cadastrarProfessor;
    private javax.swing.JLabel bt_excluir;
    private javax.swing.JButton bt_voltar;
    private javax.swing.JCheckBox disc_artes;
    private javax.swing.JCheckBox disc_ciencia;
    private javax.swing.JCheckBox disc_educfisica;
    private javax.swing.JCheckBox disc_geografia;
    private javax.swing.JCheckBox disc_historia;
    private javax.swing.JCheckBox disc_ingles;
    private javax.swing.JCheckBox disc_matematica;
    private javax.swing.JCheckBox disc_portugues;
    private javax.swing.JCheckBox disc_religiao;
    private javax.swing.JLabel divisor_disciplinasMinistradas;
    private javax.swing.JLabel divisor_topo_cadastro_professor;
    private com.github.lgooddatepicker.components.DatePicker escolhe_data;
    private javax.swing.JLabel lbl_bairro;
    private javax.swing.JLabel lbl_cep;
    private javax.swing.JLabel lbl_cidade;
    private javax.swing.JLabel lbl_cpf;
    private javax.swing.JLabel lbl_divisoria;
    private javax.swing.JLabel lbl_divisoria2;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_endereco;
    private javax.swing.JLabel lbl_nascimento;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_rg;
    private javax.swing.JLabel lbl_tel1;
    private javax.swing.JLabel lbl_tel2;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JTextField txt_cep;
    private javax.swing.JTextField txt_cidade;
    private javax.swing.JTextField txt_cpf;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_endereco;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_rg;
    private javax.swing.JTextField txt_tel1;
    private javax.swing.JTextField txt_tel2;
    // End of variables declaration//GEN-END:variables
}
