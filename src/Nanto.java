import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

class Nanto {
    /* VARIABLES */
	public static int[][] jCandid = new int[9][84];
    public static int[][] jPlace = new int[4][84];
	public static int money;
	public static int energy;
	public static int strength;
	public static int charm;
	public static int brain;
    public static HashMap<Character, Candidate> candid = new HashMap<> ();
    public static HashMap<Character, Item> items = new HashMap<> ();
	public static int time;
	public static String candidCodes;
	public static String itemCodes;
	public static int nCandidate;
    public static int nItem;
    
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
		money = scan.nextInt();
		time = scan.nextInt();
        energy = scan.nextInt();
        strength = (scan.nextInt());
        charm = (scan.nextInt());
        brain = (scan.nextInt());
		nCandidate = scan.nextInt();
		scan.nextLine();
        for (int i=0;i<nCandidate;i++) {
			String[] inputs = scan.nextLine().split(" ");
            Candidate temp = new Candidate(Integer.parseInt(inputs[0]),
					Integer.parseInt(inputs[1]),Integer.parseInt(inputs[2]),
					inputs[3].toCharArray(),Integer.parseInt(inputs[4]),
					Integer.parseInt(inputs[5]),Integer.parseInt(inputs[6]),
					i);
			candid.put(Integer.toString(i+1).toCharArray()[0], temp);
			String concat = Integer.toString(i+1);
			candidCodes += concat;
        }
        nItem = scan.nextInt();
        for (int i=0;i<nItem;i++){
            Item temp = new Item(scan.next().charAt(0),scan.nextInt(),
					scan.nextInt());
			items.put(temp.getCode(), temp);
			String concat = String.valueOf(temp.getCode());
			itemCodes += concat;
        }
        scan.close();
    }
}
