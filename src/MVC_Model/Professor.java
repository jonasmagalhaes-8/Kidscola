package MVC_Model;

import Class.Dado_DuplicadoBanco;
import Class.validador_cpf;
import Class.validador_de_digitos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Professor extends Pessoa
{  
    private int id_professor=0;
    private String email="",cpf="",rg="";
    private List<String> materias = new ArrayList<>();
    Connection conexao = ModuloConexao.conector();
    private PreparedStatement pst=null;
    private ResultSet rs=null;
   
    public Professor()
    {
        
    }
    
    public Professor(int id_professor,String nome, Date nascimento, String telefone1, String telefone2, String cep, String rua, String bairro, String cidade, String email, String cpf, String rg,List<String> materias)
    {
        this.id_professor = id_professor;
        this.nome = nome;
        this.data_nascimento = nascimento.toLocalDate();
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.materias = materias;
    }
   
    public Professor(String nome, Date nascimento, String telefone1, String telefone2, String cep, String rua, String bairro, String cidade, String email, String cpf, String rg,List<String> materias)
    {
        this.nome = nome;
        this.data_nascimento = nascimento.toLocalDate();
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.materias = materias;
    }
    
    public Professor(int id_professor,String nome)
    {
        this.id_professor = id_professor;
        this.nome = nome;
    }
    
    public int getId_professor()
    {
        return id_professor;
    }
    
    public List<String> getMaterias()
    {
        return materias;
    }

    public void setId_professor(int id_professor)
    {
        this.id_professor = id_professor;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        if(email.length()>=6 && email.contains("@") && email.contains("."))
        this.email = email;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        if(validador_cpf.validador_cpf(cpf))
        this.cpf = cpf;
    }

    public String getRg()
    {
        return rg;
    }

    public void setRg(String rg)
    {
        if(validador_de_digitos.isNumeric(rg)&& rg.length()>=7 && rg.length()<=14)
        this.rg = rg;
    }
    
    public void setMaterias(List<String> materias)
    {
        this.materias = materias;
    }
    
    public boolean Cadastrar_Professor()
    {
        boolean sucesso=false;
        int i=0;
        
        try
        {   conexao.setAutoCommit(false);   }
        catch(Exception e)
        {   JOptionPane.showMessageDialog(null, e);   }
        
        try
        {
            String error=Dado_DuplicadoBanco.checa_telefone2(conexao,"Professor","telefone1_professor","telefone2_professor",getTelefone2());
            
            if(error==null)
            {
                Novo_Professor();
            
                if(getId_professor()!=0)
                {
                    do
                    {
                      sucesso=Materias_Professor(materias.get(i));
                      i++;
                    }
                    while(i<materias.size() && sucesso==true);
                    
                    if(sucesso)
                    conexao.commit();
                    else
                    {
                        conexao.rollback();    
                        conexao.close();
                    }
                    
                    i=0; 
                }
            }
            else
            exibe_dado_duplicado(error);
        }
        catch(Exception e)
        {   
            JOptionPane.showMessageDialog(null,e);
            try
            {   conexao.close();   }
            catch(Exception ex)
            {   JOptionPane.showMessageDialog(null,ex);   }
        }
        
        return sucesso;
    }
    
    private void Novo_Professor()
    {
        String sql="INSERT INTO Professor(nome_professor, nascimento_professor, telefone1_professor, telefone2_professor,email_professor,cpf_professor,rg_professor,cep_professor, rua_professor,bairro_professor,cidade_professor) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try
        {
            pst=conexao.prepareStatement(sql);
            pst.setString(1, getNome());
            pst.setDate(2, java.sql.Date.valueOf(getData_nascimento()));
            pst.setString(3,getTelefone1());
            pst.setString(4, getTelefone2());
            pst.setString(5, getEmail());
            pst.setString(6, getCpf());
            pst.setString(7, getRg());
            pst.setString(8, getCep());
            pst.setString(9, getRua());
            pst.setString(10, getBairro());
            pst.setString(11, getCidade());
            pst.executeUpdate();
            pst.close();
            
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next())
            setId_professor(rs.getInt(1));
            
            rs.close();
        }
        catch(Exception e)
        {   
            String erro=e.toString();
            if(erro.contains("UNIQUE"))
            exibe_dado_duplicado(erro);
            JOptionPane.showMessageDialog(null,e); 
            /*try
            {   conexao.close();   }
            catch(Exception ex)
            {   JOptionPane.showMessageDialog(null,ex);   }*/
        }
    }
    private boolean Materias_Professor(String materia)
    {
        boolean sucesso=false;
        String sql="INSERT INTO Professor_Materia(id_professor, materia) VALUES (?,?)";
        try
        {
            pst=conexao.prepareStatement(sql);
            pst.setInt(1, getId_professor());
            pst.setString(2, materia);
            pst.executeUpdate();
            pst.close();
            sucesso=true;
        }
        catch(Exception e)
        {   
            JOptionPane.showMessageDialog(null,e);
            //Delete_Professor(Prof, conexao);
        }
        return sucesso;
    }
    
    private void exibe_dado_duplicado(String error)
    {
        if(error.contains("telefone1"))
        JOptionPane.showMessageDialog(null, "O Telefone "+getTelefone1()+" já foi cadastrado!");
        else if(error.contains("email"))
        JOptionPane.showMessageDialog(null, "O E-mail "+getEmail()+" já foi cadastrado!");
        else if(error.contains("cpf"))
        JOptionPane.showMessageDialog(null, "O CPF "+getCpf()+" já foi cadastrado!");
        else if(error.contains("rg"))
        JOptionPane.showMessageDialog(null, "O RG "+getRg()+" já foi cadastrado!");
        else if(error.contains("Telefone 2"))
        JOptionPane.showMessageDialog(null, "O Telefone 2"+getTelefone2()+" já foi cadastrado!");   
    }
    
    public ResultSet tabela_carrega_professores()
    {
        try
        {
            pst=conexao.prepareStatement("SELECT * FROM Professor");
            rs=pst.executeQuery();
        }
        catch(Exception e)
        {   JOptionPane.showMessageDialog(null,e);   } 
        return rs;
    }
    
    public ResultSet busca_professor(String busca)
    {
        try
        {
            pst=conexao.prepareStatement("SELECT * FROM Professor WHERE Professor.nome_professor like ?");
            pst.setString(1, busca);
            rs=pst.executeQuery();
        }
        catch(Exception e)
        {   JOptionPane.showMessageDialog(null,e);   } 
        return rs;
    }
    
    public List<String> carrega_materias(int id_professor)
    {
        try
        {
            pst = conexao.prepareStatement("SELECT Professor_Materia.materia FROM Professor_Materia WHERE id_professor=?");
            pst.setInt(1, id_professor);
            rs = pst.executeQuery();
                
            while(rs.next())
            materias.add(rs.getString(1));
        }
        catch(Exception e)
        {
            
        }
        return materias;
    }
    
    public List<Professor> carrega_professores()
    {
        List<Professor> professores = new ArrayList<Professor>();
        
        try
        {
            //pst = conexao.prepareStatement("SELECT * FROM Professor AS prof INNER JOIN Professor_Endereco AS prof_end ON prof.id_professor=prof_end.id_professor;");
            pst = conexao.prepareStatement("SELECT Professor.id_professor, Professor.nome_professor FROM Professor;");
            rs = pst.executeQuery();

            while(rs.next())
            professores.add(new Professor(rs.getInt(1),rs.getString(2)));
            //professores.add(new Professor(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
  
            pst.close();
            rs.close();
            
            int i;
            for(i=0;i<professores.size();i++)
            {
                pst = conexao.prepareStatement("SELECT Professor_Materia.materia FROM Professor_Materia WHERE id_professor=?");
                pst.setInt(1, professores.get(i).getId_professor());
                rs = pst.executeQuery();
                
                while(rs.next())
                professores.get(i).materias.add(rs.getString(1));
            }
        }
        catch (Exception e)
        { JOptionPane.showMessageDialog(null, e); }   
        finally
        {
            try
            { 
              rs.close();
              pst.close();
            }
            catch (Exception e)
            { JOptionPane.showMessageDialog(null,e); }
        } 
        return professores;
    }
    
    public boolean atualiza_disciplinas_professor(int id_professor,List <String> novas_materias)
    {
        boolean sucesso=false;
        int i=0;
        
        try
        {   conexao.setAutoCommit(false);   }
        catch(Exception e)
        {   JOptionPane.showMessageDialog(null, e);   }
        
        try
        {
            this.id_professor = id_professor;
            
            pst=conexao.prepareStatement("DELETE FROM Professor_Materia where id_professor=?");
            pst.setInt(1, this.id_professor);
            pst.executeUpdate();
            sucesso=true;
            
            if(sucesso==true)
            {
                do
                {
                    sucesso=Materias_Professor(novas_materias.get(i));
                    i++;
                }
                while(i<novas_materias.size() && sucesso==true);
            }
            
            if(sucesso)
            conexao.commit();
            else
            {
                conexao.rollback();
                conexao.close();
            }
            i=0; 
            
        }
        catch(Exception e)
        {   
            JOptionPane.showMessageDialog(null,e);
            sucesso=false;
            try
            {   conexao.close();   }
            catch(Exception ex)
            {   JOptionPane.showMessageDialog(null,ex);   }
        }
        
        return sucesso;
    }
    
    @Override
    public String toString()
    {   
        return getNome();
    }
}