<@override name="title">注册</@override>
<@override name="head">
<link href="../assets/js/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
<link type="text/css" rel="stylesheet" href="/assets/js/bootstrapvalidator-0.5.2/dist/css/bootstrapValidator.min.css"/>
<script src="../assets/js/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script src="../assets/js/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"
        charset="utf-8"></script>
<script type="text/javascript" src="/assets/js/bootstrapvalidator-0.5.2/dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="/assets/js/dcloud/register.js"></script>

</@override>

<@override name="body">
<div class="container">
    <div class="modal show" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                <#--<button type="button" class="close">x</button>-->
                    <h1 class="text-center text-primary">注册</h1>
                </div>
                <div class="modal-body  col-md-12">

                    <form id="registerForm" class="form-horizontal  center-block" method="post"
                          action="/index/saveUser">
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">用户名</label>

                            <div class="col-sm-10">
                                <input style="display:none;"/>
                                <input type="text" name="name" class="form-control input-md" id="name"
                                       placeholder="请输入用户名" autocomplete="off">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">密码</label>

                            <div class="col-sm-10">
                                <input style="display:none;"/>
                                <input type="password" name="password" class="form-control input-md" id="password"
                                       placeholder="请输入密码" autocomplete="off">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password2" class="col-sm-2 control-label">再次输入</label>

                            <div class="col-sm-10">
                                <input style="display:none;"/>
                                <input type="password" class="form-control input-md" id="password2"
                                       placeholder="再次输入密码" name="password2" autocomplete="off"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">性别</label>

                            <div class="col-sm-10">
                                <label class="radio-inline">
                                    <input type="radio" name="sex" value="true" checked>男
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="sex" value="false">女
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="datetimepicker" class="col-sm-2 control-label">出生日期</label>

                            <div class="col-sm-10">
                                <input style="display:none;"/>
                                <input type="text" name="birth" value="" id="datetimepicker" class="input-md" autocomplete="off"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-primary btn-md btn-block">注册</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">

                </div>
            </div>
        </div>
    </div>
</div>
</@override>
<@extends name="layout/index.ftl"/>