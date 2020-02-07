package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Book;

public class BookRepository {
	private final String driverPath = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/restapi";
	private final String userName = "root";
	private final String password = "admin";
	private Connection con;
	
	public BookRepository() {
		try {
			Class.forName(driverPath);
			con = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int createBook(Book newBook) {
		String query = "INSERT INTO Book VALUES (?,?,?,?,?)";
		PreparedStatement st;
		int rowsAffected = 0;
		try {
			st = con.prepareStatement(query);
			st.setInt(1, newBook.getId());
			st.setString(2, newBook.getTitle());
			st.setString(3, newBook.getWriter());
			st.setString(4, newBook.getPublisher());
			st.setInt(5, newBook.getPublishedYear());
			rowsAffected = st.executeUpdate();
			System.out.println(rowsAffected + " : rows affected.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
	public int searchBookByName(String title) {
		title = title.toLowerCase();
		List<Book> books = getAllBooks();
		int totalBooks = books.size();
		for (int index = 0; index < totalBooks; index++) {
			String bookTitle = books.get(index).getTitle().toLowerCase();
			if (bookTitle.equals(title)) {
				return index;
			}
		}
		return -1;
	}
	
	public List<Book> getAllBooks() {
		String query = "SELECT * FROM Book";
		Statement st;
		List<Book> books = new ArrayList<Book>();
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
				book.setPublisher(rs.getString("publisher"));
				book.setPublishedYear(rs.getInt("publishedYear"));
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
		
	}
	
	public Book getBook(String title) {
		int index = searchBookByName(title);
		if (index == -1) {
			return new Book();
		}
		return getAllBooks().get(index);
	}
	
	public Book getBook(int id) {
		String query = "SELECT * FROM Book WHERE id = " + id;
		Statement st;
		Book book = new Book();
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
				book.setPublisher(rs.getString("publisher"));
				book.setPublishedYear(rs.getInt("publishedYear"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
		
	}
	
	public Book deleteBook(int id) {
		Book deletedBook = getBook(id);
		String query = "DELETE FROM Book where id = " + id;
		try {
			Statement st = con.createStatement();
			int rowsAffected = st.executeUpdate(query);
			System.out.println(rowsAffected + " rows affected.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedBook;
	}
	
	public List<Book> deleteBooks() {
		String query = "DELETE FROM Book;";
		List<Book> books = getAllBooks();
		try {
			Statement st = con.createStatement();
			int rowsAffected = st.executeUpdate(query);
			System.out.println(rowsAffected + " rows affected.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return books;
	}
	
	public Book updateBook(int id, Book newBook) {
		Book previousBook = getBook(id);
		if (previousBook.getId() == 0) {
			return previousBook;
		}
		String query = "UPDATE Book set title = ?, writer = ?, publisher = ?, publishedYear = ? where id = ?";
		PreparedStatement st;
		try {
			st = con.prepareStatement(query);
			st.setString(1, newBook.getTitle());
			st.setString(2, newBook.getWriter());
			st.setString(3, newBook.getPublisher());
			st.setInt(4, newBook.getPublishedYear());
			st.setInt(5, id);
			int rowsAffected = st.executeUpdate();
			System.out.println(rowsAffected + " rows affected");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return previousBook;
	}
}
