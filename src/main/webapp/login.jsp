<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>健康码管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <!--<link href="bootstrap/css/bootstrap.css" rel="stylesheer" type="text/css">-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <script type="text/javascript" src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
    <script src="change.js"></script>
</head>
<body id="index">
    <div class="container">
        <h1>健康码管理系统</h1>
        <div id="bg">
            <div class="in">
                <fieldset>
                    <legend>登录</legend>
                        <div class="btn-toolbar">
                        <div class="btn-group nav navbar-nav" data-toggle="buttons">
                            <label class="btn btn-default" id="b1">
                                <input type="radio" data-toggle="tab" data-target=".ip1">申报登录
                            </label>
                            <label class="btn btn-default" id="b2">
                                <input type="radio" data-toggle="tab" data-target=".ip2">管理登录
                            </label>
                        </div>
                        </div>
                        <div class="tab-content">
                            <div class="ip1 tab-pane" >
                                <form action="login1.action" method="post">
                                <div class="input-group" >
                                    <label>
                                        <span class="glyphicon glyphicon-education form-control-feedback" style="left: 0px;
                                        margin-top: 9px;color: white;"></span>
                                        <input  type="text" id="num1" name="num1" required="required" placeholder="学号/工号" class="form-control">
                                    </label><br>
                                </div>
                                <div class="input-group">
                                    <span class="glyphicon glyphicon-user form-control-feedback"style="left: 0px;
                                        margin-top: 9px;color: white;"></span>
                                    <label><input type="text" id="name1" name="name1" required="required" placeholder="姓名"
                                                  class="form-control">
                                    </label><br>
                                </div>
                                <div class="input-group">
                                    <span class="glyphicon glyphicon-lock form-control-feedback"style="left: 0px;
                                        margin-top: 9px;color: white;"></span>
                                    <label><input type="password" id="id1" name="id1" required="required" placeholder="身份证后8位"
                                                  class="form-control">
                                    </label><br>
                                </div>
                                    <label><button id="sm1" type="submit" class="btn btn-default" href="#">登录</button></label>
                                </form>
                            </div>
                            <div class="ip2 tab-pane">
                                <form action="login2.action" method="post">
                                <div class="input-group" >
                                    <label>
                                        <span class="glyphicon glyphicon-user form-control-feedback" style="left: 0px;
                                        margin-top: 9px;color: white;"></span>
                                        <input  type="text" id="num2" name="num2" required="required" placeholder="工号" class="form-control">
                                    </label><br>
                                </div>
                                <div class="input-group">
                                    <span class="glyphicon glyphicon-lock form-control-feedback"style="left: 0px;
                                        margin-top: 9px;color: white;"></span>
                                    <label><input type="password" id="pw2" name="pw2" required="required" placeholder="密码"
                                                  class="form-control">
                                    </label><br>
                                </div>
                                    <label><button  id="sm2" type="submit" class="btn btn-default" href="#">登录</button></label>
                                </form>
                            </div>
                        </div>
                        <!--<label style="color: white;"><input type="checkbox" id="remember">记住我</label>
                        <label><a href="#" id="forget">忘记密码</a></label><br>-->
                </fieldset>
            </div>
        </div>
    </div>
</body>
</html>