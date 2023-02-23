<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>蓝码</title>
<link href="css/style2.css" rel="stylesheet" type="text/css"/>
<script type='text/javascript' src='http://cdn.staticfile.org/jquery/2.1.1/jquery.min.js'></script>
<script type="text/javascript" src="http://cdn.staticfile.org/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
<script type="text/javascript">
function connect(str1,str2,str3,str4){
	str=str1+str2+" "+str3+" "+str4;
	return str;
}
function utf16to8(str) {
    var out, i, len, c;
    out = "";
    len = str.length;
    for(i = 0; i < len; i++) {
    c = str.charCodeAt(i);
    if ((c >= 0x0001) && (c <= 0x007F)) {
    out  = str.charAt(i);
    } else if (c > 0x07FF) {
    out  = String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));
    out  = String.fromCharCode(0x80 | ((c >> 6) & 0x3F));
    out  = String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
    } else {
    out  = String.fromCharCode(0xC0 | ((c >> 6) & 0x1F));
    out  = String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
    }
    }
    return out;
}
$(function(){
    $('.ewm').qrcode({
       /* render: "table", //table方式  */
        width: 300, //宽度 
        height:300, //高度 
        text: utf16to8(connect('${name}','${id}','${number}','${academy}')), //任意内容 
        background :"#ffffff",//背景颜色  
        foreground :"#0000ff" //前景颜色  
    });
})
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
    <h1 class="header">健康码</h1>
	<h2 id=tit></h2>
	<h3><%=request.getAttribute("name") %>&nbsp<%=request.getAttribute("id") %></h3>
	<h3><%=request.getAttribute("number") %></h3>
	<h3><%=request.getAttribute("academy") %></h3>
	<div class=ewm style="width:300px;height:300px;margin: 10px auto;border: 10px solid rgb(253, 242, 0);"></div>
	<div class="footer">凭此码可在校园进出，请主动出示，配合检查</div>
</body>
</html>