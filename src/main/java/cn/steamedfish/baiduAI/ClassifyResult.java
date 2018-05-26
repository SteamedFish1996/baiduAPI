package cn.steamedfish.baiduAI;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 储存照片信息 与其他照片信息比较
 * @author zzy
 * @version 180526
 *
 */

public class ClassifyResult {
	private Long log_id;//唯一的log id，用于问题定位
	private int result_num;//返回结果数目，即result数组中的元素个数
	private JSONArray result;//标签结果数组
	private double score[];//置信度，0-1
	private String root[];//识别结果的上层标签，有部分钱币、动漫、烟酒等tag无上层标签
	private String keyword[];//图片中的物体或场景名称
	private static double threshold=(double) 0.3;//置信度的阈值，大于threshold表示可信
	
	/**
	 * 构造函数
	 * @param res 返回的json对象
	 */
	public ClassifyResult(JSONObject res){
		this.log_id=res.getLong("log_id");
		this.result_num=res.getInt("result_num");
		this.result=res.getJSONArray("result");
		score = new double[result_num];
		root = new String[result_num];
		keyword = new String[result_num];
		for (int i = 0; i < result.length(); i++) {
	        JSONObject info = result.getJSONObject(i);
	        score[i]=info.getDouble("score");
	        root[i]=info.getString("root");
	        keyword[i] = info.getString("keyword");
	    }
		
	}
	/**
	 * Constructor
	 * @param log_id
	 * @param result_num
	 * @param result
	 */
	public ClassifyResult(Long log_id,int result_num,JSONArray result){
		this.log_id=log_id;
		this.result_num=result_num;
		this.result=result;
		score = new double[result_num];
		root = new String[result_num];
		keyword = new String[result_num];
		
		for (int i = 0; i < result.length(); i++) {
	        JSONObject info = result.getJSONObject(i);
	        score[i]=info.getDouble("score");
	        root[i]=info.getString("root");
	        keyword[i] = info.getString("keyword");
	    }
		
	}
	
	/**
	 * 输出图片信息用于测试
	 */
	public void print() {
		System.out.print("log_id");
		System.out.println(log_id);
		System.out.print("result_num");
		System.out.println(result_num);
		for (int i = 0; i < result_num; i++) {
			System.out.println("第"+i+"个：");
			System.out.print("score：");
			System.out.println(score[i]);
			System.out.print("root：");
			System.out.println(root[i]);
			System.out.print("keyword：");
			System.out.println(keyword[i]);
		}  
	}
	/**
	 * 比较是不是相似图片 在本工程中如果返回相似且地理位置相近则认为是相似图片
	 * @param cr
	 * @return true/false
	 */
	public boolean sameWith(ClassifyResult cr) {
		for (int i = 0; i < result_num; i++) {
			for (int j = 0; j < cr.result_num; j++) {
				if (keyword[i].equals(cr.keyword[j])) {
					if (score[i]>threshold && cr.score[j]>threshold)
						return true;
				}
			}			
		}
		return false;
	}
}
