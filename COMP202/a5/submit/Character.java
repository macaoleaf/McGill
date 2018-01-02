import java.util.ArrayList;
import java.util.Random;
public class Character{
  private String name;
  private double attack;
  private double maxHealth;
  private double currHealth;
  private int numOfWins;
  private static ArrayList<Spell> spells =
             new ArrayList<Spell>(); //attributes
  public static void setSpells(ArrayList<Spell> one) {
    for(Spell n : one) {
      spells.add(n);
    }
  } //spell setter
  public double castSpell(String spellName) {
  	  double damage = 0;
  	  boolean match = false;
  	  String spellLowerCase = spellName.toLowerCase();
  	  	Spell matchSpell = spells.get(0);
    //set an original value of Spell to store possible matched one
  	  for(Spell n : spells) {
  	  	  if((n.getName().toLowerCase()).equals(spellLowerCase)) {
  	  	    match = true;
  	  	    matchSpell = n; //set the matched one to this Spell
  	  	  }
  	  }
  	  if(match) {
  	  		double spellDamage = matchSpell.getDamage();
  	  		if(spellDamage == 0) {
  	  			System.out.println(this.name + " tried to cast " + spellLowerCase +
	               ", but they failed");
  	  		}else {
  	  		  String damageStr = String.format("%1$.2f", spellDamage);
  	  			System.out.println(this.name + " casted " + spellLowerCase +
  	  					               " for damage of " + damageStr);
  	  			damage = spellDamage;
  	  		}
  	  }else {
  	  	  System.out.println(this.name + " tried to cast " + spellLowerCase +
  	  				               ", but they don't know that spell");
  	  }
  	  return damage;
  } //return the damage by the spell
  public Character(String name, double attack, double maxHealth, int numOfWins){
    this.name = name;
    this.attack = attack;
    this.maxHealth = maxHealth;
    this.currHealth = maxHealth;
    this.numOfWins = numOfWins;
  } //constructor
  public String toString(){
    return ("Name: " + this.name + " Health: " + this.currHealth + "\n" +
            "Attack: " + this.attack + "\n" + "Number of Wins: " + this.numOfWins);
  } //toString method
  public String roundInfo() {
  	  String healthStr = String.format("%1$.2f", this.currHealth);
    return ("Name: " + this.name + " Health: " + healthStr);
  } //print out info at the end of each round
  public double calcAttack(){
    Random rand = new Random();
    double times = rand.nextInt(40) + 30;
    double eachAttack = attack * times / 100;
    return eachAttack;
  } //calculate the damage
  public void takeDamage(double n){
    this.currHealth -= n;
  } //lose HP
  public double getCurrHealth(){
    return this.currHealth;
  }
  public String getName(){
    return this.name;
  }
  public double getAttack(){
    return this.attack;
  }
  public double getMaxHealth(){
    return this.maxHealth;
  }
  public int getNumOfWins(){
    return this.numOfWins;
  } //getters
  public void increaseWins(){
    this.numOfWins++;
  }
}