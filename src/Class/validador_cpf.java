package Class;

public class validador_cpf
{
  public static boolean validador_cpf(String cpf)
  {
    boolean valido=false;
    
    if(cpf.length()==11)
    {
        int digito,i,multiplicador=0,somatorio=0;

        for(i=0;i<=8;i++)
        {
          multiplicador++;
          digito = Character.getNumericValue(cpf.charAt(i));
          somatorio = somatorio + (digito*multiplicador);
        }

        int dverificador1 = somatorio%11;

        if(dverificador1==10)
        dverificador1=0;

        somatorio=0;
        multiplicador=-1;
        for(i=0;i<=9;i++)
        {
          multiplicador++;
          if(i!=9)
          {
            digito = Character.getNumericValue(cpf.charAt(i));
            somatorio = somatorio + (digito*multiplicador);   
          }
          else
          somatorio = somatorio+(dverificador1*i);
        }

        int dverificador2 = somatorio%11;
        if(dverificador2==10)
        dverificador2=0;

        String digitos_verificadores = Integer.toString(dverificador1).concat(Integer.toString(dverificador2));

        if(cpf.substring(cpf.length()-2).equals(digitos_verificadores))
        valido=true;
    }
    return valido;
  }
}