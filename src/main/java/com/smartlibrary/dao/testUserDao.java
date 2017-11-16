package com.smartlibrary.dao;

import java.util.List;

import com.smartlibrary.domain.School;
import com.smartlibrary.domain.TestGctrl;

public interface testUserDao {
	public abstract List<School> getschool(School school);
	List<TestGctrl> getGctrl();
}
