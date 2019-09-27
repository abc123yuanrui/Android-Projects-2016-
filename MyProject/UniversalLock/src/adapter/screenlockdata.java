package adapter;

import android.widget.Switch;

public class screenlockdata
{
  private static int img;
  private static Switch sw;
  private String desc;
  private String name;
  
  public screenlockdata(String paramString)
  {
    this(paramString, "", img, sw);
  }
  
  public screenlockdata(String paramString1, String paramString2, int paramInt, Switch paramSwitch)
  {
    this.name = paramString1;
    this.desc = paramString2;
    img = paramInt;
    sw = paramSwitch;
  }
}
