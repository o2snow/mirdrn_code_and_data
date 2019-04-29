// JavaScript Document
var token;
var LAYOUT_STYLE;
var RAW_GENE_LIST;
var VIEW_TOKEN = 1;
var SUBPATHWAY_STRORE_OREGINAL = new Array();
var SUBPATHWAY_STRORE_SORT = new Array();
var SUBPATHWAY_STRORE_BUFFER = new Array();

var ASSOCIATED_TARGET_GENE_STRORE = [];
var ASSOCIATED_TARGET_GENE_SIZE;

var SUBPATHWAY_STRORE = [];
var SUBPATHWAY_STRORE_SIZE;

var SUBPATHWAY_PAGE_COUNT;
var SUBPATHWAY_PAGE_NO;
var SUBPATHWAY_PAGE_SIZE = 40;

var COMORBIDITY_PAGE_COUNT;
var COMORBIDITY_PAGE_NO;
var COMORBIDITY_PAGE_SIZE = 25;

var COMORBIDITY_GENE_STORAGE = new Array();

var GO_PAGE_SIZE = 20;

var TARGET_MF_STRORE = [];
var TARGET_MF_STRORE_SIZE;
var TARGET_MF_PAGE_COUNT;
var TARGET_MF_PAGE_NO;

var TARGET_BP_STRORE = [];
var TARGET_BP_STRORE_SIZE;
var TARGET_BP_PAGE_COUNT;
var TARGET_BP_PAGE_NO;

var TARGET_CC_STRORE = [];
var TARGET_CC_STRORE_SIZE;
var TARGET_CC_PAGE_COUNT;
var TARGET_CC_PAGE_NO;

var NETWORK_JSON;
var NETWORK_STYLE;

var NETWORK_JSON_BUFFER;

$(function() {	

	$("#associated_mirnas_viewer").hide();
	$("#target_gene_viewer").hide();
	$("#subpathway_viewer").hide();
	$("#comorbidity_gene_viewer").hide();
	$("#network_viewer").hide();
	$('#gotop').hide();
	
	$("#network_cc").hide();
	$("#network_bp").hide();
	$("#network_mf").hide();
	
	$("#sub_pre").hide();
	$("#com_pre").hide();
	
	token = $("#phpToken").val();
	//==============================================	
	$("#mirna").mouseover(function(){
  		$("#mirna").attr('src',"img/ncRANppi_icon_mirna_over.png");
	});
	$("#mirna").mouseout(function(){
    	$("#mirna").attr('src',"img/ncRANppi_icon_mirna_off.png");
  	});
		
	$("#sirna").mouseover(function(){
  		$("#sirna").attr('src',"img/ncRANppi_icon_sirna_over.png");
	});
	$("#sirna").mouseout(function(){
    	$("#sirna").attr('src',"img/ncRANppi_icon_sirna_off.png");
  	});
	
	$("#query").mouseover(function(){
  		$("#query").attr('src',"img/ncRANppi_butten_query_on_long.png");
	});
	$("#query").mouseout(function(){
    	$("#query").attr('src',"img/ncRANppi_butten_query_off_long.png");
  	});
	
		
	$("#query").click(function(){
			GetDisease();
	});
		
	$('#export').click(function(e){
		var sb = "";
		sb = sb + "#########################################################################"+"\n";
		sb = sb + "#                                                                       #"+"\n";
		sb = sb + "#  Disease specific miRNAs regulated network database.                  #"+"\n";
		sb = sb + "#                                                                       #"+"\n";
		sb = sb + "#  Copyright (C) 2019-01, National Central University and               #"+"\n";
		sb = sb + "#                         The Institute of Biology and Bioinformatics.  #"+"\n";
		sb = sb + "#                                                                       #"+"\n";
		sb = sb + "#  This code is licensed under the GNU Lesser General Public License.   #"+"\n";
		sb = sb + "#  See the file LICENSE or this URL for the full text of the license:   #"+"\n";
		sb = sb + "#  http://www.gnu.org/licenses/lgpl.html                                #"+"\n";
		sb = sb + "#                                                                       #"+"\n";
		sb = sb + "#########################################################################"+"\n";
		sb = sb + "\n";
		sb = sb + "\n";
		sb = sb + "This file stores all the sub-pathways by specific miRNA regulated."+"\n";
		sb = sb + "This information contains the following columns:"+"\n";
		sb = sb + "1.	miRNA"+"\n";
		sb = sb + "2.	Target Gene"+"\n";
		sb = sb + "3.	Gene 1"+"\n";
		sb = sb + "4.	Gene 2"+"\n";
		sb = sb + "5.	P-Value"+"\n";
		sb = sb + "\n";
		sb = sb + "# The format of each gene node information:"+"\n";
		sb = sb + "# Gene ID|Gene Symbol|Cancerous Protein|OMIM|Transcription Factor(true/false)|Receptor Protein(true/false)\n";
		sb = sb + "\n";
		
		var etype = $('#export_type').val();		
		if(etype == 2){
			
			for(var key in SUBPATHWAY_STRORE_BUFFER){
				var value =SUBPATHWAY_STRORE_BUFFER[key];
				var symbol_0 = value.target_gene;
				var symbol_1 = value.gene_one;
				var symbol_2 = value.gene_two;	
				var mapkegg = value.kegg;
				var mappvalue = value.pvalue.toExponential(6);
				
				var mirna; 
				for(var keyin in ASSOCIATED_TARGET_GENE_STRORE){
					var tar = ASSOCIATED_TARGET_GENE_STRORE[keyin].split(" ");
					var con = tar[1].split("|");
					if(symbol_0.match(con[1])){
						mirna = tar[0];
						break;
					}	
				}
				
						
				sb = sb + mirna +"\t"+ symbol_0+"\t"+symbol_1+"\t"+symbol_2+"\t"+mapkegg+"\t"+mappvalue+"\n";						
			}
			
		}else{
			
			for(var key in SUBPATHWAY_STRORE){
				var value = JSON.parse(SUBPATHWAY_STRORE[key]);
				var symbol_0 = value.target_gene;
				var symbol_1 = value.gene_one;
				var symbol_2 = value.gene_two;	
				var mapkegg = value.kegg;
				var mappvalue = value.pvalue.toExponential(6);
				
				var mirna; 
				for(var keyin in ASSOCIATED_TARGET_GENE_STRORE){
					var tar = ASSOCIATED_TARGET_GENE_STRORE[keyin].split(" ");
					var con = tar[1].split("|");
					if(symbol_0.match(con[1])){
						mirna = tar[0];
						break;
					}	
				}
				
						
				sb = sb + mirna +"\t"+ symbol_0+"\t"+symbol_1+"\t"+symbol_2+"\t"+mapkegg+"\t"+mappvalue+"\n";						
			}
		}
		
		$.generateFile({
			filename	: 'export_subpathways.txt',
			content		: sb.toString(),
			script		: 'download.php'
		});
		
		e.preventDefault();
		
	});
	
	
	
	$('#export_com').click(function(e){
		var sb = "";
		sb = sb + "#########################################################################"+"\n";
		sb = sb + "#                                                                       #"+"\n";
		sb = sb + "#  Disease specific miRNAs regulated network database.                  #"+"\n";
		sb = sb + "#                                                                       #"+"\n";
		sb = sb + "#  Copyright (C) 2019-01, National Central University and               #"+"\n";
		sb = sb + "#                         The Institute of Biology and Bioinformatics.  #"+"\n";
		sb = sb + "#                                                                       #"+"\n";
		sb = sb + "#  This code is licensed under the GNU Lesser General Public License.   #"+"\n";
		sb = sb + "#  See the file LICENSE or this URL for the full text of the license:   #"+"\n";
		sb = sb + "#  http://www.gnu.org/licenses/lgpl.html                                #"+"\n";
		sb = sb + "#                                                                       #"+"\n";
		sb = sb + "#########################################################################"+"\n";
		sb = sb + "\n";
		sb = sb + "\n";
		sb = sb + "This file stores all comorbidity genes from the sub-pathways by specific miRNA regulated."+"\n";	
		sb = sb + "This information contains the following columns:"+"\n";
		sb = sb + "1.	Comorbidity Gene"+"\n";
		sb = sb + "2.	Cancerous protein"+"\n";
		sb = sb + "3.	OMIM"+"\n";
		sb = sb + "4.	KEGG"+"\n";
		sb = sb + "\n";
		sb = sb + "\n";
		
		for(var key in COMORBIDITY_GENE_STORAGE){
			var symbol = COMORBIDITY_GENE_STORAGE[key].split("\|");	
			
			var role = symbol[2].split(";");	
			var CanerousMarker = "";
			
			if(role[0] == 1){
				CanerousMarker = CanerousMarker + "OCG"; 
			}
			if(role[1] == 1 && role[0] == 1){
				CanerousMarker = CanerousMarker + ";TSG"; 
			}else if(role[1] == 1 && role[0] == 0){
				CanerousMarker = CanerousMarker + "TSG"; 
			}
			if(role[2] == 1 && (role[0] == 1 || role[1] == 1)){
				CanerousMarker = CanerousMarker + ";CRG"; 
			}else if(role[2] == 1 && role[0] == 0 && role[1] == 0){
				CanerousMarker = CanerousMarker + "CRG"; 
			}	
				
				
			var keggListArray = symbol[5].split(";");									
			var keggString = "";
			for(var i = 0; i <= keggListArray.length-2 ; i++){				
				var itemKeggArray = keggListArray[i].split("=");
				keggString = keggString + itemKeggArray[0]+";";
			}
					
			sb = sb + symbol[1] +"\t"+ CanerousMarker +"\t"+ symbol[3] +"\t"+keggString+"\n";						
		}
		
		$.generateFile({
			filename	: 'export_comorbidity_genes.txt',
			content		: sb.toString(),
			script		: 'download.php'
		});
		
		e.preventDefault();
		
	});
	
	
	
	$("#network_layout").change(function(){ 		
		jQuery('option:selected', this).each(function(){ 
			if(this.value != 0){
				LAYOUT_STYLE = this.value;
				RunCyto();
			}
			
		});
	});
	
	
	$("#go_cc").click(function(){
		$("#go_cc_b").css('background-color', '#CF8F56');
		$("#go_bp_b").css('background-color', '#DDAE85');
		$("#go_mf_b").css('background-color', '#DDAE85');
		viewGOCC();
		return false;
	});
	$("#go_bp").click(function(){
		$("#go_cc_b").css('background-color', '#DDAE85');
		$("#go_bp_b").css('background-color', '#CF8F56');
		$("#go_mf_b").css('background-color', '#DDAE85');
		viewGOBP();
		return false;
	});
	$("#go_mf").click(function(){
		$("#go_cc_b").css('background-color', '#DDAE85');
		$("#go_bp_b").css('background-color', '#DDAE85');
		$("#go_mf_b").css('background-color', '#CF8F56');
		viewGOMF();
		return false;
	});
	
	
	
	InitialTop();
	
	
	$("#subview_top_button").click(function(){
		
		var TOP_NUMBER = $("#subview_top").val();
		//$("#sub_number").html("(Number of list:"+TOP_NUMBER+")");
		
		if(!isNumber(TOP_NUMBER)){
			alert("Please check this value is number.");
		}else{	
			SubPathwaysViews(TOP_NUMBER);
		}
		return false;
	});
	
		
});

