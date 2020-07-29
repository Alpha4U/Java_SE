package com.tnb.time;


public class GetTime {
	
	private int hour=0;
	private int min=0;
	private int sec=0;
	
	public void setTime(int hour,int min, int sec){
		this.hour = 4;
		this.min = 5;
		this.sec = 6;
	}
	
//	public void setTime(int h,int m, int s){
//		hour = ((h>0 && h<24) ?h:0);
//		min = ((m>0 && m<60)?m:0);
//		sec = ((s>0 && s<60)?s:0);
//	}
	
	public String toMillitary(){	
		return String.format("%02d:%02d:%02d",hour,min,sec);
	}
	
	public String toString(){
		return String.format("%d:%02d:%02d %s",((hour==0 || hour==12)?12:(hour%12)),min,sec,((hour<12)?"AM":"PM") );
	}

}
