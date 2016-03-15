/**
 * @package com
 * @author cuiyueyang
 * @date 2016-3-7 下午5:42:33
 * @todo TODO
 */
package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.domain.BusinessModel;


/**
 * @author cuiyueyang
 * @data 2016-3-7 下午5:42:33
 * @todo TODO
 */
public class JsonNetTest {

	public static void main(String[] args){
//		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		List list = new LinkedList<BusinessModel>();
		for(int i=1;i<10;i++){
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
		JSONArray json = JSONArray.fromObject(list);
		System.out.println("json:"+json);
		boolean[] boolArray = new boolean[]{true,false,true};  
        JSONArray jsonArray = JSONArray.fromObject( boolArray );  
        System.out.println( jsonArray ); 
	}
}
