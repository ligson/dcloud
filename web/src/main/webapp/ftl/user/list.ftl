<#import "include/pager.ftl" as pager/>
<@override name="title">用户列表</@override>
<@override name="head">
<link href="../../assets/css/pager.css" rel="stylesheet"/>
</@override>

<@override name="body">
<div class="container">
    <div class="col-md-10">
        <table class="table">
            <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>sex</th>
                <th>password</th>
                <th>birth</th>
                <th>删除</th>
                <th>修改</th>
            </tr>
            </thead>
            <tbody>
                <#list userList as u>
                <tr>
                    <td>${u.id}</td>
                    <td>${u.name}</td>
                    <td>${u.sex}</td>
                    <td>${u.password}</td>
                    <td>${u.birth?string('yyyy-MM-dd HH:mm:ss')}</td>
                    <td><a class="btn-danger" href="/user/remove?id=${u.id}">删除</a></td>
                    <td><a class="btn-danger" href="/user/edit?id=${u.id}">修改</a></td>
                </tr>
                </#list>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="6">
                    <div class="page-control pagination pull-right">
                        <@pager.pagination total=total offset=offset max=max url="/user/list"/>
                    </div>
                </td>
            </tr>
            </tfoot>
        </table>
    </div>
</div>
</@override>
<@extends name="layout/index.ftl"/>
