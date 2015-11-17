/**
 * Created by ligson on 2015/11/17.
 */
$(function () {
    $('#loginForm').bootstrapValidator({
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
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    }
                }
            }
        }
    });


    // dom加载完毕
    var $modal = $("#myModal");
    // 测试 bootstrap 居中
    var $modal_dialog = $modal.find(".modal-dialog");
    var m_top = ( $(document).height() - $modal_dialog.height() ) / 2;
    $modal_dialog.css({"margin": m_top + "px auto"});


});