<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.teacher" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>院级信息管理</title>
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
		{$("#table6").removeClass("hidden");
		$(".setting").removeClass("hidden");
		}
	}
	function inputvalue(str)
	{
		document.getElementById("hideid").value=str;
	}
</script>
</head>
<body>
<div id="header" class="container-fluid" style="background-color:#375A87;height: 60px;">
    <h2>院级信息管理</h2>
    <label>欢迎您,${useracademy}院级管理员 ${username}</label>
</div>
<div class="main">
    <div id="leftbar">
        <div class="dropdown">
            <button class="btn btn-primary btn-lg btn-block" type="button" id="dropdownMenu1" data-toggle="dropdown" >
                信息查询
                <span class="caret"></span>
            </button>
            <form action="select3" method="post">
	            <ul class="dropdown-link">
	                <li><button class="dropdown-item" value="2" name="option">专业信息查询</button></li>
	                <li><button class="dropdown-item" value="3" name="option">班级信息查询</button></li>
	                <li><button class="dropdown-item" value="4" name="option">教师信息查询</button></li>
	                <li><button class="dropdown-item" value="5" name="option">学生信息查询</button></li>
	                <li><button class="dropdown-item" value="6" name="option">健康码和打卡统计</button></li>
	                <div class="arrow"></div>
	            </ul>
            </form>
        </div>
    </div>
    <div id="rightbar">
        <ul class="breadcrumb">
            <li>信息查询</li>
            <li>${tip}</li>
        </ul>
        <div class="setting hidden">
        
        <form id="ss"action="information3.do" method="post">
            <div class="icon2">
                <span class="glyphicon glyphicon-search"></span>
                <label>查找</label>
            </div>
            <div id="search">
                <input type="search" class="form-control" placeholder="" name="search">
            </div>
            <button type="submit" class="btn btn-info" id="commit">确认</button>
            </form>
        </div>
        <div id="table-p">
		 <table class="table table-striped table-hover hidden" id="table2">
			<thead>
			<tr>
				<td>专业</td>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="x" items="${list2}">
				<tr>
					<td>${x.subject}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>

    		 <table class="table table-striped table-hover hidden" id="table3">
			<thead>
			<tr>
				<td>班级</td>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="x" items="${list3}">
				<tr>
		            <td>${x.class1}</td>
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
  </div>
<div id="footer" style="background-color:#375A87;height: 40px;">
    <section id="copyright" class="container">
    </section>
</div>

</body>
</html>