package com.dotsafrica.dotsafrica.extend;

import com.dotsafrica.dotsafrica.entity.AppUser;
import com.dotsafrica.dotsafrica.request.UserRequest;

/**
 * @author Ismail
 * 
 * A class to add a user in the database
 */
public interface UserServices {

    /**
     * Adding a user in the database
     * 
     * @param user username of the new user
     * @return username
     */
    String addUser(UserRequest user);

    /**
     * Get user from the database
     * 
     * @param username username of the user
     * @return user
     */
    AppUser findUserbyUsername(String username);
}
