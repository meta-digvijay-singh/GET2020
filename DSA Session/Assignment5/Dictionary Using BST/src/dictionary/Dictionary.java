package dictionary;

import java.util.Map;

/**
 * Represents dictionary
 * @author Digvijay
 *
 */
public interface Dictionary {
    
    /**
     * Gives value for the specified key.
     * @param key : key in the dictionary.
     * @return value if found.
     * @throws Exception if key does not exist.
     */
    String getValue(int key) throws Exception;
    
    /**
     * Put the key and value in the dictionary.
     * @param key : key
     * @param value : value
     */
    void put(int key, String value);
    
    /**
     * Delete the specified key if present.
     * @param key : key
     * @return value present at the specified key.
     * @throws Exception if key does not exist.
     */
    String delete(int key) throws Exception;
    
    /**
     * Gives the sorted dictionary.
     * @return sorted key value pair.
     */
    Map<Integer, String> sort();
    
    /**
     * Gives the sorted dictionary within the given range [key1, key2].
     * @param key1 : the lower bound.
     * @param key2 : the upper bound.
     * @return sorted key value pair.
     */
    Map<Integer, String> sort(int key1, int key2);
}
