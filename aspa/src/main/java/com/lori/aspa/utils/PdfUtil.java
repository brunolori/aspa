package com.lori.aspa.utils;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class PdfUtil {
	
	 public static PdfPTable getTable(int columns,boolean noBorder,int aligment)
	    {
	        
	            PdfPTable table = new PdfPTable(columns);
	            if(noBorder)
	            {table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);}
	            table.getDefaultCell().setHorizontalAlignment(aligment);
	        
	            return table;
	    }
	    
	    
	    public static PdfPCell getCell(boolean noBorder,int aligment)
	    {
	        
	            PdfPCell cell = new PdfPCell();
	            if(noBorder)
	            {cell.setBorder(PdfPCell.NO_BORDER);}
	            cell.setHorizontalAlignment(aligment);
	            
	            return cell;
	    }

}
