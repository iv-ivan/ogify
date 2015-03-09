package net.ogify.engine.friends;

import com.google.common.cache.CacheLoader;
import net.ogify.engine.vkapi.exceptions.VkSideError;

import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * Created by melges on 09.03.2015.
 */
public class ExtendedFriendCacheLoader extends CacheLoader<Long, Set<Long>> {
    @Override
    public Set<Long> load(Long userId) throws VkSideError, ExecutionException {
        return FriendProcessor.loadExtendedFriendList(userId);
    }
}
