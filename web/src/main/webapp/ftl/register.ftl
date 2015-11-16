<@override name="title">注册</@override>
<@override name="head">
<link href="../assets/js/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
<script src="../assets/js/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script src="../assets/js/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"
        charset="utf-8"></script>
<script type="text/javascript">
    $(function () {
        $("#datetimepicker").datetimepicker({
            format: 'yyyy-mm-dd',
            language: "zh-CN"
        });
    });
</script>

</@override>

<@override name="body">
<div class="container">
    <div class="col-md-10">
        <form class="form-horizontal" method="post" action="/user/saveUser">
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
                <label for="inputPassword4" class="col-sm-2 control-label">再次输入</label>

                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword4" placeholder="再次输入密码">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">性别</label>

                <div class="col-sm-10">
                    <label class="radio-inline">
                        <input type="radio" name="sex" value="true">男
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="sex" value="false">女
                    </label>
                </div>
            </div>

            <div class="form-group">
                <label for="datetimepicker" class="col-sm-2 control-label">出生日期</label>

                <div class="col-sm-10">
                    <input type="text" name="birth" value="" id="datetimepicker">
                </div>
            </div>


            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">注册</button>
                </div>
            </div>
        </form>
    </div>
</div>
</@override>
<@extends name="layout/index.ftl"/>