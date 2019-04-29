package edu.map.ws.vo;


public interface IVoConstants {
	
	public final static String HTTP_CODE_UTF8 = "UTF-8";
	public final static String UUID = "uuid";
	public final static Double ELECTRONIC_FEE = 3.8;
	public final static String PAGE_NUMBER = "pageNo";
	public final static String PAGE_SIZE = "pageSize";
	public final static String RESULT_SIZE = "resultNo";
	
	// facade name
	public final static String HMDD_TARGET_PURE_RAW_FACADE = "edu.map.ws.facade.imp.HmddTargetPureRawFacade";
	public final static String PPI2014_GEMES_FACADE = "edu.map.ws.facade.imp.Ppi2014GenesFacade";
	public final static String SUB_PATHWAYS_SERVICE_FACADE = "edu.map.ws.facade.imp.SubpathwayServiceFacade";
	public final static String GO_FACADE = "edu.map.ws.facade.imp.GoFacade";
	public final static String TARBASE_UNI_FACADE = "edu.map.ws.facade.imp.TarbaseUniFacade";
	public final static String SIRNA_FACADE = "edu.map.ws.facade.imp.SirnaFacade";

	// TOKEN for creation permission
	public final static String PERMISSION_TOKEN = "B481A5E1D39B47FDF9DBEB8A13F786A4";
	public final static String PERMISSION_TOKEN_NAME = "token";
		
	// PARAMETER NAME
	public final static String MESSAGE_ATG = "atg";
	
	public final static String MESSAGE_STATUS = "status";
	public final static String MESSAGE_RETURN = "return";
	public final static String MESSAGE_TRUE = "true";
	public final static String MESSAGE_FALSE = "false";
	public final static String MESSAGE_RESULT = "result";
	public final static String MESSAGE_CALLBACK = "callback";
	
	public final static String REQUEST_MIRNA = "mirna";
	public final static String REQUEST_SIRNA = "sirna";
	public final static String REQUEST_DISEASE = "disease";
	public final static String REQUEST_DISEASE_1 = "disease_1";	
	public final static String REQUEST_TISSUE = "tissue";
	public final static String REQUEST_OMIM_NODE_TARGET = "omim_node_target";
	public final static String REQUEST_OMIM_NODE_1 = "omim_node_1";
	public final static String REQUEST_OMIM_NODE_2 = "omim_node_2";
	public final static String REQUEST_OMIM_ID = "omim_id";
	public final static String REQUEST_TUMOR_TYPE = "tumor_type";
	public final static String REQUEST_KEGG = "kegg";
	public final static String REQUEST_RANKING = "ranking";
	public final static String REQUEST_RULE_TARGET = "role_target";
	public final static String REQUEST_RULE_LEVEL_1 = "role_level_1";
	public final static String REQUEST_RULE_LEVEL_2 = "role_level_2";
	public final static String REQUEST_TF_TARGET = "tf_target";
	public final static String REQUEST_TF_LEVEL_1 = "tf_level_1";
	public final static String REQUEST_TF_LEVEL_2 = "tf_level_2";
	public final static String REQUEST_RC_TARGET = "rc_target";
	public final static String REQUEST_RC_LEVEL_1 = "rc_level_1";
	public final static String REQUEST_RC_LEVEL_2 = "rc_level_2";
	public final static String REQUEST_PVALUE = "pvalue";
	
	
	public final static String REQUEST_DISEASE_2 = "disease_2";
	public final static String REQUEST_TISSUE2 = "tissue2";
	public final static String REQUEST_OMIM_NODE_TARGET_2 = "omim_node_target_2";
	public final static String REQUEST_OMIM_NODE_1_2 = "omim_node_1_2";
	public final static String REQUEST_OMIM_NODE_2_2 = "omim_node_2_2";
	public final static String REQUEST_OMIM_ID_2 = "omim_id_2";
	public final static String REQUEST_TUMOR_TYPE_2 = "tumor_type_2";
	public final static String REQUEST_KEGG2 = "kegg2";
	public final static String REQUEST_RANKING2 = "ranking2";
	public final static String REQUEST_RULE_TARGET_2 = "role_target_2";
	public final static String REQUEST_RULE_LEVEL_1_2 = "role_level_1_2";
	public final static String REQUEST_RULE_LEVEL_2_2 = "role_level_2_2";
	public final static String REQUEST_TF_TARGET_2 = "tf_target_2";
	public final static String REQUEST_TF_LEVEL_1_2 = "tf_level_1_2";
	public final static String REQUEST_TF_LEVEL_2_2 = "tf_level_2_2";
	public final static String REQUEST_RC_TARGET_2 = "rc_target_2";
	public final static String REQUEST_RC_LEVEL_1_2 = "rc_level_1_2";
	public final static String REQUEST_RC_LEVEL_2_2 = "rc_level_2_2";
	public final static String REQUEST_PVALUE2 = "pvalue2";
	
