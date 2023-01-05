package com.geekbrains.spring.web.configs;


import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LongGetterCached implements LongGetter {

    private final RedisTemplate<String, Long> redisTemplate;
    private LongGetter origin;

    public LongGetterCached(LongGetter origin) {
        this.origin = origin;
        redisTemplate = new RedisTemplate<>();
    }

    public long getLong(String newString) {
        if (!redisTemplate.hasKey(newString)) {
            redisTemplate.opsForValue().set(newString, origin.getLong(newString, 1L));
        }
        return (Long) redisTemplate.opsForValue().get(newString);
    }
}
