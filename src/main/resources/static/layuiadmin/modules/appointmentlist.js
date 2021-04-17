/**

 @Name：layuiAdmin 内容系统
 @Author：star1029
 @Site：http://www.layui.com/admin/
 @License：LPPL
    
 */


layui.define(['table', 'form'], function(exports){
  var $ = layui.$
  ,table = layui.table
  ,form = layui.form;

  //文章管理
  table.render({
    elem: '#LAY-appointment-list'
    ,url: '/appointment/selectAppointmentList' //模拟接口
    ,cols: [[
      {type: 'numbers', fixed: 'left'}
      ,{field: 'user.name', width: '10%', title: '预约人姓名',templet:function (d) {
          return d.user.name
        }}
      ,{field: 'user.animal', width: '10%', title: '预约人宠物类型',templet:function (d) {
          return d.user.animal
        }}
      ,{field: 'user.animalName', width: '10%', title: '预约人宠物姓名',templet:function (d) {
          return d.user.animalName
        }}
      ,{field: 'appointmentTime', title: '预约时间', width: '10%'}
      ,{field: 'isSuccessful', title: '预约是否成功',width: '10%',templet:function (d) {
          if(d.isSuccessful == 1){
            return '是'
          }else if(d.isSuccessful == 0) {
            return '否'
          }
        }}
      ,{field: 'appointmentDetail', title: '预约详情',width: '32.6%'}
      ,{title: '操作', width: '15%', align: 'center', fixed: 'right', toolbar: '#table-content-list'}
    ]]
    ,page: false
    ,text: '对不起，加载出现异常！'
  });
  
  //监听工具条
  table.on('tool(LAY-appointment-list)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
      layer.confirm('真的删除么', function (index) {
        $.ajax({
          url: "/appointment/deleteAppointmentById?id=" + data.id,
          type: "get",
          async: false,
          success: function (data) {
            layer.msg("删除成功");
          },
          error: function (data) {
            layer.msg("删除失败");
          }
        });
        table.reload('LAY-appointment-list');
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.open({
        type: 2
        ,title: '编辑文章'
        ,content: '/appointment/updateAppointmentIndex?id='+ data.id
        ,maxmin: true
        ,area: ['550px', '550px']
        ,btn: ['确定', '取消']
        ,yes: function(index, layero){
          var iframeWindow = window['layui-layer-iframe'+ index]
          ,submit = layero.find('iframe').contents().find("#layuiadmin-appointment-edit");

          //监听提交
          iframeWindow.layui.form.on('submit(layuiadmin-appointment-edit)', function(data){
            var field = data.field; //获取提交的字段
            
            //提交 Ajax 成功后，静态更新表格中的数据
            //$.ajax({});

            $.ajax({
              type: "post",
              /*contentType: "application/json;charset=UTF-8",*/
              url: "/appointment/updateAppointment",
              data: field,
              async: false,
              success: function (data) {
                layer.msg("编辑成功");
              },
              error: function (e) {
                layer.msg("编辑失败");
              }
            })
            table.reload('LAY-appointment-list'); //数据刷新
            layer.close(index); //关闭弹层
          });  
          
          submit.trigger('click');
        }
      });
    }
  });


  exports('appointmentlist', {})
});