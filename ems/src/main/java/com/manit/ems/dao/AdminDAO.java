package com.manit.ems.dao;

import com.manit.ems.entity.Admin;

public interface AdminDAO {
	
	public Admin getAdminByEmail(String email);

}
