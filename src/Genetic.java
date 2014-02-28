
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
* The MIT License
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
* 
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
*/

/**
 * This class is strictly used for an entry point into the simulation itself,
 * it has no other functionality.
 * 
 * @author Arief Rahman
 * @version Tubes 1
 */
public class Genetic {

	/**
	 * The main method used for execution of the application.
	 * 
	 * @param args Command-line arguments (ignored).
	 */
       public static void load(File f2,File f3){
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
        }
       
        public static void Export(Chromosome best) throws IOException{
            FileWriter fw = new FileWriter("hasil.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.print(best.getGene());
            pw.flush();
            pw.close();
            fw.close();
        }
    
	public static void main(String[] args) throws IOException {
		File f1 = new File("info.txt");
        File f2 = new File("kandidat.txt");
        File f3 = new File("tempat.txt");
        Nanto n = new Nanto();
        n.load(f1);
        load(f2,f3);
		
		// The size of the simulation population
		final int populationSize = 6;
		
		// The maximum number of generations for the simulation.
		final int maxGenerations = 30000;
		
		// The probability of crossover for any member of the population,
		// where 0.0 <= crossoverRatio <= 1.0
		final float crossoverRatio = 0.2f;
		
		// The portion of the population that will be retained without change
		// between evolutions, where 0.0 <= elitismRatio < 1.0
		final float elitismRatio = 0.1f;
		
		// The probability of mutation for any member of the population,
		// where 0.0 <= mutationRatio <= 1.0
		final float mutationRatio = 0.4f;
	
		// Get the current run time.  Not very accurate, but useful for 
		// some simple reporting.
		long startTime = System.currentTimeMillis();
		
		// Create the initial population
		Population pop = new Population(populationSize, crossoverRatio, 
				elitismRatio, mutationRatio);

		// Start evolving the population, stopping when the maximum number of
		// generations is reached, or when we find a solution.
		int i = 0;
		Chromosome best = pop.getPopulation()[0];
//		for (int a=0;a<populationSize;a++){
//                    System.out.println("INIT " + a + " " + pop.getPopulation()[a] );
//                }
		// Threshold
		// By iterations
		// i++ <= maxGenerations
		// By minimum enlightenment (example highscore : 90)
		// best.getFitness() < 90
		
		while (i++ <= maxGenerations) {
			pop.evolve();
			best = pop.getPopulation()[0];
                        //for (int a=0;a<populationSize;a++){
                            //System.out.println("CROSS " + a + " " + pop.cross.get(a) );
                            //System.out.println("MUTATE " + a + " " + pop.mutate.get(a) );
                        //}
                        //ngambil hasil cross pake "pop.cross.get(GENkeBERAPA)"
                        //ngambil hasil mutate pake "pop.mutate.get(GENkeBERAPA)"
		}
		
		// Get the end time for the simulation.
		long endTime = System.currentTimeMillis();
		
		// Print out some information to the console.
        Export(best);
		System.out.println("Best Gene    " + i + ": " + best.getGene());
		System.out.println("Gene Fitness " + i + ": " + best.getFitness());
		System.out.println("Total execution time: " + (endTime - startTime) + 
				"ms");
	}
}