package userInformation;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class BookInfoDao {
	java.sql.Connection  conn = null;
	private String driver;
	private String url;
	private String user;
	private String password;

	/**
	 * コンストラクタ
	 *
	 * @param driver
	 *            ドライバー
	 * @param url
	 *            URL
	 * @param user
	 *            ユーザー名
	 * @param password
	 *            パスワード
	 */
	public BookInfoDao(String driver, String url, String user, String password) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	/**
	 * 引数なしのコンストラクタ 既定値を使用する
	 */
	public BookInfoDao() {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost/BookInfodb";
		user = "root";
		password = "";
	}

	public void bookInfoGet() throws SQLException {
		String msg = "";
			try {
			     Class.forName("com.mysql.jdbc.Driver").newInstance();
			     msg = "ドライバのロードに成功しました";
			   } catch (ClassNotFoundException e){
			     msg = "ドライバのロードに失敗しました";
			   } catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			     System.out.println(msg);
		}
		/**
		 *
		 * @param bookBean
		 * @param sql
		 * @throws SQLException
		 */

		public void addBookInfo (BookBean bookBean, String sql) throws SQLException {

			conn = DriverManager.getConnection(this.url, this.user, this.password);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bookBean.getIsbn());
			ps.setString(2, bookBean.getBookTytle());
			ps.setString(3, bookBean.getTotalPage());
			ps.setString(4, bookBean.getAuthor());
			System.out.println("setFinish");
			ps.executeUpdate();
			System.out.println("execute");
		}
		/**
		 *
		 * @param isbn
		 * @param sql
		 * @return
		 * @throws SQLException
		 */

		public BookBean selectBookInfo(String isbn, String sql) throws SQLException {
			conn = DriverManager.getConnection(this.url, this.user, this.password);
			BookBean forSearch = new BookBean();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			HashMap map = new HashMap();
			ArrayList list = new ArrayList();
			while (rs.next()) {
				map.clear();
				map.put("isbn",rs.getString("isbn"));
				map.put("tytle", rs.getString("tytle"));
				map.put("page", rs.getString("page"));
				map.put("author", rs.getString("author"));
				list.add(map);
//				String answer =rs.getString("isbn");
//				if (isbn.equals(answer)) {
//					String tytle = rs.getString("tytle");
//					String totalPage = rs.getString("page");
//					String author = rs.getString("author");
//					forSearch.setAuthor(author);
//					forSearch.setTotalPage(totalPage);
//					forSearch.setBookTytle(tytle);
//					forSearch.setIsbn(answer);
//					break;
//				}
			}
			rs.close();
			return forSearch;
		}
		/**
		 *
		 * @param sql
		 * @param deleteKey
		 * @throws SQLException
		 */
		public void deleteBookInfo(String sql, String deleteKey) throws SQLException {
			conn = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, deleteKey);
			System.out.println(sql);
			System.out.println(deleteKey);
			ps.executeUpdate();
		}
		/**
		 *
		 * @param sql
		 * @param field
		 * @param newData
		 * @param isbn
		 * @throws SQLException
		 */
		public void updataBookInfo(String sql,  String newData, String isbn) throws SQLException {
			conn = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newData);
			ps.setString(2, isbn);
			System.out.println(sql);
			System.out.println(newData);
			System.out.println(isbn);
			ps.executeUpdate();
		}

	}
