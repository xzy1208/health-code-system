<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.teacher" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>系统管理员</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <!--<link href="bootstrap/css/bootstrap.css" rel="stylesheer" type="text/css">-->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-NU/T4JKmgovMiPaK2GP9Y+TVBQxiaiYFJB6igFtfExinKlzVruIK6XtKqxCGXwCG" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.15.4/dist/bootstrap-table.min.css">
    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/bootstrap-table@1.15.4/dist/bootstrap-table.min.js"></script>

    <script type="text/javascript">
    function notnullpa(){
    	var v1 = document.getElementById("newpassword").value;
    	if(v1!="")
    		validatepa();
    	else
    		alert("输入框不能为空");
    		
    }
    function notnull1(){
    	var v1 = document.getElementById("academyname1").value;
    	if(v1!="")
    		validate1();
    	else
    		alert("输入框不能为空");
    		
    }
function notnull2(){
	var v1 = document.getElementById("academyname2").value;
    var v2 = document.getElementById("subjectname2").value;
	if(v1!=""&&v2!="")
		validate2();
	else
		alert("输入框不能为空");
    }
function notnull3(){
	 	var v1 = document.getElementById("academyname3").value;
	   var v2 = document.getElementById("subjectname3").value;
	   var v3 = document.getElementById("classname3").value;
		if(v1!=""&&v2!=""&&v3!="")
			validate3();
		else
			alert("输入框不能为空");
}

function notnull4(){
	 	var v1 = document.getElementById("jobnumber4").value;
	    var v2 = document.getElementById("name4").value;
	    var v3 = document.getElementById("id4").value;
	    var v4 = document.getElementById("academyname4").value;
	    var v5 = document.getElementById("role4").value;
	    if(v1!=""&&v2!=""&&v3!=""&&v4!=""&&v5!="")
			validate4();
		else
			alert("输入框不能为空");
}
function notnull5(){
	var v1 = document.getElementById("studentnumber5").value;
    var v2 = document.getElementById("name5").value;
    var v3 = document.getElementById("id5").value;
    var v4 = document.getElementById("academyname5").value;
    var v5 = document.getElementById("subject5").value;
    var v6 = document.getElementById("class5").value;
    if(v1!=""&&v2!=""&&v3!=""&&v4!=""&&v5!=""&&v6!="")
		validate5();
	else
		alert("输入框不能为空");
}
	window.onload=function()
	{
		var v=${flag};
		$("#add1").addClass("hidden");
		$("#add2").addClass("hidden");
		$("#add3").addClass("hidden");
		$("#add4").addClass("hidden");
		$("#add5").addClass("hidden");
		$("#table1").addClass("hidden");
		$("#table2").addClass("hidden");
		$("#table3").addClass("hidden");
		$("#table4").addClass("hidden");
		$("#table5").addClass("hidden");
		$("#table6").addClass("hidden");
		if(v=="1")
		{
		$("#table1").removeClass("hidden");
		$(".setting").removeClass("hidden");
		$("#add1").removeClass("hidden");
		}
		else if(v=="2")
		{
			$("#table2").removeClass("hidden");
			$(".setting").removeClass("hidden");
			$("#add2").removeClass("hidden");
		}
		else if(v=="3")
		{
			$("#table3").removeClass("hidden");
			$(".setting").removeClass("hidden");
			$("#add3").removeClass("hidden");
		}
		else if(v=="4")
		{
			$("#table4").removeClass("hidden");
			$(".setting").removeClass("hidden");
			$("#add4").removeClass("hidden");
		}
		else if(v=="5")
		{
			$("#table5").removeClass("hidden");
			$(".setting").removeClass("hidden");
			$("#add5").removeClass("hidden");
		}
		else if(v=="6") 
			{
			$("#table6").removeClass("hidden");
			$(".setting").removeClass("hidden");
			}
		
	}
	function inputvaluetopa(str)
	{
		document.getElementById("hideid2").value=str;
	}
	function inputvalue(str)
	{
		document.getElementById("hideid").value=str;
	}
