<?php
$TOKEN = "B481A5E1D39B47FDF9DBEB8A13F786A4";

?>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>miRDRN</title>
<style type="text/css">
body,td,th {
	font-family: Arial, Helvetica, sans-serif;
}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<link href="style/main.css" rel="stylesheet" type="text/css">
<style type="text/css">
hr.style7 {border-top: 1px solid #8c8b8b;
	border-bottom: 1px solid #fff;
}
</style>
<script type="text/javascript" src="./js/jquery-1.10.2.min.js"></script>
<script src="./js/jquery-ui.min.js"></script>
<script src="./js/jquery.blockUI.js"></script>
<script type="text/javascript" src="./js/src/json2.js"></script>
<script type="text/javascript" src="./js/src/AC_OETags.js"></script>
<script type="text/javascript" src="./js/src/cytoscapeweb.js"></script>
<script type="text/javascript" src="./jscolor/jscolor.js"></script>
<script type="text/javascript" src="./js/mirnaservice.js"></script>
<script src="./js/jquery.generateFile.js"></script>
</head>

<body>
<?php require 'header.php'; ?> 
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="660"><table width="1024" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center"><table width="740" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td align="center"><a href="disease_service.php"><img src="img/ncRANppi_icon_diease_off.png" name="disease" width="101" height="111" id="disease"></a></td>
            <td align="center"><a href="#"><img src="img/ncRANppi_icon_mirna_on.png" name="mirna" width="101" height="111" id="mirna"></a></td>
            <td align="center"><a href="sirna_service.php"><img src="img/ncRANppi_icon_sirna_off.png" name="sirna" width="101" height="111" id="sirna"></a></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td align="center">&nbsp;</td>
      </tr>
      <tr>
        <td align="center"><table width="558" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="45">&nbsp;</td>
            <td>&nbsp;</td>
            <td width="45">&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td align="center">
              <label for="mirna_term"></label>            
              <select name="mirna_term" id="mirna_term" Style="font-size:13pt;height:25px;background: transparent;overflow:hidden;" class="table_text">
                <option value="" selected="SELECTED">---------------------- Select one miRNA -------------------</option>
                <option value="hsa-edited-mir-376a-5p">hsa-edited-mir-376a-5p</option>