function viewGOCC(){
		$("#network_cc").show();
		$("#network_bp").hide();
		$("#network_mf").hide();
		return false;
	}
function viewGOBP(){
		$("#network_cc").hide();
		$("#network_bp").show();
		$("#network_mf").hide();
		return false;
	}
function viewGOMF(){
		$("#network_cc").hide();
		$("#network_bp").hide();
		$("#network_mf").show();
		return false;
	}


function InitialTop(){
	
	
}

function CleanCache(){
	SUBPATHWAY_STRORE_BUFFER = [];
	SUBPATHWAY_STRORE_OREGINAL = [];
	SUBPATHWAY_STRORE_SORT = [];
	
	ASSOCIATED_TARGET_GENE_STRORE = [];
	ASSOCIATED_TARGET_GENE_SIZE = 0;
	
	SUBPATHWAY_STRORE = [];
	SUBPATHWAY_STRORE_SIZE = 0;

	SUBPATHWAY_PAGE_COUNT = 0;
 	SUBPATHWAY_PAGE_NO = 0;
	
	COMORBIDITY_PAGE_COUNT = 0;
	COMORBIDITY_PAGE_NO = 0;

	TARGET_MF_STRORE = [];
	TARGET_MF_STRORE_SIZE = 0;
	TARGET_MF_PAGE_COUNT = 0;
	TARGET_MF_PAGE_NO = 0;

	TARGET_BP_STRORE = [];
	TARGET_BP_STRORE_SIZE =0;
	TARGET_BP_PAGE_COUNT =0;
	TARGET_BP_PAGE_NO =0;

	TARGET_CC_STRORE = [];
	TARGET_CC_STRORE_SIZE =0;
	TARGET_CC_PAGE_COUNT =0;
	TARGET_CC_PAGE_NO =0;	
	
	$("#network_gene").html("");	
	$("#network_omim").html("");
	$("#network_cancerous").html("");
	$("#network_cc").html("");
	$("#network_bp").html("");
	$("#network_mf").html("");
	$("#network_pathway").html("");
	
	$("#genefilter").val("");
	
	$("#go_cc_b").css('background-color', '#CF8F56');
	$("#go_bp_b").css('background-color', '#DDAE85');
	$("#go_mf_b").css('background-color', '#DDAE85');
	viewGOCC();
	
	document.getElementById('network_layout').options[0].selected = 'selected';
	$("#cytoscapeweb").html("Your disease network will be displayed by your choosing.");
}

