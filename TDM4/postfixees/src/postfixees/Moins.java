package postfixees;
public class Moins  extends Operateur implements Yytoken{

  protected int calcul(int... values){
    return values[0]-values[1];
  }

  public Moins(String image){
    super(image,2);
  }
}