	public final static String RANKING_MF = "molecular_function";
	public final static String RANKING_BP = "biological_process";
	
	public final static String RESULT_DISEASE = "result_disease";
	public final static String RESULT_SUBPATHWAY = "subpathway";
	public final static String RESULT_NETWORK = "network";
	public final static String RESULT_NETWORK_STYLE = "network_style";
	public final static String RESULT_NETWORK_GENE_SIZE = "network_gene_size";
	
	public final static String RESULT_ASSOCIATED_MIRNAS = "associated_mirnas";
	public final static String RESULT_ASSOCIATED_DISEASE_1_MIRNAS = "associated_disease_1_mirnas";
	public final static String RESULT_ASSOCIATED_DISEASE_2_MIRNAS = "associated_disease_2_mirnas";
	public final static String RESULT_ASSOCIATED_TARGET_GENE = "associated_target_gene";
	public final static String RESULT_ASSOCIATED_TARGET_GENE_GO = "associated_go";
	public final static String RESULT_COMORBIDITY_GENE = "comorbidity_gene";
	
	public final static String RESULT_ASSOCIATED_MIRNAS_MIRNA = "associated_mirnas_mirna";
	public final static String RESULT_ASSOCIATED_MIRNAS_PUBMED = "associated_mirnas_pubmed";
	
	
	public final static String RESULT_MIRNA = "mirna";
	public final static String RESULT_MIRNA_SEQ = "mirna_seq";
	
	
	public final static String RESULT_MF_GO = "molecular_function";
	public final static String RESULT_BP_GO = "biological_process";
	public final static String RESULT_CC_GO = "cellular_component";
	public final static String RESULT_GO = "go_term";
	public final static String RESULT_GO_SIZE = "size";
	public final static String RESULT_GO_NAME = "go_name";
	
	
	
