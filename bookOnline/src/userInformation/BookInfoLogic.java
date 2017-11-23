package userInformation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class BookInfoLogic extends BookInfoDao{

	public static String sql = "INSERT INTO BookInfodb (isbn , tytle , page , author) VALUES(?, ?, ?, ?)";
	public static String sqlSelect =  "SELECT * FROM bookInfodb";
	public static  String sqlDelete = "delete FROM bookInfodb where isbn = ?";
	public static String sqlUpDateTitle = "update bookInfodb set tytle = ? where isbn = ?";
	public static String sqlUpDatePage = "update bookInfodb set page = ? where isbn = ?";
	public static String sqlUpDateAuthor = "update bookInfodb set author = ? where isbn = ?";
	BookBean forSearch = new BookBean();
	ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

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

	public ArrayList<HashMap<String, String>>  searchBookdb() {
		try {
			this.bookInfoGet();
			list = this.searchBookInfo(sqlSelect);
		} catch (Exception e) {
		}
		return list;
	}

	public BookBean selectBookdb(String isbn) {
		try {
			list = this.searchBookdb();
			forSearch = this.findNeedData(list, isbn);
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

	public BookBean findNeedData (ArrayList<HashMap<String, String>> list, String isbn) {
		BookBean bookBean = new BookBean();
		for (HashMap<String, String> search : list) {
			if (isbn.equals(search.get("isbn"))) {
				bookBean.setIsbn(isbn);
				bookBean.setBookTytle(search.get("tytle"));
				bookBean.setTotalPage(search.get("page"));
				bookBean.setAuthor(search.get("author"));
				System.out.println("========================");
				System.out.println(search.get("tytle"));
				System.out.println("========================");
				return bookBean;
			}
			System.out.println(search.get("tytle"));

		}
		return null;
	}

}