package com.example.service;

import com.example.dao.DeveloperDao;
import com.example.dto.Developer;

public class DeveloperService {

	DeveloperDao dao = new DeveloperDao();

	public Developer addDeveloper(Developer developer) {
		return dao.saveDeveloper(developer);
	}

	public Developer updateDeveloper(Developer developer) {
		return dao.updateDeveloper(developer);

	}

	public Developer getDeveloperById(int id) {
		return dao.getDeveloperById(id);
	}

	public Developer getDeleteById(int id) {

		return dao.getDeleteById(id);
	}

}
