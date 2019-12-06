package com.subu2code.expenses_tracker.dao;

import com.subu2code.expenses_tracker.entity.Role;

public interface RoleDao {

	Role findRoleByName(String theRoleName);
}
