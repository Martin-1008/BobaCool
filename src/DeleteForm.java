import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.*;

import dao.BarangDAO;

public class DeleteForm extends JFrame implements ActionListener, MouseListener {

	JMenuItem back, exitMenu;
	JTable table;
	JLabel txtKode, txtNama, txtHarga, txtStok;
	JButton delete;
	String tanda="";

	
	public DeleteForm() {
		initMenuBar();
		initFrame();
		buttonDelete();
	}
	
	public void initMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Menu");
		menu1.setForeground(Color.blue);

		back = new JMenuItem("Kembali ke Menu");
		exitMenu = new JMenuItem("Exit");
		
		back.addActionListener(this);
		exitMenu.addActionListener(this);

		menu1.add(back);
		menu1.add(exitMenu);
		
		menuBar.add(menu1);
		
		setJMenuBar(menuBar);
	}
	
	public void initFrame() {
		setTitle("Delete Form");
		setSize(500, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(400, 200);
		setLayout(new GridLayout(3,1));
		setResizable(false);
		setVisible(true);
		
		initTable();
		initComponent();
	}
	
	public void initTable() {
		Vector<String> column = new Vector<>();
		column.add("Kode");
		column.add("Nama");
		column.add("Harga");
		column.add("Stok");
		BarangDAO barangDAO = new BarangDAO();
		
		table = new JTable(barangDAO.getData(), column) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		
		table.addMouseListener(this);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, 500, 500);
		
		add(scroll);
	}
	
	public void initComponent() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		
		JLabel kode = new JLabel("Kode :");
		txtKode = new JLabel();
		panel.add(kode);
		panel.add(txtKode);
		
		JLabel nama = new JLabel("Nama :");
		txtNama = new JLabel();
		panel.add(nama);
		panel.add(txtNama);
		
		JLabel harga = new JLabel("Harga :");
		txtHarga = new JLabel();
		panel.add(harga);
		panel.add(txtHarga);
		
		JLabel stok = new JLabel("Stok :");
		txtStok = new JLabel();
		panel.add(stok);
		panel.add(txtStok);

		add(panel);
	}
	
	public void buttonDelete() {
		delete = new JButton("Delete Data");
		delete.addActionListener(this);
		add(delete);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int selectRowIndex = table.getSelectedRow();
		tanda = table.getValueAt(selectRowIndex, 0).toString();
		String kode = table.getValueAt(selectRowIndex, 0).toString();
		String nama = table.getValueAt(selectRowIndex, 1).toString();
		String harga = table.getValueAt(selectRowIndex, 2).toString();
		String stok = table.getValueAt(selectRowIndex, 3).toString();
		
		txtKode.setText(kode);
		txtNama.setText(nama);
		txtHarga.setText(harga);
		txtStok.setText(stok);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(back)){
			new MainMenu();
			setVisible(false);
		}else if(e.getSource().equals(exitMenu)) {
			System.exit(0);
		}else if(e.getSource().equals(delete)) {
			if(tanda.equals("")) {
				JOptionPane.showMessageDialog(null, "Pilih data yang akan di Delete");
			}else {
				BarangDAO barangDAO = new BarangDAO();
				barangDAO.deleteBarang(tanda);
				JOptionPane.showMessageDialog(null, "Delete telah berhasil dilakukan");
				new DeleteForm();
				setVisible(false);
			}
		}
	}

}
