package com.dotsafrica.dotsafrica.extend;

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
}
