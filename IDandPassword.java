import java.util.HashMap;

public class IDandPassword {
	
	//====Bina HashMap===
	
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	
	// =========Database User Mini===========
	IDandPassword(){
		
		logininfo.put("Naufal","Naufal1234");
		logininfo.put("Admin","Hello1234");
		logininfo.put("Aina","Aina1234");
	}
	
	protected HashMap getLoginInfo() {
		return logininfo;
	}
	
}
