package com.newlecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.newlecture.web.entity.Exam;

public class App2 {

	public static void main(String[] args) { 
		
		System.out.println("----map---------------------map");
		
		{
			Map<String,Object> map = new HashMap();
			
			map.put("id",1); //key는 식별자
			map.put("title","안녕하세요");
			map.put("writerId",3);
			map.put("content","냉무");
			
			for(String key : map.keySet())
				System.out.println(key);
			
			for(Object v : map.values())
				System.out.println(v);
			
			for(Map.Entry<String,Object> entry : map.entrySet())
				System.out.println(entry);
		}
		
		System.out.println("------------------------------list");
		
		{
			List<Integer> list = new ArrayList<>();
			list.add(3);
			list.add(3); 
			list.add(4);
			list.add(3);
//			list.add("asd");
			int size = list.size();
			System.out.println(size);
			int num = list.get(0);
			System.out.println(num);
			for(Integer a : list)
				System.out.print(a);
		}
		
		System.out.println("------------------------set");
		
		{
			Exam exam = new Exam("bok",1,1,1);
			Exam exam1 = new Exam("ha",2,2,2);
			Set<Exam> set = new HashSet<>();
//			set.add(3);
//			set.add(3);
//			set.add(4);
//			set.add(3);
			
			set.add(exam);
			set.add(exam1);
			set.add(new Exam("y",3,3,3));
			set.add(new Exam("y1",4,4,4));
//			int size = set.size();
//			System.out.println(size);
			Iterator it1 = set.iterator();
			
			{
				while(it1.hasNext()) 
				System.out.println(it1.next());
			}
			
			{	
				for(Exam exa : set) 
				System.out.println(exa);
			}
		}
	}

}
