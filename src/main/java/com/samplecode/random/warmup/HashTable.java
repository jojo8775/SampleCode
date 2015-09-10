package com.samplecode.random.warmup;

import java.lang.reflect.Array;

public class HashTable<K,V>
{
	private Entry<K,V>[] table = (Entry<K, V>[]) Array.newInstance(Entry.class, 128);
	private int count = 0;
	
	
	public void add(K key, V val)
	{
		if(key == null || val == null)
		{
			throw new IllegalArgumentException("The given key or value cannot be null");
		}
		
		int hashIndex = getHashIndex(key);
		
		if(table[hashIndex] == null)
		{
			table[hashIndex] = new Entry<K,V>(key, val); 
		}

		Entry<K,V> prevEntry = table[hashIndex];
		Entry<K,V> currentEntry = prevEntry;
		
		while(currentEntry != null)
		{
			if(currentEntry.key.equals(key))
			{
				currentEntry.value = val;
				return;
			}
			
			prevEntry = currentEntry;
			currentEntry = currentEntry.next;
		}
		
		prevEntry.next = new Entry<K,V>(key, val);
		count++;
	}
	
	public V get(K key)
	{
		if(key == null)
		{
			throw new IllegalArgumentException("The given key cannot be null");
		}
		
		int hashIndex = getHashIndex(key);
		
		Entry<K,V> entry = table[hashIndex];
		
		while(entry != null)
		{
			if(entry.key.equals(key))
			{
				return entry.value;
			}
			
			entry = entry.next;
		}
		
		return null;
	}
	
	public int size()
	{
		return count;
	}
	
	public void clear()
	{
		table = (Entry<K, V>[]) Array.newInstance(Entry.class, 128);
	}
	
	private int getHashIndex(K key)
	{
		return key.hashCode()%127;
	}
	
}

