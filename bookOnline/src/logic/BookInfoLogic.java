package logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import beans.BookBean;
import beans.UserBean;
import tool.sqlCostants;

public class BookInfoLogic extends BookInfoDao{
	BookBean forSearch = new BookBean();
	ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

	/**
	 * 本情報を追加する用の処理
	 * @param bookBean
	 * @throws SQLException
	 */
	public void insertBookInfodb(BookBean bookBean) throws SQLException {
		try {
			this.bookInfoGet();
			System.out.println("bookInfoGet");
			this.addBookInfo(bookBean, sqlCostants.sql);
			System.out.println("addBookInfo");
			this.printGetSql(bookBean);
		}catch (SQLException e) {
			throw e;
		}
	}

	/**
	 * 本情報の全検索結果を受け取る
	 * @return
	 */
	public ArrayList<HashMap<String, String>>  searchBookdb() {
		try {
			this.bookInfoGet();
			list = this.searchBookInfo(sqlCostants.sqlSelect);
		} catch (Exception e) {
		}
		return list;
	}

	/**
	 * 検索したい本情報を取得する
	 * @param isbn
	 * @return
	 */
	public BookBean selectBookdb(String isbn) {
		try {
			list = this.searchBookdb();
			forSearch = this.findNeedData(list, isbn);
		} catch (Exception e) {
		}
		return forSearch;
	}

	/**
	 * 本情報を削除する
	 * @param isbn
	 */
	public void deleteBookdb(String isbn) {
		try {
			this.bookInfoGet();
			this.deleteBookInfo(sqlCostants.sqlDelete, isbn);
		} catch (Exception e) {
		}
	}

	/**
	 * 主キーを与えて本情報を更新する
	 * @param key
	 * @param isbn
	 * @param record
	 */
	public void updataBookdb(String key, String isbn, String record) {
		try {
			this.bookInfoGet();
			if (key.equals("tytle")) {
				this.updataBookInfo(sqlCostants.sqlUpDateTitle, record, isbn);
			}
			if (key.equals("page")) {
				this.updataBookInfo(sqlCostants.sqlUpDatePage, record, isbn);
			}
			if (key.equals("author")) {
				this.updataBookInfo(sqlCostants.sqlUpDateAuthor, record, isbn);
			}
		} catch (Exception e) {

		}
	}

	/**
	 * ユーザー録情情報を新規で追加する
	 * @param userBean
	 * @throws SQLException
	 */
	public void userCreate(UserBean userBean) throws SQLException {
		this.bookInfoGet();
		this.addUserInfo(sqlCostants.sqlUserAdd, userBean);
	}

	/**
	 *　コンソールに登録情報を表示する（確認用）
	 * @param beans
	 */
	public void printGetSql(BookBean bookBean) {
	System.out.println(bookBean.getAuthor());
		System.out.println(bookBean.getIsbn());
		System.out.println(bookBean.getBookTytle());
		System.out.println(bookBean.getTotalPage());
	}

	/**
	 * 一件検索を行うためのメソッド
	 * @param list
	 * @param isbn
	 * @return
	 */
	public BookBean findNeedData (ArrayList<HashMap<String, String>> list, String isbn) {
		BookBean bookBean = new BookBean();
		for (HashMap<String, String> search : list) {
			if (isbn.equals(search.get("isbn"))) {
				bookBean.setIsbn(isbn);
				bookBean.setBookTytle(search.get("tytle"));
				bookBean.setTotalPage(search.get("page"));
				bookBean.setAuthor(search.get("author"));
				return bookBean;
			}
			System.out.println(search.get("tytle"));

		}
		return null;
	}

}