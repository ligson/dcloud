<#import "include/pager.ftl" as pager/>
<@override name="title">用户登录</@override>
<@override name="head">
<link href="/assets/css/pager.css" rel="stylesheet"/>
</@override>

<@override name="body">
<div class="container">
    <div class="col-md-10">
        <form class="form-horizontal" method="post" action="/user/login">
            <div class="form-group">
                <label for="inputName3" class="col-sm-2 control-label">用户名</label>

                <div class="col-sm-10">
                    <input type="text" name="name" class="form-control" id="inputName3" placeholder="请输入用户名">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">密码</label>

                <div class="col-sm-10">
                    <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="请输入密码">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">登录</button>
                    <a class="btn btn-primary" href="/user/register">注册</a>
                </div>
            </div>
        </form>
    </div>
</div>
</@override>
<@extends name="layout/index.ftl"/>