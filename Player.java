
public class Player extends GameObject {
	
	private String name;
    private int health;

    public Player(String name, int x, int y, int width, int height, int health) {
        super(x, y, width, height);
        setName(name);
        setHealth(health);
    }

    public String getName() { return name; }

 
    public void setName(String name) {
    	if( name.trim().equals("")) {
			System.out.println("Ne moze biti prazno");
		}
    	
    	
        String[] rijeci = name.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rijeci.length; i++) {
            String r = rijeci[i];
            sb.append(Character.toUpperCase(r.charAt(0)))
              .append(r.substring(1).toLowerCase());
            if (i < rijeci.length - 1) {
                sb.append(" ");
            }
        }
        this.name = sb.toString();
    }

    public int getHealth() { return health; }

 
    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        } else if (health > 100) {
            this.health = 100;
        } else {
            this.health = health;
        }
    }

    @Override
    public String toString() {
        return "Player[" + name + "] @ (" + getX() + "," + getY() + ") "
                + getWidth() + "x" + getHeight() + " HP=" + health;
    }
}


