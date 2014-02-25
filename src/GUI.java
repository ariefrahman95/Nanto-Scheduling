
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arief pradana
 */
public class GUI extends javax.swing.JFrame {

     private ArrayList<Character> arrayinput = new ArrayList();
     BufferedImage img = null;
     int pointerarray = 0;
     Nanto nantoslife = new Nanto();
     int minggu = 1;
     int pointerhari = 0;
     ArrayList<String> day = new ArrayList();
     int pukul = 9;
     int enlightenment = 0;
     int maxenergy = 0;
     class pasangan{
         int pencerahan; 
         int energidibutuhkan;
     }
     ArrayList<pasangan> pkandidat = new ArrayList();
     class barang {
        char kode;
        int harga;
     }
     ArrayList<barang> hargabarang = new ArrayList();
     
     int energypointer = 0;
     ArrayList<Integer> energyrecord = new ArrayList();
     
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        nantoslife.load(new File("info.txt"));
        readfile();
        inisialisasi(nantoslife);
        updateimage(nantoslife);
    }
      
      public void readfile() {
        File file = new File("hasil.txt");
        Scanner scan = null;
        try{
           scan = new Scanner(file);
        }
        catch(FileNotFoundException e){
           System.exit(0);
        }
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            for (int i = 0; i < line.length(); i++) {
             arrayinput.add(line.charAt(i));
             System.out.println(arrayinput.get(i));
            }
        }
        scan.close();
    }
       public void inisialisasi(Nanto n){
           maxenergy = n.energy;
           jLabel2.setText("Kebugaran : "+n.energy);
           jLabel3.setText("Uang : "+n.money);
           jLabel4.setText("Otak : "+n.brain);
           jLabel5.setText("Pesona : "+n.charm);
           jLabel6.setText("Otot : "+n.strength);
           jLabel10.setText("Minggu ke "+minggu);
           day.add("Senin");
           day.add("Selasa");
           day.add("Rabu");
           day.add("Kamis");
           day.add("Jumat");
           day.add("Sabtu");
           day.add("Minggu");
           jLabel11.setText("Hari : "+day.get(pointerhari));
           jLabel12.setText("Pukul :"+pukul+".00 - "+(pukul+1)+".00");
           jLabel13.setText("Pencerahan : "+enlightenment);
 
           
           char[] candidCode = n.candidCodes.toCharArray();
           for(int i = 0; i < n.nCandidate; i++){
               pasangan pas = new pasangan();
               pas.pencerahan = n.candid.get(candidCode[i]).getEnlightenment();
               pas.energidibutuhkan = n.candid.get(candidCode[i]).getEnergy();
               //System.out.println(""+pas.energidibutuhkan+" "+pas.pencerahan );
               pkandidat.add(pas);
           }
           
           char[] itemCode = Nanto.itemCodes.toCharArray();
           for(int j = 0; j <n.nItem; j++){
               barang temp = new barang();
               temp.kode = n.items.get(itemCode[j]).getCode();
               temp.harga = n.items.get(itemCode[j]).getPrice();
              // System.out.println(""+temp.kode+" "+temp.harga );
               hargabarang.add(temp);
           }
       } 
       
       public void updateimage(Nanto n){
          if(pointerarray < arrayinput.size()){
                //System.out.println(pointerarray);
               // System.out.println(arrayinput.size());
                if (pukul == 21){
                  energyrecord.add(energypointer,n.energy);
                  //System.out.println(energypointer);
                  //System.out.println(energyrecord.get(energypointer));
                  energypointer = energypointer+1;
                  n.energy = maxenergy;
                  jLabel2.setText("Kebugaran : "+n.energy);
                  pukul = 10; 
                  if(pointerhari == 6){
                      pointerhari = 0;
                      minggu = minggu+1;
                      jLabel11.setText("Hari : "+day.get(pointerhari));
                      jLabel10.setText("Minggu ke "+minggu);
                    }else {
                      pointerhari = pointerhari+1;   
                      jLabel11.setText("Hari : "+day.get(pointerhari));
                    }
                } else {
                  pukul = pukul+1;
                }
              jLabel12.setText("Pukul :"+pukul+".00 - "+(pukul+1)+".00");
              
              try {
                if (arrayinput.get(pointerarray) == 'c'){
                    img = ImageIO.read(new File("CAFE.png"));
                    jTextArea2.setText("*tuk tuk* Nanto berjalan menuju cafe~");
                    n.charm = n.charm+2;
                    n.energy = n.energy-6;
                    jLabel5.setText("Pesona : "+n.charm);
                    jLabel2.setText("Kebugaran : "+n.energy);
                } else if (arrayinput.get(pointerarray) == 'g'){
                    img = ImageIO.read(new File("GYM.png"));
                     jTextArea2.setText("*ngek* Barbel berat!!! \n ...terangkat dengan kedua tangan (~'_')~");
                     n.strength = n.strength+2;
                     n.energy = n.energy-12;
                     jLabel6.setText("Otot : "+n.strength);
                     jLabel2.setText("Kebugaran : "+n.energy);
                } else if (arrayinput.get(pointerarray) == 'm'){
                    img = ImageIO.read(new File("MALL.png"));
                    jTextArea2.setText("Nemu duit di jalan...*aneh bin ajaib*");
                    n.money = n.money+10000;
                    n.energy = n.energy-8;
                    jLabel3.setText("Uang : "+n.money);
                    jLabel2.setText("Kebugaran : "+n.energy);
                } else if (arrayinput.get(pointerarray) == 'u'){
                    img = ImageIO.read(new File("UNIV.png"));
                    jTextArea2.setText("O.O Nanto melototin 'papan tulis'!!!");
                    n.brain = n.brain+3;
                    n.energy = n.energy-15;
                    jLabel4.setText("Otak : "+n.brain);
                    jLabel2.setText("Kebugaran : "+n.energy);
                } else if (arrayinput.get(pointerarray) == '0'){
                    img = ImageIO.read(new File("bengong.png"));
                    jTextArea2.setText("heeee....ngah ngoh *ngeces*");
                } else if (arrayinput.get(pointerarray) == '1' || arrayinput.get(pointerarray) == '2' || arrayinput.get(pointerarray) == '3' || arrayinput.get(pointerarray) == '4' || arrayinput.get(pointerarray) == '5' || arrayinput.get(pointerarray) == '6' || arrayinput.get(pointerarray) == '7'){
                    img = ImageIO.read(new File("CANDIDAT.png"));
                    jTextArea2.setText("Hey Honey #"+arrayinput.get(pointerarray)+" wanna chitchat~?");

                    int temp = Character.getNumericValue(arrayinput.get(pointerarray));
                    enlightenment = enlightenment+pkandidat.get(temp-1).pencerahan ;
                    n.energy = n.energy - pkandidat.get(temp-1).energidibutuhkan;

                    jLabel13.setText("Pencerahan : "+enlightenment);
                    jLabel2.setText("Kebugaran : "+n.energy);
                } else {
                    img = ImageIO.read(new File("BARANG.png"));
                    jTextArea2.setText("*Cling* Get Item!!! code "+arrayinput.get(pointerarray));

                    int i = 0;
                    while ((char)arrayinput.get(pointerarray) != hargabarang.get(i).kode){
                        i++;
                    }
                     n.money = n.money - hargabarang.get(i).harga;
                     jLabel3.setText("Uang : "+n.money);
                }
              } catch (IOException e) {
                  System.out.println("o3o");
                   }  

               jLabel1.setIcon(new ImageIcon(img));
               jLabel1.setVisible(true);
               jPanel1.repaint();
               System.out.println("(~'_')~");
          }
       }
       
       public void rollback(Nanto n){
           if(pointerarray > 0){
              
                if (arrayinput.get(pointerarray) == 'c'){
                    n.charm = n.charm-2;
                    n.energy = n.energy+6;
                    jLabel5.setText("Pesona : "+n.charm);
                    jLabel2.setText("Kebugaran : "+n.energy);
                } else if (arrayinput.get(pointerarray) == 'g'){
                     n.strength = n.strength-2;
                     n.energy = n.energy+12;
                     jLabel6.setText("Otot : "+n.strength);
                     jLabel2.setText("Kebugaran : "+n.energy);
                } else if (arrayinput.get(pointerarray) == 'm'){
                    n.money = n.money-10000;
                    n.energy = n.energy+8;
                    jLabel3.setText("Uang : "+n.money);
                    jLabel2.setText("Kebugaran : "+n.energy);
                } else if (arrayinput.get(pointerarray) == 'u'){
                    n.brain = n.brain-3;
                    n.energy = n.energy+15;
                    jLabel4.setText("Otak : "+n.brain);
                    jLabel2.setText("Kebugaran : "+n.energy);
                } else if (arrayinput.get(pointerarray) == '0'){

                } else if (arrayinput.get(pointerarray) == '1' || arrayinput.get(pointerarray) == '2' || arrayinput.get(pointerarray) == '3' || arrayinput.get(pointerarray) == '4' || arrayinput.get(pointerarray) == '5' || arrayinput.get(pointerarray) == '6' || arrayinput.get(pointerarray) == '7'){


                    int temp = Character.getNumericValue(arrayinput.get(pointerarray));
                    enlightenment = enlightenment-pkandidat.get(temp-1).pencerahan ;
                    n.energy = n.energy + pkandidat.get(temp-1).energidibutuhkan;

                    jLabel13.setText("Pencerahan : "+enlightenment);
                    jLabel2.setText("Kebugaran : "+n.energy);
                } else {

                    int i = 0;
                    while ((char)arrayinput.get(pointerarray) != hargabarang.get(i).kode){
                        i++;
                    }
                     n.money = n.money + hargabarang.get(i).harga;
                     jLabel3.setText("Uang : "+n.money);
                }
                
               // System.out.println(pointerarray);
                if (pukul == 10){
                  energypointer = energypointer-1;
                  n.energy = energyrecord.get(energypointer);
                  jLabel2.setText("Kebugaran : "+n.energy);
                  pukul = 21; 
                  if(pointerhari == 0){
                      pointerhari = 6;
                      minggu = minggu-1;
                      jLabel11.setText("Hari : "+day.get(pointerhari));
                      jLabel10.setText("Minggu ke "+minggu);
                    }else {
                      pointerhari = pointerhari-1;   
                      jLabel11.setText("Hari : "+day.get(pointerhari));
                    }
                } else {
                  pukul = pukul-1;
                }
              jLabel12.setText("Pukul :"+pukul+".00 - "+(pukul+1)+".00");
          }
       }
       
       public void image(){
          try {
            if (arrayinput.get(pointerarray) == 'c'){
                img = ImageIO.read(new File("CAFE.png"));
                jTextArea2.setText("*tuk tuk* Nanto berjalan menuju cafe~");
            } else if (arrayinput.get(pointerarray) == 'g'){
                img = ImageIO.read(new File("GYM.png"));
                 jTextArea2.setText("*ngek* Barbel berat!!! \n ...terangkat dengan kedua tangan (~'_')~");
            } else if (arrayinput.get(pointerarray) == 'm'){
                img = ImageIO.read(new File("MALL.png"));
                jTextArea2.setText("Nemu duit di jalan...*aneh bin ajaib*");
            } else if (arrayinput.get(pointerarray) == 'u'){
                img = ImageIO.read(new File("UNIV.png"));
                jTextArea2.setText("O.O Nanto melototin 'papan tulis'!!!");
            } else if (arrayinput.get(pointerarray) == '0'){
                img = ImageIO.read(new File("bengong.png"));
                jTextArea2.setText("heeee....ngah ngoh *ngeces*");
            } else if (arrayinput.get(pointerarray) == '1' || arrayinput.get(pointerarray) == '2' || arrayinput.get(pointerarray) == '3' || arrayinput.get(pointerarray) == '4' || arrayinput.get(pointerarray) == '5' || arrayinput.get(pointerarray) == '6' || arrayinput.get(pointerarray) == '7'){
                img = ImageIO.read(new File("CANDIDAT.png"));
                jTextArea2.setText("Hey Honey #"+arrayinput.get(pointerarray)+" wanna chitchat~?");
            } else {
                img = ImageIO.read(new File("BARANG.png"));
                jTextArea2.setText("*Cling* Get Item!!! code "+arrayinput.get(pointerarray));
            }
          } catch (IOException e) {
              System.out.println("o3o");
               }  
           
           jLabel1.setIcon(new ImageIcon(img));
           jLabel1.setVisible(true);
           jPanel1.repaint();
           System.out.println("~('_'~)");
       }
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nanto's Schedule");
        setBounds(new java.awt.Rectangle(820, 0, 480, 770));
        setPreferredSize(new java.awt.Dimension(480, 770));

        jPanel1.setBackground(new java.awt.Color(25, 36, 42));

        jTextArea2.setBackground(new java.awt.Color(25, 36, 42));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea2.setRows(5);
        jTextArea2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 5, true));
        jScrollPane2.setViewportView(jTextArea2);

        jButton1.setText("Prev");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousactivity(evt);
            }
        });

        jButton2.setText("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextactivity(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jPanel2.setBackground(new java.awt.Color(25, 36, 42));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 5, true));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Stamina");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Uang");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Brain");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Charm");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Strength");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Minggu ke");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Hari");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Jam");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Pencerahan");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel13))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(jButton1)
                                .addGap(69, 69, 69)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 76, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextactivity(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextactivity
       if(pointerarray < arrayinput.size()){
        pointerarray++;   
       }
       updateimage(nantoslife);
    }//GEN-LAST:event_nextactivity

    private void previousactivity(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousactivity
        rollback(nantoslife);
        if(pointerarray > 0){
            pointerarray--;
        }
        image();
    }//GEN-LAST:event_previousactivity

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
