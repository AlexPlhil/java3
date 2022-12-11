package bsu.rfe.java.group2.lab1.filipchyck.varB2;
import java.awt.Color;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.lang.Math;
public class GornerTableCellRenderer implements TableCellRenderer {
	private Double[] coefficients;
	private Double from;
	private Double to;
	private Double step;
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel();
	private String needle = null;
	private GornerTableModel data1;
	private DecimalFormat formatter =
	(DecimalFormat)NumberFormat.getInstance();
	public GornerTableCellRenderer(Double[] coefficients) {
		
	formatter.setMaximumFractionDigits(5);
	formatter.setGroupingUsed(false);
	DecimalFormatSymbols dottedDouble =
	formatter.getDecimalFormatSymbols();
	dottedDouble.setDecimalSeparator('.');
	formatter.setDecimalFormatSymbols(dottedDouble);
	panel.add(label);
	panel.setLayout(new FlowLayout(FlowLayout.LEFT));
	this.coefficients = coefficients;
	this.from = from;
	this.to = to;
	this.step = step;
	}
	
	public Component getTableCellRendererComponent(JTable table,
	Object value, boolean isSelected, boolean hasFocus, int row, int col) {
	String formattedDouble = formatter.format(value);
	label.setText(formattedDouble);
	
	 if ( needle!=null && needle.equals(formattedDouble)) {
			panel.setBackground(Color.RED);
	
	}else if (col==1) {double x =0+ 0.1*row;
	double scale=Math.pow(10, 5);
	double result = coefficients[0]*x+coefficients[1];
	for (int i=2;i<coefficients.length;i++ )
		result+=result*x+coefficients[i];
	result=Math.round(result*scale)/scale;
	String result1=Double.toString(result);
char f='.';

for(int i=0; i<result1.length();i++)
{int l=0;int n=0;
if(result1.charAt(i)==f) {
	for(int j=i+1;j<result1.length();j++) {
	 n=n+(result1.charAt(j)-'0');}
	if(n%10==0) {
	panel.setBackground(Color.GREEN);}}}}
	else {
			panel.setBackground(Color.WHITE);}
	return panel;}

	public void setNeedle(String needle) {
	this.needle = needle;
	}


}
