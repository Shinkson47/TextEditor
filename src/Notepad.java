import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Notepad extends JFrame{
	
	private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;

    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
	
	public Notepad() {
        initComponents();
    }
	
	 private void initComponents() {

	        jScrollPane1 = new javax.swing.JScrollPane();
	        jTextArea1 = new javax.swing.JTextArea();
	        jMenuBar1 = new javax.swing.JMenuBar();
	        jMenu1 = new javax.swing.JMenu();
	        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
	        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();

	        jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();
	        jCheckBoxMenuItem5 = new javax.swing.JCheckBoxMenuItem();
	        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
	        jMenu2 = new javax.swing.JMenu();
	        jMenuItem2 = new javax.swing.JMenuItem();
	        jMenuItem1 = new javax.swing.JMenuItem();
	        jMenuItem3 = new javax.swing.JMenuItem();
	        jMenuItem4 = new javax.swing.JMenuItem();
	        jMenu3 = new javax.swing.JMenu();
	        jMenu4 = new javax.swing.JMenu();
	        jMenu5 = new javax.swing.JMenu();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jTextArea1.setColumns(20);
	        jTextArea1.setRows(5);
	        jScrollPane1.setViewportView(jTextArea1);

	        jMenu1.setText("File");
	        jMenu1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenu1ActionPerformed(evt);
	            }
	        });

	        jCheckBoxMenuItem1.setSelected(true);
	        jCheckBoxMenuItem1.setText("New");
	        jMenu1.add(jCheckBoxMenuItem1);

	        jCheckBoxMenuItem2.setSelected(true);
	        jCheckBoxMenuItem2.setText("Open");
	        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jCheckBoxMenuItem2ActionPerformed(evt);
	            }
	        });
	        jMenu1.add(jCheckBoxMenuItem2);

	        jCheckBoxMenuItem4.setSelected(true);
	        jCheckBoxMenuItem4.setText("Save");
	        jCheckBoxMenuItem4.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jCheckBoxMenuItem4ActionPerformed(evt);
	            }
	        });
	        jMenu1.add(jCheckBoxMenuItem4);

	        jCheckBoxMenuItem5.setSelected(true);
	        jCheckBoxMenuItem5.setText("Save As");
	        jMenu1.add(jCheckBoxMenuItem5);

	        jCheckBoxMenuItem3.setSelected(true);
	        jCheckBoxMenuItem3.setText("Print");
	        jMenu1.add(jCheckBoxMenuItem3);

	        jMenuBar1.add(jMenu1);

	        jMenu2.setText("Edit");

	        jMenuItem2.setText("Cut");
	        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItem2ActionPerformed(evt);
	            }
	        });
	        jMenu2.add(jMenuItem2);

	        jMenuItem1.setText("Copy");
	        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItem1ActionPerformed(evt);
	            }
	        });
	        jMenu2.add(jMenuItem1);

	        jMenuItem3.setText("Paste");
	        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItem3ActionPerformed(evt);
	            }
	        });
	        jMenu2.add(jMenuItem3);

	        jMenuItem4.setText("Select All");
	        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItem4ActionPerformed(evt);
	            }
	        });
	        jMenu2.add(jMenuItem4);

	        jMenuBar1.add(jMenu2);

	        jMenu3.setText("View");
	        jMenuBar1.add(jMenu3);

	        jMenu4.setText("Format");
	        jMenuBar1.add(jMenu4);

	        jMenu5.setText("Help");
	        jMenuBar1.add(jMenu5);

	        setJMenuBar(jMenuBar1);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1102, Short.MAX_VALUE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(0, 0, Short.MAX_VALUE))
	        );

	        pack();
	    }                      

	    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {                                      
	        // TODO add your handling code here:
	        jTextArea1.setText("");
	    }                                     

	    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                                  
	          try
	        { 
	        JFileChooser jf = new JFileChooser();
	        jf.showSaveDialog(this);
	        File f =  new File(jf.getSelectedFile().toString());
	        FileReader fw = new FileReader(f);
	        BufferedReader bw = new BufferedReader(fw);
	        String s="";
	        String s1="";
	        while((s1=bw.readLine())!=null)
	        {
	            s+=s1;
	        }
	        jTextArea1.setText(s);
	        bw.close();
	       
	        }
	        catch(Exception ex)
	        {
	           
	        }
	    }                                                 

	    private void jCheckBoxMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {                                                  
	        try
	        { 
	        JFileChooser jf = new JFileChooser();
	        jf.showSaveDialog(this);
	        File f =  new File(jf.getSelectedFile().toString());
	        FileWriter fw = new FileWriter(f);
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(jTextArea1.getText());
	        bw.close();
	       
	        }
	        catch(Exception ex)
	        {
	           
	        }
	    }                                                 

	    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                          
	        // TODO add your handling code here:
	        jTextArea1.cut();
	    }                                         

	    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                          
	        // TODO add your handling code here:
	        jTextArea1.copy();
	    }                                         

	    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {                                          
	        // TODO add your handling code here:
	        jTextArea1.paste();
	    }                                         

	    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {                                          
	        // TODO add your handling code here:
	        jTextArea1.selectAll();
	    }                                          

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {

	            java.util.logging.Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new Notepad().setVisible(true);
	            }
	        });


	}

}