</script>
<script>
function validatepa(){
    createXMLHttpRequest();
    var hideid=document.getElementById("hideid2").value;
    var newpassword = document.getElementById("newpassword").value;
    var url = "set.do?hideid2="+hideid+"&newpassword="+newpassword;
    url=encodeURI(url);
    xmlHttp.open("get", url, true);
    xmlHttp.onreadystatechange = handleStateChangepa;    
    xmlHttp.send(null);
  }
  
  function handleStateChangepa() {
    if(xmlHttp.readyState == 4){
      if(xmlHttp.status == 200){
        var message = xmlHttp.responseXML.
          getElementsByTagName("message")[0].firstChild.data;
        var messageArea = document.getElementById("resultpa");
        messageArea.innerHTML = "<p>" + message + "</p>";
      }
    }
  }

function validates(){
    createXMLHttpRequest();
    var hideid=document.getElementById("hideid").value;
    var url = "sub.do?hideid="+hideid;
    xmlHttp.open("get", url, true);
    xmlHttp.onreadystatechange = handleStateChanges;    
    xmlHttp.send(null);
  }
  
  function handleStateChanges() {
    if(xmlHttp.readyState == 4){
      if(xmlHttp.status == 200){
        var message = xmlHttp.responseXML.
          getElementsByTagName("message")[0].firstChild.data;
        var messageArea = document.getElementById("results");
        messageArea.innerHTML = "<p>" + message + "</p>";
      }
    }
  }
