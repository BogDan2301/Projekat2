import java.util.ArrayList;

public class Game {

	private Player player;
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private ArrayList<String> eventLog = new ArrayList<String>();
 
    
    public Game(Player player) {
        this.player = player;
        
    }
    
    public boolean checkCollision(Player p, Enemy e) {
        return p.intersects(e);
    }
    
    public void decreaseHealth(Player p, Enemy e) {
        int oldHp = p.getHealth();
        int dmg = e.getEffectiveDamage();
        int newHp = oldHp - dmg;
        p.setHealth(newHp);
 
        eventLog.add("HIT: " + p.getName() + " by " + e.getType()
                + " for " + dmg + " -> HP " + oldHp + " -> " + p.getHealth());
    }
    
    public void addEnemy(Enemy e) {
        enemies.add(e);
        eventLog.add("ADDED: " + e);
    }
    
    public ArrayList<Enemy> findByType(String query) {
        String q = query.trim().toLowerCase();
        ArrayList<Enemy> rezultat = new ArrayList<Enemy>();
        for (Enemy e : enemies) {
            if (e.getType().toLowerCase().contains(q)) {
                rezultat.add(e);
            }
        }
        return rezultat;
    }
    
    public ArrayList<Enemy> collidingWithPlayer() {
        ArrayList<Enemy> rezultat = new ArrayList<Enemy>();
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                rezultat.add(e);
            }
        }
        return rezultat;
    }
    
    public void resolveCollisions() {
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                decreaseHealth(player, e);
            }
        }
    }
    
	public static void main(String[] args) {
		
		Player p = new Player("  peTar   petrović ", 10, 5, 32, 32, 85);
        Game game = new Game(p);
        
        game.addEnemy(new MeleeEnemy("Goblin", 12, 5, 16, 16, 20, 60));
        game.addEnemy(Enemy.fromString("Goblin Boss;20,10;16x16;15;boss"));
        game.addEnemy(new MeleeEnemy("Orc", 200, 200, 20, 20, 30, 80));
        
        System.out.println("-- Svi neprijatelji --");
        for (Enemy e : game.enemies) {
            System.out.println(e);
        }
 
        System.out.println("--- Tip sadrži 'gob' ---");
        for (Enemy e : game.findByType("gob")) {
            System.out.println(e);
        }
 
        System.out.println("--- Kolizije ---");
        System.out.println("U koliziji sa igracem: " + game.collidingWithPlayer().size());
        System.out.println("Prije:   " + p);
        game.resolveCollisions();
        System.out.println("Poslije: " + p);
 
        System.out.println("--- Event log ---");
        for (String zapis : game.eventLog) {
            System.out.println(zapis);
        }
    }
}
