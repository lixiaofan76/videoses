<%--
  Created by IntelliJ IDEA.
  User: 李晓帆
  Date: 2019/8/6
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>修改信息</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
    <script type="text/javascript" src="js/jquery-1.12.2.min.js"></script>
</head>
<body>
<form class="layui-form" action="" lay-filter="test">
    <div class="layui-form-item">
        <div class="layui-input-block">
            <input type="hidden" name="id" lay-verify="id" autocomplete="off"  class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">讲师姓名</label>
        <div class="layui-input-block">
            <input type="text" name="speakerName" lay-verify="speakerName" autocomplete="off"  class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">讲师简介</label>
        <div class="layui-input-block">
            <input type="text" name="speakerDesc" lay-verify="speakerDesc"  autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">讲师职务</label>
        <div class="layui-input-block">
            <input type="text" name="speakerJob" lay-verify="speakerJob"  autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">头像播放地址</label>
        <div class="layui-input-block">
            <input type="text" name="headImgUrl" lay-verify="headImgUrl"  autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo">立即提交</button>
        </div>
    </div>
</form>

<script type="text/javascript">
    var form = null;
    layui.use('form', function(){
        form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功

        //……

        //但是，如果你的HTML是动态生成的，自动渲染就会失效
        //因此你需要在相应的地方，执行下述方法来手动渲染，跟这类似的还有 element.init();
        //form.render();

        //自定义验证规则




        //监听提交
        form.on('submit(demo)', function(data){

            $.ajax({
                type:"post",
                url:"speaker/updateInfo.do?id=${param.id}",
                data:data.field,
                dataType:"json",
                success:function(data){
                    if(data.code == 1){
                        // parent.location.reload(); // 父页面刷新
                        //var t = parent.window.layui.table;
                        var t = parent.layui.table;// 上面写法也可以用
                        t.reload('transferTable');// 重新加载页面

                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭

                    } else {
                        alert(data.info);
                    }
                }
            });

            return false;
        });

        $.ajax({
            type:"get",
            url:"speaker/query.do?id=${param.id}",
            dataType:"json",
            success:function(data){
                if(data.code == 1){
                    form.val("test", data.info[0]);
                    form.render();
                }
            }
        })

    });

</script>
</body>
</html>
