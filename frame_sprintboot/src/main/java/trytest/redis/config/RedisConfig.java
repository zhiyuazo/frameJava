package trytest.redis.config;
import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
 
@Configuration
@EnableCaching
//Redis 缓存配置类
public class RedisConfig extends CachingConfigurerSupport {
 
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory  factory) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.PUBLIC_ONLY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
//        redisTemplate.setKeySerializer(stringSerializer);
//        redisTemplate.setHashKeySerializer(stringSerializer);  
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);         
//        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        
        RedisCacheConfiguration config =  RedisCacheConfiguration.defaultCacheConfig();//get a default cfg
								config.entryTtl(Duration.ofSeconds(60)); //set the default expired time
								config.disableCachingNullValues();  //none-cache Null value..
								
		Set<String> cacheNames = new HashSet<>();
		cacheNames.add("my-redis-cache1");
		cacheNames.add("my-redis-cache2");
		Map<String,RedisCacheConfiguration> cfgMap = new HashMap<>();
		cfgMap.put("my-redis-cache1", config);
		cfgMap.put("my-redis-cache2", config.entryTtl(Duration.ofSeconds(120)));
		
        CacheManager cacheManager =  RedisCacheManager.builder(factory)
        							 .initialCacheNames(cacheNames)
        							 .withInitialCacheConfigurations(cfgMap)
        							 //.cacheDefaults(config)
        							 .build();
        return cacheManager;
  
    }
    
}