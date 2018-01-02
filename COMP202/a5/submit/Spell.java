import java.util.Random;
public class Spell {
	private String name;
	private double minDamage;
	private double maxDamage;
	private double spellChance;
	public Spell(String name, double minDamage, double maxDamage,
			         double spellChance) {
		this.name = name;
		if(minDamage >= 0 && minDamage <= maxDamage &&
			 spellChance >= 0 && spellChance <= 1) {
			this.minDamage = minDamage;
			this.maxDamage = maxDamage;
			this.spellChance = spellChance;
		}else {
			throw new IllegalArgumentException("Invalid data!");
		}
	}
	public String getName() {
		return this.name;
	} //name getter
	public double getDamage() {
		Random rand = new Random();
		double damage = 0;
		double chance = rand.nextDouble();
		if(chance <= this.spellChance) {
			damage = this.minDamage + rand.nextDouble() *
					     (this.maxDamage - this.minDamage); 
		}
		return damage;
	}
	public String toString() {
		double percent = this.spellChance * 100;
		return "Name: " + this.name + " Damage: " + this.minDamage + 
				   "-" + this.maxDamage + " Chance: " + percent + "%";
	}
	
	//main method for tests
	public static void main(String[] args) {
		Spell one = new Spell("A", 0.3, 0.9, 0.7);
		System.out.println(one.getDamage());
	}
}
