package MVC_Model;

import Class.validador_de_digitos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.sql.Date;
import javax.swing.JOptionPane;

public abstract class Pessoa
{
    String nome, telefone1,telefone2,cep,rua,bairro,cidade;
    LocalDate data_nascimento;
    
    Connection conexao = ModuloConexao.conector();
    private PreparedStatement pst=null;
    private ResultSet rs=null;
    
    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        if(nome.length()>2)
        this.nome = nome;
        else
        this.nome = "";
    }

    public void setdata_nascimento(LocalDate nascimento)
    {
        if(nascimento!=null)
        this.data_nascimento=nascimento;
        else
        this.data_nascimento=null;
    }
    
    public LocalDate getData_nascimento()
    {
        return data_nascimento;
    }
    

    public String getTelefone1()
    {
        return telefone1;
    }

    public void setTelefone1(String telefone1)
    {
        if(validador_de_digitos.isNumeric(telefone1) && telefone1.length()==11)
        this.telefone1 = telefone1;
        else
        this.telefone1 = "";
    }

    public String getTelefone2()
    {
        return telefone2;
    }

    public void setTelefone2(String telefone2)
    {
        if(telefone2.length()==0)
        this.telefone2="Não informado";
        else if(validador_de_digitos.isNumeric(telefone2) && telefone2.length()==11 && !telefone2.equals(this.telefone1))
        this.telefone2 = telefone2;
        else
        this.telefone2="";
    }

    public String getCep()
    {
        return cep;
    }

    public void setCep(String cep)
    {
        if(validador_de_digitos.isNumeric(cep) && cep.length()==8)
        this.cep = cep;
        else
        this.cep = "";
    }

    public String getRua()
    {
        return rua;
    }

    public void setRua(String rua)
    {
        if(rua.length()>0)
        this.rua = rua;
        else
        this.rua= "";
    }

    public String getBairro()
    {
        return bairro;
    }

    public void setBairro(String bairro)
    {
        if(bairro.length()>0)
        this.bairro = bairro;
        else
        this.bairro = "";
    }

    public String getCidade()
    {
        return cidade;
    }

    public void setCidade(String cidade)
    {
        if(cidade.length()>0)
        this.cidade = cidade;
        else
        this.cidade = "";
    }
    
    public boolean update_dado_textual(String sql,int id, String novo_dado)
    {
        boolean sucesso=true;
        try
        {
            pst=conexao.prepareStatement(sql);
            pst.setString(1, novo_dado);
            pst.setInt(2, id);
            pst.executeUpdate();
        }
        catch (Exception e)
        { 
            sucesso=false;
            JOptionPane.showMessageDialog(null,e);
        } 
        finally
        {
            try
            { conexao.close(); }
            catch (Exception e)
            { JOptionPane.showMessageDialog(null,e); }
        }
        return sucesso;
    }
    
    public boolean update_dado_inteiro(String sql, int id, int novo_dado)
    {
        boolean sucesso=true;
        try
        {
            pst=conexao.prepareStatement(sql);
            pst.setInt(1, novo_dado);
            pst.setInt(2, id);
            pst.executeUpdate();
        }
        catch (Exception e)
        { 
            sucesso=false;
            JOptionPane.showMessageDialog(null,e);
        } 
        finally
        {
            try
            { conexao.close(); }
            catch (Exception e)
            { JOptionPane.showMessageDialog(null,e); }
        }
        return sucesso;
    }
        
    
    public boolean update_datas(String sql,int id, LocalDate novo_dado)
    {
        boolean sucesso=false;
        try
        {
            pst=conexao.prepareStatement(sql);
            pst.setDate(1, java.sql.Date.valueOf(novo_dado));
            pst.setInt(2, id);
            pst.executeUpdate();
            sucesso=true;
        }
        catch (Exception e)
        { 
            sucesso=false;
            JOptionPane.showMessageDialog(null,e);
        } 
        finally
        {
            try
            { conexao.close(); }
            catch (Exception e)
            { JOptionPane.showMessageDialog(null,e); }
        }
        return sucesso;
    }
    
    public boolean delete(String sql, int id_aluno)
    {
        boolean sucesso=false;
        try
        {
            pst=conexao.prepareStatement(sql);
            pst.setInt(1, id_aluno);
            pst.executeUpdate();
            sucesso=true;
        }
        catch(Exception e)
        {   JOptionPane.showMessageDialog(null,e);   }
        return sucesso;
    }
    
}
