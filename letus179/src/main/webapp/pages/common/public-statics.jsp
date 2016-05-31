<%-- 所有的静态资源导入都放在这里--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String contextPath = (String) request.getContextPath();
%>
<script type="text/javascript">var contextPath="<%=contextPath %>";</script>
<%-- 样式 默认就有 type="text/css" --%>
<link href="<%=contextPath%>/resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="<%=contextPath%>/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"  />

<script src="<%=contextPath%>/resources/js/jquery-1.12.3.min.js"></script>
<script src="<%=contextPath%>/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=contextPath%>/resources/js/rootpath.js"></script>

<%-- 
<script src="<%=contextPath%>/resources/bdp/highchart/exporting.js"></script>
<script src="<%=contextPath%>/resources/bdp/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=contextPath%>/resources/bdp/js/bdp/orgStructTree/bootstrap/bootstrap-table-all.min.js"></script>
<script src="<%=contextPath%>/resources/bdp/js/bootstrap-table/bootstrap-table-resize.js"></script>
<script src="<%=contextPath%>/resources/bdp/js/bootstrap-table/setIframeHeight.js"></script>
<script src="<%=contextPath%>/resources/bdp/js/bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
<script src="<%=contextPath%>/resources/bdp/js/jquery/jquery-validate/jquery.validate.min.js"></script>
<script src="<%=contextPath%>/resources/bdp/js/jquery/jquery-validate/messages_zh.js"></script>
<script src="<%=contextPath%>/resources/bdp/js/jquery/jquery.ztree.core-3.5.min.js"></script>
<script src="<%=contextPath%>/resources/bdp/js/jquery/jquery.ztree.excheck-3.5.min.js"></script>
<script src="<%=contextPath%>/resources/bdp/js/jquery/jquery.ztree.exedit-3.5.min.js"></script>
<!--下拉选择框JS  -->
<script src="<%=contextPath%>/resources/bdp/bootstrap/js/bootstrap-multiselect.js"></script>
<!--时间控件  -->
<script src="<%=contextPath%>/resources/bdp/bootstrap/datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script src="<%=contextPath%>/resources/bdp/bootstrap/datetimepicker/js/bootstrap-datetimepicker.fr.js"></script>
<!--在线编辑器  -->
<script src="<%=contextPath%>/resources/bdp/bootstrap/js/summernote.js"></script>

<script src="<%=contextPath%>/resources/bdp/js/bdp/util.js"></script>
<script src="<%=contextPath%>/resources/bdp/js/bdp/commons-operate.js"></script>
<!-- 引入组织架构 -->
<script src="<%=contextPath%>/resources/bdp/js/bdp/orgStructTree/orgStructTree.js"></script>

<!-- 引入导出表格到文件的插件 -->
<script src="<%=contextPath%>/resources/bdp/bootstrap/export/tableExport.min.js"></script>
<script src="<%=contextPath%>/resources/bdp/bootstrap/export/FileSaver.min.js"></script>
<script src="<%=contextPath%>/resources/bdp/bootstrap/export/bootstrap-table-export.js"></script> 
 --%>