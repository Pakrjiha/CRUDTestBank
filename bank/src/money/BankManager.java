package money;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BankManager {
	private static JTextField textid;
	private static JTextField textname;
	private static JTextField textage;
	private static JTextField texttel;

	public static void main(String[] args) {

		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		f.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnInsert = new JButton("insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BankDAO dao = new BankDAO();
				BankDTO dto = new BankDTO();

				dto.setId(textid.getText());
				dto.setName(textname.getText());
				dto.setAge(Integer.parseInt(textage.getText()));
				dto.setTel(texttel.getText());

				try {
					dao.insert(dto);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		panel.add(btnInsert);

		JButton btnUpdate = new JButton("update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BankDAO dao = new BankDAO();
				BankDTO dto = new BankDTO();

				dto.setId(textid.getText());
				dto.setTel(texttel.getText());

				try {
					dao.update(dto);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		panel.add(btnUpdate);

		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BankDAO dao = new BankDAO();
				BankDTO dto = new BankDTO();

				dto.setId(textid.getText());

				try {
					dao.delete(dto);
				} catch (Exception d) {
					d.printStackTrace();
				}

			}
		});
		panel.add(btnDelete);

		JButton btnSelect = new JButton("select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BankDAO dao = new BankDAO();
				BankDTO dto = new BankDTO();

				dto.setId(textid.getText());
				
				try {
					dao.select(dto);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		panel.add(btnSelect);

		JButton btnSelectAll = new JButton("select all");
		btnSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BankDAO dao = new BankDAO();
				BankDTO dto = new BankDTO();

				try {
					dao.selectAll(dto);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		panel.add(btnSelectAll);

		JPanel panel_1 = new JPanel();
		f.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblId = new JLabel("ID : ");
		lblId.setFont(new Font("Dialog", Font.PLAIN, 36));
		panel_1.add(lblId);

		textid = new JTextField();
		textid.setFont(new Font("굴림", Font.PLAIN, 35));
		panel_1.add(textid);
		textid.setColumns(10);

		JLabel lblName = new JLabel("Name : ");
		lblName.setFont(new Font("Dialog", Font.PLAIN, 36));
		panel_1.add(lblName);

		textname = new JTextField();
		textname.setFont(new Font("굴림", Font.PLAIN, 35));
		panel_1.add(textname);
		textname.setColumns(10);

		JLabel lblAge = new JLabel("Age : ");
		lblAge.setFont(new Font("Dialog", Font.PLAIN, 36));
		panel_1.add(lblAge);

		textage = new JTextField();
		textage.setFont(new Font("굴림", Font.PLAIN, 35));
		panel_1.add(textage);
		textage.setColumns(10);

		JLabel lblTel = new JLabel("Tel : ");
		lblTel.setFont(new Font("Dialog", Font.PLAIN, 36));
		panel_1.add(lblTel);

		texttel = new JTextField();
		texttel.setFont(new Font("굴림", Font.PLAIN, 35));
		panel_1.add(texttel);
		texttel.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("insert : 모든 항목이 들어가야 합니다.      \r\nupdate : Id와 Tel이 들어가야 합니다.\r\n");
		panel_1.add(lblNewLabel);
		
		JLabel lblDeleteId = new JLabel("delete : Id가 들어가야 합니다.      select : Id가 들어가야 합니다.");
		panel_1.add(lblDeleteId);
		
		JLabel lblNewLabel_1 = new JLabel("select all : 아무 항목도 안들어가도 됩니다.");
		panel_1.add(lblNewLabel_1);

		f.setVisible(true);
	}

}
