package Ch2_Implementation;

public class Q12_김민주2 {
	
	private int n;
	private boolean[][] cols, rows;
	private final int COLUMN=0, ROW=1, REMOVE=0, ADD=1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] solution(int n, int[][] build_frame){
		this.n=n;
		int count=0;//리턴 정답 배열의 크기를 계산 
		
		//1~n+1 까지만 사용 , 양쪽에 1씩 더한 이유는 보 삭제하기 위해(양쪽에 보가 연결되어 있는 경우)
		cols=new boolean[n+3][n+3];
		rows=new boolean[n+3][n+3];
		
		for(int []frame:build_frame) {
			int x=frame[0]+1;
			int y=frame[1]+1;
			
			if(frame[2]==COLUMN) {
				if(frame[3]==ADD&&isExistCol(x,y)) {
					cols[x][y]=true; //설치 
					count++;
				}
				if(frame[3]==REMOVE&&canRemove(x,y,COLUMN))	{
					cols[x][y]=false; //삭제 
					count--;
				}
			}else {
				if(frame[3]==ADD&&isExistRow(x,y)) {
					rows[x][y]=true; //설치 
					count++;
				}
				if(frame[3]==REMOVE&&canRemove(x,y,ROW)) {
					rows[x][y]=false; //삭제 
					count--;
				}
			}
		}
		
		int[][] answer=new int[count][3];
		int index=0;
		for(int i=1;i<=n+1;i++) {
			for(int j=1;j<=n+1;j++) {
				if(cols[i][j])answer[index++]=new int[] {i-1, j-1, COLUMN};
				if(rows[i][j])answer[index++]=new int[] {i-1, j-1, ROW};
			}
		}
		
		return answer;
	}
	
	private boolean isExistCol(int x, int y) {
		return y==1||cols[x][y-1]||rows[x][y]||rows[x-1][y];
	}
	
	private boolean isExistRow(int x, int y) {
		return cols[x][y-1]||cols[x+1][y-1]||(rows[x-1][y]&&rows[x+1][y]);
	}
	
	private boolean canRemove(int x, int y, int type) {
		boolean result=true;
		
		//먼저삭제 
		if(type==COLUMN) cols[x][y]=false;
		else rows[x][y]=false;
		
		//남아있는 구조물 전수조사 -> 조건 만족하지못한다면 false
		loop:
			for(int i=1;i<=n+1;i++) {
				for(int j=1;j<=n+1;j++) {
					if(cols[i][j]&&!isExistCol(i,j)) {
						result=false;
						break loop;
					}
					if(rows[i][j]&&!isExistRow(i,j)) {
						result=false;
						break loop;
					}
				}
			}
		
		//다시 원상 복구 
		if(type==COLUMN) cols[x][y]=true;
		else rows[x][y]=true;
		
		return result;
		//false 리턴하면 삭제하지 않고 true 리턴하면 삭제 (solution 함수에서)
	}
}
