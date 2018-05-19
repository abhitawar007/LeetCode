package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LRUCache
{
	int capacity;
	List<Integer> cache;
	HashMap<Integer, Integer> map;

	public LRUCache(int _capacity)
	{
		capacity = _capacity;
		cache = new ArrayList<Integer>();
		map = new HashMap<Integer, Integer>();
	}

	public int get(int key)
	{
		/*
		 * Get the value (will always be positive) of the key if the key exists in the
		 * cache, otherwise return -1.
		 */
		int ret = -1;
		if (cache.contains(key))
		{
			ret = map.get(key);
			updateCache(key);
		}
		return ret;
	}

	public void put(int key, int value)
	{
		/*
		 * Set or insert the value if the key is not already present. When the cache
		 * reached its capacity, it should invalidate the least recently used item
		 * before inserting a new item.
		 */

		if (!cache.contains(key))
		{
			if (cache.size() == capacity)
				trim();
		}
		map.put(key, value);
		updateCache(key);
	}

	private void updateCache(int key)
	{
		/*
		 * Make the key as most recently used element
		 */

		if (!cache.contains(key))
			cache.add(key);

		if (cache.get(0) == key)
			return;

		int i = 1, prev = cache.get(0), curr = 0;
		while (cache.get(i) != key)
		{
			curr = cache.get(i);
			cache.set(i, prev);
			prev = curr;
			i++;
		}
		cache.set(i, prev);
		cache.set(0, key);
	}

	private void trim()
	{
		/*
		 * Remove the least recently used key from cache
		 */
		map.remove(cache.get(cache.size() - 1));
		cache.remove(cache.size() - 1);
	}
}
