package com.metacube.bookinventory;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pojo.Book;
import repositories.BookRepository;

@Path("books")
public class BookResource {

	private BookRepository repo = new BookRepository();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String createBook(Book newBook) {
		System.out.println(newBook);
		int rowsAffected = repo.createBook(newBook);
		if (rowsAffected == 0) {
			return "Entry could not be made.";
		}
		return "Book successfully added.";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAllBooks() {
		return repo.getAllBooks();
	}
	
	@GET
	@Path("{bookName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookByName(@PathParam("bookName") String title) {
		return repo.getBook(title);
	}
	
	@DELETE
	@Path("{bookId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book deleteBook(@PathParam("bookId") int id) {
		return repo.deleteBook(id);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> deleteAllBooks() {
		return repo.deleteBooks();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{bookId}")
	public Book updateBook(@PathParam("bookId") int id, Book newBook) {
		return repo.updateBook(id, newBook);
	}
}
