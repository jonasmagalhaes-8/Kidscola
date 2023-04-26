package MVC_Controller;
import MVC_Model.Professor;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;

public class Controller_Professor
{
    private int checkin=0;
    
    //public void Cadastrar_professor(String nome, String nascimento, String telefone1, String telefone2, String cep, String rua, String n_rua, String bairro, String cidade, String email, String cpf, String rg,List<Integer> materias)
    public boolean Cadastrar_professor(String nome, LocalDate nascimento, String telefone1, String telefone2, String cep, String rua, String bairro, String cidade, String email, String cpf, String rg,List<String> materias)
    {
        Professor professor = new Professor();
        professor.setNome(nome);
        if(!professor.getNome().equals(""))
        checkin++;
        else
        erro("Nome");
        
        professor.setdata_nascimento(nascimento);
        if(professor.getData_nascimento()!=null)
        checkin++;
        else
        erro("Data de Nascimento");
        
        professor.setTelefone1(telefone1);
        if(!professor.getTelefone1().equals(""))
        checkin++;
        else
        erro("Telefone 1");
        
        professor.setTelefone2(telefone2);
        if(!professor.getTelefone2().equals(""))
        checkin++;
        else
        erro("Telefone 2");
        
        professor.setCep(cep);
        if(!professor.getCep().equals(""))
        checkin++;
        else
        erro("CEP");
        
        professor.setRua(rua);
        if(!professor.getRua().equals(""))
        checkin++;
        else
        erro("Rua");
        
        professor.setBairro(bairro);
        if(!professor.getBairro().equals(""))
        checkin++;
        else
        erro("Bairro");
        
        professor.setCidade(cidade);
        if(!professor.getCidade().equals(""))
        checkin++;
        else
        erro("Cidade");
        
        professor.setEmail(email);
        if(!professor.getEmail().equals(""))
        checkin++;
        else
        erro("E-mail");
       
        professor.setCpf(cpf);
        if(!professor.getCpf().equals(""))
        checkin++;
        else
        erro("CPF");   
       
        professor.setRg(rg);
        if(!professor.getRg().equals(""))
        checkin++;
        else
        erro("RG");  
       
        if(materias.size()>0)
        {
           professor.setMaterias(materias);
           checkin++;
        }
        else
        {
           JOptionPane.showMessageDialog(null, "O professor deve ministrar pelo menos uma matéria!");
           checkin=0;
        }

        if(checkin==12)
        return professor.Cadastrar_Professor();
        else
        return false;
    }
    
    public List <String> carrega_materias_professor(int id_professor)
    {
        return new Professor().carrega_materias(id_professor);
    }
    
    public Professor recupera_professor(int matricula, String nome, Date nascimento, String telefone1, String telefone2, String email,String cpf, String rg, String cep, String rua,String bairro, String cidade, List<String> materias)
    {
        Professor professor = new Professor(matricula, nome, nascimento, telefone1, telefone2, cep, rua,bairro, cidade,email,cpf,rg,materias);
        return professor;
    }
    
    private void erro(String alvo)
    {
        JOptionPane.showMessageDialog(null, alvo+" informado(a) inválido(a)!");
        checkin=0;
    }
    
    public ResultSet tabela_carrega_professores()
    {
       return new Professor().tabela_carrega_professores();
    }
    
    public List<Professor> carrega_professores()
    {
       return new Professor().carrega_professores();
    }
    
    
    public boolean update_nome(Professor professor,String novo_dado)
    {
        professor.setNome(novo_dado);
        String sql = "UPDATE Professor set nome_professor=? where id_professor=?";
        return new Professor().update_dado_textual(sql,professor.getId_professor(), novo_dado);
    }
    
    public boolean detele_professor(int id_professor)
    {
        String sql = "DELETE FROM Professor where id_professor=?";
        return new Professor().delete(sql,id_professor);
    }
    
    public boolean update_nascimento(Professor professor, LocalDate novo_dado)
    {
        professor.setdata_nascimento(novo_dado);
        
        if(!professor.getData_nascimento().equals(null))
        {
            String sql = "UPDATE Professor set nascimento_professor=? where id_professor=?";
            return new Professor().update_datas(sql,professor.getId_professor(),novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_cep(Professor professor, String novo_dado)
    {
        professor.setCep(novo_dado);
        
        if(!professor.getCep().equals(""))
        {
            String sql = "UPDATE Professor set cep_professor=? where id_professor=?";
            return new Professor().update_dado_textual(sql,professor.getId_professor(), novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_rua(Professor professor, String novo_dado)
    {
        professor.setRua(novo_dado);
        
        if(!professor.getRua().equals(""))
        {
            String sql = "UPDATE Professor set rua_professor=? where id_professor=?";
            return new Professor().update_dado_textual(sql,professor.getId_professor(), novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_bairro(Professor professor, String novo_dado)
    {
        professor.setBairro(novo_dado);
        
        if(!professor.getBairro().equals(""))
        {
            String sql = "UPDATE Professor set bairro_professor=? where id_professor=?";
            return new Professor().update_dado_textual(sql,professor.getId_professor(), novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_cidade(Professor professor, String novo_dado)
    {
        professor.setCidade(novo_dado);
        
        if(!professor.getCidade().equals(""))
        {
            String sql = "UPDATE Professor set cidade_professor=? where id_professor=?";
            return new Professor().update_dado_textual(sql,professor.getId_professor(), novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_telefone1(Professor professor, String novo_dado)
    {
        professor.setTelefone1(novo_dado);
        
        if(!professor.getTelefone1().equals(""))
        {
            String sql = "UPDATE Professor set telefone1_professor=? where id_professor=?";
            return new Professor().update_dado_textual(sql,professor.getId_professor(), novo_dado);
        }
        else
        return false;
    }
    
    public boolean update_telefone2(Professor professor, String novo_dado)
    {
        professor.setTelefone2(novo_dado);
        
        if(!professor.getTelefone2().equals(""))
        {
            String sql = "UPDATE Professor set telefone2_professor=? where id_professor=?";
            return new Professor().update_dado_textual(sql,professor.getId_professor(), novo_dado);
        }
        else
        return false; 
    }
    
    public boolean update_cpf(Professor professor, String novo_dado)
    {
        professor.setCpf(novo_dado);
        if(!professor.getCpf().equals(""))
        {
            String sql = "UPDATE Professor set cpf_professor=? where id_professor=?";
            return new Professor().update_dado_textual(sql,professor.getId_professor(), novo_dado);
        }
        else
        return false; 
    }
    
    public boolean update_rg(Professor professor, String novo_dado)
    {
        professor.setRg(novo_dado);
        if(!professor.getRg().equals(""))
        {
            String sql = "UPDATE Professor set rg_professor=? where id_professor=?";
            return new Professor().update_dado_textual(sql,professor.getId_professor(), novo_dado);
        }
        else
        return false; 
    }
    
    public boolean update_email(Professor professor, String novo_dado)
    {
        professor.setEmail(novo_dado);
        if(!professor.getEmail().equals(""))
        {
            String sql = "UPDATE Professor set email_professor=? where id_professor=?";
            return new Professor().update_dado_textual(sql,professor.getId_professor(), novo_dado);
        }
        else
        return false; 
    }
    
    public boolean update_materias_professor(int id_professor,List <String> materias)
    {
        return new Professor().atualiza_disciplinas_professor(id_professor,materias);
    }
    
    public ResultSet busca_professor(String busca)
    {
        return new Professor().busca_professor(busca);
    }
}