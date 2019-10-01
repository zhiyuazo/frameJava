package trytest.redis.service;

import org.springframework.data.domain.Pageable;

import trytest.redis.bean.Bird;
import trytest.redis.util.Page4Navigator;

public interface BirdService {
	public Page4Navigator<Bird> list(Pageable pageable);
    public void save(Bird bird);
    public void delete(Bird b);
    public Bird get(int id);
}
