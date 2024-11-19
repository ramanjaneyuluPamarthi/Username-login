package pack1;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductBean implements Serializable
{
	private String pid,pname,pcompany;
    private double pprice;
    private int pqty;
    
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcompany() {
		return pcompany;
	}
	public void setPcompany(String pcompany) {
		this.pcompany = pcompany;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	public int getPqty() {
		return pqty;
	}
	public void setPqty(int pqty) {
		this.pqty = pqty;
	}
	public ProductBean() {}
	/*
	 * @Override public String toString() { return "ProductBean [pid=" + pid +
	 * ", pname=" + pname + ", pcompany=" + pcompany + ", pprice=" + pprice +
	 * ", pqty=" + pqty + "]"; }
	 */
	
    
}
