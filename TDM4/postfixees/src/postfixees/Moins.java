package postfixees;
public class Moins  extends Operateur implements Yytoken{

  protected int calcul(int... values){
    return values[1]-values[0];
  }

  public Moins(String image){
    super(image,2);
  }
}