</script>
<script type="text/javascript">
var xmlHttp;
function createXMLHttpRequest() {
    if (window.XMLHttpRequest) {
       xmlHttp = new XMLHttpRequest();
     }else{
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
}
  function validate1() {
    createXMLHttpRequest();
    var academyname1 = document.getElementById("academyname1");
    var url = "add.do?academyname1=" + academyname1.value+"&m=1";
    url=encodeURI(url);
    xmlHttp.open("GET", url, true);
    xmlHttp.onreadystatechange = handleStateChange1;    
    xmlHttp.send(null);
  }

  function handleStateChange1() {
    if(xmlHttp.readyState == 4){
      if(xmlHttp.status == 200){
        var message = xmlHttp.responseXML.
          getElementsByTagName("message")[0].firstChild.data;
        var messageArea = document.getElementById("result1");
        messageArea.innerHTML = "<p>" + message + "</p>";
      }
    }
  }
  function validate2() {
	    createXMLHttpRequest();
	    var academyname2 = document.getElementById("academyname2");
	    var subjctname2 = document.getElementById("subjectname2");
	    var url = "add.do?academyname2=" + academyname2.value+"&subjectname2="+subjectname2.value+"&m=2";
	    url=encodeURI(url);
	    xmlHttp.open("GET", url, true);
	    xmlHttp.onreadystatechange = handleStateChange2;    
	    xmlHttp.send(null);
	  }

	  function handleStateChange2() {
	    if(xmlHttp.readyState == 4){
	      if(xmlHttp.status == 200){
	        var message = xmlHttp.responseXML.
	          getElementsByTagName("message")[0].firstChild.data;
	        var messageArea = document.getElementById("result2");
	        messageArea.innerHTML = "<p>" + message + "</p>";
	      }
	    }
	  }
	  function validate3() {
		    createXMLHttpRequest();
		    var academyname3 = document.getElementById("academyname3");
		    var subjctname3 = document.getElementById("subjectname3");
		    var classname3 = document.getElementById("classname3");
		    var url = "add.do?academyname3=" + academyname3.value+"&subjectname3=" + subjctname3.value+"&classname3="+classname3.value+"&m=3";
		    url=encodeURI(url);
		    xmlHttp.open("GET", url, true);
		    xmlHttp.onreadystatechange = handleStateChange3;    
		    xmlHttp.send(null);
		  }

		  function handleStateChange3() {
		    if(xmlHttp.readyState == 4){
		      if(xmlHttp.status == 200){
		        var message = xmlHttp.responseXML.
		          getElementsByTagName("message")[0].firstChild.data;
		        var messageArea = document.getElementById("result3");
		        messageArea.innerHTML = "<p>" + message + "</p>";
		      }
		    }
		  }
		  function validate4() {
			    createXMLHttpRequest();
			    var jobnumber4 = document.getElementById("jobnumber4");
			    var name4 = document.getElementById("name4");
			    var id4 = document.getElementById("id4");
			    var academyname4 = document.getElementById("academyname4");
			    var role4 = document.getElementById("role4");
			    var url = "add.do?jobnumber4=" + jobnumber4.value+"&name4=" + name4.value+"&academyname4="+academyname4.value+"&id4="+id4.value+"&role4="+role4.value+"&m=4";
			    url=encodeURI(url);
			    xmlHttp.open("GET", url, true);
			    xmlHttp.onreadystatechange = handleStateChange4;    
			    xmlHttp.send(null);
			  }

			  function handleStateChange4() {
			    if(xmlHttp.readyState == 4){
			      if(xmlHttp.status == 200){
			        var message = xmlHttp.responseXML.
			          getElementsByTagName("message")[0].firstChild.data;
			        var messageArea = document.getElementById("result4");
			        messageArea.innerHTML = "<p>" + message + "</p>";
			      }
			    }
			  }
			  function validate5() {
				  createXMLHttpRequest();
				    var studentnumber5 = document.getElementById("studentnumber5");
				    var name5 = document.getElementById("name5");
				    var id5 = document.getElementById("id5");
				    var academyname5 = document.getElementById("academyname5");
				    var subject5 = document.getElementById("subject5");
				    var class5 = document.getElementById("class5");
				    var url = "add.do?studentnumber5=" + studentnumber5.value+"&name5=" + name5.value+"&academyname5="+academyname5.value+"&id5="+id5.value+"&subject5="+subject5.value+"&class5="+class5.value+"&m=5";
				    url=encodeURI(url);
				    xmlHttp.open("GET", url, true);
				    xmlHttp.onreadystatechange = handleStateChange5;    
				    xmlHttp.send(null);
				  }

				  function handleStateChange5() {
				    if(xmlHttp.readyState == 4){
				      if(xmlHttp.status == 200){
				        var message = xmlHttp.responseXML.
				          getElementsByTagName("message")[0].firstChild.data;
				        var messageArea = document.getElementById("result5");
				        messageArea.innerHTML = "<p>" + message + "</p>";
				      }
				    }
				  }
</script>
</head>
<body>
<div id="header" class="container-fluid" style="background-color:#375A87;height: 60px;">
    <h2>系统信息管理</h2>
    <label>欢迎您,系统管理员 ${username}</label>
</div>
<div class="main">
    <div id="leftbar">
        <div class="dropdown">
            <button class="btn btn-primary btn-lg btn-block" type="button" id="dropdownMenu1" data-toggle="dropdown" >
                信息管理
                <span class="caret"></span>
            </button>
            <form action="select1" method="post">
	            <ul class="dropdown-link">
	                <li><button class="dropdown-item" value="1" name="option">学院信息管理</button></li>
	                <li><button class="dropdown-item" value="2" name="option">专业信息管理</button></li>
	                <li><button class="dropdown-item" value="3" name="option">班级信息管理</button></li>
	                <li><button class="dropdown-item" value="4" name="option">教师信息管理</button></li>
	                <li><button class="dropdown-item" value="5" name="option">学生信息管理</button></li>
	                <li><button class="dropdown-item" value="6" name="option">健康码和打卡统计</button></li>
	                <div class="arrow"></div>
	            </ul>
            </form>
        </div>
    </div>
    <div id="rightbar">
        <ul class="breadcrumb">
            <li>信息管理</li>
            <li>${tip}</li>
        </ul>
        <div class="setting hidden">
        
        <form id="ss"action="information1.do" method="post">
            <div class="icon2">
                <span class="glyphicon glyphicon-search"></span>
                <label>查找</label>
            </div>
            <div id="search">
                <input type="search" class="form-control" placeholder="" name="search">
            </div>
            <button type="submit" class="btn btn-info" id="commit">确认</button>
            </form>
            <button class="btn btn-default hidden" data-toggle="modal" data-target="#Modal1" id="add1"><span class="glyphicon glyphicon-plus"></span>添加</button>
            <button class="btn btn-default hidden" data-toggle="modal" data-target="#Modal2" id="add2"><span class="glyphicon glyphicon-plus"></span>添加</button>
            <button class="btn btn-default hidden" data-toggle="modal" data-target="#Modal3" id="add3"><span class="glyphicon glyphicon-plus"></span>添加</button>
            <button class="btn btn-default hidden" data-toggle="modal" data-target="#Modal4" id="add4"><span class="glyphicon glyphicon-plus"></span>添加</button>
            <button class="btn btn-default hidden" data-toggle="modal" data-target="#Modal5" id="add5"><span class="glyphicon glyphicon-plus"></span>添加</button>
        </div>
        <div id="table-p">
		  <table class="table table-striped table-hover hidden" id="table1">
			<thead>
			<tr>
				<td>学院</td>
				<td></td>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="x" items="${list1}">
				<tr>
		            <td>${x.academy}</td>
		            <td><button class="btn btn-default"  id="sub1" data-toggle="modal" data-target="#Modals" onclick="inputvalue('${x.academy}')"><span class="glyphicon glyphicon-minus"></span>删除</button></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		 <table class="table table-striped table-hover hidden" id="table2">
			<thead>
			<tr>
				<td>学院</td>
				<td>专业</td>
				<td></td>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="x" items="${list2}">
				<tr>
					<td>${x.academy}</td>
					<td>${x.subject}</td>
					<td><button class="btn btn-default"  id="sub2" data-toggle="modal" data-target="#Modals" onclick="inputvalue('${x.subject}')"><span class="glyphicon glyphicon-minus"></span>删除</button></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>

    		 <table class="table table-striped table-hover hidden" id="table3">
			<thead>
			<tr>

				<td>学院</td>
				<td>专业</td>
				<td>班级</td>
				<td></td>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="x" items="${list3}">
				<tr>
					<td>${x.academy}</td>
		            <td>${x.subject}</td>
		            <td>${x.class1}</td>
		            <td><button class="btn btn-default"  id="sub3" data-toggle="modal" data-target="#Modals" onclick="inputvalue('${x.class1}')"><span class="glyphicon glyphicon-minus"></span>删除</button></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
     
    		 <table class="table table-striped table-hover hidden" id="table4">
			<thead>
			<tr>
				<td>工号</td>
				<td>姓名</td>
				<td>身份证号</td>
				<td>学院</td>
				<td>角色</td>
				<td></td>
				<td></td>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="x" items="${list4}">
				<tr>
					<td>${x.jobnumber}</td>
		            <td>${x.name}</td>
		            <td>${x.id}</td>
		            <td>${x.academy}</td>
		            <td>${x.role}</td>
					<c:if test="${x.role=='院级管理员'||x.role=='校级管理员'}" var="result">
						<td><button class="btn btn-default"  id="setpa" data-toggle="modal" data-target="#Modalpa" onclick="inputvaluetopa('${x.jobnumber}')"><span class="glyphicon glyphicon-cog"></span>设置密码</button></td>
					</c:if>
					<c:if test="${x.role!='院级管理员'&& x.role!='校级管理员'}" var="result">
						<td></td>
					</c:if>
		            <td><button class="btn btn-default"  id="sub4" data-toggle="modal" data-target="#Modals" onclick="inputvalue('${x.jobnumber}')"><span class="glyphicon glyphicon-minus"></span>删除</button></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
  
    		 <table class="table table-striped table-hover hidden" id="table5">
			<thead>
			<tr>
				<td>学号</td>
				<td>姓名</td>
				<td>身份证号</td>
				<td>学院</td>
				<td>专业</td>
				<td>班级</td>
				<td></td>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="x" items="${list5}">
				<tr>
					<td>${x.studentnumber}</td>
		            <td>${x.name}</td>
		            <td>${x.id}</td>
		            <td>${x.academy}</td>
		            <td>${x.subject}</td>
		            <td>${x.class1}</td>
		            <td><button class="btn btn-default"  id="sub5" data-toggle="modal" data-target="#Modals" onclick="inputvalue('${x.studentnumber}')"><span class="glyphicon glyphicon-minus"></span>删除</button></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="hidden" id="table6">
 <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main1" style="width: 600px;height:400px;"></div>
    <script type="text/javascript">
        var myChart = echarts.init(document.getElementById('main1'));// 基于准备好的dom，初始化echarts实例
        myChart.setOption({
        	title:{text:'健康码',x:'center',y:'top',},
        	color:['#68ad77','#ecbe2d','#d81118'],
            series : [
                {
                    name: '健康码',
                    type: 'pie',      // 设置图表类型为饼图
                    radius: '55%',    // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
                    data:[            // 数据数组，name 为数据项名称，value 为数据项值
                        {value:<%=request.getAttribute("green1") %>, name:'绿码'},
                        {value:<%=request.getAttribute("yellow1")%>, name:'黄码'},
                        {value:<%=request.getAttribute("red1")%>, name:'红码'}
                    ],
                    itemStyle:{ 
				        normal:{ 
				           label:{ 
				              show: true, 
				              formatter: '{b} : {c} ({d}%)' 
				           }, 
				           labelLine :{show:true} 
				        } 
				    } 
                }
            ]
        })
    </script>
    
    <div id="main2" style="width: 600px;height:400px;"></div>
    <script type="text/javascript">
        var myChart = echarts.init(document.getElementById('main2'));// 基于准备好的dom，初始化echarts实例
        myChart.setOption({
        	title:{text:'每日一报',x:'center',y:'top',},
        	color:['#68ad77','#ecbe2d','#d81118','#000000'],
            series : [
                {
                	
                    name: '每日一报',
                    type: 'pie',      // 设置图表类型为饼图
                    radius: '55%',    // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
                    data:[            // 数据数组，name 为数据项名称，value 为数据项值
                        {value:<%=request.getAttribute("green2") %>, name:'绿码'},
                        {value:<%=request.getAttribute("yellow2")%>, name:'黄码'},
                        {value:<%=request.getAttribute("red2")%>, name:'红码'},
                        {value:<%=request.getAttribute("wait")%>, name:'未申报'}
                    ],
                    itemStyle:{ 
				        normal:{ 
				           label:{ 
				              show: true, 
				              formatter: '{b} : {c} ({d}%)' 
				           }, 
				           labelLine :{show:true} 
				        } 
				    } 
                }
            ]
        })
    </script>
    <table class="table table-striped table-hover" id="table6-t">
			<thead>
			<tr>
				<td>日期</td>
				<td>学工号</td>
				<td>学院</td>
				<td>当日打卡结果</td>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="x" items="${list6}">
				<tr>
					<td>${x.date}</td>
		            <td>${x.number}</td>
		            <td>${x.academy}</td>
		            <td>${x.result}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
        </div>
    </div>
    <div class="modal fade" id="Modal1" tabindex="-1" role="dialog" aria-labelledby="ModalLabel1" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="ModalLabel1">添加学院</h4>
                </div>
                <div class="modal-body">
			         <div class="form-group">
			             <label for="number">学院名称</label>
			             <input type="text" required="required" class="form-control" name="academyname1" id="academyname1" style="border: #0a0a0a;">
		            </div>
		            <div id="result1">
		            </div>                	
	           </div>
		           <div class="modal-footer">
		               <button class="btn btn-default" data-dismiss="modal">关闭</button>
		               <button type="submit" class="btn btn-primary" value="a1" name="as" onclick="notnull1()">提交添加</button>
		           </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="Modal2" tabindex="-1" role="dialog" aria-labelledby="ModalLabel2" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="ModalLabel2">添加专业</h4>
                </div>
                <div class="modal-body">
			         <div class="form-group">
			             <label for="academyname2">学院名称</label>
			             <input type="text" required="required" class="form-control" id="academyname2" style="border: #0a0a0a;">
			             </div>
			             <div class="form-group">
			             <label for="subjectname2">专业名称</label>
			             <input type="text" required="required" class="form-control" id="subjectname2" style="border: #0a0a0a;">
		            </div><br>
		            <div id="result2">
		            </div>                	
	           </div>
		           <div class="modal-footer">
		               <button class="btn btn-default" data-dismiss="modal">关闭</button>
		               <button type="submit" class="btn btn-primary" value="a2" name="as" onclick="notnull2()">提交添加</button>
		           </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="Modal3" tabindex="-1" role="dialog" aria-labelledby="ModalLabel3" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="ModalLabel3">添加班级</h4>
                </div>
                <div class="modal-body">
			         <div class="form-group">
			             <label for="academyname3">学院名称</label>
			             <input type="text" required="required" class="form-control" id="academyname3" style="border: #0a0a0a;">
			             </div>
			             <div class="form-group">
			             <label for="subjectname3">专业名称</label>
			             <input type="text" required="required" class="form-control" id="subjectname3" style="border: #0a0a0a;">
			             </div>
			             <div class="form-group">
			             <label for="classname3">班级名称</label>
			             <input type="text" required="required" class="form-control" id="classname3" style="border: #0a0a0a;">
			             </div><br>
			             <div id="result3"></div>             
		            </div>
		            <div class="modal-footer">
		               <button class="btn btn-default" data-dismiss="modal">关闭</button>
		               <button type="submit" class="btn btn-primary" value="a3" name="as" onclick="notnull3()">提交添加</button>
		           </div>
	           </div>
            </div>
        </div>
            <div class="modal fade" id="Modal4" tabindex="-1" role="dialog" aria-labelledby="ModalLabel4" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="ModalLabel4">添加教师</h4>
                </div>
                <div class="modal-body">
			         <div class="form-group">
			             <label for="jobnumber4">工号</label>
			             <input type="text" required="required" class="form-control" id="jobnumber4" style="border: #0a0a0a;">
			        </div>
			         <div class="form-group">
			             <label for="name4">姓名</label>
			             <input type="text" required="required" class="form-control" id="name4" style="border: #0a0a0a;">
			        </div>
			        <div class="form-group">
			             <label for="id4">身份证号</label>
			             <input type="text" required="required" class="form-control" id="id4" style="border: #0a0a0a;">
			        </div>
			   		<div class="form-group">
 						<label for="academyname4">学院</label>
			             <input type="text" required="required" class="form-control" id="academyname4" style="border: #0a0a0a;">
			        </div>
			        	<div class="form-group">
			             <label for="role4">角色</label>
			             <input type="text" required="required" class="form-control" id="role4" style="border: #0a0a0a;">
			        </div>
						<div id="result4">
		            </div>      
		            </div>
		             <div class="modal-footer">
		               <button class="btn btn-default" data-dismiss="modal">关闭</button>
		               <button type="submit" class="btn btn-primary" value="a4" name="as" onclick="notnull4()">提交添加</button>
		           </div>     	
	           </div> 
            </div>
        </div>
      <div class="modal fade" id="Modal5" tabindex="-1" role="dialog" aria-labelledby="ModalLabel5" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h5 class="modal-title" id="ModalLabel5">添加学生</h5>
                </div>
                <div class="modal-body">
			         <div class="form-group">
			             <label for="studentnumber5">学号</label>
			             <input type="text" required="required" class="form-control" id="studentnumber5" style="border: #0a0a0a;">
			        </div>
			         <div class="form-group">
			             <label for="name5">姓名</label>
			             <input type="text" required="required" class="form-control" id="name5" style="border: #0a0a0a;">
			        </div>
			        <div class="form-group">
			             <label for="id5">身份证号</label>
			             <input type="text" required="required" class="form-control" id="id5" style="border: #0a0a0a;">
			        </div>
			   		<div class="form-group">
 						<label for="academyname5">学院</label>
			             <input type="text" required="required" class="form-control" id="academyname5" style="border: #0a0a0a;">
			        </div>
			        <div class="form-group">
			             <label for="subject5">专业</label>
			             <input type="text" required="required" class="form-control" id="subject5" style="border: #0a0a0a;">
			        </div>
			        	<div class="form-group">
			             <label for="class5">班级</label>
			             <input type="text" required="required" class="form-control" id="class5" style="border: #0a0a0a;">
			        </div>
			        <div id="result5">
		            </div>
		            </div><br>

		             <div class="modal-footer">
		               <button class="btn btn-default" data-dismiss="modal">关闭</button>
		               <button type="submit" class="btn btn-primary" value="a5" name="as" onclick="notnull5()">提交添加</button>
		           </div>            	
	           </div>
            </div>
        </div>
        <div class="modal fade" id="Modals" tabindex="-1" role="dialog" aria-labelledby="ModalLabels" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="ModalLabels">提示</h4>
                </div>
                <div class="modal-body">
                <div><p>确定是否删除？</p>
                <input type="hidden" id="hideid" name="hideid" value=''>
                </div>    
	                <div id="results">
			        </div>
	           </div>
		           <div class="modal-footer">
		               <button class="btn btn-default" data-dismiss="modal">关闭</button> 
		               	<button type="submit" class="btn btn-primary" onclick="validates()">确定</button>
		           </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="Modalpa" tabindex="-1" role="dialog" aria-labelledby="ModalLabelpa" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="ModalLabelpa">设置密码</h4>
                </div>
                <div class="modal-body">
                <input type="hidden" id="hideid2" name="hideid2" value=''>
			         <div class="form-group">
			             <label for="academyname3">新密码</label>
			             <input type="text" required="required" class="form-control" id="newpassword" style="border: #0a0a0a;">
			             </div>
			             <div id="resultpa"></div>             
		            </div>
		            <div class="modal-footer">
		               <button class="btn btn-default" data-dismiss="modal">关闭</button>
		               <button type="submit" class="btn btn-primary" value="apa" name="as" onclick="notnullpa()">提交设置</button>
		           </div>
	           </div>
            </div>
        </div>
    </div>
<div id="footer" style="background-color:#375A87;height: 40px;">
    <section id="copyright" class="container">
    </section>
</div>
</body>
</html>