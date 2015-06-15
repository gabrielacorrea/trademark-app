package com.trademark.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;

public class ApagarPostagensReminder {
	Timer timer;

    public ApagarPostagensReminder(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(),0, seconds*1000);
    }

    class RemindTask extends TimerTask {
    	int cont = 3;
        public void run() {
        	if(cont > 0){
        		apagarPostagens();
        		System.out.println("Exec Scheduler.");
        		cont--;
        	}else{
        		System.out.println("End Scheduler.");
        		timer.cancel(); //Terminate the timer thread
        	}
        }
    }

    public static void main(String args[]) {
        new ApagarPostagensReminder(5);
        System.out.println("Starting Scheduler....");
    }
    
    private void apagarPostagens(){
    	 Connection connection = null;
         try {
             Class.forName("org.postgresql.Driver");
             connection = DriverManager.getConnection(
                     "jdbc:postgresql://localhost:5432/trademark_db",
                     "postgres", "112233");

             Statement st = connection.createStatement();
             
             String sql = "DELETE FROM POSTAGENS WHERE data_inicial <= CURRENT_DATE -7";

             st.executeUpdate(sql);
             connection.close();

         } catch (SQLException e) {
             e.printStackTrace();
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }

    }
}
