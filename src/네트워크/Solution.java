package 네트워크;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {

		int[][] computers= {{1,1,0},{1,1,1},{0,1,1}};
		System.out.println(solution(3,computers));
	}

	 public static int solution(int n, int[][] computers) {
	        int answer = 0;
	        boolean check[]=new boolean[n];
	        for(int i=0;i<n;i++)
	        {
	        	if(!check[i]) // 현재 노드를 방문하지 않았을 때
	        	{
	        		answer++;
	        		bfs(i,check,computers);
	        	}
	        }
	        return answer;
	 }
	 
	 static void bfs(int idx,boolean[] check,int[][] computers)
	 {
		 Queue<Integer> q= new LinkedList<>();
		 
		 q.offer(idx);
		 
		 while(!q.isEmpty())
		 {
			 int index=q.poll();

				 for(int i=0;i<check.length;i++)
				 {
					 if(computers[index][i]==1&&!check[i])
					 { 
						check[i]=true;
					 	q.offer(i);
					 }
				 }
		 }
	 }
}
