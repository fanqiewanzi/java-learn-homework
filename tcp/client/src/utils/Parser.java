package utils;


public class Parser {
	
	public static boolean getIsSuccess(String returnStr){
		return returnStr.equals("true");
	}
	
	
	public static String[][] fndBookParser(String returnStr){
		
		/* Client的Parser
		 * 客户端收到的是查询结果：attr,attr,attr|attr,attr,attr
		 * 这里返回String[][]
		 */
		String[] firstSplit = returnStr.split("\\|");
		String[][] bookList = new String[firstSplit.length][3];
		for(int i=0;i<firstSplit.length;i++){
			String[] attrs = firstSplit[i].split(",");
			bookList[i][0] = attrs[0];
			bookList[i][1] = attrs[1];
			bookList[i][2] = attrs[2];
		}
		return bookList;
	}

}