
package com.electriHome.electriHome.respositories;

import com.electriHome.electriHome.models.User;
import java.util.List;
import org.springframework.data.repository.Repository;

/**
 *
 * @author elvis_agui
 */
public interface UserRepositori extends Repository<User, String>{
    public List<User> findAll();
}
