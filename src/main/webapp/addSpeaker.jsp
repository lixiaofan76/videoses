<%--
  Created by IntelliJ IDEA.
  User: 李晓帆
  Date: 2019/8/6
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>添加讲师</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">

    <script type="text/javascript" src="js/jquery-1.12.2.min.js" ></script>
    <script type="text/javascript" src="layui/layui.js"></script>
</head>
<body>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
         <legend>添加讲师信息</legend>
    </fieldset>
    <div>
        <form class="layui-form" action="">
            <div class="layui-form-item">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-block">
                    <input  type="text" name="speakerName" lay-verify="speakerName" autocomplete="off" placeholder="讲师姓名" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">讲师简介</label>
                <div class="layui-input-block">
                    <input  type="text" name="speakerDesc" lay-verify="speakerDesc" autocomplete="off" placeholder="讲师简介" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">讲师职位</label>
                <div class="layui-input-block">
                    <input type="speakerJob" name="speakerJob" lay-verify="title" autocomplete="off" placeholder="讲师职位" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">头像图片地址</label>
                <div class="layui-input-block">
                    <input type="text" name="headImgUrl" lay-verify="headImgUrl" autocomplete="off" placeholder="具体的url" class="layui-input">
                </div>
            </div>·


            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
                </div>
            </div>
        </form>
    </div>
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
    <script type="text/javascript">

        layui.use(['layer', 'form', 'table'], function() {
            var layer = layui.layer, form = layui.form, table = layui.table;

            form.render();

            //监听提交
            form.on('submit(demo1)', function(data){
                // JSON.stringify 将js对象转为json格式的字符串
                // data.field 表单中提交的数据
//                    layer.alert(JSON.stringify(data.field), {
//                        title: '最终的提交信息'
//                    })

                $.ajax({
                    type:"post",
                    url:"speaker/add.do",
                    data:data.field,
                    dataType:"json",
                    success:function(data){  //{code:1,info:....}
                        if(data.code == 1){
                            var t = parent.layui.table;
                            t.reload('transferTable');// 重新加载页面,demo 表示父窗体table标签的id值
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index); //再执行关闭
                        }else{
                            alert(data.info);
                        }
                    }
                })




                // 阻止默认的提交
                return false;
            });
        });
    </script>
</body>
</html>
