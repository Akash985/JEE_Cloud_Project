package com.capgemini.dao;

import com.capgemini.exception.UserNotFoundException;
import com.capgemini.model.Admin;

public interface AdminDao {
  Admin getAdminbyUserName(String adminUserName) throws UserNotFoundException;
}
