package cn.suius.violin.repository;

import cn.suius.violin.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository {

    private final ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator = new AtomicInteger();

    public boolean save(User user){
        boolean success = false;
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.put(id,user)==null;
    }

    /**
     * 返回所有用户列表
     */
    public Collection<User> findAll(){
        return repository.values();
    }
}
