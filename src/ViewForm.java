import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;

import dao.BarangDAO;

public class ViewForm extends JFrame implements ActionListener{

	JMenuItem back = new JMenuItem("Kembali ke Menu");
	JMenuItem exitMenu = new JMenuItem("Exit");
	
	public ViewForm() {
		// TODO Auto-generated constructor stub
		initMenuBar();
		initFrame();
	}
	
	public void initMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Menu");
		menu1.setForeground(Color.blue);

		back.addActionListener(this);
		exitMenu.addActionListener(this);

		menu1.add(back);
		menu1.add(exitMenu);
		
		menuBar.add(menu1);
		
		setJMenuBar(menuBar);
	}
	
	public void initFrame() {
		setTitle("View Form");
		setSize(500, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(400, 200);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		
		initTable();
	}
	
	public void initTable() {
		Vector<String> column = new Vector<>();
		column.add("Kode");
		column.add("Nama");
		column.add("Harga");
		column.add("Stok");
		BarangDAO  barangDAO = new BarangDAO();
		
		JTable table = new JTable(barangDAO.getData(), column) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, 500, 500);
		
		add(scroll);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(back)){
			new MainMenu();
			setVisible(false);
		}else if(e.getSource().equals(exitMenu)) {
			System.exit(0);
		}
	}

}