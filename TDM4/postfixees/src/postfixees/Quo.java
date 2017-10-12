package postfixees;
public class Quo  extends Operateur implements Yytoken{

  protected int calcul(int... values){
    return values[1]/values[0];
  }

  public Quo(String image){
    super(image,2);
  }
}