	public final static String RESULT_SUBPATYWAY_NO = "no";
	public final static String RESULT_SUBPATYWAY_MIRNA = "mirna";
	public final static String RESULT_SUBPATYWAY_TARGET_GENE = "target_gene";
	public final static String RESULT_SUBPATYWAY_GENE_ONE = "gene_one";
	public final static String RESULT_SUBPATYWAY_GENE_TWO = "gene_two";
	public final static String RESULT_SUBPATYWAY_KEGG = "kegg";
	public final static String RESULT_SUBPATYWAY_PVALUE = "pvalue";
	
		
	public final static String CYTOSCAPE_DATA_SCHEMA = "dataSchema";
	public final static String CYTOSCAPE_DATA = "data";
	public final static String CYTOSCAPE_NODES = "nodes";
	public final static String CYTOSCAPE_EDGES = "edges";
	public final static String CYTOSCAPE_NAME = "name";
	public final static String CYTOSCAPE_TYPE = "type";
	public final static String CYTOSCAPE_ID = "id";
	public final static String CYTOSCAPE_SHAPE = "shape";
	public final static String CYTOSCAPE_LABEL = "label";
	public final static String CYTOSCAPE_TARGET = "target";
	public final static String CYTOSCAPE_SOURCE = "source";
	public final static String CYTOSCAPE_ATTR_NAME = "attrName";
	public final static String CYTOSCAPE_PASS_THROUGH_MAPPER = "passthroughMapper";
	public final static String CYTOSCAPE_BORDER_WIDTH = "borderWidth";
	public final static String CYTOSCAPE_BORDER_COLOR = "borderColor";
	public final static String CYTOSCAPE_DEFAULT_VALUE = "defaultValue";
	public final static String CYTOSCAPE_CONTINUOUS_MAPPER = "continuousMapper";
	public final static String CYTOSCAPE_MIN_VALUE = "minValue";
	public final static String CYTOSCAPE_MAX_VALUE = "maxValue";
	public final static String CYTOSCAPE_SIZE = "size";
	public final static String CYTOSCAPE_ATTR_VALUE = "attrValue";
	public final static String CYTOSCAPE_VALUE = "value";
	public final static String CYTOSCAPE_ENTRIES = "entries";
	public final static String CYTOSCAPE_DISCRETE_MAPPER = "discreteMapper";
	public final static String CYTOSCAPE_COLOR = "color";
	public final static String CYTOSCAPE_LABEL_HORIZONTAL_ANCHOR = "labelHorizontalAnchor";
	public final static String CYTOSCAPE_TOOL_TIP_TEXT = "tooltipText";
	public final static String CYTOSCAPE_TOOL_TIP_TEXT_SIZE = "tooltipFontSize";
	public final static String CYTOSCAPE_BACK_GROUND_COLOR = "backgroundColor";
	public final static String CYTOSCAPE_LABEL_FONT_COLOR = "labelFontColor";
	public final static String CYTOSCAPE_TOOL_TIP_DELAY = "tooltipDelay";
	public final static String CYTOSCAPE_GLOBAL = "global";
	public final static String CYTOSCAPE_WIDTH = "width";
	public final static String CYTOSCAPE_WEIGHT = "weight";
	
	public final static String CYTOSCAPE_OMIM = "omim";
	public final static String CYTOSCAPE_CANCEROUS = "cancerous";
	public final static String CYTOSCAPE_KEGG = "kegg";
	public final static String CYTOSCAPE_CELLULAR_COMPONENT = "cellular";
	public final static String CYTOSCAPE_BIOLOGICAL_PROCESS = "biological";
	public final static String CYTOSCAPE_MOLECULAR_FUNCTION = "molecular";
	
	
	public final static String CYTOSCAPE_SHAPE_TYPE_ELLIPSE = "ELLIPSE";
	public final static String CYTOSCAPE_SHAPE_TYPE_RECTANGLE = "RECTANGLE";
	public final static String CYTOSCAPE_SHAPE_TYPE_TRIANGLE = "TRIANGLE";
	public final static String CYTOSCAPE_SHAPE_TYPE_DIAMOND = "DIAMOND";
	public final static String CYTOSCAPE_SHAPE_TYPE_HEXAGON = "HEXAGON";
	public final static String CYTOSCAPE_SHAPE_TYPE_OCTAGON = "OCTAGON";
	public final static String CYTOSCAPE_SHAPE_TYPE_PARALLELOGRAM = "PARALLELOGRAM";
	public final static String CYTOSCAPE_SHAPE_TYPE_ROUNDRECT = "ROUNDRECT";
	public final static String CYTOSCAPE_SHAPE_TYPE_VEE = "VEE";
	
	
	
	public final static int CYTOSCAPE_ROLE_NORMAL_NODE = 0;
	public final static int CYTOSCAPE_ROLE_MIRNA = 1;
	public final static int CYTOSCAPE_ROLE_TARGET_NODE = 2;
	
	public final static int CYTOSCAPE_DISEASE_GENE_ROLE_1 = 1;
	public final static int CYTOSCAPE_DISEASE_GENE_ROLE_2 = 2;
	public final static int CYTOSCAPE_DISEASE_GENE_ROLE_BOTH = 3;
}
