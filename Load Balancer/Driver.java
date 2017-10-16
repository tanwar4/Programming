import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {

	public static void main(String[] args){
		List<String> ls = new ArrayList<>();
		ls.add("Server1");
		LoadBalancer lb = new LoadBalancer(8,ls);
		
		
		lb.getServerForKey(2305843009213693951L);
		lb.getServerForKey(4611686018427387903L);
		lb.getServerForKey(6917529027641081855L);
		lb.getServerForKey(9223372036854775807L);
		lb.getServerForKey(1);
		lb.getServerForKey(2305843009213693952L);
		lb.getServerForKey(4611686018427387904L);
		lb.getServerForKey(6917529027641081856L);
		
		lb.addServer("Server2");
		System.out.println("----------------------------");
		lb.getServerForKey(2305843009213693951L);
		lb.getServerForKey(4611686018427387903L);
		lb.getServerForKey(6917529027641081855L);
		lb.getServerForKey(9223372036854775807L);
		lb.getServerForKey(1);
		lb.getServerForKey(2305843009213693952L);
		lb.getServerForKey(4611686018427387904L);
		lb.getServerForKey(6917529027641081856L);
		
		lb.addServer("Server3");
		System.out.println("----------------------------");
		lb.getServerForKey(2305843009213693951L);
		lb.getServerForKey(4611686018427387903L);
		lb.getServerForKey(6917529027641081855L);
		lb.getServerForKey(9223372036854775807L);
		lb.getServerForKey(1);
		lb.getServerForKey(2305843009213693952L);
		lb.getServerForKey(4611686018427387904L);
		lb.getServerForKey(6917529027641081856L);
		
		lb.addServer("Server4");
		System.out.println("----------------------------");
		lb.getServerForKey(2305843009213693951L);
		lb.getServerForKey(4611686018427387903L);
		lb.getServerForKey(6917529027641081855L);
		lb.getServerForKey(9223372036854775807L);
		lb.getServerForKey(1);
		lb.getServerForKey(2305843009213693952L);
		lb.getServerForKey(4611686018427387904L);
		lb.getServerForKey(6917529027641081856L);
		
		lb.removeServer("Server4");
		System.out.println("----------------------------");
		lb.getServerForKey(2305843009213693951L);
		lb.getServerForKey(4611686018427387903L);
		lb.getServerForKey(6917529027641081855L);
		lb.getServerForKey(9223372036854775807L);
		lb.getServerForKey(1);
		lb.getServerForKey(2305843009213693952L);
		lb.getServerForKey(4611686018427387904L);
		lb.getServerForKey(6917529027641081856L);

	}
}
