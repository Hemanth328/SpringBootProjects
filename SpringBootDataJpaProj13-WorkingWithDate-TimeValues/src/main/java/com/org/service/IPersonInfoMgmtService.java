package com.org.service;

import java.util.List;

import com.org.entity.PersonInfo;

public interface IPersonInfoMgmtService {
	public String registerPersonInfo(PersonInfo info);
	public List<PersonInfo> fetchAllPersonDetails();
}