function GetDisease(){
		
		CleanCache();
		try {
			
					
			
				$("#associated_mirnas_viewer").fadeOut("fast");
				$("#target_gene_viewer").fadeOut("fast");
				//$("#target_geneontology_viewer").fadeOut("fast");
				$("#subpathway_viewer").fadeOut("fast");
				$("#comorbidity_gene_viewer").fadeOut("fast");
				$("#network_viewer").fadeOut("fast");
				//$("#network_genoontology_viewer").fadeOut("fast");
				
				// D1
				var disease1 = $("#disease_1").val();				
				var ranking = $("#ranking").val();
				var pvalue = $("#pvalue").val();
				var tissue = $("#tissue").val();
				var kegg = 0;
				var tf_target = 0;
				var tf_1 = 0;
				var tf_2 = 0;
				var rc_target = 0;
				var rc_1 = 0;
				var rc_2 = 0;
				
				var cancerous1 = $("#cancerous1").val();
				var cancerous2 = $("#cancerous2").val();
				var cancerous3 = $("#cancerous3").val();
				
				
				
				// D2
				var disease2 = $("#disease_2").val();
				var pvalue2 = $("#pvalue2").val();
				var tissue2 = $("#tissue2").val();
				var kegg2 = 0;
				var tf_target_2 = 0;
				var tf_1_2 = 0;
				var tf_2_2 = 0;
				var rc_target_2 = 0;
				var rc_1_2 = 0;
				var rc_2_2 = 0;
				
				var cancerous4 = $("#cancerous4").val();
				var cancerous5 = $("#cancerous5").val();
				var cancerous6 = $("#cancerous6").val();
				
				
				
				// Filter				
				if(disease1 == "" || disease2 == ""){			
					alert("Please select the disease for 1 and 2");
					return;
				}
											
				
				if ($("input[name='common_pathway']:checked").val()) {					
					kegg = 1;
				}
				if ($("input[name='common_pathway2']:checked").val()) {					
					kegg2 = 1;
				}
				
				
				if ($("input[name='transcription1']:checked").val()) {					
					tf_target = 1;
				}
				if ($("input[name='transcription2']:checked").val()) {					
					tf_1 = 1;
				}
				if ($("input[name='transcription3']:checked").val()) {					
					tf_2 = 1;
				}
				
				if ($("input[name='transcription4']:checked").val()) {					
					tf_target_2 = 1;
				}
				if ($("input[name='transcription5']:checked").val()) {					
					tf_1_2 = 1;
				}
				if ($("input[name='transcription6']:checked").val()) {					
					tf_2_2 = 1;
				}
				
				
				
				if ($("input[name='receptor1']:checked").val()) {					
					rc_target = 1;
				}
				if ($("input[name='receptor2']:checked").val()) {					
					rc_1 = 1;
				}
				if ($("input[name='receptor3']:checked").val()) {					
					rc_2 = 1;
				}
				
				if ($("input[name='receptor4']:checked").val()) {					
					rc_target_2 = 1;
				}
				if ($("input[name='receptor5']:checked").val()) {					
					rc_1_2 = 1;
				}
				if ($("input[name='receptor6']:checked").val()) {					
					rc_2_2 = 1;
				}
				
				
				if(pvalue == ""){
					pvalue = 0;
				}else{
					var pvalueIsOK1 = isNumber(pvalue);
					if( pvalueIsOK1 != true || !(pvalue < 1)){
						alert("Please check the P-Value of disease 1 is less than 1");
						return;
					}
				}
				
				if(pvalue2 == ""){
					pvalue2 = 0;
				}else{
					var pvalueIsOK2 = isNumber(pvalue2);
					if( pvalueIsOK2 != true || !(pvalue2 < 1)){
						alert("Please check the P-Value of disease 2 is less than 1");
						return;
					}
				}
				
				//alert(token+"\n"+disease1+"\n"+tissue+"\n"+kegg+"\n"+cancerous1+"\n"+cancerous2+"\n"+cancerous3+"\n"+tf_target+"\n"+tf_1+"\n"+tf_2+"\n"+rc_target+"\n"+rc_1+"\n"+rc_2+"\n"+ranking+"\n"+pvalue+"\n");
				
				//alert(token+"\n"+disease2+"\n"+tissue2+"\n"+kegg2+"\n"+cancerous4+"\n"+cancerous5+"\n"+cancerous6+"\n"+tf_target_2+"\n"+tf_1_2+"\n"+tf_2_2+"\n"+rc_target_2+"\n"+rc_1_2+"\n"+rc_2_2+"\n"+ranking2+"\n"+pvalue2);
				
								
				$.blockUI({ message: '<h8><img src="./img/busy.gif" />&nbsp;&nbsp;&nbsp;processing...</h8>',
					css: { centerX: true, top: '30%', height:'100', backgroundColor: '#FFFFFF', color: '#fff', border:'0px', '-webkit-border-radius': '6px'},
					overlayCSS:  { backgroundColor: '#000000',opacity:0.1}   });
				
				
				
				
				
				//##################################################################################					
				$.getJSON('http://mirdrn.ncu.edu.tw:8080/map/service/GetCompareDiseaseMap?callback=?', {
					token: token,
					disease_1: disease1,
					tissue: tissue,			
					kegg: kegg,
					role_target: cancerous1,
					role_level_1: cancerous2,
					role_level_2: cancerous3,
					tf_target: tf_target,
					tf_level_1: tf_1,
					tf_level_2: tf_2,
					rc_target: rc_target,
					rc_level_1: rc_1,
					rc_level_2: rc_2,
					ranking: ranking,
					pvalue: pvalue,					
					disease_2: disease2,
					tissue2: tissue2,			
					kegg2: kegg2,
					role_target_2: cancerous4,
					role_level_1_2: cancerous5,
					role_level_2_2: cancerous6,
					tf_target_2: tf_target_2,
					tf_level_1_2: tf_1_2,
					tf_level_2_2: tf_2_2,
					rc_target_2: rc_target_2,
					rc_level_1_2: rc_1_2,
					rc_level_2_2: rc_2_2,
					ranking2: ranking,
					pvalue2: pvalue2			
				}, function(data) {	
						
						if(data[0].status == 1001){			
											
							var networkJson = JSON.stringify(data[0].network);							
							var networkStyle = JSON.stringify(data[0].network_style);
							NETWORK_JSON = JSON.parse(networkJson);
							NETWORK_STYLE = JSON.parse(networkStyle);
							
							var associated_mirnas_1 = data[0].associated_disease_1_mirnas;
							var associated_mirnas_2 = data[0].associated_disease_2_mirnas;
							
							if(associated_mirnas_1 != null || associated_mirnas_2 != null){	
							
								//Disease 1 associated_miRNA
								var mirnaArray = data[0].associated_disease_1_mirnas.associated_mirnas_mirna;						
								var outMirnaArray = mirnaArray.join(", ");
								
								var pubmedArray = data[0].associated_disease_1_mirnas.associated_mirnas_pubmed;
								var outPubmedArray = "";
								var num = 0;
								for(var i = 0; i <= pubmedArray.length ; i++){
									if(num == 0){
											if(pubmedArray[i] != null){
												outPubmedArray = outPubmedArray + "<a href=\"http://www.ncbi.nlm.nih.gov/pubmed/?term="+pubmedArray[i]+"\" target=\"_blank\">"+pubmedArray[i]+"</a>";
											}											
										}else{
											if(pubmedArray[i] != null){
												outPubmedArray = outPubmedArray + ", <a href=\"http://www.ncbi.nlm.nih.gov/pubmed/?term="+pubmedArray[i]+"\" target=\"_blank\">"+pubmedArray[i]+"</a>";
											}
										}
										num++;		
								}
								
								var htmlAssociatedMirnas1 = "<tr><td class=\"column_title\" align=\"left\">miRNA</td><td class=\"column_title\">Pubmed</td></tr><tr><td width=\"70%\" bgcolor=\"#FFFFFF\" align=\"left\">"+outMirnaArray+"</td><td width=\"30%\" bgcolor=\"#FFFFFF\" align=\"left\">"+outPubmedArray+"</td></tr>";
								$("#disease_1_assoicated_gene_total").html("Total:&nbsp;"+mirnaArray.length );
								$("#disease_1_associated_mirnas").html(htmlAssociatedMirnas1);
							
							
								//Disease 2 associated_miRNA
								var mirnaArray2 = data[0].associated_disease_2_mirnas.associated_mirnas_mirna;						
								var outMirnaArray2 = mirnaArray2.join(", ");
								
								var pubmedArray2 = data[0].associated_disease_2_mirnas.associated_mirnas_pubmed;
								var outPubmedArray2 = "";
								var num = 0;
								for(var i = 0; i <= pubmedArray2.length ; i++){
									if(num == 0){
											if(pubmedArray2[i] != null){
												outPubmedArray2 = outPubmedArray2 + "<a href=\"http://www.ncbi.nlm.nih.gov/pubmed/?term="+pubmedArray2[i]+"\" target=\"_blank\">"+pubmedArray2[i]+"</a>";
											}											
										}else{
											if(pubmedArray2[i] != null){
												outPubmedArray2 = outPubmedArray2 + ", <a href=\"http://www.ncbi.nlm.nih.gov/pubmed/?term="+pubmedArray2[i]+"\" target=\"_blank\">"+pubmedArray2[i]+"</a>";
											}
										}
										num++;		
								}
								
								var htmlAssociatedMirnas2 = "<tr><td class=\"column_title\" align=\"left\">miRNA</td><td class=\"column_title\">Pubmed</td></tr><tr><td width=\"70%\" bgcolor=\"#FFFFFF\" align=\"left\">"+outMirnaArray2+"</td><td width=\"30%\" bgcolor=\"#FFFFFF\" align=\"left\">"+outPubmedArray2+"</td></tr>";
								$("#disease_2_assoicated_gene_total").html("Total:&nbsp;"+mirnaArray2.length );
								$("#disease_2_associated_mirnas").html(htmlAssociatedMirnas2);
							
							
							
								//Associated_target_gene		
								ASSOCIATED_TARGET_GENE_STRORE = [];
								ASSOCIATED_TARGET_GENE_SIZE = 0;
											
								var targetGeneArray = data[0].associated_target_gene;
								
								var outTargetGene = "<tr><td width=\"25%\" class=\"column_title\">Gene</td><td width=\"20%\" class=\"column_title\">Cancerous protein</td><td width=\"25%\" class=\"column_title\">OMIM ID</td><td width=\"30%\" class=\"column_title\">miRNAs</td></tr>";
								var target_gene_lenth = 0;
								$.each( targetGeneArray, function( key, val ) {
									target_gene_lenth++;
									
									var symbol = key.split("\|");
									
								　 	ASSOCIATED_TARGET_GENE_STRORE.push(val+" "+symbol[0]+"|"+symbol[1]+"|"+symbol[3]);
								  	ASSOCIATED_TARGET_GENE_SIZE++;									
									
									
									var outBeMirna = val.join(", ");
									var role = symbol[2].split(";");	
																	
									var omimList = symbol[3].split(";");
									var omimTag = "";
									var num = 0;	
									for(var i = 0; i <= omimList.length ; i++){
										if(num == 0){
											if(omimList[i] != null){
												omimTag = omimTag + "<a href=\"http://www.omim.org/entry/"+omimList[i]+"\" target=\"_blank\">"+omimList[i]+"</a>";
											}											
										}else{
											if(omimList[i] != null){
												omimTag = omimTag + ", <a href=\"http://www.omim.org/entry/"+omimList[i]+"\" target=\"_blank\">"+omimList[i]+"</a>";
											}
										}
										num++;										
									}
																
									
									
									var ocgMarker = "";
									var ocgMarkerBreak = 0;
									if(role[0] == 1){
										if(ocgMarkerBreak == 0){
											ocgMarkerBreak = 1;
											ocgMarker = ocgMarker + " ";
										}
										ocgMarker = ocgMarker + "<a href=\"http://www.binfo.ncku.edu.tw/cgi-bin/gf.pl?genename="+symbol[1]+"\" target=\"_blank\"><img src=\"img/ocg.png\" width=\"36\" height=\"18\"></a>";
									}
									if(role[1] == 1){
										if(ocgMarkerBreak == 0){
											ocgMarkerBreak = 1;
											ocgMarker = ocgMarker + " ";
										}
										ocgMarker = ocgMarker + "<a href=\"http://www.binfo.ncku.edu.tw/cgi-bin/gf.pl?genename="+symbol[1]+"\" target=\"_blank\"><img src=\"img/tsg.png\" width=\"36\" height=\"18\"></a>";
									}
									if(role[2] == 1){
										if(ocgMarkerBreak == 0){
											ocgMarkerBreak = 1;
											ocgMarker = ocgMarker + " ";
										}
										ocgMarker = ocgMarker + "<a href=\"http://www.binfo.ncku.edu.tw/cgi-bin/gf.pl?genename="+symbol[1]+"\" target=\"_blank\"><img src=\"img/crg.png\" width=\"36\" height=\"18\"></a>";
									}
									
									
									outTargetGene = outTargetGene + "<tr><td width=\"25%\" bgcolor=\"#FFFFFF\" align=\"center\"><a href=\"http://www.genecards.org/cgi-bin/carddisp.pl?gene="+symbol[1]+"-"+symbol[4]+"\" target=\"_blank\">"+symbol[1]+"</a></td><td width=\"20%\" bgcolor=\"#FFFFFF\" align=\"center\">"+ocgMarker+"</td><td width=\"25%\" bgcolor=\"#FFFFFF\" align=\"left\">"+omimTag+"</td><td width=\"30%\" bgcolor=\"#FFFFFF\" class=\"table_text\">"+outBeMirna+"</td></tr>";
								});
								$("#target_gene_total").html("Total:&nbsp;"+target_gene_lenth );
								$("#target_gene").html(outTargetGene);
								
								
								
								
								// Sub Pathway								
								SUBPATHWAY_STRORE_SIZE = 0;
								
								$.each(data[0].subpathway, function(index, json) { 
								  var jArray = JSON.stringify(json);
								　 SUBPATHWAY_STRORE.push(jArray);
								  SUBPATHWAY_STRORE_SIZE++;
								  
								  var newjson = jQuery.parseJSON(jArray);
								  
								  SUBPATHWAY_STRORE_OREGINAL.push(newjson);						
								  SUBPATHWAY_STRORE_SORT.push(newjson);
								  
								}); 
								$("#subview_top").val(SUBPATHWAY_STRORE_SIZE);
								
								
								//SORTTING	
								SUBPATHWAY_STRORE_SORT.sort(function(obj1, obj2) {
									// Ascending: first age less than the previous									
									return obj1.pvalue - obj2.pvalue;
								});	
								
								
								
								
								//SubPathwaysViews
								SubPathwaysViews(SUBPATHWAY_STRORE_SIZE);
								
								
								//ComorbidityGeneViews
								var knum = 0;
								$.each(data[0].comorbidity_gene, function(index, json) { 
								  var jArray = JSON.stringify(json);								  
								  var newjson = jQuery.parseJSON(jArray);
								  knum++;
								  COMORBIDITY_GENE_STORAGE.push(newjson+"|"+knum);								  
								});
								ComorbidityGeneViews();
								
								
																
								//=====================================
								$("#associated_mirnas_viewer").show();
								$("#target_gene_viewer").show();
								//$("#target_geneontology_viewer").show();
								$("#subpathway_viewer").show();
								$("#comorbidity_gene_viewer").show();
								$("#network_viewer").show();
								//$("#network_genoontology_viewer").show();
							
							
							}
							
							
							$.unblockUI({ 
								onUnblock: function(){ } 
							});												
						}else{
							$.unblockUI({ 
								onUnblock: function(){ alert("No any result for your input.");	 } 
							});	 
						}
						
				}); 
	
		} catch (e) {
			$.unblockUI({ 
				onUnblock: function(){ alert("System Error! Please contact us with the email.");	 } 
			});	
		}
	}
	


