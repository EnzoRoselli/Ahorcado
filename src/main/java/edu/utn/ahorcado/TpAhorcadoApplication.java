package edu.utn.ahorcado;

import edu.utn.ahorcado.model.*;
import edu.utn.ahorcado.repository.interfaces.IMatchDao;
import edu.utn.ahorcado.repository.interfaces.IUserDao;
import edu.utn.ahorcado.repository.interfaces.IWinnerDao;
import edu.utn.ahorcado.repository.interfaces.IWordDao;
import edu.utn.ahorcado.repository.mysql.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@SpringBootApplication
public class TpAhorcadoApplication {

	public static void main(String[] args) {
	   // SpringApplication.run(TpAhorcadoApplication.class, args);

		try {
			Connection conn = ConnectionMySQL.getConnection();

			IWinnerDao winnerDao = new WinnerMySQLDao(conn);
			IUserDao userDao = new UserMySQLDao(conn);
			IWordDao wordDao = new WordMySQLDao(conn);
			IMatchDao matchDao = new MatchMySQLDao(conn);

			Word palabra = wordDao.getRandomWord();
			Match match = new Match(palabra, winnerDao);

			UserLocal jug1 = new UserLocal(userDao.getById(1), match);
			UserVisit jug2 = new UserVisit(userDao.getById(2), match);

			Thread threadJug1 = new Thread(jug1);
			Thread threadJug2 = new Thread(jug2);

//			long millis = System.currentTimeMillis();
//			Date fecha = new Date(millis);
//
//			Winner ganador = new Winner(1,4,fecha);
//			winnerDao.save(ganador);

			threadJug1.start();
			threadJug2.start();

			long millis = System.currentTimeMillis();
			Date fecha = new Date(millis);

//			Winner ganador = new Winner(1,5,fecha);
//			winnerDao.save(ganador);

			matchDao.save(jug1.getId(), jug2.getId(), palabra.getId(), fecha);

			ConnectionMySQL.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
