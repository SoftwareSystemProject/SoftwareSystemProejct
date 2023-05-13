package com.example.jpetstore.controller;

import org.springframework.beans.support.PagedListHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.example.jpetstore.domain.Category;
import com.example.jpetstore.domain.Product;


/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */
@Controller
public class TestCont { 

   @Autowired
   DataSource ds;
   
   
   @RequestMapping(value="/test/{id}/{name}", method = RequestMethod.GET)
   public String handleRequest2(@PathVariable String id, @PathVariable String name) 
           throws Exception {
      System.out.println(id + ", " + name);
      Connection conn = ds.getConnection();
      PreparedStatement stmt = conn.prepareStatement(
         "INSERT INTO Member (User_ID, USER_Name) VALUES (?, ?)");
      stmt.setString(1, id);
      stmt.setString(2, name);
      stmt.executeUpdate();
      System.out.println("inserted");     
      return "redirect:/";
   }
}