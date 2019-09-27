package adapter;

import android.view.LayoutInflater;

public interface SwitchInterface {
    String posi = null;
    String vibratorv = null;
    String status = null;
    String lsb = null;
	public void setValues(int posi2);
	
	public void setValue(int vval);
	
	public void setstatusbar(int statusb);

	public void setlsb(int lsb);
}
