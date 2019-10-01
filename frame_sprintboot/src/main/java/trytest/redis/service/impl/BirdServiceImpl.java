package trytest.redis.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import trytest.redis.bean.Bird;
import trytest.redis.dao.BirdDao;
import trytest.redis.service.BirdService;
import trytest.redis.util.Page4Navigator;

@Service
@CacheConfig(cacheNames="bird")  //all date into bird-group In Redis
public class BirdServiceImpl implements BirdService	{
	@Autowired BirdDao birdDao;
	
	@Override
	@Cacheable(key="'bird '+#p0.offset + '-' + #p0.pageSize ")
	public Page4Navigator<Bird> list(Pageable pageable) {
		Page<Bird> pageFromJPA=  birdDao.findAll(pageable);
        Page4Navigator<Bird> page = new Page4Navigator<>(pageFromJPA,5);
		return page;
	}

	@Override
	@CacheEvict(allEntries=true)
	public void save(Bird bird) {
		birdDao.save(bird);
	}

	@Override
	@CacheEvict(allEntries=true)
	public void delete(Bird b) {
		birdDao.delete(b);
	}

	@Override
	@Cacheable(key="'bird '+ #p0")
	public Bird get(int id) {
		Bird b =birdDao.getOne(id);
		return b;
	}

}
