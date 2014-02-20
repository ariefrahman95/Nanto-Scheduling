class Item {
    /* VARIABLES */
    private char code;
    private int price;
    private int restock;
    
    public Item(char code, int price, int restock){
        this.code = code;
        this.price = price;
        this.restock = restock;
    }
    
    /* GETTERS & SETTERS */
    public char getCode() {return code;}
    public int getPrice() {return price;}
    public int getRestock() {return restock;}
    
    public void setCode(char code) {this.code = code;}
    public void setPrice(int price) {this.price = price;}
    public void setRestock(int restock) {this.restock = restock;}
    
    /* METHODS */
    @Override
	public String toString() {
		String temp = code + " " + price + " " + restock;
		return temp;
	}
}