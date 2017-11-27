package userInformation;

public class sqlCostants {
	public final static String sql = "INSERT INTO BookInfodb (isbn , tytle , page , author) VALUES(?, ?, ?, ?)";
	public final static String sqlSelect =  "SELECT * FROM bookInfodb";
	public final static  String sqlDelete = "delete FROM bookInfodb where isbn = ?";
	public final static String sqlUpDateTitle = "update bookInfodb set tytle = ? where isbn = ?";
	public final static String sqlUpDatePage = "update bookInfodb set page = ? where isbn = ?";
	public final static String sqlUpDateAuthor = "update bookInfodb set author = ? where isbn = ?";
	public final static String sqlUserAdd = "INSERT INTO UserInfo (username, password) VALUES(?, ?)";
}
