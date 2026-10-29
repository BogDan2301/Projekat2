
public class Enemy extends GameObject {
	
	private String type;
    private int damage;
    private int health;

    public Enemy(String type, int x, int y, int width, int height, int damage, int health) {
        super(x, y, width, height);
        setType(type);
        setDamage(damage);
        setHealth(health);
    }

    public String getType() { return type; }

    public void setType(String type) {
    	if(type.trim() == ("")) {
			System.out.println("Tip neprijatelja ne smije biti prazan.");
		} else {
			this.type = type.trim();
		}
    }

    public int getDamage() { return damage; }

    public void setDamage(int damage) {
        if (damage < 0 || damage > 100) {
            System.out.println("Damage mora biti izmedju 0 i 100");
        }
        this.damage = damage;
    }

    public int getHealth() { return health; }

    public void setHealth(int health) {
        if (health < 0 || health > 100) {
            System.out.println("Health mora biti izmedju 0 i 100");
        }
        this.health = health;
    }
    
    public int getEffectiveDamage() {
        return damage;
    }
    
    public static Enemy fromString (String s) {
    	
        String[] dijelovi = s.split(";");
        String type = dijelovi[0].trim();

        String[] pozicija = dijelovi[1].split(",");
        int x = Integer.parseInt(pozicija[0].trim());
        int y = Integer.parseInt(pozicija[1].trim());

        String[] dimenzije = dijelovi[2].toLowerCase().split("x");
        int width = Integer.parseInt(dimenzije[0].trim());
        int height = Integer.parseInt(dimenzije[1].trim());

        int damage = Integer.parseInt(dijelovi[3].trim());

        boolean boss = dijelovi.length > 4 && dijelovi[4].trim().toLowerCase().equals("boss");
        if (boss) {
            return new BossEnemy(type, x, y, width, height, damage, 100);
        }
        return new MeleeEnemy(type, x, y, width, height, damage, 100);
    }
    
    @Override
    public String toString() {
        return "Enemy[" + type + "] @ (" + getX() + "," + getY() + ") "
                + getWidth() + "x" + getHeight() + " DMG=" + damage + " HP=" + health;
    }
}



