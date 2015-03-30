package com.molcon.phibase.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.molcon.phibase.excelParse.PhibaseCitationDetails;
import com.molcon.phibase.excelParse.PhibaseDisease;
import com.molcon.phibase.excelParse.PhibaseDiseaseIntervention;
import com.molcon.phibase.excelParse.PhibaseDiseaseProcess;
import com.molcon.phibase.excelParse.PhibaseGene;
import com.molcon.phibase.excelParse.PhibaseHost;
import com.molcon.phibase.excelParse.PhibaseInfo;
import com.molcon.phibase.excelParse.PhibaseMutantCharcteristics;
import com.molcon.phibase.excelParse.PhibasePathogen;
import com.molcon.phibase.excelParse.PhibaseReference;



public class PhibaseExcelParse {
		enum classTypeEnum{String,Integer};


	public static void main(String []args)throws Exception{

		PhibaseExcelParse phibaseExcelParse=new PhibaseExcelParse();
		
		PhibaseExcelParseDB phibaseExcelParseDB=new PhibaseExcelParseDB();
		String phibaseInputFilePath="";
		Properties properties = new Properties();
		try {
			FileReader reader = new FileReader("./resources/phibaseExcelParseConfig.properties");
			properties.load(reader);

		} catch (IOException e) {
			e.printStackTrace();
		}
		StringBuffer phibaseResultBuffer=new StringBuffer("Phibase validation Report :\n");
		File phibaseResultFile = new File(properties.getProperty("phibaseResultFilePath"));
		
		List<Map<String, Object>> parsingClassesBeanMapList=phibaseExcelParse.parseExcel(properties,phibaseResultBuffer,phibaseExcelParseDB,phibaseResultFile);

		phibaseExcelParseDB.insertExcelParseDataToDB(parsingClassesBeanMapList,phibaseResultFile);
		
		
	}

