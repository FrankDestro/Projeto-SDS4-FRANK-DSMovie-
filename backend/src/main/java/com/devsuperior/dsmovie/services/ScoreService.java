package com.devsuperior.dsmovie.services;

import java.text.SimpleDateFormat;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.config.repositories.MovieRepository;
import com.devsuperior.dsmovie.config.repositories.ScoreRepository;
import com.devsuperior.dsmovie.config.repositories.UserRepository;
import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;

@Service
public class ScoreService {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScoreRepository scoreRepository;
	
	private Instant registrationDate =(Instant.now());
	
							//private Long movieid; 
						   //private String email;
						  //private Double score;
	@Transactional        //        |   
	public MovieDTO saveScore(ScoreDTO dto) {
		
		// buscar email no banco de dados se for null(nao estiver cadastrado) ele cadastra um novo usuario no metodo saveAndFlush.
		User userEmail = userRepository.findByEmail(dto.getEmail());
		if (userEmail == null) {
			userEmail = new User();
			userEmail.setCreatedAt(registrationDate);
			userEmail.setEmail(dto.getEmail());
			
			userEmail = userRepository.saveAndFlush(userEmail);
		}
		
		// buscando Movie do banco de dados. 
		Movie movie_id = movieRepository.findById(dto.getMovieid()).get();
		
		// Salvando Score
		Score score = new Score();
		score.setMovie(movie_id);
		score.setUser(userEmail);
		score.setValue(dto.getScore());	
		score.setRegistrationDate(registrationDate);
		score = scoreRepository.saveAndFlush(score);
				
		double sum = 0.0;
		for (Score s : movie_id.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie_id.getScores().size();
		
		movie_id.setScore(avg);
		movie_id.setCount(movie_id.getScores().size());
		movie_id = movieRepository.save(movie_id);
	
		return new MovieDTO(movie_id);
	}
}
