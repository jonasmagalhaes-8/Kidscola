package MVC_Model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ModuloConexao
{
    public static Connection conector()
    {
      Connection conexao = null;
      try
      {
        Class.forName("org.sqlite.JDBC");
	conexao = DriverManager.getConnection("jdbc:sqlite:banco/kidscola.db"); 
        return conexao;
      }
      catch(Exception ex)
      {   JOptionPane.showMessageDialog(null,ex); 
          return null;
      }
   }
}