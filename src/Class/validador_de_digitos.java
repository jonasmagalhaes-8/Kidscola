package Class;

//Referencia: https://mkyong.com/java/java-how-to-check-if-a-string-is-numeric/

public class validador_de_digitos
{
    public static boolean isNumeric(final String str)
    {
        for (char c:str.toCharArray())
        {
          if (!Character.isDigit(c))
          return false;
        }
        return true;
    }
}