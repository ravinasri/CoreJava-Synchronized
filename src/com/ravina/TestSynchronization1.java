package com.ravina;


class Message 
{
	public synchronized void msg() throws InterruptedException
	{
		for(int i=0;i<=5;i++)
		{
			System.out.println(i);
			Thread.sleep(1500);
		}
	}
}

 class First extends Thread
{
	Message m1;
	
	
	
	public First(Message m2) {
	this.m1=m2;	
	}



	public void run()
	{
		try {
			m1.msg();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

 class Second extends Thread
{
	Message m2;
	Second(Message m2)
	{
		this.m2=m2;
	}
	public void run()
	{
		try {
			m2.msg();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


public class TestSynchronization1 
{
	public static void main(String args[]) throws InterruptedException
	{
		Message m1=new Message();
		First t1=new First(m1);
		t1.start();
		Second t2=new Second(m1);
		t2.start();
		
		
		
	}
}