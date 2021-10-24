package Manager;

import javax.swing.JOptionPane;

public class Helper {

	public static void showMessage(String str) {
		String msg;
		switch (str) {
		case "fill": 
			msg = "Lütfen Tüm Alanlarý Doldurunuz.";
			break;
		case "succes":
			msg = "Ýþlem Baþarýlý";
			break;
		default:
			msg = str;
		}
		
		JOptionPane.showMessageDialog(null, msg, "Mesaj", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public static boolean showConfirmMessage(String str) {
		String msg;
		switch (str) {
		case "sure": 
			msg = "Bu iþlemi gerçekleþtirmek istediðinizden emin misiniz ? ";
			break;
		default:
			msg = str;
		}
		
		int res = JOptionPane.showConfirmDialog(null, msg, "Mesaj", JOptionPane.YES_NO_OPTION);
		
		if(res == 0) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
