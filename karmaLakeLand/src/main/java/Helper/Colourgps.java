package Helper;

public class Colourgps {
	public String teename;
	public String yards;
	
	
	public Colourgps()
	{
		
	}
	 public Colourgps(String teename, String yards) {
	        super();
	      this.teename=teename;
	      this.yards= yards;      
	    }
	
	 public String getTeename() {
			return teename;
		}
		public void setTeename(String teename) {
			this.teename = teename;
		}
		public String getYards() {
			return yards;
		}
		public void setYards(String yards) {
			this.yards = yards;
		}
		
		
		public String toString() {
			return  "Teename : " + teename + " Yards : " +yards;
		}	
}
