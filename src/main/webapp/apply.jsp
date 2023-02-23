<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>每日健康申报</title>
<link href="css/style1.css" rel="stylesheet" type="text/css"/>
<!--web-fonts-->
<link href='//fonts.googleapis.com/css?family=Josefin+Sans:400,100,300,600,700' rel='stylesheet' type='text/css'>
<!--web-fonts-->
<script type="text/javascript">
function check()
{
	var x=document.forms["myform"]["phone"].value;
	var y=document.getElementsByName("ensure");
    var x1=document.getElementsByName("epidemic");
    var x2=document.getElementsByName("abroad");
    var y1=document.getElementsByName("touch");
    var y2=document.getElementsByName("confirm");
    var y3=document.getElementsByName("safe");
    var z1=document.getElementsByName("condition1");
    var z2=document.getElementsByName("condition");
	var n=z2.length;
	var t=0;
	for(var i=0;i<n;i++){
        if(z2[i].checked){
            t++;
        }
    }
    if(x.length<11){
        alert("手机号不得少于11个字符");
        return false;
    }
    if(!x1[0].checked&&!x1[1].checked){
    	alert("请回答：本人近期（14天内）是否去过重点疫区？");
        return false;
    }
    if(!x2[0].checked&&!x2[1].checked){
    	alert("请回答：本人近期（14天内）是否去过国外？");
        return false;
    }
    if(!y1[0].checked&&!y1[1].checked){
    	alert("请回答：本人近期（14天内）是否接触过新冠确诊病人或疑似病人？");
        return false;
    }
    if(!y2[0].checked&&!y2[1].checked){
    	alert("请回答：本人是否被卫生部门确认为新冠肺炎确诊病例或疑似病例？");
        return false;
    }
    if(!y3[0].checked&&!y3[1].checked){
    	alert("请回答：是否打过新冠疫苗？");
        return false;
    }
    if((!z1[0].checked&&!z1[1].checked)||(z1[1].checked&&t==0)){
    	alert("请回答：当前健康状况？");
        return false;
    }
	if(!y[0].checked){
    	alert("请承诺：填报信息真实，愿意承担相应的法律责任。");
    	return false;
    }
}
window.onload=function(){
    var t=new Date();
    var year=t.getFullYear();
    var month=t.getMonth()+1;
    var date=t.getDate();
    var ti=year+"年"+month+"月"+date+"日";
    document.getElementById("tit").innerHTML = ti;
}
</script>
</head>
<body>
	    <div class="header">
		    <h1>每日健康申报</h1>
	    </div>
		<div class="main">
			<h2 id=tit></h2>
			<p>为疫情防控，请如实填写以下信息</p>
			<span></span>
			<form name="myform" onsubmit="return check()" action="apply.do" method="post">
				<h4>姓名</h4>
				<input type="text" id="name" name="name" size="20" value="<%=request.getAttribute("name") %>" readonly="readonly">
				<h4>身份证号</h4>
				<input type="text" id="identity" name="identity" size="20" value="<%=request.getAttribute("identity") %>" readonly="readonly">
				<h4>学号/工号</h4>
				<input type="text" id="number" name="number" size="20" value="<%=request.getAttribute("number") %>" readonly="readonly">
				<h4>手机号</h4>						
				<input type="text" id="phone" name="phone" size="20" maxlength="11">
				<h4>本人近期（14天内）是否去过重点疫区？</h4>
				<div class="choose">
				    <input type="radio" name="epidemic" value="yes">是
				    <input type="radio" name="epidemic" value="no">否
				</div>
				<h4>本人近期（14天内）是否去过国外？</h4>
				<div class="choose">
				    <input type="radio" name="abroad" value="yes">是
				    <input type="radio" name="abroad" value="no">否
				</div>
				<h4>本人近期（14天内）是否接触过新冠确诊病人或疑似病人？</h4>
				<div class="choose">
				    <input type="radio" name="touch" value="yes">是
				    <input type="radio" name="touch" value="no">否
				</div>
				<h4>本人是否被卫生部门确认为新冠肺炎确诊病例或疑似病例？</h4>
				<div class="choose">
				    <input type="radio" name="confirm" value="yes">是
				    <input type="radio" name="confirm" value="no">否
				</div>
                <h4>是否打过新冠疫苗？</h4>
                <div class="choose">
                    <input type="radio" name="safe" value="yes">是
				    <input type="radio" name="safe" value="no">否
                </div>
				<h4>当前健康状况？</h4>
				<input type="radio" name="condition1" value="normal">无异常
			    <div class="choose">
			        <input type="radio" name="condition1" value="abnormal">有异常
                    <input type="checkbox" name="condition" value="fever">发烧
                    <input type="checkbox" name="condition" value="fatigue">乏力
                    <input type="checkbox" name="condition" value="cough">干咳
                    <input type="checkbox" name="condition" value="nose">鼻塞
                    <input type="checkbox" name="condition" value="snot">流涕
                    <input type="checkbox" name="condition" value="throat">咽痛
                    <input type="checkbox" name="condition" value="diarrhea">腹泻
                </div>
		     	<span></span>
				<input type="checkbox" name="ensure" value="ensure">本人郑重承诺：填报信息真实，愿意承担相应的法律责任。<br><br>
				<div class="submit"><input type="submit" value="提交"></div>
			</form>
		</div>
</body>
</html>