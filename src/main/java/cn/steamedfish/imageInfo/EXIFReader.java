package cn.steamedfish.imageInfo;

import java.io.File;


import com.drew.metadata.*;  


import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
  
import java.io.*;  
/**
 * 读取图片信息
 * @author zzy
 *
 */

public class EXIFReader {
	public static void main(String args[]) throws FileNotFoundException {  
		File jpegFile = new File("image/test.jpg");
		EXIFReader r=new EXIFReader();
		r.readImage(jpegFile).print();;
	}
	
	public ImageInfo readImage(File jpegFile)
	{ 
		ImageInfo info=new ImageInfo(null, null, null, null, null);

		try {
			Metadata metadata = ImageMetadataReader.readMetadata(jpegFile); 
			for (Directory directory : metadata.getDirectories()) {
				for (Tag tag : directory.getTags()) { 
					//System.out.println(tag);        
	                String tagName = tag.getTagName();  //标签名
	                String desc = tag.getDescription(); //标签信息
	                if (tagName.equals("Image Height")) {  
	                	info.setImage_Height(desc);
	                	//System.out.println("图片高度: "+desc);
	                } else if (tagName.equals("Image Width")) {  
	                	info.setImage_Width(desc);
	                	//System.out.println("图片宽度: "+desc);
	                } else if (tagName.equals("Date/Time Original")) { 
	                	info.setDate_Time_Original(desc);
	                	//System.out.println("拍摄时间: "+desc);
	                }else if (tagName.equals("GPS Latitude")) {  
	                	info.setGPS_Latitude(desc);
	                	//System.err.println("纬度 : "+desc);
//	                        System.err.println("纬度(度分秒格式) : "+pointToLatlong(desc));
	                } else if (tagName.equals("GPS Longitude")) {
	                	info.setGPS_Longitude(desc);
	                	//System.err.println("经度: "+desc);
	                	//	                        System.err.println("经度(度分秒格式): "+pointToLatlong(desc)); 
	                }
	            }   
			}
		}catch (ImageProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}  
		return info;
	}
		 
	
	 /** 
     * 经纬度格式  转换为  度分秒格式 ,如果需要的话可以调用该方法进行转换
     * @param point 坐标点 
     * @return 
     */ 
    public static String pointToLatlong (String point ) {  
        Double du = Double.parseDouble(point.substring(0, point.indexOf("°")).trim());  
        Double fen = Double.parseDouble(point.substring(point.indexOf("°")+1, point.indexOf("'")).trim());  
        Double miao = Double.parseDouble(point.substring(point.indexOf("'")+1, point.indexOf("\"")).trim());  
        Double duStr = du + fen / 60 + miao / 60 / 60 ;  
        return duStr.toString();  
    }  

}
