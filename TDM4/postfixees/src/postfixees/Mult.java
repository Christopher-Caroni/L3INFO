package postfixees;
public class Facteur  extends Operateur implements Yytoken{

  protected int calcul(int... values){
    return values[0]*values[1];
  }

  public Facteur(String image){
    super(image,2);
  }
}
