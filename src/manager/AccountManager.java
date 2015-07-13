
package manager;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AccountManager {
		private Map<String, String> credentials = new HashMap<String, String>();
			
		public AccountManager() throws IOException{
			
			FileReader file = new FileReader("foo.txt"); 
			BufferedReader reader = new BufferedReader(file);
			String line = reader.readLine();
			while (line!=null){
				credentials.put(line.split(" ")[0], line.split(" ")[1]);
				line = reader.readLine();
			}
			reader.close();
		
		}
		public boolean authenticate(String username, String password){
			return (credentials.containsKey(username) && credentials.get(username) == password);
		}
}