function SubPathwaysViews(INPUTNUMBER){
								
	var viewPathway;
	SUBPATHWAY_STRORE_BUFFER = [];
	SUBPATHWAY_PAGE_COUNT = 0;
	SUBPATHWAY_PAGE_NO = 1;	
	
	var SORT_TYPE = $("#view_sorting").val();
	var GENE_FILTER_SYMBOL = $("#genefilter").val().replace(/ /g,"");
	
	var B_STROGE; 
	if(SORT_TYPE == 1){
		B_STROGE = SUBPATHWAY_STRORE_SORT.slice();		
	}else{
		B_STROGE = SUBPATHWAY_STRORE_OREGINAL.slice();
	}
	
	
	if(INPUTNUMBER > 0){
		var keynum = 0;
			
		for (i = 0; i < B_STROGE.length; i++){				
			if(keynum >= INPUTNUMBER){					
				break;
			}	
			
			var g_symbol_0 = B_STROGE[i].target_gene.split("\|");
			var g_symbol_1 = B_STROGE[i].gene_one.split("\|");
			var g_symbol_2 = B_STROGE[i].gene_two.split("\|");
			
			//### Gene Filter
			if(GENE_FILTER_SYMBOL != "" && GENE_FILTER_SYMBOL.length > 1){
												
				if(g_symbol_0[1] == GENE_FILTER_SYMBOL || g_symbol_1[1] == GENE_FILTER_SYMBOL || g_symbol_2[1] == GENE_FILTER_SYMBOL){					
					keynum++;
					B_STROGE[i].no = keynum;
					SUBPATHWAY_STRORE_BUFFER.push(B_STROGE[i]);					
				}
				
			}else{
				keynum++;
				B_STROGE[i].no = keynum;				
				SUBPATHWAY_STRORE_BUFFER.push(B_STROGE[i]);
			}
			
		}
			
		//alert(SUBPATHWAY_STRORE_BUFFER[0].no + "--> "+$("#view_sorting").val() + "==> "+SUBPATHWAY_STRORE_BUFFER.length);
	}	
	
	$("#sub_number").html("(Number of list:"+keynum+")");
	
	SUBPATHWAY_PAGE_COUNT = Math.ceil(SUBPATHWAY_STRORE_BUFFER.length / SUBPATHWAY_PAGE_SIZE);			
					
	viewPathway = SUBPATHWAY_STRORE_BUFFER.slice((SUBPATHWAY_PAGE_NO - 1) * SUBPATHWAY_PAGE_SIZE, SUBPATHWAY_PAGE_NO * SUBPATHWAY_PAGE_SIZE);							
								
	SubPathwaysViewsTree(viewPathway);			
	
	// Initial Process
	ProcessCyto();
	$("#sub_next").show();
	$("#com_next").show();
	$("#sub_pre").hide();
	$("#com_pre").hide();							
}	

