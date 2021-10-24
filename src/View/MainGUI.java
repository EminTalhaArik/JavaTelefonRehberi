package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Manager.PersonManager;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Manager.*;
import java.awt.Toolkit;

public class MainGUI extends JFrame {

	PersonManager personManager = new PersonManager();
	private JPanel contentPane;
	private JTable tblPerson;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtEmail;
	private JTextField txtNumber;
	DefaultTableModel personModel;
	Object[] personData;
	private String selectedID = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\EclipseProjectsSpace\\TelefonRehberi\\src\\View\\telefonRehberiIcon.png"));
		setTitle("Telefon Rehberi");

		personModel = new DefaultTableModel();
		Object[] colPersonName = new Object[5];
		colPersonName[0] = "ID";
		colPersonName[1] = "Ýsim";
		colPersonName[2] = "Soyisim";
		colPersonName[3] = "E-Mail";
		colPersonName[4] = "Numara";

		personModel.setColumnIdentifiers(colPersonName);
		personData = new Object[5];

		for (int i = 0; i < personManager.getList().size(); i++) {

			personData[0] = personManager.getList().get(i).getId();
			personData[1] = personManager.getList().get(i).getName();
			personData[2] = personManager.getList().get(i).getSurname();
			personData[3] = personManager.getList().get(i).getEmail();
			personData[4] = personManager.getList().get(i).getNumber();

			personModel.addRow(personData);
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 643);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 292, 553, 313);
		contentPane.add(scrollPane);

		tblPerson = new JTable(personModel);		
		tblPerson.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					selectedID = tblPerson.getValueAt(tblPerson.getSelectedRow(), 0).toString();
				} catch (Exception e2) {
					
				}

			}
		});
		tblPerson.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				if(e.getType() == TableModelEvent.UPDATE) {
					int selectID = Integer.parseInt(tblPerson.getValueAt(tblPerson.getSelectedRow(), 0).toString());
					String selectName = tblPerson.getValueAt(tblPerson.getSelectedRow(), 1).toString();
					String selectSurname = tblPerson.getValueAt(tblPerson.getSelectedRow(), 2).toString();
					String selectEmail = tblPerson.getValueAt(tblPerson.getSelectedRow(), 3).toString();
					String selectNumber = tblPerson.getValueAt(tblPerson.getSelectedRow(), 4).toString();
				
					boolean control = personManager.update(selectID, selectName, selectSurname, selectEmail, selectNumber);
				}
				
			}
		});
	

		scrollPane.setViewportView(tblPerson);

		JLabel lblNewLabel = new JLabel("\u0130sim");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNewLabel.setBounds(192, 49, 41, 32);
		contentPane.add(lblNewLabel);

		txtName = new JTextField();
		txtName.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		txtName.setBounds(267, 49, 203, 32);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtSurname = new JTextField();
		txtSurname.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		txtSurname.setColumns(10);
		txtSurname.setBounds(267, 91, 203, 32);
		contentPane.add(txtSurname);

		JLabel lblSoyisim = new JLabel("Soyisim");
		lblSoyisim.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblSoyisim.setBounds(168, 86, 65, 32);
		contentPane.add(lblSoyisim);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(267, 133, 203, 32);
		contentPane.add(txtEmail);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblEmail.setBounds(188, 128, 45, 32);
		contentPane.add(lblEmail);

		txtNumber = new JTextField();
		txtNumber.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		txtNumber.setColumns(10);
		txtNumber.setBounds(267, 180, 203, 32);
		contentPane.add(txtNumber);

		JLabel lblTelefonNumaras = new JLabel("Telefon Numaras\u0131");
		lblTelefonNumaras.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblTelefonNumaras.setBounds(85, 175, 148, 32);
		contentPane.add(lblTelefonNumaras);

		JButton btnAdd = new JButton("Ekle");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtName.getText().length() == 0 || txtSurname.getText().length() == 0
						|| txtNumber.getText().length() == 0) {
					Helper.showMessage("fill");

				} else {
					boolean control = personManager.add(txtName.getText(), txtSurname.getText(), txtNumber.getText(),
							txtEmail.getText());

					if (control) {
						Helper.showMessage("succes");
						txtName.setText(null);
						txtSurname.setText(null);
						txtNumber.setText(null);
						txtEmail.setText(null);
						updatePersonTable();
					}

				}

			}
		});
		btnAdd.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		btnAdd.setBounds(68, 222, 203, 49);
		contentPane.add(btnAdd);

		JButton btnDelete = new JButton("Sil");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(selectedID == null) {
					Helper.showMessage("Lütfen Bir Seçim Yapýnýz !");
				}else {
					if(Helper.showConfirmMessage("sure")) {
						int selID = Integer.parseInt(selectedID);
						boolean control = personManager.delete(selID);
						
						if(control) {
							
							Helper.showMessage("succes");
							selectedID = null;
							updatePersonTable();
							
						}
					}
				}
				
			}
		});
		btnDelete.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		btnDelete.setBounds(281, 222, 203, 49);
		contentPane.add(btnDelete);
	}

	public void updatePersonTable() {
		DefaultTableModel clearModel = (DefaultTableModel) tblPerson.getModel();
		clearModel.setRowCount(0);

		for (int i = 0; i < personManager.getList().size(); i++) {

			personData[0] = personManager.getList().get(i).getId();
			personData[1] = personManager.getList().get(i).getName();
			personData[2] = personManager.getList().get(i).getSurname();
			personData[3] = personManager.getList().get(i).getEmail();
			personData[4] = personManager.getList().get(i).getNumber();

			personModel.addRow(personData);
		}

	}
}
