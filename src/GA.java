
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TOSHIBA
 */
public class GA extends javax.swing.JFrame {

    public class GARunnable implements Runnable {

        // The size of the simulation population
		final int populationSize = 6;
		
		// The maximum number of generations for the simulation.
		final int maxGenerations = 30000;
		
		// The probability of crossover for any member of the population,
		// where 0.0 <= crossoverRatio <= 1.0
		final float crossoverRatio = 0.5f;
		
		// The portion of the population that will be retained without change
		// between evolutions, where 0.0 <= elitismRatio < 1.0
		final float elitismRatio = 0.2f;
		
		// The probability of mutation for any member of the population,
		// where 0.0 <= mutationRatio <= 1.0
		final float mutationRatio = 0.9f;

        // Create the initial population
        Population pop = null;

        int i = 0;

        Chromosome best = null;
    
        GA ga = null;
        
        public void setGA(GA ga) {
            this.ga = ga;
        }
        
        @Override
        public void run() {
            // Get the current run time.  Not very accurate, but useful for 
            // some simple reporting.
            //long startTime = System.currentTimeMillis();
            
            // Create the initial population
            pop = new Population(populationSize, crossoverRatio, 
				elitismRatio, mutationRatio);
            
            // Start evolving the population, stopping when the maximum number of
            // generations is reached, or when we find a solution.
            best = pop.getPopulation()[0];
            //for (int a=0;a<populationSize;a++){
                //System.out.println("INIT " + a + " " + pop.getPopulation()[a] );
            //}

            // Threshold
            // By iterations
            // i++ <= maxGenerations
            // By minimum enlightenment (example highscore : 90)
            // best.getFitness() < 90

            while (i++ <= maxGenerations) {
                ga.genes.clear();
                for (int i = 0; i < pop.getPopulation().length; i++) {
                    ga.genes.add(pop.getPopulation()[i].getGene());
                    ga.genes.add("Fitness: " + pop.getPopulation()[i].getFitness());
                }
                ga.generation++;
                
                /*ga.dnas.clear();
                for (int i = 0; i < pop.getPopulation().length; i++) {
                    ArrayList<JLabel> labels = new ArrayList<>();
                    for (int j = 0; j < pop.getPopulation()[i].getGene().length(); j++) {
                        String s = "";
                        s += pop.getPopulation()[i].getGene().charAt(i);
                        JLabel label = new JLabel(s);
                        labels.add(label);
                    }
                    ArrayList<JLabel> fitnesss = new ArrayList<>();
                    String s = "Fitness: ";
                    s += pop.getPopulation()[i].getFitness();
                    JLabel label = new JLabel(s);
                    fitnesss.add(label);
                    ga.dnas.add(labels);
                    ga.dnas.add(fitnesss);
                }*/
                
                ga.invalidate();
                ga.validate();
                
                pop.evolve();
                best = pop.getPopulation()[0];
                //for (int a=0;a<populationSize;a++){
                    //System.out.println("CROSS " + a + " " + pop.cross.get(a) );
                    //System.out.println("MUTATE " + a + " " + pop.mutate.get(a) );
                //}
                //ngambil hasil cross pake "pop.cross.get(GENkeBERAPA)"
                //ngambil hasil mutate pake "pop.mutate.get(GENkeBERAPA)"
                
                if (ga.getCheckBox().isSelected()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GA.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            // Get the end time for the simulation.
            //long endTime = System.currentTimeMillis();
            try {
                // Print out some information to the console.
                Genetic.Export(best);
            } catch (IOException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Best Gene    " + i + ": " + best.getGene());
            System.out.println("Gene Fitness " + i + ": " + best.getFitness());
            //System.out.println("Total execution time: " + (endTime - startTime) + "ms");
            
            ga.getButton().setEnabled(true);
        }
    
    }

    /**
     * Creates new form GA
     */
    public GA() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GA_panel_background = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Genetic Algorithm");
        setBackground(new java.awt.Color(0, 0, 0));
        setBounds(new java.awt.Rectangle(365, 5, 450, 760));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(0, 0, 0));
        setName("GA_frame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(450, 760));
        setResizable(false);

        GA_panel_background.setBackground(new java.awt.Color(0, 0, 0));
        GA_panel_background.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        GA_panel_background.setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 0));
        jLabel1.setText("Algoritma Genetik");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Tampilkan Jadwal");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jList1.setBackground(new java.awt.Color(0, 0, 0));
        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jList1.setForeground(new java.awt.Color(0, 255, 0));
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 0));
        jLabel2.setText("Generasi");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 0));
        jLabel3.setText("0");

        jCheckBox1.setBackground(new java.awt.Color(0, 0, 0));
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(0, 255, 0));
        jCheckBox1.setText("Mode Santai");

        javax.swing.GroupLayout GA_panel_backgroundLayout = new javax.swing.GroupLayout(GA_panel_background);
        GA_panel_background.setLayout(GA_panel_backgroundLayout);
        GA_panel_backgroundLayout.setHorizontalGroup(
            GA_panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GA_panel_backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GA_panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(GA_panel_backgroundLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(GA_panel_backgroundLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        GA_panel_backgroundLayout.setVerticalGroup(
            GA_panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GA_panel_backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GA_panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GA_panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jCheckBox1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GA_panel_background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GA_panel_background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void validate() {
        super.validate();
        
        if (genes != null) {
            String[] ts = new String[6];
            getList().setListData(genes.toArray(ts));
        }
        
        jLabel3.setText("" + generation);
    }
    
    public void start() {
        GARunnable gar = new GARunnable();
        gar.setGA(this);
        (new Thread(gar)).start();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new GUI().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public javax.swing.JList<String> getList() {
        return jList1;
    }
    
    public javax.swing.JButton getButton() {
        return jButton1;
    }
    
    public javax.swing.JCheckBox getCheckBox() {
        return jCheckBox1;
    }
    
    ArrayList<String> genes = new ArrayList<>();
    ArrayList<ArrayList<javax.swing.JLabel>> dnas = new ArrayList<>();
    int generation = 0;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GA_panel_background;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
