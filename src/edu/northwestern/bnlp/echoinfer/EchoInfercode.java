 package edu.northwestern.bnlp.echoinfer; 

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.poi.hssf.usermodel.HeaderFooter.file;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class EchoInfercode {
	public static String[][] excelData;
	public static void main(String[] args) {
			

		// +++++++++++++++++++++++++++++++++++++++++++(VARIABLE DECLARATION)++++++++++++++++++++++++++++++++++++++++++++++//

		int numOfRows = 400;
		int numOfInputCol = 21;
		int numOfPheno = 82;  
		int startIndexCol = 5;
		int IndexCol = numOfInputCol+1;
		int addColperPheno = 6;
		int count = 0;
		int numOfOutputColumns = numOfPheno * addColperPheno + IndexCol;

		String fileName = "/Users/cnx471/Desktop/TestZ.xlsx";
		String WritefileName = "/Users/cnx471/Desktop/OUTPUT.xlsx";
		String completelist = "a";
		String check = "";
		String check1 = "";
		String check2 = "";
		// +++++++++++++++++++++++++++++++++++++++++++(METHOD CALLING)++++++++++++++++++++++++++++++++++++++++++++++++++//
		Echo_ReadExcelXFile method = new Echo_ReadExcelXFile();
		Vector recordlist = method.readExcelFile(fileName);
		String[][] arrRecords = new String[recordlist.size()][numOfInputCol];
		excelData = new String[numOfRows][numOfOutputColumns];

		// +++++++++++++++++++++++++++++++++++++++++++(INPUT / READING EXCEL SHEET)++++++++++++++++++++++++++++++++++++++//
		for (int i = 0; i < recordlist.size(); i++) {
			Vector cellStoreVector = (Vector) recordlist.elementAt(i);
			for (int j = 0; j < cellStoreVector.size(); j++) {
				XSSFCell myCell = (XSSFCell) cellStoreVector.elementAt(j);
				String stringCellValue = myCell.toString();
				String stringCellValue1 = stringCellValue.toLowerCase();
				completelist = stringCellValue1 + "\t";
				arrRecords[i][j] = completelist;
				excelData[i][j] = arrRecords[i][j]; 										// copy data from the Input file
			}
		}
		// +++++++++++++++++++++++++++++++++++++++++++(OUTPUT EXCEL CELL DECLARATION)++++++++++++++++++++++++++++++++++++//
		for (int r = 0; r < numOfRows; r++) {
			for (int c = numOfInputCol; c < numOfOutputColumns; c++) {									// blank cell created apart from Input colummns
				excelData[r][c] = "";
			}
		}
		 	excelData[0][IndexCol] = "AVA";
			excelData[0][IndexCol+6] = "MVA";
			excelData[0][IndexCol+12] = "AORTIC LEAFLET";
			excelData[0][IndexCol+18] = "MITRAL LEAFLET";
			excelData[0][IndexCol+24] = "AV PEAK GRADIENT";
			excelData[0][IndexCol+30] = "MV PEAK GRADIENT";
			excelData[0][IndexCol+36] = "MR PEAK GRADIENT";
			excelData[0][IndexCol+42] = "TR PEAK GRADIENT";
			excelData[0][IndexCol+48] = "TV PEAK GRADIENT";
			excelData[0][IndexCol+54] = "PV PEAK GRADIENT";
			excelData[0][IndexCol+60] = "LVOT PEAK GRADIENT";
			excelData[0][IndexCol+66] = "RVOT PEAK GRADIENT";
			excelData[0][IndexCol+72] = "AV MEAN GRADIENT";
			excelData[0][IndexCol+78] = "MV MEAN GRADIENT";
			excelData[0][IndexCol+84] = "PV MEAN GRADIENT";
			excelData[0][IndexCol+90] = "TRICUPSID MEAN GRADIENT";
			excelData[0][IndexCol+96] = "TRANSVALVULAR MEAN GRADIENT";
			excelData[0][IndexCol+102] = "BIOPROSTHESIS MEAN GRADIENT";
			excelData[0][IndexCol+108] = "RVOT PEAK VELOCITY";
			excelData[0][IndexCol+114] = "LVOT PEAK VELOCITY";
			excelData[0][IndexCol+120] = "TV PEAK VELOCITY";
			excelData[0][IndexCol+126] = "MV PEAK VELOCITY";
			excelData[0][IndexCol+132] = "PV PEAK VELOCITY";
			excelData[0][IndexCol+138] = "AV PEAK VELOCITY";
			excelData[0][IndexCol+144] = "TR PEAK VELOCITY";
			excelData[0][IndexCol+150] = "MR PEAK VELOCITY";
			excelData[0][IndexCol+156] = "LVOT MEAN VELOCITY";
			excelData[0][IndexCol+162] = "PV MEAN VELOCITY";
			excelData[0][IndexCol+168] = "MR MEAN VELOCITY";
			excelData[0][IndexCol+174] = "AV MEAN VELOCITY";
			excelData[0][IndexCol+180] = "MV MEAN VELOCITY";
			excelData[0][IndexCol+186] = "TV MEAN VELOCITY";
			excelData[0][IndexCol+192] = "AORTIC STENOSIS";
			excelData[0][IndexCol+198] = "MITRAL STENOSIS";
			excelData[0][IndexCol+204] = "DIMENSIONAL INDEX";
			excelData[0][IndexCol+210] = "MVA(P1/2T)";
			excelData[0][IndexCol+216] = "PULMONARY ARTERY PRESSURE";
			excelData[0][IndexCol+222] = "RIGHT ARTERY PRESSURE";
			excelData[0][IndexCol+228] = "AORTIC REGURGITATION";
			excelData[0][IndexCol+234] = "MITRAL REGURGITATION";
			excelData[0][IndexCol+240] = "VENA CONTRACTA";
			excelData[0][IndexCol+246] = "REGURGITANT FRACTION";
			excelData[0][IndexCol+252] = "REGURGITANT ORIFICE AREA";
			excelData[0][IndexCol+258] = "PRESSURE HALF";
			excelData[0][IndexCol+264] = "AORTIC FLOW REVERSAL";
			excelData[0][IndexCol+270] = "LVEF";
			excelData[0][IndexCol+276] = "DIASTOLIC FUNCTION";
			excelData[0][IndexCol+282] = "E/A RATIO";
			excelData[0][IndexCol+288] = "LV FILLING PRESSURE";
			excelData[0][IndexCol+294] = "E/e' Ratio";
			excelData[0][IndexCol+300] = "LVEDD";
			excelData[0][IndexCol+306] = "LVESD";
			excelData[0][IndexCol+312] = "CONCENTRIC TYPE";
			excelData[0][IndexCol+318] = "BASAL TYPE";
			excelData[0][IndexCol+324] = "DEGREE OF LV HYPERTROPHY";
			excelData[0][IndexCol+330] = "DEGREE OF BS HYPERTROPHY";
			excelData[0][IndexCol+336] = "SEPTAL THICKNESS";
			excelData[0][IndexCol+342] = "ATRIAL ENLARGEMENT";
			excelData[0][IndexCol+348] = "LA DIMENSION";
			excelData[0][IndexCol+354] = "VOLUME INDEX";
			excelData[0][IndexCol+360] = "BODY SURFACE AREA";
			excelData[0][IndexCol+366] = "RVOT VTI";
			excelData[0][IndexCol+372] = "LVOT DIA";
			excelData[0][IndexCol+378] = "AO ROOT DIA";
			excelData[0][IndexCol+384] = "AV VTI";
			excelData[0][IndexCol+390] = "MV VTI";
			excelData[0][IndexCol+396] = "LVOT VTI";
			excelData[0][IndexCol+402] = "RVOT DIM";
			excelData[0][IndexCol+408] = "BASAL RV SIZE";
			excelData[0][IndexCol+414] = "TAPSE";
			excelData[0][IndexCol+420] = "RVEF";
			excelData[0][IndexCol+426] = "LA VOLUME";
			excelData[0][IndexCol+432] = "MV HALF PRESSURE TIME";
			excelData[0][IndexCol+438] = "PERICARDIAL SIZE";
			excelData[0][IndexCol+444] = "IVC";
			excelData[0][IndexCol+450] = "RA PRESSURE";
			excelData[0][IndexCol+456] = "RIGHT ATRIUM";
			excelData[0][IndexCol+462] = "RV HYPERTROPHY";
			excelData[0][IndexCol+468] = "PULMONARY REGURGITATION";
			excelData[0][IndexCol+474] = "TRICUSPID REGURGITATION";
			excelData[0][IndexCol+480] = "TRICUSPID STENOSIS";
			excelData[0][IndexCol+486] = "PULMONARY STENOSIS";    
	        
			for (int col = 0; col < numOfPheno; col++) {
				excelData[0][IndexCol+(addColperPheno) * col + 1] = "Result";
				excelData[0][IndexCol+(addColperPheno) * col + 2] = "size";
				excelData[0][IndexCol+(addColperPheno) * col + 3] = "Max Value";
				excelData[0][IndexCol+(addColperPheno) * col + 4] = "Min Value";
				excelData[0][IndexCol+(addColperPheno) * col + 5] = "Last Value";
		}
			
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++(PATTERN DECLARATION)++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	       
			Pattern p = Pattern.compile(".{3}(\\sava\\s|aortic\\s*valve\\s*area|\\sav\\sarea).{1,100}?(\\s*((cm\\s*2)|(cm\\^2)|(cm\\?)|(cm\\?\\?)|(sq\\/cm)|(cm\\s*sq)|(sq\\s*cm)|(sq\\.cm)|(cm\\/sq)|(cm\\s*squared)|(cm[\\p{L}\\p{Nd}])|(cm\u00b2)|(mm2)|(mm\\s*squared)|(sq\\.mm)))");
			Pattern Px = Pattern.compile("ava\\s*index.{1,15}\\d*\\.\\d*|av\\s*area\\s*index.{1,15}\\d*\\.\\d*|aortic\\s*valve\\s*area\\s*index.{1,15}\\d*\\.\\d*");
	        Pattern p1 = Pattern.compile("((?<=(ava\\s.{1,40}))|(?<=(aortic\\s{1,4}valve\\s{1,4}area.{1,40}))|(?<=(av\\s{1,4}area.{1,40}))|(?<=(((ava\\s)|(aortic\\s{1,4}valve\\s{1,4}area)|(av\\s{1,4}area)).{1,30}((continuity\\sequation)|(planimetry)).{1,40})))\\s*((\\d*\\.*\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+)|(\\[\\*\\*\\d+(\\-|to)\\d+\\*\\*\\]))(?=(\\s*((cm\\s*2)|(cm\\^2)|(cm\\?)|(cm\\?\\?)|(sq\\/cm)|(cm\\s*sq)|(sq\\s*cm)|(sq\\.cm)|(cm\\/sq)|(cm\\s*squared)|(cm[\\p{L}\\p{Nd}])|(cm\u00b2)|(mm2)|(mm\\s*squared)|(sq\\.mm)|(vti))))");
	        
	        Pattern p4 = Pattern.compile(".{3}(mva\\s|mitral\\s*valve\\s*area|\\smv\\sarea|(mva(\\(traced\\)\\:))).{100}");
	        Pattern p5 = Pattern.compile("((?<=(mva(\\(traced\\)\\:)))|(?<=(mva.{1,20}))|(?<=(mitral\\s{1,4}valve\\s{1,4}area.{1,20}))|(?<=(mv\\s{1,4}area.{1,20}))|(?<=(((mva)|(mitral\\s{1,4}valve\\s{1,4}area)|(mv\\s{1,4}area)).{1,20}((pressure\\shalf\\stime)|(pht)).{1,20})))\\s*((\\d*\\.*\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+)|(\\[\\*\\*\\d+(\\-|to)\\d+\\*\\*\\]))(?=(\\s*((cm\\s*2)|(cm\\^2)|(cm\\?)|(cm\\?\\?)|(sq\\/cm)|(cm\\s*sq)|(sq\\s*cm)|(sq\\.cm)|(cm\\/sq)|(cm)|(cm\\s*squared)|(cm[\\p{L}\\p{Nd}])|(cm\u00b2)|(mm2)|(mm\\s*squared)|(sq\\.mm)|(vti))))");
	       
	        Pattern p8 = Pattern.compile("(.{1,10}((aortic)\\s*valve.{1,20}(is|was|are|(\\.it\\s*is)|(leaflets)).{1,40}((thickened\\s*and\\s*calcified)|(sclerotic\\s*and\\s*calcified)|(calcified)|(thickned)|(thickened)|(thickening)|(\\snormal)|(no\\schange))))|(.{1,10}((aortic)\\s*valve.{1,10}(leaflet|leaflets|trileaflet|trileaflets).{1,40}((calcified)|(thickned)|(thickened)|(thickening)|(sclerotic\\s*and\\s*calcified)|(\\snormal)|(no\\schange))).{1,10})|(aortic\\s*(valve)*.{1,5}calcification)|(aortic\\s*(thickening|sclerosis|calcification))|((calcification|thickening)[^\\.].{1,10}(aortic\\s*(valve)))");
	        Pattern p9 = Pattern.compile("(thickened\\s*and\\s*calcified)|(sclerotic\\s*and\\s*calcified)|(calcified)|(calcification)|(thickned)|(thickened)|(thickening)|(normal)|(sclerotic)|(no\\schange)|(sclerosis)");
	       
	        Pattern p8a = Pattern.compile("((((mitral)\\s*(valve).{1,20}((is)|(was)|(are)|(\\.it\\s*is)))|(mitral\\s*leaflet(s)*))[^.].{1,40}((calcified)|(thickned)|(thickened)|(thickening)|(\\snormal)|(no\\schange)))|((leaflet|leaflets|trileaflet|trileaflets).{1,30}(mitral)\\s*valve[^.].{1,40}((calcified)|(thickned)|(thickened)|(thickening)|(normal)|(no\\schange)))|(mitral\\s*(valve|annular).{1,20}(calcification|thickening))|((calcification|thickening).{1,20}leaflets.{1,10}(mitral\\s*(valve)))|(mitral\\svalve\\sleaflets[^.].{1,40}(thickened|calcified))");
	        Pattern p9a = Pattern.compile("(thickened\\s*and\\s*calcified)|(calcified)|(calcification)|(thickned)|(thickened)|(thickening)|(normal)|(sclerotic)|(no\\schange)|(sclerosis)");
	       
	        Pattern p10a = Pattern.compile("(peak(\\/|and)mean\\s*aortic*gradient.{1,20}(mmhg|mm\\s{1,4}hg))|(ao\\s{1,6}max\\s{1,6}pg.{1,20}(mmhg|mm\\s{1,4}hg))|((av|aortic\\s*valve)\\s{1,6}peak\\s{1,6}(pressure)*\\s*gradient.{1,20}((mmhg)|(mm\\s*hg)))|(peak((((\\s{1,6}pressure)|(\\s{1,6}forward\\s{1,6}flow)|(\\/mean)|(\\sand\\smean))\\s{1,6}gradient)|(\\s{1,6}gradient)).{1,30}across.{1,30}(aortic\\s*((valve)|(prosthesis))).{1,20}(mmhg|mm\\s*hg))|(((across.{1,30}(aortic\\s*valve))|((bioprosthetic\\s{1,6}valve).{1,90}aortic\\s{1,6}pos(i)*tion)).{1,80}peak\\s{1,6}(pressure)*(forward\\s{1,6}flow)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))|(peak\\s{1,6}(trans)*(aortic|av)(\\svalve)*\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))|(((((bioprosthetic)|(prosthetic)|(bioprosthetic\\svalve)).{1,90}aortic\\s*(valve|pos(i)*tion))|(((aortic)|(ao)|(av))\\s*((bioprosthetic\\s(valve)*)|(prosthesis)|(bioprosthesis)|(pos(i)*tion)))).{1,140}((this\\scorresponds)|with|calculating|the).{1,140}(peak\\s{1,4}(gradient|(pressure\\s)*difference)).+?{1,40}(mmhg|mm\\s*hg))|(aortic\\svalve.{1,100}((this\\scorresponds)|with|calculating|the|consistent).{1,100}(peak((((\\/)mean)|(\\sand\\smean))*\\s{1,4}gradient|\\s{1,4}(pressure\\s)*difference)).+?{1,140}(mmhg|mm\\s*hg))");
	        Pattern p11a = Pattern.compile("((?<=(ao\\s{1,6}max\\s{1,6}pg.{1,20}))|(?<=(peak\\s{1,6}pressure\\s{1,6}(gradient|difference).{1,40}))|(?<=(peak\\s{1,6}gradient.{1,40}))|(?<=(peak((\\/mean)|(\\sand\\smean))\\s{1,6}gradient.{1,80}))|(?<=(peak\\s{1,6}((transaortic)|(aortic\\svalve)|(av)|(aortic)|(ao)|(forward\\s{1,6}flow))\\s{1,6}gradient.{1,20})))\\s*(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|((?<!\\/)\\d+))((?=(\\s{1,20}mmhg))|(?=(mmhg))|(?=(\\s{1,20}mm\\shg))))");
	        
	        Pattern p10b = Pattern.compile("(mv\\s{1,6}max\\s{1,6}pg.{1,20}(mmhg|mm\\s{1,4}hg))|((mv|mitral\\s*valve)\\s{1,6}peak\\s{1,6}(pressure)*\\s*gradient.{1,20}((mmhg)|(mm\\s*hg)))|(peak\\s{1,6}(pressure)*\\s*gradient.{1,30}(across\\s(the)*\\s*mitral\\s*valve).{1,20}(mmhg|mm\\shg))|((across\\s*(the)*\\s*mitral\\s*valve).{1,40}peak\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\shg))|(peak\\s{1,6}(trans)*mitral(\\svalve)*\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\shg))");
	        Pattern p11b = Pattern.compile("((?<=(mv\\s{1,6}max\\s{1,6}pg.{1,20}))|(?<=(peak\\spressure\\sgradient.{1,40}))|(?<=(peak\\sgradient.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))((?=(\\s*mmhg))|(?=(mmhg))|(?=(\\s*mm\\shg))))");
	       
	        Pattern p10c = Pattern.compile("(mr\\s{1,6}max\\s{1,6}pg.{1,20}(mmhg|mm\\s{1,4}hg))|(mr\\s{1,6}peak\\s{1,6}(pressure)*\\s*gradient.{1,20}((mmhg)|(mm\\s*hg)))|(mr\\s{1,6}max\\s{1,6}pg.{1,20}(mmhg|mm\\s{1,4}hg))");
	        Pattern p11c = Pattern.compile("((?<=(mr\\s{1,6}max\\s{1,6}pg.{1,20}))|(?<=(peak\\sgradient.{1,40}))|(?<=(mr\\s{1,6}max\\s{1,6}pg.{1,20}))|)(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))((?=(\\s*mmhg))|(?=(mmhg))|(?=(\\s*mm\\s*hg))))");
	       
	        Pattern p10d = Pattern.compile("(tr\\s{1,6}max\\s{1,6}pg.{1,20}(mmhg|mm\\s{1,4}hg))|(tr\\s{1,6}peak\\s{1,6}(pressure)*\\s*gradient.{1,20}((mmhg)|(mm\\s*hg)))|(tr\\s{1,6}max\\s{1,6}pg.{1,20}(mmhg|mm\\s{1,4}hg))");
	        Pattern p11d = Pattern.compile("((?<=(tr\\s{1,6}max\\s{1,6}pg.{1,20}))|(?<=(peak\\sgradient.{1,40}))|(?<=(tr\\s{1,6}max\\s{1,6}pg.{1,20}))|)(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))((?=(\\s*mmhg))|(?=(mmhg))|(?=(\\s*mm\\s*hg))))");
	       
	        Pattern p10e = Pattern.compile("(tv\\s{1,6}max\\s{1,6}pg.{1,20}(mmhg|mm\\s{1,4}hg))|(tv\\s{1,6}peak\\s{1,6}(pressure)*\\s*gradient.{1,20}((mmhg)|(mm\\s*hg)))|(tv\\s{1,6}max\\s{1,6}pg.{1,20}(mmhg|mm\\s{1,4}hg))");
	        Pattern p11e = Pattern.compile("((?<=(tv\\s{1,6}max\\s{1,6}pg.{1,20}))|(?<=(peak\\sgradient.{1,40}))|(?<=(tv\\s{1,6}max\\s{1,6}pg.{1,20}))|)(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))((?=(\\s*mmhg))|(?=(mmhg))|(?=(\\s*mm\\s*hg))))");
	        
	        Pattern p10f = Pattern.compile("(pv\\s{1,6}max\\s{1,6}pg.{1,20}(mmhg|mm\\s{1,4}hg))|(pv\\s{1,6}peak\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))|(pv\\s{1,6}max\\s{1,6}pg.{1,20}(mmhg|mm\\s{1,4}hg)|(pulmonary.{1,20}valve.{1,50}((with)|(yield)|(predicts)).{1,20}peak\\s*gradient.{1,20}?(mm\\s*hg)))");
	        Pattern p11f = Pattern.compile("((?<=(pv\\s{1,6}max\\s{1,6}pg.{1,20}))|(?<=(peak\\sgradient.{1,40}))|(?<=(pv\\s{1,6}max\\s{1,6}pg.{1,20})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))((?=(\\s*mmhg))|(?=(mmhg))|(?=(\\s*mm\\s*hg))))");
	        
	        Pattern p10g = Pattern.compile("(lvot\\s{1,6}peak\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))|(lvot.{1,40}((with)|(and)).{1,40}peak\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))");
	        Pattern p11g = Pattern.compile("((?<=(peak\\sgradient.{1,40}))|(?<=(peak\\sgradient\\sof.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))((?=(\\s*mmhg))|(?=(mmhg))|(?=(\\s*mm\\s*hg))))");
	        
	        Pattern p10h = Pattern.compile("(rvot\\s{1,6}peak\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))|(rvot.{1,40}((with)|(and)).{1,40}peak\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))");
	        Pattern p11h = Pattern.compile("((?<=(peak\\sgradient.{1,40}))|(?<=(peak\\sgradient\\sof.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))((?=(\\s*mmhg))|(?=(mmhg))|(?=(\\s*mm\\s*hg))))");
	        
	        Pattern p10aa = Pattern.compile("(aortic\\s*((valve)|(position)|(prosthesis)|(vavle)|(stenosis)|(insufficiency)).{1,190}?((mean\\s*gradient)|(mean\\s*is)|(mean\\s{1,6}transaortic\\s{1,6}gradient)|(mean\\s{1,6}aortic\\svalve\\s{1,6}gradient)|(mean\\s{1,6}av\\s{1,6}gradient)|(mean\\s{1,6}aortic\\s{1,6}gradient)|(mean\\s{1,6}ao\\s{1,6}gradient)|(mean\\s{1,6}forward\\s{1,6}flow\\s{1,6}gradient)|(mean\\s{1,6}transvalvular\\s{1,6}gradient)).{1,60}?(mmhg|mm\\s{1,4}hg))|(ao\\s{1,6}mean\\s{1,6}pg.{1,20}(mmhg|mm\\s{1,4}hg))|((av|aortic\\s*valve)\\s{1,6}mean\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))|(mean\\s{1,6}((pressure)|(forward\\s{1,6}flow))*\\s*gradient.{1,30}((across)|(through)).{1,30}(aortic\\s*(valve|prosthesis)).{1,20}(mmhg|mm\\s*hg))|(((across.{1,30}(aortic\\s*valve))|((bioprosthetic\\s{1,6}valve).{1,90}aortic\\s{1,6}pos(i)*tion)).{1,80}mean\\s{1,6}(pressure)*(forward\\s{1,6}flow)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))|(mean\\s{1,6}(trans)*(aortic|av)(\\svalve)*\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))|(ao\\s{1,6}mean\\s{1,6}pg.{1,20}(mmhg|mm\\s{1,4}hg))|(((((bioprosthetic)|(prosthetic)|(bioprosthetic\\svalve)).{1,90}aortic\\s*(valve|pos(i)*tion))|(((aortic)|(ao)|(av))\\s*((bioprosthetic\\s(valve)*)|(prosthesis)|(bioprosthesis)|(pos(i)*tion)))).{1,140}?((this\\scorresponds)|with|calculating|the).{1,140}?(mean\\s{1,4}((forward\\s{1,6}flow\\s{1,6}gradient)|(gradient)|((pressure\\s)*difference))).{1,40}?(mmhg|mm\\s*hg))|(aortic\\svalve.{1,100}?((this\\scorresponds)|with|calculating|the|consistent).{1,100}?(mean\\s{1,4}((forward\\s{1,6}flow\\s{1,6}gradient)|(gradient)|((pressure\\s)*difference))).{1,140}?(mmhg|mm\\s*hg))");
	        Pattern p11aa = Pattern.compile("((?<=(ao\\s{1,6}mean\\s{1,6}pg.{1,20}))|(?<=(aortic\\s{1,6}valve\\s{1,6}.{1,30}))|(?<=(ao\\s{1,6}mean\\s{1,6}pg.{1,20}))|(?<=(mean\\s{1,6}pressure\\s{1,6}(gradient|difference).{1,40}))|(?<=(mean\\s{1,6}((gradient)|(is)).{1,40}))|(?<=(mean\\s{1,6}((transaortic)|(aortic\\svalve)|(av)|(aortic)|(ao)|(forward\\s{1,6}flow)|(transvalvular))\\s{1,6}gradient.{1,20})))\\s*(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))((?=(\\s{1,20}mmhg))|(?=(mmhg))|(?=(\\s{1,20}mm\\shg))))");
	       
	        Pattern p10ab = Pattern.compile("(mv\\s{1,6}mean\\s{1,6}pg.{1,20}(mmhg|mm\\s{1,4}hg))|((mv|mitral\\s*valve)\\s{1,6}mean\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))|(mean\\s{1,6}(pressure)*\\s*gradient.{1,30}(((across)|(through))\\s(the)*\\s*mitral\\s*(valve|prosthesis)).{1,20}(mmhg|mm\\s*hg))|((across\\s*(the)*\\s*mitral\\s*(valve|prosthesis)).{1,40}mean\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))|(mean\\s{1,6}(trans)*(mitral|mv)(\\svalve)*\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))|(mv\\s{1,6}mean\\s{1,6}pg.{1,20}(mmhg|mm\\s{1,4}hg))");
	        Pattern p11ab = Pattern.compile("((?<=(mv\\s{1,6}mean\\s{1,6}pg.{1,20}))|(?<=(mv\\s{1,6}mean\\s{1,6}pg.{1,20}))|(?<=(mean\\s{1,6}pressure\\s{1,6}gradient.{1,40}))|(?<=(mean\\s{1,6}((transmitral)|(mitral\\s(valve|prosthesis))|(mv)|(mitral)|(forward\\s{1,6}flow))\\s{1,6}gradient.{1,20}))|(?<=(mean\\s{1,6}gradient.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))((?=(\\s*mmhg))|(?=(mmhg))|(?=(\\s*mm\\s*hg))))");
	        
	        Pattern p10ac = Pattern.compile("(((pulmonic|pulmonary)\\s*valve)\\s{1,6}mean\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))|(mean\\s*(pressure)*\\s*gradient.{1,30}(across\\s(the)*\\s*pulmonic\\s*valve).{1,20}(mmhg|mm\\s*hg))|((across\\s*(the)*\\s*pulmonic\\s*valve).{1,40}mean\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))|(mean\\s{1,6}(trans)*pulmonary(\\svalve)*\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))");
	        Pattern p11ac = Pattern.compile("((?<=(mean\\s{1,6}pressure\\s{1,6}gradient.{1,40}))|(?<=(mean\\s{1,6}((transpulmonary)|(pulmonary\\svalve)|(pulmonary))\\s{1,6}gradient.{1,20}))|(?<=(mean\\s{1,6}gradient.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))((?=(\\s*mmhg))|(?=(mmhg))|(?=(\\s*mm\\s*hg))))");
	        
	        Pattern p10ad = Pattern.compile("(tv\\s{1,6}mean\\s{1,6}pg.{1,20}(mmhg|mm\\s{1,4}hg))|((mean\\s{1,6}(pressure)*\\s*gradient.{1,30}(across\\s(the)*\\s*tricuspid\\s*valve).{1,20}(mmhg|mm\\s*hg))|(tricuspid\\s*valve).{1,40}mean\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))|((across\\s*(the)*\\s*tricuspid\\s*valve).{1,40}mean\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))|(mean\\s{1,6}(trans)*tricuspid(\\svalve)*\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))|(tv\\s{1,6}mean\\s{1,6}pg.{1,20}(mmhg|mm\\s{1,4}hg))");
	        Pattern p11ad = Pattern.compile("((?<=(tv\\s{1,6}mean\\s{1,6}pg.{1,20}))|(?<=(tv\\s{1,6}mean\\s{1,6}pg.{1,20}))|(?<=(mean\\s{1,6}pressure\\s{1,6}gradient.{1,40}))|(?<=(mean\\s{1,6}((transtricupsid)|(tricuspid\\svalve)|(tricuspid))\\s{1,6}gradient.{1,20}))|(?<=(mean\\s{1,6}gradient.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))((?=(\\s*mmhg))|(?=(mmhg))|(?=(\\s*mm\\s*hg))))");
	       
	        Pattern p10ae = Pattern.compile("(((transvalvular))\\s{1,20}mean\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))|(mean\\s{1,6}(pressure)*\\s{1,6}gradient.{1,30}(across\\s(the)*\\s*transvalvular\\s*valve).{1,20}(mmhg|mm\\s*hg))|((across\\s*(the)*\\s*transvalvular\\s*valve).{1,40}mean\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))|(mean\\s{1,6}transvalvular\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))");
	        Pattern p11ae = Pattern.compile("((?<=(mean\\s{1,6}pressure\\s{1,6}gradient.{1,40}))|(?<=(mean\\s{1,6}((transvalvular))\\s{1,6}gradient.{1,20}))|(?<=(mean\\s{1,6}gradient.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))((?=(\\s*mmhg))|(?=(mmhg))|(?=(\\s*mm\\s*hg))))");
	       
	        Pattern p10af = Pattern.compile("(((bioprosthetic\\s*valve))\\s{1,20}mean\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))|(mean\\s{1,6}(pressure)*\\s*gradient.{1,30}(across\\s(the)*\\s*bioprosthetic\\s*valve).{1,20}(mmhg|mm\\s*hg))|((across\\s*(the)*\\s*bioprosthetic\\s*valve).{1,40}mean\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))|(mean\\s{1,6}bioprosthetic\\svalve\\s{1,6}(pressure)*\\s*gradient.{1,20}(mmhg|mm\\s*hg))");
	        Pattern p11af = Pattern.compile("((?<=(mean\\spressure\\sgradient.{1,40}))|(?<=(mean\\s{1,6}bioprosthetic\\svalve\\s{1,6}gradient.{1,20}))|(?<=(mean\\sgradient.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))((?=(\\s*mmhg))|(?=(mmhg))|(?=(\\s*mm\\s*hg))))");
	               
	        Pattern p12a = Pattern.compile("((rvot)\\s{1,6}peak\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec)))|(peak\\s{1,6}(recorded)*\\s*velocity.{1,30}(across\\s(the)*\\s*rvot).{1,20}(((cm)|m)\\/(s|second|sec)))|((across\\s*(the)*\\s*rvot).{1,40}peak\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec)))");
	        Pattern p13a = Pattern.compile("((?<=(peak\\s{1,6}(recorded)\\s{1,6}velocity.{1,40}))|(?<=(peak\\s{1,6}velocity.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\_*\\s*(((cm)|m)\\/(s|second|sec)))");
	        
	        Pattern p12b = Pattern.compile("((lvot)\\s{1,6}peak\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec)))|((lvot.{1,40}((with)|(and)).{1,40}peak\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec))))|(peak\\s{1,6}(recorded)*\\s*velocity.{1,30}(across\\s(the)*\\s*lvot).{1,20}(((cm)|m)\\/(s|second|sec)))|((across\\s*(the)*\\s*lvot).{1,40}peak\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec)))");
	        Pattern p13b = Pattern.compile("((?<=(peak\\s{1,6}(recorded)\\s{1,6}velocity.{1,40}))|(?<=(peak\\s{1,6}velocity.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\_*\\s*(((cm)|m)\\/(s|second|sec)))");
	        
	        Pattern p12c = Pattern.compile("((tv)\\s{1,6}peak\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec)))|(peak\\s{1,6}(recorded)*\\s*velocity.{1,30}(across\\s(the)*\\s*tricuspid\\s*valve).{1,20}(((cm)|m)\\/(s|second|sec)))|((across\\s*(the)*\\s*tricuspid\\s*valve).{1,40}peak\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec)))");
	        Pattern p13c = Pattern.compile("((?<=(peak\\s{1,6}(recorded)\\s{1,6}velocity.{1,40}))|(?<=(peak\\s{1,6}velocity.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\_*\\s*(((cm)|m)\\/(s|second|sec)))");
	                
	        Pattern p12d = Pattern.compile("((mv|mitral\\s*valve)\\s{1,6}peak\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec)))|(peak\\s{1,6}(recorded)*\\s*velocity.{1,30}(across\\s(the)*\\s*(bioprosthetic\\s)*mitral\\s*valve).{1,20}((with)|(and)).{1,20}(((cm)|m)\\/(s|second|sec)))|((across\\s*(the)*\\s*(bioprosthetic\\s)*mitral\\s*valve).{1,40}peak\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec)))|(peak\\s{1,6}(trans)*mitral(\\svalve)*\\s{1,6}velocity.{1,20}(((cm)|m)\\/(s|second|sec)))");
	        Pattern p13d = Pattern.compile("((?<=(peak\\s{1,6}(recorded|transmitral)\\s{1,6}velocity.{1,40}))|(?<=(peak\\s{1,6}mitral\\s{1,6}velocity.{1,40}))|(?<=(peak\\s{1,6}velocity.{1,80})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\_*\\s*(((cm)|m)\\/(s|second|sec)))");
	               
	        Pattern p12e = Pattern.compile("((pv)\\s{1,6}peak\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec)))|(peak\\s{1,6}(recorded)*\\s*velocity.{1,30}(across\\s(the)*\\s*pulmonary\\s*valve).{1,20}(((cm)|m)\\/(s|second|sec)))|((across\\s*(the)*\\s*pulmonary\\s*valve).{1,40}peak\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec)))");
	        Pattern p13e = Pattern.compile("((?<=(peak\\s{1,6}(recorded)\\s{1,6}velocity.{1,40}))|(?<=(peak\\s{1,6}velocity.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\_*\\s*(((cm)|m)\\/(s|second|sec)))");
	                
	        Pattern p12f = Pattern.compile("((av|aortic\\s*valve)\\s{1,6}peak\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec)))|(peak\\s{1,6}(recorded)*\\s*velocity.{1,30}(across\\s(the)*\\s*(bioprosthetic\\s)*aortic\\s*valve).{1,20}(((cm)|m)\\/(s|second|sec)))|((across\\s*(the)*\\s*(bioprosthetic\\s)*aortic\\s*valve).{1,40}peak\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec)))|(peak\\s{1,6}(trans)*aortic(\\svalve)*\\s{1,6}velocity.{1,20}(((cm)|m)\\/(s|second|sec)))|(((((bioprosthetic)|(prosthetic)|(bioprosthetic\\svalve)).{1,90}aortic\\s*(valve|pos(i)*tion))|(((aortic)|(ao)|(av))\\s*((bioprosthetic\\s(valve)*)|(prosthesis)|(bioprosthesis)|(pos(i)*tion)))).{1,140}((this\\scorresponds)|with|calculating|the).{1,140}(peak\\s{1,4}(velocity)).+?{1,40}(((cm)|m)\\/(s|second|sec)))");
	        Pattern p13f = Pattern.compile("((?<=(peak\\s{1,6}(recorded|transaortic)\\s{1,6}velocity.{1,40}))|(?<=(peak\\s{1,6}aortic\\s{1,6}velocity.{1,40}))|(?<=(peak\\s{1,6}velocity.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\_*\\s*(((cm)|m)\\/(s|second|sec)))");
	           
	        Pattern p12g = Pattern.compile("(tr\\s{1,6}peak\\s{1,6}velocity.{1,20}(((cm)|m)\\/(s|second|sec)))|(tr\\s{1,6}max\\s{1,6}vel.{1,20}(((cm)|m)\\/(s|second|sec)))");
	        Pattern p13g = Pattern.compile("((?<=(peak\\s{1,6}(recorded)\\s{1,6}velocity.{1,40}))|(?<=(tr\\s{1,6}max\\s{1,6}vel.{1,20}))|(?<=(peak\\s{1,6}velocity.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\_*\\s*(((cm)|m)\\/(s|second|sec)))");
	        
	        Pattern p12h = Pattern.compile("(mr\\s{1,6}peak\\s{1,6}velocity.{1,20}(((cm)|m)\\/(s|second|sec)))");
	        Pattern p13h = Pattern.compile("((?<=(peak\\s{1,6}(recorded)\\s{1,6}velocity.{1,40}))|(?<=(peak\\s{1,6}velocity.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\_*\\s*(((cm)|m)\\/(s|second|sec)))");
	       
	        Pattern p12aa = Pattern.compile("((lvot)\\s{1,6}mean\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec)))|(mean\\s{1,6}(recorded)*\\s*velocity.{1,30}(across\\s(the)*\\s*lvot).{1,20}(((cm)|m)\\/(s|second|sec)))|((across\\s*(the)*\\s*lvot).{1,40}mean\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec)))");
	        Pattern p13aa = Pattern.compile("((?<=(mean\\s{1,6}(recorded)\\s{1,6}velocity.{1,40}))|(?<=(mean\\s{1,6}velocity.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\_*\\s*(((cm)|m)\\/(s|second|sec)))");
	        
	        Pattern p12ab = Pattern.compile("((pv)\\s{1,6}mean\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec)))|(mean\\s{1,6}(recorded)*\\s*velocity.{1,30}(across\\s(the)*\\s*pulmonary\\s*valve).{1,20}(((cm)|m)\\/(s|second|sec)))|((across\\s*(the)*\\s*pulmonary\\s*valve).{1,40}mean\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec)))");
	        Pattern p13ab = Pattern.compile("((?<=(mean\\s{1,6}(recorded)\\s{1,6}velocity.{1,40}))|(?<=(mean\\s{1,6}velocity.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\_*\\s*(((cm)|m)\\/(s|second|sec)))");
	        
	        Pattern p12ac = Pattern.compile("(mr\\s{1,6}mean\\s{1,6}velocity.{1,20}(((cm)|m)\\/(s|second|sec)))");
	        Pattern p13ac = Pattern.compile("((?<=(mean\\s{1,6}(recorded)\\s{1,6}velocity.{1,40}))|(?<=(mean\\s{1,6}velocity.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\_*\\s*(((cm)|m)\\/(s|second|sec)))");
	        
	        Pattern p12ad = Pattern.compile("((av|aortic\\s*valve)\\s{1,6}mean\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec)))|(mean\\s{1,6}(recorded)*\\s*velocity.{1,30}(across\\s(the)*\\s*(bioprosthetic\\s)*aortic\\s*valve).{1,20}(((cm)|m)\\/(s|second|sec)))|((across\\s*(the)*\\s*(bioprosthetic\\s)*aortic\\s*valve).{1,40}mean\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec)))|(mean\\s{1,6}(trans)*aortic(\\svalve)*\\s{1,6}velocity.{1,20}(((cm)|m)\\/(s|second|sec)))");
	        Pattern p13ad = Pattern.compile("((?<=(mean\\s{1,6}(recorded)\\s{1,6}velocity.{1,40}))|(?<=(mean\\s{1,6}velocity.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\_*\\s*(((cm)|m)\\/(s|second|sec)))");
	        
	        Pattern p12ae = Pattern.compile("((mv|mitral\\s*valve)\\s{1,6}mean\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec)))|(mean\\s{1,6}(recorded)*\\s*velocity.{1,30}(across\\s(the)*\\s*(bioprosthetic\\s)*mitral\\s*valve).{1,20}(((cm)|m)\\/(s|second|sec)))|((across\\s*(the)*\\s*(bioprosthetic\\s)*mitral\\s*valve).{1,40}mean\\s{1,6}(recorded)*\\s*velocity.{1,20}(((cm)|m)\\/(s|second|sec)))|(mean\\s{1,6}(trans)*mitral(\\svalve)*\\s{1,6}velocity.{1,20}(((cm)|m)\\/(s|second|sec)))");
	        Pattern p13ae = Pattern.compile("((?<=(mean\\s{1,6}(recorded)\\s{1,6}velocity.{1,40}))|(?<=(mean\\s{1,6}velocity.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\_*\\s*(((cm)|m)\\/(s|second|sec)))");
	        
	        Pattern p12af = Pattern.compile("((tricuspid\\s*valve)|(tv))\\s{1,6}mean\\s{1,6}velocity.{1,20}(((cm)|m)\\/(s|second|sec))");
	        Pattern p13af = Pattern.compile("((?<=(mean\\s{1,6}(recorded)\\s{1,6}velocity.{1,40}))|(?<=(mean\\s{1,6}velocity.{1,40})))(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\_*\\s*((cm|m)\\/(s|second|sec)))");
	      
	        Pattern p14 = Pattern.compile("((mildly\\s*dialated\\s*(moderate|severe))|(moderately\\s*severe\\s*to\\s*severe)|(mild\\s*\\-*to\\s*\\-*moderate)|(moderate\\s*\\-*to\\s*\\-*severe)|(mild-moderate)|(moderate-severe)|(mild)|(moderate)|(severe)|(low\\s*\\-*gradient)|(minimal)|(no\\s*significant)|(significant)|(no\\s+evidence\\s*of*(\\sbioprosthetic)*)|(no\\s*))[\\s\\w]{1,30}(((aortic.{1,5}stenosis))|(aortic\\svalve\\sstenosis))");
	        Pattern p15 = Pattern.compile("((mildly\\s*dialated\\s*(moderate|severe))|(moderately\\s*severe\\s*to\\s*severe)|(mild\\s*\\-*to\\s*\\-*moderate)|(moderate\\s*\\-*to\\s*\\-*severe)|(mild-moderate)|(moderate-severe)|(mild)|(moderate)|(severe)|(low\\s*\\-*gradient)|(minimal)|(no\\s*significant)|(significant)|(no\\s+evidence\\s)|(no\\s))");
	        
	        Pattern p14a = Pattern.compile("((mildly\\s*dialated\\s*(moderate|severe))|(moderately\\s*severe\\s*to\\s*severe)|(mild\\s*\\-*to\\s*\\-*moderate)|(moderate\\s*\\-*to\\s*\\-*severe)|(mild-moderate)|(moderate-severe)|(mild)|(moderate)|(severe)|(low\\s*\\-*gradient)|(minimal)|(no\\s*significant)|(significant)|(no\\s+evidence\\s*of*(\\sbioprosthetic)*)|(no\\s*))[\\s\\w]{1,30}((mitral.{1,15}stenosis)|(mitral\\svalve\\sstenosis))");
	        Pattern p15a = Pattern.compile("((mildly\\s*dialated\\s*(moderate|severe))|(moderately\\s*severe\\s*to\\s*severe)|(mild\\s*\\-*to\\s*\\-*moderate)|(moderate\\s*\\-*to\\s*\\-*severe)|(mild-moderate)|(moderate-severe)|(mild)|(moderate)|(severe)|(low\\s*\\-*gradient)|(minimal)|(no\\s*significant)|(significant)|(no\\s+evidence\\s)|(no\\s))");
	      
	        Pattern p16 = Pattern.compile("(dimensionless\\s*index)\\s*(is|are|was|of|\\=)*\\s*((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))(?=(\\s|\\,|\\(|\\)|\\w+|(\\s\\d)|(\\.\\s*\\w+)))");
	        Pattern p17 = Pattern.compile("(?<=(dimensionless\\s{1,6}index.{1,5}))(\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+)");
	       
	        Pattern p18 = Pattern.compile("mva\\s*\\(p1\\/2t\\)(.){1,10}((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))");
	        Pattern p19 = Pattern.compile("(?<=(\\(p1\\/2t\\)\\:))((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))");
	      
	        Pattern p20 = Pattern.compile("((pulmonary\\s*artery\\s*systolic\\s*pressure.{1,20}(estimated)*.{1,10})|(pa\\s*systolic\\s*pressure)).{1,15}(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))((\\s*mmhg)|(\\s*mm\\s*hg)))");
	        Pattern p21 = Pattern.compile("(\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+)");
	       
	        Pattern p22 = Pattern.compile("((right\\s*atrial\\s*pressure)|(ra\\s*pressure)).{1,40}(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+)).{1,8}((\\s*mmhg)|(\\s*mm\\s*hg)))");
	        Pattern p23 = Pattern.compile("((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d+\\s*(\\-|to)\\s*\\d*\\.\\d+)|(\\d*\\.\\d+)|(\\d+))");
	      
	        Pattern p24 =  Pattern.compile("((no\\s(obvious))|(not\\ssuggest\\ssevere)|(not\\ssuggestive\\sof\\ssignificant)|(trace\\sto\\smild)|(mild\\sto\\strace)|(trivial\\sto\\smild)|(mildly\\s*dialated\\s*(moderate|severe))|(moderately\\s*severe\\s*to\\s*severe)|(mild\\s*\\-*to\\s*\\-*moderate)|(mild\\s*\\-*to\\s*\\-*trace)|(moderate\\s*\\-*to\\s*\\-*((severe)|(marked)))|(mild-moderate)|(moderate-severe)|(mild)|(trace)|(moderate)|(severe)|(trace(\\s\\/)*)|(trivial)|(no\\s*significant)|(significant)|(no\\s+evidence\\s*of*)|(no\\s*))((\\s*\\Wai\\W)|(\\s*\\War\\W)|([\\s\\w+]{1,35}((aortic)\\s*((insufficiency)|(stenosis.{1,35}regurgitation)|(regurgitation)))))");
	        Pattern p25 =  Pattern.compile("((no\\s(obvious))|(not\\ssuggest\\ssevere)|(not\\ssuggestive\\sof\\ssignificant)|(trace\\sto\\smild)|(mild\\sto\\strace)|(trivial\\sto\\smild)|(mildly\\s*dialated\\s*(moderate|severe))|(moderately\\s*severe\\s*to\\s*severe)|(mild\\s*\\-*to\\s*\\-*moderate)|(mild\\s*\\-*to\\s*\\-*trace)|(moderate\\s*\\-*to\\s*\\-*((severe)|(marked)))|(mild-moderate)|(moderate-severe)|(mild)|(trace)|(moderate)|(severe)|(trace)|(trivial)|(no\\s*significant)|(significant)|(no\\s+evidence\\s*of*)|(no\\s))((?=(\\sai\\W))|(?=(\\sar\\W))|(?=(\\s*aortic\\s*((insufficiency)|(stenosis.{1,35}regurgitation)|(regurgitation))))|((?=(\\s*((transvalvular)|(peri\\s*valvular)|(central)|(eccentric)|((\\w+\\s)*jet\\sof)|(perivalvular\\sleak\\sor)|(transvalvular\\sor\\sperivalvular)|(\\s(\\/\\s)*\\w+\\s)|(\\s\\w+\\s\\w+\\s))\\s*aortic\\s*((insufficiency)|(stenosis.{1,35}regurgitation)|(regurgitation))))))");
	        
	        Pattern p24a = Pattern.compile("((no\\s(obvious))|(not\\ssuggest\\ssevere)|(not\\ssuggestive\\sof\\ssignificant)|(trace\\sto\\smild)|(mild\\sto\\strace)|(trivial\\sto\\smild)|(mildly\\s*dialated\\s*(moderate|severe))|(moderately\\s*severe\\s*to\\s*severe)|(mild\\s*\\-*to\\s*\\-*moderate)|(mild\\s*\\-*to\\s*\\-*trace)|(moderate\\s*\\-*to\\s*\\-*((severe)|(marked)))|(mild-moderate)|(moderate-severe)|(mild)|(trace)|(moderate)|(severe)|(trace(\\s\\/)*)|(trivial)|(no\\s*significant)|(significant)|(no\\s+evidence\\s*of*)|(no\\s*))((\\s*\\Wmi\\W)|(\\s*\\Wmr\\W)|([\\s\\w+]{1,35}((mitral)\\s*((insufficiency)|(stenosis\\sor\\sregurgitation)|(regurgitation)))))");
	        Pattern p25a = Pattern.compile("((no\\s(obvious))|(not\\ssuggest\\ssevere)|(not\\ssuggestive\\sof\\ssignificant)|(trace\\sto\\smild)|(mild\\sto\\strace)|(trivial\\sto\\smild)|(mildly\\s*dialated\\s*(moderate|severe))|(moderately\\s*severe\\s*to\\s*severe)|(mild\\s*\\-*to\\s*\\-*moderate)|(mild\\s*\\-*to\\s*\\-*trace)|(moderate\\s*\\-*to\\s*\\-*((severe)|(marked)))|(mild-moderate)|(moderate-severe)|(mild)|(trace)|(moderate)|(severe)|(trace)|(trivial)|(no\\s*significant)|(significant)|(no\\s+evidence\\s*of*)|(no\\s))((?=(\\smi\\W))|(?=(\\smr\\W))|(?=(\\s*mitral\\s*((insufficiency)|(stenosis\\sor\\sregurgitation)|(regurgitation))))|((?=(\\s*((transvalvular)|(peri\\s*valvular)|(central)|(eccentric)|((\\w+\\s)*jet\\sof)|(perivalvular\\sleak\\sor)|(transvalvular\\sor\\sperivalvular)|(\\s(\\/\\s)*\\w+\\s)|(\\s\\w+\\s\\w+\\s))\\s*mitral\\s*((insufficiency)|(stenosis.{1,35}regurgitation)|(regurgitation))))))");
	      
	        Pattern p26 = Pattern.compile("vena\\s*contracta(.){1,20}((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\s*(cm|mm)");
	        Pattern p27 = Pattern.compile("((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\s*(cm|mm)");
	       
	        Pattern p28 = Pattern.compile("regurgitant\\s*fraction(.){1,20}((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\s*(\\%)");
	        Pattern p29 = Pattern.compile("(\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d+\\.\\d+)|(\\d+)");
	      
	        Pattern p30 = Pattern.compile("((effective\\s*regurgitant\\s*orifice.{1,8}area)|(effective\\s*orifice\\s*area)|(effective\\s*regurgitant\\s*orifice)|(regurgitant\\s*orifice\\s*area))(.){1,50}((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\s*(cm2|(cm[\\p{L}\\p{Nd}])|(cm\u00b2)|mm2|mm\\?*|cm\\?*|sq\\scm|sq\\smm|m2)");
	        Pattern p31 = Pattern.compile("((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\s*(cm2|(cm[\\p{L}\\p{Nd}])|(cm\u00b2)|mm2|mm\\?*|cm\\?*|sq\\scm|sq\\smm|m2)");
	       
	        Pattern p32 = Pattern.compile("((ar)|(ai)|(aortic\\s*(insufficiency|regurgitation))).{1,5}pressure\\s*half.{1,5}time(.){1,10}(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\s*(ms|msec|millisecond|millisec))");
	        Pattern p33 = Pattern.compile("((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))(?=(\\s*(ms|msec|millisecond|millisec)))");
	       
	        Pattern p34 = Pattern.compile("(.{1,30}(holodiastolic|diastolic|aorta).{1,20}(flow.{1,30}reversal).{1,20})|(.{1,30}(reversal\\s*of\\s*flow).{1,30}(aorta|diastole))");
	        Pattern p35 = Pattern.compile("(there\\s*is\\s*no\\s)|(there\\s*is\\s*(evidence)*)|(is\\s*not\\s*seen)|(there\\s*was)|(show)|(reveal)|(no\\s)|(no\\s*spectral*\\s*evidence)|(has)|(demonstrate(sd)*)|(with\\s*(evidence)*)|(with)");
	      
	        Pattern p36 = Pattern.compile("((lvef)|((?<=\\W)ef\\W)|(lv\\s*ejection\\s*fraction)|(left\\s*(ventricular|ventricle)\\s*ejection\\s*fraction)|(ejection\\s*fraction)).{1,85}?((((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\s*(\\%))|(normal(\\slimit)*))");
	        Pattern p37 = Pattern.compile("((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))((?=(\\%))|(?=(\\-*\\s*(\\%))))");
	        
			Pattern p38 = Pattern.compile("(diastolic\\s*(dysfunction|function).{1,30}grade\\s*(\\d|(i\\-)|(i\\s)))|(grade.{1,40}diastolic\\s*(dysfunction|function)(\\s\\w+\\s\\w+)*)");
	        Pattern p39 = Pattern.compile("(grade\\s*(i-ii))|(grade\\s*(iii))|(grade\\s*(ii))|(grade\\s*(i))|(grade\\s*(1))|(grade\\s*(2))|(grade\\s*(3))");
	      
	        Pattern p40 = Pattern.compile("(((mv)|(mitral\\s*valve))\\s*e(\\/a\\:)\\s*((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+)))|((mitral\\s*e\\s*to\\s*a\\s*ratio).{1,10}((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+)))"); //
	        Pattern p41 = Pattern.compile("(\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+)");
	      
	        Pattern p42 = Pattern.compile("((lv)|(left\\s*(ventricular|ventricle)))\\s*filling\\s*(pressure|pressures).{1,40}(increased|elevated|indeterminate|normal)"); //
	        Pattern p43 = Pattern.compile("(increased|elevated|indeterminate|normal)");
	       
	        Pattern p44 = Pattern.compile("((e\\/e\\')|(e\\:e\\'))[\\s*\\=\\w+]{1,50}((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))"); //
	        Pattern p45 = Pattern.compile("((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))");
	       
	        Pattern p46 = Pattern.compile("(lvedd\\s*\\=*\\s*((\\d*\\.\\d+)|(\\d+))\\s*((cm)|(mm)|(ccm))*)|(lvedd\\s*(is|at|\\:)[\\s*\\w+]{1,50}((\\d*\\.\\d+)|(\\d+))\\s*((cm)|(mm)|(ccm))*)|(lv\\s*size\\s*\\-*end\\s*diastole.{1,15}?cm)"); // LV end diastole
	        Pattern p47 = Pattern.compile("((\\d*\\.\\d+)|(\\d+))\\s*((cm)|(mm)|(ccm))*");
	        
	        Pattern p48 = Pattern.compile("((lvsd|lvesd)\\s*\\=*\\s*(is\\s)*((\\d*\\.\\d+)|(\\d+))\\s*((cm)|(mm)|(ccm))*)|(lv\\s*size\\s*\\-*end\\s*systole.{1,15}?cm)");  // LV end systole
	        Pattern p49 = Pattern.compile("((\\d*\\.\\d+)|(\\d+))\\s*((cm)|(mm)|(ccm))*");
	       
	        Pattern p50 = Pattern.compile("(concentric.{1,15}((lvh)|(((left\\s*(ventricular|ventricle))|(lv))\\s*hypertrophy)))|(((left\\s*(ventricular|ventricle))|(lv))\\s*concentric\\s*hypertrophy)"); //
	        Pattern p51 = Pattern.compile("concentric");
	        
	        Pattern p50a = Pattern.compile("basal\\s*septal\\s*hypertrophy"); //
	        Pattern p51a = Pattern.compile("basal\\s*septal");
	       
	        Pattern p52 = Pattern.compile("((mild\\s*\\-*to*\\s*\\-*moderate)|(borderline)|(moderate\\s*\\-*to*\\s*\\-*severe)|(mild)|(severe)|(moderate)).{1,10}((concentric.{1,15}((lvh)|(((left\\s*(ventricular|ventricle))|(lv))\\s*hypertrophy)))|(((left\\s*(ventricular|ventricle))|(lv))\\s*concentric\\s*hypertrophy))");
	        Pattern p53 = Pattern.compile("((mild\\s*\\-*to*\\s*\\-*moderate)|(borderline)|(moderate\\s*\\-*to*\\s*\\-*severe)|(mild)|(severe)|(moderate))");
	        
	        Pattern p52a = Pattern.compile("(((mild\\s*\\-*to*\\s*\\-*moderate)|(borderline)|(moderate\\s*\\-*to*\\s*\\-*severe)|(mild\\s*additiona*l)|(severe)|(moderate)|(mild))\\s{1,4}basal\\s{1,4}septal\\s{1,4}hypertrophy)");
	        Pattern p53a = Pattern.compile("((mild\\s*\\-*to*\\s*\\-*moderate)|(borderline)|(moderate\\s*\\-*to*\\s*\\-*severe)|(mild)|(severe)|(moderate))");
	       
	        Pattern p54 = Pattern.compile("septal\\s*thickness.{1,40}((\\d+\\s*\\-\\s*\\d+)|(\\d*\\.\\d*\\s*\\-\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\s(cm|mm)"); // |(.{1,100}septal\\s*w.{1,100})
	        Pattern p55 = Pattern.compile("(\\d+\\s*\\-\\s*\\d+)|(\\d*\\.\\d*\\s*\\-\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+)\\s(cm|mm)"); // |septal\\s*wall\\s*thick[\\s*\\-]diastole.{1,30}(\\d+|\\d*\\.\\d+)\\s*(cm|ccm|mm)
	      
	        Pattern p56 = Pattern.compile("((moderately\\s*severe\\s*to\\s*severe)|(mild\\s*\\-*to\\s*\\-*moderate)|(moderate\\s*\\-*to\\s*\\-*severe)|(mild)|(moderate)|(severe))((.{1,50}and\\s*left\\s*atrial\\s*enlargement)|(atrial\\s*enlargement)|(\\s*left\\s*atrial\\s*enlargement))");
	        Pattern p57 = Pattern.compile("(moderately\\s*severe\\s*to\\s*severe)|(mild\\s*\\-*to\\s*\\-*moderate)|(moderate\\s*\\-*to\\s*\\-*severe)|(mild)|(moderate)|(severe)");
	       
	        Pattern p58 = Pattern.compile("(la\\s*dimension\\s*\\:\\s*((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\s*(cm|mm))|(la\\s*diameter.{1,20}?cm)"); 	//Pattern.compile("la\\s*dia.*?((\\d*\\.\\d+)|(\\d+))\\s*(cm|mm)");
	        Pattern p59 = Pattern.compile("((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))");    									//Pattern.compile("(?<!((\\-)|(\\-\\s)))((\\d+\\.\\d*))\\s*(cm)");
	        
	        Pattern p60 = Pattern.compile("volume\\s*index(.){1,20}((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\s{1,4}((ml\\s*per\\s*square\\s*meter)|(ml\\/m(2|\\?)*)|(ml\\/sq\\/m))"); //
	        Pattern p61 = Pattern.compile("((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))(?=(\\s*((ml\\s*per\\s*square\\s*meter)|(ml\\/m(2|\\?)*)|(ml\\/sq\\/m))))");
	       
	        Pattern p62 = Pattern.compile("(bsa).{10}"); //
	        Pattern p63 = Pattern.compile("((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))(?=(.*((\\(cm\\))|(m\\s\\2)|(m[\\p{L}\\p{Nd}])|(m\u00b2)|(.*cm)|(.*m2)|(.*m\\?*))))");

			Pattern p62a = Pattern.compile("((rvot\\s*stroke\\s*volume)|(rvot\\s*velocity\\s*time\\s*(integr(al)*))|(rvot\\s*vti)).*?\\s*cm\\?*"); //
			Pattern p63a = Pattern.compile("((?<=(rvot\\s{1,6}stroke\\s{1,6}volume.{1,30}))|(?<=(rvot\\s{1,6}velocity\\s{1,6}time\\s{1,6}((integral)|(integr)).{1,40}))|(?<=(rvot\\s{1,6}vti.{1,20}))|(?<=(((rvot\\s{1,6}stroke\\s{1,6}volume)|(rvot\\s{1,6}velocity\\s{1,6}time\\s{1,6}((integral)|(integr)))|(rvot\\s{1,6}vti)).{1,20}((is)|(of)|(\\=)).{1,20})))\\s*((\\d*\\.*\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+)|(\\[\\*\\*\\d+(\\-|to)\\d+\\*\\*\\]))(?=(\\s*((cm)|(cm\\?)|(cm\\?\\?))))");
			
			Pattern p62b = Pattern.compile("((lvot\\s*((dia(meter)*)|(dimension))).{1,20}?((mm)|(cm)))"); // term lvot
			Pattern p63b = Pattern.compile("((?<=(lvot\\s{1,6}((diameter)|(dimension))\\s{1,100}))|(?<=(lvot\\s{1,6}((diam\\:)|(diam\\:\\s{1,10})|(diam\\,\\s{1,6}s\\s{1,10}))))|(?<=(lvot\\s{1,6}((diameter)|(dimension))\\s{1,10}((\\w{1,40})|(\\=))\\s{1,10}))|(?<=(lvot\\s{1,6}((diameter)|(dimension))\\=))|(?<=(lvot\\s{1,6}((diameter)|(dimension))\\s{1,5}\\=)))((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d+\\.\\d+)|(\\d+))\\s*((cm)|(mm))*");
			
			Pattern p62c = Pattern.compile("((((aortic)|(ao))\\s*root\\s*((dia)|(measured))).*?((mm)|(cm)|(normal)))"); // term aortic
			Pattern p63c = Pattern.compile("((?<=(((aortic)|(ao))\\s{1,6}root\\s{1,6}((dia\\.\\s)|(diameter\\s)|(diam\\:)|(diam\\:\\s)|(dia\\.)|(diameter)|(measured\\s{1,10}))))|(?<=(((aortic\\s{1,6}root\\s{1,10}((dia\\.)|(diameter)).{1,50}valsalva\\s)|(aortic\\s{1,6}root\\s{1,10}((dia\\.)|(diameter))\\s)).{1,50}((\\w{1,40}\\s{1,10})|(\\=\\s{1,10})))))((\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d+\\.\\d+)|(\\d+))\\s*((cm)|(mm))");

			Pattern p62d = Pattern.compile("((av\\s*velocity\\s*time\\s*(integr(al)*))|(ao\\s*v2\\s*vti)).*?\\s*cm\\?*"); //((av)|(v2))
			Pattern p63d = Pattern.compile("((?<=(av\\s{1,6}velocity\\s{1,6}time\\s{1,6}((integral)|(integr)).{1,40}))|(?<=(((av)|(ao\\s{1,6}v2))\\s{1,6}vti.{1,20}))|(?<=(((av\\s{1,6}velocity\\s{1,6}time\\s{1,6}((integral)|(integr)))|(((av)|(v2))\\s{1,6}vti)).{1,20}((is)|(of)|(\\=)|(\\:)).{1,20})))\\s*((\\d*\\.*\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+)|(\\[\\*\\*\\d+(\\-|to)\\d+\\*\\*\\]))(?=(\\s*((cm)|(cm\\?)|(cm\\?\\?))))");
			
			Pattern p62e = Pattern.compile("((mv\\s*stroke\\s*volume)|(mv\\s*velocity\\s*time\\s*(integr(al)*))|(mv\\s*v2\\s*vti)).*?\\s*cm\\?*");
			Pattern p63e = Pattern.compile("((?<=(mv\\s{1,6}stroke\\s{1,6}volume.{1,30}))|(?<=(mv\\s{1,6}velocity\\s{1,6}time\\s{1,6}((integral)|(integr)).{1,40}))|(?<=(mv\\s{1,6}v2\\s{1,6}vti.{1,20}))|(?<=(((mv\\s{1,6}stroke\\s{1,6}volume)|(mv\\s{1,6}velocity\\s{1,6}time\\s{1,6}((integral)|(integr)))|(mv\\s{1,6}vti)).{1,20}((is)|(of)).{1,20})))\\s*((\\d*\\.*\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+)|(\\[\\*\\*\\d+(\\-|to)\\d+\\*\\*\\]))(?=(\\s*((cm)|(cm\\?)|(cm\\?\\?))))");
			
			Pattern p62f = Pattern.compile("((lvot\\s*stroke\\s*volume)|(lvot\\s*velocity\\s*time\\s*(integr(al)*))|(((lvot)|(v1))\\s*vti)).*?\\s*cm\\?*"); //((lvot)|(v1))
			Pattern p63f = Pattern.compile("((?<=(lvot\\s{1,6}stroke\\s{1,6}volume.{1,30}))|(?<=(lvot\\s{1,6}velocity\\s{1,6}time\\s{1,6}((integral)|(integr)).{1,40}))|(?<=(((lvot)|(v1))\\s{1,6}vti.{1,20}))|(?<=(((lvot\\s{1,6}stroke\\s{1,6}volume)|(lvot\\s{1,6}velocity\\s{1,6}time\\s{1,6}((integral)|(integr)))|(((lvot)|(v1))\\s{1,6}vti)).{1,20}((is)|(of)|(\\=)).{1,20})))\\s*((\\d*\\.*\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+)|(\\[\\*\\*\\d+(\\-|to)\\d+\\*\\*\\]))(?=(\\s*((cm)|(cm\\?)|(cm\\?\\?))))");

			Pattern p62g = Pattern.compile("((rvot\\s*((dia(meter)*)|(dimension))).{1,20}?((mm)|(cm)))"); 
			Pattern p63g = Pattern.compile("((?<=(rvot\\s{1,6}((diameter)|(dimension))\\s{1,100}))|(?<=(rvot\\s{1,6}(diam\\:){1,20}))|(?<=(rvot\\s{1,6}((diameter)|(dimension))\\s{1,10}((\\w{1,40})|(\\=))\\s{1,10}))|(?<=(rvot\\s{1,6}((diameter)|(dimension))\\=))|(?<=(rvot\\s{1,6}((diameter)|(dimension))\\s{1,5}\\=)))((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\s*((cm)|(mm))*");
			
			Pattern p64 = Pattern.compile("(((rv\\s*basal)|(basal\\s*rv))).{1,50}?((mm)|(cm))");
			Pattern p65 = Pattern.compile("((\\d*\\.\\d+)|(\\d+))\\s*((cm)|(mm))*");
			
			Pattern p66= Pattern.compile("tapse.{1,20}?((cm)|(mm)|(\\%))");
			Pattern p67 = Pattern.compile("((\\d*\\.\\d+)|(\\d+))\\s*((cm)|(mm))*");
			
			Pattern p68 = Pattern.compile("((rvef)|(rv\\s*ejection\\s*fraction)|(right\\s*(ventricular|ventricle)\\s*ejection\\s*fraction)).{1,20}?((((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\s*(\\%))|(normal(\\slimit)*))");
			Pattern p69 = Pattern.compile("(((\\d+\\s*(\\-|to)\\s*\\d+)|(\\d*\\.\\d*\\s*(\\-|to)\\s*\\d*\\.\\d*)|(\\d*\\.\\d+)|(\\d+))\\s*((cm)|(mm))*)|(normal(\\slimit)*)");
			
			Pattern p70 = Pattern.compile("la\\s*volume(?!(\\s{1,20}index)).{1,20}?((ml/m2)|(ml/m\\?*)|(ml\\s*per\\s*square\\s*meter))"); 
			Pattern p71 = Pattern.compile("((\\d*\\.\\d+)|(\\d+))(?=(\\s{1,20}((ml/m2)|(ml/m\\?*)|(ml\\s*per\\s*square\\s*meter))))");
			
			Pattern p72 = Pattern.compile("(mv).{1,5}pressure\\s*half.{1,5}time(.){1,10}(((\\d*\\.\\d+)|(\\d+))\\s*(ms|msec|millisecond|millisec))");
			Pattern p73 = Pattern.compile("((\\d*\\.\\d+)|(\\d+))(?=(\\s*(ms|msec|millisecond|millisec)))");
	        
	        Pattern p74 = Pattern.compile(".{20}(pericardiu(m)*.{1,40}?size).{30}");   
	        Pattern p75 = Pattern.compile("((moderate)|(trace)|(trivial)|(((small)|(large)|(medium)|(moderate(ly)*))\\-*sized)|(small\\-*to*moderate)|(moderate\\-*to*large))");
	        
	        Pattern p76 = Pattern.compile(".{30}((inferior\\s*vena\\s*cava\\s*dia)|((ivc\\s))).{90}");
	        Pattern p77 = Pattern.compile("((\\d+\\.\\d*)|(\\d+))\\s*((cm)|(mm)|(\\%))");
	        
	        Pattern p78 = Pattern.compile("((right\\s*atrial\\s*pressure(?!(\\.)))|((ra\\s*pressure(?!(\\.)))))(?!(.{1,30}\\..{1,30})).{1,60}?((moderate)|(normal)|(small)|(large)|(medium))");   
	        Pattern p79 = Pattern.compile("((moderate)|(trace)|(trivial)|(((small)|(large)|(normal)|(medium)|(moderate(ly)*))\\-*sized)|(small\\-*to*moderate)|(moderate\\-*to*large))");
	        
	        Pattern p80 = Pattern.compile("(((ra)|(right\\s*atrium))\\W.{1,80}?((\\Wnormal)|(dilated)|(enlarged)|(supranormal)|(abnormal)))");   
	        Pattern p81 = Pattern.compile("((\\Wnormal)|(dilated)|(enlarged)|(supranormal)|(abnormal))");
	        
	        Pattern p82 = Pattern.compile("((mild\\s*\\-*to*\\s*\\-*moderate)|(borderline)|(moderate\\s*\\-*to*\\s*\\-*severe)|(mild)|(severe)|(moderate)|(\\Wno\\W)).{1,10}?((((rvh)|(((right\\s*(ventricular|ventricle))|(rv))\\s*hypertrophy)))|(((right\\s*(ventricular|ventricle))|(rv))\\s*hypertrophy))");
	        Pattern p83 = Pattern.compile("((mild\\s*\\-*to*\\s*\\-*moderate)|(borderline)|(moderate\\s*\\-*to*\\s*\\-*severe)|(mild)|(severe)|(moderate)|(\\Wno\\W))");
	        
	        Pattern p84 =  Pattern.compile("((no\\s(obvious))|(not\\ssuggest\\ssevere)|(not\\ssuggestive\\sof\\ssignificant)|(trace\\sto\\smild)|(mild\\sto\\strace)|(trivial\\sto\\smild)|(mildly\\s*dialated\\s*(moderate|severe))|(moderately\\s*severe\\s*to\\s*severe)|(mild\\s*\\-*to\\s*\\-*moderate)|(mild\\s*\\-*to\\s*\\-*trace)|(moderate\\s*\\-*to\\s*\\-*((severe)|(marked)))|(mild-moderate)|(moderate-severe)|(mild)|(trace)|(moderate)|(severe)|(trace(\\s\\/)*)|(trivial)|(no\\s*significant)|(significant)|(no\\s+evidence\\s*of*)|(no\\s*))((\\s*\\Wpi\\W)|(\\s*\\Wpr\\W)|([\\s\\w+]{1,35}((pulmonary)\\s*((insufficiency)|(stenosis\\sor\\sregurgitation)|(regurgitation)))))");
	        Pattern p85 =  Pattern.compile("((no\\s(obvious))|(not\\ssuggest\\ssevere)|(not\\ssuggestive\\sof\\ssignificant)|(trace\\sto\\smild)|(mild\\sto\\strace)|(trivial\\sto\\smild)|(mildly\\s*dialated\\s*(moderate|severe))|(moderately\\s*severe\\s*to\\s*severe)|(mild\\s*\\-*to\\s*\\-*moderate)|(mild\\s*\\-*to\\s*\\-*trace)|(moderate\\s*\\-*to\\s*\\-*((severe)|(marked)))|(mild-moderate)|(moderate-severe)|(mild)|(trace)|(moderate)|(severe)|(trace)|(trivial)|(no\\s*significant)|(significant)|(no\\s+evidence\\s*of*)|(no\\s))((?=(\\s*\\Wpi\\W))|(?=(\\s*\\Wpr\\W))|(?=(\\s*pulmonary\\s*((insufficiency)|(stenosis\\sor\\sregurgitation)|(regurgitation))))|((?=(\\s*((transvalvular)|(peri\\s*valvular)|(central)|(eccentric)|((\\w+\\s)*jet\\sof)|(perivalvular\\sleak\\sor)|(transvalvular\\sor\\sperivalvular)|(\\s(\\/\\s)*\\w+\\s)|(\\s\\w+\\s\\w+\\s))\\s*pulmonary\\s*((insufficiency)|(stenosis\\sor\\sregurgitation)|(regurgitation))))))");
	        
	        Pattern p86 =  Pattern.compile("((no\\s(obvious))|(not\\ssuggest\\ssevere)|(not\\ssuggestive\\sof\\ssignificant)|(trace\\sto\\smild)|(mild\\sto\\strace)|(trivial\\sto\\smild)|(mildly\\s*dialated\\s*(moderate|severe))|(moderately\\s*severe\\s*to\\s*severe)|(mild\\s*\\-*to\\s*\\-*moderate)|(mild\\s*\\-*to\\s*\\-*trace)|(moderate\\s*\\-*to\\s*\\-*((severe)|(marked)))|(mild-moderate)|(moderate-severe)|(mild)|(trace)|(moderate)|(severe)|(trace(\\s\\/)*)|(trivial)|(no\\s*significant)|(significant)|(no\\s+evidence\\s*of*)|(no\\s*))((\\s*\\Wti\\W)|(\\s*\\Wtr\\W)|([\\s\\w+]{1,35}((tricuspid)\\s*((insufficiency)|(stenosis\\sor\\sregurgitation)|(regurgitation)))))");
	        Pattern p87 =  Pattern.compile("((no\\s(obvious))|(not\\ssuggest\\ssevere)|(not\\ssuggestive\\sof\\ssignificant)|(trace\\sto\\smild)|(mild\\sto\\strace)|(trivial\\sto\\smild)|(mildly\\s*dialated\\s*(moderate|severe))|(moderately\\s*severe\\s*to\\s*severe)|(mild\\s*\\-*to\\s*\\-*moderate)|(mild\\s*\\-*to\\s*\\-*trace)|(moderate\\s*\\-*to\\s*\\-*((severe)|(marked)))|(mild-moderate)|(moderate-severe)|(mild)|(trace)|(moderate)|(severe)|(trace)|(trivial)|(no\\s*significant)|(significant)|(no\\s+evidence\\s*of*)|(no\\s))((?=(\\s*\\Wti\\W))|(?=(\\s*\\Wtr\\W))|(?=(\\s*tricuspid\\s*((insufficiency)|(stenosis\\sor\\sregurgitation)|(regurgitation))))|((?=(\\s*((transvalvular)|(peri\\s*valvular)|(central)|(eccentric)|((\\w+\\s)*jet\\sof)|(perivalvular\\sleak\\sor)|(transvalvular\\sor\\sperivalvular)|(\\s(\\/\\s)*\\w+\\s)|(\\s\\w+\\s\\w+\\s))\\s*tricuspid\\s*((insufficiency)|(stenosis\\sor\\sregurgitation)|(regurgitation))))))");
	        
	        Pattern p88 = Pattern.compile("((mildly\\s*dialated\\s*(moderate|severe))|(moderately\\s*severe\\s*to\\s*severe)|(mild\\s*\\-*to\\s*\\-*moderate)|(moderate\\s*\\-*to\\s*\\-*severe)|(mild-moderate)|(moderate-severe)|(mild)|(moderate)|(severe)|(low\\s*\\-*gradient)|(minimal)|(no\\s*significant)|(significant)|(no\\s+evidence\\s*of*(\\sbioprosthetic)*)|(no\\s*))[\\s\\w]{1,30}((tricuspid.{1,15}stenosis)|(tricuspid\\svalve\\sstenosis))");
	        Pattern p89 = Pattern.compile("((mildly\\s*dialated\\s*(moderate|severe))|(moderately\\s*severe\\s*to\\s*severe)|(mild\\s*\\-*to\\s*\\-*moderate)|(moderate\\s*\\-*to\\s*\\-*severe)|(mild-moderate)|(moderate-severe)|(mild)|(moderate)|(severe)|(low\\s*\\-*gradient)|(minimal)|(no\\s*significant)|(significant)|(no\\s+evidence\\s)|(no\\s))");
	        
	        Pattern p90 = Pattern.compile(".{30}(pulmonary\\s*(stenosis)).{10}");   
	        Pattern p91 = Pattern.compile("((moderated)|(trace)|(\\Wno\\W(significant)*)|(trivial)|(mild)|(trace\\-*to*mild))");
			
		// +++++++++++++++++++++++++++++++++++++++++++(LOOP OF CONCEPT EXTRACTION)++++++++++++++++++++++++++++++++++++++++++//
		for (int i = 1; i < recordlist.size(); i++) {
			check = arrRecords[i][2];
			check1 = check.replaceAll("\\.{2,}", "");
//			check1 = check1.replaceAll("\\n", " ");              // if the notes include new lines uncomment this line
			check1 = check1.replaceAll("\\s{3,}", " ");
			
			
			// 1 //////////////////////////First Concept Start// Here//////////////////////////////////
            // ////////////// Find concept (AVA) /////////////////////////
			if (check1.matches("(.*)((ava)|(av\\s*area)|(aortic\\s*valve\\s*area))(.*)")) {
               	Matcher mx = Px.matcher(check1);
                check2 = mx.replaceAll("IndexRemoved");
                check2 = conceptBlock(p,check1,check2,i,IndexCol,p1,true);
            }
            startIndexCol = IndexCol + (6 * 1);
            check2 = " ";
	        // 2 //////////////////////////Next Concept Start// Here//////////////////////////////////
            // ////////////// Find concept (MVA) /////////////////////////
            if (check1.matches("(.*)((mva)|(mv\\s*area)|(mitral\\s*valve\\s*area))(.*)")) {
            	check2 = conceptBlock(p4,check1,check2,i,startIndexCol,p5,true);
              }
            startIndexCol = IndexCol + (6 * 2);
            check2 = " ";
			// 3 //////////////////////////Next Concept Start// Here//////////////////////////////////
            // ////////////// Find concept (AORTIC Leaflet) //////////////////////
            if (check1.matches("(.*)(aortic)(.*)")) {
            	check2 = conceptBlock(p8,check1,check2,i,startIndexCol,p9,false);
            }
            startIndexCol = IndexCol + (6 * 3);
            check2 = " ";
			// 4 //////////////////////////Next Concept Start// Here//////////////////////////////////
            // ////////////// Find concept (MITRAL Leaflet) //////////////////////
            if (check1.matches("(.*)(mitral)(.*)")) {
            	check2 = conceptBlock(p8a,check1,check2,i,startIndexCol,p9a,false);
           }
            startIndexCol = IndexCol + (6 * 4);
            check2 = " ";
			// 5 //////////////////////////Next Concept Start// Here//////////////////////////////////
            // ////////////// Find concept (AV Peak Gradient) /////////////////
            if (check1.matches("(.*)((peak)|(pg)|(max))(.*)")) {
                check2 = conceptBlock(p10a,check1,check2,i,startIndexCol,p11a,true);
            }
            startIndexCol = IndexCol + (6 * 5);
            check2 = " ";
			// 6 //////////////////////////Next Concept Start// Here//////////////////////////////////
            // ////////////// Find concept (MV Peak Gradient) /////////////////
            if (check1.matches("(.*)((peak)|(pg)|(max))(.*)")) {
                check2 = conceptBlock(p10b,check1,check2,i,startIndexCol,p11b,true);
            }
            startIndexCol = IndexCol + (6 * 6);
            check2 = " ";
			// 7 //////////////////////////Next Concept Start// Here//////////////////////////////////
            // ////////////// Find concept (MR Peak Gradient) /////////////////
            if (check1.matches("(.*)((peak)|(pg)|(max))(.*)")) {
                check2 = conceptBlock(p10c,check1,check2,i,startIndexCol,p11c,true);
                
            }
            startIndexCol = IndexCol + (6 * 7);
            check2 = " ";
			// 8 //////////////////////////Next Concept Start// Here//////////////////////////////////
            // ////////////// Find concept (TR Peak Gradient) /////////////////
            if (check1.matches("(.*)((peak)|(pg)|(max))(.*)")) {
                check2 = conceptBlock(p10d,check1,check2,i,startIndexCol,p11d,true); 
            }
            startIndexCol = IndexCol + (6 * 8);
            check2 = " ";
			// 9 //////////////////////////Next Concept Start// Here//////////////////////////////////
            // ////////////// Find concept (TV Peak Gradient) /////////////////
            if (check1.matches("(.*)((peak)|(pg)|(max))(.*)")) {
                check2 = conceptBlock(p10e,check1,check2,i,startIndexCol,p11e,true);
            }
            startIndexCol = IndexCol + (6 * 9);
            check2 = " ";
			// 10 //////////////////////////Next Concept Start// Here//////////////////////////////////
            // ////////////// Find concept (PV Peak Gradient) /////////////////
            if (check1.matches("(.*)((peak)|(pg)|(max))(.*)")) {
                check2 = conceptBlock(p10f,check1,check2,i,startIndexCol,p11f,true);
            }
            startIndexCol = IndexCol + (6 * 10);
            check2 = " ";
			// 11 //////////////////////////Next Concept Start// Here//////////////////////////////////
            // ////////////// Find concept (LVOT Peak Gradient) /////////////////
            if (check1.matches("(.*)((peak)|(pg)|(max))(.*)")) {
                check2 = conceptBlock(p10g,check1,check2,i,startIndexCol,p11g,true);
            }
            startIndexCol = IndexCol + (6 * 11);
            check2 = " ";
			// 12 //////////////////////////Next Concept Start// Here//////////////////////////////////
            // ////////////// Find concept (RVOT Peak Gradient) /////////////////
            if (check1.matches("(.*)((peak)|(pg)|(max))(.*)")) {
                check2 = conceptBlock(p10h,check1,check2,i,startIndexCol,p11h,true);
            }
            startIndexCol = IndexCol + (6 * 12);
            check2 = " ";
			// 13 //////////////////////////Next Concept Start// Here//////////////////////////////////
            // ////////////// Find concept (AV Mean Gradient) /////////////////
            if (check1.matches("(.*)((mean)|(pg))(.*)")) {
                check2 = conceptBlock(p10aa,check1,check2,i,startIndexCol,p11aa,true);
            }
            startIndexCol = IndexCol + (6 * 13);
            check2 = " ";
			// 14 //////////////////////////Next Concept Start// Here//////////////////////////////////
            // ////////////// Find concept (MV Mean Gradient) /////////////////
            if (check1.matches("(.*)((mean)|(pg))(.*)")) {
                check2 = conceptBlock(p10ab,check1,check2,i,startIndexCol,p11ab,true);
            }
            startIndexCol = IndexCol + (6 * 14);
            check2 = " ";
		    // 15 //////////////////////////Next Concept Start// Here//////////////////////////////////
            // ////////////// Find concept (PV Mean Gradient) /////////////////
            if (check1.matches("(.*)((mean)|(pg))(.*)")) {
                check2 = conceptBlock(p10ac,check1,check2,i,startIndexCol,p11ac,true);
            }
            startIndexCol = IndexCol + (6 * 15);
            check2 = " ";
		    // 16 //////////////////////////Next Concept Start// Here//////////////////////////////////
            // ////////////// Find concept (Tricupsid Mean Gradient) /////////////////
            if (check1.matches("(.*)((mean)|(pg))(.*)")) {
                check2 = conceptBlock(p10ad,check1,check2,i,startIndexCol,p11ad,true);
                
            }
            startIndexCol = IndexCol + (6 * 16);
            check2 = " ";
		    // 17 //////////////////////////Next Concept Start// Here//////////////////////////////////
            // ////////////// Find concept (TV Mean Gradient) /////////////////
            if (check1.matches("(.*)((mean)|(pg))(.*)")) {
                check2 = conceptBlock(p10ae,check1,check2,i,startIndexCol,p11ae,true);
            }
            startIndexCol = IndexCol + (6 * 17);
            check2 = " ";
		    // 18 //////////////////////////Next Concept Start// Here//////////////////////////////////
            // ////////////// Find concept (Bioprosthesis Mean Gradient) /////////////////
            if (check1.matches("(.*)((mean)|(pg))(.*)")) {
                check2 = conceptBlock(p10af,check1,check2,i,startIndexCol,p11af,true);
            }
            startIndexCol = IndexCol + (6 * 18);
            check2 = " ";
			// 19 ///////////////// Next Concept Start Here ///////////////
            // ///////////////////////////////////Find concept// (RVOT Peak Velocity)/////////////
            if (check1.matches("(.*)((peak)|(max))(.*)")) {
                check2 = conceptBlock(p12a,check1,check2,i,startIndexCol,p13a,true);
            }
            startIndexCol = IndexCol + (6 * 19);
            check2 = " ";
			// 20 ///////////////// Next Concept Start Here ///////////////
            // ///////////////////////////////////Find concept// (LVOT Peak Velocity)/////////////
            if (check1.matches("(.*)((peak)|(max))(.*)")) {
                check2 = conceptBlock(p12b,check1,check2,i,startIndexCol,p13b,true);
            }
            startIndexCol = IndexCol + (6 * 20);
            check2 = " ";
			// 21 ///////////////// Next Concept Start Here ///////////////
            // ///////////////////////////////////Find concept// (TV Peak Velocity)/////////////
            if (check1.matches("(.*)((peak)|(max))(.*)")) {
                check2 = conceptBlock(p12c,check1,check2,i,startIndexCol,p13c,true);
            }
            startIndexCol = IndexCol + (6 * 21);
            check2 = " ";
			// 22 ///////////////// Next Concept Start Here ///////////////
            // ///////////////////////////////////Find concept// (MV Peak Velocity)/////////////
            if (check1.matches("(.*)((peak)|(max))(.*)")) {
                check2 = conceptBlock(p12d,check1,check2,i,startIndexCol,p13d,true);
            }
            startIndexCol = IndexCol + (6 * 22);
            check2 = " ";
			// 23 ///////////////// Next Concept Start Here ///////////////
            // ///////////////////////////////////Find concept// (PV Peak Velocity)/////////////
            if (check1.matches("(.*)((peak)|(max))(.*)")) {
                check2 = conceptBlock(p12e,check1,check2,i,startIndexCol,p13e,true);
            }
            startIndexCol = IndexCol + (6 * 23);
            check2 = " ";
			// 24 ///////////////// Next Concept Start Here ///////////////
            // ///////////////////////////////////Find concept// (AV Peak Velocity)/////////////
            if (check1.matches("(.*)((peak)|(max))(.*)")) {
                check2 = conceptBlock(p12f,check1,check2,i,startIndexCol,p13f,true);
                
            }
            startIndexCol = IndexCol + (6 * 24);
            check2 = " ";
			// 25 ///////////////// Next Concept Start Here ///////////////
            // ///////////////////////////////////Find concept// (TR Peak Velocity)/////////////
            if (check1.matches("(.*)((peak)|(max))(.*)")) {
                check2 = conceptBlock(p12g,check1,check2,i,startIndexCol,p13g,true);
            }
            startIndexCol = IndexCol + (6 * 25);
            check2 = " ";
			// 26 ///////////////// Next Concept Start Here ///////////////
            // ///////////////////////////////////Find concept// (MR Peak Velocity)/////////////
            if (check1.matches("(.*)((peak)|(max))(.*)")) {
                check2 = conceptBlock(p12h,check1,check2,i,startIndexCol,p13h,true);
            }
            startIndexCol = IndexCol + (6 * 26);
            check2 = " ";
			// 27 ///////////////// Next Concept Start Here ///////////////
            // ///////////////////////////////////Find concept // (LVOT Mean Velocity)/////////////
            if (check1.matches("(.*)((peak)|(max))(.*)")) {
                check2 = conceptBlock(p12aa,check1,check2,i,startIndexCol,p13aa,true);
            }
            startIndexCol = IndexCol + (6 * 27);
            check2 = " ";
			// 28 ///////////////// Next Concept Start Here ///////////////
            // ///////////////////////////////////Find concept // (PV Mean Velocity)/////////////
            if (check1.contains("mean velocity")) {
                check2 = conceptBlock(p12aa,check1,check2,i,startIndexCol,p13aa,true);
            }
            startIndexCol = IndexCol + (6 * 28);
            check2 = " ";
			// 29 ///////////////// Next Concept Start Here ///////////////
            // ///////////////////////////////////Find concept // (MR Mean Velocity)/////////////
            if (check1.matches("(.*)(mean.{1,25}velocity)(.*)")) {
                check2 = conceptBlock(p12ac, check1, check2, i, startIndexCol, p13ac, true);
            }
            startIndexCol = IndexCol + (6 * 29);
            check2 = " ";
			// 30 ///////////////// Next Concept Start Here ///////////////
            // ///////////////////////////////////Find concept // (AV Mean Velocity)/////////////
            if (check1.matches("(.*)(mean.{1,25}velocity)(.*)")) {
                check2 = conceptBlock(p12ad, check1, check2, i, startIndexCol, p13ad, true);
            }
            startIndexCol = IndexCol + (6 * 30);
            check2 = " ";
			// 31 ///////////////// Next Concept Start Here ///////////////
            // ///////////////////////////////////Find concept // (MV Mean Velocity)/////////////
            if (check1.matches("(.*)(mean.{1,25}velocity)(.*)")) {
                check2 = conceptBlock(p12ae, check1, check2, i, startIndexCol, p13ae, true);
            }
            startIndexCol = IndexCol + (6 * 31);
            check2 = " ";
			// 32 ///////////////// Next Concept Start Here ///////////////
            // ///////////////////////////////////Find concept // (TV Mean Velocity)/////////////
            if (check1.matches("(.*)(mean.{1,25}velocity)(.*)")) {
                check2 = conceptBlock(p12af, check1, check2, i, startIndexCol, p13af, true);
            }
            startIndexCol = IndexCol + (6 * 32);
            check2 = " ";
			// 33 ///////////////// Next Concept Start Here ///////////////
            // //////////////// Find concept (Aortic Stenosis Severity)// //////////////////
            if (check1.matches("(.*)((stenosis))(.*)")) {
                check2 = conceptBlock(p14, check1, check2, i, startIndexCol, p15, false);
            }
            startIndexCol = IndexCol + (6 * 33);
            check2 = " ";
			// 34 ///////////////// Next Concept Start Here ///////////////
            // //////////////// Find concept (Mitral Stenosis Severity)// //////////////////
            if (check1.matches("(.*)((stenosis))(.*)")) {
                check2 = conceptBlock(p14a, check1, check2, i, startIndexCol, p15a, false);
            }
            startIndexCol = IndexCol + (6 * 34);
            check2 = " ";
			// 35 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (Dimensionless Index)// //////////////////
            if (check1.matches("(.*)((index))(.*)")) {
                check2 = conceptBlock(p16, check1, check2, i, startIndexCol, p17, true);                
            }
            startIndexCol = IndexCol + (6 * 35);
            check2 = " ";
			// 36 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (MVA(P1/2T)) //////////////////
            if (check1.matches("(.*)(\\(p1\\/2t\\))(.*)")) {
                check2 = conceptBlock(p18, check1, check2, i, startIndexCol, p19, true);
            }
            startIndexCol = IndexCol + (6 * 36);
            check2 = " ";
			// 37 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (Pulmonary Artery pressure)// //////////////////
            if (check1.matches("(.*)(pressure)(.*)")) {
                check2 = conceptBlock(p20, check1, check2, i, startIndexCol, p21, true);
            }
            startIndexCol = IndexCol + (6 * 37);
            check2 = " ";
			// 38 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (Right Artery Pressure) //
            if (check1.matches("(.*)(pressure)(.*)")) {
                check2 = conceptBlock(p22, check1, check2, i, startIndexCol, p23, true);
            }
            startIndexCol = IndexCol + (6 * 38);
            check2 = " ";
			//+++++++++++++++++++++++++++++++++++++++++++(REGURGITATION GRADING)++++++++++++++++++++++++++++++++++++++//
            // 39 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (aortic regurgitation) //
            if (check1.matches("(.*)((aortic)|(\\Wai\\W)|(\\War\\W))(.*)")) {
                check2 = conceptBlock(p24, check1, check2, i, startIndexCol, p25, false);
            }
            startIndexCol = IndexCol + (6 * 39);
            check2 = " ";
			// 40 ///// Next Concept Start Here ///////////////
            // ////////////////Find concept (mitral regurgitation) //
            if (check1.matches("(.*)((mitral)|(\\Wmi\\W)|(\\Wmr\\W))(.*)")) {
                check2 = conceptBlock(p24a, check1, check2, i, startIndexCol, p25a, false);
            }
            startIndexCol = IndexCol + (6 * 40);
            check2 = " ";
			// 41 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (vena contracta) //
            if (check1.matches("(.*)(vena\\s*contracta)(.*)")) {
            	check2 = conceptBlock(p26, check1, check2, i, startIndexCol, p27, true);
			}
			startIndexCol = IndexCol + (6 * 41);
			check2 = " ";
			// 42 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (regurgitant fraction) //
            if (check1.matches("(.*)(fraction)(.*)")) {
                check2 = conceptBlock(p28, check1, check2, i, startIndexCol, p29, true);
            }
            startIndexCol = IndexCol + (6 * 42);
            check2 = " ";
			// 43 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (regurgitant orifice area) //
            if (check1.matches("(.*)(orifice)(.*)")) {
            	check2 = conceptBlock(p30, check1, check2, i, startIndexCol, p31, true);
            }
                startIndexCol = IndexCol + (6 * 43);
                check2 = " ";
			// 44 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (Pressure Half time) //
            if (check1.matches("(.*)(pressure)(.*)")) {
                check2 = conceptBlock(p32, check1, check2, i, startIndexCol, p33, true);
            }
            startIndexCol = IndexCol + (6 * 44);
            check2 = " ";
			// 45  ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (Aortic Flow Reversal) //
            if (check1.matches("(.*)(reversal)(.*)")) {
                check2 = conceptBlock(p34, check1, check2, i, startIndexCol, p35, false);
            }
            startIndexCol = IndexCol + (6 * 45);
            check2 = " ";
			//+++++++++++++++++++++++++++++++++++++++++++(LEFT VENTRICLE)++++++++++++++++++++++++++++++++++++++//
            // 46 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (LVEF) //
            if (check1.matches("(.*)((lvef)|(ejection\\s*fraction)|(\\Wef))(.*)")) {
                check2 = conceptBlock(p36, check1, check2, i, startIndexCol, p37, true);
            }
            startIndexCol = IndexCol + (6 * 46);
            check2 = " ";
			// 47 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (DIASTOLIC FUNCTION) //
            if (check1.matches("(.*)(diastolic\\s*(dysfunction|function))(.*)")) {
                check2 = conceptBlock(p38, check1, check2, i, startIndexCol, p39, false);
            }
            startIndexCol = IndexCol + (6 * 47);
            check2 = " ";
			// 48 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (MV E/A RATIO) //
            if (check1.matches("(.*)((e\\s*(\\/|\\:)\\s*a\\W)|(e\\s*to\\s*a\\s*(ratio)*))(.*)")) {
                check2 = conceptBlock(p40, check1, check2, i, startIndexCol, p41, true);
            }
            startIndexCol = IndexCol + (6 * 48);
            check2 = " ";
			// 49 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (LV FILLING PRESSURE) //
            if (check1.matches("(.*)filling\\s*pressure(.*)")) {
                check2 = conceptBlock(p42, check1, check2, i, startIndexCol, p43, false);
            }
            startIndexCol = IndexCol + (6 * 49);
            check2 = " ";
			// 50 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (E/e' Ratio) //
            if (check1.matches("(.*)e\\s*(\\/|\\:)\\s*e\\s*\\'(.*)")) {
                check2 = conceptBlock(p44, check1, check2, i, startIndexCol, p45, true);
            }
            startIndexCol = IndexCol + (6 * 50);
            check2 = " ";
			// 51 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (Chamber Size LVEDd) /////////
            if (check1.matches("(.*)lvedd(.*)")) {
            	check2 = conceptBlock(p46, check1, check2, i, startIndexCol, p47, true);
            }
            startIndexCol = IndexCol + (6 * 51);
            check2 = " ";
			// 52 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (Chamber Size LVESD) /////////
            if (check1.matches("(.*)((lvesd)|(lvsd))(.*)")) {
                check2 = conceptBlock(p48, check1, check2, i, startIndexCol, p49, true);
            }
            startIndexCol = IndexCol + (6 * 52);
            check2 = " ";
			// 53 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (Chamber Thickness: Type:concentric)//////
            if (check1.matches(".*concentric.*")) {
                check2 = conceptBlock(p50, check1, check2, i, startIndexCol, p51, false);
            }
            startIndexCol = IndexCol + (6 * 53);
            check2 = " ";
			// 54 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (Chamber Thickness: Type:basal septal) /////
            if (check1.matches("(.*)basal(.*)")) {
                check2 = conceptBlock(p50a, check1, check2, i, startIndexCol, p51a, false);
            }
            startIndexCol = IndexCol + (6 * 54);
            check2 = " ";
			// 55 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (Degree Of Hypertrophy) //
            if (check1.matches(".*concentric.*")) {
                check2 = conceptBlock(p52, check1, check2, i, startIndexCol, p53, false);
            }
            startIndexCol = IndexCol + (6 * 55);
            check2 = " ";
			// 56  ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (Degree of Septal thickness) //
            if (check1.matches("(.*)basal(.*)")) {
                check2 = conceptBlock(p52a, check1, check2, i, startIndexCol, p53a, false);
            }
            startIndexCol = IndexCol + (6 * 56);
            check2 = " ";
			// 57  ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (Degree of Septal thickness) //
            if (check1.matches("(.*)thickness(.*)")) {
            	check2 = conceptBlock(p54, check1, check2, i, startIndexCol, p55, true);
            }
            startIndexCol = IndexCol + (6 * 57);
            check2 = " ";
			//+++++++++++++++++++++++++++++++++++++++++++(LEFT ATRIUM)++++++++++++++++++++++++++++++++++++++//
            // 58 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (Atrial Englargement) //
            if (check1.matches("(.*)enlarge(.*)")) {
                check2 = conceptBlock(p56, check1, check2, i, startIndexCol, p57, false);
            }
            startIndexCol = IndexCol + (6 * 58);
            check2 = " ";
			// 59 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (LA Dimension) //
            if (check1.matches("(.*)(dimension)(.*)")) {
                check2 = conceptBlock(p58, check1, check2, i, startIndexCol, p59, true);
            }
            startIndexCol = IndexCol + (6 * 59);
            check2 = " ";
			// 60 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (Volumen Index) //
            if (check1.matches("(.*)index(.*)")) {
                check2 = conceptBlock(p60, check1, check2, i, startIndexCol, p61, true);
            }
            startIndexCol = IndexCol + (6 * 60);
            check2 = " ";
            // 61 ///////////////// Next Concept Start Here ///////////////
            // ////////////////Find concept (Body Surface Area) //
            if (check1.matches("(.*)bsa(.*)")) {
                check2 = conceptBlock(p62, check1, check2, i, startIndexCol, p63, true);
            }
            startIndexCol = IndexCol + (6 * 61);
			check2 = " ";
			// 62 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (RVOT velocity time intregal) //
			if (check1.matches("(.*)rvot(.*)")) {
				check2 = conceptBlock(p62a, check1, check2, i, startIndexCol, p63a, true);
			}
			startIndexCol = IndexCol + (6 * 62);
			check2 = " ";
			// 63 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (LVOT DIA) //
			if (check1.matches("(.*)lvot(.*)")) {
				check2 = conceptBlock(p62b, check1, check2, i, startIndexCol, p63b, true);
			}
			startIndexCol = IndexCol + (6 * 63);
			check2 = " ";
			// 64 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (AORTIC ROOT DIA) //
			if (check1.matches("(.*)aortic(.*)")) {
				check2 = conceptBlock(p62c, check1, check2, i, startIndexCol, p63c, true);
			}
			startIndexCol = IndexCol + (6 * 64);
			check2 = " ";
			// 65 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (AV VTI) //
			if (check1.matches("(.*)((time)|(vti))(.*)")) {
				check2 = conceptBlock(p62d, check1, check2, i, startIndexCol, p63d, true);
			}
			startIndexCol = IndexCol + (6 * 65);
			check2 = " ";
			// 66 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (MV VTI) //
			if (check1.matches("(.*)((mv)|(time)|(vti)|(stroke))(.*)")) {
				check2 = conceptBlock(p62e, check1, check2, i, startIndexCol, p63e, true);
			}
			startIndexCol = IndexCol + (6 * 66);
			check2 = " ";
			// 67 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (LVOT VTI) //
			if (check1.matches("(.*)((time)|(vti)|(stroke))(.*)")) {
				check2 = conceptBlock(p62f, check1, check2, i, startIndexCol, p63f, true);
			}
			startIndexCol = IndexCol + (6 * 67);
			check2 = " ";
			// 68 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (RVOT DIMENSION) //
			if (check1.matches("(.*)(rvot)(.*)")) {
				check2 = conceptBlock(p62g, check1, check2, i, startIndexCol, p63g, true);
			}

			startIndexCol = IndexCol + (6 * 68);
			check2 = " ";
			// 69 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (RV BASAL DIMENSION) //
			if (check1.matches("(.*)(rv)(.*)")) {
				check2 = conceptBlock(p64, check1, check2, i, startIndexCol, p65, true);
			}			
			startIndexCol = IndexCol + (6 * 69);
			check2 = " ";
			// 70 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (TAPSE SIZE) //
			if (check1.matches("(.*)(tapse)(.*)")) {
				check2 = conceptBlock(p66, check1, check2, i, startIndexCol, p67, true);
			}
			startIndexCol = IndexCol + (6 * 70);
			check2 = " ";
			// 71 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (RVEF) //
			if (check1.matches("(.*)((rvef)|(ejection\\s*fraction)|(\\Wef))(.*)")) {
				check2 = conceptBlock(p68, check1, check2, i, startIndexCol, p69, true);
			}
			startIndexCol = IndexCol + (6 * 71);
			check2 = " ";
			// 72 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (LA Volume) //
			if (check1.matches("(.*)((time)|(vti)|(stroke))(.*)")) {
				check2 = conceptBlock(p70, check1, check2, i, startIndexCol, p71, true);
			}
			startIndexCol = IndexCol + (6 * 72);
			check2 = " ";
			// 73 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (MV HALF PRESSURE) //
			if (check1.matches("(.*)(half)(.*)")) {
				check2 = conceptBlock(p72, check1, check2, i, startIndexCol, p73, true);
			}
			startIndexCol = IndexCol + (6 * 73);
			check2 = " ";
			// 74 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (PERICARDIAL SIZE) //
			if (check1.matches("(.*)(size)(.*)")) {
				check2 = conceptBlock(p74, check1, check2, i, startIndexCol, p75, false);
			}
			startIndexCol = IndexCol + (6 * 74);
			check2 = " ";
			// 75 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (Inferior Vena Cava) //
			if (check1.matches("(.*)((\\Wivc)|(inferior))(.*)")) {
				check2 = conceptBlock(p76, check1, check2, i, startIndexCol, p77, true);
			}
			startIndexCol = IndexCol + (6 * 75);
			check2 = " ";
			// 76 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (RA PRESSURE) //
			if (check1.matches("(.*)((ra\\s)|(pressure))(.*)")) {
				check2 = conceptBlock(p78, check1, check2, i, startIndexCol, p79, false);
			}
			startIndexCol = IndexCol + (6 * 76);
			check2 = " ";
			// 77 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (RIGHT ATRIUM CONDITION) //
			if (check1.matches("(.*)((\\Wra)|(right))(.*)")) {
				check2 = conceptBlock(p80, check1, check2, i, startIndexCol, p81, false);
			}
			startIndexCol = IndexCol + (6 * 77);
			check2 = " ";
			// 78 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (RV HYPERTROPHY) //
			if (check1.matches("(.*)((\\Wrv)|(hypertrophy))(.*)")) {
				check2 = conceptBlock(p82, check1, check2, i, startIndexCol, p83, false);
			}
			startIndexCol = IndexCol + (6 * 78);
			check2 = " ";
			// 79 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (PULMONARY REGURGITATION) //
			if (check1.matches("(.*)((pulmonary)|(\\Wpi\\W)|(\\Wpr\\W))(.*)")) {
				check2 = conceptBlock(p84, check1, check2, i, startIndexCol, p85, false);
			}
			startIndexCol = IndexCol + (6 * 79);
			check2 = " ";
			// 80 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (TRICUSPID REGURGITATION) //
			if (check1.matches("(.*)((tricuspid)|(\\Wti\\W)|(\\Wtr\\W))(.*)")) {
				check2 = conceptBlock(p86, check1, check2, i, startIndexCol, p87, false);
			}
			startIndexCol = IndexCol + (6 * 80);
			check2 = " ";
			// 81 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (TRICUSPID STENOSIS) //
			if (check1.matches("(.*)(stenosis)(.*)")) {
				check2 = conceptBlock(p88, check1, check2, i, startIndexCol, p89, false);
			}
			startIndexCol = IndexCol + (6 * 81);
			check2 = " ";
			// 82 ///////////////// Next Concept Start Here ///////////////
			// ////////////////Find concept (PULMONARY STENOSIS) //
			if (check1.matches("(.*)(stenosis)(.*)")) {
				check2 = conceptBlock(p90, check1, check2, i, startIndexCol, p91, false);
			}
            startIndexCol = 4;
            check2 = " ";
		}
		// ++++++++++++++++++++++++++++++++++++++++++++(WRITING EXCEL SHEET)+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
		XSSFWorkbook myWorkBook = new XSSFWorkbook();
		XSSFSheet mySheet = myWorkBook.createSheet();
		XSSFRow myRow = null;
		XSSFCell myCell = null;
		
		for (int rowNum = 0; rowNum < numOfRows; rowNum++) {
			myRow = mySheet.createRow(rowNum);
			
			for (int cellNum = 0; cellNum < numOfOutputColumns; cellNum++) {
				myCell = myRow.createCell(cellNum);
				myCell.setCellValue(excelData[rowNum][cellNum]);
			}
		}
		try {
			FileOutputStream out = new FileOutputStream(WritefileName);
			myWorkBook.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ++++++++++++++++++++++++++++++++++++++++++++(METHOD DECLARATION)+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	private static boolean calculate(List<String> matchstring, Matcher match) {
        if ((match.group().contains("-") || match.group().contains("to"))) {
        	match.group().replaceAll("\\[", "\\s");
        	match.group().replaceAll("\\]", "\\s");
        	if (match.group().contains("mm..*|sq\\smm|mm2")) {
        	String[] items = match.group().split("to|-|mm..*|sq\\smm|mm2");
            Float f1 = new Float(items[0]);
            Float f2 = new Float(items[items.length-1]);
            String ca = Float.toString((f1 + f2) / 200) +" cm2";
            return matchstring.add(ca);
        	}
        	else if (match.group().contains("mm")) {
            	String[] items = match.group().split("to|-|mm");
                Float f1 = new Float(items[0]);
                Float f2 = new Float(items[items.length-1]);
                String ca = Float.toString((f1 + f2) / 20) +" cm";
                return matchstring.add(ca);
            	}
        	else if (match.group().contains("cm/s")) {
            	String[] items = match.group().split("to|-|cm/s");
                Float f1 = new Float(items[0]);
                Float f2 = new Float(items[items.length-1]);
                String ca = Float.toString((f1 + f2) / 200) +" m/s";
                return matchstring.add(ca);
            	}
        	else if (match.group().contains("sq\\sm|m2")){
            	String[] items = match.group().split("to|-|sq\\sm|m2");
                Float f1 = new Float(items[0]);
                Float f2 = new Float(items[items.length-1]);
                String ca = Float.toString((f1 + f2) / 2) + "m2";
                return matchstring.add(ca);
            	}
        	else if (match.group().contains("cm")){
            	String[] items = match.group().split("to|-|cm");
                Float f1 = new Float(items[0]);
                Float f2 = new Float(items[items.length-1]);
                String ca = Float.toString((f1 + f2) / 2) + "cm";
                return matchstring.add(ca);
            	}
        	else if (match.group().contains("m/s")){
            	String[] items = match.group().split("to|-|m/s");
                Float f1 = new Float(items[0]);
                Float f2 = new Float(items[items.length-1]);
                String ca = Float.toString((f1 + f2) / 2) + "m/s";
                return matchstring.add(ca);
            	}
        	else {
            	String[] items = match.group().split("to|-");
                Float f1 = new Float(items[0]);
                Float f2 = new Float(items[items.length-1]);
                String ca = Float.toString((f1 + f2) / 2);
                return matchstring.add(ca);
            	}
        } else {       	
        if (match.group().contains("mm..*|sq\\smm|mm2")) {
            String[] items = match.group().split("mm..*|sq\\smm|mm2");
            Float f = new Float(items[0]);
            String ca = Float.toString(f / 100) + " cm2";
        return matchstring.add(ca);
        }
        else if (match.group().contains("mm")) {
                String[] items = match.group().split("mm");
                Float f = new Float(items[0]);
                String ca = Float.toString(f / 10) + " cm";
            return matchstring.add(ca);
          }
        else if (match.group().contains("cm/s")) {
            String[] items = match.group().split("cm/s");
            Float f = new Float(items[0]);
            String ca = Float.toString(f / 100) + " m/s";
        return matchstring.add(ca);
        }else{
            return matchstring.add(match.group());
        	}
        }
    }

    static String[][] dataEntry(List<String> matchString, String[][] excelData,int i, int IndexCol, boolean flag){
        excelData[i][IndexCol + 1] = matchString.toString();
        excelData[i][IndexCol + 2] = Integer.toString(matchString.size());
        if(flag){    
        excelData[i][IndexCol + 3] = Collections.max(matchString);
        excelData[i][IndexCol + 4] = Collections.min(matchString);
        }
        excelData[i][IndexCol + 5] = matchString.get(matchString.size() - 1);
        return excelData;
    }
    
    static String conceptBlock(Pattern pt1, String check1Str, String check2Str, int i, int indexCol, Pattern pt2,boolean flag){
        Matcher m = pt1.matcher(check1Str);
        while(m.find()){
            check2Str = check2Str + "^^ " + m.group();
                  excelData[i][indexCol] = excelData[i][indexCol] + "\n" + "<OUTPUT>" + m.group();
             }
        Matcher m2 = pt2.matcher(check2Str);
        List<String> matchStr1 = new ArrayList<String>();
        while(m2.find()){
        	if(flag){
            calculate(matchStr1, m2);
        	}
        	else {
                matchStr1.add(m2.group());
            }
        }
        if (matchStr1 != null && !matchStr1.isEmpty()) {
            excelData = dataEntry(matchStr1, excelData, i, indexCol, flag);
        }       
        return check2Str;
    }
}

//+++++++++++++++++++++++++++++++++++++++++++++++(PROGRAM ENDS HERE)++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
