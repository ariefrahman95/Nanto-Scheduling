
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

    public static List arrayinput = new ArrayList();
     BufferedImage img = null;
     int pointerarray = 0;
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        readfile();
        addimage();
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

       public void addimage(){
          try {
            if (arrayinput.get(pointerarray) == 'c'){
                img = ImageIO.read(new File("CAFE.png"));
                jTextArea2.setText("*tuk tuk* Nanto berjalan menuju cafe~");
            } else if (arrayinput.get(pointerarray) == 'g'){
                img = ImageIO.read(new File("GYM.png"));
                 jTextArea2.setText("*ngek* Barbel berat!!! \n ...terangkat dengan kedua tangan (~'_')~");
            } else if (arrayinput.get(pointerarray) == 'm'){
                img = ImageIO.read(new File("MALL.png"));
                jTextArea2.setText("*bla3* Suasana ini...membuat Nanto semangat ");
            } else if (arrayinput.get(pointerarray) == 'u'){
                img = ImageIO.read(new File("UNIV.png"));
                jTextArea2.setText("O.O Nanto melototin 'papan tulis'!!!");
            } else if (arrayinput.get(pointerarray) == '0'){
                img = ImageIO.read(new File("bengong.png"));
                jTextArea2.setText("heeee....ngah ngoh *ngeces*");
            } else if (arrayinput.get(pointerarray) == '0' || arrayinput.get(pointerarray) == '2' || arrayinput.get(pointerarray) == '3' || arrayinput.get(pointerarray) == '4' || arrayinput.get(pointerarray) == '5' || arrayinput.get(pointerarray) == '6' || arrayinput.get(pointerarray) == '7'){
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
           System.out.println("(~'_')~");
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nanto's Schedule");
        setBounds(new java.awt.Rectangle(825, 5, 470, 760));
        setPreferredSize(new java.awt.Dimension(470, 760));

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

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(50, Short.MAX_VALUE))
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
                        .addGap(0, 46, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
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
       pointerarray++;
       addimage();
    }//GEN-LAST:event_nextactivity

    private void previousactivity(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousactivity
        pointerarray--;
        addimage();
    }//GEN-LAST:event_previousactivity

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
