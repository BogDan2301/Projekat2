
public  class GameObject {
		
	private int x;
    private int y;
    private int width;
    private int height;
 
       public GameObject(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            setWidth(width);
            setHeight(height);
        }
        
        public int getX() { 
        	return x; 
        }
        public void setX(int x) { 
        	this.x = x; 
        }
 
        public int getY() {
        	return y; 
        }
        public void setY(int y) {
        	this.y = y; 
        }
 
        public int getWidth() {
        	return width; 
        }
        public void setWidth(int width) {
            if (width <= 0) {
                System.out.println("Greska, width mora biti veci od nule");
            }
            this.width = width;
        }
 
        public int getHeight() { 
        	return height; 
        	}
        public void setHeight(int height) {
            if (height <= 0) {
                System.out.println("Greska, height mora biti veci od nule");
            }
            this.height = height;
        }
        
        public boolean intersects(GameObject obj) {
        	
            return this.x < obj.x + obj.width
                    && this.x + this.width > obj.x
                    && this.y < obj.y + obj.height
                    && this.y + this.height > obj.y;
        }
        

		@Override
		public String toString() {
			return "GameObject @ (" + x + "," + y + ") " + width + "x" + height;
		}
        
    
	}
	