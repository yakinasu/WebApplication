package userInformation;

import java.sql.SQLException;

public class BookInfoLogic extends BookInfoDao{

	public static String sql = "INSERT INTO BookInfodb (isbn , tytle , page , author) VALUES(?, ?, ?, ?)";
	public static String sqlSelect =  "SELECT * FROM bookInfodb";
	public static  String sqlDelete = "delete FROM bookInfodb where isbn = ?";
	public static String sqlUpDateTitle = "update bookInfodb set tytle = ? where isbn = ?";
	public static String sqlUpDatePage = "update bookInfodb set page = ? where isbn = ?";
	public static String sqlUpDateAuthor = "update bookInfodb set author = ? where isbn = ?";
	BookBean forSearch = new BookBean();

	public void insertBookInfodb(BookBean bookBean) throws SQLException {
		try {
			this.bookInfoGet();
			System.out.println("bookInfoGet");
			this.addBookInfo(bookBean, sql);
			System.out.println("addBookInfo");
			this.printGetSql(bookBean);
		}catch (SQLException e) {
			throw e;
		}
	}

	public BookBean selectBookdb(String isbn) {
		try {
			this.bookInfoGet();
			forSearch = this.selectBookInfo(isbn, sqlSelect);
		} catch (Exception e) {
		}
		return forSearch;
	}
	public void deleteBookdb(String isbn) {
		try {
			this.bookInfoGet();
			this.deleteBookInfo(sqlDelete, isbn);
		} catch (Exception e) {
		}
	}

	public void updataBookdb(String key, String isbn, String record) {
		try {
			this.bookInfoGet();
			if (key.equals("tytle")) {
				this.updataBookInfo(sqlUpDateTitle, record, isbn);
			}
			if (key.equals("page")) {
				this.updataBookInfo(sqlUpDatePage, record, isbn);
			}
			if (key.equals("author")) {
				this.updataBookInfo(sqlUpDateAuthor, record, isbn);
			}
		} catch (Exception e) {

		}
	}
	/**
	 *
	 * @param beans
	 */
	public void printGetSql(BookBean bookBean) {
	System.out.println(bookBean.getAuthor());
		System.out.println(bookBean.getIsbn());
		System.out.println(bookBean.getBookTytle());
		System.out.println(bookBean.getTotalPage());
	}

}