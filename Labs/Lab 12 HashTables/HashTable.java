// HashTable.java

public class HashTable<Key, Value> {
    private Value[] values;
    private Key[] keys;
    private int maxSize;
    
    // used for reporting
    private int items;
    private int collisions;

    public HashTable(int size) {
        maxSize = size;
        
        // make the arrays, with the workaround for Java not allowing generic arrays
        values = (Value[]) new Object[maxSize];
        keys =  (Key[]) new Object[maxSize];
        
        // start with nothing
        collisions = 0;
        items = 0;
    }

    public void report() {
        System.out.println("With " + items + " items, there are " + collisions + " collisions.");
    }

    // insert a key/value pair
    public void insert(Key key, Value value) {
        // get the index by hashing the key
        int index = Math.abs(key.hashCode()) % maxSize;

        // linear probe until we find an empty name
        while (values[index] != null) {
            index = (index + 1) % maxSize;
            collisions++;
        }

        // insert the value and key here
        values[index] = value; 
        keys[index] = key;
        items++;
    }

    // lookup a value by its key
    public Value lookup(Key key) {
        // the index they should be at
        int index = Math.abs(key.hashCode()) % maxSize;

        // linear probe until we find the key matches, or are sure it's not here
        while (true) {
            // if this is null, it must not have been found
            if (keys[index] == null) {
                return null;
            }

            // if it's equal, we found it
            if (keys[index].equals(key)) {
                return values[index];
            }
            
            // move to next one
            index = (index + 1) % maxSize;
        }
    }
}

