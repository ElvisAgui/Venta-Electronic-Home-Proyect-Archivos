
package com.electriHome.electriHome.implemets;

import com.electriHome.electriHome.models.User;
import com.electriHome.electriHome.respositories.UserRepositori;
import com.electriHome.electriHome.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author elvis_agui
 */
@Service
public class UserImplement implements UserService{
    @Autowired
    private UserRepositori userRepositore;

    @Override
    public List<User> list() {
        return userRepositore.findAll();
    }
}
