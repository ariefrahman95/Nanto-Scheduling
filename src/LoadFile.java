import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LoadFile {
    public static void main(String[] args) {
        File f1 = new File("info.txt");
        File f2 = new File("kandidat.txt");
        File f3 = new File("tempat.txt");
        Nanto n = new Nanto();
        n.load(f1);
  
        Scanner scan = null;
        try{
           scan = new Scanner(f2);
        }
        catch(FileNotFoundException e){
           System.exit(0);
        }
        int j = 0;
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            for (int i = 0; i < line.length(); i++) {
                Nanto.jCandid[j][i] = Character.getNumericValue(line.charAt(i));
            }
            j += 1;
        }
        scan.close();
        
        scan = null;
        try{
           scan = new Scanner(f3);
        }
        catch(FileNotFoundException e){
           System.exit(0);
        }
        j = 0;
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            for (int i = 0; i < line.length(); i++) {
                Nanto.jPlace[j][i] = Character.getNumericValue(line.charAt(i));
            }
            j += 1;
        }
        scan.close();
		
		System.out.println(Nanto.money + " " + Nanto.time + " " +
				Nanto.energy + " " + Nanto.strength + " " + Nanto.charm + " " +
				Nanto.brain);
		System.out.println(Nanto.nCandidate);
		for(int i = 0; i < Nanto.nCandidate; i++) {
			char code = Nanto.candidCodes.charAt(i);
			System.out.println(Nanto.candid.get(code));
		}
		System.out.println(Nanto.nItem);
		for(int i = 0; i < Nanto.nItem; i++) {
			char code = Nanto.itemCodes.charAt(i);
			System.out.println(Nanto.items.get(code));
		}
		
		System.out.println();
		
		for(int x = 0; x < Nanto.nCandidate; x++) {
			for(int y = 0; y < 84; y++) {
				System.out.print(Nanto.jCandid[x][y]);
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int x = 0; x < 4; x++) {
			for(int y = 0; y < 84; y++) {
				System.out.print(Nanto.jCandid[x][y]);
			}
			System.out.println();
		}
		
		// Test one chromosome's fitness
		Chromosome c1 = Chromosome.generateRandom();
		System.out.println(c1);
                
                GUI giyuai = new GUI();
                giyuai.main(args);
    }
}