package 단어변환;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		String[] words= {"hot","dot","dog","lot","log","cog"};
		System.out.println(solution("hit","cog",words));
	}

	 public static int solution(String begin, String target, String[] words) {
	        int answer = 0;
	        boolean check[]=new boolean[words.length];
	        answer+=bfs(begin,target,words,check);
	        return answer;
	 }
	 
	 static int bfs(String begin, String target, String[] words,boolean[] check)
	 {
		 Queue<Pair> q = new LinkedList<>();
		 
		 q.offer(new Pair(begin,0));
		 
		 while(!q.isEmpty())
		 {
			 String str= q.peek().str;
			 int num=q.peek().num;
			 q.poll();
			 // 종료 조건
			 if(str.equals(target)) 
			 {
				 return num;
			 }
			 // 배열에 있는 단어를 검색
			 for(int i=0;i<words.length;i++)
			 {
				 if(check[i])continue;
				 int cnt=0;
				 // 단어 한글자씩 비교
				 for(int j=0;j<words[0].length();j++)
				 {
					 if(str.charAt(j)!=words[i].charAt(j))cnt++;
					 if(cnt>1)break;
				 }
				 if(cnt<=1)
				 {
					 check[i]=true;
					 q.offer(new Pair(words[i],num+1));
				 }
			 }
		 }
		 return 0;
	 }
	 
	 static class Pair{
		 String str;
		 int num;
		public Pair(String str, int num) {
			super();
			this.str = str;
			this.num = num;
		}
	 }
}