function SubPathwaysViewsTree(CONTENT_ARRAY){
	
	var htmlSubpathway = "<tr><td width=\"15%\" class=\"column_title\">No.</td><td width=\"16%\" class=\"column_title\">Target Gene</td><td width=\"16%\" class=\"column_title\">Gene 1</td><td width=\"16%\" class=\"column_title\">Gene 2</td><td width=\"20%\" class=\"column_title\">Common Pathway</td><td width=\"17%\" class=\"column_title\">P-Value</td></tr>";
								
	for(ii = 0; ii < CONTENT_ARRAY.length; ii++){
			
			var value = CONTENT_ARRAY[ii];
						
			var symbol_0 = value.target_gene.split("\|");
			var symbol_1 = value.gene_one.split("\|");
			var symbol_2 = value.gene_two.split("\|");
									
																																													
			var ocgMarker0 = "";
			var ocgMarkerBreak0 = 0;
			if(symbol_0[2].match("OCG") != null){
				if(ocgMarkerBreak0 == 0){
					ocgMarkerBreak0 = 1;
					ocgMarker0 = ocgMarker0 + " ";
				}
				ocgMarker0 = ocgMarker0 + "<a href=\"http://www.binfo.ncku.edu.tw/cgi-bin/gf.pl?genename="+symbol_0[1]+"\" target=\"_blank\"><img src=\"img/ocg.png\" width=\"36\" height=\"18\"></a>";
			}
			if(symbol_0[2].match("TSG") != null){
				if(ocgMarkerBreak0 == 0){
					ocgMarkerBreak0 = 1;
					ocgMarker0 = ocgMarker0 + " ";
				}
				ocgMarker0 = ocgMarker0 + "<a href=\"http://www.binfo.ncku.edu.tw/cgi-bin/gf.pl?genename="+symbol_0[1]+"\" target=\"_blank\"><img src=\"img/tsg.png\" width=\"36\" height=\"18\"></a>";
			}
			if(symbol_0[2].match("CRG") != null){
				if(ocgMarkerBreak0 == 0){
					ocgMarkerBreak0 = 1;
					ocgMarker0 = ocgMarker0 + " ";
				}
				ocgMarker0 = ocgMarker0 + "<a href=\"http://www.binfo.ncku.edu.tw/cgi-bin/gf.pl?genename="+symbol_0[1]+"\" target=\"_blank\"><img src=\"img/crg.png\" width=\"36\" height=\"18\"></a>";
			}
									
			var tfrc0 = "";
			if(symbol_0[4] == 1){
				tfrc0 = tfrc0 + " <img src=\"img/tf.png\" width=\"18\" height=\"19\">";									
			}
			if(symbol_0[5] == 1){
				tfrc0 = tfrc0 + " <img src=\"img/rc.png\" width=\"18\" height=\"19\">";									
			}
									
									
			var ocgMarker1 = "";
			var ocgMarkerBreak1 = 0;
			if(symbol_1[2].match("OCG") != null){
				if(ocgMarkerBreak1 == 0){
					ocgMarkerBreak1 = 1;
					ocgMarker1 = ocgMarker1 + " ";
				}
				ocgMarker1 = ocgMarker1 + "<a href=\"http://www.binfo.ncku.edu.tw/cgi-bin/gf.pl?genename="+symbol_1[1]+"\" target=\"_blank\"><img src=\"img/ocg.png\" width=\"36\" height=\"18\"></a>";
			}
			if(symbol_1[2].match("TSG") != null){
				if(ocgMarkerBreak1 == 0){
					ocgMarkerBreak1 = 1;
					ocgMarker1 = ocgMarker1 + " ";
				}
				ocgMarker1 = ocgMarker1 + "<a href=\"http://www.binfo.ncku.edu.tw/cgi-bin/gf.pl?genename="+symbol_1[1]+"\" target=\"_blank\"><img src=\"img/tsg.png\" width=\"36\" height=\"18\"></a>";
			}
			if(symbol_1[2].match("CRG") != null){
				if(ocgMarkerBreak1 == 0){
					ocgMarkerBreak1 = 1;
					ocgMarker1 = ocgMarker1 + " ";
				}
				ocgMarker1 = ocgMarker1 + "<a href=\"http://www.binfo.ncku.edu.tw/cgi-bin/gf.pl?genename="+symbol_1[1]+"\" target=\"_blank\"><img src=\"img/crg.png\" width=\"36\" height=\"18\"></a>";
			}
									
			var tfrc1 = "";
			if(symbol_1[4] == 1){
				tfrc1 = tfrc1 + " <img src=\"img/tf.png\" width=\"18\" height=\"19\">";									
			}
			if(symbol_1[5] == 1){
				tfrc1 = tfrc1 + " <img src=\"img/rc.png\" width=\"18\" height=\"19\">";									
			}
									
									

			var ocgMarker2 = "";
			var ocgMarkerBreak2 = 0;
			if(symbol_2[2].match("OCG") != null){
				if(ocgMarkerBreak2 == 0){
					ocgMarkerBreak2 = 1;
					ocgMarker2 = ocgMarker2 + " ";
				}
				ocgMarker2 = ocgMarker2 + "<a href=\"http://www.binfo.ncku.edu.tw/cgi-bin/gf.pl?genename="+symbol_2[1]+"\" target=\"_blank\"><img src=\"img/ocg.png\" width=\"36\" height=\"18\"></a>";
			}
			if(symbol_2[2].match("TSG") != null){
				if(ocgMarkerBreak2 == 0){
					ocgMarkerBreak2 = 1;
					ocgMarker2 = ocgMarker2 + " ";
				}
				ocgMarker2 = ocgMarker2 + "<a href=\"http://www.binfo.ncku.edu.tw/cgi-bin/gf.pl?genename="+symbol_2[1]+"\" target=\"_blank\"><img src=\"img/tsg.png\" width=\"36\" height=\"18\"></a>";
			}
			if(symbol_2[2].match("CRG") != null){
				if(ocgMarkerBreak2 == 0){
					ocgMarkerBreak2 = 1;
					ocgMarker2 = ocgMarker2 + " ";
				}
				ocgMarker2 = ocgMarker2 + "<a href=\"http://www.binfo.ncku.edu.tw/cgi-bin/gf.pl?genename="+symbol_2[1]+"\" target=\"_blank\"><img src=\"img/crg.png\" width=\"36\" height=\"18\"></a>";
			}
									
			var tfrc2 = "";
			if(symbol_2[4] == 1){
				tfrc2 = tfrc2 + " <img src=\"img/tf.png\" width=\"18\" height=\"19\">";									
			}
			if(symbol_2[5] == 1){
				tfrc2 = tfrc2 + " <img src=\"img/rc.png\" width=\"18\" height=\"19\">";									
			}
									
									
			var keggArray = value.kegg.split("\|");
			var keggString = "";
			var num = 0;	
			for(var i = 0; i <= keggArray.length ; i++){
				if(num == 0){
					if(keggArray[i] != null){
						keggString = keggString + "<a href=\"http://www.genome.jp/kegg-bin/show_pathway?"+keggArray[i]+"\" target=\"_blank\">"+keggArray[i]+"</a>";
					}											
				}else{
					if(keggArray[i] != null){
						keggString = keggString + ", <a href=\"http://www.genome.jp/kegg-bin/show_pathway?"+keggArray[i]+"\" target=\"_blank\">"+keggArray[i]+"</a>";
					}
				}
				num++;										
			}
									
			//alert(value.pvalue);
																		
									
	htmlSubpathway = htmlSubpathway + "<tr><td bgcolor=\"#FFFFFF\" class=\"table_text\">"+value.no+"</td><td bgcolor=\"#FFFFFF\" align=\"center\"><a href=\"http://www.genecards.org/cgi-bin/carddisp.pl?gene="+symbol_0[1]+"\" target=\"_blank\">"+symbol_0[1]+"</a>"+ocgMarker0+tfrc0+"</td><td bgcolor=\"#FFFFFF\" align=\"center\"><a href=\"http://www.genecards.org/cgi-bin/carddisp.pl?gene="+symbol_1[1]+"\" target=\"_blank\">"+symbol_1[1]+"</a>"+ocgMarker1+tfrc1+"</td><td bgcolor=\"#FFFFFF\" align=\"center\"><a href=\"http://www.genecards.org/cgi-bin/carddisp.pl?gene="+symbol_2[1]+"\" target=\"_blank\">"+symbol_2[1]+"</a>"+ocgMarker2+tfrc2+"</td><td bgcolor=\"#FFFFFF\" align=\"left\">"+keggString+"</td><td bgcolor=\"#FFFFFF\" class=\"table_text\">"+value.pvalue.toExponential(6)+"</td></tr>";
										
	}
								
	$("#subpathway_total").html("Total:&nbsp;"+SUBPATHWAY_STRORE_SIZE);
	$("#subpathway").html(htmlSubpathway);
}


