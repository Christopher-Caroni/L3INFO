package postfixees;
public class Valeur  extends AbstractToken implements Yytoken {
  public final int value;
  public int value(){
    return value;
  }
  public Valeur(String image){
    super(image.trim());
    this.value = Integer.parseInt(this.image.trim());
  }
}
