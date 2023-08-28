package com.learning.learningspring;


public class Student {
    public String name;
    public int score;
    
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public int getScore() {
		// TODO Auto-generated method stub
		return this.score;
	}

	public void setScore(int score) {
		// TODO Auto-generated method stub
		this.score = score;
	}

   public String toString()
   {
	   return String.format(name + " " + score);
   }
}