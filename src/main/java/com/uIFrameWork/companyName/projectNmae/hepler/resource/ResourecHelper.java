package com.uIFrameWork.companyName.projectNmae.hepler.resource;

public class ResourecHelper {
	
		public static String getResourcePath(String path){
			System.out.println(path);
			System.out.println(System.getProperty("user.dir"));
			
			String basepath  = System.getProperty("user.dir");
			System.out.println("path :"+path);
			System.out.println("basepath :"+basepath);
			return  basepath+path;		
		}
		
		public static void main(String[] args) {
			String path = ResourecHelper.getResourcePath("/resources/configfile/Log4j.properties");
			System.out.println("Final Path :"+path);
			
		}
}
 