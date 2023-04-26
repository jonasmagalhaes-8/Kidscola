package MVC_Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Turma
{
    private String nome_turma,serie_turma,turno_turna;
    private int id_turma,ano_turma;
    private Connection conexao = ModuloConexao.conector();
    private PreparedStatement pst=null;
    private ResultSet rs=null;
    
    public Turma()
    {
        
    }
    
    public String getNome_turma()
    {
        return nome_turma;
    }

    public void setNome_turma(String nome_turma)
    {
        this.nome_turma = nome_turma;
    }

    public String getSerie_turma()
    {
        return serie_turma;
    }

    public void setSerie_turma(String serie_turma)
    {
        this.serie_turma = serie_turma;
    }

    public int getAno_turma()
    {
        return ano_turma;
    }

    public void setAno_turma(int ano_turma)
    {
        this.ano_turma = ano_turma;
    }

    public int getId_turma()
    {
        return id_turma;
    }

    public void setId_turma(int id_turma)
    {
        this.id_turma = id_turma;
    }
    
    public String getTurno_turna()
    {
        return turno_turna;
    }

    public void setTurno_turna(String turno_turna)
    {
        this.turno_turna = turno_turna;
    }
    
    public Turma(int id_turma,String nome_turma, String serie_turma, int ano_turma, String turno_turna)
    {
        this.id_turma = id_turma;
        this.nome_turma = nome_turma;
        this.serie_turma = serie_turma;
        this.ano_turma = ano_turma;
        this.turno_turna = turno_turna;
    }
    
    public Turma(String nome_turma, String serie_turma, int ano_turma, String turno_turna)
    {
        this.nome_turma = nome_turma;
        this.serie_turma = serie_turma;
        this.ano_turma = ano_turma;
        this.turno_turna = turno_turna;
    }
    
    public boolean Cadastrar_Turma(List<String> materias, List<Integer> professores)
    {
        boolean sucesso=false;
        int i=0;
        
        try
        {   conexao.setAutoCommit(false);   }
        catch(Exception e)
        {   JOptionPane.showMessageDialog(null, e);   }
        
        try
        {
            Nova_Turma();
            
            if(getId_turma()!=0)
            {
                do
                {
                  sucesso=Disciplinas_Turma(materias.get(i), professores.get(i));
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
    
    private void Nova_Turma()
    {
        String sql="INSERT INTO Turma(nome_turma, serie_turma, ano_turma, turno_turma) VALUES (?,?,?,?)";
        try
        {
            pst=conexao.prepareStatement(sql);
            pst.setString(1, getNome_turma());
            pst.setString(2, getSerie_turma());
            pst.setInt(3, getAno_turma());
            pst.setString(4, getTurno_turna());
            pst.executeUpdate();
            pst.close();
            
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next())
            setId_turma(rs.getInt(1));
            
            rs.close();
        }
        catch(Exception e)
        {   JOptionPane.showMessageDialog(null,e);   }
    }
    
    private boolean Disciplinas_Turma(String materia, int id_professor)
    {
        boolean sucesso=false;
        String sql="INSERT INTO Turma_Disciplinas(id_turma, materia,id_professor) VALUES (?,?,?)";
        try
        {
            pst=conexao.prepareStatement(sql);
            pst.setInt(1, getId_turma());
            pst.setString(2, materia);
            pst.setInt(3, id_professor);
            pst.executeUpdate();
            pst.close();
            sucesso=true;
        }
        catch(Exception e)
        {   JOptionPane.showMessageDialog(null,e);   }
        return sucesso;
    }
    
    public List<Turma> carrega_turmas()
    {
        List<Turma> turmas = new ArrayList<>();
        
        try
        {
            //pst = conexao.prepareStatement("SELECT * FROM Professor AS prof INNER JOIN Professor_Endereco AS prof_end ON prof.id_professor=prof_end.id_professor;");
            pst = conexao.prepareStatement("SELECT * FROM Turma;");
            rs = pst.executeQuery();

            while(rs.next())
            turmas.add(new Turma(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)));

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
        return turmas;
    }
    
    @Override
    public String toString()
    {   
        return getNome_turma();
    } 

    public ResultSet carrega_alunos(int id_turma)
    {
        try
        {
            pst=conexao.prepareStatement("SELECT * FROM Aluno INNER JOIN Turma_Alunos where Turma_Alunos.n_matricula=Aluno.n_matricula AND Turma_Alunos.id_turma=?");
            pst.setInt(1, id_turma);
            rs=pst.executeQuery();
        }
        catch(Exception e)
        {   JOptionPane.showMessageDialog(null,e);   } 
        return rs;
    }
    
    public List <String> Professores_titulares(int id_turma)
    {
        List <String> professores_materias = new ArrayList<>();
        professores_materias.add(" Lista de Professores e Matérias ministradas na Turma:");
        
        String id_professor, nome_professor, materia;
        String sql="SELECT Professor.id_professor, Professor.nome_professor, Turma_Disciplinas.materia FROM Professor INNER JOIN Turma_Disciplinas where Turma_Disciplinas.id_professor=Professor.id_professor AND Turma_Disciplinas.id_turma=?";
        try
        {
            pst=conexao.prepareStatement(sql);
            pst.setInt(1, id_turma);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                id_professor=String.valueOf(rs.getInt(1));
                nome_professor = rs.getString(2);
                materia = rs.getString(3);
                professores_materias.add("ID do Professor: "+id_professor+" || Professor: "+nome_professor+" || Materia: "+materia);
            }
        }
        catch(Exception e)
        {   JOptionPane.showMessageDialog(null,e);   }
        return professores_materias;
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
    
    public boolean delete(String sql, int id_turma)
    {
        boolean sucesso=false;
        try
        {
            pst=conexao.prepareStatement(sql);
            pst.setInt(1, id_turma);
            pst.executeUpdate();
            sucesso=true;
        }
        catch(Exception e)
        {   JOptionPane.showMessageDialog(null,e);   }
        return sucesso;
    }
    
    public boolean Update_Disciplinas_Turma(int id_turma,List<String> materias, List<Integer> professores)
    {
        boolean sucesso=false;
        int i=0;
        
        try
        {   conexao.setAutoCommit(false);   }
        catch(Exception e)
        {   JOptionPane.showMessageDialog(null, e);   }
        
        try
        {
            this.id_turma = id_turma;
            pst=conexao.prepareStatement("DELETE FROM Turma_Disciplinas where id_turma=?");
            pst.setInt(1, this.id_turma);
            pst.executeUpdate();
            sucesso=true;
            
            if(sucesso==true)
            {
                do
                {
                    sucesso=Disciplinas_Turma(materias.get(i), professores.get(i));
                    i++;
                }
                while(i<materias.size() && sucesso==true);
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
    
    public ResultSet busca_aluno(int id_turma,String busca)
    {
        try
        {
            pst=conexao.prepareStatement("SELECT * FROM Aluno INNER JOIN Turma_Alunos where Turma_Alunos.n_matricula=Aluno.n_matricula AND Turma_Alunos.id_turma=? AND Aluno.aluno_nome like ?");
            pst.setInt(1, id_turma);
            pst.setString(2, busca);
            rs=pst.executeQuery();
        }
        catch(Exception e)
        {   JOptionPane.showMessageDialog(null,e);   } 
        return rs;
    }
}
