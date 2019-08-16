<%--
  Created by IntelliJ IDEA.
  User: 李晓帆
  Date: 2019/8/3
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">

    <script type="text/javascript" src="js/jquery-1.12.2.min.js" ></script>
    <script type="text/javascript" src="layui/layui.js"></script>

</head>
<body>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>添加视频信息</legend>
    </fieldset>
<div>
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">名称</label>
            <div class="layui-input-block">
                <input  type="text" name="title" lay-verify="title" autocomplete="off" placeholder="视频名称" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">教师姓名</label>
            <div  class="layui-input-block">
            <select id="s1" name="speakerId">
                <option value="">选择教师</option>
            </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">所属课程</label>
            <div  class="layui-input-block">
                <select id="s2" name="courseId" >
                    <option value="">选择课程</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">时长</label>
            <div class="layui-input-block">
                <input type="text" name="time" lay-verify="title" autocomplete="off" placeholder="请输入正整数" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">封面图片地址</label>
            <div class="layui-input-block">
                <input type="text" name="imageUrl" lay-verify="title" autocomplete="off" placeholder="具体的url" class="layui-input">
            </div>
        </div>·
        <div class="layui-form-item">
            <label class="layui-form-label">视频播放地址</label>
            <div class="layui-input-block">
                <input type="text" name="videoUrl" lay-verify="title" autocomplete="off" placeholder="具体的url" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <textarea  name="detail" placeholder="请输入内容" class="layui-textarea"></textarea>
            </div>
        </div>
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
                    url:"video/add.do",
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


        $(function () {
            $.ajax({
                type:"post",
                url:"speaker/list2.do",
                dataType:"json",
                success:function (data) {
                    if(data.code == 1){
                        var infos = data.info;
                        $(infos).each(function () {
                            var html = '<option value="'+this.id+'">' + this.speakerName+'</option>'
                            $('#s1').append($(html));
                        })
                    } else{
                        alert(data.info)
                    }
                }
            })
        })

        $(function () {
            $.ajax({
                type:"post",
                url:"course/list.do",
                dataType:"json",
                success:function (data) {
                    if(data.code == 1){
                        var infos = data.info;
                        $(infos).each(function () {
                            var html = '<option value="'+this.id+'">' + this.courseTitle+'</option>'
                            $('#s2').append($(html));
                        })
                    } else{
                        alert(data.info)
                    }
                }
            })
        })
    </script>
</body>
</html>