function ComorbidityGeneViews(){
	COMORBIDITY_PAGE_COUNT = 0;
	COMORBIDITY_PAGE_NO = 1;	
	
	COMORBIDITY_PAGE_COUNT = Math.ceil(COMORBIDITY_GENE_STORAGE.length / COMORBIDITY_PAGE_SIZE);			
	
	var comorbidityGeneArray = COMORBIDITY_GENE_STORAGE.slice((COMORBIDITY_PAGE_NO - 1) * COMORBIDITY_PAGE_SIZE, COMORBIDITY_PAGE_NO * COMORBIDITY_PAGE_SIZE);
	
	ComorbidityGeneViewsTree(comorbidityGeneArray);
	
}


function ComorbidityGeneViewsTree(CONTENT_ARRAY) {
	
	var outComorbidityGene = "<tr><td width=\"10%\" class=\"column_title\">No.</td><td width=\"20%\" class=\"column_title\">Gene</td><td width=\"15%\" class=\"column_title\">Cancerous protein</td><td width=\"25%\" class=\"column_title\">OMIM ID</td><td width=\"30%\" class=\"column_title\">KEGG</td></tr>";
	
	$.each( CONTENT_ARRAY, function( key, val ) {
												
			var symbol = val.split("\|");
			var role = symbol[2].split(";");	
			var keggListArray = symbol[5].split(";");									
			var keggString = "";
			var nonum = symbol[6];
			
			var num = 0;										
			for(var i = 0; i <= keggListArray.length-2 ; i++){
																				
				var itemKeggArray = keggListArray[i].split("=");
										
					if(num == 0){
						if(itemKeggArray != null){
							keggString = keggString + "<a href=\"http://www.genome.jp/kegg-bin/show_pathway?"+itemKeggArray[0]+"\" target=\"_blank\" title=\""+itemKeggArray[1]+"\">"+itemKeggArray[0]+"</a>";
						}											
					}else{
						if(itemKeggArray != null){
							keggString = keggString + ", <a href=\"http://www.genome.jp/kegg-bin/show_pathway?"+itemKeggArray[0]+"\" target=\"_blank\" title=\""+itemKeggArray[1]+"\">"+itemKeggArray[0]+"</a>";
						}
					}
					num++;										
			}	
										
														
			var omimList = symbol[3].split(";");
			var omimTag = "";
			
			var num = 0;	
			for(var i = 0; i <= omimList.length ; i++){
				if(num == 0){
					if(omimList[i] != null){
						omimTag = omimTag + "<a href=\"http://www.omim.org/entry/"+omimList[i]+"\" target=\"_blank\">"+omimList[i]+"</a>";
					}											
				}else{
					if(omimList[i] != null){
						omimTag = omimTag + ", <a href=\"http://www.omim.org/entry/"+omimList[i]+"\" target=\"_blank\">"+omimList[i]+"</a>";
					}
				}
				num++;										
			}
																
									
			var ocgMarker = "";
			var ocgMarkerBreak = 0;
			if(role[0] == 1){
				if(ocgMarkerBreak == 0){
						ocgMarkerBreak = 1;
						ocgMarker = ocgMarker + " ";
				}
				ocgMarker = ocgMarker + "<a href=\"http://www.binfo.ncku.edu.tw/cgi-bin/gf.pl?genename="+symbol[1]+"\" target=\"_blank\"><img src=\"img/ocg.png\" width=\"36\" height=\"18\"></a>";
			}
			if(role[1] == 1){
				if(ocgMarkerBreak == 0){
						ocgMarkerBreak = 1;
						ocgMarker = ocgMarker + " ";
				}
				ocgMarker = ocgMarker + "<a href=\"http://www.binfo.ncku.edu.tw/cgi-bin/gf.pl?genename="+symbol[1]+"\" target=\"_blank\"><img src=\"img/tsg.png\" width=\"36\" height=\"18\"></a>";
			}
			if(role[2] == 1){
				if(ocgMarkerBreak == 0){
						ocgMarkerBreak = 1;
						ocgMarker = ocgMarker + " ";
				}
				ocgMarker = ocgMarker + "<a href=\"http://www.binfo.ncku.edu.tw/cgi-bin/gf.pl?genename="+symbol[1]+"\" target=\"_blank\"><img src=\"img/crg.png\" width=\"36\" height=\"18\"></a>";
			}
									
									
	outComorbidityGene = outComorbidityGene + "<tr><td width=\"10%\" bgcolor=\"#FFFFFF\" class=\"table_text\">"+nonum+"</td><td width=\"20%\" bgcolor=\"#FFFFFF\" align=\"center\"><a href=\"http://www.genecards.org/cgi-bin/carddisp.pl?gene="+symbol[1]+"\" target=\"_blank\">"+symbol[1]+"</a></td><td width=\"15%\" bgcolor=\"#FFFFFF\" class=\"table_text\">"+ocgMarker+"</td><td width=\"25%\" bgcolor=\"#FFFFFF\" align=\"left\">"+omimTag+"</td><td width=\"30%\" bgcolor=\"#FFFFFF\" align=\"left\">"+keggString+"</td></tr>";
			
	});
	$("#comorbidity_gene_total").html("Total:&nbsp;"+COMORBIDITY_GENE_STORAGE.length );
	$("#comorbidity_gene").html(outComorbidityGene);
}


