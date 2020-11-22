  import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * <h1>A basic standalone text editor programme.</h1>
 */
public class Notepad extends JFrame{

	//#region UI Elements
	private JCheckBoxMenuItem menuItemNew = new JCheckBoxMenuItem("New", true);
    private JCheckBoxMenuItem menuItemOpen = new JCheckBoxMenuItem("Open", true);
    private JCheckBoxMenuItem menuItemPrint = new JCheckBoxMenuItem("Print", true);
    private JCheckBoxMenuItem menuItemSave = new JCheckBoxMenuItem("Save", true);
    private JCheckBoxMenuItem menuItemSaveAs = new JCheckBoxMenuItem("Save As", true);


	private JMenuBar jMenuBar = new JMenuBar();
    private JMenu menuFile = new JMenu("File");
    private JMenu menuEdit = new JMenu("Edit");
    private JMenu menuView = new JMenu("View");
    private JMenu menuFormat = new JMenu("Format");
    private JMenu menuHelp = new JMenu("Help");


    private JMenuItem menuItemCopy = new JMenuItem("Copy");
    private JMenuItem menuItemCut = new JMenuItem("Cut");
    private JMenuItem menuItemPaste = new JMenuItem("Paste");
    private JMenuItem menuItemSelectAll = new JMenuItem("Select All");


	/**
	 * Main text editing area.
	 */
	private JTextArea txtArea = new JTextArea();

	/**
	 * Scroll pane parent for the text editing area.
	 */
	private JScrollPane txtAreaScrollPane = new JScrollPane();
	//#endregion UI Elements

	//#region construction

	/*
	 * Simplified constructor.
	 * <br><br>
	 * Sets exit on close, configures and populates window, then displays it.
	 */
	{
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		initComponents();
		setVisible(true);
    }

	/**
	 * <h2>Configures swing window components</h2>
	 */
	private void initComponents() {
			// Configure text area
	        txtArea.setColumns(20);
	        txtArea.setRows(5);
	        txtAreaScrollPane.setViewportView(txtArea);

	        // Add action listeners
			menuItemOpen.addActionListener(this::openFile);
	        menuItemSave.addActionListener(this::saveFile);

			menuItemCut.addActionListener(this::cut);
			menuItemCopy.addActionListener(this::copy);
			menuItemSelectAll.addActionListener(this::selectAll);
			menuItemPaste.addActionListener(this::paste);

			// Populate menu file
			menuFile.add(menuItemNew);
			menuFile.add(menuItemOpen);
			menuFile.add(menuItemSave);
			menuFile.add(menuItemSaveAs);
	        menuFile.add(menuItemPrint);

	        // Populate edit menu
	        menuEdit.add(menuItemCut);
			menuEdit.add(menuItemCopy);
			menuEdit.add(menuItemPaste);
			menuEdit.add(menuItemSelectAll);

			// Add menus to menu bar
			jMenuBar.add(menuFile);
	        jMenuBar.add(menuEdit);
	        jMenuBar.add(menuView);
	        jMenuBar.add(menuFormat);
	        jMenuBar.add(menuHelp);

	        // Add menu bar to super
	        setJMenuBar(jMenuBar);

			// Configure layout
	        getContentPane().setLayout(new GroupLayout(getContentPane()));
	        GroupLayout layout = (GroupLayout) getContentPane().getLayout();

			layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addComponent(txtAreaScrollPane, GroupLayout.DEFAULT_SIZE, 1102, Short.MAX_VALUE)
	        );

	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(txtAreaScrollPane, GroupLayout.PREFERRED_SIZE, 581, GroupLayout.PREFERRED_SIZE)
	                .addGap(0, 0, Short.MAX_VALUE))
	        );

	        pack();
	    }                      
	//#endregion construction

	/**
	 * Prompts the user to load a file to {@link Notepad#txtArea}
	 */
	private void openFile(java.awt.event.ActionEvent evt) {

		try {
																		// TODO File chooser can be abstracted
	        final JFileChooser jf = new JFileChooser();					// Create a file chooser. FINAL: We only need to do this once.
	        jf.showSaveDialog(this);								// Prompt user for save location


			File f =  new File(jf.getSelectedFile().toString());		// Get file location

	        FileReader fw = new FileReader(f);							// Create a read buffer
			BufferedReader br = new BufferedReader(fw);

	        StringBuilder content = new StringBuilder();				// local store for the file's content.
	        String line;												// local store for the current line of the file.

	        while((line=br.readLine())!=null)							// For every line, read it and
	            content.append(line);									// append it to the local content

			br.close();													// close the buffer
			fw.close();												    // close the reader
	        txtArea.setText(content.toString());						// place read data into the editing field

		}
		catch(Exception ignored){} 										// TODO User is not alerted to any failure.
	}

	/**
	 * Prompts the user to save the text found in {@link Notepad#txtArea} to a file.
	 */
	private void saveFile(ActionEvent evt) {
		try {
			final JFileChooser jf = new JFileChooser();					// TODO File chooser can be abstracted. FINAL: we only need to create this once.
	        jf.showSaveDialog(this);								// prompt the user for a file,
	        File f =  new File(jf.getSelectedFile().toString());		// Create a local file for the desired location. TODO check for existing files and *.txt file extension
	        FileWriter fw = new FileWriter(f);							// Open a writer
	        BufferedWriter bw = new BufferedWriter(fw);					// Create a write buffer
	        bw.write(txtArea.getText());								// Dump the text editor field to the file
	        bw.close();													// close the writer
			fw.close();													// close the file writer
		}
	    catch(Exception ignored){} 									// TODO User is not alerted to failure.
	    }                                                 

	//#region Edit Actions
	private void cut(ActionEvent evt) {
		txtArea.cut();
	}

	private void copy(ActionEvent evt) {
		txtArea.copy();
	}

	private void paste(java.awt.event.ActionEvent evt) {
		txtArea.paste();
	}

	private void selectAll(java.awt.event.ActionEvent evt) {
		txtArea.selectAll();
	}
	//#endregion Edit Actions


	public static void main(String[] args) {
		 try {
	            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
	            Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } // FIXME invokes logger, but provides no message.
			  // TODO logging may be abstracted.

		new Notepad();
	}
}
