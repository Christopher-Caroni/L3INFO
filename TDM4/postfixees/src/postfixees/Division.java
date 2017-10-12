package postfixees;
public class Division  extends Operateur implements Yytoken{

  protected int calcul(int... values){
    return values[1]/values[0];
  }

  public Division(String image){
    super(image,2);
  }
}
