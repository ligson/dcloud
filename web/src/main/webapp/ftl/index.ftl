<@override name="title">用户登录</@override>
<@override name="head">
<link type="text/css" rel="stylesheet" href="/assets/js/bootstrapvalidator-0.5.2/dist/css/bootstrapValidator.min.css"/>
<link type="text/css" rel="stylesheet" href="/assets/css/index.css"/>
<script type="text/javascript" src="/assets/js/bootstrapvalidator-0.5.2/dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="/assets/js/dcloud/index.js"></script>
</@override>

<@override name="body">
<div class="container">
    <div class="modal show" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                <#--<button type="button" class="close">x</button>-->
                    <h1 class="text-center text-primary">登录</h1>
                </div>
                <div class="modal-body  col-md-12">
                    <form id="loginForm" action="/index/login" method="post" class="form center-block">
                        <div class="form-group">
                            <input style="display:none;"/>
                            <input type="text" class="form-control input-md" placeholder="用户名" name="name"
                                   value="${name}" id="name" autocomplete="off"/>
                        </div>
                        <div class="form-group">
                            <input style="display:none;"/>
                            <input type="password" class="form-control input-md" placeholder="登录密码" name="password"
                                   value="${password}" id="password" autocomplete="off"/>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-md btn-block">立刻登录</button>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <#if msg>
                        <span class="pull-left alert alert-danger">${msg}</span>
                    </#if>

                    <span><a href="#">找回密码</a></span>&nbsp;&nbsp;
                    <span><a href="/index/register" class="pull-right">注册</a></span>
                </div>
            </div>
        </div>
    </div>

</div>
</@override>
<@extends name="layout/index.ftl"/>