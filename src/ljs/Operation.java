package ljs;

import ljs.Author;
import ljs.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Operation extends ConnectJDBC{
	
    public List<Book> findAll(){
        ArrayList<Book> list = new ArrayList<Book>();
        Connection conn = getConnection();
        String sql = "select * from book";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Book book = new Book();
                book.setISBN(rs.getString("ISBN"));
                book.setTitle(rs.getString("Title"));
                book.setName(getAuthorById(rs.getInt("AuthorID")).getName());
                book.setPublisher(rs.getString("Publisher"));
                book.setPrice(rs.getFloat("Price"));
                book.setPublishDate(rs.getDate("PublishDate"));
                list.add(book);
            }
            rs.close();
            ps.close();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public Boolean delete(String ISBN){
        Boolean result=false;
        String sql="delete from book where ISBN=?";
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,ISBN);
            if (ps.executeUpdate() == 1){
                result = true;
            }
            ps.close();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    private Author getAuthorById(int id){
        Connection conn=getConnection();
        Author author = new Author();
        String sql="select * from author where AuthorID=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                author.setAuthorID(id);
                author.setName(rs.getString("Name"));
                author.setAge(rs.getInt("Age"));
                author.setCountry(rs.getString("Country"));
            }
            rs.close();
            ps.close();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return author;
    }
    
    public Book getBookByISBN(String ISBN){
        Book book=new Book();
        String sql="select * from book where ISBN=?";
        Connection conn=getConnection();
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,ISBN);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                book.setISBN(ISBN);
                book.setTitle(rs.getString("Title"));
                book.setAuthorID(rs.getInt("AuthorID"));
                book.setPublisher(rs.getString("Publisher"));
                book.setPublishDate(rs.getDate("PublishDate"));
                book.setPrice(rs.getFloat("Price"));
            }
            rs.close();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        Author author=getAuthorById(book.getAuthorID());
        book.setName(author.getName());
        book.setAge(author.getAge());
        book.setCountry(author.getCountry());
        return book;
    }
    
    public List<Book> findBooksByName(String name){
        ArrayList<Book> list=new ArrayList<Book>();
        Connection conn=getConnection();
        String sql="select * from book where AuthorID in (select AuthorID from author where Name=?)";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Book book=new Book();
                book.setISBN(rs.getString("ISBN"));
                book.setTitle(rs.getString("Title"));
                book.setName(getAuthorById(rs.getInt("AuthorID")).getName());
                book.setPrice(rs.getFloat("Price"));
                book.setPublisher(rs.getString("Publisher"));
                book.setPublishDate(rs.getDate("PublishDate"));
                list.add(book);
            }
            rs.close();
            ps.close();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
