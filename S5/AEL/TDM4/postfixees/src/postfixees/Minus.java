package postfixees;
public class Minus  extends Operateur implements Yytoken{

  protected int calcul(int... values){
    return values[1]-values[0];
  }

  public Minus(String image){
    super(image,2);
  }
}
