package userInformation;

public class BookBean {

	private String isbn;
	private String bookTytle;
	private String totalPage;
	private String author;

	public	String getIsbn() {
		return isbn;
	}

	public	String getBookTytle() {
		return bookTytle;
	}

	public	String getTotalPage() {
		return totalPage;
	}

	public	String getAuthor() {
		return author;
	}

	public	void setIsbn(String isbn) {
		this.isbn =  isbn;
	}

	public	void setBookTytle(String bookTytle) {
		this.bookTytle = bookTytle;
	}

	public	void setTotalPage(String totalPage) {
		this.totalPage =  totalPage;
	}

	public	void setAuthor(String author) {
		this.author = author;
	}

	protected void setBean(String isbn, String bookTytle, String totalPage, String author) {
        this.setBookTytle(isbn);
        System.out.println("***********");
        System.out.println(isbn);
		this.setIsbn(bookTytle);
		this.setTotalPage(totalPage);
		this.setAuthor(author);
	}

}