<option value="hsa-hsv1-mir-lat">hsa-hsv1-mir-lat</option>
<option value="hsa-let-7">hsa-let-7</option>
<option value="hsa-let-7a">hsa-let-7a</option>
<option value="hsa-let-7b">hsa-let-7b</option>
<option value="hsa-let-7c">hsa-let-7c</option>
<option value="hsa-let-7e">hsa-let-7e</option>
<option value="hsa-let-7g">hsa-let-7g</option>
<option value="hsa-mir-1">hsa-mir-1</option>
<option value="hsa-mir-101">hsa-mir-101</option>
<option value="hsa-mir-103">hsa-mir-103</option>
<option value="hsa-mir-103-1">hsa-mir-103-1</option>
<option value="hsa-mir-106a">hsa-mir-106a</option>
<option value="hsa-mir-106b">hsa-mir-106b</option>
<option value="hsa-mir-107">hsa-mir-107</option>
<option value="hsa-mir-10a">hsa-mir-10a</option>
<option value="hsa-mir-10b">hsa-mir-10b</option>
<option value="hsa-mir-122">hsa-mir-122</option>
<option value="hsa-mir-122a">hsa-mir-122a</option>
<option value="hsa-mir-124">hsa-mir-124</option>
<option value="hsa-mir-124a">hsa-mir-124a</option>
<option value="hsa-mir-125a">hsa-mir-125a</option>
<option value="hsa-mir-125b">hsa-mir-125b</option>
<option value="hsa-mir-126">hsa-mir-126</option>
<option value="hsa-mir-127">hsa-mir-127</option>
<option value="hsa-mir-128">hsa-mir-128</option>
<option value="hsa-mir-129">hsa-mir-129</option>
<option value="hsa-mir-130">hsa-mir-130</option>
<option value="hsa-mir-130a">hsa-mir-130a</option>
<option value="hsa-mir-132">hsa-mir-132</option>
<option value="hsa-mir-133">hsa-mir-133</option>
<option value="hsa-mir-133a">hsa-mir-133a</option>
<option value="hsa-mir-133b">hsa-mir-133b</option>
<option value="hsa-mir-136">hsa-mir-136</option>
<option value="hsa-mir-138">hsa-mir-138</option>
<option value="hsa-mir-140">hsa-mir-140</option>
<option value="hsa-mir-141">hsa-mir-141</option>
<option value="hsa-mir-143">hsa-mir-143</option>
<option value="hsa-mir-145">hsa-mir-145</option>
<option value="hsa-mir-148">hsa-mir-148</option>
<option value="hsa-mir-15">hsa-mir-15</option>
<option value="hsa-mir-150">hsa-mir-150</option>
<option value="hsa-mir-155">hsa-mir-155</option>
<option value="hsa-mir-15a">hsa-mir-15a</option>
<option value="hsa-mir-15b">hsa-mir-15b</option>
<option value="hsa-mir-16">hsa-mir-16</option>
<option value="hsa-mir-17-5p">hsa-mir-17-5p</option>
<option value="hsa-mir-181">hsa-mir-181</option>
<option value="hsa-mir-181b">hsa-mir-181b</option>
<option value="hsa-mir-189">hsa-mir-189</option>
<option value="hsa-mir-192">hsa-mir-192</option>
<option value="hsa-mir-196">hsa-mir-196</option>
<option value="hsa-mir-199a">hsa-mir-199a</option>
<option value="hsa-mir-199b">hsa-mir-199b</option>
<option value="hsa-mir-19a">hsa-mir-19a</option>
<option value="hsa-mir-19b">hsa-mir-19b</option>
<option value="hsa-mir-19b-2">hsa-mir-19b-2</option>
<option value="hsa-mir-1b">hsa-mir-1b</option>
<option value="hsa-mir-20">hsa-mir-20</option>
<option value="hsa-mir-200a">hsa-mir-200a</option>
<option value="hsa-mir-200b">hsa-mir-200b</option>
<option value="hsa-mir-200c">hsa-mir-200c</option>
<option value="hsa-mir-206">hsa-mir-206</option>
<option value="hsa-mir-20a">hsa-mir-20a</option>
<option value="hsa-mir-20b">hsa-mir-20b</option>
<option value="hsa-mir-21">hsa-mir-21</option>
<option value="hsa-mir-210">hsa-mir-210</option>
<option value="hsa-mir-214">hsa-mir-214</option>
<option value="hsa-mir-221">hsa-mir-221</option>
<option value="hsa-mir-222">hsa-mir-222</option>
<option value="hsa-mir-223">hsa-mir-223</option>
<option value="hsa-mir-224">hsa-mir-224</option>
<option value="hsa-mir-23">hsa-mir-23</option>
<option value="hsa-mir-23a">hsa-mir-23a</option>
<option value="hsa-mir-23b">hsa-mir-23b</option>
<option value="hsa-mir-24">hsa-mir-24</option>
<option value="hsa-mir-26">hsa-mir-26</option>
<option value="hsa-mir-26a">hsa-mir-26a</option>
<option value="hsa-mir-27a">hsa-mir-27a</option>
<option value="hsa-mir-27b">hsa-mir-27b</option>
<option value="hsa-mir-29">hsa-mir-29</option>
<option value="hsa-mir-29a">hsa-mir-29a</option>
<option value="hsa-mir-29b">hsa-mir-29b</option>
<option value="hsa-mir-29b-1">hsa-mir-29b-1</option>
<option value="hsa-mir-29c">hsa-mir-29c</option>
<option value="hsa-mir-302a">hsa-mir-302a</option>
<option value="hsa-mir-30a-3p">hsa-mir-30a-3p</option>
<option value="hsa-mir-32">hsa-mir-32</option>
<option value="hsa-mir-34">hsa-mir-34</option>
<option value="hsa-mir-34a">hsa-mir-34a</option>
<option value="hsa-mir-370">hsa-mir-370</option>
<option value="hsa-mir-372">hsa-mir-372</option>
<option value="hsa-mir-373">hsa-mir-373</option>
<option value="hsa-mir-375">hsa-mir-375</option>
<option value="hsa-mir-376a-5p">hsa-mir-376a-5p</option>
<option value="hsa-mir-378">hsa-mir-378</option>
<option value="hsa-mir-429">hsa-mir-429</option>
<option value="hsa-mir-431">hsa-mir-431</option>
<option value="hsa-mir-433">hsa-mir-433</option>
<option value="hsa-mir-433-3p">hsa-mir-433-3p</option>
<option value="hsa-mir-433-5p">hsa-mir-433-5p</option>
<option value="hsa-mir-434-3p">hsa-mir-434-3p</option>
<option value="hsa-mir-434-5p">hsa-mir-434-5p</option>
<option value="hsa-mir-520h">hsa-mir-520h</option>
<option value="hsa-mir-9">hsa-mir-9</option>
<option value="hsa-mir-92-2">hsa-mir-92-2</option>
<option value="hsa-mir-98">hsa-mir-98</option>
<option value="hsa-lna_let-7b">hsa-lna_let-7b</option>
<option value="hsa-mir-30">hsa-mir-30</option>
                </select>           
            </td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td align="center"><table width="740" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="11" height="25" background="./img/fram_upper_left.png">&nbsp;</td>
            <td width="718" height="25" background="./img/fram_top.png"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="3%">&nbsp;</td>
                <td width="7%" align="center" bgcolor="#FFFFFF" class="table_title">Filter</td>
                <td width="90%">&nbsp;</td>
              </tr>
            </table></td>
            <td width="11" height="25" background="./img/fram_upper_right.png">&nbsp;</td>
          </tr>
          <tr>
            <td width="11" background="./img/fram_side.png">&nbsp;</td>
            <td width="718" align="center"><table width="98%" border="0" cellspacing="1" cellpadding="0">
              <tr>
                <td width="37%" height="26" align="right" bgcolor="#F0F1F4" class="table_text">Tissue/Tumor type :</td>
                <td width="63%" bgcolor="#F0F1F4" class="table_text"><select name="tissue" class="table_text" id="tissue" >
                  <option value="" selected="selected">--- Tissue types ---</option>
                  <option value="adult">adult</option>
                  <option value="adipose tissue">adipose tissue</option>
                  <option value="adrenal gland">adrenal gland</option>
                  <option value="ascites">ascites</option>
                  <option value="bladder">bladder</option>
                  <option value="blood">blood</option>
                  <option value="bone">bone</option>
                  <option value="bone marrow">bone marrow</option>
                  <option value="brain">brain</option>
                  <option value="blastocyst">blastocyst</option>
                  <option value="cervix">cervix</option>
                  <option value="connective tissue">connective tissue</option>
                  <option value="ear">ear</option>
                  <option value="embryonic tissue">embryonic tissue</option>
                  <option value="eye">eye</option>
                  <option value="esophagus">esophagus</option>
                  <option value="embryoid body">embryoid body</option>
                  <option value="fetus">fetus</option>
                  <option value="heart">heart</option>
                  <option value="infant">infant</option>
                  <option value="intestine">intestine</option>
                  <option value="juvenile">juvenile</option>
                  <option value="kidney">kidney</option>
                  <option value="larynx">larynx</option>
                  <option value="liver">liver</option>
                  <option value="lung">lung</option>
                  <option value="lymph">lymph</option>
                  <option value="lymph node">lymph node</option>
                  <option value="mammary gland">mammary gland</option>
                  <option value="mouth">mouth</option>
                  <option value="muscle">muscle</option>
                  <option value="neonate">neonate</option>
                  <option value="nerve">nerve</option>
                  <option value="ovary">ovary</option>
                  <option value="pancreas">pancreas</option>
                  <option value="parathyroid">parathyroid</option>
                  <option value="pharynx">pharynx</option>
                  <option value="placenta">placenta</option>
                  <option value="prostate">prostate</option>
                  <option value="pituitary gland">pituitary gland</option>
                  <option value="salivary gland">salivary gland</option>
                  <option value="skin">skin</option>
                  <option value="spleen">spleen</option>
                  <option value="stomach">stomach</option>
                  <option value="trachea">trachea</option>
                  <option value="testis">testis</option>
                  <option value="thymus">thymus</option>
                  <option value="thyroid">thyroid</option>
                  <option value="tonsil">tonsil</option>
                  <option value="umbilical cord">umbilical cord</option>
                  <option value="uterus">uterus</option>
                  <option value="vascular">vascular</option>
                  <option value="">--- Tumor types ---</option>
                  <option value="adrenal tumor">adrenal tumor</option>
                  <option value="bladder carcinoma">bladder carcinoma</option>
                  <option value="breast (mammary gland) tumor">breast (mammary gland) tumor</option>
                  <option value="cervical tumor">cervical tumor</option>
                  <option value="colorectal tumor">colorectal tumor</option>
                  <option value="chondrosarcoma">chondrosarcoma</option>
                  <option value="esophageal tumor">esophageal tumor</option>
                  <option value="gastrointestinal tumor">gastrointestinal tumor</option>
                  <option value="germ cell tumor">germ cell tumor</option>
                  <option value="glioma">glioma</option>
                  <option value="head and neck tumor">head and neck tumor</option>
                  <option value="kidney tumor">kidney tumor</option>
                  <option value="leukemia">leukemia</option>
                  <option value="liver tumor">liver tumor</option>
                  <option value="lung tumor">lung tumor</option>
                  <option value="lymphoma">lymphoma</option>
                  <option value="non-neoplasia">non-neoplasia</option>
                  <option value="normal">normal</option>
                  <option value="ovarian tumor">ovarian tumor</option>
                  <option value="pancreatic tumor">pancreatic tumor</option>
                  <option value="primitive neuroectodermal tumor of the CNS">primitive neuroectodermal tumor of the CNS</option>
                  <option value="prostate cancer">prostate cancer</option>
                  <option value="retinoblastoma">retinoblastoma</option>
                  <option value="skin tumor">skin tumor</option>
                  <option value="soft tissue/muscle tissue tumor">soft tissue/muscle tissue tumor</option>
                  <option value="uterine tumor">uterine tumor</option>
                </select></td>
              </tr>
              <tr>
                <td height="26" align="right" bgcolor="#FFFFFF" class="table_text">Common expression of target gene, gene 1 and gene 2 nodes in KEGG (optional):</td>
                <td bgcolor="#FFFFFF" class="table_text"><p>
                  <label>
  &nbsp;<input type="checkbox" name="common_pathway" id="common_pathway">
                    Yes</label>
                  &nbsp;<br>
                  </p></td>
              </tr>
              <tr>
                <td height="26" bgcolor="#F0F1F4" class="table_text">&nbsp;</td>
                <td bgcolor="#F0F1F4" class="table_text"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="35%" align="center">Target Gene</td>
                    <td width="32%" align="center">Gene 1</td>
                    <td width="33%" align="center">Gene 2</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="26" align="right" bgcolor="#FFFFFF" class="table_text">
                	Selection of cancerous protein (optional):<br>
                    <span style="color:#CC6600; font-size:12px;">
                    Cancer related gene&nbsp;(CRG)<br>
                    Oncogene&nbsp;(OCG)<br>
                    Tumor suppressor gene&nbsp;(TSG)
                    </span> 
                </td>
                <td bgcolor="#FFFFFF" class="table_text"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="35%" align="center"><label for="cancerous1"></label>
                      <select name="cancerous1" id="cancerous1" class="table_text">
                        <option value="" selected="SELECTED"></option>
                        <option value="1">CRG</option>
                        <option value="2">OCG</option>
                        <option value="3">TSG</option>
                      </select></td>
                    <td width="32%" align="center"><select name="cancerous2" id="cancerous2" class="table_text">
                      <option value="" selected></option>
                      <option value="1">CRG</option>
                      <option value="2">OCG</option>
                      <option value="3">TSG</option>
                    </select></td>
                    <td width="33%" align="center"><select name="cancerous3" id="cancerous3" class="table_text">
                      <option value="" selected></option>
                      <option value="1">CRG</option>
                      <option value="2">OCG</option>
                      <option value="3">TSG</option>
                    </select></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="26" align="right" bgcolor="#F0F1F4"><span class="table_text">Filter out receptor protein (optional):</span></td>
                <td bgcolor="#F0F1F4"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="35%" align="center"><input type="checkbox" name="receptor1" id="receptor1">
                      <label for="receptor1"></label></td>
                    <td width="32%" align="center"><input type="checkbox" name="receptor2" id="receptor2"></td>
                    <td width="33%" align="center"><input type="checkbox" name="receptor3" id="receptor3"></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="26" align="right" bgcolor="#FFFFFF" class="table_text">Selectoin of  transcription factor (optional):</td>
                <td bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="35%" align="center"><input type="checkbox" name="transcription1" id="transcription1"></td>
                    <td width="32%" align="center"><input type="checkbox" name="transcription2" id="transcription2"></td>
                    <td width="33%" align="center"><input type="checkbox" name="transcription3" id="transcription3"></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="26" align="right" class="table_text" bgcolor="#F0F1F4">Pathway ranking by:</td>
                <td bgcolor="#F0F1F4"><label for="pvalue"></label>
                  <span class="table_text">&nbsp;
                  <label for="ranking"></label>
                  <select name="ranking" id="ranking" class="table_text">
                    <option value="molecular_function" selected="selected" >Jaccard index (MF)</option>
                    <option value="biological_process">Jaccard index (BP)</option>
                  </select>
                  p-value&nbsp;&lt</span> 
                  <input name="pvalue" type="text" id="pvalue" size="12">
                  <span class="table_text">(ex:0.001)</span></td>
              </tr>
              <tr>
                <td height="26" bgcolor="#FFFFFF" >&nbsp;</td>
                <td bgcolor="#FFFFFF">&nbsp;</td>
              </tr>
            </table></td>
            <td width="11" background="./img/fram_side.png">&nbsp;</td>
          </tr>
          <tr>
            <td width="11" height="25" background="./img/fram_lower_left.png">&nbsp;</td>
            <td width="718" height="25" background="./img/fram_bottom.png">&nbsp;</td>
            <td width="11" height="25" background="./img/fram_lower_right.png">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td align="center"><a href="#"><img src="img/ncRANppi_butten_query_off_long.png" name="query" width="186" height="25" id="query"></a></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center" bgcolor="#96CDED" id="associated_mirnas_viewer"><table width="1024" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td align="center"><table width="963" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>&nbsp;</td>
            <td height="25" class="sub_title">miRNA Information</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td width="11" background="./img/fram_upper_left.png">&nbsp;</td>
            <td width="941" height="25" background="./img/fram_top.png">&nbsp;</td>
            <td width="11" background="./img/fram_upper_right.png">&nbsp;</td>
          </tr>
          <tr>
            <td width="11" background="./img/fram_side.png">&nbsp;</td>
            <td align="center"><table width="96%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="1%">&nbsp;</td>
                <td><table width="100%" border="0" cellspacing="1" cellpadding="0" id="associated_mirnas">                  
                  </table></td>
                <td width="1%">&nbsp;</td>
                </tr>
              </table></td>
            <td width="11" background="./img/fram_side.png">&nbsp;</td>
          </tr>
          <tr>
            <td width="11" background="./img/fram_lower_left.png">&nbsp;</td>
            <td height="25" background="./img/fram_bottom.png">&nbsp;</td>
            <td width="11" background="./img/fram_lower_right.png">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td align="center">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center" bgcolor="#85E58E" id="target_gene_viewer"><table width="1024" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td align="center"><table width="963" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>&nbsp;</td>
            <td height="25" class="sub_title">Target genes by miRNA</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td width="11" background="./img/fram_upper_left.png">&nbsp;</td>
            <td width="941" height="25" background="./img/fram_top.png">&nbsp;</td>
            <td width="11" background="./img/fram_upper_right.png">&nbsp;</td>
          </tr>
          <tr>
            <td background="./img/fram_side.png">&nbsp;</td>
            <td align="center"><table width="96%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="1%">&nbsp;</td>
                <td><table width="100%" border="0" cellspacing="1" cellpadding="0" id="associated_mirnas5">
                </table>
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td class="text_item" id="target_gene_total">Total:</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td align="right" class="text_item">&nbsp;</td>
                    </tr>
                  </table></td>
                <td width="1%">&nbsp;</td>
              </tr>
            </table></td>
            <td background="./img/fram_side.png">&nbsp;</td>
          </tr>
          <tr>
            <td background="./img/fram_side.png">&nbsp;</td>
            <td align="center">&nbsp;</td>
            <td background="./img/fram_side.png">&nbsp;</td>
          </tr>
          <tr>
            <td width="11" background="./img/fram_side.png">&nbsp;</td>
            <td align="center"><table width="96%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="1%">&nbsp;</td>
                <td>
                <table width="100%" border="0" cellspacing="1" cellpadding="0" id="target_gene">
                </table>
                </td>
                <td width="1%">&nbsp;</td>
              </tr>
            </table></td>
            <td width="11" background="./img/fram_side.png">&nbsp;</td>
          </tr>
          <tr>
            <td width="11" background="./img/fram_lower_left.png">&nbsp;</td>
            <td height="25" background="./img/fram_bottom.png">&nbsp;</td>
            <td width="11" background="./img/fram_lower_right.png">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td align="center">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center" bgcolor="#E0CE86" id="subpathway_viewer"><table width="1024" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td align="center"><table width="963" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>&nbsp;</td>
            <td height="25" class="sub_title"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="50%" align="left">miRNA regulatory sub-pathways</td>
                <td width="50%" align="right">
                <label for="export_type"></label>
                  <select name="export_type" id="export_type">
                    <option value="1" selected="selected">All pathways</option>
                    <option value="2">Filtered pathways</option>
                  </select> 
                <input type="submit" name="export" id="export" value="Export Data">
                </td>
              </tr>
            </table></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td width="11" background="./img/fram_upper_left.png">&nbsp;</td>
            <td width="941" height="25" background="./img/fram_top.png">&nbsp;</td>
            <td width="11" background="./img/fram_upper_right.png">&nbsp;</td>
          </tr>
          <tr>
            <td background="./img/fram_side.png">&nbsp;</td>
            <td align="center"><table width="96%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="1%">&nbsp;</td>
                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="55%" align="left" class="text_item" id="subpathway_total">Total:</td>
                    <td width="15%">&nbsp;</td>
                    <td width="9%">&nbsp;</td>
                    <td width="21%" align="right">&nbsp;</td>
                  </tr>
                </table></td>
                <td width="1%">&nbsp;</td>
              </tr>
            </table></td>
            <td background="./img/fram_side.png">&nbsp;</td>
          </tr>
          <tr>
            <td background="./img/fram_side.png">&nbsp;</td>
            <td align="center">&nbsp;</td>
            <td background="./img/fram_side.png">&nbsp;</td>
          </tr>
          <tr>
            <td background="./img/fram_side.png">&nbsp;</td>
            <td align="center"><table width="96%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="1%">&nbsp;</td>
                <td><table width="100%">
                  <tr>
                    <td width="8%" align="left" class="text_item">List view: </td>
                    <td colspan="2" align="left" class="text_item">Gene filter
                      <input name="genefilter" id="genefilter" type="text">
                      (Please input a gene symbol, ex:BCL2),</td>
                  </tr>
                  <tr>
                    <td width="8%" align="left" class="text_item"></td>
                    <td width="54%" align="left" class="text_item">Sort by
                      <select name="view_sorting" id="view_sorting">
                        <option value="1" selected="selected">P-Value</option>
                        <option value="2">Symbol (TG)</option>
                      </select>
                      ,&nbsp;Show&nbsp;top
                      <label for="subview_top"></label>
                      <input type="text" name="subview_top" id="subview_top" style="width:70px">
                      &nbsp;sub-pathways&nbsp;
                      <input type="submit" name="subview_top_button" id="subview_top_button" value="GO"></td>
                    <td width="38%" align="left" class="text_item" id="sub_number">&nbsp;</td>
                  </tr>
                </table></td>
                <td width="1%">&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="61%" align="left" class="text_item">&nbsp;</td>
                    <td width="20%" class="text_item"></td>
                    <td width="2%">&nbsp;</td>
                    <td width="17%" align="right" class="text_item_tb"><a href="#" id="sub_pre" onclick="PrevSubpathway(); return false;">&lt;&lt; Prev</a> | <a href="#" id="sub_next" onclick="NextSubpathway(); return false;">Next &gt;&gt;</a></td>
                  </tr>
                </table></td>
                <td>&nbsp;</td>
              </tr>
            </table></td>
            <td background="./img/fram_side.png">&nbsp;</td>
          </tr>
          <tr>
            <td background="./img/fram_side.png">&nbsp;</td>
            <td align="center"><table width="96%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="1%">&nbsp;</td>
                <td><hr class="style7"></td>
                <td width="1%">&nbsp;</td>
              </tr>
            </table></td>
            <td background="./img/fram_side.png">&nbsp;</td>
          </tr>
          <tr>
            <td background="./img/fram_side.png">&nbsp;</td>
            <td align="center">&nbsp;</td>
            <td background="./img/fram_side.png">&nbsp;</td>
          </tr>
          <tr>
            <td width="11" background="./img/fram_side.png">&nbsp;</td>
            <td align="center"><table width="96%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="1%">&nbsp;</td>
                <td><table width="100%" border="0" cellspacing="1" cellpadding="0" id="subpathway">
                </table></td>
                <td width="1%">&nbsp;</td>
              </tr>
            </table></td>
            <td width="11" background="./img/fram_side.png">&nbsp;</td>
          </tr>
          <tr>
            <td width="11" background="./img/fram_lower_left.png">&nbsp;</td>
            <td height="25" background="./img/fram_bottom.png">&nbsp;</td>
            <td width="11" background="./img/fram_lower_right.png">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td align="center">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center" bgcolor="#DDAE85" id="network_viewer"><table width="90%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td align="center"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>&nbsp;</td>
            <td height="25" class="sub_title">Disease specific miRNAs regulatory network</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td width="11">&nbsp;</td>
            <td width="941" height="25" background="./img/fram_top.png">&nbsp;</td>
            <td width="11">&nbsp;</td>
          </tr>
          <tr>
            <td width="11">&nbsp;</td>
            <td align="center"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td>&nbsp;</td>
                <td align="left"><img src="img/labele1.png" width="473" height="54"></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="5%" class="text_item"><strong>Layout&nbsp;: </strong></td>
                    <td width="90%" align="left"><form name="form1" method="post" action="">
                      <label for="network_layout"></label>
                      <select name="network_layout" id="network_layout" class="table_text">
                        <option value="0" selected="selected">==== Select one layout for your network display ====</option>
                        <option value="Tree">Tree</option>
                        <option value="Circle">Circle</option>
                        <option value="Radial">Radial</option>
                      </select>
                    </form></td>
                    <td width="5%" align="left">&nbsp;</td>
                  </tr>
                </table></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td align="left" class="text_item">(If you re-setting the sub-pathways list view, please select this layout again)</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td width="1%">&nbsp;</td>
                <td><table width="100%" border="0" cellspacing="1" cellpadding="0">
                  <tr>
                    <td width="100%" height="868" colspan="2" align="center" bgcolor="#FFFFFF" id="cytoscapeweb">Your disease network will be displayed after your layout choosing.</td>
                  </tr>
                </table></td>
                <td width="1%">&nbsp;</td>
              </tr>
            </table></td>
            <td width="11">&nbsp;</td>
          </tr>
          <tr>
            <td width="11">&nbsp;</td>
            <td height="25" background="./img/fram_bottom.png">&nbsp;</td>
            <td width="11">&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td height="25" align="center"><table width="96%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="1%">&nbsp;</td>
                <td align="center"><table width="963" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td>&nbsp;</td>
                    <td height="25" class="sub_title">Information for selected node:</td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td width="11" background="./img/fram_upper_left.png">&nbsp;</td>
                    <td width="941" height="25" background="./img/fram_top.png">&nbsp;</td>
                    <td width="11" background="./img/fram_upper_right.png">&nbsp;</td>
                  </tr>
                  <tr>
                    <td background="./img/fram_side.png">&nbsp;</td>
                    <td align="center"><table width="96%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="1%">&nbsp;</td>
                        <td align="center"><table width="900" border="0" cellspacing="1" cellpadding="0">
                          <tr>
                            <td width="160" class="text_item_tb">Gene:</td>
                            <td width="740" bgcolor="#FFFFFF" id="network_gene">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="text_item_tb">Cancerous protein:</td>
                            <td valign="middle" bgcolor="#FFFFFF" id="network_cancerous">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="text_item_tb">OMIM ID:</td>
                            <td bgcolor="#FFFFFF" id="network_omim">&nbsp;</td>
                          </tr>
                          <tr>
                            <td valign="top" class="text_item_tb">KEGG pathway:</td>
                            <td align="left" valign="top" bgcolor="#FFFFFF" style="height:100px;overflow:auto;"><div id="network_pathway" style="height:100px;overflow:auto;"></div></td>
                          </tr>
                          <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                          </tr>
                          <tr>
                            <td colspan="2"><table width="900" border="0" cellspacing="0" cellpadding="0">
                              <tr height="32">
                                <td align="left" valign="bottom"><table width="900" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td height="30" align="center" bgcolor="#CF8F56" id="go_cc_b"><a id="go_cc" href="#" class="linka">Cellular component</a></td>
                                    <td align="center" id="go_bp_b"><a id="go_bp" href="#" class="linka">Biological process</a></td>
                                    <td align="center" id="go_mf_b"><a id="go_mf" href="#" class="linka">Molecular function</a></td>
                                  </tr>
                                </table></td>
                              </tr>
                              <tr>
                                <td bgcolor="#CF8F56" style="height:240px;overflow:auto;"><div id="network_cc" style="height:240px;overflow:auto;"></div>
                                  <div id="network_bp" style="height:240px;overflow:auto;"></div>
                                  <div id="network_mf" style="height:240px;overflow:auto;"></div></td>
                              </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                          </tr>
                        </table></td>
                        <td width="1%">&nbsp;</td>
                      </tr>
                    </table></td>
                    <td background="./img/fram_side.png">&nbsp;</td>
                  </tr>
                  <tr>
                    <td width="11" background="./img/fram_lower_left.png">&nbsp;</td>
                    <td height="25" background="./img/fram_bottom.png">&nbsp;</td>
                    <td width="11" background="./img/fram_lower_right.png">&nbsp;</td>
                  </tr>
                </table></td>
                <td width="1%">&nbsp;</td>
              </tr>
            </table></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td height="25" background="./img/fram_bottom.png">&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td align="center">&nbsp;</td>
      </tr>
    </table></td>
  </tr>  
  <tr>
    <td align="center">&nbsp;</td>
  </tr>
</table>
<?php require 'footer.php'; ?> 
<div id="gotop">Top</div>
</body>
</html>