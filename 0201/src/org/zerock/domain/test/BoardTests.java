package org.zerock.domain.test;

import java.beans.BeanInfo;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.zerock.domain.Board;

public class BoardTests {

	// bad code
	public static void main(String[] args) throws Exception {
		
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("title", "타이틀");
		paramMap.put("content", "내용물........");
		
		Class clz = Class.forName("org.zerock.domain.Board");
		
		System.out.println(clz);
		
		Object obj = clz.newInstance();

//		Board obj = new Board();
//
//		Class clz = obj.getClass();

		BeanInfo info = java.beans.Introspector.getBeanInfo(clz);

		System.out.println(info);

		PropertyDescriptor[] props = info.getPropertyDescriptors();

		for (PropertyDescriptor prop : props) {
			System.out.println(prop);
			
			//read를 쓰면 겟이 가능
			//EL이나 마이바티스도 이걸사용한다.
			Method setMethod = prop.getWriteMethod();

			if (setMethod != null) {
				String pName = prop.getName();
				if(paramMap.get(pName) != null);
				
				setMethod.invoke(obj, paramMap.get(pName));
			}
		}
		System.out.println(obj);
	}
}
