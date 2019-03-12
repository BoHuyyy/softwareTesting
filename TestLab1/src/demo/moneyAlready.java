package demo;

public class moneyAlready {
	private int fifty=1;
	private int twenty=1;
	private int five=2;
	private int one = 3;
	
	public int find(int count){
		int flag=0;
		for(int i=0;i<=fifty;i++){
			for(int j=0;j<=twenty;j++){
				for(int k=0;k<=five;k++){
					for(int m=0;m<=one;m++){
						if(50*i+20*j+5*k+m==count){
							System.out.println(i+"张50元、"+j+"张20元、"+k+"张5元、"+m+"张一元。");
							flag=1;
						}
					}
				}
			}
		}
		if(flag==0){
			System.out.println("未找到结果");
		}
		return flag;
	}
}
