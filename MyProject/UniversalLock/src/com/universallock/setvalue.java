package com.universallock;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class setvalue extends Application{

	private static String pinvalue,ring;
	private static String ab1,ab2,ab3,ab4,ab5,ab6,ab7,ab8,ab9;
	private static int a1,a2,a3,a4,a5,a6,a7,a8,a9;
	public  String getpinvalue(){return pinvalue;}
	private  String MyPREFERENCESS = "MyUserChoices";
	private  SharedPreferences sharedPreferences;
	
	public String getpinvString(){if(pinvalue != null){ pinvalue = sharedPreferences.getString("pin_vl", "");}return pinvalue;}
	public void setpinvalue(String pinvalue)
	{
		 sharedPreferences = getSharedPreferences(MyPREFERENCESS, Context.MODE_PRIVATE);
		this.pinvalue = pinvalue; 
		sharedPreferences.edit().putString("pin_vl", this.pinvalue).commit();
	}
	
	public String getimagevalue1(){ if(ab1 != null){ ab1 = sharedPreferences.getString("ss1", "");} return ab1;}
	public String getimagevalue2(){ if(ab2 != null){ab2 = sharedPreferences.getString("ss2", "");}return ab2;}
	public String getimagevalue3(){ if(ab3 != null){ ab3 = sharedPreferences.getString("ss3", "");}return ab3;}
	public String getimagevalue4(){ if(ab4 != null){ab4 = sharedPreferences.getString("ss4", "");}return ab4;}
	public String getimagevalue5(){ if(ab5 != null){ab5 = sharedPreferences.getString("ss5", "");}return ab5;}
	public String getimagevalue6(){ if(ab6 != null){ab6 = sharedPreferences.getString("ss6", "");}return ab6;}
	public String getimagevalue7(){ if(ab7 != null){ab7 = sharedPreferences.getString("ss7", "");}return ab7;}
	public String getimagevalue8(){ if(ab8 != null){ab8 = sharedPreferences.getString("ss8", "");}return ab8;}
	public String getimagevalue9(){ if(ab9 != null){ab9 = sharedPreferences.getString("ss9", "");}return ab9;}
	
	public void setimagevalue(String ab1,String ab2,String ab3,String ab4,String ab5,String ab6,
			String ab7,String ab8,String ab9){
		sharedPreferences = getSharedPreferences(MyPREFERENCESS, Context.MODE_PRIVATE);
		this.ab1 = ab1;this.ab2 = ab2;this.ab3 = ab3;this.ab4 = ab4;this.ab5 = ab5;
		this.ab6 = ab6;this.ab7= ab7;this.ab8 = ab8;this.ab9 = ab9;
		sharedPreferences.edit().putString("ss1", this.ab1).commit();sharedPreferences.edit().putString("ss1", this.ab2).commit();
		sharedPreferences.edit().putString("ss3", this.ab3).commit();sharedPreferences.edit().putString("ss1", this.ab4).commit();
		sharedPreferences.edit().putString("ss5", this.ab5).commit();sharedPreferences.edit().putString("ss1", this.ab6).commit();
		sharedPreferences.edit().putString("ss7", this.ab7).commit();sharedPreferences.edit().putString("ss1", this.ab8).commit();
		sharedPreferences.edit().putString("ss9", this.ab9).commit();
	}
	
	public int getimageposition1(){if(a1 == 0){a1 = 0;}else{a1 = sharedPreferences.getInt("ip1", 0);}return a1;}
	public int getimageposition2(){if(a2 == 0){a2 = 0;}else{a2 = sharedPreferences.getInt("ip2", 0);}return a2;}
	public int getimageposition3(){if(a3 == 0){a3 = 0;}else{a3 = sharedPreferences.getInt("ip3", 0);}return a3;}
	public int getimageposition4(){if(a4 == 0){a4 = 0;}else{a4 = sharedPreferences.getInt("ip4", 0);}return a4;}
	public int getimageposition5(){if(a5 == 0){a5 = 0;}else{a5 = sharedPreferences.getInt("ip5", 0);}return a5;}
	public int getimageposition6(){if(a6 == 0){a6 = 0;}else{a6 = sharedPreferences.getInt("ip6", 0);}return a6;}
	public int getimageposition7(){if(a7 == 0){a7 = 0;}else{a7 = sharedPreferences.getInt("ip7", 0);}return a7;}
	public int getimageposition8(){if(a8 == 0){a8 = 0;}else{a8 = sharedPreferences.getInt("ip8", 0);}return a8;}
	public int getimageposition9(){if(a9 == 0){a9 = 0;}else{a9 = sharedPreferences.getInt("ip9", 0);}return a9;}
	
	public void setimageposition(int a1,int a2,int a3,int a4,int a5,int a6,int a7,int a8,int a9){
		sharedPreferences = getSharedPreferences(MyPREFERENCESS, Context.MODE_PRIVATE);
		this.a1 = a1;this.a2 = a2;this.a3 = a3;this.a4 = a4;this.a5 = a5;this.a6 = a6;this.a7 = a7;
		this.a8 = a8;this.a9 = a9;
		if(this.a1 == 0 ){sharedPreferences.edit().putInt("ip1", 0).commit();}else{sharedPreferences.edit().putInt("ip1", this.a1).commit();}
		if(this.a2 == 0 ){sharedPreferences.edit().putInt("ip2", 0).commit();}else{sharedPreferences.edit().putInt("ip2", this.a2).commit();}
		if(this.a3 == 0 ){sharedPreferences.edit().putInt("ip3", 0).commit();}else{sharedPreferences.edit().putInt("ip3", this.a3).commit();}
		if(this.a4 == 0 ){sharedPreferences.edit().putInt("ip4", 0).commit();}else{sharedPreferences.edit().putInt("ip4", this.a4).commit();}
		if(this.a5 == 0 ){sharedPreferences.edit().putInt("ip5", 0).commit();}else{sharedPreferences.edit().putInt("ip5", this.a5).commit();}
		if(this.a6 == 0 ){sharedPreferences.edit().putInt("ip6", 0).commit();}else{sharedPreferences.edit().putInt("ip6", this.a6).commit();}
		if(this.a7 == 0 ){sharedPreferences.edit().putInt("ip7", 0).commit();}else{sharedPreferences.edit().putInt("ip7", this.a7).commit();}
		if(this.a8 == 0 ){sharedPreferences.edit().putInt("ip8", 0).commit();}else{sharedPreferences.edit().putInt("ip8", this.a8).commit();}
		if(this.a9 == 0 ){sharedPreferences.edit().putInt("ip9", 0).commit();}else{sharedPreferences.edit().putInt("ip9", this.a9).commit();}
	}
	
	public String getrington(){return ring;}
	public void setrington(String ring){
		this.ring = ring;
	}
}