function NextComorbidityGeneViews() {
  COMORBIDITY_PAGE_NO++;
  
  if(COMORBIDITY_PAGE_NO == COMORBIDITY_PAGE_COUNT){
	  $("#com_next").hide();
	  $("#com_pre").show();
  }else if(COMORBIDITY_PAGE_NO == 1){
	  $("#com_next").show();
	  $("#com_pre").hide();
  }else{
	  $("#com_next").show();
	  $("#com_pre").show();
  }
  
  	var comorbidityGeneArray = COMORBIDITY_GENE_STORAGE.slice((COMORBIDITY_PAGE_NO - 1) * COMORBIDITY_PAGE_SIZE, COMORBIDITY_PAGE_NO * COMORBIDITY_PAGE_SIZE);	
	
	ComorbidityGeneViewsTree(comorbidityGeneArray);
	
}


function PrevComorbidityGeneViews() {
  COMORBIDITY_PAGE_NO--;
  
  if(COMORBIDITY_PAGE_NO == COMORBIDITY_PAGE_COUNT){
	  $("#com_next").hide();
	  $("#com_pre").show();
  }else if(COMORBIDITY_PAGE_NO == 1){
	  $("#com_next").show();
	  $("#com_pre").hide();
  }else{
	  $("#com_next").show();
	  $("#com_pre").show();
  }
  
  	var comorbidityGeneArray = COMORBIDITY_GENE_STORAGE.slice((COMORBIDITY_PAGE_NO - 1) * COMORBIDITY_PAGE_SIZE, COMORBIDITY_PAGE_NO * COMORBIDITY_PAGE_SIZE);	
	
	ComorbidityGeneViewsTree(comorbidityGeneArray);
	
	
}

	
function isNumber(n) {
  return !isNaN(parseFloat(n)) && isFinite(n);
}



function NextSubpathway() {
  SUBPATHWAY_PAGE_NO++;
  
  if(SUBPATHWAY_PAGE_NO == SUBPATHWAY_PAGE_COUNT){
	  $("#sub_next").hide();
	  $("#sub_pre").show();
  }else if(SUBPATHWAY_PAGE_NO == 1){
	  $("#sub_next").show();
	  $("#sub_pre").hide();
  }else{
	  $("#sub_next").show();
	  $("#sub_pre").show();
  }
  
  var viewPathway = SUBPATHWAY_STRORE_BUFFER.slice((SUBPATHWAY_PAGE_NO - 1) * SUBPATHWAY_PAGE_SIZE, SUBPATHWAY_PAGE_NO * SUBPATHWAY_PAGE_SIZE);
    
  SubPathwaysViewsTree(viewPathway);
}


function PrevSubpathway() {
  SUBPATHWAY_PAGE_NO--;
  
  if(SUBPATHWAY_PAGE_NO == 1){
	  $("#sub_next").show();
	  $("#sub_pre").hide();
  }else if(SUBPATHWAY_PAGE_NO > 1){
	  $("#sub_next").show();
	  $("#sub_pre").show();
  }
  
  var viewPathway = SUBPATHWAY_STRORE_BUFFER.slice((SUBPATHWAY_PAGE_NO - 1) * SUBPATHWAY_PAGE_SIZE, SUBPATHWAY_PAGE_NO * SUBPATHWAY_PAGE_SIZE);
 					
  SubPathwaysViewsTree(viewPathway);
}


function ProcessCyto(){	
	//############ Renew Buffer
	DROWP_NETWORK = null;
	
	NETWORK_JSON_BUFFER = null;
	NETWORK_JSON_BUFFER = jsonCopy(NETWORK_JSON);
	
	FINAL_NETWORK_NODES = null;
	FINAL_NETWORK_NODES = [];
	
	FINAL_NETWORK_EDGES = null;
	FINAL_NETWORK_EDGES = [];
	//############
	
	
	var raw_array_ppi = [];
	RAW_GENE_LIST = [];
				
	for(i=0; i< SUBPATHWAY_STRORE_BUFFER.length; i++){
			//var string = JSON.stringify(SUBPATHWAY_STRORE_BUFFER[i]);
										
			var node1array = SUBPATHWAY_STRORE_BUFFER[i].target_gene.split("\|");
			var node1 = node1array[1];
					
			var node2array = SUBPATHWAY_STRORE_BUFFER[i].gene_one.split("\|");
			var node2 = node2array[1];
					
			var node3array = SUBPATHWAY_STRORE_BUFFER[i].gene_two.split("\|");
			var node3 = node3array[1];
													
					
			if(node1 > node2){
				raw_array_ppi.push(node1+"|"+node2);
			}else{
				raw_array_ppi.push(node2+"|"+node1);
			}
					
			if(node2 > node3){
				raw_array_ppi.push(node2+"|"+node3);
			}else{
				raw_array_ppi.push(node3+"|"+node2);
			}		
												
	}
				
	var unique_raw_array_ppi = Array.from(new Set(raw_array_ppi));
		
	var node;		
	for(i=0; i< unique_raw_array_ppi.length; i++){
		node = unique_raw_array_ppi[i].split("\|");
		RAW_GENE_LIST.push(node[0]);
		RAW_GENE_LIST.push(node[1]);
	}
				
	//alert(raw_array_ppi.length+" "+unique_raw_array_ppi.length);
				
	var raw_data_edges_array = NETWORK_JSON_BUFFER.data.edges;
	var new_data_edges_array = [];
				
	$.each( raw_data_edges_array, function( key, val ){
					
		if(raw_data_edges_array[key].target.match("hsa-")){
				new_data_edges_array.push(raw_data_edges_array[key].target+"|"+raw_data_edges_array[key].source);
						
				RAW_GENE_LIST.push(raw_data_edges_array[key].target);
				RAW_GENE_LIST.push(raw_data_edges_array[key].source);
				//var string = JSON.stringify(raw_data_edges_array[key]);
				//alert(string);
		}
					
	});
				
	var unique_raw_gene_list = Array.from(new Set(RAW_GENE_LIST));
		
				
	var final_edges_array = new_data_edges_array.concat(unique_raw_array_ppi);
				
	//alert(final_edges_array.length);
	var FINAL_NETWORK_EDGES = [];
	var pinnum = 0;
	for(i=0; i<final_edges_array.length; i++){
		pinnum++;
					
		var aay = final_edges_array[i].split("\|");
					
		var str_json = '{"id":"'+pinnum+'","target":"'+aay[0]+'","source":"'+aay[1]+'"}';
		var json_obj = JSON.parse(str_json);
		FINAL_NETWORK_EDGES.push(json_obj);
	}
				
	//alert(FINAL_NETWORK_EDGES.toString());
	//alert(JSON.stringify(NETWORK_JSON.data.nodes));			
	
	//############ Renew Edges	
	NETWORK_JSON_BUFFER.data.edges = FINAL_NETWORK_EDGES;
	//############
					
	var FINAL_NETWORK_NODES = [];
	var NS = 0;
	for(i=0; i<NETWORK_JSON_BUFFER.data.nodes.length; i++){
					
			for (ii=0; ii<unique_raw_gene_list.length; ii++){
				if(NETWORK_JSON_BUFFER.data.nodes[i].id == unique_raw_gene_list[ii]){
					NS++;		
					//alert(NETWORK_JSON.data.nodes[i].id +" "+unique_raw_gene_list[ii]);
					FINAL_NETWORK_NODES.push(NETWORK_JSON_BUFFER.data.nodes[i]);
					break;
				}
			}	
	}
	//############ Renew Nodes			
	NETWORK_JSON_BUFFER.data.nodes = FINAL_NETWORK_NODES;
	//############
	
}

