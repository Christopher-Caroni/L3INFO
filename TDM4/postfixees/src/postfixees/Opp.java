package postfixees;
public class Division  extends Operateur implements Yytoken{

  protected int calcul(int... values){
    return -values[0];
  }

  public Division(String image){
    super(image,2);
  }
}
