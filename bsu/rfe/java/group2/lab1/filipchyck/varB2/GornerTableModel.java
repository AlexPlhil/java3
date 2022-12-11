package bsu.rfe.java.group2.lab1.filipchyck.varB2;

import javax.swing.table.AbstractTableModel;

import java.awt.Color;
import java.lang.Math;
public class GornerTableModel extends AbstractTableModel {

	private Double[] coefficients;
	private Double from;
	private Double to;
	private Double step;
	public GornerTableModel(Double from, Double to, Double step,Double[] coefficients) {
	this.coefficients = coefficients;
	this.from=from;
	this.to=to;
	this.step=step;
	}
	public Double getFrom() {
	return from;
	}
	public Double getTo() {
	return to;
	}
	public Double getStep() {
	return step;
	}
	public int getColumnCount() {
	return 3;
	}
	public int getRowCount() {
	return new Double(Math.ceil((to-from)/step)).intValue()+1;
	}
	public Object getValueAt(int row, int col) {
	double x = from + step*row;
	
	if (col==0) {
	
	return x;
	}else if(col==1){double result = coefficients[0]*x+coefficients[1];
	for (int i=2;i<coefficients.length;i++ )
		result+=result*x+coefficients[i];
	double scale=Math.pow(10, 5);
	result=Math.round(result*scale)/scale;;
		return result;
		}
	else 
		return getValuet(row, 2);}
	public Boolean getValuet(int row, int col) {
		double x = from + step*row;
		double scale=Math.pow(10, 5);
		double result = coefficients[0]*x+coefficients[1];
		for (int i=2;i<coefficients.length;i++ )
			result+=result*x+coefficients[i];
		result=Math.round(result*scale)/scale;
	if(col==2) {
		String result1=Double.toString(result);
	String[] result2=new String [result1.length()];
	char f='.', k,l;
	boolean t=false;
	for(int i=0; i<result1.length();i++)
	{
	if(result1.charAt(i)==f)
	{
		k=result1.charAt(i-1);
		l=result1.charAt(i+1);
		if(k==l)
		t=true;
	break;
}
	}
		return t;
		
	}
	else {boolean t=false;
	return t;
	}
	}
	public Class<?> getColumnClass(int col) {
		switch (col) {
		case 0:
		return Double.class;
		case 2:
		return Boolean.class;
		default:
		return Double.class;
		}
		}

	public String getColumnName(int col) {
	switch (col) {
	case 0:

	return "Значение X";
	case 2:
		return "Ограниченная симметрия";
	default:

	return "Значение многочлена";
	}
	}


}
