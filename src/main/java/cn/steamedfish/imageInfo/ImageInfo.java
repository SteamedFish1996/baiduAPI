package cn.steamedfish.imageInfo;

public class ImageInfo {
	private String Image_Height;//图片高度
	private String Image_Width;//图片宽度
	private String Date_Time_Original;//拍摄时间
	private String GPS_Latitude;//维度
	private String GPS_Longitude;//经度
	public ImageInfo() {
		Image_Height = null;
		Image_Width = null;
		Date_Time_Original = null;
		GPS_Latitude = null;
		GPS_Longitude = null;
		
	}
	public ImageInfo(String image_Height, String image_Width, String date_Time_Original, String gPS_Latitude,
			String gPS_Longitude) {
		Image_Height = image_Height;
		Image_Width = image_Width;
		Date_Time_Original = date_Time_Original;
		GPS_Latitude = gPS_Latitude;
		GPS_Longitude = gPS_Longitude;
	}
	public String getImage_Height() {
		return Image_Height;
	}
	public void setImage_Height(String image_Height) {
		Image_Height = image_Height;
	}
	public String getImage_Width() {
		return Image_Width;
	}
	public void setImage_Width(String image_Width) {
		Image_Width = image_Width;
	}
	public String getDate_Time_Original() {
		return Date_Time_Original;
	}
	public void setDate_Time_Original(String date_Time_Original) {
		Date_Time_Original = date_Time_Original;
	}
	public String getGPS_Latitude() {
		return GPS_Latitude;
	}
	public void setGPS_Latitude(String gPS_Latitude) {
		GPS_Latitude = gPS_Latitude;
	}
	public String getGPS_Longitude() {
		return GPS_Longitude;
	}
	public void setGPS_Longitude(String gPS_Longitude) {
		GPS_Longitude = gPS_Longitude;
	}
	
	public void print()
	{
		System.out.println("Date_Time_Original:"+getDate_Time_Original());
		System.out.println("Latitude:"+getGPS_Latitude());
		System.out.println("Longitude:"+getGPS_Longitude());
		System.out.println("Image_Height:"+getImage_Height());
		System.out.println("Image_Width:"+getImage_Width());
		
	}
	

}
