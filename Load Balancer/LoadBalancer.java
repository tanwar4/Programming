/*
 * Client class is basically an implementation of rendezvous Hashing 
 * */
import java.security.MessageDigest;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class LoadBalancer extends Master {
	
	Tablet t;
	public LoadBalancer(int numTablets, List<String> serverNames) {
		super(numTablets, serverNames);
		t = new Tablet(numTablets);  
		t.calcTabletRange();       //calculate tablet range
		//t.display();				//display range of each tablet(Max value)
	}

	/*To get the server for key, first find the respective Tablet in which
	  the key is stored and than use the tablet to find the server */
	@Override
	public String getServerForKey(long key) {			
		long maxValue = Long.MIN_VALUE;
		String score = null;
		String keyTabletMapper = t.findTabletForkey(key);
		if(keyTabletMapper != null){
			for (String node : serverNames) {
				long serverHash = generateHash(node+":"+keyTabletMapper);
				if (serverHash > maxValue) {
					score = node;
					maxValue = serverHash;
				}
			}
		}
		System.out.printf(" Tablet:%s ---->%s \n",keyTabletMapper,score);
		return score;
		
	}

	@Override
	public void addServer(String serverName) {
		 this.serverNames.add(serverName);
	}

	@Override
	public void removeServer(String serverName) {
	     this.serverNames.remove(serverName);
	}

	//This hash function generates values which are spread uniformly
	//http://burtleburtle.net/bob/hash/doobs.html
	//This function is same as used in libketama
	public long generateHash(String serverName){ 
		long k = 0;
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			 md5.reset();
	          byte[] digest = md5.digest(serverName.getBytes());	            
	          for (int i = 0; i < 4; i++) {
	              k = ((long) (digest[3 + i * 4] & 0xFF) << 24)
	                  | ((long) (digest[2 + i * 4] & 0xFF) << 16)
	                  | ((long) (digest[1 + i * 4] & 0xFF) << 8)
	                  | (digest[i * 4] & 0xFF);
	              
	          }
			
		}catch (Exception e) {
			System.out.println("Error in generating Hash Function");
		}		
		return k;	   
	}

}
