package com.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.org.repository.MovieRepo;

@Service("movieimpl")
public class MovieMgmtServiceImpl implements IMovieMgmtService {
	
	@Autowired
	private MovieRepo movieRepo;
	
}
