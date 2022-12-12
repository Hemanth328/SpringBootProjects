package com.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.org.entity.Movie;
import com.org.repository.MovieRepo;

@Service("movieimpl")
public class MovieMgmtServiceImpl implements IMovieMgmtService {
	
	@Autowired
	private MovieRepo movieRepo;
	
	
	@Override
	public String removeMoviesByIds(List<Integer> ids) {
		List<Movie> list = movieRepo.findAllById(ids);
		int moviesCount = list.size();
		
		if(moviesCount!= 0) {
			movieRepo.deleteAllByIdInBatch(ids);
			
			return moviesCount+" Records have been deleted";
			
		} else  {
			return "No Id's are available to deltete";
		}
		
		/*
		 * No Need of If condition cause in the sql query it is using or clause(in)
		 * 
		 * if(moviesCount!= 0 && moviesCount == ids.size()) {
			movieRepo.deleteAllByIdInBatch(ids);
			
			return moviesCount+" Records have been deleted";
			
		} else  {
			return "No Id's are given to delete or either some of the Id's are not available to deltete";
		}*/
	}
	
	
	
	@Override
	public List<Movie> searchMoviesByMovie(Movie movie, boolean asc, String... props) {
		
		Example<Movie> example = Example.of(movie);  // Of Avoids the possibility of Null pointer Exception
		
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC, props);
		
		List<Movie> list = movieRepo.findAll(example, sort);
		
		return list;
	}
	
	
	
	
	@Override
	public Movie searchMovieById(Integer id) {
		
		Movie movie = movieRepo.getReferenceById(id);  // If Id is not found directly it will throw an exception so findById(crudRepo) is prefered cause we can handle if the id is null
		System.out.println("Movie Object Class Name : "+movie.getClass());
		return movie;
		
	}
}
