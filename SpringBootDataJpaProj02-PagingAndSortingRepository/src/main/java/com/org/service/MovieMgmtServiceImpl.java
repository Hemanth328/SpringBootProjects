package com.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.org.entity.Movie;
import com.org.repository.MovieRepo;

@Service("movieimpl")
public class MovieMgmtServiceImpl implements IMovieMgmtService {
	
	@Autowired
	private MovieRepo movierepo;
	
	@Override
	public Iterable<Movie> displayMoviesByOrder(boolean asc, String... properties) {
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC, properties);
		return movierepo.findAll(sort);
	}
	
	@Override
	public Page<Movie> generateReport(int pageNo, int pageSize, boolean asc, String... props) {
		// Create Pageable Object
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(asc?Direction.ASC:Direction.DESC, props));
		//get Requested page records
		Page<Movie> page = movierepo.findAll(pageable);
		
		return page;
	}
	
	//===========================================================================================================================================
	
	@Override
	public void  generateMoviesReport(int pageSize) {
		 //get count of records
		 long recordsCount=movierepo.count();
		 //decide no.of pages (pagesCount)
		 long pagesCount=0;
		 
		 if(pageSize>=1) {
			 pagesCount=recordsCount/pageSize;
			 // get exact pagesCount
			 pagesCount=recordsCount%pageSize==0?pagesCount:++pagesCount;
		 }
		 else {
			 throw new IllegalArgumentException("PageSize can not be <=Zero");
		 }
		 
		 for(int pageNo=0;pageNo<pagesCount;++pageNo) {
			 //prepare pageable object
			 Pageable pageable=PageRequest.of(pageNo, pageSize);
			 Page<Movie> page=movierepo.findAll(pageable);
			 
			 System.out.println("\n*******page no::"+(pageNo+1)+" pageSize: "+pageSize+" pageRecords count:: "+page.getNumberOfElements()+"*******\n");
			 List<Movie> list=page.getContent();
			 list.forEach(movie->{
			 	System.out.println(movie);
			 });
		 }	 
	}
	
	//===========================================================================================================================================================
	
}
