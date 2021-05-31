import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
import dao.BarangDAO;

public class InsertForm extends JFrame implements ActionListener{

	JButton save = new JButton("Simpan");
	JButton cancel = new JButton("Kembali ke Menu");
	
	JTextField txtKode = new JTextField();
	JTextField txtNama = new JTextField();
	JTextField txtHarga = new JTextField();
	JTextField txtStok = new JTextField();
	
	JMenuItem exit = new JMenuItem("Exit");
	
	public InsertForm() {
		// TODO Auto-generated constructor stub
		initMenuBar();
		initFrame();
	}
	
	public void initMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Menu");
		menu1.setForeground(Color.blue);
		
		exit.addActionListener(this);
		menu1.add(exit);
		
		menuBar.add(menu1);
		
		setJMenuBar(menuBar);
	}
	
	public void initFrame() {
		setTitle("Insert Barang Baru");
		setSize(400, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(400, 200);
		setLayout(new GridLayout(0,2));
		setResizable(false);
		setVisible(true);
		
		initComponent();
	}
	
	public void initComponent() {
		JLabel kode = new JLabel("Kode :");
		add(kode);
		add(txtKode);
		
		JLabel nama = new JLabel("Nama :");
		add(nama);
		add(txtNama);
		
		JLabel harga = new JLabel("Harga :");
		add(harga);
		add(txtHarga);
		
		JLabel stok = new JLabel("Stok :");
		add(stok);
		add(txtStok);
		
		save.addActionListener(this);
		cancel.addActionListener(this);
		add(save);
		add(cancel);
	}

	public boolean validateBarang() {
		if(txtKode.getText().isEmpty()
			||txtNama.getText().isEmpty()
			||txtHarga.getText().isEmpty()
			||txtStok.getText().isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(save)) {
			if(validateBarang() == false) {
				JOptionPane.showMessageDialog(null, "Diharuskan isi semua kolom");
			}else {
				BarangDAO barangDAO = new BarangDAO();
				barangDAO.insertBarang(txtKode.getText(), txtNama.getText(), txtHarga.getText(), txtStok.getText());
				JOptionPane.showMessageDialog(null, "Barang Baru Berhasil Dimasukkan");
			}
		}else if(e.getSource().equals(cancel)){
			new MainMenu();
			setVisible(false);
		}else if(e.getSource().equals(exit)) {
			System.exit(0);
		}
	}


}
