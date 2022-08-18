package org.zerock.persistence;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
   
   static {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public void testConnection() {
      try (Connection con = 
            DriverManager.getConnection(
                  "jdbc:oracle:thin:@localhost;1521:XE",
                  "book_ex",
                  "book_ex")){
         log.info(con);
      } catch (Exception e) {
         fail(e.getMessage());
      }
   }

}