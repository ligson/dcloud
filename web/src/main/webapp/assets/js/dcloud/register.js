/**
 * Created by ligson on 2015/11/17.
 */
$(function () {
    $("#datetimepicker").datetimepicker({
        format: 'yyyy-mm-dd',
        language: "zh-CN",
        minView: "month"
    });
    $("#registerForm").bootstrapValidator({
        message: '这个值是无效的',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                message: '用户名是无效的',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    remote: {
                        url: "/index/check_name",
                        type: 'POST',
                        message: '用户名已存在',
                        delay: 1000
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    identical: {
                        field: 'password2',
                        message: '两次密码输入不一致'
                    }
                }
            },
            password2: {
                validators: {
                    notEmpty: {
                        message: '不允许为空!'
                    },
                    identical: {
                        field: 'password',
                        message: '两次密码输入不一致'
                    }
                }
            },
            birth: {
                validators: {
                    notEmpty: {
                        message: '出生日期不能为空'
                    },
                    date: {
                        format: 'YYYY-MM-DD',
                        message: "请输入有效的日期"
                    }
                }
            }
        }
    });
});