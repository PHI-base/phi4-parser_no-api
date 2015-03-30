package com.molcon.phibase.main;

import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.molcon.phibase.excelParse.PhibaseCitationDetails;
import com.molcon.phibase.excelParse.PhibaseDisease;
import com.molcon.phibase.excelParse.PhibaseDiseaseIntervention;
import com.molcon.phibase.excelParse.PhibaseDiseaseProcess;
import com.molcon.phibase.excelParse.PhibaseGene;
import com.molcon.phibase.excelParse.PhibaseHost;
import com.molcon.phibase.excelParse.PhibaseIdGeneMappingVo;
import com.molcon.phibase.excelParse.PhibaseInfo;
import com.molcon.phibase.excelParse.PhibaseMutantCharcteristics;
import com.molcon.phibase.excelParse.PhibasePathogen;
import com.molcon.phibase.excelParse.PhibaseReference;


public class PhibaseExcelParseDB {
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/PHIBASE?characterEncoding=UTF8";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root123";
	public Connection getConnection(){
		Connection con=null;
        try{
            Class.forName(DB_DRIVER);
            con=DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
        }catch (Exception e) {
        	e.printStackTrace();
        }

	    return con;
	}

	private void closeQuietly(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException ignored) {}
        }
    }

	public void writeFile(File phibaseResultFile,String phibaseResult,boolean appendFlag){
		FileWriter fw = null;
		try{

			if (!phibaseResultFile.exists()) {
				phibaseResultFile.createNewFile();
			}
			fw=new FileWriter(phibaseResultFile,appendFlag);
			fw.write(phibaseResult);

		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			closeQuietly(fw);
		}

	}
	
	
	public void insertExcelParseDataToDB(List<Map<String, Object>> parsingClassesBeanMapList,File phibaseResultFile)throws SQLException{

		int noRecordInserted=0;
		StringBuffer phibaseResultBuffer=new StringBuffer("\nPhibase Upload Report :\n");

		//iterate each set of parsing bean classes
		for(Map<String, Object> parsingClassesBeanMap:parsingClassesBeanMapList){

			PhibaseReference phibaseReference=(PhibaseReference)parsingClassesBeanMap.get("PhibaseReference");
			PhibaseGene phibaseGene=(PhibaseGene)parsingClassesBeanMap.get("PhibaseGene");
			PhibasePathogen phibasePathogen=(PhibasePathogen)parsingClassesBeanMap.get("PhibasePathogen");
			PhibaseHost phibaseHost=(PhibaseHost)parsingClassesBeanMap.get("PhibaseHost");
			//PhibaseMutantCharcteristics phibaseMutantCharcteristics=(PhibaseMutantCharcteristics)parsingClassesBeanMap.get("PhibaseMutantCharcteristics");
			PhibaseDisease phibaseDisease=(PhibaseDisease)parsingClassesBeanMap.get("PhibaseDisease");
			PhibaseDiseaseProcess phibaseDiseaseProcess=(PhibaseDiseaseProcess)parsingClassesBeanMap.get("PhibaseDiseaseProcess");
			PhibaseDiseaseIntervention phibaseDiseaseIntervention=(PhibaseDiseaseIntervention)parsingClassesBeanMap.get("PhibaseDiseaseIntervention") ;
			PhibaseCitationDetails phibaseCitationDetails=(PhibaseCitationDetails)parsingClassesBeanMap.get("PhibaseCitationDetails");
			PhibaseInfo phibaseInfo=(PhibaseInfo)parsingClassesBeanMap.get("PhibaseInfo");

			 Connection conn=getConnection();
			 PreparedStatement preparedStatement=null;
			 ResultSet rs=null;
			 int phibaseSerialId=0;
			 int geneDetailsId=0;
			 int diseaseDetailsId=0;

			try{
				   //Assume a valid connection object conn
				   conn.setAutoCommit(false);

				   //REFERENCE
				   String insertQuery="INSERT INTO PHIBASE_ACCESSION_DETAILS(PHIBASE_ACCESSION_ID) VALUES(?)";
				   preparedStatement=conn.prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);
				   System.out.println(phibaseReference.getPhibaseAccessionId());
				   preparedStatement.setString(1, phibaseReference.getPhibaseAccessionId());

				   preparedStatement.executeUpdate();
				   rs = preparedStatement.getGeneratedKeys();
		            if(rs != null && rs.next()){
		            	phibaseSerialId=rs.getInt(1);
		            }

				   //GENE
				   insertQuery="INSERT INTO GENE_DETAILS(PHIBASE_SL_ID,IDENTIFIER_TYPE_GN_PROTEIN_ID,GN_PROTEIN_ID,IDENTIFIER_TYPE_GN_LOCUS_ID," +
				   		"GN_LOCUS_ID,AA_GN_SEQUENCE,NT_GN_SEQUENCE,GN_STRAIN,GN_NAME,GN_LOCATION,GN_MODIFICATION,GN_MODIFIED_ID,GN_INTERACTING_PARTNER,"
				   		+ "GN_INTERACTING_PARTNER_ID,GN_FUNCTION_NAME,GN_GO_ANNO_ID,GN_DATABASE," +
				   		"GN_PATHWAY_SECRETION_SYSTEM,ESS_GN_LETHAL_KNOCKOUT) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				   preparedStatement=conn.prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);
				   preparedStatement.setInt(1,phibaseSerialId);
				   preparedStatement.setString(2, phibaseGene.getIdentifierTypeGeneProteinId());
				   preparedStatement.setString(3, phibaseGene.getGeneProteinId());
				   preparedStatement.setString(4, phibaseGene.getIdentifierTypeGeneLocusId());
				   preparedStatement.setString(5, phibaseGene.getGeneLocusId());
				   preparedStatement.setString(6, phibaseGene.getAASequence());
				   preparedStatement.setString(7, phibaseGene.getNTSequence());
				   preparedStatement.setString(8, phibaseGene.getGeneStrain());
				   preparedStatement.setString(9, phibaseGene.getGeneName());
				   preparedStatement.setString(10, phibaseGene.getGeneLocation());
				   preparedStatement.setString(11, phibaseGene.getGeneProtienModification());
				   preparedStatement.setString(12, phibaseGene.getGenProtienModificationId());
				   preparedStatement.setString(13, phibaseGene.getInteractingPartners());
				   preparedStatement.setString(14, phibaseGene.getInteractingPartnersId());
				   preparedStatement.setString(15, phibaseGene.getGeneFunctionName());
				   preparedStatement.setString(16, phibaseGene.getGeneGoAnnoId());
				   preparedStatement.setString(17, phibaseGene.getGeneDatabase());
				   preparedStatement.setString(18, phibaseGene.getGenPathwaySecretionSystem());
				   preparedStatement.setString(19, phibaseGene.getGeneEssentialLethalKnockout());

				   preparedStatement.executeUpdate();
				   rs = preparedStatement.getGeneratedKeys();
		            if(rs != null && rs.next()){
		            	geneDetailsId=rs.getInt(1);
		            }

				  /* insertQuery=" SELECT MAX(GENE_DETAILS_ID) GENE_DETAILS_ID FROM GENE_DETAILS";
				   preparedStatement=conn.prepareStatement(insertQuery);
				   rs=preparedStatement.executeQuery();
				   while(rs.next()){
					   geneDetailsId=rs.getInt("GENE_DETAILS_ID");
				   }*/

				   //PATHOGEN
				   insertQuery="INSERT INTO PATHOGEN_DETAILS(GENE_DETAILS_ID,PG_SPECIES_TAXONOMY_ID,PG_STRAIN_TAXONOMY_ID,PATHOGEN_SPECIES," +
				   		"PG_EXPERIMENTAL_STRAIN) values(?,?,?,?,?)";
				   preparedStatement=conn.prepareStatement(insertQuery);
				   preparedStatement.setInt(1, geneDetailsId);
				   preparedStatement.setString(2,phibasePathogen.getPathogenSpeciesTaxonomyId());
				   preparedStatement.setString(3, phibasePathogen.getPathogenStrainTaxonomyId());
				   preparedStatement.setString(4, phibasePathogen.getPathogenSpecies());
				   preparedStatement.setString(5, phibasePathogen.getPathogenExperimentalStrain());
				   preparedStatement.executeUpdate();

				   //HOST
				   insertQuery="INSERT INTO HOST_DETAILS(PHIBASE_SL_ID,HST_MONOCOT_DICOT_PLANT,HST_NCBI_TAXONOMY_ID,HST_EXPERIMENTAL_SPECIES," +
				   		"HST_TISSUE_TYPE,HOST_STRAIN_GENOTYPE,HST_GENO_TYPE,HST_GENOTYPE_ID) VALUES(?,?,?,?,?,?,?,?)";
				   preparedStatement=conn.prepareStatement(insertQuery);
				   preparedStatement.setInt(1, phibaseSerialId);
				   preparedStatement.setString(2, phibaseHost.getHostMonocotDicotPlant());
				   preparedStatement.setString(3,phibaseHost.getHostNCBITaxonomyId());
				   preparedStatement.setString(4, phibaseHost.getHostExperimentalSpecies());
				   preparedStatement.setString(5, phibaseHost.getHostTissueType());
				   preparedStatement.setString(6, phibaseHost.getHostStrainGenoType());
				   preparedStatement.setString(7, phibaseHost.getHostGenoType());
				   preparedStatement.setString(8, phibaseHost.getHostGenoTypeId());

				   preparedStatement.executeUpdate();
				  
				   //DISEASE
				   insertQuery="INSERT INTO DISEASE_DETAILS(PHIBASE_SL_ID,DIS_MULTIPLE_MUTATION,DISEASE_NAME,DIS_PHENOTYPE_MUTANT," +
				   		"DIS_DELV_MACROSCOPICALLY,DIS_INDUCER,DIS_INDUCER_ID_CAS,DIS_HOST_TARGET,DIS_HOST_TARGET_ID,DIS_INTERACTION_PHENOTYPE,"
				   		+ "DIS_HOST_RESPONSE,DIS_EXPERIMENTAL_EVIDENCE,DIS_EXP_EVIDENCE_TRANSIENT,DIS_COMMENTS) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				   preparedStatement=conn.prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);
				   preparedStatement.setInt(1, phibaseSerialId);
				   preparedStatement.setString(2, phibaseDisease.getDiseaseMultipleMutation());
				   preparedStatement.setString(3, phibaseDisease.getDiseaseName());
				   preparedStatement.setString(4, phibaseDisease.getDiseasePhenotypeMutant());
				   preparedStatement.setString(5, phibaseDisease.getDiseaseDevelopementMacroScopicallyVisible());
				   preparedStatement.setString(6, phibaseDisease.getGeneInducer());
				   preparedStatement.setString(7, phibaseDisease.getGeneInducerId());
				   preparedStatement.setString(8, phibaseDisease.getHostTarget());
				   preparedStatement.setString(9, phibaseDisease.getHostTargetId());
				   preparedStatement.setString(10, phibaseDisease.getInteractionPhenotype());
				   preparedStatement.setString(11, phibaseDisease.getDiseaseHostResponse());
				   preparedStatement.setString(12, phibaseDisease.getDiseaseExperimentalEvidence());
				   preparedStatement.setString(13, phibaseDisease.getDiseaseExperimentalEvidenceTransient());
				   preparedStatement.setString(14, phibaseDisease.getDiseaseComments());
				   preparedStatement.executeUpdate();

				   rs = preparedStatement.getGeneratedKeys();
		            if(rs != null && rs.next()){
		            	diseaseDetailsId=rs.getInt(1);
		            }
				   /*insertQuery=" SELECT MAX(DISEASE_DETAILS_ID) DISEASE_DETAILS_ID FROM DISEASE_DETAILS";
				   preparedStatement=conn.prepareStatement(insertQuery);
				   rs=preparedStatement.executeQuery();
				   while(rs.next()){
					   diseaseDetailsId=rs.getInt("DISEASE_DETAILS_ID");
				   }*/


				   //DISEASE PROCESS
				   insertQuery="INSERT INTO DISEASE_PROCESS(DISEASE_DETAILS_ID,DIS_MATING_DEFECT_PRI_PENETRATION,DIS_PRE_PENETRATION_DEFECT," +
				   		"DIS_PENETRATION_DEFECT,DIS_POST_PENETRATION_DEFECT,DIS_VEGETATIVE_SPORES,DIS_SEXUAL_SPORES,DIS_INVITRO_GROWTH,DIS_SPORE_GERMINATION)" +
				   		"VALUES(?,?,?,?,?,?,?,?,?)";
				   preparedStatement=conn.prepareStatement(insertQuery);
				   preparedStatement.setInt(1,diseaseDetailsId);
				   preparedStatement.setString(2, phibaseDiseaseProcess.getDiseaseMatingDefectPriPenetration());
				   preparedStatement.setString(3, phibaseDiseaseProcess.getDiseasePrePenetrationDefect());
				   preparedStatement.setString(4, phibaseDiseaseProcess.getDiseasePenetrationDefect());
				   preparedStatement.setString(5, phibaseDiseaseProcess.getDiseasePostPenetrationDefect());
				   preparedStatement.setString(6, phibaseDiseaseProcess.getMutantVegetativeSpore());
				   preparedStatement.setString(7, phibaseDiseaseProcess.getMutantSexualSpore());
				   preparedStatement.setString(8, phibaseDiseaseProcess.getMutantInVitroGrowth());
				   preparedStatement.setString(9, phibaseDiseaseProcess.getMutantSpermGermination());
				   

				   preparedStatement.executeUpdate();

				   //DISEASE INTERVENTION
				   insertQuery="INSERT INTO DISEASE_INTERVENTION(DISEASE_DETAILS_ID,DIS_ANTI_INFECTIVE_AGENT_ID_CAS,DIS_ANTI_INFECTIVE_AGENT,"
				   		+ "DIS_ANTI_INFECTIVE_COMPOUND,DIS_ANTI_INFECTIVE_TARGET_SITE,DIS_ANTI_INFECTIVE_GROUP_NAME,DIS_ANTI_INFECTIVE_CHEMICAL_GP,"
				   		+ "DIS_ANTI_INFECTIVE_MODE_PL,DIS_ANTI_INFECTIVE_FRAC_CODE,DIS_ANTI_INFECTIVE_COMMENT) VALUES(?,?,?,?,?,?,?,?,?,?)";
				   preparedStatement=conn.prepareStatement(insertQuery);
				   preparedStatement.setInt(1,diseaseDetailsId);
				   preparedStatement.setString(2, phibaseDiseaseIntervention.getDiseaseCas());
				   preparedStatement.setString(3, phibaseDiseaseIntervention.getAntInfectiveAgent());
				   preparedStatement.setString(4, phibaseDiseaseIntervention.getAntiInfectiveCompound());
				   preparedStatement.setString(5, phibaseDiseaseIntervention.getAntiInfectiveTargetSite());
				   preparedStatement.setString(6, phibaseDiseaseIntervention.getAntiInfectiveGroupname());
				   preparedStatement.setString(7, phibaseDiseaseIntervention.getAntiInfectiveChemicalGroup());
				   preparedStatement.setString(8, phibaseDiseaseIntervention.getAntiInfectiveModeInPlanta());
				   preparedStatement.setString(9, phibaseDiseaseIntervention.getFracCode());
				   preparedStatement.setString(10, phibaseDiseaseIntervention.getAntiInfectiveComment());

				   preparedStatement.executeUpdate();


				   //CITAION_DETAILS
				   insertQuery="INSERT INTO REFERENCE(PHIBASE_SL_ID,LITERATURE_ID,LIT_SOURCE,LIT_YEAR,DOI,FULL_CITATION,AUTHOR_MAIL,REFERENCE) VALUES(?,?,?,?,?,?,?,?)";
				   preparedStatement=conn.prepareStatement(insertQuery);
				   preparedStatement.setInt(1, phibaseSerialId);
				   preparedStatement.setString(2, phibaseCitationDetails.getLiteratureId());
				   preparedStatement.setString(3, phibaseCitationDetails.getLiteratureSource());
				   preparedStatement.setString(4, phibaseCitationDetails.getLiteratureYear());
				   preparedStatement.setString(5, phibaseCitationDetails.getDoi());
				   preparedStatement.setString(6, phibaseCitationDetails.getFullCitation());
				   preparedStatement.setString(7, phibaseCitationDetails.getAuthorEmail());
				   preparedStatement.setString(8, phibaseCitationDetails.getReference());

				   preparedStatement.executeUpdate();

				   //PHIBASE_INFO
				   insertQuery="INSERT INTO INFO_NOT_DISPLAY(PHIBASE_SL_ID,SPECIES_EXPERT,ENTERED_BY,MANUAL_M_OR_TEXT_MINING_T,CURATOR_ORGANIZATION,"
				   		+ "CURATION_DATE,CURATION_COMMENTS,TO_DO,RECORD_ID,CURATION_DETAILS,PDF_FILE_NAME,BATCH_NO,LAB,FG_MYCOTOXIN) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				   preparedStatement=conn.prepareStatement(insertQuery);
				   preparedStatement.setInt(1, phibaseSerialId);
				   preparedStatement.setString(2, phibaseInfo.getPhibaseSpeciesExpert());
				   preparedStatement.setString(3, phibaseInfo.getEnteredBy());
				   preparedStatement.setString(4, phibaseInfo.getManualMORTextMiningT());
				   preparedStatement.setString(5, phibaseInfo.getCuratorOrganisation());
				   preparedStatement.setString(6, phibaseInfo.getCurationDate());
				   preparedStatement.setString(7, phibaseInfo.getCurationComments());
				   preparedStatement.setString(8, phibaseInfo.getToDo());
				   preparedStatement.setString(9, phibaseInfo.getRecordId());
				   preparedStatement.setString(10, phibaseInfo.getCurationDetails());
				   preparedStatement.setString(11, phibaseInfo.getFileName());
				   preparedStatement.setString(12, phibaseInfo.getBatchNo());
				   preparedStatement.setString(13, phibaseInfo.getLab());
				   preparedStatement.setString(14, phibaseInfo.getFGMycotoxin());

				   preparedStatement.executeUpdate();
				   
				   insertQuery="INSERT INTO PHIBASE_ACCESSION_GENE_MAPPING(PHIBASE_SL_ID,PHIBASE_ACCESSION_ID,GENE_NAME) VALUES(?,?,?)";
				   preparedStatement=conn.prepareStatement(insertQuery);
				   preparedStatement.setInt(1, phibaseSerialId);
				   preparedStatement.setString(2, phibaseReference.getPhibaseAccessionId());
				   preparedStatement.setString(3, phibaseGene.getGeneName());
				   preparedStatement.executeUpdate();
				   
				   
				   //mapPhibaseIdGene();
				   // If there is no error.
				   conn.commit();
				   conn.setAutoCommit(true);
				   noRecordInserted++;
				}catch(SQLException se){
				   // If there is any error.
					se.printStackTrace();
					phibaseResultBuffer.append("Error During uploading :"+phibaseReference.getPhibaseAccessionId()+" : "+se.getMessage()+"\n");
					if(conn!=null){
						try{
							System.out.println("Transaction is being rolled back");
							conn.rollback();
						}catch (SQLException e) {
							e.printStackTrace();
						}

					}

				}catch (Exception e) {
					e.printStackTrace();
					phibaseResultBuffer.append("Error In Format of Data: "+phibaseReference.getPhibaseAccessionId()+" : "+e.getMessage()+"\n");
					if(conn!=null){
						try{
							System.out.println("Transaction is being rolled back");
							conn.rollback();
						}catch (SQLException se) {
							se.printStackTrace();
						}

					}
				}finally{
					if(preparedStatement!=null){
						try{
							preparedStatement.close();
						}catch (SQLException e) {
							e.printStackTrace();
						}

					}
					if(rs!=null){
						try{
							rs.close();
						}catch (SQLException e) {
							e.printStackTrace();
						}
					}
					if(conn!=null){
						try{
							conn.close();
						}catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
		}
		phibaseResultBuffer.append("Total No of Record Successfully updated :"+noRecordInserted);
		writeFile(phibaseResultFile, phibaseResultBuffer.toString(),true);
	}
}
