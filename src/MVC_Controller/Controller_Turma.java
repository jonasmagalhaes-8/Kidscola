package MVC_Controller;

import MVC_Model.Turma;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;

public class Controller_Turma
{
    int checkin=0;
    
    public boolean Cadastrar_turma(String nome_turma, String serie_turma, int ano_turma, String turno_turna, List<String> materias,List<Integer> professores)
    {
       Turma turma = new Turma();
       turma.setSerie_turma(serie_turma);
       turma.setTurno_turna(turno_turna);
       
       if(nome_turma.length()>2)
       {
           turma.setNome_turma(nome_turma);
           checkin++;
       }
       else
       erro("Nome da Turma");
       
       if(ano_turma>1900)
       {
           turma.setAno_turma(ano_turma);
           checkin++;
       }
       else
       erro("Ano Letivo");
       
       if(professores.size()>0)
       checkin++;
       else
       {
           JOptionPane.showMessageDialog(null, "A turma deve conter pelo menos uma matéria/professor!");
           checkin=0;
       }

       if(checkin==3)
       return turma.Cadastrar_Turma(materias,professores);
       else
       return false;
    }
    
    public List<String> Professores_titulares(int id_turma)
    {
        return new Turma().Professores_titulares(id_turma);
    }
    
    public List<Turma> carrega_turmas()
    {
       return new Turma().carrega_turmas();
    }
    
    private void erro(String alvo)
    {
        JOptionPane.showMessageDialog(null, alvo+" informado(a) inválido(a)!");
        checkin=0;
    }
    
    public ResultSet carrega_alunos(int id_turma)
    {
        return new Turma().carrega_alunos(id_turma);
    }
    
    public boolean update_nome(Turma turma,String novo_dado)
    {
        turma.setNome_turma(novo_dado);
        String sql = "UPDATE Turma set nome_turma=? where id_turma=?";
        return new Turma().update_dado_textual(sql,turma.getId_turma(), novo_dado);
    }
    
    public boolean update_escolaridade(Turma turma, String novo_dado)
    {
        turma.setSerie_turma(novo_dado);
        String sql = "UPDATE Turma set serie_turma=? where id_turma=?";
        return new Turma().update_dado_textual(sql,turma.getId_turma(), novo_dado);
    }
    
    public boolean update_ano_letivo(Turma turma, int novo_dado)
    {
        turma.setAno_turma(novo_dado);
        String sql = "UPDATE Turma set ano_turma=? where id_turma=?";
        return new Turma().update_dado_inteiro(sql,turma.getId_turma(), novo_dado);
    }
    
    public boolean update_turno(Turma turma, String novo_dado)
    {
        turma.setTurno_turna(novo_dado);
        String sql = "UPDATE Turma set turno_turma=? where id_turma=?";
        return new Turma().update_dado_textual(sql,turma.getId_turma(), novo_dado);
    }
    
    public boolean atualiza_disciplinas(int id_turma,List<String> materias,List<Integer> professores)
    {
        return new Turma().Update_Disciplinas_Turma(id_turma,materias, professores);
    }
    
    public ResultSet busca_aluno(int id_turma,String busca)
    {
        return new Turma().busca_aluno(id_turma, busca);
    }
    
    public boolean deletar_turma(int id_turma)
    {
        String sql = "DELETE FROM Turma where id_turma=?";
        return new Turma().delete(sql, id_turma);
    }
}