function RunCyto() {
				NETWORK_STYLE["edges"].color = "#3CA9C1";
				NETWORK_STYLE["global"].backgroundColor = "#FEFEFE";
				
  				// id of Cytoscape Web container div
                var div_id = "cytoscapeweb";               
                var options = {					
                    swfPath: "swf/CytoscapeWeb",
                    flashInstallerPath: "swf/playerProductInstall"
                };
                
                // init and draw
                var vis = new org.cytoscapeweb.Visualization(div_id, options);
				
				// callback when Cytoscape Web has finished drawing
                vis.ready(function() {
                			
                    // add a listener for when nodes and edges are clicked
                    vis.addListener("click", "nodes", function(event) {						
                        handle_click(event);
                    })
                    .addListener("click", "edges", function(event) {
                        
                    });
                    
                    function handle_click(event) {
                         var target = event.target;                         
						 var weight ="";
						 var label = "";
						 var omim = "";
						 var go_cc = "";
						 var go_bp = "";
						 var go_mf = "";
						 var cancerous = "";
						 var kegg = "";
                         //print("event.group = " + event.group);
                         for (var i in target.data) {
                            var variable_name = i;
                            var variable_value = target.data[i];
							if(variable_name == "weight"){
								weight = variable_value;								
							}else if(variable_name == "label"){
								label = variable_value;								
							}else if(variable_name == "omim"){
								omim = variable_value;								
							}else if(variable_name == "cellular"){
								go_cc = variable_value;								
							}else if(variable_name == "biological"){
								go_bp = variable_value;								
							}else if(variable_name == "molecular"){
								go_mf = variable_value;								
							}else if(variable_name == "cancerous"){
								cancerous = variable_value;								
							}else if(variable_name == "kegg"){
								kegg = variable_value;								
							}                           
                         }
						//alert(label+"\n"+omim+"\n"+go_cc+"\n"+go_bp+"\n"+go_mf+"\n");
						
						if(label.match("hsa-")){
							$("#network_gene").html(label);
							$("#network_omim").html("");
							$("#network_cancerous").html("");
							$("#network_mf").html("");
							$("#network_bp").html("");
							$("#network_cc").html("");
							$("#network_pathway").html("");
							
						}else{
							var labelString = "<a href=\"http://www.genecards.org/cgi-bin/carddisp.pl?gene="+label+"\" target=\"_blank\">"+label+"</a>";
							$("#network_gene").html(labelString);
							
							var omimList = omim.replace(/\, /g,";").split(";");
										var omimTag = "";
										var num = 0;	
										for(var i = 0; i <= omimList.length ; i++){
											if(num == 0){
												if(omimList[i] != null){
													omimTag = omimTag + "<a href=\"http://www.omim.org/entry/"+omimList[i]+"\" target=\"_blank\">"+omimList[i]+"</a>";
												}											
											}else{
												if(omimList[i] != null){
													omimTag = omimTag + ", <a href=\"http://www.omim.org/entry/"+omimList[i]+"\" target=\"_blank\">"+omimList[i]+"</a>";
												}
											}
											num++;										
										}	
							$("#network_omim").html(omimTag);
							
							
							var cancerous_info = cancerous.split("\|");
							var string_concerous = "";
							
							if(cancerous_info[0] == 1){
								string_concerous = string_concerous + "<a href=\"http://www.binfo.ncku.edu.tw/cgi-bin/gf.pl?genename="+label+"\" target=\"_blank\"><img src=\"img/ocg.png\" width=\"36\" height=\"18\"></a>";
							}
							if(cancerous_info[1] == 1){
								string_concerous = string_concerous + "<a href=\"http://www.binfo.ncku.edu.tw/cgi-bin/gf.pl?genename="+label+"\" target=\"_blank\"><img src=\"img/tsg.png\" width=\"36\" height=\"18\"></a>";
							}
							if(cancerous_info[2] == 1){
								string_concerous = string_concerous + "<a href=\"http://www.binfo.ncku.edu.tw/cgi-bin/gf.pl?genename="+label+"\" target=\"_blank\"><img src=\"img/crg.png\" width=\"36\" height=\"18\"></a>";
							}						
							$("#network_cancerous").html(string_concerous);
							
							
							
							var string_cc = "<table width=\"880\" border=\"0\" cellspacing=\"1 \" cellpadding=\"0\">";
							var cc_info = go_cc.split("\;");
							for (var i = 0; i < cc_info.length; i++) {
								var it = cc_info[i];
								var itValue = it.split("\|");	
								string_cc = string_cc + "<tr><td width=\"160\" bgcolor=\"#F2F2F2\">"+itValue[0]+"</td><td width=\"720\" bgcolor=\"#F2F2F2\" align=\"left\">"+itValue[1]+"</td></tr>";		
							}
							string_cc = string_cc + "</table>";	
							$("#network_cc").html(string_cc);
							
							var string_bp = "<table width=\"880\" border=\"0\" cellspacing=\"1\" cellpadding=\"0\">";
							var bp_info = go_bp.split("\;");
							for (var i = 0; i < bp_info.length; i++) {
								var it = bp_info[i];
								var itValue = it.split("\|");	
								string_bp = string_bp + "<tr><td width=\"160\" bgcolor=\"#F2F2F2\">"+itValue[0]+"</td><td width=\"720\" bgcolor=\"#F2F2F2\" align=\"left\">"+itValue[1]+"</td></tr>";		
							}
							string_bp = string_bp + "</table>";	
							$("#network_bp").html(string_bp);
							
							var string_mf = "<table width=\"880\" border=\"0\" cellspacing=\"1\" cellpadding=\"0\">";
							var mf_info = go_mf.split("\;");
							for (var i = 0; i < mf_info.length; i++) {
								var it = mf_info[i];
								var itValue = it.split("\|");	
								string_mf = string_mf + "<tr><td width=\"160\" bgcolor=\"#F2F2F2\">"+itValue[0]+"</td><td width=\"720\" bgcolor=\"#F2F2F2\" align=\"left\">"+itValue[1]+"</td></tr>";		
							}
							string_mf = string_mf + "</table>";	
							$("#network_mf").html(string_mf);
							
							
							var string_kegg = "<table width=\"720\" border=\"0\" cellspacing=\"1\" cellpadding=\"0\">";
							var kegg_info = kegg.split("\;");
							for (var i = 0; i < kegg_info.length - 1; i++) {
								var it = kegg_info[i];
								var itValue = it.split("\|");
								string_kegg = string_kegg + "<tr><td width=\"100\" bgcolor=\"#F2F2F2\" align=\"left\"><a href=\"http://www.genome.jp/kegg-bin/show_pathway?"+itValue[0]+"\" target=\"_blank\">"+itValue[0]+"</a></td><td width=\"620\" bgcolor=\"#F2F2F2\" align=\"left\">"+itValue[1]+"</td></tr>";
								
							}
							string_kegg = string_kegg + "</table>";	
							$("#network_pathway").html(string_kegg);
							
							//View Initial
							$("#go_cc_b").css('background-color', '#CF8F56');
							$("#go_bp_b").css('background-color', '#DDAE85');
							$("#go_mf_b").css('background-color', '#DDAE85');
							viewGOCC();
						}
						
						
                    }
                    
                   					
                });
				
								
	var draw_options = {
          // your data goes here
          network: NETWORK_JSON_BUFFER,
                    
          // show edge labels too
          edgeLabelsVisible: true,
                    
          // let's try another layout
          layout: LAYOUT_STYLE,
                    
          // set the style at initialisation
		  //NETWORK_STYLE.replace(/e8e8e8/g, 'B00B19');
		  visualStyle: NETWORK_STYLE,
                    
          // hide pan zoom
          panZoomControlVisible: true ,
					
		  nodeTooltipsEnabled: true
     };				
				
     vis.draw(draw_options);
	
}

function jsonCopy(src) {
  return JSON.parse(JSON.stringify(src));
}
