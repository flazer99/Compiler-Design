import java.util.*;
import javafx.util.*;
public class max_much {

	public static void main(String[] args) {
	HashMap<String,Integer> mp1 = new HashMap<>();
	HashMap<String,Integer> mp2 = new HashMap<>();
	Scanner sc = new Scanner(System.in);
	String str;
	int flag = 0, x = 0;
	int[][] arr = new int[10][10];
	int[] fi = new int[10];

	for(int i = 0; i<10; i++)
	{
		for(int j = 0; j<10; j++)
		{
			arr[i][j] = -1;
		}
	}
	
	System.out.println("Constructing dfa transition table");
	do
	{
		System.out.println("Enter the transition sequence : ");
		str = sc.nextLine();
		int temp1,temp2,temp3;
		String[] arrOfStr = str.split(" ", 5);
		
		if(!mp1.containsKey(arrOfStr[0]))
		{
			mp1.put(arrOfStr[0],(arrOfStr[0].charAt(1)-'0'));
		}
		
		if(!mp2.containsKey(arrOfStr[1]))
		{
			mp2.put(arrOfStr[1],flag);
			flag++;
		}
		
		if(!mp1.containsKey(arrOfStr[2]))
		{
			mp1.put(arrOfStr[2],(arrOfStr[2].charAt(1)-'0'));
		}
		
		temp1 = mp1.get(arrOfStr[0]);
		temp2 = mp2.get(arrOfStr[1]);
		temp3 = mp1.get(arrOfStr[2]);
		
		arr[temp1][temp2]=temp3;
		System.out.println("Do you wish to continue 0/1:-  ");
		x = sc.nextInt();
		String temp = sc.nextLine();
	}
	while(x!=1);
	System.out.println("Enter the final states ");
	str = sc.nextLine();
	String[] arrOfStr = str.split(" ", 5);
	for(int i=0;i<10;i++)
	{
		fi[i] = -1;
	}
	for(int i = 0; i<arrOfStr.length; i++)
	{
		fi[i] = mp1.get(arrOfStr[i]);
	}
	System.out.println();
	System.out.println("Printing the final states array ...");
	for(int i=0;i<10;i++)
	{
		System.out.print(fi[i]+" ");
	}
	System.out.println("Printing Transition Table ...");
//	for(int i = 0; i<10; i++) 
//	{
//		for(int j = 0; j<10; j++)
//		{
//			System.out.print(arr[i][j]+" ");
//		}
//		System.out.println();
//	}
//	System.out.println(mp1);
//	System.out.println(mp2);
	
	Stack<Integer> stack = new Stack<Integer>(); 
	
	
	System.out.println("Enter the input string:- ");
	str = sc.nextLine();
//	Pair <Integer, Integer> ans =  new Pair <Integer, Integer>null, null;
	int i = 1;
	int q = 0;
	 x = -1;
	
	while(true) 
	{
		int fin_flag = 0;
		q=0;
		stack.clear();
		stack.push(-1);
//		System.out.println("Staring i value : "+i+" and q value : "+q);
		switch(str.charAt(i-1))
		{
			case 'a': x = 0; break;
			case 'b': x = 1; break;
		}
		while( i<=str.length() && arr[q][x]!=-1 )
		{
			switch(str.charAt(i-1))
			{
				case 'a': x = 0; break;
				case 'b': x = 1; break;
			}
			
			for(int k=0;k<10;k++)
			{
				if( fi[k]!=-1 && fi[k] == q )
					{
						fin_flag++;break;
					}
			}
			if( fin_flag != 0)
			{
				stack.clear();
				stack.push(-1);
			}
			fin_flag = 0;
//			System.out.println("Stack status :- "+stack.peek()+" X = "+x); 

			stack.push(q);
			stack.push(i);
//			System.out.println("State : "+q);
			q = arr[q][x];
//			System.out.println("Dest State : "+q);
			i++;
//			System.out.println("i value : "+i);
//			System.out.println("Stack status :- "+stack.peek()); 
			if(i<=str.length()) {
			switch(str.charAt(i-1))
			{
				case 'a': x = 0; break;
				case 'b': x = 1; break;
			}}
		}
//		System.out.println("Outside !");
//		System.out.println("Before while " + q);
		while( q!=1 && q!=2 )
		{
//			System.out.println("Inside while "+q);
//			System.out.println(stack.peek());
			i = stack.pop();
			q = stack.pop();
//			i--;
			if( q == -1)
			{
				System.out.println("Failure : Tokenization not possible. " + q);
				return;
			}
			
//			System.out.println("Hey, Value of i :-"+i);
		}
		
		System.out.println("Output :- "+(i-1));
		if(i>str.length())
		{
			System.out.println("Success");
			return;
		}
		
		
	}
	
	
	}

}
