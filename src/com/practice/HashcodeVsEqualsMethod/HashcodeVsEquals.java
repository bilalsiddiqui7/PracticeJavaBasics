//EQUALS AND HASHCODE CONTRACT
//equals() and hashCode() work together to support correct and efficient behavior of hash-based collections like 
//HashMap and HashSet. The hashCode() method determines the bucket (location) where an object is stored, while equals() 
//determines whether two objects are logically equal. According to the contract, if two objects are equal as per equals(),
//they must return the same hashCode() so they end up in the same bucket. However, having the same hash code does not 
//guarantee equality; this is called a collision, and equals() is used to confirm equality. Also, hashCode() must 
//consistently return the same value as long as the object’s state does not change, otherwise collections may fail to find
//the object.

//Why Override BOTH Together? If you override only equals(): Objects look equal But go into different buckets ❌ If 
//you override only hashCode(): Objects go into same bucket But equals() says they are different ❌ So both must agree.

//IN SIMPLE TERMS
//1)HOW TO MAKE TWO OBJECTS LOGICALLY EQUAL IS BY OVERRIDING THE EQUALS METHOD.
//2)BY OVERRIDING THE HASHCODE FUNCTION THE HASHCODE MUST CONSISTENTLY RETURN THE SAME VALUE. SO THAT LOGICALLY SAME OBJECTS DO NOT LAND UP IN
//DIFFERENT BUCKETS

package com.practice.HashcodeVsEqualsMethod;

class Employee
{
	private int id;
	private String name;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	// How to make two objects logically equal is by overiding the equals method
	// This is how you implement the equals method in 3 steps
	public boolean equals(Object o)
	{
		// 1)If it is null or it is not of the same class
		if (o == null || this.getClass() != o.getClass())
			return false;
		// 2)If they are pointing to the same memory location
		if (o == this)
			return true;
		// 3)Create a type casted object of the Employee class and then return
		// if the id's are same or not
		Employee e = (Employee) o;
		return (this.getId() == e.getId());
	}

	public int hashcode()
	{
		return this.getId();
	}

}

public class HashcodeVsEquals
{
	public static void main(String[] args)
	{
		Employee e1 = new Employee();
		e1.setId(1);
		e1.setName("John");
		// If I make e2=e1 then I will get true for shallow copy as both e1 and
		// e2 will point to
		// the same memory, also deep copy will be true because if the objects
		// are same physically
		// then they will be same logically as well
//		Employee e2=e1;
		Employee e2 = new Employee();
		e2.setId(1);
		e2.setName("John");
		System.out.println("shallow copy " + (e1 == e2));
		//by overriding the equals method we got true for deep copy
		System.out.println("deep copy " + e1.equals(e2));
	}
}
