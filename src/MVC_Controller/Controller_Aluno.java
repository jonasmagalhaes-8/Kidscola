package MVC_Controller;

import MVC_Model.Aluno;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class Controller_Aluno
{
    private int checkin=0;
    
    public boolean Matricular_Aluno(int id_turma,String nome, LocalDate nascimento, String telefone1, String telefone2, String tel_emergencia,String cep, String rua, String bairro, String cidade, String mae_nome,String tel1_mae,String tel2_mae,String cpf_mae, String rg_mae, String pai_nome,String tel1_pai,String tel2_pai,String cpf_pai, String rg_pai)
    {
        Aluno aluno = new Aluno();
        
        aluno.setId_turma(id_turma);
        checkin++;
        
        aluno.setNome(nome);
        if(!aluno.getNome().equals(""))
        checkin++;
        else
        erro("Nome");
        
        aluno.setdata_nascimento(nascimento);
        if(aluno.getData_nascimento()!=null)
        checkin++;
        else
        erro("Data de Nascimento");
        
        if(telefone1.equals(""))
        checkin++;
        else
        {
            aluno.setTelefone1(telefone1);
            if(!aluno.getTelefone1().equals(""))
            checkin++;
            else
            erro("Telefone 1");
        }
        
        aluno.setTelefone2(telefone2);
        if(!aluno.getTelefone2().equals(""))
        checkin++;
        else
        erro("Telefone 2");
        
        aluno.setCep(cep);
        if(!aluno.getCep().equals(""))
        checkin++;
        else
        erro("CEP");
        
        aluno.setRua(rua);
        if(!aluno.getRua().equals(""))
        checkin++;
        else
        erro("Rua");
        
        aluno.setBairro(bairro);
        if(!aluno.getBairro().equals(""))
        checkin++;
        else
        erro("Bairro");
        
        aluno.setCidade(cidade);
        if(!aluno.getCidade().equals(""))
        checkin++;
        else
        erro("Cidade");
        
        aluno.setNome_mae(mae_nome);
        if(!aluno.getNome_mae().equals(""))
        checkin++;
        else
        erro("Nome da Mãe");
        
        aluno.setCpf_mae(cpf_mae);
        if(!aluno.getCpf_mae().equals(""))
        checkin++;
        else
        erro("CPF da Mãe");
        
        aluno.setRg_mae(rg_mae);
        if(!aluno.getRg_mae().equals(""))
        checkin++;
        else
        erro("RG da Mãe");
        
        aluno.setNome_pai(pai_nome);
        if(!aluno.getNome_pai().equals(""))
        checkin++;
        else
        erro("Nome do Pai");
        
        aluno.setCpf_pai(cpf_pai);
        if(!aluno.getCpf_pai().equals(""))
        checkin++;
        else
        erro("CPF do Pai");
        
        aluno.setRg_pai(rg_pai);
        if(!aluno.getRg_pai().equals(""))
        checkin++;
        else
        erro("RG do Pai");
        
        aluno.setTelefone1_mae(tel1_mae);
        if(!aluno.getTelefone1_mae().equals(""))
        checkin++;
        else
        erro("Telefone 1 da Mãe");
        
        aluno.setTelefone2_mae(tel2_mae);
        if(!aluno.getTelefone2_mae().equals(""))
        checkin++;
        else
        erro("Telefone 2 da Mãe");
        
        aluno.setTelefone1_pai(tel1_pai);
        if(!aluno.getTelefone1_pai().equals(""))
        checkin++;
        else
        erro("Telefone 1 do Pai");
        
        aluno.setTelefone2_pai(tel2_pai);
        if(!aluno.getTelefone2_pai().equals(""))
        checkin++;
        else
        erro("Telefone 2 do Pai");
        
        if(checkin==19)
        return aluno.cadastrar_aluno();
        else
        return false;
    }
    
    public Aluno recupera_aluno(int id_aluno,int id_turma,String nome, Date nascimento, String telefone1, String telefone2, String tel_emergencia,String cep, String rua, String bairro, String cidade, String mae_nome,String tel1_mae,String tel2_mae,String cpf_mae, String rg_mae, String pai_nome,String tel1_pai,String tel2_pai,String cpf_pai, String rg_pai)
    {
        Aluno aluno = new Aluno(nome, nascimento, telefone1, telefone2, cep, rua, bairro, cidade, id_aluno, id_turma, mae_nome, cpf_mae, rg_mae, pai_nome, cpf_pai, rg_pai, tel1_mae, tel2_mae, tel1_pai, tel2_pai, tel_emergencia);
        return aluno;
    }
    
    private void erro(String alvo)
    {
        JOptionPane.showMessageDialog(null, alvo+" informado(a) inválido(a)!");
        checkin=0;
    }
    
    public boolean update_nome(Aluno aluno,String novo_dado)
    {
        aluno.setNome(novo_dado);
        String sql = "UPDATE Aluno set aluno_nome=? where n_matricula=?";
        return new Aluno().update_dado_textual(sql,aluno.getId_aluno(), novo_dado);
    }
    
    public boolean detele_aluno(int id_aluno)
    {
        String sql = "DELETE FROM Aluno where n_matricula=?";
        return new Aluno().delete(sql,id_aluno);
    }
    
    public boolean update_nascimento(Aluno aluno, LocalDate novo_dado)
    {
        aluno.setdata_nascimento(novo_dado);
        
        if(!aluno.getData_nascimento().equals(null))
        {
            String sql = "UPDATE Aluno set aluno_nascimento=? where n_matricula=?";
            return new Aluno().update_datas(sql,aluno.getId_aluno(),novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_cep(Aluno aluno, String novo_dado)
    {
        aluno.setCep(novo_dado);
        
        if(!aluno.getCep().equals(""))
        {
            String sql = "UPDATE Aluno set cep_aluno=? where n_matricula=?";
            return new Aluno().update_dado_textual(sql,aluno.getId_aluno(), novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_rua(Aluno aluno, String novo_dado)
    {
        aluno.setRua(novo_dado);
        
        if(!aluno.getRua().equals(""))
        {
            String sql = "UPDATE Aluno set rua_aluno=? where n_matricula=?";
            return new Aluno().update_dado_textual(sql,aluno.getId_aluno(), novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_bairro(Aluno aluno, String novo_dado)
    {
        aluno.setBairro(novo_dado);
        
        if(!aluno.getBairro().equals(""))
        {
            String sql = "UPDATE Aluno set bairro_aluno=? where n_matricula=?";
            return new Aluno().update_dado_textual(sql,aluno.getId_aluno(), novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_cidade(Aluno aluno, String novo_dado)
    {
        aluno.setCidade(novo_dado);
        
        if(!aluno.getCidade().equals(""))
        {
            String sql = "UPDATE Aluno set cidade_aluno=? where n_matricula=?";
            return new Aluno().update_dado_textual(sql,aluno.getId_aluno(), novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_telefone1(Aluno aluno, String novo_dado)
    {
        aluno.setTelefone1(novo_dado);
        
        if(!aluno.getTelefone1().equals(""))
        {
            String sql = "UPDATE Aluno set telefone1_aluno=? where n_matricula=?";
            return new Aluno().update_dado_textual(sql,aluno.getId_aluno(), novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_telefone2(Aluno aluno, String novo_dado)
    {
        aluno.setTelefone2(novo_dado);
        
        if(!aluno.getTelefone2().equals(""))
        {
            String sql = "UPDATE Aluno set telefone2_aluno=? where n_matricula=?";
            return new Aluno().update_dado_textual(sql,aluno.getId_aluno(), novo_dado);
        }
        else
        return false; 
    }
    
    public boolean update_mae_nome(Aluno aluno, String novo_dado)
    {
        aluno.setNome_mae(novo_dado);
        
        if(!aluno.getNome_mae().equals(""))
        {
            String sql = "UPDATE Aluno set mae_nome=? where n_matricula=?";
            return new Aluno().update_dado_textual(sql,aluno.getId_aluno(), novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_cpf_mae(Aluno aluno, String novo_dado)
    {
        aluno.setCpf_mae(novo_dado);
        
        if(!aluno.getCpf_mae().equals(""))
        {
            String sql = "UPDATE Aluno set cpf_mae=? where n_matricula=?";
            return new Aluno().update_dado_textual(sql,aluno.getId_aluno(), novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_rg_mae(Aluno aluno, String novo_dado)
    {
        aluno.setRg_mae(novo_dado);
        
        if(!aluno.getRg_mae().equals(""))
        {
            String sql = "UPDATE Aluno set rg_mae=? where n_matricula=?";
            return new Aluno().update_dado_textual(sql,aluno.getId_aluno(), novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_telefone1_mae(Aluno aluno, String novo_dado)
    {
        aluno.setTelefone1_mae(novo_dado);
        
        if(!aluno.getTelefone1_mae().equals(""))
        {
            String sql = "UPDATE Aluno set telefone1_mae=? where n_matricula=?";
            return new Aluno().update_dado_textual(sql,aluno.getId_aluno(), novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_telefone2_mae(Aluno aluno, String novo_dado)
    {
        aluno.setTelefone2_mae(novo_dado);
        
        if(!aluno.getTelefone2_mae().equals(""))
        {
            String sql = "UPDATE Aluno set telefone2_mae=? where n_matricula=?";
            return new Aluno().update_dado_textual(sql,aluno.getId_aluno(), novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_pai_nome(Aluno aluno, String novo_dado)
    {
        aluno.setNome_pai(novo_dado);
        
        if(!aluno.getNome_pai().equals(""))
        {
            String sql = "UPDATE Aluno set pai_nome=? where n_matricula=?";
            return new Aluno().update_dado_textual(sql,aluno.getId_aluno(), novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_cpf_pai(Aluno aluno, String novo_dado)
    {
        aluno.setCpf_pai(novo_dado);
        
        if(!aluno.getCpf_pai().equals(""))
        {
            String sql = "UPDATE Aluno set cpf_pai=? where n_matricula=?";
            return new Aluno().update_dado_textual(sql,aluno.getId_aluno(), novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_rg_pai(Aluno aluno, String novo_dado)
    {
        aluno.setRg_pai(novo_dado);
        
        if(!aluno.getRg_pai().equals(""))
        {
            String sql = "UPDATE Aluno set rg_pai=? where n_matricula=?";
            return new Aluno().update_dado_textual(sql,aluno.getId_aluno(), novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_telefone1_pai(Aluno aluno, String novo_dado)
    {
        aluno.setTelefone1_pai(novo_dado);
        
        if(!aluno.getTelefone1_pai().equals(""))
        {
            String sql = "UPDATE Aluno set telefone1_pai=? where n_matricula=?";
            return new Aluno().update_dado_textual(sql,aluno.getId_aluno(), novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_telefone2_pai(Aluno aluno, String novo_dado)
    {
        aluno.setTelefone2_pai(novo_dado);
        
        if(!aluno.getTelefone2_pai().equals(""))
        {
            String sql = "UPDATE Aluno set telefone2_pai=? where n_matricula=?";
            return new Aluno().update_dado_textual(sql,aluno.getId_aluno(), novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_telefone_emergencial(Aluno aluno, String novo_dado)
    {
        aluno.setTelefone_emergencial(novo_dado);
        
        if(!aluno.getTelefone_emergencial().equals(""))
        {
            String sql = "UPDATE Aluno set telefone_emergencial=? where n_matricula=?";
            return new Aluno().update_dado_textual(sql,aluno.getId_aluno(), novo_dado);
        }
        else
        return false; 
    }
    
    public boolean update_aluno_turma(int id_aluno, int nova_turma)
    {
        String sql = "UPDATE Turma_Alunos set id_turma=? where n_matricula=?";
        return new Aluno().update_dado_inteiro(sql,id_aluno, nova_turma);
    }
}
