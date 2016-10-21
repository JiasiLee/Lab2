package ljs;

import ljs.Operation;
import ljs.Book;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Date;
import java.util.List;

public class Actions extends ActionSupport{
	
	private Book book;
	private List<Book> list;
	
	private String ISBN;
	private String Title;
	private int AuthorID;
	private String Publisher;
	private Date PublishDate;
	private float Price;
	private String Name;
	private int Age;
	private String Country;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(int authorID) {
		AuthorID = authorID;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public Date getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(Date publishDate) {
		PublishDate = publishDate;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public List<Book> getList() {
		return list;
	}
	public void setList(List<Book> list) {
		this.list = list;
	}
	
	public String findAllbooks(){
        Operation op = new Operation();
        setList(op.findAll());
        return "list";
    }
	
	public String Delete(){
        Operation op = new Operation();
        if(op.delete(ISBN))
            return "success";
        else
            return "error";
    }
	
	public String Edit(){
        Operation op = new Operation();
        book = op.getBookByISBN(ISBN);
        if(book.getName() == null||"".equals(book.getName()))
            return "error";
        else
            return "success";
    }
	
    public String findbook(){
        Operation op = new Operation();
        list = op.findBooksByName(Name);
        if(list == null)
            return "error";
        else
            return "success";
    }
}
