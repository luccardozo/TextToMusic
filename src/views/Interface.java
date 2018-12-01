package views;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import common.Manager;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class Interface extends JFrame{

	private JPanel ctpMain;
	private JTextArea textArea;
	private JScrollPane scrTextToConvert;
	private JMenuBar menuBar;
	private JMenu smnArquivo;
	private JMenuItem imnSalvarMidi;
	private JButton btnStop;
	private JButton btnPlay;
	private JButton btnPause;
	private Manager Controller = new Manager();
	private JMenuItem imnAbrir;
	private JLabel lblGuris;
	private JMenu smnSobre;
	private JMenuItem imnUltramegapower;
	private JLabel label;
	private JButton btnTrash;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Interface() {
		
		initComponets();
		createCreateEvents();
	}

	
	/////////////////////////////////////////////////////////////////////////////////
	// This method contains all of the code for creating and
	// Initializing components.
	/////////////////////////////////////////////////////////////////////////////////
	private void initComponets() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Interface.class.getResource("/resources/monkey.png")));
		setTitle("UltraMegaPower Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 378);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		smnArquivo = new JMenu("Arquivo");
		menuBar.add(smnArquivo);
		
		imnAbrir = new JMenuItem("Abrir...");
		
		smnArquivo.add(imnAbrir);
		
		imnSalvarMidi = new JMenuItem("Salvar MIDI");


		smnArquivo.add(imnSalvarMidi);
		
		smnSobre = new JMenu("Sobre");
		menuBar.add(smnSobre);
		
		imnUltramegapower = new JMenuItem("UltraMegaPower");

		smnSobre.add(imnUltramegapower);
		ctpMain = new JPanel();
		ctpMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ctpMain);
		
		JLabel lblEscrevaOTexto = new JLabel("Escreva o texto a ser convertido:");
		lblEscrevaOTexto.setForeground(Color.DARK_GRAY);
		lblEscrevaOTexto.setFont(new Font("Calibri", Font.BOLD, 14));
		
		scrTextToConvert = new JScrollPane();
		
		btnPause = new JButton("");
	
		btnPause.setIcon(new ImageIcon(Interface.class.getResource("/resources/pause.png")));
		
		btnPlay = new JButton("");

		btnPlay.setIcon(new ImageIcon(Interface.class.getResource("/resources/play.png")));
		
		btnStop = new JButton("");

		btnStop.setIcon(new ImageIcon(Interface.class.getResource("/resources/stop.png")));
		
		lblGuris = new JLabel("");
		lblGuris.setIcon(new ImageIcon(Interface.class.getResource("/resources/usguris.png")));
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Interface.class.getResource("/resources/logoInf.png")));
		
		btnTrash = new JButton("");

		btnTrash.setIcon(new ImageIcon(Interface.class.getResource("/resources/trash.png")));
		
		GroupLayout gl_ctpMain = new GroupLayout(ctpMain);
		gl_ctpMain.setHorizontalGroup(
			gl_ctpMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEscrevaOTexto)
						.addComponent(scrTextToConvert, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_ctpMain.createSequentialGroup()
							.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
								.addComponent(btnPause)
								.addComponent(btnPlay)
								.addComponent(btnStop))
							.addGap(12))
						.addGroup(gl_ctpMain.createSequentialGroup()
							.addComponent(btnTrash)
							.addContainerGap())))
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
					.addComponent(lblGuris)
					.addContainerGap())
		);
		gl_ctpMain.setVerticalGroup(
			gl_ctpMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEscrevaOTexto, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ctpMain.createSequentialGroup()
							.addComponent(btnPlay)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPause)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnStop)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnTrash))
						.addComponent(scrTextToConvert, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(lblGuris))
					.addContainerGap())
		);
		
		textArea = new JTextArea();
		scrTextToConvert.setViewportView(textArea);
		ctpMain.setLayout(gl_ctpMain);

	}
	
	
	/////////////////////////////////////////////////////////////////////////////////
	// This method contains all of the code for creating events
	/////////////////////////////////////////////////////////////////////////////////
	private void createCreateEvents() 
	{
				
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(Controller.isAlive()) {
					Controller.setTextToConvert(textArea.getText());
					Controller.playMusic();
				}
				else {
					makeAnewThread();
					Controller.start();
				}
			}
		});
				
		btnPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(Controller.isAlive()) {
					Controller.pauseMusic();
				}
			}
		});
		
		btnStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Controller.isAlive()) {
					Controller.stopMusic();
				}
			}
		});
		btnTrash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!Controller.isAlive()) {
					Controller.stopMusic();
					textArea.setText("");
				}
			}
		});
				
		imnAbrir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fs = new JFileChooser();
				fs.setDialogTitle("Abrir arquivo");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Textos (*.txt)", "txt");
				fs.setFileFilter(filter);
				int resultado = fs.showOpenDialog(null);
				if (resultado == JFileChooser.APPROVE_OPTION) {
					File arq = fs.getSelectedFile();
					//pega um arquivo e converte para uma string
					try {
						textArea.setText(new String(Files.readAllBytes(Paths.get(arq.getAbsolutePath()))));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		imnSalvarMidi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fs = new JFileChooser();
				fs.setDialogTitle("Salvar MIDI");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Midi (*.midi)", "midi");
				fs.setFileFilter(filter);
				int result = fs.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File arq = fs.getSelectedFile();
					try {
						Controller.setTextToConvert(textArea.getText());
						Controller.saveMIDI(arq);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
			}
		});
		
		imnUltramegapower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				JFrame about = new JFrame();
				about.setTitle("UltaMegaPower Converter");
				about.setBounds(100, 100, 550, 200);
				about.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				about.getContentPane().setLayout(new BorderLayout());
				about.setVisible(true);
				about.getContentPane().setLayout(new BorderLayout());
				JLabel labelSobre = new JLabel();
				labelSobre.setFont(new Font("Calibri", Font.CENTER_BASELINE, 14));
				labelSobre.setText("<html>Software desenvolvido para a cadeira"
									+ " Técnicas de Construção de Programas - INF001120<br>"
									+ " Tem por objetivo converter um texto para música."
									+ "<br><br>Autores:<br>Lucas Cardoso<br>Filipe Bachini"
									+ "<br>Moatan Predroso<br>Lucas Hagemaister</html>");
				JScrollPane labelSobreComScroll = new JScrollPane(labelSobre);
				about.getContentPane().add(BorderLayout.CENTER,labelSobreComScroll);
			}
		});
		
	}
	
	private void makeAnewThread(){
		Controller = new Manager();
		Controller.setTextToConvert(textArea.getText());
	}
}

