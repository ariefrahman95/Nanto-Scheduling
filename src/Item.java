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
    public int getCode() {return code;}
    public int getPrice() {return price;}
    public int getRestock() {return restock;}
    
    public void setCode(char code) {this.code = code;}
    public void setPrice(int price) {this.price = price;}
    public void setRestock(int restock) {this.restock = restock;}
    
    /* METHODS */
    public void print(){
        System.out.println(code);
        System.out.println(price);
        System.out.println(restock);
    }
}