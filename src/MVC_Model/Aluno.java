package MVC_Model;

import Class.validador_cpf;
import Class.validador_de_digitos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Aluno extends Pessoa
{
    private int id_aluno,id_turma;
    private String nome_mae,cpf_mae,rg_mae,nome_pai,cpf_pai,rg_pai,telefone1_mae,telefone2_mae,telefone1_pai,telefone2_pai,telefone_emergencial;
    
    Connection conexao = ModuloConexao.conector();
    private PreparedStatement pst=null;

    public Aluno()
    {
        
    }
    
    public Aluno(String nome, Date nascimento, String telefone1, String telefone2, String cep, String rua, String bairro, String cidade,int id_aluno, int id_turma, String nome_mae, String cpf_mae, String rg_mae, String nome_pai, String cpf_pai, String rg_pai, String telefone1_mae, String telefone2_mae, String telefone1_pai, String telefone2_pai, String telefone_emergencial)
    {
        this.nome = nome;
        this.data_nascimento = nascimento.toLocalDate();
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.id_aluno = id_aluno;
        this.id_turma = id_turma;
        this.nome_mae=nome_mae;
        this.cpf_mae=cpf_mae;
        this.rg_mae=rg_mae;
        this.nome_pai=nome_pai;
        this.cpf_pai=cpf_pai;
        this.rg_pai=rg_pai;
        this.telefone1_mae=telefone1_mae;
        this.telefone2_mae=telefone2_mae;
        this.telefone1_pai=telefone1_pai;
        this.telefone2_pai=telefone2_pai;
        this.telefone_emergencial = telefone_emergencial;
    }
    
    public int getId_aluno()
    {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno)
    {
        this.id_aluno = id_aluno;
    }
    
    public int getId_turma()
    {
        return id_turma;
    }

    public void setId_turma(int id_turma)
    {
        this.id_turma = id_turma;
    }
    
    public String getNome_mae()
    {
        return nome_mae;
    }

    public void setNome_mae(String nome_mae)
    {
        if(nome_mae.length()>3)
        this.nome_mae = nome_mae;
        else
        this.nome_mae = "";      
    }

    public String getNome_pai()
    {
        return nome_pai;
    }

    public void setNome_pai(String nome_pai)
    {
        if(nome_pai.equals(""))
        this.nome_pai = "Não informado";
        else
        this.nome_pai = nome_pai;
    }
    
    public String getCpf_mae()
    {
        return cpf_mae;
    }

    public void setCpf_mae(String cpf_mae)
    {
        if(validador_cpf.validador_cpf(cpf_mae))
        this.cpf_mae = cpf_mae;
        else
        this.cpf_mae="";
    }

    public String getRg_mae()
    {
        return rg_mae;
    }

    public void setRg_mae(String rg_mae)
    {
        if(validador_de_digitos.isNumeric(rg_mae)&& rg_mae.length()>=7 && rg_mae.length()<=14)
        this.rg_mae = rg_mae;
        else
        this.rg_mae="";
    }

    public String getCpf_pai()
    {
        return cpf_pai;
    }

    public void setCpf_pai(String cpf_pai)
    {
        if(cpf_pai.equals(""))
        this.cpf_pai="Não informado";
        else if(validador_cpf.validador_cpf(cpf_pai))
        this.cpf_pai = cpf_pai;
        else
        this.cpf_pai="";
    }

    public String getRg_pai()
    {
        return rg_pai;
    }

    public void setRg_pai(String rg_pai)
    {
        if(rg_pai.equals(""))
        this.rg_pai="Não informado";
        else if(validador_de_digitos.isNumeric(rg_pai)&& rg_pai.length()>=7 && rg_pai.length()<=14)
        this.rg_pai = rg_pai;
        else
        this.rg_pai="";
    }

    public String getTelefone1_mae()
    {
        return telefone1_mae;
    }

    public void setTelefone1_mae(String telefone_mae)
    {
        if(validador_de_digitos.isNumeric(telefone_mae) && telefone_mae.length()==11)
        this.telefone1_mae = telefone_mae;
        else
        this.telefone1_mae="";
    }

    public String getTelefone1_pai()
    {
        return telefone1_pai;
    }

    public void setTelefone1_pai(String telefone_pai)
    {
        if(telefone_pai.equals(""))
        this.telefone1_pai="Não informado";
        else if(validador_de_digitos.isNumeric(telefone_pai) && telefone_pai.length()==11)
        this.telefone1_pai = telefone_pai;
        else
        this.telefone1_pai="";
    }

    public String getTelefone2_mae()
    {
        return telefone2_mae;
    }

    public void setTelefone2_mae(String telefone2_mae)
    {
        if(telefone2_mae.equals(""))
        this.telefone2_mae="Não informado";
        else if(validador_de_digitos.isNumeric(telefone2_mae) && telefone2_mae.length()==11)
        this.telefone2_mae = telefone2_mae;
        else
        this.telefone2_mae="";
    }

    public String getTelefone2_pai()
    {
        return telefone2_pai;
    }

    public void setTelefone2_pai(String telefone2_pai)
    {
        if(telefone2_pai.equals(""))
        this.telefone2_pai="Não informado";
        else if(validador_de_digitos.isNumeric(telefone2_pai) && telefone2_pai.length()==11)
        this.telefone2_pai = telefone2_pai;
        else
        this.telefone2_pai="";
    }
    
    public String getTelefone_emergencial()
    {
        return telefone_emergencial;
    }

    public void setTelefone_emergencial(String telefone_emergencial)
    {
        if(validador_de_digitos.isNumeric(telefone_emergencial) && telefone_emergencial.length()==11)
        this.telefone_emergencial = telefone_emergencial;
        else if(telefone_emergencial.length()==0)
        this.telefone_emergencial="Não informado";
        else
        this.telefone_emergencial="";
    }

    public boolean cadastrar_aluno()
    {
        boolean sucesso=false;
        
        try
        {   conexao.setAutoCommit(false);   }
        catch(Exception e)
        {   JOptionPane.showMessageDialog(null, e);   }
        
        try
        {
            Novo_Aluno();
            
            if(getId_aluno()!=0)
            {
                sucesso=Aluno_Turma();
                if(sucesso)
                conexao.commit();
                else
                {
                    conexao.rollback();
                    conexao.close();
                }
            }
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
    
    private void Novo_Aluno()
    {
        String sql="INSERT INTO Aluno(aluno_nome,aluno_nascimento,mae_nome,pai_nome,cpf_mae,rg_mae,cpf_pai,rg_pai,cep_aluno,rua_aluno,bairro_aluno,cidade_aluno,telefone1_aluno,telefone2_aluno,telefone1_pai,telefone2_pai,telefone1_mae,telefone2_mae,telefone_emergencial) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try
        {
            pst=conexao.prepareStatement(sql);
            pst.setString(1, getNome());
            pst.setDate(2, java.sql.Date.valueOf(getData_nascimento()));
            pst.setString(3,getNome_mae());
            pst.setString(4,getNome_pai());
            pst.setString(5,getCpf_mae());
            pst.setString(6,getRg_mae());
            pst.setString(7,getCpf_pai());
            pst.setString(8,getRg_pai());
            pst.setString(9, getCep());
            pst.setString(10, getRua());
            pst.setString(11, getBairro());
            pst.setString(12, getCidade());
            pst.setString(13, getTelefone1());
            pst.setString(14, getTelefone2());
            pst.setString(15, getTelefone1_pai());
            pst.setString(16, getTelefone2_pai());
            pst.setString(17, getTelefone1_mae());
            pst.setString(18, getTelefone2_mae());
            pst.setString(19, getTelefone_emergencial());
            pst.executeUpdate();
            pst.close();
            
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next())
            setId_aluno(rs.getInt(1));
            
            rs.close();
        }
        catch(Exception e)
        {   
            JOptionPane.showMessageDialog(null,e);
            try
            {   conexao.close();   }
            catch(Exception ex)
            {   JOptionPane.showMessageDialog(null,ex);   }
        }
    }
    
    private boolean Aluno_Turma()
    {
        boolean sucesso=false;
        String sql="INSERT INTO Turma_Alunos(id_turma,n_matricula) VALUES (?,?)";
        try
        {
            pst=conexao.prepareStatement(sql);
            pst.setInt(1, getId_turma());
            pst.setInt(2, getId_aluno());
            pst.executeUpdate();
            pst.close();
            sucesso=true;
        }
        catch(Exception e)
        {   
            try
            {   conexao.close();   }
            catch(Exception ex)
            {   JOptionPane.showMessageDialog(null,ex);   }
            JOptionPane.showMessageDialog(null,e);
        }
        return sucesso;
    }
}
