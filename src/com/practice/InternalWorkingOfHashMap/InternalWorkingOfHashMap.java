// Imagine a HashMap / Map as a dictionary, where each word (key) maps to a meaning (value).

// Hashing is the process of converting an object (not just a String) into a fixed-length integer value called a hash code.
// This hash value helps in indexing and faster searching.

// In Java, every object has a public int hashCode() method that returns a hash value for that object.

// equals() and hashCode() contract:
// If two objects are equal using equals(), they must return the same hashCode().

// The hash code is used by HashMap to determine where the key-value pair should be stored.

// A HashMap internally maintains an array of buckets.
// Each bucket may contain:

// No entry

// A single node

// A linked list of nodes

// A balanced tree (Java 8+)

// 🔹 How put() Works

// HashMap capacity is always a power of 2.
// The default initial capacity is 16.

// put(K key, V value) {
//     hash(key);
//     index = (n - 1) & hash;
// }


// When put() is called:

// HashMap computes the hash value of the key.

// The index is calculated using (n - 1) & hash.

// This index determines which bucket the entry belongs to.

// If another entry already exists at the same index, a collision occurs.

// The new entry is added as the next node in that bucket.

// HashMap allows one null key.

// For a null key, the hash value is treated as 0, so it is stored at index 0.

// 🔹 How get() Works
// V get(Object key) {
//     hash(key);
//     index = (n - 1) & hash;
// }


// When get() is called:

// The hash of the key is computed.

// The index is calculated using the same logic as put().

// HashMap looks at the bucket at that index.

// It compares:

// First the hash value

// Then the key using equals()

// If a match is found, the corresponding value is returned.

// In case of collision, HashMap traverses:

// Each node in the bucket

// Compares hash and then key

// Continues until a match is found

// 🔹 Java 8 Optimization (Treeification)

// In Java 8, if too many keys end up in the same bucket:

// And the bucket size exceeds TREEIFY_THRESHOLD = 8

// The linked list is converted into a balanced Red-Black Tree

// This improves worst-case performance:

// From O(n) (linked list)

// To O(log n) (balanced tree)

// This ensures HashMap remains efficient even with poor hash distributions.

package com.practice.InternalWorkingOfHashMap;

public class InternalWorkingOfHashMap
{

}
