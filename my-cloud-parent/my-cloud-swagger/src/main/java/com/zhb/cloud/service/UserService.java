package com.zhb.cloud.service;

import com.zhb.cloud.domain.User;

public interface UserService {

	User getUser(String username, String password);

}
