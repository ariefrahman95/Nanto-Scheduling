import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Nanto {
    /* VARIABLES */
    private int money;
//    private int time;
    private int energy;
    private int strength;
    private int charm;
    private int brain;
    private int nCandidate;
    private int nItem;
    private Candidate[] candid;
    private Item[] items;
	
	public static int time;
	public static String candidCodes;
	public static String itemCodes;

    /* GETTERS & SETTERS */
    public int getMoney() {return money;}
//    public int getTime() {return time;}
    public int getEnergy() {return energy;}
    public int getStrength() {return strength;}
    public int getCharm() {return charm;}
    public int getBrain() {return brain;}
    public int getnCandidate() {return nCandidate;}
    public int getnItem() {return nItem;}

    public void setMoney(int money) {this.money = money;}
//    public void setTime(int time) {this.time = time;}
    public void setEnergy(int energy) {this.energy = energy;}
    public void setStrength(int strength) {this.strength = strength;}
    public void setCharm(int charm) {this.charm = charm;}
    public void setBrain(int brain) {this.brain = brain;}
    public void setnCandidate(int nCandidate) {this.nCandidate = nCandidate;}
    public void setnItem(int nItem) {this.nItem = nItem;}
    
	/* CONSTRUCTOR */
	public Nanto() {
		candidCodes = new String();
		itemCodes = new String();
	}
	
    /* METHODS */
    public void load(File f){
        Scanner scan = null;
        try{
           scan = new Scanner(f);
        }
        catch(FileNotFoundException e){
           System.exit(0);
        }
        setMoney(scan.nextInt());
		time = scan.nextInt();
//        setTime(scan.nextInt());
        setEnergy(scan.nextInt());
        setStrength(scan.nextInt());
        setCharm(scan.nextInt());
        setBrain(scan.nextInt());
        setnCandidate(scan.nextInt());
		scan.nextLine();
        candid = new Candidate[nCandidate];
        for (int i=0;i<nCandidate;i++) {
			String[] inputs = scan.nextLine().split(" ");
            candid[i] = new Candidate(Integer.parseInt(inputs[0]),
					Integer.parseInt(inputs[1]),Integer.parseInt(inputs[2]),
					inputs[3].toCharArray(),Integer.parseInt(inputs[4]),
					Integer.parseInt(inputs[5]),Integer.parseInt(inputs[6]));
			String concat = Integer.toString(i+1);
			candidCodes += concat;
        }
		System.out.println(candidCodes);
        setnItem(scan.nextInt());
        items = new Item[nItem];
        for (int i=0;i<nItem;i++){
            items[i] = new Item(scan.next().charAt(0),scan.nextInt(),
					scan.nextInt());
			String concat = String.valueOf(items[i].getCode());
			itemCodes += concat;
        }
		System.out.println(itemCodes);
        scan.close();
    }
    public void print(){
        System.out.println(money);
        System.out.println(time);
        System.out.println(energy);
        System.out.println(strength);
        System.out.println(charm);
        System.out.println(brain);
        System.out.println(nCandidate);
        for (int i=0;i<nCandidate;i++){
            candid[i].print();
        }
        System.out.println(nItem);
        for (int i=0;i<nItem;i++){
            items[i].print();
        }
    }
}
