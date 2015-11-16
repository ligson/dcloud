<@override name="title">编辑</@override>
<@override name="head">

</@override>

<@override name="body">
<div class="container">
    <div class="col-md-10">
        <form class="form-horizontal" method="post" action="/user/updateUser">
            <input type="hidden" value="${user.id}" name="id"/>
            <div class="form-group">
                <label for="inputName3" class="col-sm-2 control-label">用户名</label>

                <div class="col-sm-10">
                    <input type="text" name="name" class="form-control" id="inputName3" placeholder="请输入用户名"
                           value="${user.name}">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">性别</label>

                <div class="col-sm-10">
                    <label class="radio-inline">
                        <input type="radio" name="sex" value="true" ${user.sex?string("checked","")}>男
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="sex" value="false" ${user.sex?string("","checked")}>女
                    </label>
                </div>
            </div>

            <div class="form-group">
                <label for="datetimepicker" class="col-sm-2 control-label">出生日期</label>

                <div class="col-sm-10">
                    <input type="text" name="birth" value="${user.birth?string('yyyy-MM-dd')}" id="datetimepicker">
                </div>
            </div>


            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</@override>
<@extends name="layout/index.ftl"/>
