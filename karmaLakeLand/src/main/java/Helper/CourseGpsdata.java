package Helper;

public class CourseGpsdata {

	public String latitude;
	public String longitude;
	public String holeNo;
	public String teename;
	public String yards;

	 public CourseGpsdata() {
		// TODO Auto-generated constructor stub
	}
	 
    public CourseGpsdata(String latitude, String longitude, String holeNo, String teename, String yards) {
        super();
      this.latitude=latitude;
      this.longitude=longitude;
      this.holeNo=holeNo;
      this.teename=teename;
      this.yards= yards;      
    }

	public String getLatitude() {
		return latitude;

	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getHoleNo() {
		return holeNo;
	}
	public void setHoleNo(String holeNo) {
		this.holeNo = holeNo;
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
		return  "Latitude: " + latitude + ", Longitude : " + longitude + ", holeNo: "
				+ holeNo + ", Teename : " + teename + ", Yards : " +yards;
	}

	
}
