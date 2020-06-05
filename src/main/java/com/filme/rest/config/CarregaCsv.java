package com.filme.rest.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.filme.rest.entites.Filmes;
import com.filme.rest.repository.FilmesRepository;

@Configuration
public class CarregaCsv implements CommandLineRunner {

	@Autowired
	private FilmesRepository filmesRepository;

	@Override
	public void run(String... args) throws Exception {

		File file = new File("C:\\movielist.csv");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			String[] camposCsv;
			String winner = "";
			while (scanner.hasNextLine()) {

				camposCsv = scanner.nextLine().split(";");

				try {
					winner = camposCsv[4] != null ? "winner" : "";
				} catch (Exception e) {
					winner = "";
				}

				Filmes filmes = new Filmes(null, camposCsv[0], camposCsv[1], camposCsv[2], camposCsv[3], winner);

				if (!camposCsv[0].equalsIgnoreCase("year"))
					filmesRepository.save(filmes);

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();

		}

	}

}
