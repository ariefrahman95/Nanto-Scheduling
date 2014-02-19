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
//        n.print();
        
        int[][] jCandid = new int[4][84];
        int[][] jPlace = new int[4][84];
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
                jCandid[j][i] = Character.getNumericValue(line.charAt(i));
            }
            j += 1;
        }
        scan.close();
        
//        for (int a=0;a<4;a++){
//            for (int b=0;b<84;b++)
//                System.out.print(jCandid[a][b]);
//            System.out.println();
//        }
        
        
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
                jPlace[j][i] = Character.getNumericValue(line.charAt(i));
            }
            j += 1;
        }
        scan.close();
        
//        System.out.println();
//        System.out.println();
//        for (int a=0;a<4;a++){
//            for (int b=0;b<84;b++)
//                System.out.print(jPlace[a][b]);
//            System.out.println();
//        }
		
		System.out.println(Chromosome.generateRandom().getGene());
		System.out.println(Chromosome.generateRandom().getGene());
		System.out.println(Chromosome.generateRandom().getGene());
    }
}