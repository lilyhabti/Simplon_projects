package entities;

public class CurrentAdmin {
	private static int currentAdminId;
	private static int id;
	private static String currentpassword;
	private static String currentusername;
	private static String currentfullname;
	

	public static String getCurrentusername() {
		return currentusername;
	}

	public static void setCurrentusername(String currentusername) {
		CurrentAdmin.currentusername = currentusername;
	}

	public static String getCurrentfullname() {
		return currentfullname;
	}

	public static void setCurrentfullname(String currentfullname) {
		CurrentAdmin.currentfullname = currentfullname;
	}

	public static int getCurrentAdminId() {
		return currentAdminId;
	}

	public static void setCurrentAdminId(int currentAdminId) {
		CurrentAdmin.currentAdminId = currentAdminId;
	}

	public static String getCurrentpassword() {
		return currentpassword;
	}

	public static void setCurrentpassword(String currentpassword) {
		CurrentAdmin.currentpassword = currentpassword;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int idEdit) {
		id = idEdit;
	}
}
