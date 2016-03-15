/**
 * @package com
 * @author cuiyueyang
 * @date 2016-3-4 下午7:07:57
 * @todo TODO
 */
package com;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.domain.BusinessModel;

/**
 * @author cuiyueyang
 * @data 2016-3-4 下午7:07:57
 * @todo TODO
 */
public class JsonTest {

	public static void main(String[] args){
		//声明一个Hash对象并添加数据
//		Map params =  new HashMap();
//
//		params.put("username", "cyy");
//		params.put("user_json", "123");
//
//		//声明JSONArray对象并输入JSON字符串
//		JSONObject studentJSONObject = new JSONObject();
//		 try {
//		      studentJSONObject.put("name", "Jason");
//		      studentJSONObject.put("id", 20130001);
//		      studentJSONObject.put("phone", "13579246810");
//		      studentJSONObject.put("std", params);
//		    } catch (JSONException e) {
//		      e.printStackTrace();
//		    }
//		 System.out.println(studentJSONObject.toString());
		
		List list = new LinkedList<BusinessModel>();
		for(int i=1;;i++){
//			Map<String, String> map = new HashMap<String, String>();
//			map.put("businessname", "12423423");
//			map.put("productname", "12423423");
//			map.put("priority", "12423423");
//			map.put("progress", "12423423");
//			map.put("bugnum", "12423423");
//			map.put("person", "12423423");
//			map.put("businessdescription", "12423423");
//			list.add(map);
			BusinessModel bm = new BusinessModel();
			bm.setBusinessname("123123");
			bm.setProductname("123123");
			bm.setPriority("123123");
			bm.setProgress("123123");
			bm.setBugnum("123123");
			bm.setPerson("123123");
			bm.setBusinessdescription("123123");
			list.add(bm);
		}
//		JSONArray json = new JSONArray(list, false);
	}
}
