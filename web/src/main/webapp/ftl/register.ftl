<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>注册</title>

    <!-- Bootstrap -->
    <link href="../assets/js/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="../assets/js/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="../assets/js/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

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
                    <input type="text" name="birth" value="2012-05-15" id="datetimepicker">
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

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../assets/js/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script src="../assets/js/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="../assets/js/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
    $(function () {
        $("#datetimepicker").datetimepicker({
            format: 'yyyy-mm-dd'
        });
    });
</script>
</body>
</html>