	public List<Map<String, Object>> parseExcel(Properties properties,StringBuffer phibaseResultBuffer,PhibaseExcelParseDB phibaseExcelParseDB,File phibaseResultFile)throws Exception{

		List<Map<String, Object>> parsingClassesBeanMapList=new ArrayList<Map<String,Object>>();
		

		try{

			File file = new File(properties.getProperty("phibaseInputFilePath"));
			InputStream fileInputStream = new FileInputStream(file);


			//Get the workbook instance for XLS file
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

			//Get first sheet from the workbook
			Sheet sheet = workbook.getSheetAt(0);


			//Get iterator of each row and read the column as per index which are specified in properties file

			//get header properties key list
			List<String> headerKeyList=new ArrayList<String>();
			Iterator<Cell> cellHeaderIterator=sheet.getRow(1).cellIterator();
			while(cellHeaderIterator.hasNext()){
				Cell cell=cellHeaderIterator.next();
				headerKeyList.add(getPropertyKey(cell.toString()));

			}

			//read the value by iterating rows
			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext()){
				Row row = rowIterator.next();
				if(row.getRowNum()==0 || row.getRowNum()==1)continue;
				Cell cell=row.getCell(3);
				
				if(cell==null || cell.getCellType()== XSSFCell.CELL_TYPE_BLANK)continue;
				//get object of all parsing classes
				Map<String, Object> parsingClassesBeanMap=getParsingClassesBeanMap();

				//get the properties value w.r.t headerkey
				for(String headerKey: headerKeyList){
					String propertyKeyValue=properties.getProperty(headerKey);
					String[] propertyValue=null;
					if(propertyKeyValue!=null){
						propertyValue=propertyKeyValue.split(":");
						int excelIndex=Integer.parseInt(propertyValue[0]);
						String className=propertyValue[1];
						String propertiesName=propertyValue[2];
						//String type=propertyValue[3];

						//now get the value w.r.t. index from excel of each row and set in bean object
						Cell excelIndexcell=row.getCell(excelIndex);
						String excelIndexcellValue="";
						if(excelIndexcell!=null){
							excelIndexcellValue=getCellValueType(excelIndexcell);
						}
						
						if(headerKey.equals("Multiplemutation")){
							if(!excelIndexcellValue.equals("") && !excelIndexcellValue.equals("no") && !excelIndexcellValue.equals("na")){
								if(!checkMultipleMutationFormat(excelIndexcellValue)){
									phibaseResultBuffer.append("\nError in format of Data in line no:"+(row.getRowNum()+1)+" of "+headerKey+" :"+excelIndexcellValue);
								}
							}
						}

						//get the Parsing Bean object w.r.t class name
						//System.out.println(className+">>>>>>>>>..");
					 	Object classNameObject=parsingClassesBeanMap.get(className);

						//use the reflection and dynamically initialize the properties of classes i.e invoking setter method
						 Class[] parameterTypes = null;
						 Object[] arguments = null;
						 String methodName="";
						 Method setMethod = null;

						 parameterTypes = new Class[]{String.class};
						 methodName = "set" + Character.toUpperCase(propertiesName.charAt(0))+ propertiesName.substring(1);
						 setMethod=classNameObject.getClass().getMethod(methodName, parameterTypes);

						 arguments = new Object[] {excelIndexcellValue};

						 setMethod.invoke(classNameObject,arguments);
						 parsingClassesBeanMap.put(className, classNameObject);
					}
				}
				//put in a list of parsing classes bean
				parsingClassesBeanMapList.add(parsingClassesBeanMap);
			}
			phibaseExcelParseDB.writeFile(phibaseResultFile, phibaseResultBuffer.toString(),false);
		}catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return parsingClassesBeanMapList;
	}

	public Map<String, Object> getParsingClassesBeanMap(){
		Map<String, Object> parsingClassesBeanMap=new LinkedHashMap<String, Object>();

		parsingClassesBeanMap.put("PhibaseReference", (Object)new PhibaseReference());
		parsingClassesBeanMap.put("PhibaseGene", (Object)new PhibaseGene());
		parsingClassesBeanMap.put("PhibasePathogen", (Object)new PhibasePathogen());
		parsingClassesBeanMap.put("PhibaseHost", (Object)new PhibaseHost());
		//parsingClassesBeanMap.put("PhibaseMutantCharcteristics", (Object)new PhibaseMutantCharcteristics());
		parsingClassesBeanMap.put("PhibaseDisease", (Object)new PhibaseDisease());
		parsingClassesBeanMap.put("PhibaseDiseaseProcess", (Object)new PhibaseDiseaseProcess());
		parsingClassesBeanMap.put("PhibaseDiseaseIntervention", (Object)new PhibaseDiseaseIntervention());
		parsingClassesBeanMap.put("PhibaseCitationDetails", (Object)new PhibaseCitationDetails());
		parsingClassesBeanMap.put("PhibaseInfo",(Object)new PhibaseInfo());

		return parsingClassesBeanMap;
	}

	public String getPropertyKey(String key){
		//System.out.println(key.replaceAll("[^A-Za-z0-9]", ""));
		return key.replaceAll("[^A-Za-z0-9]", "");
	}

	 public static String getCellValueType(Cell cell){
		 String cellValue="";
		 switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				cellValue=String.valueOf((int)cell.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_STRING:
				cellValue=cell.getStringCellValue().trim(); 
				break;
			default:
				break;
			}

		 return cellValue;
	 }
	 public boolean checkMultipleMutationFormat(String multipleMutation){
			boolean multipleMutationFlag=false;
			if(multipleMutation.equals("no") || multipleMutation.equals("")){
				multipleMutationFlag=true;
			}else{
				Pattern pattern=Pattern.compile("^(PHI:[0-9]+;?\\s*)+$");
				Matcher matcher=pattern.matcher(multipleMutation);
				if(matcher.matches()){
					multipleMutationFlag=true;
				}else{
					multipleMutationFlag=false;
				}
				
				
			}
			return multipleMutationFlag;
			
		}

}
