package utils;

public class Protocol {

	public static String isBookNameExist(String bookName){
		return "isExist:"+bookName+"\n";
	}

	public static String getAddBookMsg(String bookName, String author, float price) {
		// 发送的消息格式：oper:para1,para2,para3...
		return  "addBook:" + bookName + "," + author + "," + price + "\n";
	}

	public static String getDelByBookNameMsg(String bookName) {
		return "deleteByBookName:" + bookName + "\n";
	}

	public static String getDelByAuthorMsg(String author) {
		return  "deleteByAuthor:" + author + "\n";
	}

	public static String getDelByPriceMsg(float lowBound, float upBound) {
		return  "deleteByPrice:" + lowBound + "," + upBound + "\n";
	}

	public static String getFndByBookNameMsg(String bookName) {
		return "findByBookName:" + bookName + "\n";
	}

	public static String getFndByAuthorMsg(String author) {
		return  "findByAuthor:" + author + "\n";
	}

	public static String getFndByPriceMsg(float lowBound, float upBound) {
		return  "findByPrice:" + lowBound + "," + upBound + "\n";
	}

	public static String getAltBookMsg(String cursorBookName, String bookName, String author, float price) {
		return  "alterBook:" + cursorBookName + "," + bookName + "," + author + "," + price + "\n";
	}

	public static String getPrtAllBookMsg() {
		return  "printAllBook:null\n";
	}

}
