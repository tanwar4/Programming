import java.util.ArrayList;
import java.util.List;

class Tablet {
	int num_tablets;
	List<Long> tablet_id;

	public Tablet(int num_tablets) {
		super();
		this.num_tablets = num_tablets;
	}

	public void calcTabletRange(){
		//calculate each tablet range	
		tablet_id = new ArrayList<Long>();
		long total_range = Long.MAX_VALUE;
		long chunk_size=(long)Math.ceil((double)total_range/num_tablets);

		for(long i=0;i<total_range;i+=chunk_size){			
			if (i+chunk_size <=0){ //Overflow Condition
				tablet_id.add(total_range);
				break;
			}
			else{//otherwise use the calculated value 
				tablet_id.add(i+chunk_size==Long.MAX_VALUE?Long.MAX_VALUE:((i+chunk_size)-1));
			} 		
		}
	}

	//display max value for each range
	public void display(){
		for(int i=0;i<tablet_id.size();i++){
			System.out.println(tablet_id.get(i));
		}
	}

	public String findTabletForkey(long key){	
		String tablet_name=null;

		if(isValidKey(key)){
			for(int i=0;i<tablet_id.size();i++){ //find the tablet id
				if(key<=tablet_id.get(i)){
					tablet_name = i+"";
					break;
				}
			}
		}
		return tablet_name;

	}

	//check for key validity: Only keys within Long range are valid
	private boolean isValidKey(long key) {
		if(key>=0 && key<=Long.MAX_VALUE) return true;
		return false;
	}
}
