package 타겟넘버;

public class Solution {

	public static void main(String[] args) {
		
		int[] numbers= {1,1,1,1,1};
		int target=3;
		System.out.println(solution(numbers,target));
	}

	 public static int solution(int[] numbers, int target) {
	        int answer =0;
	        answer=answer+ dfs(0,0,numbers,target);
	        return answer;
	 }
	 static int dfs(int cnt,int num,int[] numbers, int target)
	 {
		 int answer=0;
		 if(cnt==numbers.length)
		 {
			 if(num==target)
			 {
				 return 1;
			 }
			 return 0;
		 }
		 answer+=dfs(cnt+1,num+numbers[cnt],numbers,target);
		 answer+= dfs(cnt+1,num-numbers[cnt],numbers,target);
		 return answer;
	 }
}
