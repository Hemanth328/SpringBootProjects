package com.org.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.entity.PersonInfo;
import com.org.repository.PersonInfoRepo;

@Service("personServ")
public class PersonInfoMgmtServiceImpl implements IPersonInfoMgmtService {

	@Autowired
	private PersonInfoRepo repo;
	
	@Override
	public String registerPersonInfo(PersonInfo info) {
		
		return repo.save(info).getPid()+" Id Person details are saved";
	}

	@Override
	public List<PersonInfo> fetchAllPersonDetails() {
		
		return repo.findAll();
	}
	
	@Override
	public PersonInfo fetchPersonDetailsById(int pid) {
		Optional<PersonInfo> opt = repo.findById(pid);
		
		if(opt.isPresent())
			return opt.get();
		else
			return null;
	}

}
